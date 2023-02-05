import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JComponent;

/**
 * Fong Yuan
 * 100285256
 *
 * A ChessViewer object that extends JComponent
 */

public class ChessViewer extends JComponent{
	
	private ChessBoard chess;
	private int oCol;
	private int oRow;
	private int nCol;
	private int nRow;
	private boolean clicked;
	private boolean dragged;
	private String message;
	private String turn;
	private int win;

	/**
	 *
	 * @param mouseClick mouseClick listener
	 * @param mouseDrag mouseDrag listener
	 *
	 * Constructor that initializes the chess board and populates it with all the proper starting pieces.
	 */
	public ChessViewer(MouseListener mouseClick, MouseMotionListener mouseDrag){

		chess = new ChessBoard();
		turn = "white";
		clicked = false;
		win = 0;

		/**
		 * Sub classes that performs actions when the associated mouse action occurs
		 */
		class MousePressListener implements MouseListener{  
			public void mousePressed(MouseEvent event){  
				
				if(clicked == false){
					oCol = (event.getX() - 40) / 45; //obtains relative coordinates to the board
					oRow = (event.getY() - 40) / 45;
					//System.out.println("col " + oCol + " row " + oRow);

				}

			}

			public void mouseReleased(MouseEvent event){
				if(clicked == true){
					nCol = (event.getX() - 40) / 45; //obtains relative coordinates to the board
					nRow = (event.getY() - 40) / 45;
					message = chess.movePiece(oCol, oRow, nCol, nRow, turn);
					clicked = false;
					dragged = false;
					turn = turnChange(message);
					win = chess.winCon();
					repaint();
					
				}else{
					if(chess.piecePositions[oCol][oRow].getType().equals("Dummy")){ //determines if first click is on an empty space
						clicked = false;
					}else{
						clicked = true;
					}
					
				}
				

				if(dragged == true){
					nCol = (event.getX() - 40) / 45; //obtains relative coordinates to the board
					nRow = (event.getY() - 40) / 45;
					message = chess.movePiece(oCol, oRow, nCol, nRow, turn);
					if(message != null){
						chess.piecePositions[oCol][oRow].moveImg(40+oCol*45,40+oRow*45); //snaps image back to starting position if invalid movement
					}
					clicked = false;
					dragged = false;
					turn = turnChange(message);
					win = chess.winCon();
					repaint();
				}

			}

			public void mouseClicked(MouseEvent event){
				//unused
			}
			
			public void mouseEntered(MouseEvent event){
				//unused
			}
			
			public void mouseExited(MouseEvent event){
				//unused
			}
		
		}

		class MouseDragListener implements MouseMotionListener{
			public void mouseDragged(MouseEvent event){
				//moves image with mouse drag
				if(chess.piecePositions[oCol][oRow].getColour().equals(turn)){
					chess.piecePositions[oCol][oRow].moveImg(event.getX() - 22, event.getY() - 22);
					repaint();
					dragged = true;
				}

			}

			public void mouseMoved(MouseEvent event){
				//unused
			}
		}
		
		MousePressListener listener = new MousePressListener();
		addMouseListener(listener);
		addMouseListener(mouseClick);

		MouseDragListener dragListener = new MouseDragListener();
		addMouseMotionListener(dragListener);
		addMouseMotionListener(mouseDrag);

		
		// populate ChessBoard with the starting positions of chess pieces
        chess.place(new Rook("black",0,0), 0,0);
        chess.place(new Knight("black",1,0), 1,0);
        chess.place(new Bishop("black",2,0), 2,0);
        chess.place(new Queen("black",3,0), 3,0);
		chess.place(new King("black",4,0), 4,0);
        chess.place(new Bishop("black",5,0), 5,0);
        chess.place(new Knight("black",6,0), 6,0);
        chess.place(new Rook("black",7,0), 7,0);
        //loop to place all black pawns
        for(int x = 0; x < 8; x++){
            chess.place(new Pawn("black",x,1), x,1);
        }
        //white pieces placed
        chess.place(new Rook("white",0,7), 0,7);
        chess.place(new Knight("white",1,7), 1,7);
        chess.place(new Bishop("white",2,7), 2,7);
		chess.place(new Queen("white",3,7), 3,7);
        chess.place(new King("white",4,7), 4,7);
        chess.place(new Bishop("white",5,7), 5,7);
        chess.place(new Knight("white",6,7), 6,7);
        chess.place(new Rook("white",7,7), 7,7);
        //white pawns placed
        for(int x = 0; x < 8; x++){
            chess.place(new Pawn("white",x,6), x,6);
        }
		
		
	}

	/**
	 *
	 * @param message message for checking movement validity
	 * @return
	 */
	private String turnChange(String message){
		if(message == null){
			if(turn.equals("white")){
				turn = "black";
				return turn;
			}else{
				turn = "white";
				return turn;
			}
		}else{
			return turn;
		}
	}

	/**
	 *
	 * @return returns current turn
	 */
	public String getTurn(){
		return turn;
	}

	/**
	 *
	 * @return returns win status
	 */
	public int getWin(){
		return win;
	}

	/**
	 *
	 * @param g
	 * paints the chess board.
	 */
	public void paintComponent(Graphics g){  
        Graphics2D g2 = (Graphics2D)g;
		chess.paint(g2);
	}
}
