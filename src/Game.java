
import java.awt.Color;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author tatad6701
 */
public class Game {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Create the game board
        Board board = new Board(12, 12);

        board.putPeg(Color.red, 1, 5);
        board.putPeg(Color.yellow, 2, 6);
        board.removePeg(1, 5);

        // Put a message on the board
        board.displayMessage("Please click the board");

        // Get a click response from the user
        while(true){
        Coordinate click = board.getClick();
        int row = click.getRow();
        int col = click.getCol();
        
        board.putPeg(Color.MAGENTA, row, col);
        }
    }
}
