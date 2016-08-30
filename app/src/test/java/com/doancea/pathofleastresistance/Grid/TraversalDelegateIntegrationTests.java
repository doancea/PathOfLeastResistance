package com.doancea.pathofleastresistance.Grid;


import com.doancea.pathofleastresistance.Path.TraversalResult;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TraversalDelegateIntegrationTests {

    private TraversalDelegate delegate;
    private GridTraverser traverser;
    private ResistanceGrid grid;

    @Test
    public void findThePathOfImmediateLeastResistance() {
        int[][] gridValues = {
                {9, 0, 8, 1, 7, 2, 6, 3, 5, 4},
                {8, 9, 7, 6, 2, 3, 1, 4, 0, 5},
                {1, 7, 8, 9, 5, 6, 2, 3, 4, 0},
                {7, 8, 9, 3, 4, 5, 6, 0, 1, 2},
                {9, 8, 0, 6, 5, 4, 3, 2, 1, 7}
        };

        grid = new ResistanceGrid(gridValues);
        traverser = new GridTraverser();

        delegate = new TraversalDelegate(traverser, grid);

        TraversalResult result = delegate.getPathOfLeastResistance();

        List<GridPoint> expectedPath = Arrays.asList(new GridPoint[]{
                new GridPoint(0, 1),
                new GridPoint(1, 2),
                new GridPoint(2, 1),
                new GridPoint(3, 0),
                new GridPoint(4, 9)
        });

        assertThat(result.getPath(), is(expectedPath));
    }
}
