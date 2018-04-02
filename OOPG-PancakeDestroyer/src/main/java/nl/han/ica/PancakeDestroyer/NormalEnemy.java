package nl.han.ica.PancakeDestroyer;

import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.SpriteObject;

import javax.naming.ldap.Rdn;
import java.util.Random;


public class NormalEnemy extends Pancake {


    public NormalEnemy(PancakeDestroyer world) {
        super(new Sprite("src/main/java/nl/han/ica/PancakeDestroyer/media/EvilPancake.png"), world);

        setxSpeed(3);
        setY(Ycod);

        if (Xcod < 100) {//initialiseer beginpunt
            setX(-getWidth());
            setDirection(90);
        } else {
            setX(world.getWidth() + getWidth());
            setDirection(270);
        }
    }

    public int getHit() {
        if (hit == false) {
            setDirection(225);
            hit = true;
            hitX = getX();
            return points;
        } else {
            return 0;
        }
    }


    @Override
    public void update() {
        if (hit == false) {
            if (Xcod < 100 && getX() >= 600) {//maak een keerpunt op 70 procent van de afgelegde weg
                if (/*randomYcod > 300 && */!turningPoint) {
                    setDirection(45);
                    turningPoint = true;//zorg dat het keerpunt is geactiveerd en niet meer gebruikt kan worden
                }
                if (randomYcod > 300 && getX() >= 750 && turningPoint) {
                    setDirection(300);
                    turningPoint = false;
                } else {
                    setDirection(270);
                }
            }
//            if (Xcod < 100 && getX() >= 900 && !turningPoint) {//maak een keerpunt op 70 procent van de afgelegde weg
//                setDirection(dir);
//                turningPoint = true;//zorg dat het keerpunt is geactiveerd en niet meer gebruikt kan worden
//            }
//            if (Xcod > 100 && getX() <= 300 && !turningPoint) {
//                setDirection(dir);
//                turningPoint = true;//zorg dat het keerpunt is geactiveerd en niet meer gebruikt kan worden
//            }
        } else {
            if (getX() <= hitX - 20) {
                System.out.println("1");
                setDirection(125);
            }
            if (getX() >= hitX + 20) {
                System.out.println("2");
                setDirection(225);
            }
        }
    }
}

