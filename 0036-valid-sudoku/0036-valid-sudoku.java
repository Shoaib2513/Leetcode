class Solution {
    public boolean check(char[][] board,int rs,int re,int cs,int ce){
        HashSet<Character> set = new HashSet<>();
        for(int i=rs;i<=re;i++){
            for(int j=cs;j<=ce;j++){
               if(board[i][j] != '.'){
                if(set.contains(board[i][j])) return false;
                else set.add(board[i][j]);
             } 
            }
        }
        return true;
    }
    public boolean isValidSudoku(char[][] board) {
      HashSet<Character> set = new HashSet<>();
      //row checking
      for(int i=0;i<9;i++){
        for(int j=0;j<9;j++){
              if(board[i][j] != '.'){
                if(set.contains(board[i][j])) return false;
                else set.add(board[i][j]);
             }
        }
        set.clear();
      }

        //column checking
         for(int j=0;j<9;j++){
        for(int i=0;i<9;i++){
             if(board[i][j] != '.'){
                if(set.contains(board[i][j])) return false;
                else set.add(board[i][j]);
             }
        }
        set.clear();
      }

      //individual box checking
      boolean flag1 = check(board,0,2,0,2);
      boolean flag2 = check(board,0,2,3,5);
      boolean flag3 = check(board,0,2,6,8);
      boolean flag4 = check(board,3,5,0,2);
      boolean flag5 = check(board,3,5,3,5);
      boolean flag6 = check(board,3,5,6,8);
      boolean flag7 = check(board,6,8,0,2);
      boolean flag8 = check(board,6,8,3,5);
      boolean flag9 = check(board,6,8,6,8);

      boolean flag = flag1 && flag2 && flag3 && flag4 && flag5 && flag6 && flag7 && flag8 && flag9;
      if(flag==false) return false;
      return true;



    }
}