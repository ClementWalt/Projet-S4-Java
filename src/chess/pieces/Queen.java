package chess.pieces;

import Principal.Chessboard;
import chess.util.Color;
import chess.util.Position;
import chess.util.Symbol;

public class Queen extends Piece {

	public Queen(Chessboard board, Position position, Color color) {

		super(board, position, color, "Queen", color == Color.WHITE ? Symbol.WHITE_QUEEN() : Symbol.BLACK_QUEEN());

	}

	@Override
	public boolean isValidMove(Position destination) {

		if (destination.isOnSameDiagonalAs(this.getPosition()) ||
				destination.isOnSameLineAs(this.getPosition()) ||
				destination.isOnSameColumnAs(this.getPosition())) {

			if (this.board.isPiecePresentOnSameDiagonalBetween(this.getPosition(), destination) == false ||
					this.board.isPiecePresentOnSameLineBetween(this.getPosition(), destination) == false ||
					this.board.isPiecePresentOnSameColumnBetween(this.getPosition(), destination) == false) {

				if (this.board.getPiece(destination) == null
						|| this.board.getPiece(destination).getColor() != this.getColor()) {

					return true;
				}
			}

		}

		return false;

	}
}
