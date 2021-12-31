package {PACKAGE_NAME};

import org.bukkit.util.EulerAngle;

import com.ticxo.modelapi.api.additions.EntityModelPart;
import com.ticxo.modelapi.api.animation.AnimationMap;
import com.ticxo.modelapi.api.modeling.Bone;
import com.ticxo.modelapi.api.modeling.ModelBase;
import com.ticxo.modelapi.api.modeling.Offset;
import com.ticxo.modelapi.api.modeling.Part;
import com.ticxo.modelapi.api.modeling.SkeletonModel;

import dracciomobs.models.{MODEL_ID}.animations.{MODEL_NAME}AnimationIdle;
import us.fihgu.toolbox.item.DamageableItem;
import us.fihgu.toolbox.resourcepack.model.ModelAxis;

public class {MODEL_NAME} extends ModelBase {

	public {MODEL_NAME}() {
		super("{PLUGIN_ID}:{MODEL_ID}", "{TEXTURE_NAME}");

		{MODEL_LINES}

	}
}