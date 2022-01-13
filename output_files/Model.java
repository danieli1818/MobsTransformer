package dracciomobs.models.model;

import com.ticxo.modelapi.api.additions.EntityModelPart;
import com.ticxo.modelapi.api.animation.AnimationMap;
import com.ticxo.modelapi.api.modeling.Bone;
import com.ticxo.modelapi.api.modeling.ModelBase;
import com.ticxo.modelapi.api.modeling.SkeletonModel;

import dracciomobs.models.model.animations.ModelAnimationIdle;
import us.fihgu.toolbox.item.DamageableItem;
import us.fihgu.toolbox.resourcepack.model.ModelAxis;

public class Model extends ModelBase {

	public Model() {
		super("dr_accio_mobs:model", "texture");

		EntityModelPart part = createPart("part", DamageableItem.DIAMOND_HOE);
		part.addBox(5, 5, 5, -5, -2, 3, ModelAxis.z, -22.5, 0, 0, 0, 32, 10, 5);
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
		
		AnimationMap animations = new AnimationMap();
		
		animations.addNode("idle", new ModelAnimationIdle());
		
		setAnimationMap(animations);

	

	}
}