import json

from animations.key_frame import KeyFrame


class AnimationsParser:

    @staticmethod
    def parse_file(filename):
        with open(filename) as json_model:
            json_animations_data = json.load(json_model)
            json_animations = json_animations_data["animations"]
            animations = {}
            for name, animation in json_animations.items():
                key_frames_per_part = {}
                for part_name, json_key_frames in animation["bones"].items():
                    key_frames_of_part = {}
                    for time, rotation in json_key_frames["rotation"].items():
                        key_frames_of_part[time] = KeyFrame(rx=rotation[0], ry=rotation[1], rz=rotation[2])
                    for time, position in json_key_frames["position"].items():
                        if key_frames_of_part[time] is None:
                            key_frames_of_part[time] = KeyFrame(x=position.x, y=position.y, z=position.z)
                        else:
                            key_frames_of_part[time].x = position[0]
                            key_frames_of_part[time].y = position[1]
                            key_frames_of_part[time].z = position[2]
                    key_frames_per_part[part_name] = key_frames_of_part
                animations[name.split(".")[-1]] = key_frames_per_part
            return animations


