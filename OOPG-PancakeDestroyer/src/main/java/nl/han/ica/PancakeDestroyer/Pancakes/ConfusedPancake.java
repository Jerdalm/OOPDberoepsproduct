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
            System.out.println("a");
        }
        if (dir > 90 && dir < 180) {//Pannekoek komt van onder
            setX(Xcod);
            setY(-getHeight());
            setDirection(125);
            down = true;
            System.out.println("b");
        }
        if (dir > 180 && dir < 270) {//Pannekoek komt van links
            setX(world.getWidth() + getWidth());
            setY(Ycod);
            setDirection(215);
            right = true;
            System.out.println("c");
        }
        if (dir > 270) {//Pannekoek komt van boven
            setX(Xcod);
            setY(world.getHeight() + getHeight());
            setDirection(305);
            up = true;
            System.out.println("d");
        }
    }

    @Override
    public void update() {
        if (hit == false) {
            if (down) {
                System.out.println("1");
                if (getX() <= Xcod - zigzagDistance) {
                    setDirection(125);
                }
                if (getX() >= Xcod + zigzagDistance) {
                    setDirection(225);
                }
            } if(up) {
                System.out.println("2");
                if (getX() <= Xcod - zigzagDistance) {
                    setDirection(35);
                }
                if (getX() >= Xcod + zigzagDistance) {
                    setDirection(305);
                }
            }
            if (right) {
                System.out.println("3");
                if (getY() <= Ycod - zigzagDistance) {
                    setDirection(215);
                }
                if (getY() >= Ycod + zigzagDistance) {
                    setDirection(305);
                }
            } if (left){
                System.out.println("4");
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
