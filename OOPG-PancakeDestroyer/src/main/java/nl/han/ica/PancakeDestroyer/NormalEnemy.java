package nl.han.ica.PancakeDestroyer;

import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.SpriteObject;


public class NormalEnemy extends SpriteObject {

    private PancakeDestroyer world;

    public Normalizer(PancakeDestroyer world) {
        super(new Sprite("foto invoeren"));
        this.world=world;
    }

    private Sprite BadPancake(Sprite sprite) {
        super(sprite);

    }

    @Override
    public void update() {

    }
}
