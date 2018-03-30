package nl.han.ica.PancakeDestroyer;

import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.SpriteObject;

import javax.naming.ldap.Rdn;
import java.util.Random;


public class NormalEnemy extends Pancake {

    private Random yStartpoint = new Random();//random plaatsing op de Y as
    private Random Xstartpoint = new Random();//random plaatsing op de X as
    private Random Rdirection = new Random();//random richting van de pannekoek
    private float dir;
    private int randomYcod;
    private int randomXcod;
    private float Ycod;
    private float Xcod;
    private boolean turningPoint = false;


    public NormalEnemy(PancakeDestroyer world) {
        super(new Sprite("src/main/java/nl/han/ica/PancakeDestroyer/media/EvilPancake.png"), world);
        randomYcod = yStartpoint.nextInt(680);//zet de random om naar een int
        Ycod = randomYcod;//zet de int om naar een float

        randomXcod = Xstartpoint.nextInt(200);//zet de random om naar een int
        Xcod = randomXcod;//zet de int om naar een float

        dir = Rdirection.nextInt(360);//zet de random om naar een int
        setxSpeed(6);
        setY(Ycod);

        if (Xcod < 100) {
            setX(-200);
            setDirection(90);
        } else {
            setX(world.getWidth() + 200);
            setDirection(270);
        }
    }

    public void getHit() {

    }

    @Override
    public void update() {

        if (Xcod < 100 && getX() >=900 && !turningPoint) {
            setDirection(dir);
            turningPoint = true;
            System.out.println("biem: "+ Xcod);
            System.out.println(Ycod);
        }
        if(Xcod > 100 && getX() <=300 && !turningPoint) {
            setDirection(dir);
            turningPoint = true;
            System.out.println("biem: "+ Xcod);
            System.out.println(Ycod);
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

