package org.example.entity;

public class Board {
    private final char[][] board = new char[3][3];
    private int nbOfCompletedCell = 0;

    public Board(){
        for(int i = 0; i < this.board.length; i++){
            for (int j = 0; j < this.board.length; j++){
                this.board[i][j] = '.';
            }
        }
    }

    public void draw(char symbol, int cell) throws RuntimeException{
        final int row = this.getRowNumber(cell-1);
        final int col = this.getColNumber(cell-1);

        if(this.board[row][col] != '.'){
            throw new RuntimeException("Case is not empty");
        }

        this.board[row][col] = symbol;
        ++this.nbOfCompletedCell;
    }

    public boolean isFull(){
        return this.nbOfCompletedCell == 9;
    }

    public boolean isWinningCell(int cell){
        final int row = this.getRowNumber(cell-1);
        final int col = this.getColNumber(cell-1);
        char cellSymbol = this.board[row][col];

        return this.isColWon(col, cellSymbol) || this.isRowWon(row, cellSymbol) || this.isLeftDiagonalWon(cellSymbol) || this.isRightDiagonalWon(cellSymbol);
    }

    private boolean isColWon(int col, char symbol){
        for (char[] chars : this.board) {
            if (chars[col] != symbol) {
                return false;
            }
        }

       return true;
    }

    private boolean isRowWon(int row, char symbol){
       for(int i = 0; i < this.board[row].length; i++){
           if(this.board[row][i] != symbol){
               return false;
           }
       }

       return true;
    }

    private boolean isLeftDiagonalWon(char symbol){
        return this.board[0][0] == symbol && this.board[1][1] == symbol && this.board[2][2] == symbol;
    }

    private boolean isRightDiagonalWon(char symbol){
        return this.board[0][2] == symbol && this.board[1][1] == symbol && this.board[2][0] == symbol;
    }

    private int getRowNumber(int cell){
        return cell / this.board.length;
    }

    private int getColNumber(int cell){
        return (cell % this.board.length);
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        int cell = 0;
        for (char[] chars : this.board) {
            for (char aChar : chars) {
                if(aChar != '.'){
                    sb.append(aChar);
                }else{
                    sb.append(cell+1);
                }
                sb.append("|");
                ++cell;
            }
            sb.append("\n");
        }

        return sb.toString();
    }
}
