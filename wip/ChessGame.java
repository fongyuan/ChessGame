import java.util.Scanner;

/**
 * Fong Yuan
 * 100285256
 *
 * Simulates a chess game.
 */

public class ChessGame {


    public static void main (String[] args){
        String turn = "white"; //player on white side plays first
        int win = 0;

        // populate ChessBoard with the starting positions of chess pieces
        ChessBoard c1 = new ChessBoard();
        c1.place(new Rook("black",0,7), 0,7);
        c1.place(new Knight("black",1,7), 1,7);
        c1.place(new Bishop("black",2,7), 2,7);
        c1.place(new King("black",3,7), 3,7);
        c1.place(new Queen("black",4,7), 4,7);
        c1.place(new Bishop("black",5,7), 5,7);
        c1.place(new Knight("black",6,7), 6,7);
        c1.place(new Rook("black",7,7), 7,7);
        //loop to place all pawns
        for(int x = 0; x < 8; x++){
            c1.place(new Pawn("black",x,6), x,6);
        }
        //white pieces placed
        c1.place(new Rook("white",0,0), 0,0);
        c1.place(new Knight("white",1,0), 1,0);
        c1.place(new Bishop("white",2,0), 2,0);
        c1.place(new King("white",3,0), 3,0);
        c1.place(new Queen("white",4,0), 4,0);
        c1.place(new Bishop("white",5,0), 5,0);
        c1.place(new Knight("white",6,0), 6,0);
        c1.place(new Rook("white",7,0), 7,0);
        //white pawns placed
        for(int x = 0; x < 8; x++){
            c1.place(new Pawn("white",x,1), x,1);
        }
        c1.print(); //print board state

        Scanner input = new Scanner(System.in);
        String pos;
        String splitPos[];
        String message;

        //start of the game for players to move pieces
        do{
            System.out.print(turn + " move: ");
            pos = input.nextLine();
            splitPos = pos.split(" ");

            while(splitPos.length != 2){ //check for proper entry
                System.out.println("Please enter a valid location");
                System.out.print(turn + " move: ");
                pos = input.nextLine();
                splitPos = pos.split(" ");
            }
            //checks board rules
            message = c1.movePiece(splitPos[0].toLowerCase().charAt(0) - 'a', splitPos[0].charAt(1) - '1',splitPos[1].toLowerCase().charAt(0) - 'a', splitPos[1].charAt(1) - '1', turn);
            c1.print();
            if(message != null){
                System.out.println(message); //prints error if player has violated board rules.
            }

            //once player has made a valid move, changes to next player
            if(turn.equals("white") && message == null){
                turn = "black";
            }else if(message == null){
                turn = "white";
            }

            win = c1.winCon(); //check win conditions

        } while(win == 0);

        if(win == 1){
            System.out.println("White wins!");
        }else{
            System.out.println("Black wins!");
            }
        }

    }



