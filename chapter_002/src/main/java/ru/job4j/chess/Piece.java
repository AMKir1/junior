package ru.job4j.chess;

public interface Piece {

    Space getPieceSpace();

    Space[] toGoFromCurrentSpaceToNextSpace(Space currSpace, Space nextSpace);

    Piece createPiece(Space nextSpace);

    default boolean equals(Piece piece) {
        return this.getPieceSpace().getX() == piece.getPieceSpace().getX()
                && this.getPieceSpace().getY() == piece.getPieceSpace().getY()
                && this.getClass() == piece.getClass();
    }
}