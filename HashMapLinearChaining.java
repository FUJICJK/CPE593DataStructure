import java.io.*;
import java.util.*;

public class HashMapLinearChaining {

	private int size;
	private int used;
	private LinkedList[] table;
	
	public HashMapLinearChaining(int inital){
		this.size=inital;
		this.used=0;
		this.table = new LinkedList[inital]; 
		
	}
	
	
	public int Hashfunction(String word){
		int key = word.hashCode()%size;
		return Math.abs(key);
	}
	
	public void put(String word){
		int key = Hashfunction(word);
		if (table[key]==null)
			table[key]= new LinkedList<String>();
		table[key].add(word);
		
	}
	
	public boolean isWord(String word){
		int key = Hashfunction(word);
		return table[key].contains(word);
	}
	
	public static void main(String[] args) throws Exception  {
	
		HashMapLinearChaining dict=new HashMapLinearChaining(100);
		 File filename=new File("dict.txt");
			InputStreamReader reader = new InputStreamReader(
			        new FileInputStream(filename));
			BufferedReader br = new BufferedReader(reader);
	        String line = "";
	        line = br.readLine();
	        while (line != null) {
	        	dict.put(line);
	        	line = br.readLine();
	        }
	        br.close();
	        reader.close();
	        
	       filename=new File("hw8.txt");
	       reader = new InputStreamReader(
			        new FileInputStream(filename));
	       br = new BufferedReader(reader);
	       line = "";
	        line = br.readLine();
	        while (line != null) {
	        	System.out.println(line+":"+dict.isWord(line));
	        	line=br.readLine();
	        }
	        br.close();
	        reader.close();
	        
	        for(int i=0;i<dict.size;i++){
	        	System.out.println(i+" : "+dict.table[i].size());
	        }
	        
	}
}