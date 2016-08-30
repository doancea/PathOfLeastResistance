package com.doancea.pathofleastresistance.Grid;

import java.util.Arrays;

public class GridTraverser {

    private final ResistanceGrid grid;

    public GridTraverser(ResistanceGrid grid) {
        this.grid = grid;
    }

    public GridPoint getNextPosition(GridPoint point) {
        int nextColumn = point.first + 1, minPosition;
        int[] possibleValues = grid.getValuesForColumn(nextColumn);

        if(nextColumn == 0) {
            minPosition = searchForMinimumPosition(possibleValues);
        } else {
            minPosition = getLeastResistance(point);
        }

        return new GridPoint(nextColumn, minPosition);
    }

    private int getLeastResistance(GridPoint point) {
        int minPosition;
        int[] adjacentValues = getAdjacentRows(point);
        minPosition = searchForMinimumPosition(adjacentValues) + (point.second - 1);
        return minPosition;
    }

    private int[] getAdjacentRows(GridPoint point) {
        int nextRow = 1;
        int[] adjacentColumns = grid.getValuesForColumn(nextRow);
        return Arrays.copyOfRange(adjacentColumns, point.second - 1, point.second + 2);
    }

    private int searchForMinimumPosition(int[] possibleValues) {
        int minPosition = 0, minValue = possibleValues[0];
        for(int i = 1; i < possibleValues.length; i++) {
            if(possibleValues[i] < minValue) {
                minPosition = i;
                minValue = possibleValues[i];
            }
        }
        return minPosition;
    }
}
