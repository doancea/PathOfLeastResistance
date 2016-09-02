package com.doancea.pathofleastresistance.Traversal;


import com.doancea.pathofleastresistance.Grid.GridPoint;
import com.doancea.pathofleastresistance.Grid.ResistanceGrid;
import com.doancea.pathofleastresistance.Path.TraversalResult;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class TraversalDelegateIntegrationTests {

    private TraversalDelegate delegate;
    private GridTraverser traverser;
    private ResistanceGrid grid;

    @Test
    public void findThePathOfImmediateLeastResistance() {
        int[][] gridValues = {
                {9, 8, 1, 7, 9},
                {0, 9, 7, 8, 8},
                {8, 7, 8, 9, 0},
                {1, 6, 9, 3, 6},
                {7, 2, 5, 4, 5},
                {2, 3, 6, 5, 4},
                {6, 1, 2, 6, 3},
                {3, 4, 3, 0, 2},
                {5, 0, 4, 1, 1},
                {4, 5, 0, 2, 7}
        };

        grid = new ResistanceGrid(gridValues);
        traverser = new GridTraverser();

        delegate = new TraversalDelegate(traverser, grid);

        TraversalResult result = delegate.getPathOfLeastResistance();

        List<GridPoint> expectedPath = Arrays.asList(new GridPoint[]{
                new GridPoint(1, 0),
                new GridPoint(2, 1),
                new GridPoint(1, 2),
                new GridPoint(0, 3),
                new GridPoint(9, 4)
        });

        assertThat(result.getPath(), is(expectedPath));
    }

    @Test @Ignore
    public void findThePathOfLeastResistance() {
        int[][] gridValues = {
                {9, 8, 1, 7, 9},
                {0, 9, 7, 8, 8},
                {8, 7, 8, 9, 0},
                {1, 6, 9, 3, 6},
                {7, 2, 5, 4, 5},
                {2, 3, 6, 5, 4},
                {6, 1, 2, 6, 3},
                {3, 4, 3, 0, 2},
                {5, 0, 4, 1, 1},
                {4, 5, 0, 2, 7}
        };

        grid = new ResistanceGrid(gridValues);
        traverser = new GridTraverser();

        delegate = new TraversalDelegate(traverser, grid);

        TraversalResult result = delegate.getPathOfLeastResistance();

        List<GridPoint> expectedPath = Arrays.asList(new GridPoint[]{
                new GridPoint(0, 7),
                new GridPoint(1, 8),
                new GridPoint(2, 9),
                new GridPoint(3, 8),
                new GridPoint(4, 8)
        });

        assertThat(result.getPath(), is(expectedPath));
    }
}
