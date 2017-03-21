import java.io.*;

public class DoubleLinkedList {
	private static class Node{
		private int val;
		Node next;
		Node prev;
		Node(int v, Node next, Node prev){
			this.val=v;
			this.next=next;
			this.prev=prev;
		}
	}
	private Node head;
	private Node tail;


	public void addStart(int v){
		head = new Node(v,head,null);
		if (tail==null)
			tail=head;
		if(head.next != null)
			head.next.prev=head;
	}
	public void addEnd(int v){
		tail = new Node(v,null,tail);
		if (head==null)
			head=tail;
		if (tail.prev !=null)
			tail.prev.next=tail;
	}
	public void removeStart(){
		head=head.next;
		head.prev=null;
	}
	public void removeEnd(){
		tail=tail.prev;
		tail.next=null;
	}

	public int get(int i) {
		Node p = head;
		for (int j = 0; j < i; j++) {
			p = p.next;
		}
		return p.val;
	}
	 public void print(){
		 if(head!=null){
			 Node p = head;
			 while(p!=tail){
				 System.out.print(p.val+",");
				 p= p.next;
			 }
			 System.out.print(tail.val);
		 }
		 System.out.println();
	}



	public static void main(String[] args) {//Test
		DoubleLinkedList a = new DoubleLinkedList();
		 try{
	            File filename = new File("HW4b.txt");
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
}
