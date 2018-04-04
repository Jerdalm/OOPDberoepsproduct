package nl.han.ica.PancakeDestroyer;

import nl.han.ica.PancakeDestroyer.Pancakes.*;

import java.util.ArrayList;
import java.util.Random;

public class PancakeSpawner {

    PancakeDestroyer world;
    private ArrayList<Pancake> pancakes = new ArrayList<>();

    public PancakeSpawner(PancakeDestroyer world) {
        this.world = world;
    }

    public void update() {
        spawnPancakes();
        deletePancakes();
    }

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

    public ArrayList<Pancake> getPancakes() {
        return pancakes;
    }
}

