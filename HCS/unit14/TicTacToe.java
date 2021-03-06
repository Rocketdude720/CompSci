package unit14;
import java.util.Scanner;
public class TicTacToe {

    //lines 3-8 set up variables for global usage

    public static void main(String[] args) {
        char[][] board = new char[3][3];
        String[] who = new String[3];

        int[] allCoords = new int[2];

        initialBoard(board);										//makes he 3x3 grid
        who = win(who, board);
        boolean q = false;
        while(who[2].equals("false")){
            if(q == false){
                q = true;
            }
            else if(q == true){
                q = false;
            }
            allCoords = pickMove(allCoords, q, board);										// lines 14-21 runs through functions until win

            who = win(who, board);
        }
        System.out.println();
        System.out.println(who[1] + " wins!");				//writes winner
        System.out.println(who[0] + " loses!");			//writes loser
    }

    public static void initialBoard(char[][] board){						//function for initial Board

        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board.length; j++){
                board[j][i] = '*';
            }
        }
        for(int i = 0; i < board.length; i++){
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int[] pickMove(int[] allCoords, boolean transfer, char[][] board){							//function for user coordinate input


        Scanner input = new Scanner(System.in);
        int xCoord = input.nextInt() - 1;						//42-46 take initial input
        int yCoord = input.nextInt() - 1;

        while(xCoord > 3 || yCoord > 3 || board[xCoord][yCoord] == 'X' || board[xCoord][yCoord] == 'O'){

            System.out.println("Invalid numbers chosen. Please pick other numbers between 1 and 3.");

            xCoord = input.nextInt() - 1;						//Lines 48-54 set parameters for
            yCoord = input.nextInt() - 1;						//values must be less than 3, and not overwriting
        }

        allCoords[0] = xCoord;
        allCoords[1] = yCoord;

        System.out.println("Valid numbers chosen");			//indicates a valid input
        makeBoard(allCoords, transfer, board);
        return(allCoords);
    }

    public static void makeBoard(int[] input,boolean pickState, char[][] board){							//function for writing board in an ongoing game

        if(pickState == true){
            board[input[0]][input[1]] = 'X';
            pickState = false;
            System.out.println("It's O's turn");			//tells who's turn it it
        }
        else if(pickState != true){
            board[input[0]][input[1]] = 'O';
            pickState = true;
            System.out.println("It's X's turn");			//tells who's turn it it
        }
        for(int i = 0; i < board.length; i++){
            System.out.println(board[i]);
        }
    }

    public static String[] win(String[] who, char[][] board){								//function for determining wins, losses, and ties
        //Note: who[0] = Loser, who[1] = Winner, who[2] = win state
        who[2] = "false";
        int tie = 9;

        for(int i = 0; i < 3; i++){
            //win statements HVD for X
            if(board[i][0] == 'X' && board[i][1] == 'X' && board[i][2] == 'X'){
                who[2] = "true";							//Vertical
                who[0] = "O";
                who[1] = "X";
            }
            else if(board[0][i] == 'X' && board[1][i] == 'X' && board[2][i] == 'X'){
                who[2] = "true";						//Horizontal
                who[0] = "O";
                who[1] = "X";
            }
            else if(board[0][0] == 'X' && board[1][1] == 'X' && board[2][2] == 'X'){
                who[2] = "true";							//Diagonal Down L -> R
                who[0] = "O";
                who[1] = "X";
            }
            else if(board[2][0] == 'X' && board[1][1] == 'X' && board[0][2] == 'X'){
                who[2] = "true";						//Diagonal Up L -> R
                who[0] = "O";
                who[1] = "X";
            }

            //win statement HVD for O
            if(board[i][0] == 'O' && board[i][1] == 'O' && board[i][2] == 'O'){
                who[2] = "true";						//Vertical
                who[0] = "X";
                who[1] = "O";
            }
            else if(board[0][i] == 'O' && board[1][i] == 'O' && board[2][i] == 'O'){
                who[2] = "true";						//Horizontal
                who[0] = "X";
                who[1] = "O";
            }
            else if(board[0][0] == 'O' && board[1][1] == 'O' && board[2][2] == 'O'){
                who[2] = "true";						//Diagonal Down L -> R
                who[0] = "X";
                who[1] = "O";
            }
            else if(board[2][0] == 'O' && board[1][1] == 'O' && board[0][2] == 'O'){
                who[2] = "true";						//Diagonal Up L -> R
                who[0] = "X";
                who[1] = "O";
            }

            //draw
            for(int j = 0; j < 3; j++){						//checks for the filling of all spots
                if(board[i][j] != '*'){
                    tie--;
                }
            }
        }
        if(tie == 0 && who[2] == "false"){					//concludes tie if all spots are filled with no winner
            who[1] = "Nobody";
            who[0] = "Everybody";
            who[2] = "true";
        }
        return(who);
    }

}
