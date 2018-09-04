package ru.job4j.chess.piece;
/**
 * Chapter_002. Chess.
 * @author Andrei Kirillovykh (mailto:andykirill@gmail.com)
 * @version 1
 */
import ru.job4j.chess.*;

//Ладья - ходит по вертикали и горизонтали
public class Rook implements Piece {

    private Space currSpace;

    public Rook(Space space) {
        this.currSpace = space;
    }

    @Override
    public Piece createPiece(Space nextSpace) {
        return new Rook(nextSpace);
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

        Space[] result = new Space[Math.abs(currX - nextX) + Math.abs(currY - nextY)];

        if (!((currX == nextX && currY != nextY) || (currY == nextY && currX != nextX))
                || !((currY <= 7 && currY >= 0)
                && (currX <= 7 && currX >= 0)
                && (nextY <= 7 && nextY >= 0)
                && (nextX <= 7 && nextX >= 0))
                ) {
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
