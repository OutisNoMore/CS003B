public class BackTracking{
  public static boolean columnHasQueen(char[][] board, int col){
    for(int i = 0; i < board.length; i++){
      if(board[i][col] == 'Q'){
        return true;
      }
    }

    return false;
  }

  public static boolean rowHasQueen(char[][] board, int row){
    for(int i = 0; i < board[row].length; i++){
      if(board[row][i] == 'Q'){
        return true;
      }
    }

    return false;
  }

  public static boolean antiDiagonalHasQueen(char[][] board, int row, int col){
    int topOfAntiDiagonal;
    if(row + col < board.length){
      topOfAntiDiagonal = row+col;

      for(int c = 0, r = topOfAntiDiagonal; c < board.length && r > 0; c++, r--){
        if(board[r][c] == 'Q'){
          return true;
        }
      }
    }
    else{
      topOfAntiDiagonal = (row + col) % (board.length-1);
      for(int c = board.length-1, r = topOfAntiDiagonal; c > 0 && r < board.length; c--, r++){
        if(board[r][c] == 'Q'){
          return true;
        }
      }
    }

    return false;
  }

  public static boolean diagonalHasQueen(char[][] board, int row, int col){
    int topOfAntiDiagonal;
    
    if(col >= row){
      topOfAntiDiagonal = (col - row);

      for(int c = topOfAntiDiagonal, r = 0; c < board.length && r < board.length; r++, c++){
        if(board[r][c] == 'Q'){
          return true;
        }
      }
    }
    else{
      topOfAntiDiagonal = (row - col);
      for(int r = topOfAntiDiagonal, c = 0; c < board.length && r < board.length; r++, c++){
        if(board[r][c] == 'Q'){
          return true;
        }
      }
    }

    return false;
  }

  public static boolean nQueens(char[][] board, int row, int col){
    // End of board, solution complete
    if(row == board.length){
      return true;
    }
    // Last column, move on to next row
    if(col == board[row].length){
      return nQueens(board, row + 1, 0);
    }
    // Check if row and col is a valid position for Queen
    if(rowHasQueen(board, row)           ||
       columnHasQueen(board, col)        ||
       diagonalHasQueen(board, row, col) ||
       antiDiagonalHasQueen(board, row, col));
    else board[row][col] = 'Q';

    return nQueens(board, row, col+1);
  }

  public static void printBoard(char[][] board){
    for(int i = 0; i < board.length; i++){
      for(int j = 0; j < board[i].length; j++){
        System.out.print(board[i][j] + " ");
      }
      System.out.println();
    }
  }

  public static void fillBoard(char[][]board){
    char first = 'b';
    char second = 'w';
    for(int i = 0; i < board.length; i++){
      if(i%2 == 0){
        first = 'b';
        second = 'w';
      } else{
        first = 'w';
        second = 'b';
      }
      for(int j = 0; j < board[i].length; j++){
        if(j%2 == 0){
          board[i][j] = first;
        }
        else{
          board[i][j] = second;
        }
      }
    }
  }

  public static void main(String args[]){
    char[][] board = new char[8][8];
    fillBoard(board);

    nQueens(board, 0, 0);

    printBoard(board);
  }
}
