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
        randomYcod = yStartpoint.nextInt(690);//zet het random beginpunt voor Y om naar een int
        Ycod = randomYcod;//zet de int om naar een float

        randomXcod = Xstartpoint.nextInt(200);//zet het random beginpunt voor X om naar een int
        Xcod = randomXcod;//zet de int om naar een float

        dir = Rdirection.nextInt(360);//zet het random aantal graden om naar een int

        setxSpeed(6);
        setY(Ycod);

        if (Xcod < 100) {//initialiseer beginpunt
            setX(-getWidth());
            setDirection(90);
        } else {
            setX(world.getWidth() + getWidth());
            setDirection(270);
        }
    }

    public void getHit() {

    }

    @Override
    public void update() {

        if (Xcod < 100 && getX() >= 900 && !turningPoint) {//maak een keerpunt op 70 procent van de afgelegde weg
            setDirection(dir);
            turningPoint = true;//zorg dat het keerpunt is geactiveerd en niet meer gebruikt kan worden
        }
        if (Xcod > 100 && getX() <= 300 && !turningPoint) {
            setDirection(dir);
            turningPoint = true;//zorg dat het keerpunt is geactiveerd en niet meer gebruikt kan worden
        }
    }
}

