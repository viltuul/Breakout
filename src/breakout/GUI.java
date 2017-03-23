package breakout;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;

/**
 * Graphical user interface
 *
 * @author ville
 */
public class GUI implements Runnable {

    private JFrame frame;
    private Game game;
    private Platform platform;
    private JPanel scorePanel;
    private JLabel scoreLabel;

    public GUI(Game game) {
        this.game = game;
        this.platform = new Platform(game);
        this.scorePanel = new JPanel();
        this.scoreLabel = new JLabel("Score: 0");
    }

    @Override
    public void run() {
        frame = new JFrame("Breakout");
        BorderLayout layout = new BorderLayout();
        frame.setPreferredSize(new Dimension(game.getSize() + 20, game.getSize() + 170));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        layout.addLayoutComponent(platform, BorderLayout.SOUTH);
        layout.addLayoutComponent(scorePanel, BorderLayout.NORTH);

        platform.setLocation(0, 100);
        platform.setSize(game.getSize() + 20, game.getSize() + 100);
        frame.add(platform);

        scorePanel.setLocation(0, 0);
        scorePanel.setSize(game.getSize(), 50);
        scorePanel.setBackground(Color.black);
        scoreLabel.setForeground(Color.green);
        frame.add(scorePanel);

        KeyboardListener listener = new KeyboardListener(game);
        frame.addKeyListener(listener);

        frame.pack();
        frame.setVisible(true);

    }

    public JFrame getFrame() {
        return frame;
    }

    public Platform getPlatform() {
        return platform;
    }

    public void updateData(int score) {
        scoreLabel.setFont(new Font("Serif", Font.BOLD, 60));
        scoreLabel.setText("Hp: " + game.getShuttle().getHealth() + "  Score: " + score);
        scorePanel.add(scoreLabel);
        frame.add(scorePanel);
    }

    public void youLose() {
        JOptionPane.showMessageDialog(null, "GAME OVER, points: " + game.getScore());
        game.restart();
    }

}
