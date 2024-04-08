package Levels;

import main.Game;
import utilz.Loadsave;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Levelmanager {
    private Game game;
    private Levelgenerator levelgenerator;
    private BufferedImage[] levelSprite;
    private int currentLevel = 0;
    private int[] currentstage = new int[2];
    public Levelmanager(Game game){
        this.game = game;
        levelgenerator = new Levelgenerator();
        createLevel();
    }

    public void createLevel(){
        switch (currentLevel){
            case 0:
                LevelOne levelOne = new LevelOne(game, levelgenerator);
        }
    }

    public void update(){

    }

    public int getCurrentLevel() {
        return currentLevel;
    }

    public void setCurrentLevel(int current_level) {
        this.currentLevel = current_level;
    }
}
