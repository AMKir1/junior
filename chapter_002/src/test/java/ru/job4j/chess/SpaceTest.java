package ru.job4j.chess;

import org.junit.Test;
import ru.job4j.chess.piece.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SpaceTest {
    /**
     * Провекра на получение координаты X
     */
    @Test
    public void chessBoardTestGetX() {
        ChessBoard board = new ChessBoard();
        Piece piece1 = new Pawn(new Space(0, 3));
        board.setPieceInSpace(piece1);
        assertThat(piece1.getPieceSpace().getX(), is(0));
    }
    /**
     * Провекра на получение координаты Y
     */
    @Test
    public void chessBoardTestGetY() {
        ChessBoard board = new ChessBoard();
        Piece piece1 = new Pawn(new Space(0, 3));
        board.setPieceInSpace(piece1);
        assertThat(piece1.getPieceSpace().getY(), is(3));
    }
}
