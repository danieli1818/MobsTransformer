package me.danieli1818.dr_accio_mobs.models.model.animations;


public class ModelAnimationIdle implements Animation {

    private Map<String, Animation> partsAnimations;

    public ModelAnimationIdle() {
        this.partsAnimations = new HashMap<>();

        List<KeyFrame> part_inside_part = new ArrayList<KeyFrame>();
		part_inside_part.add(new KeyFrame(0.0, new EularAngle(Math.toRadians(0), Math.toRadians(0), Math.toRadians([0, 0, 0], [0, 0, 0])), new Offset(0, 0, 0));
		part_inside_part.add(new KeyFrame(1.0, new EularAngle(Math.toRadians(0), Math.toRadians(0), Math.toRadians([0, 0, 4], [0, 0, 180])), new Offset(0, 0, 4));
		part_inside_part.add(new KeyFrame(2.0, new EularAngle(Math.toRadians(0), Math.toRadians(0), Math.toRadians([0, 0, 0], [0, 0, 360])), new Offset(0, 0, 0));
		this.partsAnimations.put("part_inside_part", part_inside_part);

		List<KeyFrame> part = new ArrayList<KeyFrame>();
		part.add(new KeyFrame(0.0, new EularAngle(Math.toRadians(0), Math.toRadians(0), Math.toRadians([0, 0, 0], [0, 0, 0])), new Offset(0, 0, 0));
		part.add(new KeyFrame(1.0, new EularAngle(Math.toRadians(0), Math.toRadians(0), Math.toRadians([0, 0, 10], [0, 0, 180])), new Offset(0, 0, 10));
		part.add(new KeyFrame(2.0, new EularAngle(Math.toRadians(0), Math.toRadians(0), Math.toRadians([0, 0, 0], [0, 0, 360])), new Offset(0, 0, 0));
		this.partsAnimations.put("part", part);


    }

    @Override
    public void entityParentConnection(Entity parent, ArmorStand target, Part part, EularAngle head, EularAngle body) {
        getPartAnimation(part.getModelName()).entityParentConnection(parent, target, part, head, body);
    }

    @Override
    public void partParentConnection(ArmorStand parent, ArmorStand target, Part part, EularAngle head, EularAngle body) {
        getPartAnimation(part.getPartAnimation()).partParentConnection(parent, target, part, head, body);
    }

    @Override
    public Animation createAnimation() {
        return new ModelAnimationIdle();
    }

    @Override
    public boolean containsPartAnimation(Part part) {
        return getPartAnimation(part.getModelName()) != null;
    }

    private Animation getPartAnimation(String partName) {
        String[] partNameArray = partName.split("/");
        this.partsAnimations.get(partNameArray[partNameArray.length()]);
    }



}
