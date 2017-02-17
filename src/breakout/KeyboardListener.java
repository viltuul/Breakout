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

    public KeyboardListener(Shuttle shuttle) {
        this.shuttle = shuttle;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            shuttle.setX(shuttle.getX() + 25);
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            shuttle.setX(shuttle.getX() - 25);
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

}
