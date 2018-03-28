package nl.han.ica.PancakeDestroyer;

import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.SpriteObject;


public class NormalEnemy extends SpriteObject {

    private PancakeDestroyer world;

    public NormalEnemy(PancakeDestroyer world) {
        this(new Sprite("src/main/java/nl/han/ica/PancakeDestroyer/media/EnemyPancake.png"));
        this.world=world;
    }

    private NormalEnemy(Sprite sprite) {
        super(sprite);
        setxSpeed(-1);
    }

    @Override
    public void update() {
        if (getX()+ getWidth()<=0) {
            setX(world.getWidth());
        }

    }
}
