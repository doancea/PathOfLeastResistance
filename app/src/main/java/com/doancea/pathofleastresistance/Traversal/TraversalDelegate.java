package com.doancea.pathofleastresistance.Traversal;


import com.doancea.pathofleastresistance.Grid.GridPoint;
import com.doancea.pathofleastresistance.Grid.ResistanceGrid;
import com.doancea.pathofleastresistance.Path.TraversalResult;
import com.doancea.pathofleastresistance.Traversal.GridTraverser;

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
