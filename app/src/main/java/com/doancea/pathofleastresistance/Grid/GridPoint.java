package com.doancea.pathofleastresistance.Grid;

import android.support.v4.util.Pair;


public final class GridPoint extends Pair<Integer, Integer> {

    public final int column = super.first;

    public final int row = super.second;

    public GridPoint() {
        super(-1, -1);
    }

    public GridPoint(int column, int row) {
        super(column, row);
    }


}
