package breakout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Timer;

/**
 * Game's logic class.
 *
 * @author ville
 */
public class Game extends Timer implements ActionListener, Updateable {

    private Ball ball;
    private Shuttle shuttle;
    private ArrayList<Tile> tiles;
    private int size;
    private Updateable updateable;
    private boolean stop;

    /**
     * Creates the game. Sets the timer on the game, sets the size of the
     * platform, creates ball and places it on the middle of the game, creates
     * shuttle and places it on the bottom middlei of the game, creates list for
     * the Tiles and adds an actionlistener to the game.
     */
    public Game() {
        super(2, null);
        this.size = 800;
        this.ball = new Ball(size / 2, size / 2);
        this.shuttle = new Shuttle(size - 100, size - 100);
        this.tiles = new ArrayList();
        addActionListener(this);
        this.stop = false;
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

    /**
     * Creates tiles and adds them to the tiles list.
     */
    public void createTiles() {
        for (int i = 0; i < 8; i++) {
            tiles.add(new Tile(i * 100, 10));
            tiles.add(new Tile(i * 100, 20));
            tiles.add(new Tile(i * 100, 30));
        }
    }

    /**
     * Collisions the ball with the tiles. Changes the ball's speedY to -1 *
     * speedY
     */
    public void tileCollision() {
        for (Tile tile : tiles) {
            if (ball.getY() == tile.getY() && ball.getX() >= tile.getX() && ball.getX() <= tile.getX() + tile.getWidth()) {
                ball.setSpeedY(ball.getSpeedY() * (-1));
                tile.setX(size + 100);
            }
        }
    }

    /**
     * Collisions the ball with the shuttle. Changes the ball's speedY to -1*
     * speedY and also changes speedX according to the point of the shuttle
     * where the ball hit.
     */
    public void shuttleCollision() {
        Random rnd = new Random();
        double constant;
        if (ball.getY() + 35 == shuttle.getY() && ball.getX() + 40 >= shuttle.getX() && ball.getX() <= shuttle.getX() + shuttle.getWidth()) {
            ball.setSpeedY(ball.getSpeedY() * (-1));
            if (ball.getX() + 40 <= shuttle.getX() + shuttle.getWidth() / 2) {
                constant = (ball.getX()- shuttle.getX()+shuttle.getWidth()/2) / shuttle.getWidth() / 2;
                ball.setSpeedX(ball.getSpeedX() - constant);
                System.out.println(ball.getSpeedX());
            } else {
                constant = (ball.getX() - shuttle.getX()) / shuttle.getWidth() / 2;
                ball.setSpeedX(ball.getSpeedX() + constant);
                System.out.println(ball.getSpeedX());
            }
//        } else if (ball.getY() == shuttle.getY() && ball.getX() <= shuttle.getX() + shuttle.getWidth() && ball.getX() >= shuttle.getX()) {
//            ball.setSpeedY(ball.getSpeedY() * (-1));
//            ball.setSpeedX(ball.getSpeedX() + 0.1);
        }
    }
/**
 * Moves the ball and makes sure it doesn't go out of bounds
 */
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

    public boolean isStop() {
        return stop;
    }

    public void setStop(boolean stop) {
        this.stop = stop;
    }

}
