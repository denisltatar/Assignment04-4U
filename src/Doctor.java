/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tatad6701
 */
public class Doctor {

    // Create the constants to be used
    private int col;
    private int row;

    /**
     * A constructor to create the doctor creator
     *
     * @param theRow The row number of the doctor character being passed through
     * by the user
     * @param theCol The column number of the doctor character being passed
     * through by the user
     */
    public Doctor(int theRow, int theCol) {
        this.col = theCol;
        this.row = theRow;
    }

    /**
     * Method used to move the doctor peg (if one space, move there, if not then
     * generate randomly)
     *
     * @param newRow The row from the user's click being passed through
     * @param newCol The column from the user's click being passed through
     */
    public void move(int newRow, int newCol) {
        // Integer for a random move ((Row)
        int randomRow = (int) (Math.random() * 12);
        // Integer for a random move (Col)
        int randomCol = (int) (Math.random() * 12);
        // if it's one spot away, then move there && if the spot is more than one teloport randomly
        if (this.row - newRow <= 1 && this.row - newRow >= -1 && this.col - newCol <= 1 && this.col - newCol >= -1) {
            this.row = newRow;
            this.col = newCol;
        } else {
            // Randomize the new spot of the doctor
            this.row = randomRow;
            this.col = randomCol;

        }
    }

    /**
     * Return the row number of the doctor
     *
     * @return the row number of the doctor
     */
    public int getRow() {
        return this.row;
    }

    /**
     * Returns the column number of the doctor
     *
     * @return the column number of the doctor
     */
    public int getCol() {
        return this.col;
    }
}
