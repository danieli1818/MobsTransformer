package me.danieli1818.dr_accio_mobs.models.model;

import com.ticxo.modelapi.api.modeling.ModelBase;

public class Model extends ModelBase {

	public Model() {
		super("dr_accio_mobs:model", "texture");
		
		EntityModelPart part = createPart("part", DamageableItem.DIAMOND_HOE);
		part.addBox(5, 5, 5, -5, -2, 3, ModelAxis.z, -22.5, 0, 0, 0, 32, 10, 5.0);
		Bone bPart = new Bone(part);
		
		EntityModelPart part_inside_part = createPart("part_inside_part", DamageableItem.DIAMOND_HOE);
		part_inside_part.addBox(1, 1, 1, 0, 0, 0, ModelAxis.x, 0, 0, 0, 0, 32, 0, 10);
		part_inside_part.addBox(1, 1, 1, 0, 0, 1, ModelAxis.y, 0, 0.5, 0.5, 1.5, 32, 0, 2);
		Bone bPart_inside_part = new Bone(part_inside_part);
		bPart.addChild(bPart_inside_part);
		
		EntityModelPart bone = createPart("bone", DamageableItem.DIAMOND_HOE);
		bone.addBox(1, 1, 1, 0, 0, 2, ModelAxis.z, 45, 1, 1, 1, 32, 0, 0);
		Bone bBone = new Bone(bone);
		
		setSkeletonModel(new SkeletonModel(null, bBody));

	}
}