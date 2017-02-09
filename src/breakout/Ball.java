/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package breakout;

import java.util.Random;

/**
 *
 * @author ville
 */
public class Ball {

    private int x;
    private int y;
    private double speedX;
    private double speedY;

    public Ball(int x, int y) {
        this.x = x;
        this.y = y;
        Random random = new Random();
        this.speedX = random.nextInt(4)-2;
        this.speedY = -2;
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

    public void move() {
        x += speedX;
        y += speedY;
    }

}
