class Point {
	int x;
	int y;
	Point() { x = 0; y = 0; }
	Point(int a, int b) { x = a; y = b; }
	}

public class Myclass {
	public static int maxPoints(Point[] points) {
		int length=points.length;
		int max=2;
		int new_max=2;
		int overlap=0;
		if(length < 2)
			max=length;
		for(int i=0;i<length-2;i++){
			int xi=points[i].x;
			int yi=points[i].y;
			overlap=0;
			for(int j=i+1;j<length-1;j++){
				int xj=points[j].x;
				int yj=points[j].y;
				if(xi==xj && yi==yj){//Same_point as (xi,yi)
					overlap++;//how many Same_points
					continue; //beak for(j); new_max
				}
				else if(xi==xj){ //if k==inf
					for(int l=j+1;l<length;l++){		
						if(points[l].x==xi)
							new_max++;
					}
				}
				else{	//k!=inf
					float k=(yi-yj)*1.0f/(xi-xj);
					float b=yi-k*xi;
					for(int l=j+1;l<length;l++){
						int xl=points[l].x;
						int yl=points[l].y;
						int temp=xl-xi;
						if(temp==0){//kl=inf
							if(yl==yi){
								new_max++;
							}
						}
						else{//kl!=inf
							float kl=(yl-yi)*1.0f/(temp);
							float bl=yi-kl*xi;
							if(kl==k && bl==b){
								new_max++;
							}
						}
					}
				}
				max= max > (new_max+overlap)? max: (new_max+overlap);
				new_max=2;
			}
			max= max > (new_max+overlap)? max: (new_max+overlap);
		}
		return max;
	 }
	public static void main(String[] args){
		int N=132;
		Point[] P=new Point[N];//[(0,0),(-1,-1),(2,2)]
		int[] coeff={40,-23,9,138,429,115,50,-17,-3,80,-10,33,5,-21,-3,80,-6,-65,-18,26,-6,-65,5,72,0,77,-9,86,10,-2,-8,85,21,130,18,-6,-18,26,-1,-15,10,-2,8,69,-4,63,0,3,-4,40,-7,84,-8,7,30,154,16,-5,6,90,18,-6,5,77,-4,77,7,-13,-1,-45,16,-5,-9,86,-16,11,-7,84,1,76,3,77,10,67,1,-37,-10,-81,4,-11,-20,13,-10,77,6,-17,-27,2,-10,-81,10,-1,-9,1,-8,43,2,2,2,-21,3,82,8,-1,10,-1,-9,1,-12,42,16,-5,-5,-61,20,-7,9,-35,10,6,12,106,5,-21,-5,82,6,71,-15,34,-10,87,-14,-12,12,106,-5,82,-46,-45,-4,63,16,-5,4,1,-3,-53,0,-17,9,98,-18,26,-9,86,2,77,-2,-49,1,76,-3,-38,-8,7,-17,-37,5,72,10,-37,-4,-57,-3,-53,3,74,-3,-11,-8,7,1,88,-12,42,1,-37,2,77,-6,77,5,72,-4,-57,-18,-33,-12,42,-9,86,2,77,-8,77,-3,77,9,-42,16,41,-29,-37,0,-41,-21,18,-27,-34,0,77,3,74,-7,-69,-21,18,27,146,-20,13,21,130,-6,-65,14,-4,0,3,9,-5,6,-29,-2,73,-1,-15,1,76,-4,77,6,-29
		};//test data
		for(int i=0;i<N;i++){
			P[i]=new Point(coeff[2*i],coeff[2*i+1]);//load data
		}
		int max=maxPoints(P);
	}
}
