package nl.han.ica.PancakeDestroyer;

import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.SpriteObject;

public abstract class Pancake extends SpriteObject {

    protected PancakeDestroyer world;

    public Pancake(Sprite sprite, PancakeDestroyer world) {
        super(sprite);
        this.world = world;
    }

    @Override
    public void update() {

    }
}
