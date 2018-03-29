package nl.han.ica.PancakeDestroyer;

import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.SpriteObject;


public class NormalEnemy extends SpriteObject {

    private PancakeDestroyer world;


    public NormalEnemy(PancakeDestroyer world) {
        this(new Sprite("src/main/java/nl/han/ica/PancakeDestroyer/media/EnemyPancake.png"));
        this.world=world;
//        this.setX(x);
//        this.setY(y);
    }

    private NormalEnemy(Sprite sprite) {
        super(sprite);
        setxSpeed(10);
        setX(0);
        setY(300);

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
            setX(world.getWidth());
        }
        if (getY()- getHeight()>= world.getHeight()) {
            setY(world.getHeight());
        }

        if (getX() > getWidth()*0.8 && getY() + getHeight() < 450){
            System.out.println(getX());
            System.out.println(getY());
            setDirection(225);
        }
        if (getX() + getWidth() > getWidth()* 0.2 && getY() + getHeight() > 450){
            System.out.println(getX());
            System.out.println(getY());
            setDirection(90);
        }

    }
}
