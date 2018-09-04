package ru.job4j.chess.piece;

import org.junit.Test;
import ru.job4j.chess.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class KnightTest {
    /**
     * Попытка пойти конем правильно
     */
    @Test
    public void testKnightGo() {
        ChessBoard board = new ChessBoard();
        Piece knight = new Knight(new Space(0, 1));
        board.setPieceInSpace(knight);
        boolean result = true;
        assertThat(board.move(knight.getPieceSpace(), new Space(2, 2)), is(result));
    }
    /**
     * Попытка коня пойти королевской походкой
     */
    @Test
    public void testKnightGoLikeAKing() {
        ChessBoard board = new ChessBoard();
        Piece knight = new Knight(new Space(0, 1));
        board.setPieceInSpace(knight);
        boolean result = true;
        assertThat(board.move(knight.getPieceSpace(), new Space(1, 1)), is(!result));
    }
    /**
     * Конь решил выйти за рамки дозаоленного
     */
    @Test
    public void testKnightGoAnyWay() {
        ChessBoard board = new ChessBoard();
        Piece knight = new Knight(new Space(0, 1));
        board.setPieceInSpace(knight);
        boolean result = true;
        assertThat(board.move(knight.getPieceSpace(), new Space(-1, 3)), is(!result));
    }
    /**
     * Попытка пойти конем как слоном
     */
    @Test
    public void testKnightGoLikeABishop() {
        ChessBoard board = new ChessBoard();
        Piece knight = new Knight(new Space(0, 1));
        board.setPieceInSpace(knight);
        boolean result = true;
        assertThat(board.move(knight.getPieceSpace(), new Space(4, 5)), is(!result));
    }
    /**
     * Попытка пойти конем как ладьей
     */
    @Test
    public void testKnightGoLikeARook() {
        ChessBoard board = new ChessBoard();
        Piece knight = new Knight(new Space(0, 1));
        board.setPieceInSpace(knight);
        boolean result = true;
        assertThat(board.move(knight.getPieceSpace(), new Space(7, 1)), is(!result));
    }
    /**
     * Попытка пойти конем если есть ограничение
     */
    @Test
    public void testKnightGoRight() {
        ChessBoard board = new ChessBoard();
        Piece knight = new Knight(new Space(1, 1));
        board.setPieceInSpace(knight);
        boolean result = true;
        assertThat(board.move(knight.getPieceSpace(), new Space(0, 3)), is(result));
    }
}
