package com.zhenbin.lzb.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhenbin.lzb on 2016/10/17.
 */
public class L329 {
    private int[][] depth;
    private int maxRow, maxCol;

    public int longestIncreasingPath(int[][] matrix) {
        if (null == matrix || matrix.length == 0) return 0;
        maxRow = matrix.length;
        maxCol = matrix[0].length;
        depth = new int[maxRow][maxCol];
        int result = 0;
        for (int i = 0; i < maxRow; i++) {
            for (int j = 0; j < maxCol; j++) {
                dfs(i, j, matrix);
                result = result > depth[i][j] ? result : depth[i][j];
            }
        }
        return result;
    }

    private int dfs(int row, int col, int[][] matrix) {
        if (depth[row][col] != 0) return depth[row][col];
        int[][] directions = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
        int result = 1;
        for (int i = 0; i < 4; i++) {
            int nextRow = directions[i][0] + row;
            int nextCol = directions[i][1] + col;
            if (isVaild(nextRow, nextCol) && matrix[row][col] > matrix[nextRow][nextCol]) {
                int currentDepth = dfs(nextRow, nextCol, matrix) + 1;
                result = result > currentDepth ? result : currentDepth;
            }
        }
        return depth[row][col] = result;
    }

    private boolean isVaild(int row, int col) {
        if (row < 0 || row >= maxRow || col < 0 || col >= maxCol) return false;
        return true;
    }

    public static void main(String[] args) {
        L329 solution = new L329();
        int[][] matrix = {{9, 9, 4}, {6, 6, 8}, {2, 1, 1}};
        System.out.println(solution.longestIncreasingPath(matrix));
        System.out.println("a");
    }
}