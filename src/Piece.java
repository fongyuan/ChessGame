import java.awt.Graphics2D;

/**
 * Fong Yuan
 * 100285256
 *
 * An abstract object that is the basis of all chess pieces.
 */
abstract public class Piece {


	public Piece(){

	}
	
	
	abstract public String getType();
		
	abstract public String getColour();
		
	abstract public void printPiece();
	
	abstract public void paint(Graphics2D g);
	
	abstract public void setPos(int column, int row);
	
	abstract public void moveImg(int x, int y);
	
	
}
