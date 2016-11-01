/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tatad6701
 */
public class Dalek {

    // Create the constants to be used
    private int col;
    private int row;
    private boolean dalekCrash = false;

    /**
     * A constructor to create a Dalek
     *
     * @param theRow The row number of the Dalek character which are randomized
     * @param theCol The column number of the Dalek character which are
     * randomized
     */
    public Dalek(int theRow, int theCol) {
        this.col = theCol;
        this.row = theRow;
    }

    /**
     * Method that moves the Dalek towards the doctor
     *
     * @param doctor The doctor, the character which the Dalek must move towards
     */
    public void advancedTowards(Doctor doctor) {
        if (doctor.getRow() > this.row) {
            this.row++;
        } else if (doctor.getRow() < this.getRow()) {
            this.row--;
        }
        if (doctor.getCol() > this.col) {
            this.col++;
        } else if (doctor.getCol() < this.col) {
            this.col--;
        }
    }

    /**
     * Return the current row number of the Dalek character
     *
     * @return the current row number of the Dalek character
     */
    public int getRow() {
        // Return the current row number of the Dalek character
        return this.row;
    }

    /**
     * Return the current column number of the Dalek character
     *
     * @return the current column number of the Dalek character
     */
    public int getCol() {
        // Return the current column number of the Dalek character
        return this.col;
    }

    /**
     * Method that tells whether two Daleks have collided/crashed
     */
    public void crash() {
        dalekCrash = true;
    }

    /**
     * Check if the Dalek has crashed (True or False)
     *
     * @return the boolean (true or flase) that determines whether if the Dalek
     * has crashed (true) or not (false)
     *
     *
     */
    public boolean hasCrashed() {
        // Return whether the Dalek has crashed
        return dalekCrash;
    }
}
