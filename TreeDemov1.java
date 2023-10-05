class Node{
	   int value;
	   Node left, right;
	   
	   public Node(int value){
	      this.value = value;
	      left = null;
	      right = null;
	   }

	}

	class BinarySearchTree{

	   Node root;
	  
	   
	   /*
	   recursive insert method
		
	   */
	   /*
	   inserts a node into the tree
	   */
	   public void insert(int value){
	      //tree is empty
	      if(root == null){
	         root = new Node(value);
	         return;
	      }else{
	         Node current = root;
	         Node parent = null;
	         
	         while(true){
	            parent = current;
	            
	            if(value < current.value){
	               current = current.left;
	               if(current == null){
	                  parent.left = new Node(value);
	                  return;
	               }
	            }else{
	               current = current.right;
	               if(current == null){
	                  parent.right = new Node(value);
	                  return;
	               }
	            }
	           
	         }//closing while
	      
	      }//closing main if-else 
	   }
	   
	   /**
	   *pre-order traversal
	   *Prints the value of every node preorder
	   *@param root the current node in the BST
	   */
	   public void preOrderTraversal(Node root){
		//implement in here
		if(root == null){
			return;
		 }
		 System.out.println(root.value);
		 preOrderTraversal(root.left);
		 preOrderTraversal(root.right); 
	   }

	   
	   
	   /**
	   *in-order traversal
	   *Prints out the BST using the inOrder Traversal method
	   *@param root The current root in the BST
	   */
	   public void inOrderTraversal(Node root){
		if(root == null){
			return;
		 }
		 inOrderTraversal(root.left);
		 System.out.print(root.value + ", ");
		 inOrderTraversal(root.right);
	   }
	   
	   
	   
	   /**
	   *post-order traversal
	   *Prints out the BST using postOrder traversal method
	   * @param root The current node in the BST
	   */
	  
	   public void postOrderTraversal(Node root){
         //implement in here
		 if(root == null){
			return;
		 }
		 postOrderTraversal(root.left);
		 postOrderTraversal(root.right);
		 System.out.print(root.value + ", ");
	   }
	   
	   
	   
	   /**
	   *a method to find the node in the tree using a key
	   *@param root the current in the BST
	   *@param key the value that is being searched for
	   *@return true or false depending on if the key is in the BST
	   */
	   public boolean find(Node root, int key){
		 //implement in here
		 boolean check = false;
		 if(root == null){
			return false;
		 }
		 if(root.value == key){
			check = true;
			return check;
		 }
		 if(check == false && root.left != null){
			return find(root.left, key);
		 }
		 if(check == false && root.right != null){
			return find(root.right, key);
		 }
		 return check;
	   }
	   
	   
	   
	   /**
		* A method that returns the minimum value in the BST
		* @param root The current node in the BST
		* @return the minimum value in the BST
	   */
	   public int getMin(Node root){
         //implement in here
		 int min;
		 if(root.left == null){
			min = root.value;
			return min;
		 }
		 return getMin(root.left);
	   }
	  
	  
	  
	   /**
		* A method that returns the maximum value in the BST
		* @param root The current node in the BST
		* @return The maximum value in the BST
	   */
	   public int getMax(Node root){
         //implement in here
		 int max;
      	 if(root.right == null){
         	max = root.value;
         	return max;
      	 }
      	 return getMax(root.right);
	   }
	   
	   
	   
	   /*
	   this method will not compile until getMax
	   is implemented
	   */
	   public Node delete(Node root, int key){
	      
	      if(root == null){
	         return root;
	      }else if(key < root.value){
	         root.left = delete(root.left, key);
	      }else if(key > root.value){
	         root.right = delete(root.right, key);
	      }else{
	         //node has been found
	         if(root.left==null && root.right==null){
	            //case #1: leaf node
	            root = null;
	         }else if(root.right == null){
	            //case #2 : only left child
	            root = root.left;
	         }else if(root.left == null){
	            //case #2 : only right child
	            root = root.right;
	         }else{
	            //case #3 : 2 children
	            root.value = getMax(root.left);
	            root.left = delete(root.left, root.value);
	         }
	      }
	      return root;  
	   }
	   
	   
	   
	}



	public class TreeDemo{
	   public static void main(String[] args){
	      BinarySearchTree t1  = new BinarySearchTree();
	      t1.insert( 24);
	      t1.insert(80);
	      t1.insert(18);
	      t1.insert(9);
	      t1.insert(90);
	      t1.insert(22);
	            
	      System.out.print("in-order :   ");
	      t1.inOrderTraversal(t1.root);
	      System.out.println();
	           
	      
	   }  
	}
