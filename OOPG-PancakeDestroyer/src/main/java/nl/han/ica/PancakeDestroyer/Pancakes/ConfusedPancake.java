package nl.han.ica.PancakeDestroyer.Pancakes;

import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;
import nl.han.ica.PancakeDestroyer.PancakeDestroyer;

public class ConfusedPancake extends Pancake {

    private boolean down;
    private boolean left;
    private int zigzagDistance = 50;

    public ConfusedPancake(PancakeDestroyer world) {
        super(new Sprite("src/main/java/nl/han/ica/PancakeDestroyer/media/ConfusedPancake.png"), world);
        points = 5;
        setxSpeed(10);

        if (dir < 90) {//Pannekoek komt van rechts
            setX(-getWidth());
            setY(Ycod);
            setDirection(35);
            left = false;
        }
        if (dir > 90 && dir < 180) {//Pannekoek komt van onder
            setX(Xcod);
            setY(-getHeight());
            setDirection(125);
            down = true;
        }
        if (dir > 180 && dir < 270) {//Pannekoek komt van links
            setX(world.getWidth() + getWidth());
            setY(Ycod);
            setDirection(215);
            left = true;
        }
        if (dir > 270) {//Pannekoek komt van boven
            setX(Xcod);
            setY(world.getHeight() + getHeight());
            setDirection(305);
            down = false;
        }
    }

    @Override
    public void update() {
        if (hit == false) {
            if (down) {
                if (getX() <= Xcod - zigzagDistance) {
                    setDirection(125);
                }
                if (getX() >= Xcod + zigzagDistance) {
                    setDirection(225);
                }
            } if(!down) {
                if (getX() <= Xcod - zigzagDistance) {
                    setDirection(35);
                }
                if (getX() >= Xcod + zigzagDistance) {
                    setDirection(305);
                }
            }
            if (left) {
                if (getY() <= Ycod - zigzagDistance) {
                    setDirection(305);
                }
                if (getY() >= Ycod + zigzagDistance) {
                    setDirection(215);
                }
            } if (!left){
                if (getY() <= Ycod - zigzagDistance) {
                    setDirection(125);
                }
                if (getY() >= Ycod + zigzagDistance) {
                    setDirection(35);
                }
            }
        } else {
            if (getX() <= hitX - 20) {
                setDirection(125);
            }
            if (getX() >= hitX + 20) {
                setDirection(225);
            }
        }
    }
}
