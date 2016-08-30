package com.doancea.pathofleastresistance.Grid;

public class GridTraverser {

    private final ResistanceGrid grid;

    public GridTraverser(ResistanceGrid grid) {
        this.grid = grid;
    }

    public GridPoint getNextPosition(GridPoint point) {
        if(point.first == -1 || point.second == -1) {
            int[] possibleValues = grid.getValuesForColumn(0);

            int minPosition = 0, minValue = possibleValues[0];
            for(int i = 1; i < possibleValues.length; i++) {
                if(possibleValues[i] < minValue) {
                    minPosition = i;
                    minValue = possibleValues[i];
                }
            }

            return new GridPoint(0, minPosition);
        }

        return new GridPoint();
    }
}
