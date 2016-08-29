package com.doancea.pathofleastresistance.Grid;

import android.support.v4.util.Pair;


public class GridPoint extends Pair<Integer, Integer> {

    public GridPoint() {
        super(-1, -1);
    }

    public GridPoint(int column, int row) {
        super(column, row);
    }
}
