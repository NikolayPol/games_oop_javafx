package ru.job4j.puzzle;

public class Win {
    public static boolean check(int[][] board) {
        boolean result = false;
        int size = board.length;
        int sumx = 0;
        int sumy = 0;
        for (int y = 0; y < size; y++) {
            for (int x = 0; x < size; x++) {
                sumx +=board[y][x];
                sumy +=board[x][y];
            }
            if((sumx == size)||(sumy == size)){
                result = true;
                break;
            }
            sumx = 0;
            sumy = 0;
        }
        return result;
    }
}
