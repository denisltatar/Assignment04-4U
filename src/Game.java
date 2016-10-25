
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
        // Create the doctor
        Doctor doctor = new Doctor((int) (Math.random() * 12), (int) (Math.random() * 12));
        board.putPeg(Color.GREEN, doctor.getRow(), doctor.getCol());
        // Create the first Dalek
        Dalek dalek1 = new Dalek((int) (Math.random() * 12), (int) (Math.random() * 12));
        board.putPeg(Color.BLACK, dalek1.getRow(), dalek1.getCol());
        // Create the second Dalek
        Dalek dalek2 = new Dalek((int) (Math.random() * 12), (int) (Math.random() * 12));
        board.putPeg(Color.BLACK, dalek2.getRow(), dalek2.getCol());
        // Create tje third Dalek
        Dalek dalek3 = new Dalek((int) (Math.random() * 12), (int) (Math.random() * 12));
        board.putPeg(Color.BLACK, dalek3.getRow(), dalek3.getCol());

        // Put a message on the board
        board.displayMessage("Please click the board");

        // Get a click response from the user
        while (true) {
            // DOCTOR ACTIONS
            // Coordinates of the user's click
            Coordinate click = board.getClick();
            // Remove the old doctor peg
            board.removePeg(doctor.getRow(), doctor.getCol());
            // Move the doctor peg to new location
            doctor.move(click.getRow(), click.getCol());
            // Place the doctor peg!
            board.putPeg(Color.GREEN, doctor.getRow(), doctor.getCol());

            // DALEK ACTIONS
            // Add all the actions here in chronological order
            // CHECK CRASHES: if Daleks has crashed or not with each other or the Doctor
            // If Dalek1 has crashed with Dalek2
            if (dalek1.getRow() == dalek2.getRow() && dalek1.getRow() == dalek2.getRow()) {
                dalek1.crash();
                dalek2.crash();
                // Put a red peg where the two crashed
                board.putPeg(Color.RED, dalek1.getRow(), dalek1.getCol());
            }
            // If Dalek 1 has crashed with Dalek3
            if (dalek1.getRow() == dalek3.getRow() && dalek1.getRow() == dalek3.getRow()) {
                dalek1.crash();
                dalek3.crash();
                // Put a red peg where the two crashed
                board.putPeg(Color.RED, dalek1.getRow(), dalek1.getCol());
            }
            // If Dalek 2 and 3 crash
            if (dalek2.getRow() == dalek3.getRow() && dalek2.getCol() == dalek3.getCol()) {
                dalek2.crash();
                dalek3.crash();
                // Put a red peg where the two crashed
                board.putPeg(Color.RED, dalek1.getRow(), dalek1.getCol());
            }
            // If Dalek 1, 2, or 3 has crashed with the doctor // ADD ALL THE DALEKS IN THE IF LOOP!
            if (dalek1.getRow() == doctor.getRow() && dalek1.getRow() == doctor.getRow()
                    && dalek2.getRow() == doctor.getRow() && dalek2.getRow() == doctor.getRow()
                    && dalek3.getRow() == doctor.getRow() && dalek3.getRow() == doctor.getRow()) {
                // End the game
                break;
            }
        }
    }
}
