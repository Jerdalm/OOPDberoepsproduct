package nl.han.ica.PancakeDestroyer;

import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.SpriteObject;

public class Player extends SpriteObject {

    private PancakeDestroyer world;

    public Player(PancakeDestroyer world) {
        this(new Sprite("src/main/java/nl/han/ica/PancakeDestroyer/media/Crosshair.png"));
        Sprite.resize(25, 25);
        this.world = world;

    }

    private Player (Sprite sprite) {
        super(sprite);
    }

    @Override
    public void update() {
//        setY(100);
//        setX(100);

    }

}
