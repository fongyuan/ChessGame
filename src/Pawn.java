import java.awt.Graphics2D;

/**
 * Fong Yuan
 * 100285256
 * 
 * object to represent a Pawn piece in the game of Chess. 
 */


public class Pawn extends Piece {
		
	private int x;
	private int y;
	
	private String type;
	private String colour;
	private MyImg pawnImg;

	/**
	 *
	 * @param col colour of the piece
	 * @param x x coordinate of the piece relative to the board
	 * @param y y coordinate of the piece relative to the board
	 */
	public Pawn(String col, int x, int y){
		colour = col;
		this.x = 40+x*45; //sets x y values to absolute coordinates
		this.y = 40+y*45;
		
		type = "Pawn";
		//determines which colour piece to use
		if(col.equalsIgnoreCase("white")){
			pawnImg = new MyImg(Definition.IMG_PAWN_WHITE, this.x, this.y);
		}else{
			pawnImg = new MyImg(Definition.IMG_PAWN_BLACK, this.x, this.y);
		}
		
	}

	/**
	 *
	 * @param column column number relative to the board
	 * @param row row number relative to the board
	 */
	public void setPos(int column, int row){
		x = 40+column*45;
		y = 40+row*45;
		pawnImg.move(x, y);

	}

	/**
	 *
	 * @param x x coordinate
	 * @param y y coordinate
	 */
	public void moveImg(int x, int y){
		pawnImg.move(x, y);
	}

	/**
	 *
	 * @return returns the type of piece
	 */
	public String getType(){
		return type;
	}

	/**
	 *
	 * @return returns colour of piece
	 */
	public String getColour(){
		return colour;
	}
	
	/**
	 * print it's own piece details.
	 */
	public void printPiece(){
		System.out.print("" + getType().charAt(0) + getColour().charAt(0));
	}

	/**
	 *
	 * @param g2
	 *
	 * paints itself
	 */
	public void paint(Graphics2D g2){
		pawnImg.paint(g2);
	}
}
