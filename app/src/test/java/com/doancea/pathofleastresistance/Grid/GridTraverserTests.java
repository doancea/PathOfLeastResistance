package com.doancea.pathofleastresistance.Grid;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class GridTraverserTests {

    private GridTraverser subject;
    private ResistanceGrid mockGrid;

    @Before
    public void setup() {
        mockGrid = Mockito.mock(ResistanceGrid.class);
        subject = new GridTraverser();
    }

    @Test
    public void getNextPositionReturnsThePointWithLowestValueFromTheFirstColumnOfTheCurrentGridWhenTheDefaultGridPositionIsGiven() {
        int[] columnValues = {4, 1, 2, 3};
        when(mockGrid.getValuesForColumn(0)).thenReturn(columnValues);

        GridPoint point = new GridPoint();

        GridPoint actualNextPosition = subject.getNextPosition(point, mockGrid);

        GridPoint expectedNextPosition = new GridPoint(0, 1);
        assertThat(actualNextPosition, is(expectedNextPosition));
    }

    @Test
    public void getNextPositionReturnsThePointWithTheLowestValueFromTheAdjacentPointsInTheNextColumn() {
        int[] columnValues = {0, 2, 4, 1, 0};
        when(mockGrid.getValuesForColumn(1)).thenReturn(columnValues);

        GridPoint point = new GridPoint(0, 2);

        GridPoint actualNextPosition = subject.getNextPosition(point, mockGrid);

        GridPoint expectedNextPosition = new GridPoint(1, 3);
        assertThat(actualNextPosition, is(expectedNextPosition));
    }

    @Test
    public void getNextPositionReturnsWrapsToTheBottomRowWhenTheGivenPointIsInTheTopRow() {
        int[] columnValues = {5, 2, 4, 1, 0};
        when(mockGrid.getValuesForColumn(1)).thenReturn(columnValues);
        subject = new GridTraverser();
        GridPoint point = new GridPoint(0, 0);

        GridPoint actualNextPosition = subject.getNextPosition(point, mockGrid);

        GridPoint expectedNextPosition = new GridPoint(1, 4);
        assertThat(actualNextPosition, is(expectedNextPosition));
    }

    @Test
    public void getNextPositionReturnsWrapsToTheTopRowWhenTheGivenPointIsInTheBottomRow() {
        int[] columnValues = {0, 2, 4, 1, 5};
        when(mockGrid.getValuesForColumn(1)).thenReturn(columnValues);
        subject = new GridTraverser();
        GridPoint point = new GridPoint(0, 4);

        GridPoint actualNextPosition = subject.getNextPosition(point, mockGrid);

        GridPoint expectedNextPosition = new GridPoint(1, 0);
        assertThat(actualNextPosition, is(expectedNextPosition));
    }
}
