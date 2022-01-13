
class JavaParser:

    enter = "\r\n"
    tab = "\t"

    @staticmethod
    def to_file(model, filename, model_id, plugin_id, package_name, main_group="body"):
        # print(list(model.dfs_root_first()))
        with open("model/model_template.java", "r") as template_file:
            text = template_file.read()
        model_name = "".join([name[0].upper() + name[1:] for name in model_id.split("_")])
        model_lines = []
        for group in model.dfs_root_first():
            model_lines.append(JavaParser._parse_group(group, model.groups_blocks[group.name]))
        model_lines.append("setSkeletonModel(new SkeletonModel(null, b" + main_group[0].upper() + main_group[1:] + "));")
        if model.animations is not None:
            model_lines.extend(JavaParser._parse_animations(model_name, model.animations.keys()))
        model_lines = ((JavaParser.enter + JavaParser.tab * 2) * 2).join(model_lines) + \
                        JavaParser.enter * 2 + JavaParser.tab
        text = text.replace("{PACKAGE_NAME}", package_name)
        text = text.replace("{PLUGIN_ID}", plugin_id)
        text = text.replace("{MODEL_ID}", model_id)
        text = text.replace("{MODEL_NAME}", model_name)
        text = text.replace("{TEXTURE_NAME}", model.texture_name)
        text = text.replace("{MODEL_LINES}", model_lines)
        with open(filename, "w") as java_model_file:
            java_model_file.write(text)

    @staticmethod
    def _parse_group(group, blocks):
        output = "EntityModelPart " + group.name + " = createPart(\"" + group.name + "\", DamageableItem.DIAMOND_HOE);"
        for block in blocks:
            output += JavaParser.enter + JavaParser.tab * 2 + group.name + ".addBox(" + JavaParser._parse_block(block) \
                      + ");"
        output += f"{JavaParser.enter + JavaParser.tab * 2}addPart(new Part({group.name}, new Offset(0, 0, 0)" \
                  f", new EulerAngle(0, 0, 0)));"
        output += JavaParser.enter + JavaParser.tab * 2 + "Bone b" + group.name[0].upper() + group.name[1:] \
                  + " = new Bone(" + group.name \
                                   + ");"
        if group.parent.name is not None:
            output += JavaParser.enter + JavaParser.tab * 2 + "b" + group.parent.name[0].upper() + group.parent.name[1:] \
                                       + ".addChild(b" + group.name[0].upper() + group.name[1:] + ");"
        return output

    @staticmethod
    def _parse_block(block):
        return str(block.x) + ", " + str(block.y) + ", " + str(block.z) + ", " + \
               str(block.ox) + ", " + str(block.oy) + ", " + str(block.oz) + ", " + \
               "ModelAxis." + str(block.axis) + ", " + str(block.angle) + ", " + \
               str(block.rx) + ", " + str(block.ry) + ", " + str(block.rz) + ", " + \
               str(int(block.t)) + ", " + str(int(block.get_tx())) + ", " + str(int(block.get_ty())) + ", " + \
               str(block.bx) + ", " + str(block.by) + ", " + str(block.bz)

    @staticmethod
    def _parse_animations(model_name, animations_names):
        output = ["AnimationMap animations = new AnimationMap();"]
        for animation_name in animations_names:
            output.append(f"animations.addNode(\"{animation_name}\""
                          f", new {model_name}Animation{animation_name[0].upper()}{animation_name[1:]}());")
        output.append("setAnimationMap(animations);")
        return output
