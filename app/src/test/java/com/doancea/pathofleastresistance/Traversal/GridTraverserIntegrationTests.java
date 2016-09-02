package com.doancea.pathofleastresistance.Traversal;


import com.doancea.pathofleastresistance.Grid.GridPoint;
import com.doancea.pathofleastresistance.Grid.ResistanceGrid;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class GridTraverserIntegrationTests {

    private GridTraverser traverser;
    private ResistanceGrid grid;

    @Test
    public void getNextPositionReturnsAValueFromTheFirstColumnOfTheCurrentGridWhenTheDefaultGridPointIsGiven() {
        int[][] gridValues = { { 0 }, { 1 }, { 2 }, { 3 }, { 4 }, { 5 } };
        grid = new ResistanceGrid(gridValues);
        traverser = new GridTraverser();
        GridPoint point = new GridPoint();

        GridPoint actualNextPosition = traverser.getNextPosition(point, grid);

        GridPoint expectedNextPostion = new GridPoint(0, 0);
        assertThat(actualNextPosition, is(expectedNextPostion));
    }

    @Test
    public void getNextPositionReturnsTheLowestValueFromTheFirstColumnOfTheCurrentGridWhenTheDefaultGridPositionIsGiven() {
        int[][] gridValues = { { 4 }, { 3 }, { 1 }, { 2 } };
        grid = new ResistanceGrid(gridValues);
        traverser = new GridTraverser();
        GridPoint point = new GridPoint();

        GridPoint actualNextPosition = traverser.getNextPosition(point, grid);

        GridPoint expectedNextPosition = new GridPoint(2, 0);
        assertThat(actualNextPosition, is(expectedNextPosition));
    }
}
