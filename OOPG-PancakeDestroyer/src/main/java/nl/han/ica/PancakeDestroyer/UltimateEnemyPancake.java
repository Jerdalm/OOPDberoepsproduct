package nl.han.ica.PancakeDestroyer;

public class UltimateEnemyPancake {
    public UltimateEnemy(PancakeDestroyer world) {
        super(new Sprite("src/main/java/nl/han/ica/PancakeDestroyer/media/EvilPancake.png"), world);

        if (Xcod < 100) {//initialiseer beginpunt
            setX(-getWidth());
            setDirection(90);
        } else {
            setX(world.getWidth() + getWidth());
            setDirection(270);
        }

        @Override
        public void update() {
            if (hit == false) {
                if (Xcod < 100) {//maak een keerpunt op 70 procent van de afgelegde weg
                    if (getX() <= getWidth()/2+200 && getX() >= getWidth()/2 {
                        setDirection(45);
                    } if (getX() >= getWidth()/2)+200)) {
                        setDirection(300);
                    } else {
                        setDirection(270);
                    }

                    if (Xcod > 100) {//maak een keerpunt op 70 procent van de afgelegde weg
                        if (getX() <= getWidth()/2-200 && getX() >= getWidth()/2) {
                            setDirection(45);
                        } if (getX() >= 700) {
                            setDirection(300);
                        } else {
                            setDirection(270);
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
