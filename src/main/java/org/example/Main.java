package org.example;

import java.util.Arrays;

public class Main {

    static void main() {
        char[][] matrix = {
                {'.','.','s','.'},
                {'.','#','#','#'},
                {'.','.','#','.'},
                {'#','.','.','f'}
        };

        EndPoints endPoints = PathFinder.endPointsFinder(matrix);

        for (char[] rows : PathPainter.paintMatrix(matrix, PathFinder.findPath(endPoints, matrix), endPoints)) {
            System.out.println(Arrays.toString(rows));
        }
    }
}
