package com.doancea.pathofleastresistance.Path;


import com.doancea.pathofleastresistance.Grid.GridPoint;

import java.util.ArrayList;
import java.util.List;

public class TraversalResult {

    private List<GridPoint> path;

    public TraversalResult() {
        path = new ArrayList<>();
    }

    public void addPointToPath(GridPoint point) {
        path.add(point);
    }

    public List<GridPoint> getPath() {
        return path;
    }
}
