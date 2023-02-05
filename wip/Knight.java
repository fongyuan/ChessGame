/**
 * Fong Yuan
 * 100285256
 * 
 * object to represent a Knight piece in the game of Chess. 
 */


public class Knight extends Piece {

	/**
	 * 
	 * @param col Colour of the piece
	 * @param pos Position of the piece on the board
	 * Constructor that initializes the colour, position and type of piece
	 */
	public Knight(String col, int x, int y){
		setColour(col);
		setPos(x, y);
		setType("Knight");
	}
	
	
	/**
	 * print it's own piece details.
	 */
	public void printPiece(){
		System.out.print("" + getType().toUpperCase().charAt(1) + getColour().charAt(0));
	}

}
