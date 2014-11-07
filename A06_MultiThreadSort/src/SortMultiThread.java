
public class SortMultiThread {
	
	public void sort(double[] array,int length){
		SortOneThread s1 = new SortOneThread(); 
		SortOneThread s2 = new SortOneThread();
		double[] array2 = new double[array.length];
		System.arraycopy(array, 0, array2, 0, array.length);
		s1.run(array, 0, (int)(length/2));
		s2.run(array2, (int)(length/2) + 1, length - 1);
		
	}

}
