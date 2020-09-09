package chess.util;

public class Position {
	
	private int x,y;
	
	/**
	 * Constructeur par default 
	 */
	public Position() {
		
		this.x = 0;
		this.y = 0;
	}
	
	/**
	 * Constructeur de la classe Position
	 * @param x
	 * @param y
	 */
	public Position(int x, int y) {
		if (x < 0 || x > 7 || y < 0 || y > 7)
			 throw new IllegalArgumentException("Position invalide : " + x + "," + y);
		
		this.x = x;
		this.y = y;
	}
	
	 /**
	  * Constructeur de la classe Position
	 * @param algebraicNotation
	 */
	public Position(String algebraicNotation) {
		
		char c1 = algebraicNotation.charAt(0);
		char c2 = algebraicNotation.charAt(1);
		
		if(c1 < 'A' || c1 > 'H' || c2 < '1' || c2 > '8') {
			throw new IllegalArgumentException("Position Invalide");
		}
		
		int ci1 = c1-'A';
		int ci2 = c2-'1';
		
		this.x = ci1;
		this.y = ci2;
		 
	}
	
	/**
	 * Accesseur de l'attribut X
	 * @return l'attribut X
	 */
	public int getX() {
		return this.x;
	}
	
	/**
	 *Affichage de la position
	 */
	@Override
	public String toString() {
		return  "(" + this.x + "," + this.y + ")";
	}
	 
	/**
	 *Methode de comparaison
	 */
	@Override
	public boolean equals(Object o) {
	 
		if (this == o)
			return true;
	 
		if (o == null || getClass() != o.getClass())
			return false;
	 
		Position position = (Position) o;
	 
		if (x != position.x)
			return false;
	 
		return y == position.y;
	}
	
	/**
	 * Accesseur de l'attribut y
	 * @return l'attribut y
	 */
	public int getY() {
		
		return this.y;
		
	}
	 /**
	 * @return
	 */
	public String toAlgebraicNotation() {
		 
		 char c1 = (char) (this.x + 'A');
		 char c2 = (char) (this.y + '1');
		 
		 
		 
		 String res = Character.toString(c1)+Character.toString(c2);
		 
		 
		 return res;
	 }

	 /**
	 * @param pos
	 * @return
	 */
	public boolean isOnSameLineAs(Position pos) {
		 
		 if(this.x == pos.getX()) {
			 return true;
		 }
		 else {
			 return false;
		 }
		 
	 }
	
	 /**
	 * @param pos
	 * @return
	 */
	public boolean isOnSameColumnAs(Position pos) {
		 if(this.y == pos.getY()) {
			 return true;
		 }
		 return false;
	 }
	
	 /**
	 * @param pos
	 * @return
	 */
	public boolean isOnSameDiagonalAs(Position pos) {
		 
		 return Math.abs(this.x - pos.x) == Math.abs(this.y - pos.y);
		 
	 }
	 /**
	 * @param pos
	 * @return
	 */
	public int getManhattanDistance(Position pos) {
		 
		return Math.abs(pos.getX()-this.x)+Math.abs(pos.getY()-this.y); 
		 
	 }
	
	
	
	
	
	

}
