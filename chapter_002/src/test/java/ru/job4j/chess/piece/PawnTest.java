package ru.job4j.chess.piece;

import org.junit.Test;
import ru.job4j.chess.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PawnTest {
    /**
     * Проверка хода вверх
     */
    @Test
    public void testPawnGoUp() {
        ChessBoard board = new ChessBoard();
        Piece pawn = new Pawn(new Space(1, 1));
        board.setPieceInSpace(pawn);
        boolean result = true;
        assertThat(board.move(pawn.getPieceSpace(), new Space(1, 2)), is(result));
    }
    /**
     * Проверка хода вверх на две клетки
     */
    @Test
    public void testPawnGoUpThrowTwoSpace() {
        ChessBoard board = new ChessBoard();
        Piece pawn = new Pawn(new Space(1, 1));
        board.setPieceInSpace(pawn);
        boolean result = true;
        assertThat(board.move(pawn.getPieceSpace(), new Space(1, 3)), is(result));
    }
    /**
     * Проверка хода вверх на три клетки
     */
    @Test
    public void testPawnGoUpThrowThreeSpace() {
        ChessBoard board = new ChessBoard();
        Piece pawn1 = new Pawn(new Space(1, 1));
        board.setPieceInSpace(pawn1);
        boolean result = true;
        assertThat(board.move(pawn1.getPieceSpace(), new Space(1, 4)), is(!result));
    }
    /**
     * Проверка хода назад
     */
    @Test
    public void testPawnGoBack() {
        ChessBoard board = new ChessBoard();
        Piece pawn2 = new Pawn(new Space(1, 2));
        board.setPieceInSpace(pawn2);
        boolean result = true;
        assertThat(board.move(pawn2.getPieceSpace(), new Space(0, 2)), is(!result));
    }
    /**
     * Проверка хода в сторону
     */
    @Test
    public void testPawnGoLeft() {
        ChessBoard board = new ChessBoard();
        Piece pawn = new Pawn(new Space(1, 2));
        board.setPieceInSpace(pawn);
        boolean result = true;
        assertThat(board.move(pawn.getPieceSpace(), new Space(3, 2)), is(!result));
    }
}
