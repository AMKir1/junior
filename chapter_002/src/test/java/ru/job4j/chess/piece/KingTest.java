package ru.job4j.chess.piece;

import org.junit.Test;
import ru.job4j.chess.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class KingTest {
    /**
     * Попытка пойти королем по диагонали (ВВЕРХ-ПРАВО)
     */
    @Test
    public void testKingGoUpRight() {
        ChessBoard board = new ChessBoard();
        Piece king = new King(new Space(0, 3));
        board.setPieceInSpace(king);
        boolean result = true;
        assertThat(board.move(king.getPieceSpace(), new Space(1, 2)), is(result));
    }
    /**
     * Попытка пойти королем ВВЕРХ
     */
    @Test
    public void testKingGoUp() {
        ChessBoard board = new ChessBoard();
        Piece king = new King(new Space(0, 3));
        board.setPieceInSpace(king);
        boolean result = true;
        assertThat(board.move(king.getPieceSpace(), new Space(1, 3)), is(result));
    }
    /**
     * Попытка пойти королем в НИЗ когда в низу обрывается доска
     */
    @Test
    public void testKingGoDownWithMistake() {
        ChessBoard board = new ChessBoard();
        Piece king = new King(new Space(0, 3));
        board.setPieceInSpace(king);
        boolean result = true;
        assertThat(board.move(king.getPieceSpace(), new Space(-1, 2)), is(!result));
    }
    /**
     * Попытка пойти королем в НИЗ
     */
    @Test
    public void testKingGoDown() {
        ChessBoard board = new ChessBoard();
        Piece king = new King(new Space(1, 3));
        board.setPieceInSpace(king);
        boolean result = true;
        assertThat(board.move(king.getPieceSpace(), new Space(0, 3)), is(result));
    }
    /**
     * Попытка пойти королем ВЛЕВО
     */
    @Test
    public void testKingGoLeft() {
        ChessBoard board = new ChessBoard();
        Piece king = new King(new Space(0, 3));
        board.setPieceInSpace(king);
        boolean result = true;
        assertThat(board.move(king.getPieceSpace(), new Space(0, 4)), is(result));
    }
    /**
     * Попытка пойти королем, больше одной клетки за ход
     */
    @Test
    public void testKingGoToOtherSide() {
        ChessBoard board = new ChessBoard();
        Piece king = new King(new Space(0, 3));
        board.setPieceInSpace(king);
        boolean result = true;
        assertThat(board.move(king.getPieceSpace(), new Space(7, 3)), is(!result));
    }




}
