import rpack
from rpack import PackingImpossibleError

from transform_texture.rectangle_packing.rectangle_packer import RectanglePacker


class RPackRectanglePacker(RectanglePacker):

    def pack(self, rectangles: list):
        for size in [16, 32, 64, 128, 256, 512, 1024]:
            try:
                positions = rpack.pack(rectangles, size, size)
            except PackingImpossibleError:
                continue
            return positions, size


