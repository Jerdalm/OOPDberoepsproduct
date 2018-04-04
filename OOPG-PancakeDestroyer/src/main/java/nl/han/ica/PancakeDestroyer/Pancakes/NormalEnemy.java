package nl.han.ica.PancakeDestroyer.Pancakes;

import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;
import nl.han.ica.PancakeDestroyer.PancakeDestroyer;


public class NormalEnemy extends Pancake {

    private int points = 5;

    public NormalEnemy(PancakeDestroyer world) {
        super(new Sprite("src/main/java/nl/han/ica/PancakeDestroyer/media/EvilPancake.png"), world);

        setxSpeed(10);
        setY(Ycod);

        if (Xcod < world.getWorldWidth() / 2 - 100) {//initialiseer beginpunt
            setX(-getWidth());
            setDirection(90);
        } else {
            setX(world.getWidth() + getWidth());
            setDirection(270);
        }
    }

    public int getHit() {
        if (hit == false) {
            setDirection(180);
            hit = true;
            hitX = getX();
            return points;
        } else {
            return -1000000;
        }
    }


    @Override
    public void update() {
        if (hit == false) {

            if (Xcod < world.getWorldWidth() / 2 && getX() >= world.getWorldWidth() / 4 * 3 - 100 && !turningPoint) {//maak een keerpunt op 70 procent van de afgelegde weg
                setDirection(dir);
                turningPoint = true;//zorg dat het keerpunt is geactiveerd en niet meer gebruikt kan worden
            }
            if (Xcod > world.getWorldWidth() / 2 && getX() <= world.getWorldWidth() / 4 - 100 && !turningPoint) {
                setDirection(dir);
                turningPoint = true;//zorg dat het keerpunt is geactiveerd en niet meer gebruikt kan worden
            }

        } else {
            setySpeed(15);
        }
    }
}


