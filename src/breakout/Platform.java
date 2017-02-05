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
public class Platform extends JPanel implements Updateable {

    private Game game;
    private Graphics graphics;

    public Platform(Game game) {
        this.game = game;
        super.setBackground(Color.white);
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
        graphics.setColor(Color.gray);
        graphics.fillOval(ball.getX(), ball.getY(), 5, 5);
    }

    private void drawShuttle() {
        Shuttle shuttle = game.getShuttle();
        graphics.setColor(Color.blue);
        graphics.fill3DRect(shuttle.getX(), shuttle.getY(), shuttle.getWidth(), 3, true);
    }

    private void drawTiles() {
        ArrayList<Tile> tiles = game.getTiles();
        graphics.setColor(Color.red);
        for (Tile tile : tiles) {
            graphics.draw3DRect(tile.getX(), tile.getY(), 5, 2, true);
        }
    }

    @Override
    public void update() {
        repaint();
    }

}
