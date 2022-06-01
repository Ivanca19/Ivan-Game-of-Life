package game;
// This class defines a Cell object. The "Living" things that will be changing due to their environment in my game of life
public class Cell {

    private boolean[][] _planet;

    public Cell(int row, int col) {
        _planet = new boolean[row][col];
        turnOff();
    }

    public boolean[][] getBoard() { return _planet;}
    
    // this method kills all of the cells in the board
    public void turnOff() {
        for(int r = 0; r < _planet.length; r++) {
            for (int c = 0; c < _planet[r].length; c++) {
                _planet[r][c] = false;
            }
        }
    }
    
    // this method brings all of the cells to life on the board
    public void turnOn() {
        for(int r = 0; r < _planet.length; r++) {
            for (int c = 0; c < _planet[r].length; c++) {
                _planet[r][c] = true;
            }
        }
    }

    // this is the method that is called on every single cell that analyzes the cell's environment to determine whether the cell will live or die.
    public boolean live(int row, int col) {
        int cnt = 0;

        if(row < _planet.length - 1){
            if(_planet[row + 1][col])
                cnt++;
        }
        if(col < _planet[0].length - 1){
            if(_planet[row][col + 1])
                cnt++;
        }
        if(row > 0){
            if(_planet[row - 1][col])
                cnt++;
        }
        if(col > 0){
            if(_planet[row][col - 1])
                cnt++;
        }
        if((row < _planet.length - 1) && (col < _planet[0].length - 1)){
            if(_planet[row + 1][col + 1])
                cnt++;
        }
        if((row > 0) && (col > 0)){
            if(_planet[row - 1][col - 1])
                cnt++;
        }
        if((row > 0) && (col < _planet[0].length - 1)){
            if(_planet[row - 1][col + 1])
                cnt++;
        }
        if((row < _planet.length - 1) && (col > 0)){
            if(_planet[row + 1][col - 1])
                cnt++;
        }

        if((_planet[row][col]) && (cnt == 2 || cnt == 3))
            return true;
        else if((!_planet[row][col]) && cnt == 3)
            return true;

        return false;
    }

    // this method randomly kills or brings to life a cell via a coin toss.
    public void randomize() {
        for(int r = 0; r < _planet.length; r++) {
            for (int c = 0; c < _planet[r].length; c++) {
                int sus = (int)(101 * Math.random());
                if(sus < 50)
                    _planet[r][c] = true;
                else
                    _planet[r][c] = false;
            }
        }
    }
}

