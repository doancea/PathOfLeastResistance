package com.doancea.pathofleastresistance.Traversal;

import com.doancea.pathofleastresistance.Grid.GridPoint;
import com.doancea.pathofleastresistance.Grid.ResistanceGrid;
import com.doancea.pathofleastresistance.Path.TraversalResult;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

public class TraversalDelegateTest {

    private GridTraverser traverser;
    private ResistanceGrid grid;
    private TraversalDelegate subject;

    @Before
    public void setup() {
        traverser = Mockito.mock(GridTraverser.class);
        grid = Mockito.mock(ResistanceGrid.class);

        subject = new TraversalDelegate(traverser, grid);
    }

    @Test
    public void getPathOfLeastResistanceReturnsATraversalResultWithContainingAllOfThePointsForTheResultantPath() {
        int numberOfColumns = 5;
        when(grid.getNumberOfColumns()).thenReturn(numberOfColumns);
        GridPositionAnswer positionAnswer = new GridPositionAnswer();

        when(traverser.getNextPosition(any(GridPoint.class), any(ResistanceGrid.class))).thenAnswer(positionAnswer);

        TraversalResult result = subject.getPathOfLeastResistance();
        List<GridPoint> actualPath = result.getPath();

        assertThat(actualPath.size(), is(numberOfColumns));
        assertThat(actualPath, is(positionAnswer.getExpectedPath()));
    }


    private class GridPositionAnswer implements Answer<GridPoint> {
        int currentColumn = 0;
        List<GridPoint> expectedPath = new ArrayList<>();

        @Override
        public GridPoint answer(InvocationOnMock invocation) throws Throwable {
            GridPoint newPoint = new GridPoint(currentColumn++, 1);
            expectedPath.add(newPoint);
            return newPoint;
        }

        public List<GridPoint> getExpectedPath() {
            return this.expectedPath;
        }

    }
}