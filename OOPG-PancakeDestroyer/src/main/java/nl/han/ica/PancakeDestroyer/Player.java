package nl.han.ica.PancakeDestroyer;

import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.SpriteObject;

public class Player extends SpriteObject {

    private PancakeDestroyer world;
    private int points = 0;
    private int bricks = 20;
    private int trownBricks = 0;
    private int hits = 0;

    public Player(PancakeDestroyer world) {
        this(new Sprite("src/main/java/nl/han/ica/PancakeDestroyer/media/newcrosshair.png"));

        this.world = world;
    }

    private Player(Sprite sprite) {
        super(sprite);
    }

    public int getTrownBricks() {
        return trownBricks;
    }

    public int getHits() {
        return hits;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public void setTrownBricks(int trownBricks) {
        this.trownBricks = trownBricks;
    }

    public int getPoints() {

        return points;
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
        setX(world.mouseX - getWidth() / 2);
        setY(world.mouseY - getHeight() / 2);
    }
}
