package nl.han.ica.PancakeDestroyer;

import nl.han.ica.PancakeDestroyer.Pancakes.*;
import java.util.ArrayList;
import java.util.Random;

/**
 * maakt het object PancakeSpawner die verantwoordelijk is voor het spawnen en verwijderen van pancakes
 */
public class PancakeSpawner {

    PancakeDestroyer world;
    private ArrayList<Pancake> pancakes = new ArrayList<>();

    /**
     * @param world de wereld waarin de PancakeSpawner zich in bevind
     */
    public PancakeSpawner(PancakeDestroyer world) {
        this.world = world;
    }

    /**
     * deze methode word iedere keer opnieuw aangeroepen
     */
    public void update() {
        spawnPancakes();
        deletePancakes();
    }

    /**
     * deze methode spawned een random pancake
     */
    private void spawnPancakes() {
        Random random = new Random();
        int type = random.nextInt(5);
        if (pancakes.size() < 5) {
            if (type == 0) {
                Pancake pancake = new FriendlyPancake(world);
                pancakes.add(pancake);
                world.addGameObject(pancake, 1);
            } else if (type == 1) {
                Pancake pancake = new NormalEnemy(world);
                pancakes.add(pancake);
                world.addGameObject(pancake, 1);
            } else if (type == 2) {
                Pancake pancake = new FastEnemyPancake(world);
                pancakes.add(pancake);
                world.addGameObject(pancake, 1);
            } else if (type == 3) {
                Pancake pancake = new UltimateEnemyPancake(world);
                pancakes.add(pancake);
                world.addGameObject(pancake);
            } else if (type == 4) {
                Pancake pancake = new ConfusedPancake(world);
                pancakes.add(pancake);
                world.addGameObject(pancake);
            }
        }
    }


    /**
     * deze methode verwijderd een pancake als deze buiten het scherm komt
     */
    private void deletePancakes() {
        for (int i = 0; i < pancakes.size(); i++) {
            if (pancakes.get(i).getX() > world.getWorldWidth() + 200 || pancakes.get(i).getX() < -200 ||
                    pancakes.get(i).getY() > world.getWorldHeight() + 200 || pancakes.get(i).getY() < -200) {
                world.deleteGameObject(pancakes.get(i));
                pancakes.remove(i);
                i--;
            }
        }
    }

    /**
     * @return de arraylist van pancakes
     */
    public ArrayList<Pancake> getPancakes() {
        return pancakes;
    }
}

