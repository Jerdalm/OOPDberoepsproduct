package nl.han.ica.PancakeDestroyer;

import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.SpriteObject;


public class TestPancake extends SpriteObject{

    private PancakeDestroyer world;

    public TestPancake (PancakeDestroyer world) {
        this(new Sprite("src/main/java/nl/han/ica/PancakeDestroyer/media/original.jpg"));
        this.world = world;
    }

    private TestPancake(Sprite sprite) {
        super(sprite);
        setxSpeed(20);
        if (getX() <= 400) {
            setDirection(10);
        } else {
            setDirection(270);
        }
    }

    @Override
    public void update() {
        if (getX() + getWidth() <= 0) {
            setX(world.getWidth());
        }
        if (getY() + getHeight() <= 0) {
            setY(world.getHeight());
        }

    }
}
