package dracciomobs.models.giant.animations;

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

public class GiantAnimationIdle implements Animation {

    private Map<String, Animation> partsAnimations;

    public GiantAnimationIdle() {
        this.partsAnimations = new HashMap<String, Animation>();

        List<KeyFrame> group = new ArrayList<KeyFrame>();
		group.add(new KeyFrame((int)0.0, new EulerAngle(Math.toRadians(0), Math.toRadians(0), Math.toRadians(0)), new Offset(0, 0, 0)));
		group.add(new KeyFrame((int)1.0, new EulerAngle(Math.toRadians(0), Math.toRadians(0), Math.toRadians(0)), new Offset(0, 0, 0)));
		this.partsAnimations.put("group", new SequenceAnimation(new Sequence(group)));


    }

    public void entityParentConnection(Entity parent, ArmorStand target, Part part, EulerAngle head, EulerAngle body) {
        getPartAnimation(part.getModelName()).entityParentConnection(parent, target, part, head, body);
    }

    public void partParentConnection(ArmorStand parent, ArmorStand target, Part part, EulerAngle head, EulerAngle body) {
        getPartAnimation(part.getModelName()).partParentConnection(parent, target, part, head, body);
    }

    public Animation createAnimation() {
        return new GiantAnimationIdle();
    }

    public boolean containsPartAnimation(Part part) {
        return getPartAnimation(part.getModelName()) != null;
    }

    private Animation getPartAnimation(String partName) {
        String[] partNameArray = partName.split("/");
        return this.partsAnimations.get(partNameArray[partNameArray.length]);
    }



}
