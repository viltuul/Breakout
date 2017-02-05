/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package breakout;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author ville
 */
public class KeyboardListener implements KeyListener {

    private Game game;

    public KeyboardListener(Game game) {
        this.game = game;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP) {

        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {

        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            game.getShuttle().setX(game.getShuttle().getX() - 1);
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            game.getShuttle().setX(game.getShuttle().getX() - 1);
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

}
