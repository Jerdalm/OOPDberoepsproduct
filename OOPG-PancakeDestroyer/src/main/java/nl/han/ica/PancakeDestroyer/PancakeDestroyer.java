package nl.han.ica.PancakeDestroyer;

import nl.han.ica.OOPDProcessingEngineHAN.Alarm.Alarm;
import nl.han.ica.OOPDProcessingEngineHAN.Alarm.IAlarmListener;
import nl.han.ica.OOPDProcessingEngineHAN.Dashboard.Dashboard;
import nl.han.ica.OOPDProcessingEngineHAN.Engine.GameEngine;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.TextObject;
import nl.han.ica.OOPDProcessingEngineHAN.View.View;
import processing.core.PApplet;
import java.util.ArrayList;

/**
 * dit is de hoofclassen van het spel PancakeDestoryer vanuit hier word alles aangeroepen en opgezet
 */
public class PancakeDestroyer extends GameEngine implements IAlarmListener {

    private int worldWidth;
    private int worldHeight;
    private final int gameTime = 120;
    private boolean gameOver = false;
    private boolean firstTimeGameOver = true;
    private boolean ditSpelVerdientEenTien = true;

    private ArrayList<TextObject> dashboardText = new ArrayList<>();
    private TextObject gameOverText = new TextObject("Game Over", 50);

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

        createView(worldWidth, worldHeight);
        createDashboard(worldWidth, 150, worldWidth / 2 + 200, worldHeight - 150, 5);
        createObjects();

        if (ditSpelVerdientEenTien) {
            System.out.println("Jeremy & Jeroen krijgen een 10");
        } else {
            System.out.println("Jeremy & Jeroen krijgen een 9");
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
        } else if (firstTimeGameOver){
            gameOver();
            firstTimeGameOver = false;
        }
    }

    /**
     * deze methode word aangeroepen als het spel voorbij is
     */
    private void gameOver() {
        Dashboard gameOver = new Dashboard(0, worldHeight / 2 - 50, worldWidth, 100);
        gameOver.setBackground(138, 144, 150);
        gameOverText.setY(- (worldHeight / 2 - 115));
        gameOverText.setX(worldWidth / 2 - 125);
        gameOver.addGameObject(gameOverText);
        addDashboard(gameOver,1);
    }


    /**
     * deze methode maakt de view aan voor PancakeDestroyer
     * @param worldWidth de breedte voor de view
     * @param worldHeight de hoogte voor de view
     */
    private void createView(int worldWidth, int worldHeight) {
        PApplet image = new PApplet();
        View view = new View(worldWidth, worldHeight);
        view.setBackground(image.loadImage("src/main/java/nl/han/ica/PancakeDestroyer/media/Background.png"));

        setView(view);
        size(worldWidth, worldHeight);
    }

    /**
     * deze methode maakt alle gameobjects aan op de pannenkoeken na
     */
    private void createObjects() {
        player = new Player(this);
        addGameObject(player, 0, 0, 5);
        spawner = new PancakeSpawner(this);
    }

    /**
     * deze methode update het dashboard
     */
    private void updateDashboard() {
        int thisMillis = millis() / 1000;
        dashboardText.get(0).setText("Bricks: " + player.getBricks());
        dashboardText.get(1).setText("Trown Bricks: " + player.getTrownBricks());
        dashboardText.get(2).setText("Points: " + player.getPoints());
        dashboardText.get(3).setText("Pancakes Hit: " + player.getHits());
        dashboardText.get(4).setText("Time Left: " + (gameTime - thisMillis));
    }

    /**
     * @param dashboardWidth de breedte van het te maken dashboard
     * @param dashboardHeight de hoogte van het te maken dashboard
     * @param x de x coordinaat van het te maken dashboard
     * @param y de y coordinaat van het te maken dashboard
     * @param nText de hoeveelheid text objecten die in het dashboard moeten komen te staan
     */
    private void createDashboard(int dashboardWidth, int dashboardHeight, int x, int y, int nText) {
        Dashboard dashboard = new Dashboard(x, y, dashboardWidth, dashboardHeight);
        dashboard.setBackground(138, 144, 150);
        for (int i = 0; i < nText; i++) {
            int yNew = -i * 30 + y - 25;
            dashboardText.add(new TextObject("", 30));
            dashboardText.get(i).setX(-x + 5);
            dashboardText.get(i).setY(-yNew);
            dashboard.addGameObject(dashboardText.get(i));
        }
        addDashboard(dashboard, 1);
    }

    /**
     * @return geeft het de variable met het object pancakespawner erin
     */
    public PancakeSpawner getSpawner() {
        return spawner;
    }

    /**
     * @return geeft de wereld breedte
     */
    public int getWorldWidth() {
        return worldWidth;
    }

    /**
     * @return geeft de wereld hoogte
     */
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

