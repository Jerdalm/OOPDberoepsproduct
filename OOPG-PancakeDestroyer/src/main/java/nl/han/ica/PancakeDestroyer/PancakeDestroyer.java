package nl.han.ica.PancakeDestroyer;

import nl.han.ica.OOPDProcessingEngineHAN.Dashboard.Dashboard;
import nl.han.ica.OOPDProcessingEngineHAN.Engine.GameEngine;
import nl.han.ica.OOPDProcessingEngineHAN.View.View;
import nl.han.ica.waterworld.TextObject;
import processing.core.PApplet;

import java.util.ArrayList;

public class PancakeDestroyer extends GameEngine{

    private ArrayList<TextObject> dashboardText = new ArrayList<TextObject>();
    private int bricks = 8;
    Player player;

    public static void main(String[] args) {
        PApplet.main(new String[]{"nl.han.ica.PancakeDestroyer.PancakeDestroyer"});
    }

    @Override
    public void setupGame() {
        int worldWidth=1200;
        int worldHeight=800;

        View view = new View(1000, 1000);
        setView(view);
        size(worldWidth, worldHeight);

         player = new Player(this);
         player.resize()

        createDashboard(worldWidth, 150, worldWidth / 2, worldHeight-150);

    }

    @Override
    public void update() {
            addGameObject(player, mouseX, mouseY);
            dashboardText.get(0).setText("Bricks: " + bricks);
            dashboardText.get(1).setText("hoooooiiii");
            dashboardText.get(2).setText("hoi jeremy");
    }

    public void mousePressed() {
        bricks--;
    }

    private void createDashboard(int dashboardWidth,int dashboardHeight, int x, int y) {
        Dashboard dashboard = new Dashboard(x, y, dashboardWidth, dashboardHeight);
        dashboard.setBackground(138,144,150);
        for (int i = 0; i < 3; i ++) {
            int yNew= - i * 50 + y;
            dashboardText.add(new TextObject(""));
            dashboardText.get(i) .setX(-x);
            dashboardText.get(i) .setY(-yNew);
            dashboard.addGameObject(dashboardText.get(i));
        }
        addDashboard(dashboard);
    }


}
