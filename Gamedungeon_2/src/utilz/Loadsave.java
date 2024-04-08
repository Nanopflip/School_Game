package utilz;

import main.Game;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

public class Loadsave {
    public static final String Player_Atlas = "";
    public static final String Level_Atlas = "/res/1.jpg";
    public static final String Level_One_Data = "/res/2.jpg";

    public static BufferedImage GetSpriteAtlas(String filename){
        BufferedImage img = null;
        InputStream is = Loadsave.class.getResourceAsStream(filename);
        try {
             img = ImageIO.read(is);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e){
                e.printStackTrace();
            }
        }
        return img;
    }
}
