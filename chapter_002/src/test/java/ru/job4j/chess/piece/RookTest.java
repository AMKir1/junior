package ru.job4j.chess.piece;

import org.junit.Test;
import ru.job4j.chess.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class RookTest {
    /**
     * Попытка пойти как конь
     */
    @Test
    public void testRookGoLikeAKnight() {
        ChessBoard board = new ChessBoard();
        Piece rook = new Rook(new Space(0, 1));
        board.setPieceInSpace(rook);
        boolean result = true;
        assertThat(board.move(rook.getPieceSpace(), new Space(2, 2)), is(!result));
    }
    /**
     * Попытка пойти прямо
     */
    @Test
    public void testRookGoUp() {
        ChessBoard board = new ChessBoard();
        Piece rook = new Rook(new Space(0, 1));
        board.setPieceInSpace(rook);
        boolean result = true;
        assertThat(board.move(rook.getPieceSpace(), new Space(6, 1)), is(result));
    }
    /**
     * Попытка выйти за рамки дозаоленного
     */
    @Test
    public void testRookGoAnyWay() {
        ChessBoard board = new ChessBoard();
        Piece rook = new Rook(new Space(0, 1));
        board.setPieceInSpace(rook);
        boolean result = true;
        assertThat(board.move(rook.getPieceSpace(), new Space(-1, 1)), is(!result));
    }
    /**
     * Попытка пойти как слон
     */
    @Test
    public void testRookGoLikeABishop() {
        ChessBoard board = new ChessBoard();
        Piece rook = new Rook(new Space(0, 1));
        board.setPieceInSpace(rook);
        boolean result = true;
        assertThat(board.move(rook.getPieceSpace(), new Space(4, 5)), is(!result));
    }
    /**
     * Попытка пойти в бок
     */
    @Test
    public void testRookGoRight() {
        ChessBoard board = new ChessBoard();
        Piece rook = new Rook(new Space(0, 1));
        board.setPieceInSpace(rook);
        boolean result = true;
        assertThat(board.move(rook.getPieceSpace(), new Space(0, 7)), is(result));
    }


}
