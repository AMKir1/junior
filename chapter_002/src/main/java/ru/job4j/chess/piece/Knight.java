package ru.job4j.chess.piece;
/**
 * Chapter_002. Chess.
 * @author Andrei Kirillovykh (mailto:andykirill@gmail.com)
 * @version 1
 */
import ru.job4j.chess.*;

// Конь
public class Knight implements Piece {

    private final Space currSpace;

    public Knight(Space space) {
        this.currSpace = space;
    }

    @Override
    public Space getPieceSpace() {
        return this.currSpace;
    }

    @Override
    public Piece createPiece(Space nextSpace) {
        return new Knight(nextSpace);
    }

    @Override
    public Space[] toGoFromCurrentSpaceToNextSpace(Space currSpace, Space nextSpace) {

        int currX = currSpace.getX();
        int currY = currSpace.getY();
        int nextX = nextSpace.getX();
        int nextY = nextSpace.getY();

        Space[] result = new Space[1];
        if (!(((Math.abs(nextX - currX) == 2 && Math.abs(nextY - currY) == 1) || (Math.abs(nextY - currY) == 2 && Math.abs(nextX - currX) == 1))
                && Math.abs(nextY - currY) + Math.abs(nextX - currX) == 3
                && (currX >= 0 && currY >= 0 && currY <= 7 && currX <= 7)
                && (nextX >= 0 && nextY >= 0 && nextY <= 7 && nextX <= 7))) {
            result = null;
        } else {
            result[0] = new Space(nextX, nextY);
        }
        return result;
    }
}
