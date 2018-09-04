package ru.job4j.chess.piece;
/**
 * Chapter_002. Chess.
 * @author Andrei Kirillovykh (mailto:andykirill@gmail.com)
 * @version 1
 */
import ru.job4j.chess.*;

public class Queen implements Piece {

    private final Space currSpace;

    /**
     * Конструктор ферзя
     * @param space
     */
    public Queen(Space space) {
        this.currSpace = space;
    }

    /**
     * Ставим фигуру в новом месте
     * @param nextSpace - куда ставим фигуру
     * @return фигуру  возвращаем с текущим местоположением
     */
    @Override
    public Piece createPiece(Space nextSpace) {
        return new Queen(nextSpace);
    }

    /**
     * Получаем текущее местоположение фигуры
     * @return
     */
    @Override
    public Space getPieceSpace() {
        return this.currSpace;
    }

    /**
     * Ходим фигурой
     * @param currSpace - откуда
     * @param nextSpace - куда
     * @return result
     */
    @Override
    public Space[] toGoFromCurrentSpaceToNextSpace(Space currSpace, Space nextSpace) {
        int currX = currSpace.getX();
        int currY = currSpace.getY();
        int nextX = nextSpace.getX();
        int nextY = nextSpace.getY();

        Space[] result = new Space[1];
        if ((((Math.abs(nextX - currX) == 2 && Math.abs(nextY - currY) == 1)
                || (Math.abs(nextY - currY) == 2 && Math.abs(nextX - currX) == 1))
                && Math.abs(nextY - currY) + Math.abs(nextX - currX) == 3)
                || !((currY >= 0 && currY <= 7)
                && (currX >= 0 && currX <= 7)
                && (nextY >= 0 && nextY <= 7)
                && (nextX >= 0 && nextX <= 7))) {
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
