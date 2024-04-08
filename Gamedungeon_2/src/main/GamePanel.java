package main;

import Input.KeyboardInputs;
import Input.MouseInputs;


import javax.swing.JPanel;
import java.awt.*;




public class GamePanel extends JPanel {
    private MouseInputs mouseInputs;
    private Game game;

    public GamePanel(Game game){
       mouseInputs = new MouseInputs(this);
       this.game = game;
       setPanelSize();
       addKeyListener(new KeyboardInputs(this));
       addMouseListener(mouseInputs);
       addMouseMotionListener(mouseInputs);
    }


    private void setPanelSize(){
        Dimension size = new Dimension(400, 400);
        setPreferredSize(size);
    }

    public void updateGame(){
    }


    public void paintComponent(Graphics g){
        super.paintComponent(g);
        game.render(g);
    }

    public Game getGame(){
        return game;
    }

}
