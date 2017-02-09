/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package breakout;

import static com.sun.java.accessibility.util.AWTEventMonitor.addActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Timer;

/**
 *
 * @author ville
 */
public class Game extends Timer implements ActionListener, Updateable {

    private Ball ball;
    private Shuttle shuttle;
    private ArrayList<Tile> tiles;
    private int size;
    private Updateable updateable;

    public Game(int size) {
        super(8, null);
        this.ball = new Ball(size / 2, size / 2);
        this.shuttle = new Shuttle(size - 100, size - 100);
        this.tiles = new ArrayList();
        this.size = size;
        addActionListener(this);
    }

    public void setUpdateable(Updateable updateable) {
        this.updateable = updateable;
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
            tiles.add(new Tile(i * 40, 10));
            tiles.add(new Tile(i * 40, 20));
            tiles.add(new Tile(i * 40, 30));
        }
    }

    public void tileCollision() {
        for (Tile tile : tiles) {
            if (ball.getY() == tile.getY() && ball.getX() >= tile.getX() && ball.getX() <= tile.getX() + tile.getWidth()) {
                ball.setSpeedY(ball.getSpeedY() * (-1));
                tile.setX(size + 100);
            }
        }
    }

    public void shuttleCollision() {
        Random rnd = new Random();
        if (ball.getY() == shuttle.getY() && ball.getX() >= shuttle.getX() - shuttle.getWidth() && ball.getX() <= shuttle.getX()) {
            ball.setSpeedY(ball.getSpeedY() * (-1));
            ball.setSpeedX(ball.getSpeedX() - 1);
        } else if (ball.getY() == shuttle.getY() && ball.getX() <= shuttle.getX() + shuttle.getWidth() && ball.getX() >= shuttle.getX()) {
            ball.setSpeedY(ball.getSpeedY() * (-1));
            ball.setSpeedX(ball.getSpeedX() + 1);
        }
    }

    private void moveBall() {
        ball.move();
        if (ball.getX() >= size && ball.getSpeedX() > 0) {
            ball.setSpeedX(ball.getSpeedX() * -1);
        } else if (ball.getX() <= 0 && ball.getSpeedX() < 0) {
            ball.setSpeedX(ball.getSpeedX() * -1);
        }
        if (ball.getY() == size && ball.getSpeedY() > 0) {
            ball.setSpeedY(ball.getSpeedY() * -1);
        } else if (ball.getY() == 0 && ball.getSpeedY() < 0) {
            ball.setSpeedY(ball.getSpeedY() * -1);
        }
    }

    @Override
    public void update() {
        moveBall();
        tileCollision();
        shuttleCollision();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        update();
        updateable.update();

    }
}
