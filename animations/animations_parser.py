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
                    if isinstance(json_key_frames["rotation"], dict):
                        AnimationsParser._parse_rotation_keyframes_dict(json_key_frames["rotation"], key_frames_of_part)
                    elif isinstance(json_key_frames["rotation"], list):
                        AnimationsParser._parse_rotation_keyframes_list(json_key_frames["rotation"], key_frames_of_part)
                    else:
                        raise Exception(f"Invalid animations file: \"{filename}\", rotations error!")
                    if isinstance(json_key_frames["position"], dict):
                        AnimationsParser._parse_position_keyframes_dict(json_key_frames["position"], key_frames_of_part)
                    elif isinstance(json_key_frames["position"], list):
                        AnimationsParser._parse_position_keyframes_list(json_key_frames["position"], key_frames_of_part)
                    else:
                        raise Exception(f"Invalid animations file: \"{filename}\"!, positions error!")
                    key_frames_per_part[part_name] = key_frames_of_part
                animations[name.split(".")[-1]] = key_frames_per_part
            return animations

    @staticmethod
    def _parse_rotation_keyframes_dict(rotation_key_frames: dict, key_frames_of_part: dict):
        for time, rotation in rotation_key_frames.items():
            key_frames_of_part[time] = KeyFrame(rx=rotation[0], ry=rotation[1], rz=rotation[2])

    @staticmethod
    def _parse_rotation_keyframes_list(rotation_key_frames: list, key_frames_of_part: dict):
        key_frames_of_part[0] = KeyFrame(rx=rotation_key_frames[0], ry=rotation_key_frames[1], rz=rotation_key_frames[2])

    @staticmethod
    def _parse_position_keyframes_dict(position_key_frames: dict, key_frames_of_part: dict):
        for time, position in position_key_frames.items():
            if key_frames_of_part[time] is None:
                key_frames_of_part[time] = KeyFrame(x=position.x, y=position.y, z=position.z)
            else:
                key_frames_of_part[time].x = position[0]
                key_frames_of_part[time].y = position[1]
                key_frames_of_part[time].z = position[2]

    @staticmethod
    def _parse_position_keyframes_list(position_key_frames: list, key_frames_of_part: dict):
        key_frames_of_part[0] = KeyFrame(x=position_key_frames[0], y=position_key_frames[1], z=position_key_frames[2])



