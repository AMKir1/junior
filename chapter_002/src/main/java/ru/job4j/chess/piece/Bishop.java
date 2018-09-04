package ru.job4j.chess.piece;

import ru.job4j.chess.*;
/**
 * Chapter_002. Chess.
 * @author Andrei Kirillovykh (mailto:andykirill@gmail.com)
 * @version 1
 */
// Слон - ходит по диагонали
public class Bishop implements Piece {

    private final Space currSpace;

    public Bishop(Space space) {
        this.currSpace = space;
    }

    @Override
    public Piece createPiece(Space nextSpace) {
        return new Bishop(nextSpace);
    }

    @Override
    public Space getPieceSpace() {
        return this.currSpace;
    }

    @Override
    public Space[] toGoFromCurrentSpaceToNextSpace(Space currSpace, Space nextSpace) {
        int currX = currSpace.getX();
        int currY = currSpace.getY();
        int nextX = nextSpace.getX();
        int nextY = nextSpace.getY();

        Space[] result = new Space[Math.abs(currX - nextX)];

        if (Math.abs(currX - nextX) != Math.abs(currY - nextY)
                || !((currY <= 7 && currY >= 0)
                && (currX <= 7 && currX >= 0)
                && (nextY <= 7 && nextY >= 0)
                && (nextX <= 7 && nextX >= 0))) {
            result = null;
        } else {
            int h = Integer.compare(nextX, currX);
            int v = Integer.compare(nextY, currY);
            for (int i = 0; i < result.length; i++) {
                currX += h;
                currY += v;
                result[i] = new Space(currX, currY);
            }
        }
        return result;
    }
}