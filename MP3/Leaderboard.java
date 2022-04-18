public class Leaderboard {
  private int score;
  private int ID;
  static int[][] board = new int[100][100];
  public Leaderboard(int s, int i) {
    score = s;
    ID = i;
  }
  public static void addScore(int i, int s, int x, int y)  {
    board[x][0] = i; //id
    board[0][y] = s; //score
  }
   public static void selectionSort(int[][] board) {
    for(int i = 0; i < board.length; i++){
          int smallest = i;
          for(int j = i; j < board.length; j++){
              if(board[i][1] > board[j][1]){
                  smallest = j;
              }
          }
          int temp = board[i][1];
          board[i][1] = board[smallest][1];
          board[smallest][1] = temp;
    }
    for(int i = 0; i < board.length; i++){
        System.out.println(board[i][1]);
    }
  }
}