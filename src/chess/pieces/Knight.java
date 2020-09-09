package chess.pieces;

import Principal.Chessboard;
import chess.util.Color;
import chess.util.Position;
import chess.util.Symbol;

public class Knight extends Piece{

	public Knight(Chessboard board,Position position, Color color) {
		
		super(board, position, color, "Knight", color == Color.WHITE ? Symbol.WHITE_KNIGHT() : Symbol.BLACK_KNIGHT());
	}
	
	
	@Override
	public boolean isValidMove(Position destination) {
		
		if(this.getPosition().isOnSameColumnAs(destination) == false &&
				this.getPosition().isOnSameLineAs(destination) == false &&
				this.getPosition().isOnSameDiagonalAs(destination) == false) {
		
			if(this.getPosition().getManhattanDistance(destination)==3) {
				if(this.board.getPiece(destination) == null || this.board.getPiece(destination).getColor() != this.getColor() ) {
			
					return true;
				}
			}
		}
		
		return false;
		
		
	}
}
