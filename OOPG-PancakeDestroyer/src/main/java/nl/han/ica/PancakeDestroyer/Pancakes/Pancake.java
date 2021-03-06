package nl.han.ica.PancakeDestroyer.Pancakes;

import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.SpriteObject;
import nl.han.ica.PancakeDestroyer.PancakeDestroyer;

import java.util.Random;

/**
 * de abstracte classs Pancake die alle anders dubble code voor de verschillende pancakes bevat
 */
public abstract class Pancake extends SpriteObject {

    protected PancakeDestroyer world;
    private Random yStartpoint = new Random();//random plaatsing op de Y as
    private Random Xstartpoint = new Random();//random plaatsing op de X as
    private Random Rdirection = new Random();//random richting van de pannekoek
    private int randomYcod;
    private int randomXcod;
    protected float dir;
    protected float Ycod;
    protected float Xcod;
    protected boolean turningPoint = false;
    protected boolean hit = false;
    protected float hitX = 0;
    protected int points;

    /**constructor
     * @param sprite de sprite die aan de Pancake gekoppeld moet worden
     * @param world de wereld waarin de Pancake gespawned moet worden
     */
    public Pancake(Sprite sprite, PancakeDestroyer world) {
        super(sprite);
        this.world = world;

        randomYcod = yStartpoint.nextInt(world.getWorldHeight() - 100);//zet het random beginpunt voor Y om naar een int
        Ycod = randomYcod;//zet de int om naar een float

        randomXcod = Xstartpoint.nextInt(world.getWorldWidth() - 100);//zet het random beginpunt voor X om naar een int
        Xcod = randomXcod;//zet de int om naar een float

        dir = Rdirection.nextInt(360);//zet het random aantal graden om naar een int

    }

    /**
     * @return returned het aantal punten dat de geraakte pannenkoek waard is. als de pannenkoek al geraakt is
     * word er -1000000 geretruned. bij het uitlezen van de gethit() wordt de hit dan genegeerd.
     */
    public int getHit() {
        if (hit == false) {
            setDirection(180);
            hit = true;
            hitX = getX();
            return points;
        } else {
            return -1000000;
        }
    }

    /**
     * @return deze methode returned true als de muis over de pannenkoek zweeft.
     */
    public boolean mouseOverPancake() {
        if (world.mouseX > getX() && world.mouseX < (getX() + getWidth()) && world.mouseY > getY()
                && world.mouseY < (getY() + getHeight())) {
            return true;
        } else {
            return false;
        }
    }
}

