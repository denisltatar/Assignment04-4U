
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
        // Create the first Dalek
        Dalek dalek1 = new Dalek((int) (Math.random() * 12), (int) (Math.random() * 12));
        // Create the second Dalek
        Dalek dalek2 = new Dalek((int) (Math.random() * 12), (int) (Math.random() * 12));
        // Create tje third Dalek
        Dalek dalek3 = new Dalek((int) (Math.random() * 12), (int) (Math.random() * 12));

        // IF THE DOCTOR LANDS ON THE OTHER DALEK WHEN SPAWNING


        // IF DALEKS LAND ON EACH WHEN GAME STARTS!
        while (dalek1.getRow() == dalek2.getRow() && dalek1.getCol() == dalek2.getCol()) {
            dalek1 = new Dalek((int) (Math.random() * 12), (int) (Math.random() * 12));
            board.putPeg(Color.YELLOW, dalek1.getRow(), dalek1.getCol());
        }


        board.putPeg(Color.GREEN, doctor.getRow(), doctor.getCol());
        board.putPeg(Color.YELLOW, dalek1.getRow(), dalek1.getCol());
        board.putPeg(Color.YELLOW, dalek2.getRow(), dalek2.getCol());
        board.putPeg(Color.YELLOW, dalek3.getRow(), dalek3.getCol());
        // Put a message on the board
        board.displayMessage("Please click the board to move your Doctor in green!");


        // Get a click response from the user
        while (true) {
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
            // Make the Daleks move 
            if (dalek1.hasCrashed() == false && dalek2.hasCrashed() == false && dalek3.hasCrashed() == false) {
                // Have Dalek one move towards the doctor
                board.removePeg(dalek1.getRow(), dalek1.getCol());
                dalek1.advancedTowards(doctor);
                board.putPeg(Color.YELLOW, dalek1.getRow(), dalek1.getCol());
                // Have Dalek two move towards the doctor
                board.removePeg(dalek2.getRow(), dalek2.getCol());
                dalek2.advancedTowards(doctor);
                board.putPeg(Color.YELLOW, dalek2.getRow(), dalek2.getCol());
                // Have Dalek three move towards the doctor
                board.removePeg(dalek3.getRow(), dalek3.getCol());
                dalek3.advancedTowards(doctor);
                board.putPeg(Color.YELLOW, dalek3.getRow(), dalek3.getCol());
            }


            // CHECK CRASHES: if Daleks has crashed or not with each other or the Doctor
            // If Dalek1 has crashed with Dalek2
            if (dalek1.getRow() == dalek2.getRow() && dalek1.getCol() == dalek2.getCol()) {
                dalek1.crash();
                dalek2.crash();
                // Put a red peg where the two crashed
                board.putPeg(Color.RED, dalek1.getRow(), dalek1.getCol());
            }
            // If Dalek 1 has crashed with Dalek3
            if (dalek1.getRow() == dalek3.getRow() && dalek1.getCol() == dalek3.getCol()) {
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
            if (dalek1.getRow() == doctor.getRow() && dalek1.getCol() == doctor.getCol()
                    && dalek2.getRow() == doctor.getRow() && dalek2.getCol() == doctor.getCol()
                    && dalek3.getRow() == doctor.getRow() && dalek3.getCol() == doctor.getCol()) {
                // End the game
                break;
            }
        }
    }
}
