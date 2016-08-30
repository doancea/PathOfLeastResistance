package com.doancea.pathofleastresistance.Grid;


import com.doancea.pathofleastresistance.Path.TraversalResult;

import java.lang.ref.WeakReference;

public class TraversalDelegate {

    private GridTraverser traverser;
    private ResistanceGrid grid;
    private TraversalResult result;

    public TraversalDelegate(GridTraverser traverser, ResistanceGrid grid) {
        this.traverser = traverser;
        this.grid = grid;
        this.result = new TraversalResult();
    }

    public TraversalResult getPathOfLeastResistance() {
        GridPoint startPoint = new GridPoint();
        WeakReference<GridPoint> currentPoint = new WeakReference(startPoint);

        while(result.getPath().size() < grid.getNumberOfColumns()) {
            currentPoint = new WeakReference(traverser.getNextPosition(currentPoint.get(), this.grid));
            result.addPointToPath(currentPoint.get());
        }

        return result;
    }
}
