import javax.swing.JFrame;

/**
 * Fong Yuan
 * 100285256
 *
 * Creates a frame that contains a chess game on the left with a statistics panel on the right
 */

public class ChessRunner extends JFrame{

	public static void main(String [] arg){
		JFrame frame = new JFrame();
		MainPanel mainPanel = new MainPanel();
		
		
		final int FRAME_WIDTH = 800;
		final int FRAME_HEIGHT = 500;

		frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		frame.setTitle("Chess Game");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.add(mainPanel);

		
		
		frame.setVisible(true);
	}
}

