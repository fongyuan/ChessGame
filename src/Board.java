import java.awt.Graphics2D;


/**
 * Fong Yuan
 * 100285256
 *
 * A Board object that simulates an nxn board
 */
public class Board{
	
	protected Piece[][] piecePositions;
	private BackGround[][] theBackGround;
	
	/**
	 *
	 * @param column number of columns on the board
	 * @param row number of rows on the board
	 *
	 * Constructor that initializes piecePositions to a 2D array equal the to the size of the parameters
	 */
	public Board(int column, int row){
		piecePositions = new Piece[column][row];
		theBackGround = new BackGround[column][row];
				
	}

	/**
	 * Fills board with dummy pieces
	 */
	public void start(){
		for(int y = piecePositions.length - 1; y >= 0; y--){
			for(int x = 0; x < piecePositions[0].length; x++){
				place(new Dummy(),x,y);
			}
		}
		for(int y = 0; y < theBackGround.length; y++){
			for(int x = 0; x < theBackGround[0].length; x++){
				theBackGround[y][x] = new BackGround(x , y);
			}
		}
		
	}

	/**
	 * Prints the board state out to the console
	 */
	public void print(){
		System.out.println("   a  b  c  d  e  f  g  h");
		System.out.println();
		for(int y = piecePositions.length - 1; y >= 0; y--){
			System.out.print(y + 1 + "  ");
			for(int x = 0; x < piecePositions[0].length; x++){
				piecePositions[x][y].printPiece();
				System.out.print(" ");
			}
			System.out.println();
			System.out.println();
			
		}
		System.out.println("   a  b  c  d  e  f  g  h");
	}

	/**
	 *
	 * @param p type of Piece
	 * @param column column location
	 * @param row row location
	 */
	public void place(Piece p, int column, int row){
		piecePositions[column][row] = p;
		piecePositions[column][row].setPos(column,row);
	}

	/**
	 *
	 * @param oCol original column location
	 * @param oRow original row location
	 * @param nCol new column location
	 * @param nRow new row location
	 *
	 * moves pieces by swapping their locations in the 2D array
	 */
	public void move(int oCol, int oRow, int nCol, int nRow){
	
		Piece temp = piecePositions[oCol][oRow];
		piecePositions[nCol][nRow] = piecePositions[oCol][oRow];
		piecePositions[oCol][oRow] = temp;

		piecePositions[oCol][oRow].setPos(oCol,oRow);
		piecePositions[nCol][nRow].setPos(nCol,nRow);
		
	}

	/**
	 *
	 * @param column column location
	 * @param row row location
	 *
	 * replaces the object at the row,col location with a dummy object
	 */
	public void remove(int column, int row){
		piecePositions[column][row] = new Dummy("n/a",column, row);
	}

	/**
	 *
	 * @param column column location
	 * @param row row location
	 * @return returns empty space if the object at location row,col in the array is a dummy, otherwise returns
	 * 			 the type of piece
	 */
	public String look(int column, int row){
		if(piecePositions[column][row].getType().equals("Dummy")){
			return "empty space";
		} 
		else{
			return piecePositions[column][row].getType();
		}
		
	}

	/**
	 *
	 * @param g2
	 *
	 * Has the background paint itself and then paints every piece in their proper locations
	 */
	public void paint(Graphics2D g2){
		for(int y = 0; y < theBackGround.length; y++){
			for(int x = 0; x < theBackGround[0].length; x++){
				theBackGround[y][x].draw(g2);
			}
		}
		
		for(int y = 0; y < piecePositions.length; y++){
			for(int x = 0; x < piecePositions[0].length; x++){
				piecePositions[y][x].paint(g2);
			}
		}

	}
}
