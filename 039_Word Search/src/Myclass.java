/*
 Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, 
	where "adjacent" cells are those horizontally or vertically neighboring. 
The same letter cell may not be used more than once.

For example,
Given board =

[
  ["ABCE"],
  ["SFCS"],
  ["ADEE"]
]
word = "ABCCED", -> returns true,
word = "SEE", -> returns true,
word = "ABCB", -> returns false.
 */
class Myclass {
	public static void main(String[] args){
		Myclass m = new Myclass();
		
	}
    public boolean exist(char[][] board, String word) {
        boolean visited[][] = new boolean[board.length][board[0].length];
        char[] ch = word.toCharArray();
        for(int i=0;i<board.length; i++){ //discover first character
        	for(int j=0; j<board[i].length; j++){
        		if(board[i][j] == ch[0]){
        			if(dfs(board, visited,i,j,ch,1))
        				return true;
        		}
        	}
        }
        return false;
    }
	private boolean dfs(char[][] board, boolean[][] visited, int vi, int vj, char[] ch, int ck) {
		if(ck >= ch.length)
			return true;
		
		visited[vi][vj] = true;
		if(vi>0 && board[vi-1][vj]==ch[ck] && visited[vi-1][vj] ==false){
			if(dfs(board, visited,vi-1,vj,ch,ck+1))
				return true;
		}
		if(vi<board.length-1 && board[vi+1][vj]==ch[ck]&& visited[vi+1][vj]==false){
			if(dfs(board, visited,vi+1,vj,ch,ck+1))
				return true;
		}
		if(vj>0 && board[vi][vj-1]==ch[ck] && visited[vi][vj-1] ==false){
			if(dfs(board, visited,vi,vj-1,ch,ck+1))
				return true;
		}
		if(vj<board[0].length-1 && board[vi][vj+1]==ch[ck]&& visited[vi][vj+1]==false){
			if(dfs(board, visited,vi,vj+1,ch,ck+1))
				return true;
		}
		visited[vi][vj] = false;
		return false;
	}
}
