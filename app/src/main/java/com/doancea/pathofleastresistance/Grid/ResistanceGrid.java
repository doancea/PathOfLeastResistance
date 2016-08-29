package com.doancea.pathofleastresistance.Grid;


import android.support.v4.util.Pair;

import java.lang.reflect.Array;

public class ResistanceGrid {

    private final int[][] grid;

    public ResistanceGrid(int[][] gridValues) {
        this.grid = gridValues;
    }

    public int get(int column, int row) {
        return this.grid[column][row];
    }
}
