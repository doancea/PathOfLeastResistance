package com.doancea.pathofleastresistance.Grid;


public class ResistanceGrid {

    private final int[][] grid;

    public ResistanceGrid(int[][] gridValues) {
        this.grid = gridValues;
    }

    public int get(int row, int column) {
        return this.grid[row][column];
    }

    public int[] getValuesForColumn(int column) {
        int[] columnValues = new int[grid.length];
        for(int i = 0; i < grid.length; i++) {
            columnValues[i] = this.get(i, column);
        }
        return columnValues;
    }

    public int getNumberOfColumns() {
        return this.grid[0].length;
    }
}
