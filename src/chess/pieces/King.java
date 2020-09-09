package chess.pieces;

import Principal.Chessboard;
import chess.util.Color;
import chess.util.Position;
import chess.util.Symbol;

public class King extends Piece {

	public King(Chessboard board, Position position, Color color) {

		super(board, position, color, "King", color == Color.WHITE ? Symbol.WHITE_KING() : Symbol.BLACK_KING());

	}

	@Override
	public boolean isValidMove(Position destination) {

		if (destination.isOnSameDiagonalAs(this.getPosition()) || destination.isOnSameLineAs(this.getPosition())
				|| destination.isOnSameColumnAs(this.getPosition())) {

			if (this.board.isPiecePresentOnSameDiagonalBetween(this.getPosition(), destination) == false
					|| this.board.isPiecePresentOnSameLineBetween(this.getPosition(), destination) == false
					|| this.board.isPiecePresentOnSameColumnBetween(this.getPosition(), destination) == false) {

				if (this.board.getPiece(destination) == null
						|| this.board.getPiece(destination).getColor() != this.getColor()) {

					if (this.getPosition().getManhattanDistance(destination) < 2) {

						return true;
					}
				}

			}

		}

		return false;

	}
}
