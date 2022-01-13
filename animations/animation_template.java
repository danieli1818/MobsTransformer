package {PACKAGE_NAME}.animations;

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

public class {MODEL_NAME}Animation{ANIMATION_NAME} implements Animation {

    private Map<String, Animation> partsAnimations;

    public {MODEL_NAME}Animation{ANIMATION_NAME}() {
        this.partsAnimations = new HashMap<String, Animation>();

        {ANIMATIONS}

    }

    public void entityParentConnection(Entity parent, ArmorStand target, Part part, EulerAngle head, EulerAngle body) {
        getPartAnimation(part.getModelName()).entityParentConnection(parent, target, part, head, body);
    }

    public void partParentConnection(ArmorStand parent, ArmorStand target, Part part, EulerAngle head, EulerAngle body) {
        getPartAnimation(part.getModelName()).partParentConnection(parent, target, part, head, body);
    }

    public Animation createAnimation() {
        return new {MODEL_NAME}Animation{ANIMATION_NAME}();
    }

    public boolean containsPartAnimation(Part part) {
        return getPartAnimation(part.getModelName()) != null;
    }

    private Animation getPartAnimation(String partName) {
        String[] partNameArray = partName.split("/");
        return this.partsAnimations.get(partNameArray[partNameArray.length - 1]);
    }



}
