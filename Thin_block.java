package dracciomobs.models.thin_block;

import org.bukkit.util.EulerAngle;

import com.ticxo.modelapi.api.additions.EntityModelPart;
import com.ticxo.modelapi.api.animation.AnimationMap;
import com.ticxo.modelapi.api.modeling.Bone;
import com.ticxo.modelapi.api.modeling.ModelBase;
import com.ticxo.modelapi.api.modeling.Offset;
import com.ticxo.modelapi.api.modeling.Part;
import com.ticxo.modelapi.api.modeling.SkeletonModel;

import dracciomobs.models.thin_block.animations.ThinBlockAnimationIdle;
import us.fihgu.toolbox.item.DamageableItem;
import us.fihgu.toolbox.resourcepack.model.ModelAxis;

public class ThinBlock extends ModelBase {

	public ThinBlock() {
		super("dr_accio_mobs:thin_block", "block/thin_block");

		EntityModelPart body = createPart("body", DamageableItem.DIAMOND_HOE);
		body.addBox(0.25, 0.25, 1, 0.25, 0, 3, ModelAxis.x, 0, 0, 0, 0, 16, 0, 2);
		body.addBox(1, 0, 2, 0, 0, 0, ModelAxis.x, 0, 0, 0, 0, 16, 0, 0);
		body.addBox(1, 0.25, 1, 0, 0, 2, ModelAxis.x, 0, 0, 0, 0, 16, 0, 2);
		addPart(new Part(body, new Offset(0, 0, 0), new EulerAngle(0, 0, 0)));
		Bone bBody = new Bone(body);
		
		setSkeletonModel(new SkeletonModel(null, bBody));
		
		AnimationMap animations = new AnimationMap();
		
		animations.addNode("idle", new ThinBlockAnimationIdle());
		
		setAnimationMap(animations);

	

	}
}