import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.Timer;


import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Fong Yuan
 * 100285256
 *
 * A JPanel that contains various statistics of the chess game
 */

public class StatPanel extends JPanel{
	private int whiteTime;
	private int blackTime;
	private String turn;
	private int win;
	
	private JLabel currentTurn;
	private JLabel whiteTimerLabel;
	private JLabel blackTimerLabel;
	private JLabel winnerLabel;
	private Timer timer;


	/**
	 * A constructor that initializes JLabels and sets the text fields to their default values
	 */

	public StatPanel(){
		whiteTime = 0;
		blackTime = 0;
		turn = "white";
		win = 0;

		currentTurn = new JLabel("white's turn");
		winnerLabel = new JLabel("");

		blackTimerLabel = new JLabel("Black time: 0 seconds");
		whiteTimerLabel = new JLabel("White time: 0 seconds");


		//Timer to keep track of player turn time
		class timerListener implements ActionListener{
			public void actionPerformed(ActionEvent event){
				if(win != 0){ //checks player turn

				}else if(turn.equals("black")){
					blackTime += 1;
				}else if(turn.equals("white")){
					whiteTime += 1;
				}

				whiteTimerLabel.setText("White time: " + whiteTime);
				blackTimerLabel.setText("Black time: " + blackTime);
				//System.out.println(whiteTime);

				//updates win label with winner when a win condition occurs
				if(win == 1){
					winnerLabel.setText("White wins!");
				}else if(win == -1){
					winnerLabel.setText("Black wins!");
				}

			}
		}

		timerListener timerListen = new timerListener();
		timer = new Timer(1000, timerListen);


		timer.start(); //starts the timer


		setLayout(new GridLayout(4,1)); //sets layout to be grid form

		add(currentTurn);
		add(winnerLabel);
		add(blackTimerLabel);
		add(whiteTimerLabel);
	}


	/**
	 *
	 * @param turn current turn
	 * @param winCon win condition status
	 */
	public void update(String turn, int winCon){
		this.turn = turn;
		win = winCon;

		currentTurn.setText(this.turn + "'s turn");

	}

}
