package breakout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

/**
 * Game's logic class.
 *
 * @author ville
 */
public class Game extends Timer implements ActionListener {

    private Ball ball;
    private Shuttle shuttle;
    private int size;
    private Level level;
    private boolean stop;
    private boolean gameOver;
    private int score;
    private GUI gui;
    private int diffuculty;

    /**
     * Creates the game. Sets the timer on the game, sets the size of the
     * platform, creates ball and places it on the middle of the game, creates
     * shuttle and places it on the bottom middlei of the game, creates list for
     * the Tiles and adds an actionlistener to the game.
     */
    public Game() {
        super(2, null);
        this.size = 800;
        this.gui = new GUI(this);
        SwingUtilities.invokeLater(gui);
        this.shuttle = new Shuttle();
        this.ball = new Ball();
        addActionListener(this);
        this.diffuculty = 0;
    }

    @Override
    public void start() {
        this.level = new Level(1);
        level.createTiles();
        ballStartingPosition();
        shuttle.setX(size / 2);
        shuttle.setY(size);
        shuttle.setHealth(3);
        this.stop = true;
        this.gameOver = false;
        this.score = 0;
        super.start();
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

    public int getScore() {
        return score;
    }

    public Level getLevel() {
        return level;
    }

    /**
     * Collisions the ball with the tiles. Changes the ball's speedY to -1 *
     * speedY
     */
    public void tileCollision() {
        for (Tile tile : level.getTiles()) {
            if (tile.getY() == ball.getY() && ball.getX() + 20 >= tile.getX() && ball.getX() + 20 <= tile.getX() + tile.getWidth()) {
                ball.setSpeedY(ball.getSpeedY() * (-1));
                tile.hit();
                if (tile.getHealth() < 1) {
                    tile.setX(size + 100);
                    score += 100;
                }
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
            if (ball.getSpeedY() > 0) {
                ball.setSpeedY(ball.getSpeedY() * (-1));
                if (ball.getX() + 40 <= shuttle.getX() + shuttle.getWidth() / 2) {
                    constant = (ball.getX() - shuttle.getX() + shuttle.getWidth() / 2) / shuttle.getWidth() / 2;
                    ball.setSpeedX(ball.getSpeedX() - constant);
                    System.out.println(ball.getSpeedX());
                } else {
                    constant = (ball.getX() - shuttle.getX()) / shuttle.getWidth() / 2;
                    ball.setSpeedX(ball.getSpeedX() + constant);
                    System.out.println(ball.getSpeedX());
                }
            }
        }
    }

    /**
     * Moves the ball and makes sure it doesn't go out of bounds
     */
    private void moveBall() {
        ball.move();
        ballOutOfBounds();
        tileCollision();
        shuttleCollision();
    }

    private void ballOutOfBounds() {
        if (ball.getX() + 30 >= size && ball.getSpeedX() > 0) {
            ball.setSpeedX(ball.getSpeedX() * -1);
        } else if (ball.getX() <= 0 && ball.getSpeedX() < 0) {
            ball.setSpeedX(ball.getSpeedX() * -1);
        }
        if (ball.getY() == size && ball.getSpeedY() > 0) {
            shuttle.loseHealth();
            if (shuttle.getHealth() == 0) {
                ball.setSpeedY(0);
                ball.setSpeedX(0);
                gui.youLose();
            } else {
                ball.setSpeedY(ball.getSpeedY() * -1);
            }
            // toDo gameOver
        } else if (ball.getY() <= 100 && ball.getSpeedY() < 0) {
            ball.setSpeedY(ball.getSpeedY() * -1);
        }
    }

    private void moveShuttle() {
        shuttle.move();
        shuttleOutOfBounds();
    }

    private void shuttleOutOfBounds() {
        if (shuttle.getX() <= 10) {
            shuttle.setX(10);
        } else if (shuttle.getX() >= size - shuttle.getWidth()) {
            shuttle.setX(size - shuttle.getWidth());
        }
    }

    public void update() {
        if (!stop) {
            moveBall();
            moveShuttle();
            if (level.checkTiles()){
                this.nextLevel();
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        update();
        gui.getPlatform().update();
        gui.updateData(score);

    }

    public boolean isStop() {
        return stop;
    }

    public void setStop(boolean stop) {
        this.stop = stop;
    }

    private void ballStartingPosition() {
        ball.setX(size / 2);
        ball.setY(size - 140);
        ball.setStartingSpeed();
    }

    public void nextLevel() {
        this.diffuculty = level.getDiffuculty() + 1;
        this.level = new Level(this.diffuculty);
        ballStartingPosition();
        score += 1000 * this.diffuculty;
    }

}
