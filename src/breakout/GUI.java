package breakout;

import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

/**
 * Graphical user interface
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
        frame.setPreferredSize(new Dimension(width + 50, height + 50));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        createComponents(frame.getContentPane());
        frame.pack();
        frame.setVisible(true);
    }

    public void createComponents(Container container) {
        container.add(platform);
        KeyboardListener listener = new KeyboardListener(game);
        frame.addKeyListener(listener);
    }

    public JFrame getFrame() {
        return frame;
    }

    public Updateable getUpdateable() {
        return platform;
    }

}
