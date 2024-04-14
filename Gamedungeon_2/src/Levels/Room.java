package Levels;

import Entities.Player;
import utilz.Loadsave;

import java.awt.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class Room {
    private int data = 0;
    private int[] roomLayout;
    private int number = 0;
    private int xPosition, yPosition;
    private int tileSize = 16;
    private static BufferedImage roomStructur;
    BufferedImage image;
    Graphics2D g;

    public Room(int data){
        this.data = data;
        roomLayout = RoomGenerator.generate();
        createRoom();
    }

    public static void getImage(){
        Room.roomStructur = Loadsave.GetSpriteAtlas(Loadsave.Level_Atlas);
    }

    public void update(){

    }

    private void createRoom(){
        image = new BufferedImage(1960, 1080, BufferedImage.TYPE_INT_ARGB);
        g = image.createGraphics();
         // Render the room
        loadRoom(g);
        // Save the rendered room as an image
            try {
            File output = new File("rendered_room.png");
            ImageIO.write(image, "png", output);
            System.out.println("Room saved as: " + output.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }
        // Dispose of the graphics context
        g.dispose();
    }

    private void loadRoom(Graphics g){
        yPosition = 0;
        xPosition = 0;
        switch ((roomLayout[0] % 10)) {
            // Circle
            case 0:
                xPosition = 32 * (roomLayout[0] / 100000000);
                for (int z = 0; z < (roomLayout[0] % 100000000) / 1000000; z++) {
                    xPosition += tileSize;
                    g.drawImage(roomStructur.getSubimage(192, 32, 32, 32), xPosition, yPosition , tileSize, tileSize, null);
                }
                yPosition += tileSize;
                for (int i = 0; i < roomLayout.length; i++) {
                    xPosition = 0;
                    xPosition += tileSize * (roomLayout[i] / 100000000);
                    if (i + 1 < roomLayout.length){
                        if (roomLayout[1 + i] % 100000000 == (roomLayout[i] % 100000000) + 4 * 1000000){
                            g.drawImage(roomStructur.getSubimage(192, 32, 32,32), xPosition - tileSize, yPosition, tileSize, tileSize, null);
                        }
                    }
                    if (i - 1 >= 0){
                        if (roomLayout[i - 1] % 100000000 == (roomLayout[i] % 100000000) + 4 * 1000000){
                            g.drawImage(roomStructur.getSubimage(192, 32, 32,32), xPosition - tileSize , yPosition , tileSize, tileSize, null);
                        }
                    }
                    g.drawImage(roomStructur.getSubimage(192, 32, 32,32), xPosition , yPosition , tileSize, tileSize, null);
                    xPosition += tileSize;
                    for (int j = 0; j < (roomLayout[i] % 100000000) / 1000000; j++) {
                        g.drawImage(roomStructur.getSubimage(192, 0, 32,32), xPosition , yPosition , tileSize, tileSize, null);
                        xPosition += tileSize;
                    }
                    g.drawImage(roomStructur.getSubimage(192, 32, 32,32), xPosition , yPosition , tileSize, tileSize,null);
                    if (i + 1 < roomLayout.length){
                        if (roomLayout[1 + i] % 100000000 == (roomLayout[i] % 100000000) + 4 * 1000000){
                            g.drawImage(roomStructur.getSubimage(192, 32, 32,32), xPosition + tileSize , yPosition , tileSize, tileSize, null);
                        }
                    }
                    if (i - 1 >= 0){
                        if (roomLayout[i - 1] % 100000000 == (roomLayout[i] % 100000000) + 4 * 1000000){
                            g.drawImage(roomStructur.getSubimage(192, 32, 32,32), xPosition + tileSize , yPosition , tileSize, tileSize,null);
                        }
                    }
                    yPosition += tileSize;
                }
                xPosition = tileSize * (roomLayout[0] / 100000000);
                for (int z = 0; z < (roomLayout[0] % 100000000) / 1000000; z++) {
                    xPosition += tileSize;
                    g.drawImage(roomStructur.getSubimage(192, 32, 32,32), xPosition , yPosition , tileSize, tileSize, null);
                }
                break;
                // Square
            case 1:
                for (int z = -2; z < (roomLayout[0] % 100000000) / 1000000; z++) {
                    g.drawImage(roomStructur.getSubimage(192, 32, 32,32), xPosition , yPosition , tileSize, tileSize, null);
                    xPosition += tileSize;
                }
                yPosition += tileSize;
                for (int i = 0; i < roomLayout.length; i++) {
                    xPosition = 0;
                    g.drawImage(roomStructur.getSubimage(192, 32, 32,32), xPosition , yPosition , tileSize, tileSize, null);
                    xPosition += tileSize;
                    for (int j = 0; j < (roomLayout[i] % 100000000) / 1000000; j++) {
                        g.drawImage(roomStructur.getSubimage(192, 0, 32,32), xPosition , yPosition , tileSize, tileSize, null);
                        xPosition += tileSize;
                    }
                    g.drawImage(roomStructur.getSubimage(192, 32, 32,32), xPosition , yPosition, tileSize, tileSize,null);
                    yPosition += tileSize;
                }
                xPosition = 0;
                for (int z = -2; z < (roomLayout[0] % 100000000) / 1000000; z++) {
                    g.drawImage(roomStructur.getSubimage(192, 32,32,32), xPosition, yPosition, tileSize, tileSize,null);
                    xPosition += tileSize;
                }
                break;
                // Donut
            case 2:
                xPosition = tileSize * (roomLayout[0] / 100000000);
                for (int z = 0; z < (roomLayout[0] % 100000000) / 1000000; z++) {
                    xPosition += tileSize;
                    g.drawImage(roomStructur.getSubimage(192, 32, 32,32), xPosition , yPosition , tileSize, tileSize,null);
                }
                yPosition += tileSize;
                for (int i = 0; i < roomLayout.length; i++) {
                    xPosition = 0;
                    xPosition += tileSize * (roomLayout[i] / 100000000);
                    if (i + 1 < roomLayout.length){
                        if (roomLayout[1 + i] % 100000000 == (roomLayout[i] % 100000000) + 4 * 1000000){
                            g.drawImage(roomStructur.getSubimage(192, 32, 32,32), xPosition -tileSize , yPosition, tileSize, tileSize,null);
                        }
                    }
                    if (i - 1 >= 0){
                        if (roomLayout[i - 1] % 100000000 == (roomLayout[i] % 100000000) + 4 * 1000000){
                            g.drawImage(roomStructur.getSubimage(192, 32, 32,32), xPosition - tileSize, yPosition, tileSize, tileSize,null);
                        }
                    }
                    g.drawImage(roomStructur.getSubimage(192, 32, 32,32), xPosition, yPosition , tileSize, tileSize,null);
                    xPosition += tileSize;
                        for (int z = 0; z < (roomLayout[i] % 100000000) / 1000000; z++){
                            g.drawImage(roomStructur.getSubimage(192, 0, 32,32), xPosition, yPosition, tileSize, tileSize,null);
                            xPosition += tileSize;
                        }
                        if ( 0.1 < (roomLayout[i] % 1000000) / 10000) {
                            for (int z = 0; z < (roomLayout[i] % 1000000) / 10000; z++) {
                                g.drawImage(roomStructur.getSubimage(192, 32, 32,32), xPosition, yPosition, tileSize, tileSize,null);
                                xPosition += tileSize;
                            }
                            for (int v = 0; v < (roomLayout[i] % 100000000) / 1000000; v++) {
                                g.drawImage(roomStructur.getSubimage(192, 0,32,32), xPosition, yPosition, tileSize, tileSize,null);
                                xPosition += tileSize;
                            }
                        }
                    g.drawImage(roomStructur.getSubimage(192, 32, 32,32), xPosition, yPosition, tileSize, tileSize,null);
                    if (i + 1 < roomLayout.length){
                        if (roomLayout[1 + i] % 100000000 == (roomLayout[i] % 100000000) + 4 * 1000000){
                            g.drawImage(roomStructur.getSubimage(192, 32, 32,32), xPosition + tileSize, yPosition, tileSize, tileSize,null);
                        }
                    }
                    if (i - 1 >= 0){
                        if (roomLayout[i - 1] % 100000000 == (roomLayout[i] % 100000000) + 4 * 1000000){
                            g.drawImage(roomStructur.getSubimage(192, 32,32,32), xPosition + tileSize, yPosition, tileSize, tileSize,null);
                        }
                    }
                    yPosition += tileSize;
                }
                xPosition = tileSize * (roomLayout[0] / 100000000);
                for (int z = 0; z < (roomLayout[0] % 100000000) / 1000000; z++) {
                    xPosition += tileSize;
                    g.drawImage(roomStructur.getSubimage(192, 32, 32,32), xPosition, yPosition, tileSize, tileSize,null);
                }
        }
    }

    public void render(Graphics g){
        int yGlobal = Player.getyGlobalPosition();
        int xGlobal = Player.getxGlobalPosition();
        g.drawImage(image, xGlobal, yGlobal, 1960 * 4, 1080 * 4,null);
    }
}
