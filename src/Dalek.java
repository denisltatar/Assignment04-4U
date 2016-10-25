/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tatad6701
 */
public class Dalek {

    // Create the constants
    private int col;
    private int row;
    private boolean dalekCrash = false;

    /**
     * A constructor to create the Daleks
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
     * @param doctor the doctor, the character which the Dalek must move towards
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
     * Return the row number of the Dalek character
     *
     * @return the row number of the Dalek character
     */
    public int getRow() {
        return this.row;
    }

    /**
     * Return the column number of the Dalek character
     *
     * @return the column number of the Dalek character
     */
    public int getCol() {
        return this.col;
    }

    /**
     * Method that tell whether two Daleks collide
     */
    // Create the method here but then add your if statements within the main class 
    public void crash() {
        dalekCrash = true;
    }

    /**
     * Check if the Dalek has crashed (True or False)
     *
     * @return the boolean that determines whether if the Dalek has crashed or
     * not
     *
     */
    public boolean hasCrashed() {
        return dalekCrash;
    }
}
