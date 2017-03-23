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
public class Tile {

    private int x;
    private int y;
    private int width;
    private int health;

    public Tile(int x, int y) {
        this.x = x;
        this.y = y;
        this.width = 100;
        this.health = 1;
    }

    public Tile(int x, int y, int health) {
        this.x = x;
        this.y = y;
        this.width = 100;
        this.health = health;
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

    public int getHealth() {
        return health;
    }
    public void hit(){
        health--;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getWidth() {
        return width;
    }

}
