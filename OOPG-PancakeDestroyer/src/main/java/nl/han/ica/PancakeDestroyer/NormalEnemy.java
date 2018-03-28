package nl.han.ica.PancakeDestroyer;

import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;


public class NormalEnemy {

    public BadPancake(PancakeDestroyer world) {
        this(new Sprite("foto invoeren"));
        this.world=world;
    }

    private BadPancake(Sprite sprite) {
        super(sprite);

    }
}
