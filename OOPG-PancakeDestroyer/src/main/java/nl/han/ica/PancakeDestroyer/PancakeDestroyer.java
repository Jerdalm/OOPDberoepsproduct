package nl.han.ica.PancakeDestroyer;

import nl.han.ica.OOPDProcessingEngineHAN.Alarm.Alarm;
import nl.han.ica.OOPDProcessingEngineHAN.Alarm.IAlarmListener;
import nl.han.ica.OOPDProcessingEngineHAN.Dashboard.Dashboard;
import nl.han.ica.OOPDProcessingEngineHAN.Engine.GameEngine;
import nl.han.ica.OOPDProcessingEngineHAN.View.View;
import nl.han.ica.PancakeDestroyer.Pancakes.Pancake;
import nl.han.ica.waterworld.TextObject;
import processing.core.PApplet;

import java.util.ArrayList;

public class PancakeDestroyer extends GameEngine implements IAlarmListener {

    private int worldWidth;
    private int worldHeight;
    private final int gameTime = 120;
    private boolean gameOver = false;
    private boolean ditSpelVerdientEenTien = true;

    private ArrayList<TextObject> dashboardText = new ArrayList<>();

    private PancakeSpawner spawner;
    private Alarm endOfGame;
    private Player player;

    public static void main(String[] args) {
        PApplet.main(new String[]{"nl.han.ica.PancakeDestroyer.PancakeDestroyer"});
    }

    @Override
    public void setupGame() {
        worldWidth = 1280;
        worldHeight = 800;
        noCursor();
        startAlarm();

        createView(worldWidth, worldHeight, 255, 0, 255);
        createObjects();
        createDashboard(worldWidth, 150, worldWidth / 2 + 200, worldHeight - 150, 5);

        if (ditSpelVerdientEenTien) {
            System.out.println("Jeremy & Jeroen hebben een 10");
        }
    }

    @Override
    public void update() {
        if (gameOver == false) {
            updateDashboard();
            spawner.update();

            if (player.getBricks() == 0) {
                gameOver = true;
            }
        } else {
            gameOver();
        }
    }

    private void gameOver() {
        System.out.println("GameOVer");
    }


    private void createView(int worldWidth, int worldHeight, int r, int g, int b) {
        PApplet image = new PApplet();
        View view = new View(worldWidth, worldHeight);
        view.setBackground(image.loadImage("src/main/java/nl/han/ica/PancakeDestroyer/media/Background.png"));

        setView(view);
        size(worldWidth, worldHeight);
    }

    private void createObjects() {
        player = new Player(this);
        addGameObject(player, 0, 0, 5);
        spawner = new PancakeSpawner(this);
    }

    private void updateDashboard() {
        int thisMillis = millis() / 1000;
        dashboardText.get(0).setText("Bricks: " + player.getBricks());
        dashboardText.get(1).setText("Trown Bricks: " + player.getTrownBricks());
        dashboardText.get(2).setText("Points: " + player.getPoints());
        dashboardText.get(3).setText("Pancakes Hit: " + player.getHits());
        dashboardText.get(4).setText("Time Left: " + (gameTime - thisMillis));
    }

    private void createDashboard(int dashboardWidth, int dashboardHeight, int x, int y, int nText) {
        Dashboard dashboard = new Dashboard(x, y, dashboardWidth, dashboardHeight);
        dashboard.setBackground(138, 144, 150);
        for (int i = 0; i < nText; i++) {
            int yNew = -i * 30 + y;
            dashboardText.add(new TextObject(""));
            dashboardText.get(i).setX(-x + 5);
            dashboardText.get(i).setY(-yNew);
            dashboard.addGameObject(dashboardText.get(i));
        }
        addDashboard(dashboard, 1);
    }

    public void mousePressed() {
        if (player.getBricks() > 0) {
            player.setBricks(player.getBricks() - 1);
            player.setTrownBricks(player.getTrownBricks() + 1);
            int points = player.getPoints();
            for (Pancake pancake : spawner.getPancakes()) {
                if (pancake.mouseOverPancake()) {
                    int plusPoints = pancake.getHit();
                    if (plusPoints > -900) {
                        player.setBricks(player.getBricks() + 1);
                        player.setHits(player.getHits() + 1);
                        points = points + plusPoints;
                    } else {
                    }
                }
            }
            player.setPoints(points);
        }
    }

    public int getWorldWidth() {
        return worldWidth;
    }

    public int getWorldHeight() {
        return worldHeight;
    }

    private void startAlarm() {
        endOfGame = new Alarm("GameOver", gameTime);
        endOfGame.addTarget(this);
        endOfGame.start();
    }

    @Override
    public void triggerAlarm(String alarmName) {
        gameOver = true;
    }
}

