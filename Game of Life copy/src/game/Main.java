package game;

import javax.swing.*;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        JOptionPane.showMessageDialog(null,"Welcome to the Game of Life.");
        int x = 0;
        int iRow = 0;
        while( x == 0) {
            String pRow = JOptionPane.showInputDialog("Please choose how many rows you would like. (Minimum is 6, Maximum is 25).");
            iRow = Integer.parseInt(pRow);
            if(iRow >= 6 && iRow <= 25)
                x++;
        }
        x = 0;
        int iCol = 0;
        while( x == 0) {
            String pCol = JOptionPane.showInputDialog("Please choose how many columns you would like. (Minimum is 6, Maximum is 25).");
            iCol = Integer.parseInt(pCol);
            if(iCol >= 6 && iCol <= 25)
                x++;
        }

        x = 0;
        int inum = 0;
        while( x == 0) {
            String num = JOptionPane.showInputDialog("Please choose your spawn chance percentage. You only have to put the number. (Minimum is 1%, Maximum is 80%).");
            inum = Integer.parseInt(num);
            if(inum >= 1 && inum <= 80)
                x++;
        }

        x = 0;
        Overseer board = new Overseer(iRow, iCol);
        board.startBoard(inum);
        while(x == 0) {

            if(board.menu() == false) {
                x++;
            }
        }

    }
}
