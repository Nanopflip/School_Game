package Levels;

import main.Game;

import java.awt.image.BufferedImage;
import java.util.Arrays;

public class LevelOne {
    private Game game;
    private Levelgenerator levelgenerator;
    private BufferedImage[][] levelImages = new BufferedImage[5][5];
    private int[][] level = new int[5][5];
    public LevelOne(Game game, Levelgenerator levelgenerator){
        this.game = game;
        this.levelgenerator = levelgenerator;
        level = levelgenerator.generate(level);
        System.out.println(Arrays.deepToString(level));
    }

    public void update(){

    }
}
