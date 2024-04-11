package Levels;

import main.Game;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Levelmanager {
    private Game game;
    private Levelgenerator levelgenerator;
    private RoomGenerator roomGenerator;
    private BufferedImage[] levelSprite;
    private static int currentLevel = 0;
    private int[] currentstage = new int[2];
    public Levelmanager(Game game){
        this.game = game;
        createLevel();
    }

    public void createLevel(){
        switch (currentLevel){
            case 0:
                LevelOne levelOne = new LevelOne(game);
        }
    }

    public void update(){

    }

    public static void render(Graphics g){
          LevelOne.render(g);
    }

    public static int getCurrentLevel() {
        return currentLevel;
    }

    public static void setCurrentLevel(int current_level) {
        Levelmanager.currentLevel = current_level;
    }
}
