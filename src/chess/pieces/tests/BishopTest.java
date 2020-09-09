package chess.pieces.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import Principal.Chessboard;
import chess.pieces.Bishop;
import chess.pieces.Pawn;
import chess.util.Color;
import chess.util.Position;

public class BishopTest {

	@Test
	public void isValidTest() {
		
		Chessboard board = new Chessboard();
		Bishop bis = new Bishop(board,new Position("C1"),Color.BLACK);
		board.setPiece(new Position("C1"), bis);
		Pawn pa = new Pawn(board, new Position("D2"),Color.BLACK);
		board.setPiece(new Position("D2"), pa);
		System.out.println(board);
		
		assertEquals(true,bis.isValidMove(new Position("A3")));
		assertFalse(bis.isValidMove(new Position("C2")));
		assertEquals(false,bis.isValidMove(new Position("G5")));
		
		
	}

}
