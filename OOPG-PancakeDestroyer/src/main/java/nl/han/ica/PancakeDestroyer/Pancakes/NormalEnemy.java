package nl.han.ica.PancakeDestroyer.Pancakes;

import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;
import nl.han.ica.PancakeDestroyer.PancakeDestroyer;


/**
 * Een gewone vijand, geen apart patroon, levert niet veel punten op
 */
public class NormalEnemy extends Pancake {

    /**
     * @param world is de wereld waarin de NormalEnemy Spawned
     */
    public NormalEnemy(PancakeDestroyer world) {
        super(new Sprite("src/main/java/nl/han/ica/PancakeDestroyer/media/EvilPancake.png"), world);

        points = 5;
        setxSpeed(8);
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


