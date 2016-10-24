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

//    public advanceTowards(Doctor doc) {
//        if () {
//        }
//    }
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

    // Create the method here but then add your if statements within the main class 
    public void crash() {
        dalekCrash = true;
    }

    /**
     * Check if the Dalek has crashed
     *
     * @return the
     * ****************************************************************
     */
    public boolean hasCrashed() {
        return dalekCrash;
    }
}
