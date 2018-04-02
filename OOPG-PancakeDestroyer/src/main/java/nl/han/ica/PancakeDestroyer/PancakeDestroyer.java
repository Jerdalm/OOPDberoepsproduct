package nl.han.ica.PancakeDestroyer;

import javafx.scene.Cursor;
import nl.han.ica.OOPDProcessingEngineHAN.Dashboard.Dashboard;
import nl.han.ica.OOPDProcessingEngineHAN.Engine.GameEngine;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;
import nl.han.ica.OOPDProcessingEngineHAN.View.View;
import nl.han.ica.waterworld.TextObject;
import processing.core.PApplet;
import processing.core.PImage;

import java.util.ArrayList;
import java.util.Random;

public class PancakeDestroyer extends GameEngine {

    private int worldWidth;
    private int worldHeight;

    private ArrayList<Pancake> pancakes = new ArrayList<>();
    private ArrayList<TextObject> dashboardText = new ArrayList<>();

    private Player player;

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
        for (int i = 0; i < pancakes.size(); i++) {
            if (pancakes.get(i).getX() > worldWidth + 200 || pancakes.get(i).getX() < -200 ||
                    pancakes.get(i).getY() > worldHeight + 200 || pancakes.get(i).getY() < -200) {
                pancakes.remove(i);
            }
        }

    }

    private void spawnPancakes() {
        Random random = new Random();
        int type = random.nextInt(2);
        if (pancakes.size() < 5) {
            if (type == 0) {
                Pancake pancake = new FriendlyPancake(this);
                pancakes.add(pancake);
                addGameObject(pancake, 1);
            } else if (type == 1) {
                Pancake pancake = new NormalEnemy(this);
                pancakes.add(pancake);
                addGameObject(pancake, 1);
            }
        }
    }

    private void createView(int worldWidth, int worldHeight, int r, int g, int b) {
        PApplet image = new PApplet();
        View view = new View(worldWidth, worldHeight);
        //view.setBackground(r, g, b);
        view.setBackground(image.loadImage("src/main/java/nl/han/ica/PancakeDestroyer/media/Background.jpg"));

        setView(view);
        size(worldWidth, worldHeight);
    }

    private void createObjects() {
        player = new Player(this);
        addGameObject(player, 0, 0, 5);
    }

    private void updateDashboard() {
        dashboardText.get(0).setText("Bricks: " + player.getBricks());
        dashboardText.get(1).setText("Trown Bricks: " + player.getTrownBricks());
        dashboardText.get(2).setText("Points: " + player.getPoints());
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
        player.setBricks(player.getBricks() - 1);
        int points = player.getPoints();
        for (Pancake pancake : pancakes) {
            if (pancake.mouseOverPancake()) {
                int plusPoints = pancake.getHit();
                if (plusPoints > -900) {
                    player.setHits(player.getHits() + 1);
                    points = points + plusPoints;
                } else {
                }
            }
        }
        player.setPoints(points);
    }

    public int getWorldWidth() {
        return worldWidth;
    }

    public int getWorldHeight() {
        return worldHeight;
    }
}

