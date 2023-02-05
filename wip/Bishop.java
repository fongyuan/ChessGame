/**
 * Fong Yuan
 * 100285256
 * 
 * object to represent a Bishop piece in the game of Chess. 
 */


public class Bishop extends Piece {

	/**
	 * 
	 * @param col Colour of the piece
	 * @param pos Position of the piece on the board
	 * Constructor that initializes the colour, position and type of piece
	 */
	public Bishop(String col, int x, int y){
		setColour(col);
		setPos(x, y);
		setType("Bishop");
	}
	
	
	/**
	 * print it's own piece details.
	 */
	public void printPiece(){
		System.out.print("" + getType().charAt(0) + getColour().charAt(0));
	}

}
