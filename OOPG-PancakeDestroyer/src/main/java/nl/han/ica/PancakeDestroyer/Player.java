package nl.han.ica.PancakeDestroyer;

import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.SpriteObject;
import nl.han.ica.OOPDProcessingEngineHAN.UserInput.IMouseInput;
import nl.han.ica.PancakeDestroyer.Pancakes.Pancake;

/**
 * de class Player houd alles bij waar user input mee te maken heeft en tekend het crosshair op het scherm
 */
public class Player extends SpriteObject implements IMouseInput{

    private PancakeDestroyer world;
    private int points = 0;
    private int bricks = 20;
    private int trownBricks = 0;
    private int hits = 0;

    /**
     * @param world de wereld waarin het object Player word getekend
     */
    public Player(PancakeDestroyer world) {
        this(new Sprite("src/main/java/nl/han/ica/PancakeDestroyer/media/newcrosshair.png"));

        this.world = world;
    }

    /**
     * Maak een Player aan met een sprite
     * @param sprite De sprite die aan dit object gekoppeld moet worden
     */
    private Player(Sprite sprite) {
        super(sprite);
    }

    /**
     * @return geeft het aantal trownBricks
     */
    public int getTrownBricks() {
        return trownBricks;
    }

    /**
     * @return geeft het aantal hits
     */
    public int getHits() {
        return hits;
    }

    /**
     * @return geeft het aantal Points
     */
    public int getPoints() {
        return points;
    }

    /**
     * @return geeft het aantal bricks
     */
    public int getBricks() {
        return bricks;
    }

    @Override
    public void update() {
        setX(world.mouseX - getWidth() / 2);
        setY(world.mouseY - getHeight() / 2);
    }

    @Override
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
