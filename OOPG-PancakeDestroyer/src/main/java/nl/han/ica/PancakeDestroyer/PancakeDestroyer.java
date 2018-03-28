package nl.han.ica.PancakeDestroyer;

import nl.han.ica.OOPDProcessingEngineHAN.Dashboard.Dashboard;
import nl.han.ica.OOPDProcessingEngineHAN.Engine.GameEngine;
import nl.han.ica.OOPDProcessingEngineHAN.View.View;
import nl.han.ica.waterworld.TextObject;
import processing.core.PApplet;

public class PancakeDestroyer extends GameEngine{

    private TextObject dashboardText;
    private int test = 0;

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

        createDashboard(worldWidth, 200);

    }

    @Override
    public void update() {
        test ++;
        dashboardText.setText("Bubbles popped: " + test);
    }

    private void createDashboard(int dashboardWidth,int dashboardHeight) {
        Dashboard dashboard = new Dashboard(0,0, dashboardWidth, dashboardHeight);
        dashboard.setBackground(138,144,150);
        dashboardText=new TextObject("");
        dashboard.addGameObject(dashboardText);
        addDashboard(dashboard);
    }


}
