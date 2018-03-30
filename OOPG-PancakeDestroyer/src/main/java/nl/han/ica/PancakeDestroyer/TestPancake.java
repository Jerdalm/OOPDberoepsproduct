//package nl.han.ica.PancakeDestroyer;
//
//import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;
//import nl.han.ica.OOPDProcessingEngineHAN.Objects.SpriteObject;
//
//
//public class TestPancake extends Pancake{
//
//    public TestPancake () {
//        this(new Sprite("src/main/java/nl/han/ica/PancakeDestroyer/media/original.jpg"));
//    }
//
//    public TestPancake(Sprite sprite, PancakeDestroyer world) {
//        super(sprite, world);
//    }
//
//    @Override
//    public void update() {
//        if (getX() + getWidth() <= 0) {
//            setX(world.getWidth());
//        }
//        if (getY() + getHeight() <= 0) {
//            setY(world.getHeight());
//        }
//
//    }
//}
