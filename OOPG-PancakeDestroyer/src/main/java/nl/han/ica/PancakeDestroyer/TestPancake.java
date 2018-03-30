package nl.han.ica.PancakeDestroyer;

import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.SpriteObject;


public class TestPancake extends Pancake {

    private boolean hit = false;

    public TestPancake(PancakeDestroyer world) {
        super(new Sprite("src/main/java/nl/han/ica/PancakeDestroyer/media/EvilPancake.png"), world);
        setxSpeed(5);
        setX(10);
        setY(0);
    }


    @Override
    public void update() {
        if (hit == false) {
            if (getX() + getWidth() <= 0) {
                setX(world.getWidth());
            }
            if (getY() + getHeight() <= 0) {
                setY(world.getHeight());
            }
            if (getX() - getWidth() >= world.getWidth()) {
                setX(0);
            }
            if (getY() - getHeight() >= world.getHeight()) {
                setY(0);
            }
            if (getX() > 800 && getY() + getHeight() < 550) {
                setDirection(225);
            }
            if (getX() + getWidth() < 500) {
                setDirection(91);
            }
        } else {

        }
    }

    public void getHit() {
        hit = true;
    }
}
