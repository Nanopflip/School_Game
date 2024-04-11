package Levels;

import utilz.Loadsave;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Room {
    private int data = 0;
    private int[] roomLayout;
    private int number = 0;
    private int xPosition, yPosition;
    private static BufferedImage roomStructur;

    public Room(int data){
        this.data = data;
        roomLayout = RoomGenerator.generate();
    }

    public static void getImage(){
        Room.roomStructur = Loadsave.GetSpriteAtlas(Loadsave.Level_Atlas);
    }

    public void update(){

    }
    public void render(Graphics g){
        switch ((roomLayout[0] % 10)) {
            // Circle
            case 0:
                xPosition = 32 * (roomLayout[0] / 100000000);
                for (int z = 0; z < (roomLayout[0] % 100000000) / 1000000; z++) {
                    xPosition += 32;
                    g.drawImage(roomStructur.getSubimage(192, 32, 32, 32), xPosition, yPosition, null);
                }
                yPosition += 32;
                for (int i = 0; i < roomLayout.length; i++) {
                    xPosition = 0;
                    xPosition += 32 * (roomLayout[i] / 100000000);
                    g.drawImage(roomStructur.getSubimage(192, 32, 32, 32), xPosition, yPosition, null);
                    xPosition += 32;
                    for (int j = 0; j < (roomLayout[i] % 100000000) / 1000000; j++) {
                        g.drawImage(roomStructur.getSubimage(192, 0, 32, 32), xPosition, yPosition, null);
                        xPosition += 32;
                    }
                    g.drawImage(roomStructur.getSubimage(192, 32, 32, 32), xPosition, yPosition, null);
                    yPosition += 32;
                }
                xPosition = 32 * (roomLayout[0] / 100000000);
                for (int z = 0; z < (roomLayout[0] % 100000000) / 1000000; z++) {
                    xPosition += 32;
                    g.drawImage(roomStructur.getSubimage(192, 32, 32, 32), xPosition, yPosition, null);
                }
                break;
                // Square
            case 1:
                for (int z = -2; z < (roomLayout[0] % 100000000) / 1000000; z++) {
                    g.drawImage(roomStructur.getSubimage(192, 32, 32, 32), xPosition, yPosition, null);
                    xPosition += 32;
                }
                yPosition += 32;
                for (int i = 0; i < roomLayout.length; i++) {
                    xPosition = 0;
                    g.drawImage(roomStructur.getSubimage(192, 32, 32, 32), xPosition, yPosition, null);
                    xPosition += 32;
                    for (int j = 0; j < (roomLayout[i] % 100000000) / 1000000; j++) {
                        g.drawImage(roomStructur.getSubimage(192, 0, 32, 32), xPosition, yPosition, null);
                        xPosition += 32;
                    }
                    g.drawImage(roomStructur.getSubimage(192, 32, 32, 32), xPosition, yPosition, null);
                    yPosition += 32;
                }
                xPosition = 0;
                for (int z = -2; z < (roomLayout[0] % 100000000) / 1000000; z++) {
                    g.drawImage(roomStructur.getSubimage(192, 32, 32, 32), xPosition, yPosition, null);
                    xPosition += 32;
                }
                break;
                // Donut
            case 2:
                xPosition = 32 * (roomLayout[0] / 100000000);
                for (int z = 0; z < (roomLayout[0] % 100000000) / 1000000; z++) {
                    xPosition += 32;
                    g.drawImage(roomStructur.getSubimage(192, 32, 32, 32), xPosition, yPosition, null);
                }
                yPosition += 32;
                for (int i = 0; i < roomLayout.length; i++) {
                    xPosition = 0;
                    xPosition += 32 * (roomLayout[i] / 100000000);
                    g.drawImage(roomStructur.getSubimage(192, 32, 32, 32), xPosition, yPosition, null);
                    xPosition += 32;
                    for (int j = 0; j < (roomLayout[i] % 100000000) / 1000000; j++) {
                        if (j + 1 > (roomLayout[i] % 100000000) / 1000000 && 0.1 < (roomLayout[i] % 1000000) / 10000){
                            for (int z = 0; z < (roomLayout[i] % 1000000) / 10000; z++){
                                g.drawImage(roomStructur.getSubimage(192, 32, 32, 32), xPosition, yPosition, null);
                                xPosition += 32;
                            }
                            for (int v = 0; v < (roomLayout[i] % 100000000) / 1000000; v++) {
                                g.drawImage(roomStructur.getSubimage(192, 0, 32, 32), xPosition, yPosition, null);
                                xPosition += 32;
                            }
                        } else {
                            g.drawImage(roomStructur.getSubimage(192, 0, 32, 32), xPosition, yPosition, null);
                            xPosition += 32;
                        }
                    }
                    g.drawImage(roomStructur.getSubimage(192, 32, 32, 32), xPosition, yPosition, null);
                    yPosition += 32;
                }
                yPosition += 32;
                xPosition = 0;
        }
    }
}
