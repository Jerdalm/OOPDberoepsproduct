//package nl.han.ica.PancakeDestroyer.media;
//
//import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;
//import nl.han.ica.PancakeDestroyer.Pancake;
//import nl.han.ica.PancakeDestroyer.PancakeDestroyer;
//
//public class UltimateEnemy extends Pancake {
//
//    public UltimateEnemy(PancakeDestroyer world) {
//        super(new Sprite("src/main/java/nl/han/ica/PancakeDestroyer/media/EvilPancake.png"), world);
//
//        if (Xcod < 100) {//initialiseer beginpunt
//            setX(-getWidth());
//            setDirection(90);
//        } else {
//            setX(world.getWidth() + getWidth());
//            setDirection(270);
//        }
//    }
//
//    @Override
//    public void update() {
//        if (hit == false) {
//            if (Xcod < 100 && getX() >= 600) {//maak een keerpunt op 70 procent van de afgelegde weg
//                if(randomYcod < 350 && getX() >= 750) {
//                    setDirection(45);
//                    turningPoint = true;//zorg dat het keerpunt is geactiveerd en niet meer gebruikt kan worden
//                }
//                if(randomYcod < 350 && getX() <= 750 && getX()>= 600) {
//                    setDirection(315);
//                }
//                else{
//                    setDirection(270);
//                }
//            }
//            if (Xcod > 100 && getX() <= 300 && !turningPoint) {
//                setDirection(dir);
//                turningPoint = true;//zorg dat het keerpunt is geactiveerd en niet meer gebruikt kan worden
//            }
//
//        } else {
//            if (getX() <= hitX - 20) {
//                System.out.println("1");
//                setDirection(125);
//            }
//            if (getX() >= hitX + 20) {
//                System.out.println("2");
//                setDirection(225);
//            }
//        }
//    }
//}
