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
public class TileGrid {

    private int[][] matrix;

    public TileGrid(int level) {
        if (level % 3 == 0) {
            levelThree();
        } else if (level % 2 == 1) {
            levelOne();
//        } else if (level == 0) {
//            levelZero();
        } else if (level % 2 == 0) {
            levelTwo();

        }
    }

    public int[][] getLevel() {
        return matrix;
    }

    private void levelOne() {
        this.matrix = new int[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                matrix[j][i] = 1;
            }
        }
    }

    private void levelTwo() {
        this.matrix = new int[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                matrix[j][i] = 2;
            }
        }
    }

    private void levelZero() {
        this.matrix = new int[2][2];
        matrix[0][0] = 1;
        matrix[0][1] = 1;
        matrix[1][0] = 1;
        matrix[1][1] = 1;

    }

    private void levelThree() {
        this.matrix = new int[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                matrix[j][i] = 3;
            }
        }
    }

}
