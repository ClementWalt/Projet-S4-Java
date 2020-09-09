package chess.pieces;

import Principal.Chessboard;
import chess.util.ChessMoveException;
import chess.util.Color;
import chess.util.Position;

public abstract class Piece extends Object{

	private Position position;
	private final char symbol;
	private final Color color;
	private final String name;
	protected final Chessboard board;

	public Piece(Chessboard board, Position position, Color color, String name, char symbol) {

		this.board = board;
		this.position = position;
		this.color = color;
		this.name = name;
		this.symbol = symbol;

	}

	public char getSymbol() {
		return this.symbol;
	}

	public Color getColor() {
		return this.color;
	}

	public Position getPosition() {
		return this.position;
	}

	public String getName() {
		return this.name;
	}

	public boolean isBlack() {
		if (this.color == Color.BLACK) {
			return true;
		}
		return false;
	}

	public boolean isWhite() {
		if (this.color == Color.WHITE) {
			return true;
		}
		return false;

	}

	public void moveTo(Position destination) throws ChessMoveException {
		
		if (this.isValidMove(destination)) {
		
			this.position = destination;
	
		}
		
		else {
			
			throw new ChessMoveException("Le mouvement n'est pas possible", this.position, destination);
			
		}
	}

	public abstract boolean isValidMove(Position destination);

}
