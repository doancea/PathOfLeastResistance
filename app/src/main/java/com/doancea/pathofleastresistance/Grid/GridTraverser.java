package com.doancea.pathofleastresistance.Grid;


public class GridTraverser {

    private ResistanceGrid grid;

    public void setGrid(ResistanceGrid grid) {
        this.grid = grid;
    }

    public GridPoint getNextPosition(GridPoint point) {
        if(point.first == -1 || point.second == -1) {
            return new GridPoint(0,0);
        }

        return new GridPoint();
    }
}
