/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tatad6701
 */
public class Dalek {

    // Create the constants to be used (instance variables)
    private int col;
    private int row;
    private boolean dalekCrash = false;

    /**
     * A constructor to create a Dalek
     *
     * @param theRow the row number of the Dalek character which are randomized
     * @param theCol the column number of the Dalek character which are
     * randomized
     */
    public Dalek(int theRow, int theCol) {
        // Initializing the instance variables
        this.col = theCol;
        this.row = theRow;
    }

    /**
     * Method that moves the Dalek towards the doctor
     *
     * @param doctor the doctor, the character which the Dalek must move towards
     */
    public void advanceTowards(Doctor doctor) {
        // Advancing towards the Doctor using the row numbers
        if (doctor.getRow() > this.row) {
            this.row++;
        } else if (doctor.getRow() < this.getRow()) {
            this.row--;
        }
        // Advancing towards the Doctor using the column numbers
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
        // Returns the current row number of the Dalek character
        return this.row;
    }

    /**
     * Return the current column number of the Dalek character
     *
     * @return the current column number of the Dalek character
     */
    public int getCol() {
        // Returns the current column number of the Dalek character
        return this.col;
    }

    /**
     * Method that tells whether two Daleks have collided/crashed
     */
    public void crash() {
        // The Dalek has crashed (set to true)
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
        // Return whether the Dalek has crashed or not
        return dalekCrash;
    }
}
