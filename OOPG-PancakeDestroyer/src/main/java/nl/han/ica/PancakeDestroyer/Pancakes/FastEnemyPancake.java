package nl.han.ica.PancakeDestroyer.Pancakes;

import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;
import nl.han.ica.PancakeDestroyer.PancakeDestroyer;

public class FastEnemyPancake extends Pancake {

    private int points = 10;

    public FastEnemyPancake(PancakeDestroyer world) {
        super(new Sprite("src/main/java/nl/han/ica/PancakeDestroyer/media/Fastpancake.png"), world);

        setxSpeed(15);
        setY(Ycod);

        if (Xcod < world.getWorldWidth() / 2 - 100) {//initialiseer beginpunt
            setX(-getWidth());
            setDirection(90);
        } else {
            setX(world.getWidth() + getWidth());
            setDirection(270);
        }
    }


    @Override
    public void update() {
        if(Xcod < world.getWorldWidth() / 2 && getX() >= world.getWorldWidth() / 2 - 100 && !turningPoint) {
            setDirection(dir);
            turningPoint = true;
        }
        if(Xcod > world.getWorldWidth() / 2 && getX() <= world.getWorldWidth() / 2 - 100 && !turningPoint) {
            setDirection(dir);
            turningPoint = true;
        }
    }

    @Override
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
}
