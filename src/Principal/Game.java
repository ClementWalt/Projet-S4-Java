package Principal;
import chess.util.ChessMoveException;
import chess.util.Color;
import chess.util.Position;

public class Game {

	private String whitePlayerName;
	private String blackPlayerName;
	private Chessboard board;
	private Color currentColor = Color.WHITE;
	
	
	public Game(String whitePlayerName, String blackPlayerName) {
		
		this.blackPlayerName = blackPlayerName;
		this.whitePlayerName = whitePlayerName;
	}
	
	
	public String getWhitePlayerName() {
		return this.whitePlayerName;
	}
	
	public String getBlackPlayerName() {
		return this.blackPlayerName;
	}
	public Color getCurrentColor() {
		return this.currentColor;
	}
	
	public void turn(Position start, Position end) throws ChessMoveException {
		
		
		if(board.getPiece(start) == null 
				|| board.getPiece(start).getColor() != this.currentColor 
				|| board.getPiece(start).isValidMove(end)) {
			
			throw new ChessMoveException("Déplacement Impossible",start,end);
			
		}
		
		else {
			
			if(this.currentColor == Color.BLACK) {
				this.currentColor = Color.WHITE;
				
			}
			else {
				this.currentColor = Color.BLACK;
			}
			
		}
		
		
	}
	
	public static void main(String[] args) {}

}
