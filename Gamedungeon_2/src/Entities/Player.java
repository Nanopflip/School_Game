package Entities;

import utilz.Loadsave;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import static utilz.Constans.PlayerConstans.*;
import static utilz.Constans.Directions.*;


public class Player extends Entity{
    private BufferedImage img;
    private int aniTick, aniIndex, aniCalc = 1, aniSpeed = 15;
    private int playerAction = IDLE;
    private boolean left, right, up , down;
    private static int xGlobalPosition, yGlobalPosition;
    private float playerSpeed = 2.0f;
    private boolean moving = false;
    private boolean aniWait = false;

    public Player(float x, float y) {
        super(x, y);
        loadAnimations();
    }

    public void update(){
        updatePos();
        //updateAnimationTick();
        //setAnimation();
    }
    public void render(Graphics g){
        g.drawImage(img,980,540, 144, 144, null);
    }

    private void updateAnimationTick(){
        aniTick++;
        /*if (aniTick >= aniSpeed){
            aniTick = 0;
            if (aniWait){
                aniWait = false;
            } else {
                aniIndex += aniCalc;
                if (aniIndex >= idleAni.length-1 || aniIndex <= 0){
                    aniCalc *= -1;
                    aniWait = true;
                }
            }
                   }
        aniSpeed = 10;
        if (aniTick >= aniSpeed) {
            aniTick = 0;
            if (aniWait) {
                aniWait = false;
            } else {
                aniIndex += 1;
                if (aniIndex > animations[playerAction].length) {
                    aniIndex = 0;
                }
            }
        }

         */
    }

    private void loadAnimations() {
            img = Loadsave.GetSpriteAtlas(Loadsave.Level_Atlas);
            /*
            animations = new BufferedImage[3][3];
            for (int j = 0; j < animations.length; j++) {
                for (int i = 0; i < animations[j].length; i++) {
                    animations[j][i] = img.getSubimage(i * 144, j * 144, 144, 144);
                }
            }
                         */
    }

    private void setAnimation(){
        if(moving){
            playerAction = RUNNING;
        } else {
            playerAction = IDLE;
        }
    }

    private void updatePos(){
        moving = false;
        if (left && !right){
            x-= playerSpeed;
            moving = true;
            xGlobalPosition += 1;
        } else if (right && !left) {
            x+= playerSpeed;
            moving = true;
            xGlobalPosition -= 1;
        }
        if (up && !down){
            y-= playerSpeed;
            moving = true;
            yGlobalPosition += 1;
        } else if (down && !up) {
            y+= playerSpeed;
            moving = true;
            yGlobalPosition -= 1;
        }
    }

    public void resetDirBooleans(){
        left = false;
        right = false;
        up = false;
        down = false;
    }

    public void setRight(boolean input){
        this.right = input;
    }
    public void setLeft(boolean input){
        this.left = input;
    }
    public void setDown(boolean input){
        this.down = input;
    }
    public void setUp(boolean input){
        this.up = input;
    }

    public static int getxGlobalPosition(){
        return xGlobalPosition;
    }

    public static int getyGlobalPosition(){
        return yGlobalPosition;
    }
}
