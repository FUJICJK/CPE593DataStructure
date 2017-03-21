public class Heapsort {


	public static void heapSort(int[] x) {
	        int len = x.length - 1;
	        int beginIndex = (len - 1) >> 1; 
	        for(int i = beginIndex; i >= 0; i--){
	            maxHeapify(x,i, len);
	        }
	        
	        for(int i = len; i > 0; i--){
	            swap(x,0, i);
	            maxHeapify(x,0, i - 1);
	        }
}
	    
	    private static void maxHeapify(int x[],int index,int len){
	        int li = (index << 1) + 1; 
	        int ri = li + 1;           
	        int cMax = li;            
	        
	        if(li > len) return;      
	        if(ri <= len && x[ri] > x[li])
	            cMax = ri;
	        if(x[cMax] > x[index]){
	            swap(x,cMax, index);      
	            maxHeapify(x,cMax, len);  
	        }
	    }

		private static void swap(int x[],int i,int j){
	        int temp = x[i];
	        x[i] = x[j];
	        x[j] = temp;
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
			heapSort(x1);
			print(x1);
			System.out.println();
			print(x2);
			heapSort(x2);
			print(x2);
			System.out.println();
			print(x3);
			heapSort(x3);
			print(x3);
		}


}
