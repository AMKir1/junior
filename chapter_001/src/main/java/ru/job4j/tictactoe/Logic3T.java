package ru.job4j.tictactoe;

import java.util.function.Predicate;

class Logic3T {
    private final Figure3T[][] table;

    Logic3T(Figure3T[][] table) {
        this.table = table;
    }

    public boolean fillBy(Predicate<Figure3T> predicate, int startX, int startY, int deltaX, int deltaY) {
        boolean result = true;
        for (int index = 0; index != this.table.length; index++) {
            Figure3T cell = this.table[startX][startY];
            startX += deltaX;
            startY += deltaY;
            if (!predicate.test(cell)) {
                result = false;
                break;
            }
        }
        return result;
    }

    boolean isWinnerX() {
        return checkWin();
    }

    boolean isWinnerO() {
        return checkWin();
    }

    boolean checkWin() {
        return this.fillBy(Figure3T::hasMarkO, 0, 0, 1, 0)
                || this.fillBy(Figure3T::hasMarkO, 0, 1, 1, 0)
                || this.fillBy(Figure3T::hasMarkO, 0, this.table.length - 1, 1, 0)
                || this.fillBy(Figure3T::hasMarkO, 0, 0, 0, 1)
                || this.fillBy(Figure3T::hasMarkO, 1, 0, 0, 1)
                || this.fillBy(Figure3T::hasMarkO, this.table.length - 1, 0, 0, 1)
                || this.fillBy(Figure3T::hasMarkO, 0, this.table.length - 1, 1, -1)
                || this.fillBy(Figure3T::hasMarkO, this.table.length - 1, this.table.length - 1, -1, -1);
    }

    boolean hasGap() {
       return !isWinnerX() && !isWinnerO();
    }
}
