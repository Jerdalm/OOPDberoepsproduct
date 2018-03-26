package nl.han.ica.SSDXTDT;

import nl.han.ica.OOPDProcessingEngineHAN.Engine.GameEngine;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;
import nl.han.ica.OOPDProcessingEngineHAN.Tile.TileMap;
import nl.han.ica.OOPDProcessingEngineHAN.Tile.TileType;
import nl.han.ica.OOPDProcessingEngineHAN.View.View;
import nl.han.ica.SSDXTDT.Tiles.VoidTile;
import nl.han.ica.waterworld.tiles.BoardsTile;
import processing.core.PApplet;



public class SSDXTDT extends GameEngine{
    private final int SCREEN_WIDTH = 1000;
    private final int SCREEN_HEIGHT = 800;
    TileMap tiles;

    public static void main(String[] args) {
        PApplet.main(new String[]{"nl.han.ica.SSDXTDT.SSDXTDT"});
    }

    @Override
    public void setupGame() {
        int world[][]={
                {0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0},
        };
        setupWorld(world);

        setupView();
    }
    /**
     * @param world A 2d array of what tiles to use where:
     *              0: VoidTile
     *              1: TowerTile
     *              2: StraightPathTile
     */
    private void setupWorld(int[][] world){
/*
        Sprite boardsSprite = new Sprite("src/main/java/nl/han/ica/waterworld/media/boards.jpg");
        TileType<VoidTile> boardTileType = new TileType<>(VoidTile.class, boardsSprite);

        TileType[] tileTypes = { boardTileType };
        //int tileSize=50;
        /*
        int tilesMap[][]={
                {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
                {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
                {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
                {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
                {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
                {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
                {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
                {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
                {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
                {-1,-1,-1, 0, 0, 0, 0,-1,0 , 0},
                {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
                {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
                {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
                {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1}
        };
        tileMap = new TileMap(tileSize, tileTypes, tilesMap);
        */
        if (world.length>0) {//if the array is not empty
            //laad de sprites in
            Sprite voidSprite = new Sprite("src/main/java/nl/han/ica/SSDXTDT/resources/tiles/VoidTile.png");
            TileType<VoidTile> VoidTileType = new TileType<>(VoidTile.class, voidSprite);
            TileType[] tileTypes = {VoidTileType};

            //get the usable size to draw the world
            int worldWidth = SCREEN_WIDTH;
            int worldHeight = SCREEN_HEIGHT - UI_getBarHeight();
            //get the max width and height of each tile
            int tileHeight = worldHeight / world.length;
            int tileWidth = worldWidth / world[0].length;
            int tileSize = min(tileHeight, tileWidth);//the tiles should be square so take the minimum as a final size.
            tileMap = new TileMap(tileSize, tileTypes, world);//generate tilemap
        }


    }

    private void setupView(){
        View view = new View(SCREEN_WIDTH,SCREEN_HEIGHT);
        setView(view);
        size(SCREEN_WIDTH, SCREEN_HEIGHT);

    }

    @Override
    public void update() {

    }



    //UI:

    private int UI_getBarHeight(){
        return 100;
    }



}
