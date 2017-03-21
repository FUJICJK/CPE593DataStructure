import java.util.Random;
public class Quicksort {

	private static Random r = new Random(0);
	

	public static void quickSort(int[] x,int left,int right) {
		 
		        int i = left;
		        int j = right;
		       
		        int pivot = x[left+(right-left)/2];
		        while (i <= j) {
		            while (x[i] < pivot) {
		                i++;
		            }
		            while (x[j] > pivot) {
		                j--;
		            }
		            if (i <= j) {
		            	int temp = x[i];
		            	x[i] = x[j];
		 		        x[j] = temp;
		                i++;
		                j--;
		            }
		        }
		       
		        if (left < j)
		            quickSort(x,left, j);
		        if (i < right)
		            quickSort(x,i, right);
		        }	   
		
		public static void print(int[] x) {
			for (int i = 0; i < x.length; ++i)
				System.out.print(x[i] + " ");
			System.out.println();
		}

		public static void main(String [] args) {
			int x1[]  = {1,2,3,4,5,6,7,8,9,10};
			int x2[]  = {10,9,8,7,6,5,4,3,2,1};
			int x3[]  = {62,50,50,50,62};
			print(x1);
			quickSort(x1,0,x1.length-1);
			print(x1);
			System.out.println();
			print(x2);
			quickSort(x2,0,x2.length-1);
			print(x2);
			System.out.println();
			print(x3);
			quickSort(x3,0,x3.length-1);
			print(x3);
		}


}
