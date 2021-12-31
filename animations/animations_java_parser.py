

class AnimationsJavaParser:

    enter = "\r\n"
    tab = "\t"

    @staticmethod
    def to_file(filename, package_name, model_name, animation_name, animation):
        with open("animations/animation_template.java", "r") as template_file:
            text = template_file.read()
        animations_array = []
        model_name = model_name[0].upper() + model_name[1:]
        animation_name = animation_name[0].upper() + animation_name[1:]
        for part_name, part_animation in animation.items():
            animations_array.append(f"List<KeyFrame> {part_name} = new ArrayList<KeyFrame>();")
            for time, key_frame_animation in part_animation.items():
                animations_array.append(f"{part_name}.add(new KeyFrame((int){time},"
                                        f" new EulerAngle(Math.toRadians({key_frame_animation.rx}),"
                                        f" Math.toRadians({key_frame_animation.ry}),"
                                        f" Math.toRadians({key_frame_animation.rz})),"
                                        f" new Offset({key_frame_animation.x},"
                                        f" {key_frame_animation.y},"
                                        f" {key_frame_animation.z})));")
            animations_array.append(f"this.partsAnimations.put(\"{part_name}\""
                                    f", new SequenceAnimation(new Sequence({part_name})));"
                                    f"{AnimationsJavaParser.enter}")
        animations = f"{AnimationsJavaParser.enter}{AnimationsJavaParser.tab * 2}".join(animations_array)
        text = text.replace("{PACKAGE_NAME}", package_name)
        text = text.replace("{MODEL_NAME}", model_name)
        text = text.replace("{ANIMATION_NAME}", animation_name)
        text = text.replace("{ANIMATIONS}", animations)
        with open(filename, "w") as output_file:
            output_file.write(text)
