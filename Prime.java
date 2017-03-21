
public class Prime {

	public static int CaculaePrime(int Min, int  Max){
		boolean isPrime[] = new boolean[Max+1];
		int total=0;
		isPrime[2]=true;
		if (Min<=2)
			total++;
		for(int i=3;i<=Max;i++){
			isPrime[i]=true;
		}
		for (int i=3;i<Max;i+=2){
			if(isPrime[i]){
				for (int j=i+i;j<Max;j+=i)
					isPrime[j]=false;
				if (i>=Min)
					total++;
			}	
		}
		return total;
	}
	
	public static void main(String[] args){
		System.out.println(CaculaePrime(100000,110000));
	}
	
}
