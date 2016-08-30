package com.doancea.pathofleastresistance.Grid;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class ResistanceGridTests {

    @Test
    public void getReturnsTheValueAtTheGivenRowAndColumn() {
        int[][] gridValues = { {0, 1, 2, 3, 4, 5} };
        ResistanceGrid subject = new ResistanceGrid(gridValues);

        int actualValue = subject.get(0, 2);

        assertThat(actualValue, equalTo(gridValues[0][2]));
    }

    @Test
    public void getValuesForColumnReturnsAnArrayOfAllValuesForTheGivenColumn() {
        int[][]gridValues = { { 0, 1, 2, 3 } };

        ResistanceGrid subject = new ResistanceGrid(gridValues);

        int[] actualColumnValues = subject.getValuesForColumn(0);

        int[] expectedColumnValues = {0, 1, 2, 3};
        assertArrayEquals(expectedColumnValues, actualColumnValues);
    }

    @Test
    public void getNumberOfColumnsReturnsTheNumberOfColumnsInTheGrid() {
        int[][] gridValues = { { 1 }, { 2 }, { 3 }, { 4 }, { 5 } };

        ResistanceGrid subject = new ResistanceGrid(gridValues);

        assertThat(subject.getNumberOfColumns(), is(5));
    }
}
