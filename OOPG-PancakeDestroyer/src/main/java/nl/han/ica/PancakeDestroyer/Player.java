package nl.han.ica.PancakeDestroyer;

import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.SpriteObject;

public class Player extends SpriteObject {

    private PancakeDestroyer world;

    public Player(PancakeDestroyer world) {
        this(new Sprite("src/main/java/nl/han/ica/PancakeDestroyer/media/Crosshair.png"));
        this.world = world;
    }

    private Player (Sprite sprite) {
        super(sprite);
}

    public void update() {
        setX(world.mouseX - 110);
        setY(world.mouseY + 150);
    }
}
