/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tatad6701
 */
public class Doctor {

    // Create the constants to be used (instance variables)
    private int col;
    private int row;

    /**
     * A constructor to create the doctor
     *
     * @param theRow the row number of the doctor character being passed through
     * by the user
     * @param theCol the column number of the doctor character being passed
     * through by the user
     */
    public Doctor(int theRow, int theCol) {
        // Initializing instance variables
        this.col = theCol;
        this.row = theRow;
    }

    /**
     * Method used to move the doctor peg (if one space away, move there, if not
     * then generate randomly to a new spot within the game board)
     *
     * @param newRow the row from the user's click being passed through
     * @param newCol the column from the user's click being passed through
     */
    public void move(int newRow, int newCol) {
        // Integer for a random move (Row)
        int randomRow = (int) (Math.random() * 12);
        // Integer for a random move (Col)
        int randomCol = (int) (Math.random() * 12);
        // If the doctor is one spot away, then move there & if the spot is more than one teleport randomly to another spot within the game board   
        if (this.row - newRow <= 1 && this.row - newRow >= -1 && this.col - newCol <= 1 && this.col - newCol >= -1) {
            this.row = newRow;
            this.col = newCol;
        } else {
            // Randomize the new spot of the doctor within the game board
            this.row = randomRow;
            this.col = randomCol;
        }
    }

    /**
     * Return the current row number of the doctor
     *
     * @return the current row number of the doctor
     */
    public int getRow() {
        // Return the Doctor's current row position number
        return this.row;
    }

    /**
     * Returns the current column number of the doctor
     *
     * @return the current column number of the doctor
     */
    public int getCol() {
        // Return Doctor's current column position number
        return this.col;
    }
}
