package nl.han.ica.PancakeDestroyer;

import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.SpriteObject;

import java.util.Random;

public abstract class Pancake extends SpriteObject {

    protected PancakeDestroyer world;
    protected Random yStartpoint = new Random();//random plaatsing op de Y as
    protected Random Xstartpoint = new Random();//random plaatsing op de X as
    protected Random Rdirection = new Random();//random richting van de pannekoek
    protected float dir;
    protected int randomYcod;
    protected int randomXcod;
    protected float Ycod;
    protected float Xcod;
    protected boolean turningPoint = false;
    protected boolean hit = false;
    protected float hitX = 0;
    protected int points = 5;

    public Pancake(Sprite sprite, PancakeDestroyer world) {
        super(sprite);
        this.world = world;

        randomYcod = yStartpoint.nextInt(690);//zet het random beginpunt voor Y om naar een int
        Ycod = randomYcod;//zet de int om naar een float

        randomXcod = Xstartpoint.nextInt(200);//zet het random beginpunt voor X om naar een int
        Xcod = randomXcod;//zet de int om naar een float

        dir = Rdirection.nextInt(360);//zet het random aantal graden om naar een int

    }

    public abstract int getHit();

    public boolean mouseOverPancake() {
        if (world.mouseX > getX() && world.mouseX < (getX() + getWidth()) && world.mouseY > getY()
                && world.mouseY < (getY() + getHeight())) {
            return true;
        } else {
            return false;
        }
    }
}

