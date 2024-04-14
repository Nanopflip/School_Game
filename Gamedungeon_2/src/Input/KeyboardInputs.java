package Input;

import Entities.Player;
import main.Game;
import main.GamePanel;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import static utilz.Constans.Directions.*;
public class KeyboardInputs implements KeyListener {
    private GamePanel gamePanel;
    public  KeyboardInputs(GamePanel gamePanel){
        this.gamePanel = gamePanel;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()){
            case KeyEvent.VK_D:
                GamePanel.getGame().getPlayer().setRight(true);
                break;
            case KeyEvent.VK_W:
                GamePanel.getGame().getPlayer().setUp(true);
                break;
            case KeyEvent.VK_S:
                GamePanel.getGame().getPlayer().setDown(true);
                break;
            case KeyEvent.VK_A:
                GamePanel.getGame().getPlayer().setLeft(true);
                break;

        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()){
            case KeyEvent.VK_D:
                GamePanel.getGame().getPlayer().setRight(false);
                break;
            case KeyEvent.VK_W:
                GamePanel.getGame().getPlayer().setUp(false);
                break;
            case KeyEvent.VK_S:
                GamePanel.getGame().getPlayer().setDown(false);
                break;
            case KeyEvent.VK_A:
                GamePanel.getGame().getPlayer().setLeft(false);
                break;

        }
    }

}
