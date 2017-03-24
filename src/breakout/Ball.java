package breakout;

import java.util.Random;

/**
 * Class that has location of the ball and it's speed.
 *
 * @author ville
 */
public class Ball {

    private double x;
    private double y;
    private double speedX;
    private double speedY;

    /**
     * Creates the ball in desired location and sets a random speed for it
     *
     * @param x the x coordinate of the created ball.
     * @param y the y coordinate of the created ball.
     */
    public Ball() {
        this.x = 0;
        this.y = 0;

    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setStartingSpeed() {
        Random random = new Random();
        this.speedX = random.nextInt(3) - 1;
        this.speedY = -1;
    }

    public double getSpeedX() {
        return speedX;
    }

    public double getSpeedY() {
        return speedY;
    }

    public void setSpeedX(double speedX) {
        this.speedX = speedX;
    }

    public void setSpeedY(double speedY) {
        this.speedY = speedY;
    }

    /**
     * Sets new x and y coordinates for the ball. The new coordinates depends on
     * the ball speed.
     */
    public void move() {
        x += speedX;
        y += speedY;
    }

    @Override
    public String toString() {
        return x+","+y+","+speedX+","+speedY;
    }
    

}
