package nl.han.ica.PancakeDestroyer;

import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.SpriteObject;


public class NormalEnemy extends SpriteObject {

    private PancakeDestroyer world;


    public NormalEnemy(PancakeDestroyer world) {
        this(new Sprite("src/main/java/nl/han/ica/PancakeDestroyer/media/EvilPancake.png"));
        this.world=world;
//        this.setX(x);
//        this.setY(y);
    }

    private NormalEnemy(Sprite sprite) {
        super(sprite);
        setxSpeed(5);
        setX(10);
        setY(10);
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

        if (getX() > 800 && getY() + getHeight() < 550){
            System.out.println(getX());
            System.out.println(getY());
            setDirection(225);
        }
        if (getX()+ getWidth() < 500) {
            System.out.println(getX());
            System.out.println(getY());
            setDirection(90);
        }
    }
}
