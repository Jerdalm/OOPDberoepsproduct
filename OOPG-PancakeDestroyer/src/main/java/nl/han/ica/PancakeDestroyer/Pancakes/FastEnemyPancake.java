package nl.han.ica.PancakeDestroyer.Pancakes;

import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;
import nl.han.ica.PancakeDestroyer.PancakeDestroyer;

/**
 * Een snelle vijand, levert veel punten op.
 */
public class FastEnemyPancake extends Pancake {

    /**constructor
     * @param world is de wereld waarin de NormalEnemy Spawned
     */
    public FastEnemyPancake(PancakeDestroyer world) {
        super(new Sprite("src/main/java/nl/han/ica/PancakeDestroyer/media/Fastpancake.png"), world);
        points = 15;
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
}
