/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package breakout;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;

/**
 *
 * @author ville
 */
public class Breakout {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Game game = new Game(800);
        GUI gui = new GUI(game);
        SwingUtilities.invokeLater(gui);
        game.createTiles();
        game.start();
//        while (true) {
//            game.update();
//            gui.getUpdateable().update();
//            try {
//                Thread.sleep(8);
//            } catch (InterruptedException ex) {
//                Logger.getLogger(Breakout.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
    }

}
