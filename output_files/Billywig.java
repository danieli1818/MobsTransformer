package dracciomobs.models.billywig;

import org.bukkit.util.EulerAngle;

import com.ticxo.modelapi.api.additions.EntityModelPart;
import com.ticxo.modelapi.api.animation.AnimationMap;
import com.ticxo.modelapi.api.modeling.Bone;
import com.ticxo.modelapi.api.modeling.ModelBase;
import com.ticxo.modelapi.api.modeling.Offset;
import com.ticxo.modelapi.api.modeling.Part;
import com.ticxo.modelapi.api.modeling.SkeletonModel;

import dracciomobs.models.billywig.animations.BillywigAnimationIdle;
import us.fihgu.toolbox.item.DamageableItem;
import us.fihgu.toolbox.resourcepack.model.ModelAxis;

public class Billywig extends ModelBase {

	public Billywig() {
		super("dr_accio_mobs:billywig", "billywig");

		EntityModelPart head = createPart("head", DamageableItem.DIAMOND_HOE);
		head.addBox(4, 4, 4.1, -2, 18, -2.1, ModelAxis.x, 0, 0, 0, 0, 128, 0, 0, 16, 16, 16);
		head.addBox(2, 2.25, 1.1, -1, 17, -2.6, ModelAxis.x, 0, 0, 0, 0, 128, 64, 43, 8, 9, 4);
		head.addBox(1.0, 0.75, 0.0, -0.5, 16.25, -2.5, ModelAxis.x, 0, 0, 0, 0, 128, 68, 107, 4, 3, 0);
		head.addBox(1.5, 1.5, 2.0, 1.25, 20.25, -2.25, ModelAxis.x, 0, 0, 0, 0, 128, 64, 15, 6, 6, 8);
		head.addBox(1.5, 1.5, 2.0, -2.75, 20.25, -2.25, ModelAxis.x, 0, 0, 0, 0, 128, 64, 29, 6, 6, 8);
		head.addBox(1.85, 1.1500000000000021, 2.6, -0.95, 22.01221, -1.24109, ModelAxis.y, 0, -5.025, 13.51221, 1.18391, 128, 64, 0, 7, 5, 10);
		head.addBox(3.85, 0.0, 0.6000000000000001, -0.075, 22.61221, -0.99109, ModelAxis.y, 0, 0, 22.61221, -0.69109, 128, 0, 104, 15, 0, 2);
		head.addBox(3.85, 0.0, 0.6000000000000001, -3.775, 22.61221, -0.99109, ModelAxis.y, 0, 0, 22.61221, -0.69109, 128, 0, 106, 15, 0, 2);
		head.addBox(3.85, 0.0, 0.6, -0.075, 22.61221, 0.00891, ModelAxis.y, 0, 0, 22.51221, 0.18391, 128, 0, 108, 15, 0, 2);
		head.addBox(3.85, 0.0, 0.6, -3.775, 22.61221, 0.00891, ModelAxis.y, 0, 0, 22.51221, 0.18391, 128, 34, 104, 15, 0, 2);
		head.addBox(3.85, 0.0, 0.6, -0.075, 22.61221, 0.70891, ModelAxis.y, 0, 0, 22.51221, 0.93391, 128, 34, 106, 15, 0, 2);
		head.addBox(3.85, 0.0, 0.6, -3.775, 22.61221, 0.70891, ModelAxis.y, 0, 0, 22.51221, 0.93391, 128, 34, 108, 15, 0, 2);
		addPart(new Part(head, new Offset(0, 0, 0), new EulerAngle(0, 0, 0)));
		Bone bHead = new Bone(head);
		
		EntityModelPart body = createPart("body", DamageableItem.DIAMOND_HOE);
		body.addBox(3.0, 0.75, 2.0, -1.5, 17.25, -0.5, ModelAxis.x, 0, 0, 0, 0, 128, 56, 62, 12, 3, 8);
		body.addBox(3.5, 0.75, 2.5, -1.75, 16.5, -0.75, ModelAxis.x, 0, 0, 0, 0, 128, 0, 91, 14, 3, 10);
		body.addBox(4, 0.75, 3, -2, 15.75, -1, ModelAxis.x, 0, 0, 0, 0, 128, 0, 62, 16, 3, 12);
		body.addBox(4.5, 4.0, 3.5, -2.25, 11.75, -1.25, ModelAxis.x, 0, 0, 0, 0, 128, 0, 32, 18, 16, 14);
		body.addBox(4, 0.5, 3, -2, 11.25, -1, ModelAxis.x, 0, 0, 0, 0, 128, 0, 77, 16, 2, 12);
		body.addBox(3.5, 0.5, 2.5, -1.75, 10.75, -0.75, ModelAxis.x, 0, 0, 0, 0, 128, 48, 91, 14, 2, 10);
		body.addBox(3.0, 0.5, 2.0, -1.5, 10.25, -0.5, ModelAxis.x, 0, 0, 0, 0, 128, 56, 73, 12, 2, 8);
		body.addBox(2.5, 0.5, 1.5, -1.25, 9.75, -0.25, ModelAxis.x, 0, 0, 0, 0, 128, 56, 83, 10, 2, 6);
		body.addBox(2, 0.5, 1, -1, 9.25, 0, ModelAxis.x, 0, 0, 0, 0, 128, 64, 56, 8, 2, 4);
		body.addBox(0.5, 0.5, 0.5, -0.25, 8.75, 0.25, ModelAxis.x, 0, 0, 0, 0, 128, 68, 103, 2, 2, 2);
		addPart(new Part(body, new Offset(0, 0, 0), new EulerAngle(0, 0, 0)));
		Bone bBody = new Bone(body);
		
		EntityModelPart sting = createPart("sting", DamageableItem.DIAMOND_HOE);
		sting.addBox(0.1, 2.0, 0.10000000000000003, -0.05, 6.75, 0.45, ModelAxis.x, 0, 0, 0, 0, 128, 96, 92, 1, 8, 1);
		sting.addBox(0.1, 0.75, 0.10000000000000003, -0.05, 6, 0.45, ModelAxis.x, 0, 0, 0, 0, 128, 92, 83, 1, 3, 1);
		sting.addBox(0.1, 0.75, 0.10000000000000003, -0.05, 5.25, 0.45, ModelAxis.x, 0, 0, 0, 0, 128, 92, 87, 1, 3, 1);
		sting.addBox(0.1, 0.75, 0.10000000000000003, -0.05, 4.5, 0.45, ModelAxis.x, 0, 0, 0, 0, 128, 92, 103, 1, 3, 1);
		sting.addBox(0.1, 0.75, 0.10000000000000003, -0.05, 3.75, 0.45, ModelAxis.x, 0, 0, 0, 0, 128, 96, 101, 1, 3, 1);
		sting.addBox(0.1, 0.75, 0.10000000000000003, -0.05, 3, 0.45, ModelAxis.x, 0, 0, 0, 0, 128, 96, 105, 1, 3, 1);
		addPart(new Part(sting, new Offset(0, 0, 0), new EulerAngle(0, 0, 0)));
		Bone bSting = new Bone(sting);
		bBody.addChild(bSting);
		
		EntityModelPart top_legs = createPart("top_legs", DamageableItem.DIAMOND_HOE);
		top_legs.addBox(0.3500000000000001, 2.4000000000000004, 0.34999999999999987, 1.85, 13.1, -1.65, ModelAxis.x, 22.5, 2.125, 14.8, -1.375, 128, 88, 43, 1, 10, 1);
		top_legs.addBox(0.3500000000000001, 1.4000000000000004, 0.3500000000000001, 1.25, 11.12959, -2.42386, ModelAxis.y, 0, 2.025, 12.82959, -2.34886, 128, 76, 103, 1, 6, 1);
		top_legs.addBox(0.3500000000000001, 2.4000000000000004, 0.3500000000000001, 0.95, 11.92959, -2.62386, ModelAxis.x, 22.5, 1.125, 13.62959, -2.24886, 128, 92, 15, 1, 10, 1);
		top_legs.addBox(0.3500000000000001, 2.4000000000000004, 0.3500000000000001, -1.3, 11.92959, -2.62386, ModelAxis.x, 22.5, -1.125, 13.62959, -2.24886, 128, 92, 26, 1, 10, 1);
		top_legs.addBox(0.3500000000000001, 1.4000000000000004, 0.3500000000000001, -1.6, 11.12959, -2.42386, ModelAxis.y, 0, -2.025, 12.82959, -2.34886, 128, 80, 103, 1, 6, 1);
		top_legs.addBox(0.3500000000000001, 2.4000000000000004, 0.34999999999999987, -2.2, 13.1, -1.65, ModelAxis.x, 22.5, -2.125, 14.8, -1.375, 128, 92, 37, 1, 10, 1);
		addPart(new Part(top_legs, new Offset(0, 0, 0), new EulerAngle(0, 0, 0)));
		Bone bTop_legs = new Bone(top_legs);
		bBody.addChild(bTop_legs);
		
		EntityModelPart middle_legs = createPart("middle_legs", DamageableItem.DIAMOND_HOE);
		middle_legs.addBox(0.3500000000000001, 2.3999999999999995, 0.3500000000000001, 1.45, 7.94349, -1.93128, ModelAxis.x, -22.5, 1.625, 9.14349, -1.75628, 128, 92, 48, 1, 10, 1);
		middle_legs.addBox(0.3500000000000001, 1.4000000000000004, 0.3500000000000001, 1.64371, 10.04346, -2.42386, ModelAxis.y, 0, 1.56871, 10.74346, -2.24886, 128, 84, 103, 1, 6, 1);
		middle_legs.addBox(0.3500000000000001, 2.4000000000000004, 0.34999999999999987, 1.85, 10.85, -1.65, ModelAxis.x, 22.5, 2.125, 12.55, -1.375, 128, 96, 15, 1, 10, 1);
		middle_legs.addBox(0.3500000000000001, 2.3999999999999995, 0.3500000000000001, -1.8, 7.94349, -1.93128, ModelAxis.x, -22.5, -1.625, 9.14349, -1.75628, 128, 96, 26, 1, 10, 1);
		middle_legs.addBox(0.3500000000000001, 1.4000000000000004, 0.3500000000000001, -1.99371, 10.04346, -2.42386, ModelAxis.y, 0, -1.56871, 10.74346, -2.24886, 128, 88, 54, 1, 6, 1);
		middle_legs.addBox(0.3500000000000001, 2.4000000000000004, 0.34999999999999987, -2.2, 10.85, -1.65, ModelAxis.x, 22.5, -2.125, 12.55, -1.375, 128, 96, 37, 1, 10, 1);
		addPart(new Part(middle_legs, new Offset(0, 0, 0), new EulerAngle(0, 0, 0)));
		Bone bMiddle_legs = new Bone(middle_legs);
		bBody.addChild(bMiddle_legs);
		
		EntityModelPart bottom_legs = createPart("bottom_legs", DamageableItem.DIAMOND_HOE);
		bottom_legs.addBox(0.3500000000000001, 2.3999999999999995, 0.35, 1.45, 6.74349, -0.63128, ModelAxis.x, -22.5, 1.625, 7.94349, -0.45628, 128, 96, 48, 1, 10, 1);
		bottom_legs.addBox(0.3500000000000001, 1.4000000000000004, 0.3500000000000001, 1.64371, 8.84346, -1.12386, ModelAxis.y, 0, 1.56871, 9.54346, -0.94886, 128, 88, 83, 1, 6, 1);
		bottom_legs.addBox(0.3500000000000001, 2.4000000000000004, 0.35, 1.85, 9.65, -0.35, ModelAxis.x, 22.5, 2.125, 11.35, -0.075, 128, 96, 59, 1, 10, 1);
		bottom_legs.addBox(0.3500000000000001, 2.3999999999999995, 0.35, -1.8, 6.74349, -0.63128, ModelAxis.x, -22.5, -1.625, 7.94349, -0.45628, 128, 96, 70, 1, 10, 1);
		bottom_legs.addBox(0.3500000000000001, 1.4000000000000004, 0.3500000000000001, -1.99371, 8.84346, -1.12386, ModelAxis.y, 0, -1.56871, 9.54346, -0.94886, 128, 88, 103, 1, 6, 1);
		bottom_legs.addBox(0.3500000000000001, 2.4000000000000004, 0.35, -2.2, 9.65, -0.35, ModelAxis.x, 22.5, -2.125, 11.35, -0.075, 128, 96, 81, 1, 10, 1);
		addPart(new Part(bottom_legs, new Offset(0, 0, 0), new EulerAngle(0, 0, 0)));
		Bone bBottom_legs = new Bone(bottom_legs);
		bBody.addChild(bBottom_legs);
		
		setSkeletonModel(new SkeletonModel(null, bBody));
		
		AnimationMap animations = new AnimationMap();
		
		animations.addNode("idle", new BillywigAnimationIdle());
		
		setAnimationMap(animations);

	

	}
}