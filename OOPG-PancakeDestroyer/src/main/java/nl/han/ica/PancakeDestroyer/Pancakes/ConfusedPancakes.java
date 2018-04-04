//package nl.han.ica.PancakeDestroyer.Pancakes;
//
//import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;
//import nl.han.ica.PancakeDestroyer.PancakeDestroyer;
//
//public class ConfusedPancake extends Pancake{
//    package nl.han.ica.PancakeDestroyer.Pancakes;
//
//        private int points = 5;
//
//        public ConfusedPancake(PancakeDestroyer world) {
//            super(new Sprite("src/main/java/nl/han/ica/PancakeDestroyer/media/UltimatePancake.png"), world);
//
//            setxSpeed(10);
//
//
//            if (dir < 90) {//initialiseer beginpunt
//                setX(-getWidth());
//                setY(Ycod);
//                setDirection(90);
//            }
//            if (dir > 90 && dir < 180){
//                setX(world.getWidth() + getWidth());
//                setY(Ycod);
//                setDirection(270);
//            }
//            if (dir > 90 && dir < 180){
//                setX(world.getWidth() + getWidth());
//                setY(Ycod);
//                setDirection(270);
//            }
//            if (dir > 270{
//                setX(world.getWidth() + getWidth());
//                setY(Ycod);
//                setDirection(270);
//            }
//        }
//
//        public int getHit() {
//            if (hit == false) {
//                setDirection(180);
//                hit = true;
//                hitX = getX();
//                return points;
//            } else {
//                return -1000000;
//            }
//        }
//
//        @Override
//        public void update() {
//            if (hit == false) {
//
//                if (Xcod < world.getWorldWidth() / 2 && getX() >= world.getWorldWidth() * 0.75) {//maak een keerpunt op 70 procent van de afgelegde weg
//                    setDirection(270);
//                }
//                if (Xcod > world.getWorldWidth() / 2 && getX() <= world.getWorldWidth() * 0.25) {
//                    setDirection(90);
//                }
//
//            } else {
//                if (getX() <= hitX - 20) {
//                    setDirection(125);
//                }
//                if (getX() >= hitX + 20) {
//                    setDirection(225);
//                }
//            }
//        }
//    }
//}
