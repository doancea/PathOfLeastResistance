package com.doancea.pathofleastresistance.Grid;


import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class GridTraverserIntegrationTests {

    private GridTraverser traverser;
    private ResistanceGrid resistanceGrid;

    @Test
    public void getNextPositionReturnsAValueFromTheFirstColumnOfTheCurrentGridWhenTheDefaultGridPointIsGiven() {
        int[][] gridValues = { { 0, 1, 2, 3, 4, 5 } };
        resistanceGrid = new ResistanceGrid(gridValues);
        traverser = new GridTraverser(resistanceGrid);
        GridPoint point = new GridPoint();

        GridPoint actualNextPosition = traverser.getNextPosition(point);

        GridPoint expectedNextPostion = new GridPoint(0, 0);
        assertThat(actualNextPosition, is(expectedNextPostion));
    }

    @Test
    public void getNextPositionReturnsTheLowestValueFromTheFirstColumnOfTheCurrentGridWhenTheDefaultGridPositionIsGiven() {
        int[][] gridValues = { {4, 3, 1, 2} };
        ResistanceGrid grid = new ResistanceGrid(gridValues);
        traverser = new GridTraverser(grid);
        GridPoint point = new GridPoint();

        GridPoint actualNextPosition = traverser.getNextPosition(point);

        GridPoint expectedNextPosition = new GridPoint(0, 2);
        assertThat(actualNextPosition, is(expectedNextPosition));
    }
}
