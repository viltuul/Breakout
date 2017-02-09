/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package breakout;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

/**
 *
 * @author ville
 */
public class GUI implements Runnable {

    private JFrame frame;
    private Game game;
    private Platform platform;

    public GUI(Game game) {
        this.game = game;
        this.platform = new Platform(game);
    }

    @Override
    public void run() {
        frame = new JFrame("Breakout");
        int width = (game.getSize());
        int height = (game.getSize());
        frame.setPreferredSize(new Dimension(width, height));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        createComponents(frame.getContentPane());
        frame.pack();
        frame.setVisible(true);
    }

    public void createComponents(Container container) {
        container.add(platform);
        KeyboardListener listener = new KeyboardListener(game.getShuttle());
        frame.addKeyListener(listener);
    }

    public JFrame getFrame() {
        return frame;
    }

    public Updateable getUpdateable() {
        return platform;
    }

}
