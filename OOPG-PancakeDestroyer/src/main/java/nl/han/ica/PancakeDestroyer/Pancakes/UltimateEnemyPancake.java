package nl.han.ica.PancakeDestroyer.Pancakes;

import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;
import nl.han.ica.PancakeDestroyer.PancakeDestroyer;

/**
 * UltimateEnemyPancake levert veel punten op.
 */
public class UltimateEnemyPancake extends Pancake {

    /**
     * @param world de wereld waarin de pancake spawned
     */
    public UltimateEnemyPancake(PancakeDestroyer world) {
        super(new Sprite("src/main/java/nl/han/ica/PancakeDestroyer/media/UltimatePancake.png"), world);
        points = 10;
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

    /**
     * @return returned het aantal punten dat de geraakte pannenkoek waard is. als de pannenkoek al geraakt is
     * word er -1000000 geretruned. bij het uitlezen van de gethit() wordt de hit dan genegeerd.
     */
    public int getHit() {
        super.getHit();
        setDirection(225);
        return points;
    }

    @Override
    public void update() {
        if (hit == false) {
            if (Xcod < world.getWorldWidth() / 2 && getX() >= world.getWorldWidth() * 0.75) {//maak een keerpunt op 70 procent van de afgelegde weg
                setDirection(270);
            }
            if (Xcod > world.getWorldWidth() / 2 && getX() <= world.getWorldWidth() * 0.25) {
                setDirection(90);
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