package nl.han.ica.PancakeDestroyer;

import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.SpriteObject;

import java.util.Random;


public class NormalEnemy extends Pancake {

    private PancakeDestroyer world;
    private Random r = new Random();
    private int randomNumber;
    private float Ycod;


    public NormalEnemy(PancakeDestroyer world) {
        super(new Sprite("src/main/java/nl/han/ica/PancakeDestroyer/media/EvilPancake.png"), world);
        this.world=world;
        randomNumber = r.nextInt(1);
        Ycod = randomNumber*800;
        r.nextInt(1);
        Random t = new Random();
        t.nextFloat();
        float tFloat = 800;
        setxSpeed(5);
        setX(10);
        setY(Ycod);
    }

    @Override
    public void update() {
        if (getX()+ getWidth()<=0) {
            setX(world.getWidth());
        }
        if (getY()+ getHeight()<=0) {
            setY(world.getHeight());
        }
        if (getX()- getWidth()>= world.getWidth()) {
            setX(0);
        }
        if (getY()- getHeight()>= world.getHeight()) {
            setY(0);
        }
        if(r.equals(0)){
            setDirection(225);
        }

//        }
//        if (getX() > 800 && getY() + getHeight() < 550){
//            setDirection(225);
//        }
//        if (getX()+ getWidth() < 500) {
//            setDirection(91);
//        }
    }
}
