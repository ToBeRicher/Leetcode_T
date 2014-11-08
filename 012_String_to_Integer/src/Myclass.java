class Myclass {
 
	//把string 转换成整数，如果string不符合书写规范，则返回0
	public static void main(String[] args){
		Myclass m = new Myclass();
		System.out.print(m.atoi("+-12"));
	}
	public int atoi(String str) {
		if(str == null)
			return 0;
		
		char[] cha = str.toCharArray();
		long result=0;

		boolean isWaitSymbolOrNumber = true;
		boolean isGetSymbol = false;
		int symbol = 1;
		for(int c : cha){
			if(isWaitSymbolOrNumber && c==' ')
				continue;
			else{
				if(isGetSymbol == false&&(c=='+'|| c=='-')){
					symbol = c=='+'? 1:-1;
					isGetSymbol =true;
				}else if(c>='0' && c<='9'){
					result = result*10 + c-'0';
					isGetSymbol = true;
				}else{
					break;
				}
				isWaitSymbolOrNumber=false;
			}
		}
		if(result*symbol <= 2147483647 && result*symbol >= -2147483648)
			return (int)result*symbol;
		else if(result*symbol > 2147483647)
			return 2147483647;
		else
			return -2147483648;
    }
}
