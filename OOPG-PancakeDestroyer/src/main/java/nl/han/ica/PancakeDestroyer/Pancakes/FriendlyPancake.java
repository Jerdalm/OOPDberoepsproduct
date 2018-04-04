package nl.han.ica.PancakeDestroyer.Pancakes;

import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;
import nl.han.ica.PancakeDestroyer.PancakeDestroyer;


public class FriendlyPancake extends Pancake {

    private boolean down;
    private int zigzagDistance = 20;

    public FriendlyPancake(PancakeDestroyer world) {
        super(new Sprite("src/main/java/nl/han/ica/PancakeDestroyer/media/original.png"), world);
        points = -5;
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

    @Override
    public void update() {
        if (down) {
            if (getX() <= Xcod - zigzagDistance) {
                setDirection(125);
            }
            if (getX() >= Xcod + zigzagDistance) {
                setDirection(225);
            }
        } else {
            if (getX() <= Xcod - zigzagDistance) {
                setDirection(35);
            }
            if (getX() >= Xcod + zigzagDistance) {
                setDirection(305);
            }
        }
    }
}

