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
            minPosition = getMinimumAdjacentPosition(point.second, possibleValues);
        }

        return new GridPoint(nextColumn, minPosition);
    }

    private int getMinimumAdjacentPosition(int currentRow, int[] possibleValues) {
        int[] adjacentValues = getAdjacentRows(possibleValues, currentRow);
        int relativeMinimumValuePosition = searchForMinimumPosition(adjacentValues);
        int absoluteMinimumValuePosition = getAbsolutePosition(relativeMinimumValuePosition, currentRow);

        if(absoluteMinimumValuePosition == -1) {
            absoluteMinimumValuePosition = possibleValues.length - 1;
        }

        if(absoluteMinimumValuePosition == possibleValues.length) {
            absoluteMinimumValuePosition = 0;
        }

        return absoluteMinimumValuePosition;
    }

    private int getAbsolutePosition(int relativePosition, int currentRow) {
        return relativePosition + (currentRow - 1);
    }

    private int[] getAdjacentRows(int[] adjacentColumn, int currentRow) {
        if(currentRow == 0) {
            int[] adjacentRows = { adjacentColumn[adjacentColumn.length - 1], adjacentColumn[0], adjacentColumn[1] };
            return adjacentRows;
        }

        if(currentRow == adjacentColumn.length - 1) {
            int[] adjacentRows = { adjacentColumn[currentRow - 1], adjacentColumn[currentRow], adjacentColumn[0] };
            return adjacentRows;
        }
        return Arrays.copyOfRange(adjacentColumn, currentRow - 1, currentRow + 2);
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
