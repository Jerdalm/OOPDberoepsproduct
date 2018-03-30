package nl.han.ica.PancakeDestroyer;

import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.SpriteObject;

import java.util.Random;


public class NormalEnemy extends Pancake {

    private Random r = new Random();
    private Random t = new Random();
    private Random Rdirection = new Random();
    private int randomNumber;
    private float Ycod;


    public NormalEnemy(PancakeDestroyer world) {
        super(new Sprite("src/main/java/nl/han/ica/PancakeDestroyer/media/EvilPancake.png"), world);
        randomNumber = r.nextInt(800);
        Ycod = randomNumber;
        randomNumber = r.nextInt(0);
        setxSpeed(5);
        setY(Ycod);
        if(r.equals(0)) {
            setX(-200);
            setDirection(90);
        }else{
            setX(world.getWidth()+200);
            setDirection(270);
        }
    }

    public void getHit(){
        
    }

    @Override
    public void update() {
        System.out.println(Ycod);

        if(r.equals(0) && getX() > 800){
            setDirection(Rdirection);
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
