/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tatad6701
 */
public class Doctor {

    // Create the constants
    private int col;
    private int row;

    /**
     * A constructor to create the doctor creator
     *
     * @param theRow The row number of the doctor character
     * @param theCol The column number of the doctor character
     */
    public Doctor(int theRow, int theCol) {
        this.col = theCol;
        this.row = theRow;
    }

    public void move(int newRow, int newCol) {
        // if it's one spot away, then move there && if the spot is more than one teloport randomly
        if (this.row - newRow == 0) {
        } else {
            //int rand
        }
    }

    public int getRow() {
        return this.row;
    }

    public int getCol() {
        return this.row;
    }
}
