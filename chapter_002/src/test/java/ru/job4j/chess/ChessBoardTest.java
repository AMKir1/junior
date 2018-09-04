package ru.job4j.chess;

import org.junit.Test;
import ru.job4j.chess.piece.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ChessBoardTest {
    /**
     * Проверка передвижения фигуры по доске,
     */
    @Test
    public void chessBoardTestMove() {
        ChessBoard board = new ChessBoard();
        Piece piece1 = new King(new Space(0, 3));
        Piece piece2 = new Queen(new Space(0, 4));
        board.setPieceInSpace(piece1);
        board.setPieceInSpace(piece2);
        boolean result = true;
        assertThat(board.move(piece1.getPieceSpace(), new Space(1, 3)), is(result));
    }
    /**
     * Фигура не смогла передвинуться
     */
    @Test
    public void chessBoardTestMoveWithMistake() {
        ChessBoard board = new ChessBoard();
        Piece piece1 = new King(new Space(0, 3));
        Piece piece2 = new Queen(new Space(0, 4));
        board.setPieceInSpace(piece1);
        board.setPieceInSpace(piece2);
        boolean result = false;
        assertThat(board.move(piece2.getPieceSpace(), new Space(0, 9)), is(result));
    }
    /**
     * Проверка передвижения Коня по доске несколько раз
     */
    @Test
    public void chessBoardTestMoveKnightSomeTimes() {
        ChessBoard board = new ChessBoard();
        Piece piece1 = new Knight(new Space(0, 1));
        board.setPieceInSpace(piece1);
        board.move(piece1.getPieceSpace(), new Space(1, 3));
        board.setPieceInSpace(piece1);
        board.move(piece1.getPieceSpace(), new Space(3, 4));
        board.setPieceInSpace(piece1);
        board.move(piece1.getPieceSpace(), new Space(2, 2));
        board.setPieceInSpace(piece1);
        board.move(piece1.getPieceSpace(), new Space(0, 1));
        board.setPieceInSpace(piece1);
        Space space = new Space(0, 1);

        assertThat(piece1.getPieceSpace().getX(), is(space.getX()));
    }
    /**
     * Проверка передвижения Короля по доске несколько раз
     */
    @Test
    public void chessBoardTestMoveKingSomeTimes() {
        ChessBoard board = new ChessBoard();
        Piece piece1 = new King(new Space(1, 5));
        board.setPieceInSpace(piece1);
        board.move(piece1.getPieceSpace(), new Space(0, 6));
        board.setPieceInSpace(piece1);
        board.move(piece1.getPieceSpace(), new Space(1, 6));
        board.setPieceInSpace(piece1);
        board.move(piece1.getPieceSpace(), new Space(1, 7));
        board.setPieceInSpace(piece1);
        board.move(piece1.getPieceSpace(), new Space(2, 6));
        board.setPieceInSpace(piece1);
        board.move(piece1.getPieceSpace(), new Space(1, 5));
        board.setPieceInSpace(piece1);
        Space space = new Space(1, 5);

        assertThat(piece1.getPieceSpace().getX(), is(space.getX()));
    }
    /**
     * Проверка передвижения Пешки по доске несколько раз
     */
    @Test
    public void chessBoardTestMovePawnSomeTimes() {
        ChessBoard board = new ChessBoard();
        Piece piece1 = new Pawn(new Space(1, 1));
        board.setPieceInSpace(piece1);
        board.move(piece1.getPieceSpace(), new Space(1, 2));
        board.setPieceInSpace(piece1);
        board.move(piece1.getPieceSpace(), new Space(1, 3));
        board.setPieceInSpace(piece1);
        Space space = new Space(1, 3);

        assertThat(piece1.getPieceSpace().getX(), is(space.getX()));
    }
    /**
     * Проверка передвижения Слона по доске несколько раз
     */
    @Test
    public void chessBoardTestMoveBishopSomeTimes() {
        ChessBoard board = new ChessBoard();
        Piece piece1 = new Bishop(new Space(1, 1));
        board.setPieceInSpace(piece1);
        board.move(piece1.getPieceSpace(), new Space(2, 2));
        board.setPieceInSpace(piece1);
        board.move(piece1.getPieceSpace(), new Space(6, 6));
        board.setPieceInSpace(piece1);
        Space space = new Space(6, 6);
        assertThat(piece1.getPieceSpace().getX(), is(space.getX()));
    }
    /**
     * Проверка передвижения фигуры по доске с приградой
     */
    @Test
    public void chessBoardTestMoveWhenSpaceIsNotFree() {
        ChessBoard board = new ChessBoard();
        Piece piece1 = new King(new Space(0, 3));
        Piece piece2 = new Queen(new Space(0, 4));
        board.setPieceInSpace(piece1);
        board.setPieceInSpace(piece2);
        boolean result = true;
        assertThat(board.move(piece1.getPieceSpace(), new Space(0, 4)), is(!result));
    }
    /**
     * Проверка передвижения Ладьи по доске несколько раз
     */
    @Test
    public void chessBoardTestMoveRookSomeTimes() {
        ChessBoard board = new ChessBoard();
        Piece piece1 = new Rook(new Space(1, 1));
        Space space1 = new Space(1, 5);
        Space space2 = new Space(5, 5);
        Space space3 = new Space(5, 1);
        board.setPieceInSpace(piece1);
        board.move(piece1.getPieceSpace(), space1);
        board.setPieceInSpace(piece1);
        board.move(piece1.getPieceSpace(), space2);
        board.setPieceInSpace(piece1);
        board.move(piece1.getPieceSpace(), space3);
        board.setPieceInSpace(piece1);
        assertThat(piece1.getPieceSpace().getX(), is(space3.getX()));
    }
    /**
     * Проверка передвижения  по доске несколько раз
     */
    @Test
    public void chessBoardTestMoveQueenSomeTimes() {
        ChessBoard board = new ChessBoard();
        Piece piece1 = new Queen(new Space(1, 1));
        board.setPieceInSpace(piece1);
        board.move(piece1.getPieceSpace(), new Space(2, 2));
        board.setPieceInSpace(piece1);
        board.move(piece1.getPieceSpace(), new Space(2, 4));
        board.setPieceInSpace(piece1);
        Space space = new Space(2, 4);
        assertThat(piece1.getPieceSpace().getX(), is(space.getX()));
    }
}
