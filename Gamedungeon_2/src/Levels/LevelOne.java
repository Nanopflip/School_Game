package Levels;

import main.Game;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Arrays;

public class LevelOne {
    private Game game;
    private Levelgenerator levelgenerator;
    private BufferedImage[][] levelImages = new BufferedImage[5][5];
    private static Room[] levelRooms;
    private static int[][] level = new int[5][5];
    private static int currentRoom = 0;
    public LevelOne(Game game){
        this.game = game;
        level = Levelgenerator.generate(level);
        System.out.println(Arrays.deepToString(level));
        generateRooms();
    }

    private void generateRooms(){
        int counter = 0;
        for (int i = 0; i < level.length; i++){
            for (int j = 0; j < level[i].length; j++){
                if (level[i][j] != 0){
                    counter++;
                }
            }
        }
        levelRooms = new Room[counter];
        Room.getImage();
        counter = 0;
        for (int i = 0; i < level.length; i++){
            for (int j = 0; j < level[i].length; j++){
                if (level[i][j] != 0){
                    levelRooms[counter] = new Room(level[i][j]);
                }
            }
        }
    }


    public void update(){
        levelRooms[currentRoom].update();
    }

    public static void render(Graphics g){
        levelRooms[currentRoom].render(g);
    }
}
