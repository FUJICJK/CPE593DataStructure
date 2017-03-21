
public class Tree {
	private TreeNode root;
	public Tree(){
		this.root=new TreeNode(1,"RootNode(A)");
	}
	
	public void createBinTree(TreeNode root){  
        TreeNode newNodeB = new TreeNode(2,"B");  
        TreeNode newNodeC = new TreeNode(3,"C");  
        TreeNode newNodeD = new TreeNode(4,"D");  
        TreeNode newNodeE = new TreeNode(5,"E");  
        TreeNode newNodeF = new TreeNode(6,"F");  
        TreeNode newNodeG = new TreeNode(7,"G");  
        TreeNode newNodeH = new TreeNode(8,"H"); 
        TreeNode newNodeI = new TreeNode(9,"I");  
        TreeNode newNodeJ = new TreeNode(10,"J");  
        root.leftChild=newNodeB;  
        root.rightChild=newNodeC;  
        root.leftChild.leftChild=newNodeD;  
        root.leftChild.rightChild=newNodeE;  
        root.rightChild.rightChild=newNodeF;
        root.leftChild.leftChild.leftChild=newNodeG;
        root.leftChild.rightChild.leftChild=newNodeH;
        root.leftChild.rightChild.rightChild=newNodeI;
        root.rightChild.rightChild.leftChild=newNodeJ;
    }  
	
	private class  TreeNode{  
		private int key=0;
		private String data=null;
		private TreeNode leftChild=null;
		private TreeNode rightChild=null;
		
		private TreeNode(int key,String data){
			this.key=key;
			this.data=data;
		}
	}
	
	public boolean isEmpty(){  
        return root==null;  
    }  
	
	 public int height(){  
	        return height(root);  
	    }  
	      
	 public int size(){  
	        return size(root);  
	    }  
	 
	 private int height(TreeNode subTree){  
	        if(subTree==null)  
	            return 0;//递归结束：空树高度为0  
	        else{  
	            int i=height(subTree.leftChild);  
	            int j=height(subTree.rightChild);  
	            return (i<j)?(j+1):(i+1);  
	        }  
	    }  
	      
	 private int size(TreeNode subTree){  
	        if(subTree==null){  
	            return 0;  
	        }else{  
	            return 1+size(subTree.leftChild)  
	                    +size(subTree.rightChild);  
	        }  
	    }  
	 
	 public TreeNode parent(TreeNode element){  
	        return (root==null|| root==element)?null:parent(root, element);  
	    }  
	      
	 public TreeNode parent(TreeNode subTree,TreeNode element){  
	        if(subTree==null)  
	            return null;  
	        if(subTree.leftChild==element||subTree.rightChild==element)  
	            return subTree;  
	        TreeNode p; 
	        if((p=parent(subTree.leftChild, element))!=null)  
	            
	            return p;  
	        else  
	           
	            return parent(subTree.rightChild, element);  
	    }  
	      
	    public TreeNode getLeftChildNode(TreeNode element){  
	        return (element!=null)?element.leftChild:null;  
	    }  
	      
	    public TreeNode getRightChildNode(TreeNode element){  
	        return (element!=null)?element.rightChild:null;  
	    }  
	      
	    public TreeNode getRoot(){  
	        return root;  
	    }  
	    public void destroy(TreeNode subTree){  
	        
	        if(subTree!=null){  
	            destroy(subTree.leftChild);  
	            destroy(subTree.rightChild);  
	            subTree=null;  
	        }  
	    }  
	    
	    private void visited(TreeNode Node){
	    	System.out.println("key:"+Node.key+"----"+Node.data);
	    }
	    
	    public void preOrder(TreeNode subTree ){
	    	if (subTree!=null){
	    		visited(subTree);
		    	preOrder(subTree.leftChild);
		    	preOrder(subTree.rightChild);
	    	}
	    }
	    public void inOrder(TreeNode subTree){
	    	if (subTree!=null){
	    		inOrder(subTree.leftChild);
	    		visited(subTree);
	    		inOrder(subTree.rightChild);
	    	}
	    }
	    public void postOrder(TreeNode subTree){
	    	if (subTree!=null){
	    		postOrder(subTree.leftChild);
	    		postOrder(subTree.rightChild);
	    		visited(subTree);
	    	}
	    }
	    public static void main(String[] args){
	    	Tree bt = new Tree();
	    	bt.createBinTree(bt.root);
	    	System.out.println("the size of the tree is " + bt.size());  
	        System.out.println("the height of the tree is " + bt.height());  
	        System.out.println("the size of the tree is " + bt.size());  
	        System.out.println("the preOrder of the tree is " );
	        bt.preOrder(bt.root);
	        System.out.println("the inOrder of the tree is " );
	        bt.inOrder(bt.root);
	        System.out.println("the postOrder of the tree is " );
	        bt.postOrder(bt.root);
	    }
}
