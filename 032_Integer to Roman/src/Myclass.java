/*
  Roman numerals:
  I 1
  V 5
  X 10
  L 50
  C 100
  D 500
 */
class Myclass {
	public static void main(String[] args){
		Myclass m = new Myclass();
		System.out.print(m.intToRoman(1999));
	}
	public String intToRoman(int num) {
        StringBuffer sb = new StringBuffer();
        String[] ro = {"M","D","C","L","X","V","I"};
        int [] no = {1000,500,100,50,10,5,1};
        int t;
        sb.append(this.parseLessTen(num/1000, "", "", ro[0]));
        sb.append(this.parseLessTen(num%1000/100,ro[0], ro[1], ro[2]));
        sb.append(this.parseLessTen(num%100/10, ro[2], ro[3], ro[4]));
        sb.append(this.parseLessTen(num%10/1,ro[4], ro[5], ro[6]));
        
        return sb.toString();
    }
	public StringBuffer parseLessTen(int x, String ten, String five, String one){
		StringBuffer sb = new StringBuffer();
		if(x >= 10){
			System.out.print("error");
		}else if(x==9){
			sb.append(one);
			sb.append(ten);
		}else if (x>=5){
			sb.append(five);
			while(x-->5)
				sb.append(one);
		}else if(x <= 3){
			while(x-->0)
				sb.append(one);
		}else{//(x == 4)
			sb.append(one);
			sb.append(five);
		}
		return sb;
	}

}
