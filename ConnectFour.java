import java.util.*;

// This class represents a game of Connect Four an implements the AbstractStrategyGame
// interface.
public class ConnectFour implements AbstractStrategyGame{
    private char[][] board;
    private boolean isRTurn;
    
    // Constructs a new ConnectFour game.
    public ConnectFour(){
        this.board = new char[][]{{'-', '-', '-', '-', '-', '-', '-'},
                                  {'-', '-', '-', '-', '-', '-', '-'},
                                  {'-', '-', '-', '-', '-', '-', '-'},
                                  {'-', '-', '-', '-', '-', '-', '-'},
                                  {'-', '-', '-', '-', '-', '-', '-'},
                                  {'-', '-', '-', '-', '-', '-', '-'}};
        this.isRTurn = true;
    }
   
    // Returns a String containing instructions to play the game.
    // Returns:
    // - String: the string describing how to play the game
    public String instructions(){
        String result = "";

        result += "Connect Four is a two-player game played on a 7-wide 6-tall grid.\n";
        result += "Player 1 is red (R) and Player 2 is yellow (Y). Choose where to drop a disc\n";
        result += "by entering a column number (0-6). Spaces that appear as a - are empty. The\n";
        result += "disc fills the bottom-most available space in that column. The game ends if\n";
        result += "a player connects four of their discs in a row (horizontally, vertically,\n";
        result += "or diagonally) OR the board is full, resulting in a tie.";

        return result;
    }
   
    // Returns a String representation of the current state of the board.
    // Returns:
    // - String: the string representation of the current game state.
    public String toString(){
        String result = "";
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                result += board[i][j] + " ";
            }
            result += "\n";
        }
        return result;
    }
   
    // Returns whether or not the game is over.
    // Returns:
    // - boolean: true if the game is over, false if otherwise
    public boolean isGameOver(){
        return getWinner() >= 0;
    }
   
    // Returns the index of the winner/result of the game. 1 if player 1 (R)
    // wins, 2 if player 2 (Y) wins, 0 if there's a tie, and -1 if the game
    // is not over.
    // Returns:
    // - int: the index of the winner/result of the game
    public int getWinner(){
        // Check horizontals
        for(int i = board.length - 1; i >= 0; i--){
            for(int j = 0; j < 4; j++){
                if(board[i][j] == board[i][j + 1] && board[i][j] == board[i][j + 2] && board[i][j] 
                 == board[i][j + 3] && board[i][j] != '-'){
                    return board[i][j] == 'R' ? 1 : 2;
                } 
            }           
        }
        
        // Check verticals
        for(int i = 0; i < board[0].length; i++){
            for(int j = 0; j < 3; j++){
                if(board[j][i] == board[j + 1][i] && board[j][i] == board[j + 2][i] && board[j][i] 
                == board[j + 3][i] && board[j][i] != '-'){
                    return board[j][i] == 'R' ? 1 : 2;
                } 
            }           
        }

        // Check diagonals
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if ((i < board.length - 3 && j < board[0].length - 3 && board[i][j] != '-' && 
                 board[i][j] == board[i + 1][j + 1] && board[i][j] == board[i + 2][j + 2] && 
                 board[i][j] == board[i + 3][j + 3]) || (i >= 3 && j < board[0].length - 3 && 
                 board[i][j] != '-' && board[i][j] == board[i - 1][j + 1] && board[i][j] == 
                 board[i - 2][j + 2] && board[i][j] == board[i - 3][j + 3])) {
                    return board[i][j] == 'R' ? 1 : 2;
                }
            }
        }
        
        // Check for tie
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == '-') {
                    return -1;
                }
            }
        }

        return 0;
    }
   
    // Returns the index of which player's turn it is. 1 if player 1 (X), 2 if player 2 (O), -1 
    // if the game is over.
    // Returns:
    // - int: the index of which player's turn it is
    public int getNextPlayer(){
        if(isGameOver()){
            return -1;
        } 
        return isRTurn ? 1 : 2;
    }
   
    // Given the input, places an R or Y in the column the player specifies.
    // Exception:
    // - If the input is invalid (out of bounds or column is full), an IllegalArgumentException
    // is thrown.
    // Parameters:
    // - input: the scanned user input that indicates the player's move
    public void makeMove(Scanner input){
        char currentPlayer = isRTurn ? 'R' : 'Y';

        System.out.print("Column? ");
        int column = input.nextInt();

        makeMove(column, currentPlayer);
        isRTurn = !isRTurn;
    }
   
    // Private helper method for makeMove.
    // Given the column and player index, places an R or Y in that column. 
    // Exceptions:
    // - If the input is invalid (out of bounds or column is full), an IllegalArgumentException.
    // Board bounds for columns are [0, 6]
    private void makeMove(int column, char player){
        if(column < 0 || column > 6){
            throw new IllegalArgumentException("Invalid column: " + column);
        }
        
        if(board[0][column] != '-'){
            throw new IllegalArgumentException("Selected column is full: " + column);
        }

        for(int i = board.length - 1; i >= 0; i--){
            if(board[i][column] == '-'){
                board[i][column] = player;
                i = -1;
            }
        }  
    }
}