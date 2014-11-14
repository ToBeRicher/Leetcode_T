/*
 * Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.
 */
class Myclass {
 
	public static void main(String[] args){
		Myclass m = new Myclass();
		int[][] matrix = {{0,0,0,5},{4,3,1,4},{0,1,1,4},{1,2,1,3},{0,0,1,1}};
		m.setZeroes(matrix);
		for(int[] i: matrix){
			for(int j: i)
				System.out.print(j+",");
			System.out.print("\n");
		}
	}
	public void setZeroes(int[][] matrix) {
		boolean row[] = new boolean[matrix.length];
		boolean col[] = new boolean[matrix[0].length];
		
		for(int i=0; i<matrix.length; i++){
        	for(int j=0; j<matrix[i].length; j++){
        		if(matrix[i][j]==0){
        			row[i]=true;
        			col[j]=true;
        		}
        	}
        }
		
		for(int i=0; i<row.length; i++){
			if(row[i]==true){
				for(int j=0; j<col.length; j++){
						matrix[i][j]=0;
				}
			}
		}
		for(int j=0; j<col.length; j++){
			if(col[j]==true){
				for(int i=0; i<row.length; i++){
					matrix[i][j]=0;
				}
			}
		}
    }
	
}
