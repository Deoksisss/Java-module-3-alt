package org.example;

import java.util.*;

public class PathFinder {

    private static EndPoints endPointsFinder(char[][] matrix) {
        Point start = null;
        Point finish = null;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                char cell = matrix[i][j];

                if (cell == 's') {
                    start = new Point(i, j);
                } else if (cell == 'f') {
                    finish = new Point(i, j);
                }

                if (start != null && finish != null) {
                    return new EndPoints(start, finish);
                }
            }
        }

        throw new IllegalArgumentException("Карта не содержит старта или финиша");
    }

    private static List<Point> buildPath(Point[][] parent, Point start, Point finish) {
        LinkedList<Point> path = new LinkedList<>();
        Point curr = finish;

        while (curr != null) {
            path.addFirst(curr);
            curr = parent[curr.row()][curr.col()];
        }

        return path;
    }

    public static List<Point> findPath(EndPoints endPoints, char[][] matrix) {
        Point start = endPoints.start();
        Point finish = endPoints.finish();

        Queue<Point> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[4][4];
        Point[][] parent = new Point[4][4];

        int[] dRow = {-1, 1, 0, 0};
        int[] dCol = {0, 0, -1, 1};

        queue.add(start);
        visited[start.row()][start.col()] = true;

        while (!queue.isEmpty()) {
            Point current = queue.poll();

            if (current.equals(finish)) {
                return buildPath(parent, start, finish);
            }

            for (int i = 0; i < 4; i++) {
                int newRow = current.row() + dRow[i];
                int newCol = current.col() + dCol[i];

                if (newRow >= 0 && newRow < 4 && newCol >= 0 && newCol < 4
                        && matrix[newRow][newCol] != '#'
                        && !visited[newRow][newCol]) {

                    visited[newRow][newCol] = true;
                    parent[newRow][newCol] = current;
                    queue.add(new Point(newRow, newCol));
                }
            }
        }

        return Collections.emptyList();
    }

}
