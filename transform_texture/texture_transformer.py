import copy

from common.image_utils import open_image, crop_image, create_empty_image, paste_image, save_image
from model.block import Block
from model.parsed_model import ParsedModel
from transform_texture.rectangle_packing.implementations.rpack_rectangle_packer import RPackRectanglePacker
from transform_texture.rectangle_packing.rectangle_packer import RectanglePacker


class TextureTransformer:

    def __init__(self, rectangle_packer: RectanglePacker):
        self.rectangle_packer = rectangle_packer

    def transform_texture(self, model: ParsedModel, texture_image_input_file_path, texture_image_output_file_path):
        # create tmp folder.
        groups_blocks = {}
        blocks_textures = {}
        for group, blocks in model.get_groups_blocks().items():
            groups_blocks[group] = []
            for block in blocks:
                texture, transformed_block = TextureTransformer.transform_block(block, texture_image_input_file_path)
                blocks_textures[transformed_block] = texture
                groups_blocks[group].append(transformed_block)
        blocks = [block for group_blocks in groups_blocks.values() for block in group_blocks]
        texture = self._pack_blocks(blocks, blocks_textures)
        model.groups_blocks = groups_blocks
        save_image(texture, texture_image_output_file_path)

    @staticmethod
    def transform_block(block: Block, texture_image_input_file_path: str):
        texture, size = TextureTransformer.make_block_texture(block, texture_image_input_file_path)
        transformed_block = copy.deepcopy(block)
        transformed_block.bx, transformed_block.by, transformed_block.bz = size
        return texture, transformed_block
        # copy_block = copy.copy(block)
        # deep_copy_block = copy.deepcopy(block)
        # print("original x:", block.x)
        # print("original east face:", block.faces["east"])
        # block.x = 10
        # block.faces["east"] = 10
        # print("original x:", block.x)
        # print("original east face:", block.faces["east"])
        # print("copy block x:", copy_block.x)
        # print("copy block east face:", copy_block.faces["east"])
        # print("deep copy block x:", deep_copy_block.x)
        # print("deep copy block east face:", deep_copy_block.faces["east"])

    @staticmethod
    def make_block_texture(block, texture_image_input_file_path):
        image = open_image(texture_image_input_file_path)
        faces_images = {}
        for face_name, face_uv in block.get_faces().items():
            faces_images[face_name] = crop_image(image, face_uv[0], face_uv[1])
            print(face_name)
            print(face_uv)
            print(faces_images[face_name].size)
            # if all(faces_images[face_name].size):
            # faces_images[face_name].show()
        # TODO check if the sizes of x, y, z are equal for all the textures.
        x = faces_images["up"].size[0]
        y = faces_images["east"].size[1]
        z = faces_images["up"].size[1]
        texture_size = (z * 2 + x * 2,
                        z + y)
        texture = create_empty_image(texture_size)
        texture.paste(faces_images["east"], (0, z))
        texture.paste(faces_images["up"], (z, 0))
        texture.paste(faces_images["down"], (z + x, 0))
        texture.paste(faces_images["north"], (z, z))
        texture.paste(faces_images["west"], (z + x, z))
        texture.paste(faces_images["south"], (2 * z + x, z))
        # texture.show()
        return texture, [x, y, z]

    @staticmethod
    def _create_combined_texture(blocks: list, positions: list, textures: list, texture_size: int):
        texture = create_empty_image((texture_size, texture_size))
        for block, block_texture, position in zip(blocks, textures, positions):
            paste_image(block_texture, texture, position)
        texture.show()
        return texture

    def _pack_blocks(self, blocks, textures):
        positions, texture_size = self.rectangle_packer.pack(
            [textures[block].size for block in blocks])
        texture = TextureTransformer._create_combined_texture(blocks, positions,
                                                              [textures[block] for block in blocks], texture_size)
        for block, position in zip(blocks, positions):
            block.set_texture(position[0], position[1], texture_size)
        return texture
