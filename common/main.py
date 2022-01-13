import os.path

from model.parser import Parser

from model.java_parser import JavaParser

from animations.animations_parser import AnimationsParser

from animations.animations_java_parser import AnimationsJavaParser

from error import print_error

import sys

# This is a sample Python script.

# Press Shift+F10 to execute it or replace it with your code.
# Press Double Shift to search everywhere for classes, files, tool windows, actions, and settings.
from transform_texture.rectangle_packing.implementations.rpack_rectangle_packer import RPackRectanglePacker
from transform_texture.texture_transformer import TextureTransformer


def print_hi(name):
    # Use a breakpoint in the code line below to debug your script.
    print(f'Hi, {name}')  # Press Ctrl+F8 to toggle the breakpoint.


def process_model(model_filename, model_animations_filename, texture_file_path):
    model = Parser.parse_file(model_filename)
    animations = AnimationsParser.parse_file(model_animations_filename)
    model.set_animations(animations)
    model_name = os.path.splitext(model_filename)[0].split(os.sep)[-1]
    package_name = f"dracciomobs.models.{model_name}"
    for animation_name, animation_object in animations.items():
        AnimationsJavaParser.to_file(
            f"output_files{os.sep}{model_name[0].upper()}{model_name[1:]}Animation{animation_name[0].upper()}"
            f"{animation_name[1:]}.java", package_name, model_name, animation_name, animation_object)
    TextureTransformer(RPackRectanglePacker()).transform_texture(model, texture_file_path
                                         , f"output_files{os.sep}{texture_file_path.split(os.sep)[-1]}")
    JavaParser.to_file(model, f"output_files{os.sep}{model_name[0].upper()}{model_name[1:]}.java", model_name
                       , "dr_accio_mobs", package_name)


# Press the green button in the gutter to run the script.
if __name__ == '__main__':
    print_hi('PyCharm')
    arguments = sys.argv
    if len(sys.argv) < 4:
        print_error("Not enough arguments!")
    else:
        model_filename = arguments[1]
        model_animations_filename = arguments[2]
        model_texture_filename = arguments[3]
        print(f"Arguments: {arguments}")
        process_model(model_filename, model_animations_filename, model_texture_filename)

# See PyCharm help at https://www.jetbrains.com/help/pycharm/
