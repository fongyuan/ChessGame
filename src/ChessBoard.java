/**
 * Fong Yuan
 * 100285256
 *
 * A ChessBoard objected extened from Board
 */
public class ChessBoard extends Board{
	
	
	/**
	 * constructor that initializes the board size to 8x8 and populates the board with dummy pieces.
	 */
	public ChessBoard(){
		super(8, 8);
		start();
	}

	/**
	 *
	 * @param oCol original column location
	 * @param oRow original row location
	 * @param nCol new column location
	 * @param nRow new row location
	 * @param turn current player turn
	 * @return returns a string that determines if a player has input a valid movement
	 *
	 */
	public String movePiece(int oCol, int oRow, int nCol, int nRow, String turn){

		if(oRow >= 8 || nRow >= 8 || oRow < 0 || nRow < 0 || oCol >= 8 || nCol >=8 || oCol < 0 || nCol < 0){
			return "Out of bounds";
		}
		if(piecePositions[oCol][oRow].getType().equals("Dummy")) {
			return "There is no piece there.";
		}else if(oRow == nRow && oCol == nCol){
			return "Can not move piece to it's original location";
		}else if(!piecePositions[oCol][oRow].getColour().equals(turn)){
			return "Not your turn.";
		}else if(piecePositions[oCol][oRow].getColour().equals(piecePositions[nCol][nRow].getColour())) {
			return "Can not capture your own piece.";
		}else{
			move(oCol, oRow, nCol, nRow);
			remove(oCol, oRow);
			return null;
		}
	}

	/**
	 *
	 * @return returns a win state in the form of an integer.
	 */
	public int winCon(){
		int winCon = 0;

		for(int y = 0; y < piecePositions[0].length; y++){
			for(int x = 0; x < piecePositions.length; x++){
				if(piecePositions[x][y].getType().equals("King")){
					if(piecePositions[x][y].getColour().equals("white")){
						winCon += 1;
					}
					if(piecePositions[x][y].getColour().equals("black")){
						winCon -= 1;
					}
			}
		}

		}

		return winCon;
	}


}
