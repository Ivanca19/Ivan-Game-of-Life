package game;

public class Cell {

    private boolean[][] _planet;

    public Cell(int row, int col) {
        _planet = new boolean[row][col];
        turnOff();
    }

    public boolean[][] getBoard() { return _planet;}

    public void turnOff() {
        for(int r = 0; r < _planet.length; r++) {
            for (int c = 0; c < _planet[r].length; c++) {
                _planet[r][c] = false;
            }
        }
    }

    public void turnOn() {
        for(int r = 0; r < _planet.length; r++) {
            for (int c = 0; c < _planet[r].length; c++) {
                _planet[r][c] = true;
            }
        }
    }

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

