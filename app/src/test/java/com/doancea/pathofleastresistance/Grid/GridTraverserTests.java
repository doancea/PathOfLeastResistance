package com.doancea.pathofleastresistance.Grid;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class GridTraverserTests {

    private GridTraverser subject;

    @Before
    public void setUp() {
        subject = new GridTraverser();
    }

    @Test
    public void getNextPositionReturnsAValueFromTheFirstColumnOfTheCurrentGridWhenTheDefaultGridPointIsGiven() {
        int[][] gridValues = { { 0, 1, 2, 3, 4, 5 } };
        ResistanceGrid grid = new ResistanceGrid(gridValues);
        subject.setGrid(grid);
        GridPoint point = new GridPoint();

        GridPoint actualNextPosition = subject.getNextPosition(point);

        GridPoint expectedNextPostion = new GridPoint(0, 0);
        assertThat(actualNextPosition, is(expectedNextPostion));
    }
}
