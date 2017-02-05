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
    private int speedX;
    private int speedY;

    public Ball(int x, int y) {
        this.x = x;
        this.y = y;
        Random random = new Random();
        this.speedX = random.nextInt(3) - 1;
        this.speedY = -1;
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

    public int getSpeedX() {
        return speedX;
    }

    public int getSpeedY() {
        return speedY;
    }

    public void setSpeedX(int speedX) {
        this.speedX = speedX;
    }

    public void setSpeedY(int speedY) {
        this.speedY = speedY;
    }

    public void move() {
        x += speedX;
        y += speedY;
    }

}
