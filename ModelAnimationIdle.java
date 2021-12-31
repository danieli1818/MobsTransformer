package dracciomobs.models.model.animations;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.util.EulerAngle;

import com.ticxo.modelapi.api.animation.Animation;
import com.ticxo.modelapi.api.animation.preset.KeyFrame;
import com.ticxo.modelapi.api.animation.preset.Sequence;
import com.ticxo.modelapi.api.animation.preset.SequenceAnimation;
import com.ticxo.modelapi.api.modeling.Offset;
import com.ticxo.modelapi.api.modeling.Part;

public class ModelAnimationIdle implements Animation {

    private Map<String, Animation> partsAnimations;

    public ModelAnimationIdle() {
        this.partsAnimations = new HashMap<String, Animation>();

        List<KeyFrame> part_inside_part = new ArrayList<KeyFrame>();
		part_inside_part.add(new KeyFrame((int)0.0, new EulerAngle(Math.toRadians(0), Math.toRadians(0), Math.toRadians(0)), new Offset(0, 0, 0)));
		part_inside_part.add(new KeyFrame((int)1.0, new EulerAngle(Math.toRadians(0), Math.toRadians(0), Math.toRadians(180)), new Offset(0, 0, 4)));
		part_inside_part.add(new KeyFrame((int)2.0, new EulerAngle(Math.toRadians(0), Math.toRadians(0), Math.toRadians(360)), new Offset(0, 0, 0)));
		this.partsAnimations.put("part_inside_part", new SequenceAnimation(new Sequence(part_inside_part)));

		List<KeyFrame> part = new ArrayList<KeyFrame>();
		part.add(new KeyFrame((int)0.0, new EulerAngle(Math.toRadians(0), Math.toRadians(0), Math.toRadians(0)), new Offset(0, 0, 0)));
		part.add(new KeyFrame((int)1.0, new EulerAngle(Math.toRadians(0), Math.toRadians(0), Math.toRadians(180)), new Offset(0, 0, 10)));
		part.add(new KeyFrame((int)2.0, new EulerAngle(Math.toRadians(0), Math.toRadians(0), Math.toRadians(360)), new Offset(0, 0, 0)));
		this.partsAnimations.put("part", new SequenceAnimation(new Sequence(part)));


    }

    public void entityParentConnection(Entity parent, ArmorStand target, Part part, EulerAngle head, EulerAngle body) {
        getPartAnimation(part.getModelName()).entityParentConnection(parent, target, part, head, body);
    }

    public void partParentConnection(ArmorStand parent, ArmorStand target, Part part, EulerAngle head, EulerAngle body) {
        getPartAnimation(part.getModelName()).partParentConnection(parent, target, part, head, body);
    }

    public Animation createAnimation() {
        return new ModelAnimationIdle();
    }

    public boolean containsPartAnimation(Part part) {
        return getPartAnimation(part.getModelName()) != null;
    }

    private Animation getPartAnimation(String partName) {
        String[] partNameArray = partName.split("/");
        return this.partsAnimations.get(partNameArray[partNameArray.length]);
    }



}
