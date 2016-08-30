package com.doancea.pathofleastresistance.Path;

import com.doancea.pathofleastresistance.Grid.GridPoint;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class TraversalResultTest {

    @Test
    public void addPointToPathAddsTheGivenPointToTheTravesralResultsPath() {
        TraversalResult subject = new TraversalResult();
        GridPoint firstPoint = new GridPoint(0,2);
        GridPoint secondPoint = new GridPoint(1,3);

        subject.addPointToPath(firstPoint);
        subject.addPointToPath(secondPoint);

        assertThat(subject.getPath().size(), is(2));
        assertThat(subject.getPath().get(0), is(firstPoint));
        assertThat(subject.getPath().get(1), is(secondPoint));
    }

}