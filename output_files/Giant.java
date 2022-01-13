package dracciomobs.models.giant;

import org.bukkit.util.EulerAngle;

import com.ticxo.modelapi.api.additions.EntityModelPart;
import com.ticxo.modelapi.api.animation.AnimationMap;
import com.ticxo.modelapi.api.modeling.Bone;
import com.ticxo.modelapi.api.modeling.ModelBase;
import com.ticxo.modelapi.api.modeling.Offset;
import com.ticxo.modelapi.api.modeling.Part;
import com.ticxo.modelapi.api.modeling.SkeletonModel;

import dracciomobs.models.giant.animations.GiantAnimationIdle;
import us.fihgu.toolbox.item.DamageableItem;
import us.fihgu.toolbox.resourcepack.model.ModelAxis;

public class Giant extends ModelBase {

	public Giant() {
		super("dr_accio_mobs:giant", "giant");

		EntityModelPart group = createPart("group", DamageableItem.DIAMOND_HOE);
		addPart(new Part(group, new Offset(0, 0, 0), new EulerAngle(0, 0, 0)));
		Bone bGroup = new Bone(group);
		
		EntityModelPart hands = createPart("hands", DamageableItem.DIAMOND_HOE);
		hands.addBox(4.5, 4, 5.5, -3.75, -7, 8.25, ModelAxis.x, 0, 0, 0, 0, 128, 0, 14);
		hands.addBox(4.5, 4, 5.5, 15.25, -7, 8.25, ModelAxis.x, 0, 0, 0, 0, 128, 13, 12);
		addPart(new Part(hands, new Offset(0, 0, 0), new EulerAngle(0, 0, 0)));
		Bone bHands = new Bone(hands);
		bGroup.addChild(bHands);
		
		EntityModelPart arms = createPart("arms", DamageableItem.DIAMOND_HOE);
		arms.addBox(5, 5, 6, -4, 11, 8, ModelAxis.x, 0, 0, 0, 0, 128, 10, 0);
		arms.addBox(5, 5, 6, 15, 11, 8, ModelAxis.x, 0, 0, 0, 0, 128, 0, 10);
		arms.addBox(4.25, 8, 5.25, -3.65, 3, 8.4, ModelAxis.x, 0, 0, 0, 0, 128, 13, 5);
		arms.addBox(4.250000000000002, 8, 5.25, 15.35, 3, 8.4, ModelAxis.x, 0, 0, 0, 0, 128, 4, 12);
		arms.addBox(4.0, 6, 5.0, -3.5, -3, 8.5, ModelAxis.x, 0, 0, 0, 0, 128, 13, 9);
		arms.addBox(4.0, 6, 5.0, 15.5, -3, 8.5, ModelAxis.x, 0, 0, 0, 0, 128, 8, 13);
		addPart(new Part(arms, new Offset(0, 0, 0), new EulerAngle(0, 0, 0)));
		Bone bArms = new Bone(arms);
		bGroup.addChild(bArms);
		
		EntityModelPart head = createPart("head", DamageableItem.DIAMOND_HOE);
		head.addBox(7.0, 7, 7.0, 4.5, 18, 7.5, ModelAxis.x, 0, 0, 0, 0, 128, 0, 6);
		head.addBox(5.0, 1, 5.0, 5.5, 17, 8.5, ModelAxis.x, 0, 0, 0, 0, 128, 14, 0);
		addPart(new Part(head, new Offset(0, 0, 0), new EulerAngle(0, 0, 0)));
		Bone bHead = new Bone(head);
		bGroup.addChild(bHead);
		
		EntityModelPart body = createPart("body", DamageableItem.DIAMOND_HOE);
		body.addBox(14, 19, 7.0, 1, -2, 7.5, ModelAxis.x, 0, 0, 0, 0, 128, 0, 0);
		addPart(new Part(body, new Offset(0, 0, 0), new EulerAngle(0, 0, 0)));
		Bone bBody = new Bone(body);
		bGroup.addChild(bBody);
		
		EntityModelPart legs = createPart("legs", DamageableItem.DIAMOND_HOE);
		legs.addBox(4.550000000000001, 4.75, 4.35, 9.35, -13.9, 8.75, ModelAxis.x, 0, 0, 0, 0, 128, 15, 1);
		legs.addBox(4.550000000000001, 5.0, 4.35, 2.1, -14.15, 8.75, ModelAxis.x, 0, 0, 0, 0, 128, 13, 14);
		legs.addBox(5.550000000000001, 7.25, 5.35, 1.6, -9.15, 8.25, ModelAxis.x, 0, 0, 0, 0, 128, 10, 10);
		legs.addBox(5.550000000000001, 7.25, 5.35, 8.85, -9.15, 8.25, ModelAxis.x, 0, 0, 0, 0, 128, 10, 2);
		addPart(new Part(legs, new Offset(0, 0, 0), new EulerAngle(0, 0, 0)));
		Bone bLegs = new Bone(legs);
		bGroup.addChild(bLegs);
		
		EntityModelPart toes = createPart("toes", DamageableItem.DIAMOND_HOE);
		toes.addBox(4.75, 0.8000000000000007, 0.75, 9.25, -16, 3.25, ModelAxis.x, 0, 0, 0, 0, 128, 0, 0);
		toes.addBox(4.75, 0.8000000000000007, 0.75, 2, -16, 3.25, ModelAxis.x, 0, 0, 0, 0, 128, 0, 0);
		addPart(new Part(toes, new Offset(0, 0, 0), new EulerAngle(0, 0, 0)));
		Bone bToes = new Bone(toes);
		bGroup.addChild(bToes);
		
		EntityModelPart feet = createPart("feet", DamageableItem.DIAMOND_HOE);
		feet.addBox(4.75, 2.0999999999999996, 9.25, 9.25, -16, 4, ModelAxis.x, 0, 0, 0, 0, 128, 4, 9);
		feet.addBox(4.75, 2.0999999999999996, 9.25, 2, -16, 4, ModelAxis.x, 0, 0, 0, 0, 128, 7, 6);
		addPart(new Part(feet, new Offset(0, 0, 0), new EulerAngle(0, 0, 0)));
		Bone bFeet = new Bone(feet);
		bGroup.addChild(bFeet);
		
		setSkeletonModel(new SkeletonModel(null, bBody));
		
		AnimationMap animations = new AnimationMap();
		
		animations.addNode("idle", new GiantAnimationIdle());
		
		setAnimationMap(animations);

	

	}
}