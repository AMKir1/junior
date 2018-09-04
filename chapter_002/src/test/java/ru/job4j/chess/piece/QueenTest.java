package ru.job4j.chess.piece;

import org.junit.Test;
import ru.job4j.chess.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class QueenTest {
    /**
     * Попытка пойти как конь
     */
    @Test
    public void testQueenGoLikeAKnight() {
        ChessBoard board = new ChessBoard();
        Piece queen = new Queen(new Space(0, 1));
        board.setPieceInSpace(queen);
        boolean result = true;
        assertThat(board.move(queen.getPieceSpace(), new Space(2, 2)), is(!result));
    }
    /**
     * Попытка Ферзя пойти королевской походкой
     */
    @Test
    public void testQueenGoLikeAKing() {
        ChessBoard board = new ChessBoard();
        Piece queen = new Queen(new Space(0, 1));
        board.setPieceInSpace(queen);
        boolean result = true;
        assertThat(board.move(queen.getPieceSpace(), new Space(1, 1)), is(result));
    }
    /**
     * Ферзь решил выйти за рамки дозаоленного
     */
    @Test
    public void testQueenGoAnyWay() {
        ChessBoard board = new ChessBoard();
        Piece queen = new Queen(new Space(0, 1));
        board.setPieceInSpace(queen);
        boolean result = true;
        assertThat(board.move(queen.getPieceSpace(), new Space(-1, 3)), is(!result));
    }
    /**
     * Попытка пойти Ферзем как слоном
     */
    @Test
    public void testQueenGoLikeABishop() {
        ChessBoard board = new ChessBoard();
        Piece queen = new Queen(new Space(0, 1));
        board.setPieceInSpace(queen);
        boolean result = true;
        assertThat(board.move(queen.getPieceSpace(), new Space(4, 5)), is(result));
    }
    /**
     * Попытка пойти Ферзем как ладьей
     */
    @Test
    public void testQueenGoLikeARook() {
        ChessBoard board = new ChessBoard();
        Piece queen = new Queen(new Space(0, 1));
        board.setPieceInSpace(queen);
        boolean result = true;
        assertThat(board.move(queen.getPieceSpace(), new Space(7, 1)), is(result));
    }
    /**
     * Попытка пойти Ферзем как обычная пешка
     */
    @Test
    public void testQueenGoRight() {
        ChessBoard board = new ChessBoard();
        Piece queen = new Queen(new Space(1, 1));
        board.setPieceInSpace(queen);
        boolean result = true;
        assertThat(board.move(queen.getPieceSpace(), new Space(2, 1)), is(result));
    }
}
