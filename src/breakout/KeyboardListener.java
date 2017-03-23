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

    private Shuttle shuttle;
    private Game game;

    public KeyboardListener(Game game) {
        this.shuttle = game.getShuttle();
        this.game = game;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            shuttle.setSpeedX(1.5);
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            shuttle.setSpeedX(-1.5);
        } else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            if (game.isStop()) {
                game.setStop(false);
            } else {
                game.setStop(true);
            }
        } else if (e.getKeyCode() == KeyEvent.VK_SHIFT) {
            game.getBall().setSpeedX(0);
            game.getBall().setSpeedY(game.getBall().getSpeedY() * -1);
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            shuttle.setSpeedX(0);
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            shuttle.setSpeedX(0);
        }
    }

}
