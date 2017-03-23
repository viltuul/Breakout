/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package breakout;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 *
 * @author ville
 */
public class Platform extends JPanel {

    private Game game;
    private Graphics graphics;

    public Platform(Game game) {
        this.game = game;
        super.setBackground(Color.LIGHT_GRAY);
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        this.graphics = graphics;
        drawBall();
        drawShuttle();
        drawTiles();
    }

    private void drawBall() {
        Ball ball = game.getBall();
        graphics.setColor(Color.white);
        graphics.fillOval((int) ball.getX(), (int) ball.getY(), 40, 40);
    }

    private void drawShuttle() {
        Shuttle shuttle = game.getShuttle();
        graphics.setColor(Color.darkGray);
        graphics.fillOval(shuttle.getX(), shuttle.getY()-1, 24, 25);
        graphics.fillOval(shuttle.getX() + shuttle.getWidth() - 14, shuttle.getY()-1, 24, 25);
        graphics.setColor(Color.blue);
        graphics.fillRect(shuttle.getX() + 12, shuttle.getY(), shuttle.getWidth() - 12, 24);
        graphics.setColor(new Color(255,140,0));
        graphics.fill3DRect(shuttle.getX() + 24, shuttle.getY() + 16, shuttle.getWidth() - 36, 8, true);
    }

    private void drawTiles() {
        ArrayList<Tile> tiles = game.getTiles();
        graphics.setColor(Color.yellow);
        for (Tile tile : tiles) {
            graphics.fill3DRect(tile.getX(), tile.getY(), tile.getWidth(), 20, true);
        }
    }

    public void update() {
        repaint();
    }

}
