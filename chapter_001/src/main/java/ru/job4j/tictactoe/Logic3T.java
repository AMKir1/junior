package ru.job4j.tictactoe;

class Logic3T {
    private final Figure3T[][] table;

    Logic3T(Figure3T[][] table) {
        this.table = table;
    }

    boolean isWinnerX() {
        boolean winHorizontal, winVertical, winLeftDiagonal, winRightDiagonal;
        winHorizontal = true;
        winVertical = true;
        winLeftDiagonal = true;
        winRightDiagonal = true;
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table.length; j++) {
                if (i == j) {
                    if (!(winLeftDiagonal && table[i][j].hasMarkX())) {
                        winLeftDiagonal = false;
                    }
                }
                if (!(winRightDiagonal && table[i][table.length - 1 - j].hasMarkX())) {
                    winRightDiagonal = false;
                }
                if (!(winHorizontal && table[i][j].hasMarkX())) {
                    winHorizontal = false;
                }
                if (!(winVertical && table[j][i].hasMarkX())) {
                    winVertical = false;
                }

            }
        }
        return winHorizontal || winVertical || winLeftDiagonal || winRightDiagonal;
    }

    boolean isWinnerO() {
        boolean winHorizontal, winVertical, winLeftDiagonal, winRightDiagonal;
        winHorizontal = true;
        winVertical = true;
        winLeftDiagonal = true;
        winRightDiagonal = true;
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table.length; j++) {
                if (i == j) { // главная диагональ
                    if (!(winLeftDiagonal && table[i][j].hasMarkO())) {
                        winLeftDiagonal = false;
                    }
                }
                if (j == table.length - 1 - i) { // побочная диагональ
                    if (!(winRightDiagonal && table[i][j].hasMarkO())) {
                        winRightDiagonal = false;
                    }
                }
                if (!(winHorizontal && table[i][j].hasMarkO())) {
                    winHorizontal = false;
                }
                if (!(winVertical && table[j][i].hasMarkO())) {
                    winVertical = false;
                }
            }
        }
        return winHorizontal || winVertical || winLeftDiagonal || winRightDiagonal;
    }

    boolean hasGap() {
       return !isWinnerX() && !isWinnerO();
    }
}
