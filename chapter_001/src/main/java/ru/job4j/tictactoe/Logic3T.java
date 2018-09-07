package ru.job4j.tictactoe;

public class Logic3T {
    private final Figure3T[][] table;

    public Logic3T(Figure3T[][] table) {
        this.table = table;
    }

    public boolean isWinnerX() {
        boolean winHorizontal, winVertical, winLeftDiagonal, winRightDiagonal;
        winHorizontal = true;
        winVertical = true;
        winLeftDiagonal = true;
        winRightDiagonal = true;
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table.length; j++) {
                if(i == j) {
                    if (winLeftDiagonal && table[i][j].hasMarkX()) {
                    } else {
                        winLeftDiagonal = false;
                    }
                }
                if (winRightDiagonal && table[i][table.length - 1 - j].hasMarkX()) {
                } else { winRightDiagonal = false; }
                if (winHorizontal && table[i][j].hasMarkX()) {
                } else { winHorizontal = false; }
                if (winVertical && table[j][i].hasMarkX()) {
                } else { winVertical = false; }

            }
        }
        if (winHorizontal || winVertical || winLeftDiagonal || winRightDiagonal)
        {
            return true;
        } else {
            return false;
        }
    }

    public boolean isWinnerO() {
        boolean winHorizontal, winVertical, winLeftDiagonal, winRightDiagonal;
        winHorizontal = true;
        winVertical = true;
        winLeftDiagonal = true;
        winRightDiagonal = true;
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table.length; j++) {
                if(i == j) { // главная диагональ
                    if (winLeftDiagonal && table[i][j].hasMarkO()) {
                    } else {
                        winLeftDiagonal = false;
                    }
                }
                if (j == table.length - 1 - i) { // побочная диагональ
                    if (winRightDiagonal && table[i][j].hasMarkO()) {
                    } else {
                        winRightDiagonal = false;
                    }
                }

                if (winHorizontal && table[i][j].hasMarkO()) {
                } else { winHorizontal = false; }
                if (winVertical && table[j][i].hasMarkO()) {
                } else { winVertical = false; }

            }
        }
        if (winHorizontal || winVertical || winLeftDiagonal || winRightDiagonal)
        {
            return true;
        } else {
            return false;
        }
    }
    public boolean hasGap() {
        if (!isWinnerX() && !isWinnerO()) {
            return true;
        }
        else{
            return false;
        }
    }
}
