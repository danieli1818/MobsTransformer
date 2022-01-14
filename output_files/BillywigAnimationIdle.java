package dracciomobs.models.billywig.animations;

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

public class BillywigAnimationIdle implements Animation {

    private Map<String, Animation> partsAnimations;

    public BillywigAnimationIdle() {
        this.partsAnimations = new HashMap<String, Animation>();

        List<KeyFrame> head = new ArrayList<KeyFrame>();
		head.add(new KeyFrame((int)0, new EulerAngle(Math.toRadians(0), Math.toRadians(0), Math.toRadians(0)), new Offset(0, 0, 0)));
		this.partsAnimations.put("head", new SequenceAnimation(new Sequence(head)));

		List<KeyFrame> body = new ArrayList<KeyFrame>();
		body.add(new KeyFrame((int)0, new EulerAngle(Math.toRadians(0), Math.toRadians(0), Math.toRadians(0)), new Offset(0, 0, 0)));
		this.partsAnimations.put("body", new SequenceAnimation(new Sequence(body)));


    }

    public void entityParentConnection(Entity parent, ArmorStand target, Part part, EulerAngle head, EulerAngle body) {
        getPartAnimation(part.getModelName()).entityParentConnection(parent, target, part, head, body);
    }

    public void partParentConnection(ArmorStand parent, ArmorStand target, Part part, EulerAngle head, EulerAngle body) {
        getPartAnimation(part.getModelName()).partParentConnection(parent, target, part, head, body);
    }

    public Animation createAnimation() {
        return new BillywigAnimationIdle();
    }

    public boolean containsPartAnimation(Part part) {
        return getPartAnimation(part.getModelName()) != null;
    }

    private Animation getPartAnimation(String partName) {
        String[] partNameArray = partName.split("/");
        return this.partsAnimations.get(partNameArray[partNameArray.length - 1]);
    }



}
