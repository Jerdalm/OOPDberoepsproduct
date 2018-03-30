//package nl.han.ica.PancakeDestroyer;
//
//import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;
//import nl.han.ica.OOPDProcessingEngineHAN.Objects.SpriteObject;
//
//public abstract class Pancake extends SpriteObject {
//
//    protected PancakeDestroyer world;
//    protected Sprite sprite;
//
//    public Pancake(Sprite sprite, PancakeDestroyer world) {
//        super(sprite);
//        this.world = world;
//    }
//
////    public Pancake (PancakeDestroyer world) {
////        this.world = world;
////    }
//
//    public boolean mouseOverPancake() {
//        if (world.mouseX > getX() && world.mouseX < (getX() + getWidth()) && world.mouseY > getY()
//                && world.mouseY < (getY() + getHeight())) {
//            return true;
//        } else {
//            return false;
//        }
//    }
//    }
//}
