package com.doancea.pathofleastresistance.Grid;

import android.support.v4.util.Pair;


public class GridPoint extends Pair<Integer, Integer> {

    public final int row = super.first;

    public final int column = super.second;

    public final Integer resistance;


    public GridPoint() {

        super(-1, -1);
        this.resistance = null;
    }

    public GridPoint(int row, int column) {
        super(row, column);
        this.resistance = null;
    }


    public GridPoint(int row, int column, int resistance) {
        super(row, column);
        this.resistance = resistance;
    }
}
