package ru.job4j.chess;
/**
 * Chapter_002. Chess.
 * @author Andrei Kirillovykh (mailto:andykirill@gmail.com)
 * @version 1
 */
public class ChessBoard {

    private final Piece[][] cheesboard = new Piece[8][8];
    private Piece piece;

    public Piece[][] getCheesboard() {
        return this.cheesboard;
    }

    public void setPieceInSpace(Piece piece) {
        this.piece = piece;
        this.setSpaceForPiece(this.piece, this.piece.getPieceSpace());
    }


    private void setSpaceForPiece(Piece piece, Space nextSpace) {
        this.cheesboard[nextSpace.getX()][nextSpace.getY()] = piece.createPiece(nextSpace);
    }

    public boolean move(Space currSpace, Space nextSpace) {
        boolean result = true;

        if ((currSpace.getX() < 0 || currSpace.getX() > 7) || (currSpace.getY() < 0 || currSpace.getY() > 7)
         || (nextSpace.getX() < 0 || nextSpace.getX() > 7) || (nextSpace.getY() < 0 || nextSpace.getY() > 7)) {
            result = false;
        }

        Piece piece = this.cheesboard[currSpace.getX()][currSpace.getY()];
        Space[] place = piece.toGoFromCurrentSpaceToNextSpace(currSpace, nextSpace);
        if ((place != null) && result) {
            for (Space sp : place) {
                if (this.cheesboard[sp.getX()][sp.getY()] != null) {
                    result = false;
                }
            }
        }
        if (this.cheesboard[currSpace.getX()][currSpace.getY()] == null) {
            result = false;
        }
        if (result) {
            this.setPieceInSpace(piece.createPiece(nextSpace));
            this.cheesboard[currSpace.getX()][currSpace.getY()] = null;
        }
        return result;
    }
}
