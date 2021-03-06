package nl.han.ica.PancakeDestroyer.Pancakes;

import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;
import nl.han.ica.PancakeDestroyer.PancakeDestroyer;

/**
 * Een verwarde pannekoek, levert evenveel punten op als een normale pannekoek, zigzagt door het veld heen.
 */
public class ConfusedPancake extends Pancake {

    private boolean down;
    private boolean left;
    private boolean up;
    private boolean right;
    private int zigzagDistance = 60;

    /**
     * @param world is de wereld waarin de NormalEnemy Spawned
     */
    public ConfusedPancake(PancakeDestroyer world) {
        super(new Sprite("src/main/java/nl/han/ica/PancakeDestroyer/media/ConfusedPancake.png"), world);
        points = 5;
        setxSpeed(10);

        if (dir < 90) {//Pannekoek komt van rechts
            setX(-getWidth());
            setY(Ycod);
            setDirection(35);
            left = true;
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
            right = true;
        }
        if (dir > 270) {//Pannekoek komt van boven
            setX(Xcod);
            setY(world.getHeight() + getHeight());
            setDirection(305);
            up = true;
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
            } if(up) {
                if (getX() <= Xcod - zigzagDistance) {
                    setDirection(35);
                }
                if (getX() >= Xcod + zigzagDistance) {
                    setDirection(305);
                }
            }
            if (right) {
                if (getY() <= Ycod - zigzagDistance) {
                    setDirection(215);
                }
                if (getY() >= Ycod + zigzagDistance) {
                    setDirection(305);
                }
            } if (left){
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
