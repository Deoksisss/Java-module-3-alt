package org.example;

import java.util.List;

public class PathPainter {

    public static char[][] paintMatrix(char[][] matrix, List<Point> path, EndPoints endPoints) {

        if (path.isEmpty()) {
            throw new IllegalArgumentException("На данной карте невозможно построить путь");
        }

        Point start = endPoints.start();
        Point finish = endPoints.finish();
        for (Point pathPoint : path) {
            if (!pathPoint.equals(start) && !pathPoint.equals(finish)) {
                matrix[pathPoint.row()][pathPoint.col()] = '*';
            }
        }
        return matrix;
    }

}
