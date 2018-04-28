package ru.job4j.chess.piece;
/**
 * Chapter_002. Chess.
 * @author Andrei Kirillovykh (mailto:andykirill@gmail.com)
 * @version 1
 */
import ru.job4j.chess.*;

// Король
public class King implements Piece {

    private final Space currSpace;

    public King(Space space) {
        this.currSpace = space;
    }


    @Override
    public Space getPieceSpace() {
        return this.currSpace;
    }

    @Override
    public Piece createPiece(Space space) {
        return new King(space);
    }

    @Override
    public Space[] toGoFromCurrentSpaceToNextSpace(Space currSpace, Space nextSpace) {
        Space[] result = new Space[1];
        int currX = currSpace.getX();
        int currY = currSpace.getY();
        int nextX = nextSpace.getX();
        int nextY = nextSpace.getY();
        if ((!((currX != nextX && currY == nextY) || (currX == nextX && currY != nextY))
                && Math.abs(currX - nextX) != Math.abs(currY - nextY))
             || (nextX > 7 || nextY > 7) || (nextX < 0 || nextY < 0)
             || (nextX > currX + 1 || nextY > currY + 1) || (nextX < currX - 1 || nextY < currY - 1)) {
            result = null;
        } else {
            int h = Integer.compare(nextX, currX);
            int v = Integer.compare(nextY, currY);
            for (int i = 0; i != result.length; i++) {
                currX += h;
                currY += v;
                result[i] = new Space(currX, currY);
            }
        }
        return result;
    }
}

