import json

from model.block import Block

from anytree import Node, RenderTree

from model.parsed_model import ParsedModel


class Parser:

    @staticmethod
    def parse_file(filename):
        with open(filename) as json_model:
            json_model_data = json.load(json_model)
            elements = json_model_data["elements"]
            groups = json_model_data["groups"]
            textures = list(json_model_data["textures"].values())
            model = ParsedModel()
            model.set_texture(textures[0])
            blocks_index = {}
            for group in groups:
                model.add_groups_tree(Parser.create_groups_tree_of_group(group))
                blocks_index.update(Parser.create_groups_blocks(group))
            blocks = {}
            for group, group_blocks in blocks_index.items():
                blocks[group] = []
                for element_index in group_blocks:
                    blocks[group].append(Parser.parse_block(elements[element_index]
                                                            , json_model_data["texture_size"][0]))
            model.add_groups_blocks(blocks)
            return model

    @staticmethod
    def parse_block(block_element, texture_size):
        size = [axis_delta[0] - axis_delta[1] for axis_delta in zip(block_element["to"], block_element["from"])]
        offset = block_element["from"]
        if "rotation" in block_element:
            rotation = block_element["rotation"]
            rotation_axis = rotation["axis"]
            rotation_angle = rotation["angle"]
            rotation_origin = rotation["origin"]
        else:
            rotation_axis = "x"
            rotation_angle = 0
            rotation_origin = [0, 0, 0]
        faces = block_element["faces"]
        print(faces)
        faces = dict(map(lambda face: (face[0], (face[1]["uv"][:2], face[1]["uv"][2:])), faces.items()))
        return Block(size[0], size[1], size[2], offset[0], offset[1], offset[2], rotation_axis, rotation_angle,
                     rotation_origin[0], rotation_origin[1], rotation_origin[2], texture_size, faces)

    @staticmethod
    def create_groups_tree_of_group(group, parent=None):
        root = Node(group["name"], parent)
        for child in group["children"]:
            if type(child) is not int:
                Parser.create_groups_tree_of_group(child, root)
        return root

    @staticmethod
    def create_groups_blocks(group):
        groups_blocks = {group["name"]: []}
        for child in group["children"]:
            if type(child) is not int:
                groups_blocks.update(Parser.create_groups_blocks(child))
            else:
                groups_blocks[group["name"]].append(child)
        return groups_blocks
