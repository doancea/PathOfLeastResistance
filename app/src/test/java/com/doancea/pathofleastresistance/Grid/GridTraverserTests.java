package com.doancea.pathofleastresistance.Grid;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.mockito.Mockito;

public class GridTraverserTests {

    private GridTraverser subject;

    @Test
    public void getNextPositionReturnsThePointWithLowestValueFromTheFirstColumnOfTheCurrentGridWhenTheDefaultGridPositionIsGiven() {
        ResistanceGrid mockGrid = Mockito.mock(ResistanceGrid.class);
        int[] columnValues = {4, 1, 2, 3};
        when(mockGrid.getValuesForColumn(0)).thenReturn(columnValues);
        subject = new GridTraverser(mockGrid);
        GridPoint point = new GridPoint();

        GridPoint actualNextPosition = subject.getNextPosition(point);

        GridPoint expectedNextPosition = new GridPoint(0, 1);
        assertThat(actualNextPosition, is(expectedNextPosition));
    }

    @Test
    public void getNextPositionReturnsThePointWithTheLowestValueFromTheAdjacentPointsInTheNextColumn() {
        ResistanceGrid mockGrid = Mockito.mock(ResistanceGrid.class);
        int[] columnValues = {0, 2, 4, 1, 0};
        when(mockGrid.getValuesForColumn(1)).thenReturn(columnValues);
        subject = new GridTraverser(mockGrid);
        GridPoint point = new GridPoint(0, 2);

        GridPoint actualNextPosition = subject.getNextPosition(point);

        GridPoint expectedNextPosition = new GridPoint(1, 3);
        assertThat(actualNextPosition, is(expectedNextPosition));
    }

    @Test
    public void getNextPositionReturnsWrapsToTheBottomRowWhenTheGivenPointIsInTheTopRow() {
        ResistanceGrid mockGrid = Mockito.mock(ResistanceGrid.class);
        int[] columnValues = {5, 2, 4, 1, 0};
        when(mockGrid.getValuesForColumn(1)).thenReturn(columnValues);
        subject = new GridTraverser(mockGrid);
        GridPoint point = new GridPoint(0, 0);

        GridPoint actualNextPosition = subject.getNextPosition(point);

        GridPoint expectedNextPosition = new GridPoint(1, 4);
        assertThat(actualNextPosition, is(expectedNextPosition));
    }
}
