package nl.han.ica.PancakeDestroyer;

import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.SpriteObject;

public abstract class Pancake extends SpriteObject {

    protected PancakeDestroyer world;

    public Pancake(Sprite sprite, PancakeDestroyer world) {
        super(sprite);
        this.world = world;
    }

    public abstract int getHit();

    public boolean mouseOverPancake() {
        if (world.mouseX > getX() && world.mouseX < (getX() + getWidth()) && world.mouseY > getY()
                && world.mouseY < (getY() + getHeight())) {
            return true;
        } else {
            return false;
        }
    }
}

