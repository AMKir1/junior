package ru.job4j.chess.piece;
/**
 * Chapter_002. Chess.
 * @author Andrei Kirillovykh (mailto:andykirill@gmail.com)
 * @version 1
 */
import ru.job4j.chess.*;

//Пешка
public class Pawn implements Piece {

    private final Space currSpace;

    public Pawn(Space space) {
        this.currSpace = space;
    }

    @Override
    public Space getPieceSpace() {
        return this.currSpace;
    }

    @Override
    public Piece createPiece(Space nextSpace) {
        return new Pawn(nextSpace);
    }

    @Override
    public Space[] toGoFromCurrentSpaceToNextSpace(Space currSpace, Space nextSpace) {
        int currX = currSpace.getX();
        int currY = currSpace.getY();
        int nextX = nextSpace.getX();
        int nextY = nextSpace.getY();
        Space[] result = new Space[Math.abs(nextY - currY) == 2 && (currY == 1) ? 2 : 1];
        if (!(currX == nextX && currY != nextY && ((Math.abs(nextY - currY) == 2) || (Math.abs(nextY - currY) == 1)) && (currY > 0 || nextY > 0))) {
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
