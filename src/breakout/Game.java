/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package breakout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Timer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ville
 */
public class Game extends Timer implements ActionListener, Updateable {

    private Ball ball;
    private Shuttle shuttle;
    private ArrayList<Tile> tiles;
    private int size;

    public Game(int size) {
        super();
        this.ball = new Ball(size / 2, size / 2);
        this.shuttle = new Shuttle(size - 100, size - 100);
        this.tiles = new ArrayList();
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    public Ball getBall() {
        return ball;
    }

    public Shuttle getShuttle() {
        return shuttle;
    }

    public ArrayList<Tile> getTiles() {
        return tiles;
    }

    public void createTiles() {
        for (int i = 0; i < 20; i++) {
            tiles.add(new Tile(i * 40, 1));
            tiles.add(new Tile(i * 40, 10));
            tiles.add(new Tile(i * 40, 20));
        }
    }

    public void tileCollision() {
        for (Tile tile : tiles) {
            if (ball.getY() == tile.getY()) {
                ball.setSpeedY(ball.getSpeedY() * (-1));
            }
        }
    }

    @Override
    public void update() {
        ball.move();
        tileCollision();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

}
