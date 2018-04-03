package nl.han.ica.PancakeDestroyer.Pancakes;

import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;
import nl.han.ica.PancakeDestroyer.PancakeDestroyer;


public class FriendlyPancake extends Pancake {

    private int points = -5;
    private boolean down;

    public FriendlyPancake(PancakeDestroyer world) {
        super(new Sprite("src/main/java/nl/han/ica/PancakeDestroyer/media/original.png"), world);

        setySpeed(10);
        setX(Xcod);

        if (Ycod < world.getWorldHeight() / 2 - 100) {//initialiseer beginpunt
            setY(-getHeight());
            setDirection(125);
            down = true;
        } else {
            setY(world.getHeight() + getHeight());
            setDirection(305);
            down = false;
        }
    }

    public int getHit() {
        if (hit == false) {
            setDirection(180);
            setySpeed(15);
            hit = true;
            hitX = getX();
            return points;
        } else {
            return -1000000;
        }
    }


    @Override
    public void update() {
        if (down) {
            if (getX() <= Xcod - 20) {
                setDirection(125);
            }
            if (getX() >= Xcod + 20) {
                setDirection(225);
            }
        } else {
            if (getX() <= Xcod - 20) {
                setDirection(25);
            }
            if (getX() >= Xcod + 20) {
                setDirection(305);
            }
        }
    }
}

