package nl.han.ica.PancakeDestroyer;

import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.SpriteObject;

public class Player extends SpriteObject {

    private PancakeDestroyer world;
    private int bricks = 20;
    private int trownBricks = 0;
    private int hits = 0;

    public Player(PancakeDestroyer world) {
        this(new Sprite("src/main/java/nl/han/ica/PancakeDestroyer/media/Crosshairoud.png"));
        setWidth(25);
        setHeight(25);
        this.world = world;
    }

    private Player (Sprite sprite) {
        super(sprite);
    }

    public int getTrownBricks() {
        return trownBricks;
    }

    public int getHits() {
        return hits;
    }

    public void setHits(int hits) {
        this.hits = hits;
    }

    public void setBricks(int bricks) {
        this.bricks = bricks;

    }

    public int getBricks() {
        return bricks;
    }

    public void update() {
        setX(world.mouseX - 110);
        setY(world.mouseY + 150);
    }
}
