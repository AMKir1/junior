package ru.job4j.chess.piece;

import org.junit.Test;
import ru.job4j.chess.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class BishopTest {
    /**
     * Попытка пойти слоном по вертикали
     */
    @Test
    public void testBishopGoUp() {
        ChessBoard board = new ChessBoard();
        Piece bishop = new Bishop(new Space(1, 1));
        board.setPieceInSpace(bishop);
        boolean result = true;
        assertThat(board.move(bishop.getPieceSpace(), new Space(1, 2)), is(!result));
    }
    /**
     * Попытка пойти слоном по горизонтали
     */
    @Test
    public void testBishopGoRight() {
        ChessBoard board = new ChessBoard();
        Piece bishop = new Bishop(new Space(1, 1));
        board.setPieceInSpace(bishop);
        boolean result = true;
        assertThat(board.move(bishop.getPieceSpace(), new Space(2, 1)), is(!result));
    }
    /**
     * Попытка пойти слоном по диагонали НИЗ-СПРАВА
     */
    @Test
    public void testBishopGoDownLeft() {
        ChessBoard board = new ChessBoard();
        Piece bishop = new Bishop(new Space(3, 3));
        board.setPieceInSpace(bishop);
        boolean result = true;
        assertThat(board.move(bishop.getPieceSpace(), new Space(6, 0)), is(result));
    }
    /**
     * Попытка пойти слоном по диагонали НИЗ-СЛЕВА если закончилась доска
     */
    @Test
    public void testBishopGoDownRightOnEdgeOfTheBoard() {
        ChessBoard board = new ChessBoard();
        Piece bishop = new Bishop(new Space(1, 1));
        board.setPieceInSpace(bishop);
        boolean result = true;
        assertThat(board.move(bishop.getPieceSpace(), new Space(5, 1)), is(!result));
    }
    /**
     * Попытка пойти слоном по диагонали ВВЕРХ-СЛЕВА
     */
    @Test
    public void testBishopGoUpLeft() {
        ChessBoard board = new ChessBoard();
        Piece bishop = new Bishop(new Space(3, 3));
        board.setPieceInSpace(bishop);
        boolean result = true;
        assertThat(board.move(bishop.getPieceSpace(), new Space(0, 0)), is(result));
    }
    /**
     * Попытка пойти слоном по диагонали ВВЕРХ-СЛЕВА
     */
    @Test
    public void testBishopGoUpRight() {
        ChessBoard board = new ChessBoard();
        Piece bishop = new Bishop(new Space(3, 3));
        board.setPieceInSpace(bishop);
        boolean result = true;
        assertThat(board.move(bishop.getPieceSpace(), new Space(0, 6)), is(result));
    }
    /**
     * Попытка пойти слоном по диагонали НИЗ-СЛЕВА
     */
    @Test
    public void testBishopGoDownRight() {
        ChessBoard board = new ChessBoard();
        Piece bishop = new Bishop(new Space(3, 3));
        board.setPieceInSpace(bishop);
        boolean result = true;
        assertThat(board.move(bishop.getPieceSpace(), new Space(6, 6)), is(result));
    }


}
