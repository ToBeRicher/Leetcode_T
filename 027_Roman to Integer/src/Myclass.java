import javax.xml.stream.events.Characters;

/*
 Given a roman numeral, convert it to an integer.

Input is guaranteed to be within the range from 1 to 3999.
 */
class Myclass {
	public static void main(String[] args){
		Myclass m = new Myclass();
		System.out.print(m.romanToInt("XXIX"));
	}

	int res = 0;
	int gotMaxUnit=0;
	public int romanToInt(String s) {
		char[] ch = s.toCharArray();
		for(int i = ch.length-1; i>=0; i--){
			char c = ch[i];
			if(c == 'I'){
				update(1);
			}else if(c == 'V'){
				update(5);
			}else if(c == 'X'){
				update(10);
			}else if(c == 'L'){
				update(50);
			}else if(c == 'C'){
				update(100);
			}else if(c == 'D'){
				update(500);
			}else if(c == 'M'){
				update(1000);
			}
		}
		return res;
    }
	private void update(int n){

		if(gotMaxUnit <= n){
			res+=n;
		}else{
			res-=n;
		}
		gotMaxUnit = gotMaxUnit >= n ? gotMaxUnit: n;
	}
}
