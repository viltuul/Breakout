/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package breakout;

import java.util.ArrayList;

/**
 *
 * @author ville
 */
public final class Level {

    private ArrayList<Tile> tiles;
    private TileGrid grid;
    private int diffuculty;
    private int unbrokenTiles;

    public Level(int diffuculty) {
        this.diffuculty = diffuculty;
        createTiles();
        this.unbrokenTiles = tiles.size();
    }

    /**
     * Creates tiles and adds them to the tiles list.
     */
    public void createTiles() {
        this.tiles = new ArrayList();
        TileGrid grid = new TileGrid(diffuculty);
        int[][] matrix = grid.getLevel();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 1; j < matrix.length; j++) {
                tiles.add(new Tile(i * 100 + 5, 100 + 25 * j, matrix[j][i]));
            }
        }
    }

    public ArrayList<Tile> getTiles() {
        return tiles;
    }

    public void checkTiles() {
        for (Tile tile : tiles) {
            if (!tile.isDestroyed()) {
                this.unbrokenTiles++;
            }
        }
    }

    int getDiffuculty() {
        return diffuculty;
    }
}
