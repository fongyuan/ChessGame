import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.Dimension;

import javax.swing.JPanel;

/**
 * Fong Yuan
 * 100285256
 *
 * A MainPanel extended from JPanel
 */

public class MainPanel extends JPanel{
	
	private ChessViewer chessViewer;
	private StatPanel statPanel;
	private String currentTurn;
	private int winCon;
	private MouseListener mouseClick;
	private MouseMotionListener mouseDrag;

	/**
	 * Constructor that initializes all ActionListeners and adds 2 sub panels into the appropriate locations within itself.
	 */
	public MainPanel(){


		
		/**
		 * Sub classes that performs actions when the associated mouse action occurs
		 */
		class MousePressListener extends MouseAdapter{

			public void mouseReleased(MouseEvent event){
				currentTurn = chessViewer.getTurn();
				winCon = chessViewer.getWin();
				//System.out.println(currentTurn);
				statPanel.update(currentTurn,winCon);
			}

		}

		class MouseDragListener implements MouseMotionListener{
			public void mouseDragged(MouseEvent event){
				currentTurn = chessViewer.getTurn();
				winCon = chessViewer.getWin();
				statPanel.update(currentTurn,winCon);
				//System.out.println(currentTurn);
			}

			public void mouseMoved(MouseEvent event){
				//unused
			}
		}



		mouseClick = new MousePressListener();
		mouseDrag = new MouseDragListener();

		chessViewer = new ChessViewer(mouseClick, mouseDrag);
		statPanel = new StatPanel();




		setLayout(new BorderLayout()); //set layout of MainPanel
		statPanel.setPreferredSize(new Dimension(200,100));
		add(chessViewer, BorderLayout.CENTER); //adds the panels to MainPanel
		add(statPanel, BorderLayout.EAST); //adds the panels to MainPanel

	}

}
