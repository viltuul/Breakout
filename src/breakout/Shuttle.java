/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package breakout;

/**
 *
 * @author ville
 */
public class Shuttle {

    private int x;
    private int y;
    private int width;
    private double speedX;

    public Shuttle(int x, int y) {
        this.x = x;
        this.y = y;
        this.width = 160;
        this.speedX = 0;

    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setSpeedX(double speed) {
        speedX = speed;
    }

    public int getWidth() {
        return width;
    }

    public void move() {
        x += speedX;
    }

}
