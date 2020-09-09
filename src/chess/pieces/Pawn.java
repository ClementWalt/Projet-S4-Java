package chess.pieces;

import Principal.Chessboard;
import chess.util.Color;
import chess.util.Position;
import chess.util.Symbol;

public class Pawn extends Piece {

	private boolean notMovedYet = true;

	public Pawn(Chessboard board, Position position, Color color) {

		super(board, position, color, "Pawn", color == Color.WHITE ? Symbol.WHITE_PAWN() : Symbol.BLACK_PAWN());

	}

	@Override
	public boolean isValidMove(Position destination) {

		if (destination.isOnSameColumnAs(this.getPosition())) {

			if (this.board.isPiecePresentOnSameColumnBetween(this.getPosition(), destination) == false) {
				
				if (this.board.getPiece(destination) == null
						|| this.board.getPiece(destination).getColor() != this.getColor()) {

					if (this.notMovedYet && this.getPosition().getManhattanDistance(destination) <= 2) {

						return true;
					} 
					else if (this.getPosition().getManhattanDistance(destination) < 2) {

						return true;
					}
				}
			}
			
			else if(destination.isOnSameDiagonalAs(this.getPosition())) {
				
				if (this.board.isPiecePresentOnSameDiagonalBetween(this.getPosition(), destination) == true) {
					
					if (this.board.getPiece(destination).getColor() != this.getColor()) {
						
						if (this.getPosition().getManhattanDistance(destination) < 2) {
							
							return true;
						}
					}
				}
			}

		}
		return false;
	}
	
	
	public void moveTo(Position destination) {

		if (this.isValidMove(destination)) {

			this.moveTo(destination);
			this.notMovedYet = false;
		}
	}
}
