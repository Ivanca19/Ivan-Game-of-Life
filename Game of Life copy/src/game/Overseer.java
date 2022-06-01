package game;

import javax.swing.*;

// The overseer class is in change of overseeing the interactions between the player the cell and the view.
public class Overseer {

    private Cell _board;
    private View _map;

    public Overseer(int row, int col) {
        _board = new Cell(row, col);
        _map = new View(_board);


    }

    public static int opt(Object[] options, String msg, String title) {
        return JOptionPane.showOptionDialog(null, msg, title, JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, 0);
    }

    public static int yNC(String msg, String title) {
        return JOptionPane.showOptionDialog(null, msg, title, JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, null, 0);
    }

    public static int yN(String msg, String title) {
        return JOptionPane.showOptionDialog(null, msg, title, JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, null, 0);
    }

    // This method creates the Menu that the player will interact with.
    public boolean menu() throws InterruptedException {

        String[] options = {"Exit", "Next Gen"};


        int x = -1;


        int oPT = opt(options, getMap(), "The Game of Life");

        if (oPT == 0) {
            JOptionPane.showMessageDialog(null, "Thank you. Goodbye :)");
            return false;
        }
        else if (oPT == 1) {
            for (int r = 0; r < _board.getBoard().length; r++) {
                for (int c = 0; c < _board.getBoard()[r].length; c++) {
                    if (_board.live(r, c))
                        _board.getBoard()[r][c] = true;
                    else
                        _board.getBoard()[r][c] = false;
                }
            }
        }
        return true;
    }

    public String getMap(){
        return _map.drawView();
    }

    public int Light() {
        int x = (int)(101 * Math.random());
        return x;
    }

    public void startBoard(int imp) {
        for(int r = 0; r < _board.getBoard().length ; r++) {
            for(int c = 0; c < _board.getBoard()[r].length ; c++) {

                if(Light() <= imp)
                    _board.getBoard()[r][c] = true;

            }
        }
    }

}
