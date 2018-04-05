package nl.han.ica.PancakeDestroyer;

import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.SpriteObject;
import nl.han.ica.OOPDProcessingEngineHAN.UserInput.IMouseInput;
import nl.han.ica.PancakeDestroyer.Pancakes.Pancake;

public class Player extends SpriteObject implements IMouseInput{

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

    public int getPoints() {
        return points;
    }

    public int getBricks() {
        return bricks;
    }

    public void update() {
        setX(world.mouseX - getWidth() / 2);
        setY(world.mouseY - getHeight() / 2);
    }

    public void mousePressed(int x, int y, int button) {
        if (bricks > 0) {
            bricks --;
            trownBricks ++;
            for (Pancake pancake : world.getSpawner().getPancakes()) {
                if (pancake.mouseOverPancake()) {
                    int plusPoints = pancake.getHit();
                    if (plusPoints > -900) {
                        bricks ++;
                        hits ++;
                        points = points + plusPoints;
                    } else {
                    }
                }
            }
        }
    }

}
