
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
        // Create the third Dalek
        Dalek dalek3 = new Dalek((int) (Math.random() * 12), (int) (Math.random() * 12));

        // RESPAWINING
        // If the doctor lands on any of the Daleks, then respawn
        // Doctor and Dalek 1
        while (doctor.getRow() == dalek1.getRow() && doctor.getCol() == dalek1.getCol()) {
            doctor = new Doctor((int) (Math.random() * 12), (int) (Math.random() * 12));
            board.putPeg(Color.BLACK, doctor.getRow(), doctor.getCol());
        }
        // Doctor and Dalek 2
        while (doctor.getRow() == dalek2.getRow() && doctor.getCol() == dalek2.getCol()) {
            doctor = new Doctor((int) (Math.random() * 12), (int) (Math.random() * 12));
            board.putPeg(Color.BLACK, doctor.getRow(), doctor.getCol());
        }
        // Doctor and Dalek 3
        while (doctor.getRow() == dalek3.getRow() && doctor.getCol() == dalek3.getCol()) {
            doctor = new Doctor((int) (Math.random() * 12), (int) (Math.random() * 12));
            board.putPeg(Color.BLACK, doctor.getRow(), doctor.getCol());
        }
        // If the daleks land on each other, then respawn
        // Dalek 1 and Dalek 2
        while (dalek1.getRow() == dalek2.getRow() && dalek1.getCol() == dalek2.getCol()) {
            dalek1 = new Dalek((int) (Math.random() * 12), (int) (Math.random() * 12));
            board.putPeg(Color.BLACK, dalek1.getRow(), dalek1.getCol());
        }
        // Dalek 1 and Dalek 3
        while (dalek1.getRow() == dalek3.getRow() && dalek1.getRow() == dalek3.getCol()) {
            dalek1 = new Dalek((int) (Math.random() * 12), (int) (Math.random() * 12));
            board.putPeg(Color.BLACK, dalek1.getRow(), dalek1.getCol());
        }
        /// Dalek 2 and Dalek 3
        while (dalek2.getRow() == dalek3.getRow() && dalek2.getCol() == dalek3.getCol()) {
            dalek2 = new Dalek((int) (Math.random() * 12), (int) (Math.random() * 12));
            board.putPeg(Color.BLACK, dalek2.getRow(), dalek2.getCol());
        }
        // Placing the pegs
        board.putPeg(Color.GREEN, doctor.getRow(), doctor.getCol());
        board.putPeg(Color.BLACK, dalek1.getRow(), dalek1.getCol());
        board.putPeg(Color.BLACK, dalek2.getRow(), dalek2.getCol());
        board.putPeg(Color.BLACK, dalek3.getRow(), dalek3.getCol());
        // Put a message on the board
        board.displayMessage("Goal: Crash all three Daleks and don't be captured to win!");

        // Main while loop of the entire game (where the magic happens)
        while (true) {
            // Check for crashes: If Dalek 1, 2, or 3 has crashed with the doctor 
            if (dalek1.getRow() == doctor.getRow() && dalek1.getCol() == doctor.getCol()
                    || dalek2.getRow() == doctor.getRow() && dalek2.getCol() == doctor.getCol()
                    || dalek3.getRow() == doctor.getRow() && dalek3.getCol() == doctor.getCol()) {
                board.putPeg(Color.YELLOW, doctor.getRow(), doctor.getCol());
                // Tell the player/user that they have failed!
                board.displayMessage("Mission uncompleted: YOU LOST!");
                // End the game if the doctor is captured
                break;
            }

            // Check for crashes: If all Daleks hit each other on the same move
            // If ALL THREE Daleks hit collided with each other**********************************************************
            if (dalek1.getRow() == dalek2.getRow() && dalek1.getRow() == dalek3.getRow()
                    && dalek1.getCol() == dalek2.getCol() && dalek1.getCol() == dalek3.getCol()
                    && dalek2.getRow() == dalek3.getRow() && dalek2.getCol() == dalek3.getCol()) {
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
                board.putPeg(Color.RED, dalek3.getRow(), dalek3.getCol());
            }
            // If Dalek 2 and 3 crash
            if (dalek2.getRow() == dalek3.getRow() && dalek2.getCol() == dalek3.getCol()) {
                dalek2.crash();
                dalek3.crash();
                // Put a red peg where the two crashed
                board.putPeg(Color.RED, dalek2.getRow(), dalek2.getCol());
            }
            // If all three Dalek crash then print our to the user that they won!*******************************************
            if (dalek1.hasCrashed() == true && dalek2.hasCrashed() == true && dalek3.hasCrashed() == true) {
                board.displayMessage("Mission completed: YOU WON!");
            }

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
            // Make Dalek 1 move towards the doctor
            if (dalek1.hasCrashed() == false) {
                // Have Dalek one move towards the doctor
                board.removePeg(dalek1.getRow(), dalek1.getCol());
                dalek1.advancedTowards(doctor);
            }
            // Make Dalek 2 move towards the doctor
            if (dalek2.hasCrashed() == false) {
                // Have Dalek two move towards the doctor
                board.removePeg(dalek2.getRow(), dalek2.getCol());
                dalek2.advancedTowards(doctor);
            }
            // Make Dalek 3 move towards the doctor
            if (dalek3.hasCrashed() == false) {
                // Have Dalek three move towards the doctor
                board.removePeg(dalek3.getRow(), dalek3.getCol());
                dalek3.advancedTowards(doctor);
            }
            // Place the pegs
            board.putPeg(Color.black, dalek1.getRow(), dalek1.getCol());
            board.putPeg(Color.black, dalek2.getRow(), dalek2.getCol());
            board.putPeg(Color.black, dalek3.getRow(), dalek3.getCol());

        }
    }
}
