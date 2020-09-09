package chess.pieces;

import Principal.Chessboard;
import chess.util.Color;
import chess.util.Position;
import chess.util.Symbol;

public class Bishop extends Piece {
	
	public Bishop(Chessboard board,Position position, Color color){
		
		super(board, position, color, "Bishop", color == Color.WHITE ? Symbol.WHITE_BISHOP() : Symbol.BLACK_BISHOP());

	}

	@Override
	public boolean isValidMove(Position destination) {
		
		if(destination.isOnSameDiagonalAs(this.getPosition())) {
			
			if(this.board.isPiecePresentOnSameDiagonalBetween(this.getPosition(), destination) == false) {
				
				System.out.println("oui");
				
				if(this.board.getPiece(destination) == null || this.board.getPiece(destination).getColor() != this.getColor() ) {
					
					return true;
				}
			}
			
		}
		
		return false;
		
	}

}
