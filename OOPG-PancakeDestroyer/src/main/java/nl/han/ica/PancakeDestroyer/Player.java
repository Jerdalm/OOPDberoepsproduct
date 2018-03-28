package nl.han.ica.PancakeDestroyer;

import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.SpriteObject;
import processing.core.PApplet;

public class Player extends SpriteObject {

    final int size=25;
    private final PancakeDestroyer world;

    public Player(world PancakeDestroyer) {
        this(new Sprite ("src/main/java/nl/han/ica/PancakeDestroyer/media/Crosshair.jpg"));
        this.world=world;
    }

    @Override
    public void update() {


    }
public void setXY(int x, int y){
        setY(100);
        setX(100);

}
