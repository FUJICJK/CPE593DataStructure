/**
 * Created by junkai on 2/18/2017.
 */
import java.io.*;


public class GrowArray {
    private int[] p;
    private int used;
    // this should double the size of your list
    private	void grow() {
        int[] temp = new int[this.getCapacity()*2];
        for(int i=0;i<used;i++){
            temp[i]=p[i];
        }
        p=temp;
    }
    public GrowArray() {
        p = new int[1];
        used = 0;
    }
    public GrowArray(int capacity) {
        p = new int[capacity];
        used = 0;
    }
    public void addStart(int v) { 
    	if(used == p.length)
            grow();
        for(int i = used;i>0;i--)
            p[i]=p[i-1];
        p[0]=v;
        used++;
    }

    public void removeStart(){
        if (used==0)
            return;
        else {
            for (int i =0;i<used;i++)
                p[i]=p[i+1];
            used--;
        }

    }

    public void addEnd(int v) {
        if (used == p.length)
            grow();
        p[used]=v;
        used++;
        // O(1)
    }
    public void removeEnd(){
        if (used == 0)
            return;
        else used--;
    }

    public int getCapacity() {
        return p.length;
    }

    public void print(){
    	if(used!=0){
    		int i=0;
    		 for (i = 0;i<used-1;i++ )
    	        {
    	            System.out.print(p[i]+",");
    	        }
    		 System.out.print(p[i]);
    	}
        
        System.out.println();
    }

    public int getUsed() {
        return used;
    }
    int get(int i) { 
        return p[i];
    }
    void set(int i, int v) {
        p[i] = v;
    }

    public static void main(String[] args){
        GrowArray a =new GrowArray();
        try{
            File filename = new File("HW4a.txt");
            InputStreamReader reader = new InputStreamReader(
                    new FileInputStream(filename));
            BufferedReader br = new BufferedReader(reader);
            String line = "";
            line = br.readLine();
            while (line != null) {
                
                if(line.equals("OUTPUT"))
                	a.print();
                else {
                	String[] parts1 = line.split(" ");
                	String operation = parts1[0];
                	//System.out.println(operation);
                	
                	if (operation.equals("ADD_FRONT")){
                		String[] parts2=parts1[1].split(":");
                		int start =Integer.parseInt(parts2[0]);
                		int step =Integer.parseInt(parts2[1]);
                		int end =Integer.parseInt(parts2[2]);
                		if (start<=end){
                			for (int i = start;i<=end;i+=step){
                				a.addStart(i);
                			}
                		}
                		else{
                			for (int i = start;i>=end;i+=step){
                				a.addStart(i);
                		}
                	}
                	}
                	
                	if (operation.equals("ADD_BACK")){
                		String[] parts2=parts1[1].split(":");
                		int start =Integer.parseInt(parts2[0]);
                		int step =Integer.parseInt(parts2[1]);
                		int end =Integer.parseInt(parts2[2]);
                		if (start<=end){
                			for (int i = start;i<=end;i+=step){
                				a.addEnd(i);
                			}
                		}
                		else{
                			for (int i = start;i>=end;i+=step){
                				a.addEnd(i);
                		}
                	}
                	}
                	
                	if (operation.equals("REMOVE_FRONT")){                		
                		int num =Integer.parseInt(parts1[1]);
                		for (int i = 0;i<num;i++){
                			a.removeStart();;
                		}
                	}
                	
                	if (operation.equals("REMOVE_BACK")){                		
                		int num =Integer.parseInt(parts1[1]);
                		for (int i = 0;i<num;i++){
                			a.removeEnd();;
                		}
                	}
                	
                }
                line = br.readLine();
            }
            br.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found !");
        } catch (IOException e) {
            e.printStackTrace();
        }
       

    }

};
