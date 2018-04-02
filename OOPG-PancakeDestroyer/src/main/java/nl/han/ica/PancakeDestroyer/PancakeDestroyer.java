package nl.han.ica.PancakeDestroyer;

import javafx.scene.Cursor;
import nl.han.ica.OOPDProcessingEngineHAN.Dashboard.Dashboard;
import nl.han.ica.OOPDProcessingEngineHAN.Engine.GameEngine;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;
import nl.han.ica.OOPDProcessingEngineHAN.View.View;
import nl.han.ica.waterworld.TextObject;
import processing.core.PApplet;

import java.util.ArrayList;

public class PancakeDestroyer extends GameEngine {

    private int worldWidth;
    private int worldHeight;
    private ArrayList<TextObject> dashboardText = new ArrayList<>();
    private int points = 0;
    private Player player;
    private ArrayList<Pancake> pancakes = new ArrayList<>();

    public static void main(String[] args) {
        PApplet.main(new String[]{"nl.han.ica.PancakeDestroyer.PancakeDestroyer"});
    }

    @Override
    public void setupGame() {
        worldWidth = 1200;
        worldHeight = 800;
        noCursor();

        createView(worldWidth, worldHeight, 255, 0, 255);
        createObjects();
        createDashboard(worldWidth, 150, worldWidth / 2 + 200, worldHeight - 150);

    }

    @Override
    public void update() {
        updateDashboard();
        spawnPancakes();
        deletePancakes();
    }

    private void deletePancakes() {
        //TODO het verwijderen van de pancake uit gameObjects
        for (int i = 0; i < pancakes.size(); i ++) {
            if (pancakes.get(i).getX() > worldWidth + 200 || pancakes.get(i) .getX() < -200 ||
                    pancakes.get(i) .getY() > worldHeight + 200 || pancakes.get(i) .getY() < -200) {
                pancakes.remove(i);
            }
        }

    }

    private void spawnPancakes() {
        System.out.println(1);
        if (pancakes.size() < 5) {
            Pancake pancake = new NormalEnemy(this);
            System.out.println(2);
            pancakes.add(pancake);
            addGameObject(pancake, 1);
        }
    }

    private void createView(int worldWidth, int worldHeight, int r, int g, int b) {
        View view = new View(worldWidth, worldHeight);
        view.setBackground(r, g, b);

        setView(view);
        size(worldWidth, worldHeight);
    }

    private void createObjects() {
        player = new Player(this);
        addGameObject(player, 0, 0, 5);
        //enemy2 = new NormalEnemy(this);
        //addGameObject(enemy2,1);
    }

    private void updateDashboard() {
        dashboardText.get(0).setText("Bricks: " + player.getBricks());
        dashboardText.get(1).setText("Trown Bricks: " + player.getTrownBricks());
        dashboardText.get(2).setText("Points: " + points);
        dashboardText.get(3).setText("Pancakes Hit: " + player.getHits());
    }

    private void createDashboard(int dashboardWidth, int dashboardHeight, int x, int y) {
        Dashboard dashboard = new Dashboard(x, y, dashboardWidth, dashboardHeight);
        dashboard.setBackground(138, 144, 150);
        for (int i = 0; i < 4; i++) {
            int yNew = -i * 30 + y;
            dashboardText.add(new TextObject(""));
            dashboardText.get(i).setX(-x + 5);
            dashboardText.get(i).setY(-yNew);
            dashboard.addGameObject(dashboardText.get(i));
        }
        addDashboard(dashboard, 1);
    }

    public void mousePressed() {
//        if (enemy.mouseOverPancake()) {
//            int plusPoints = enemy.getHit();
//            if (plusPoints > 0) {
//                player.setHits(player.getHits() + 1);
//                points = points + plusPoints;
//            }
//        }
//        if (enemy2.mouseOverPancake()) {
//            int plusPoints = enemy2.getHit();
//            if (plusPoints > 0) {
//                player.setHits(player.getHits() + 1);
//                points = points + plusPoints;
//            }
//        }
//        if (enemy3.mouseOverPancake()) {
//            int plusPoints = enemy3.getHit();
//            if (plusPoints > 0) {
//                player.setHits(player.getHits() + 1);
//                points = points + plusPoints;
//            }
//        }

        for (Pancake pancake : pancakes) {
            if (pancake.mouseOverPancake()) {
                int plusPoints = pancake.getHit();
                if (plusPoints > 0) {
                    player.setHits(player.getHits() + 1);
                    points = points + plusPoints;
                }
            }
        }


    }
    //if (enemy2.mouseOverPancake()) {
    //   player.setHits(player.getHits() + 1);
    // }
}

