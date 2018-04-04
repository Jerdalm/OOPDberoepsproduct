package nl.han.ica.PancakeDestroyer.Pancakes;

import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;
import nl.han.ica.PancakeDestroyer.PancakeDestroyer;

public class UltimateEnemyPancake extends Pancake {

    private int points = 5;

    public UltimateEnemyPancake(PancakeDestroyer world) {
        super(new Sprite("src/main/java/nl/han/ica/PancakeDestroyer/media/newcrosshair.png"), world);

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

            if (Xcod < world.getWorldWidth() / 2 && getX() >= world.getWorldWidth() * 0.75) {//maak een keerpunt op 70 procent van de afgelegde weg
                setDirection(270);
                turningPoint = true;//zorg dat het keerpunt is geactiveerd en niet meer gebruikt kan worden
            }
            if (Xcod > world.getWorldWidth() / 2 && getX() <= world.getWorldWidth() * 0.25) {
                setDirection(90);
                turningPoint = true;//zorg dat het keerpunt is geactiveerd en niet meer gebruikt kan worden
            }

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

//                if (Xcod < 400/*world.getWorldWidth() / 2 - 100*/) {//maak een keerpunt op 70 procent van de afgelegde weg
//                    if (getX() <= 600 && getX() >= 500 && !turningPoint){
//                        setDirection(45);
//                        turningPoint = true;
//                        System. out. println("1");
//                    }
//                    if (getX() >= 600){
//                        setDirection(315);
//                        System. out. println("2");
//                    } else{
//                        setDirection(270);
//                        System. out. println(getX());
//                    }
//                } else {//maak een keerpunt op 70 procent van de afgelegde weg
//                    if (getX() >= 400 && getX() <= 500 && !turningPoint) {
//                        setDirection(315);
//                        turningPoint = true;
//                        System. out. println("1");
//                    }
//                    if (getX() <= 400) {
//                        setDirection(45);
//                        System. out. println("2");
//                    } else {
//                        setDirection(270);
//                        System. out. println("3");
//                    }
//                }

