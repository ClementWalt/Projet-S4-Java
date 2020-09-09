package Principal;

import chess.pieces.Bishop;
import chess.pieces.King;
import chess.pieces.Knight;
import chess.pieces.Pawn;
import chess.pieces.Piece;
import chess.pieces.Queen;
import chess.pieces.Rook;
import chess.util.ChessMoveException;
import chess.util.Color;
import chess.util.Position;

public class Chessboard {

	private Piece[][] pieces = new Piece[8][8];

	public Chessboard() {
		
		for(int i=7 ; i>=0; i--) {
			
			this.pieces[i][1] = new Pawn(this, new Position(1,i),Color.WHITE);
			this.pieces[i][6] = new Pawn(this, new Position(6,i),Color.BLACK);
				
			switch(i) {
				
			case 0 :
			case 7 :
				this.pieces[i][0] = new Rook(this, new Position(0,i),Color.WHITE);
				this.pieces[i][7] = new Rook(this, new Position(7,i),Color.BLACK);
				break;
			case 1:
			case 6:
				this.pieces[i][0] = new Bishop(this, new Position(0,i),Color.WHITE);
				this.pieces[i][7] = new Bishop(this, new Position(7,i),Color.BLACK);
				break;
			case 2:
			case 5:
				this.pieces[i][0] = new Knight(this, new Position(0,i),Color.WHITE);
				this.pieces[i][7] = new Knight(this, new Position(7,i),Color.BLACK);
				break;
			case 3:
				this.pieces[i][0] = new King(this, new Position(0,i),Color.WHITE);
				this.pieces[i][7] = new Queen(this, new Position(7,i),Color.BLACK);
				break;
			case 4:
				this.pieces[i][0] = new Queen(this, new Position(0,i),Color.WHITE);
				this.pieces[i][7] = new King(this, new Position(7,i),Color.BLACK);
				break;
			}
				
		}
		

	}

	public Piece getPiece(int x, int y) {

		if (pieces[y][x] != null) {

			return pieces[y][x];

		}

		return null;

	}

	public Piece getPiece(Position pos) {

		if (pieces[pos.getX()][pos.getY()] != null) {

			return pieces[pos.getX()][pos.getY()];
		}

		return null;
	}

	public void setPiece(Position pos, Piece newPiece) {

		this.pieces[pos.getX()][pos.getY()] = newPiece;

	}

	
	public boolean isPiecePresentOnSameDiagonalBetween(Position start, Position end) {

        if (!start.isOnSameDiagonalAs(end))
            throw new IllegalArgumentException("les pièces ne sont pas sur la même diagonales");
        for (int i = 0; i < Math.abs(end.getY() - start.getY()) - 1; i++) {
            if (this.getPiece(start.getX() + (end.getX() - start.getX() > 0 ? i + 1 : -i - 1),
                    start.getY() + (end.getY() - start.getY() > 0 ? i + 1 : -i - 1)) != null) {

                return true;
            }

        }
        return false;
    }
	 

	public boolean isPiecePresentOnSameColumnBetween(Position start, Position end) {

		if (start.isOnSameColumnAs(end)) {

			boolean res = false;

			if (start.getX() < end.getX()) {

				for (int i = start.getX(); i < end.getX(); i++) {

					if (pieces[i][start.getY()] != null) {
						res = true;
					}

				}

			}

			else {

				for (int i = start.getX(); i < end.getX(); i--) {

					if (pieces[i][start.getY()] != null) {
						res = true;
					}

				}

			}

			return res;

		}

		else {

			throw new IllegalArgumentException("les pièces ne sont pas sur la même colonne");
		}

	}

	public boolean isPiecePresentOnSameLineBetween(Position start, Position end) {

		if (start.isOnSameLineAs(end)) {

			boolean res = false;

			if (start.getY() < end.getY()) {

				for (int i = start.getY(); i < end.getY(); i++) {

					if (pieces[start.getX()][i] != null) {
						res = true;
					}

				}

			}

			else {

				for (int i = start.getY(); i < end.getY(); i--) {

					if (pieces[start.getX()][i] != null) {
						res = true;
					}

				}

			}

			return res;

		}

		else {

			throw new IllegalArgumentException("les pièces ne sont pas sur la même ligne");
		}

	}
	
	public String toString() {
		StringBuilder builder = new StringBuilder();
		
		builder.append("     A   B   C   D   E   F   G   H \n   ┏━━━┳━━━┳━━━┳━━━┳━━━┳━━━┳━━━┳━━━┓");
		for(int i= 8; i >= 1; i-- ) {
			builder.append("\n "+i);
			for(int j= 1; j<=8; j++) {
				builder.append(" ┃ ");
				if(this.getPiece(i-1,j-1) == null)
					builder.append(" ");
				else {
					builder.append(pieces[j-1][i-1].getSymbol());
				}
			}
			if(i != 1) {
				builder.append(" ┃ " + i+"\n   ┣━━━╋━━━╋━━━╋━━━╋━━━╋━━━╋━━━╋━━━┫");
			}
			else {
				builder.append(" ┃ " + i+"\n   ┗━━━┻━━━┻━━━┻━━━┻━━━┻━━━┻━━━┻━━━┛\n" + 
						"     A   B   C   D   E   F   G   H");
			}
				
		}
		
		
		
		return builder.toString();
	}

	
	public static void main(String[] args) {
		
		Chessboard chess = new Chessboard();
		System.out.print(chess);
		
		//chess.getPiece(0,0);
		
	}
	
}





