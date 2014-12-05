import java.util.LinkedList;
import java.util.List;

/*
 
 */
class Myclass {
	public static void main(String[] args){
		Myclass m = new Myclass();
		m.generateParenthesis(3);
	}
	public List<String> generateParenthesis(int n) {
        List<String> list = new LinkedList<String>();
        StringBuffer s = new StringBuffer("");
        generator(n, 0, 0, s, list);
        return list;
    }
	private void generator(int total, int left, int right,StringBuffer sb,List<String> list) {
		if(left==total && right==total){
			list.add(sb.toString());
			//System.out.println(sb.toString());
			//System.out.print("Done\n");
		}else{
			if(left > right && left <= total){
				this.generator(total, left, right+1, new StringBuffer(sb).append(")"), list);
			}
			if(left < total){
				this.generator(total, left+1, right, new StringBuffer(sb).append("("), list);
			}
		}
		return;
	}
}
