
public class Choose {
    static int MAX=10000;
    static int result[][] = new int[MAX][MAX] ;
	public static int choose(int n,int r){
		if(result[n][r]>0)
			return result[n][r];
		if(r==0)return result[n][r]=1;
		if(n==r)return result[n][r]=1;
		return result[n][r]=choose(n-1,r)+choose(n-1,r-1);
		
	}
	
	public static void main(String[] args){
		int n=50;
		int r=45;
		System.out.println("C("+n+","+r+")="+choose(n,r));
		
	}
}