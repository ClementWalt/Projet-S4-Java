package chess.pieces;

import Principal.Chessboard;
import chess.util.Color;
import chess.util.Position;
import chess.util.Symbol;

public class Rook extends Piece {

	public Rook(Chessboard board, Position position, Color color) {

		super(board, position, color, "Rook", color == Color.WHITE ? Symbol.WHITE_ROOK() : Symbol.BLACK_ROOK());
	}

	@Override
	public boolean isValidMove(Position destination) {

		if (destination.isOnSameLineAs(this.getPosition()) ||
				destination.isOnSameColumnAs(this.getPosition())) {

			if (this.board.isPiecePresentOnSameLineBetween(this.getPosition(), destination) == false ||
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
