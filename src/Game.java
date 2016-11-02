
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
    public static void main(String[] argsF) {
        // Create the game board
        Board board = new Board(12, 12);
        // Create the doctor at a random position
        Doctor doctor = new Doctor((int) (Math.random() * 12), (int) (Math.random() * 12));
        // Create the first Dalek at a random position
        Dalek dalek1 = new Dalek((int) (Math.random() * 12), (int) (Math.random() * 12));
        // Create the second Dalek at a random position
        Dalek dalek2 = new Dalek((int) (Math.random() * 12), (int) (Math.random() * 12));
        // Create the third Dalek at a random position
        Dalek dalek3 = new Dalek((int) (Math.random() * 12), (int) (Math.random() * 12));

        // RESPAWINING
        // If the doctor lands on any of the Daleks, then respawn
        // Doctor and Dalek 1
        while (doctor.getRow() == dalek1.getRow() && doctor.getCol() == dalek1.getCol()) {
            // Remove the Doctor peg
            board.removePeg(doctor.getRow(), doctor.getCol());
            // Create a new location for the doctor
            doctor = new Doctor((int) (Math.random() * 12), (int) (Math.random() * 12));
        }
        // Doctor and Dalek 2
        while (doctor.getRow() == dalek2.getRow() && doctor.getCol() == dalek2.getCol()) {
            // Remove the Doctor peg
            board.removePeg(doctor.getRow(), doctor.getCol());
            // Create a new location for the doctor
            doctor = new Doctor((int) (Math.random() * 12), (int) (Math.random() * 12));
        }
        // Doctor and Dalek 3
        while (doctor.getRow() == dalek3.getRow() && doctor.getCol() == dalek3.getCol()) {
            // Remove the Doctor peg
            board.removePeg(doctor.getRow(), doctor.getCol());
            // Create a new location for the doctor
            doctor = new Doctor((int) (Math.random() * 12), (int) (Math.random() * 12));
        }
        // If the daleks land on each other, then respawn
        // Dalek 1 and Dalek 2
        while (dalek1.getRow() == dalek2.getRow() && dalek1.getCol() == dalek2.getCol()) {
            // Remove Dalek 1 peg
            board.removePeg(dalek1.getRow(), dalek1.getCol());
            // Create a new location for the Dalek 1
            dalek1 = new Dalek((int) (Math.random() * 12), (int) (Math.random() * 12));
        }
        // Dalek 1 and Dalek 3
        while (dalek1.getRow() == dalek3.getRow() && dalek1.getRow() == dalek3.getCol()) {
            // Remove Dalek 1 peg
            board.removePeg(dalek1.getRow(), dalek1.getCol());
            // Create a new location for the Dalek 1
            dalek1 = new Dalek((int) (Math.random() * 12), (int) (Math.random() * 12));
        }
        // Dalek 2 and Dalek 3
        while (dalek2.getRow() == dalek3.getRow() && dalek2.getCol() == dalek3.getCol()) {
            // Remove Dalek 2 peg
            board.removePeg(dalek2.getRow(), dalek2.getCol());
            // Create a new location for Dalek 2
            dalek2 = new Dalek((int) (Math.random() * 12), (int) (Math.random() * 12));
        }

        // Placing the pegs before the game physically starts!
        board.putPeg(Color.GREEN, doctor.getRow(), doctor.getCol());
        board.putPeg(Color.BLACK, dalek1.getRow(), dalek1.getCol());
        board.putPeg(Color.BLACK, dalek2.getRow(), dalek2.getCol());
        board.putPeg(Color.BLACK, dalek3.getRow(), dalek3.getCol());
        // Put a message on the board
        board.displayMessage("Goal: Crash all three Daleks (the black pegs) to win!");

        // Main while loop of the entire game (where the magic happens ;))
        while (true) {
            // If the Doctor is captured
            // Check for crashes: If Dalek 1, 2, or 3 has crashed with the Doctor 
            if (dalek1.getRow() == doctor.getRow() && dalek1.getCol() == doctor.getCol()
                    || dalek2.getRow() == doctor.getRow() && dalek2.getCol() == doctor.getCol()
                    || dalek3.getRow() == doctor.getRow() && dalek3.getCol() == doctor.getCol()) {
                // Place a peg where the doctor was captured
                board.putPeg(Color.YELLOW, doctor.getRow(), doctor.getCol());
                // Tell the player/user that they have failed!
                board.displayMessage("Mission uncompleted: YOU LOST!");
                // End the game if the doctor is captured
                break;
            }

            // Check for crashes: If all Daleks hit each other on the same move
            // If all THREE Daleks hit collided with each other
            if (dalek1.getRow() == dalek2.getRow() && dalek1.getRow() == dalek3.getRow()
                    && dalek1.getCol() == dalek2.getCol() && dalek1.getCol() == dalek3.getCol()
                    && dalek2.getRow() == dalek3.getRow() && dalek2.getCol() == dalek3.getCol()) {
                // All three Daleks crash
                dalek1.crash();
                dalek2.crash();
                dalek3.crash();
                // Put a red peg where all three have collided
                board.putPeg(Color.RED, dalek1.getRow(), dalek1.getCol());
                // Tell the player/user that they have successfully completed the mission! 
                board.displayMessage("Mission completed: YOU WON!");
                // End the game if all three Daleks have crashed
                break;
            }
            // If Dalek 1 has crashed with Dalek 2
            if (dalek1.getRow() == dalek2.getRow() && dalek1.getCol() == dalek2.getCol()) {
                // Both Daleks have crashed
                dalek1.crash();
                dalek2.crash();
                // Put a red peg where the two crashed
                board.putPeg(Color.RED, dalek1.getRow(), dalek1.getCol());
            }
            // If Dalek 1 has crashed with Dalek 3
            if (dalek1.getRow() == dalek3.getRow() && dalek1.getCol() == dalek3.getCol()) {
                // Both Daleks have crashed
                dalek1.crash();
                dalek3.crash();
                // Put a red peg where the two crashed
                board.putPeg(Color.RED, dalek3.getRow(), dalek3.getCol());
            }
            // If Dalek 2 has crashed with Dalek 3
            if (dalek2.getRow() == dalek3.getRow() && dalek2.getCol() == dalek3.getCol()) {
                // Both Daleks have crashed
                dalek2.crash();
                dalek3.crash();
                // Put a red peg where the two have crashed
                board.putPeg(Color.RED, dalek2.getRow(), dalek2.getCol());
            }

            // Coordinates of the user's click
            Coordinate click = board.getClick();
            // Remove the old doctor peg
            board.removePeg(doctor.getRow(), doctor.getCol());
            // Move the doctor peg to new location where the player clicked
            doctor.move(click.getRow(), click.getCol());
            // Place the doctor peg!
            board.putPeg(Color.GREEN, doctor.getRow(), doctor.getCol());

            // More Dalek actions
            // Make Dalek 1 move towards the doctor
            if (dalek1.hasCrashed() == false) {
                // Remove the Dalek's peg
                board.removePeg(dalek1.getRow(), dalek1.getCol());
                // Have Dalek 1 move towards the doctor
                dalek1.advanceTowards(doctor);
            }
            // Make Dalek 2 move towards the doctor
            if (dalek2.hasCrashed() == false) {
                // Remove the Dalek's peg
                board.removePeg(dalek2.getRow(), dalek2.getCol());
                // Have Dalek 2 move towards the doctor
                dalek2.advanceTowards(doctor);
            }
            // Make Dalek 3 move towards the doctor
            if (dalek3.hasCrashed() == false) {
                // Remove the Dalek's peg               
                board.removePeg(dalek3.getRow(), dalek3.getCol());
                // Have Dalek 3 move towards the doctor
                dalek3.advanceTowards(doctor);
            }
            // Place the new pegs which were removed
            board.putPeg(Color.BLACK, dalek1.getRow(), dalek1.getCol());
            board.putPeg(Color.BLACK, dalek2.getRow(), dalek2.getCol());
            board.putPeg(Color.BLACK, dalek3.getRow(), dalek3.getCol());
        }
    }
}
