/** Represents a BSTHeapTree.
 * @author Hikmet Mete Varol
 * @version 1.0
 * @since 1.0
*/

import java.util.*;

@SuppressWarnings("unchecked")
public class BSTHeapTree<E extends Comparable<E>> {

	/** Node class for making Binar Search Tree.
	*/
	public class Node{ 

        MaxHeap<E> data; 
        Node left, right; 
     
   
        public Node(MaxHeap<E> data){ 

            this.data = data; 
            left = right = null; 
            	
        } 
    }

    /** Root of BST.
	*/
    private Node root;

    /** Java map object for hold occurences.
	*/
    private Map<E,Integer> occmap;

    /** Default Constructor of BSTHeapTree.
	*/
    public BSTHeapTree(){

    	occmap = new HashMap<>();
    }

   /** Public insert method.
	* @param data object of MaxHeap class.
	*/
    public void insert(MaxHeap<E> data){

		root = insert(root, data);
	}
	/** Private insert method.
	* @param root object of Node class for insertion method.
	* @param data object of MaxHeap class.
	* @return root of BST.
	*/
	private Node insert(Node root, MaxHeap<E> data) {
		// instantiate a new Node with data as data if the current root has not been previously instantiated
		if(root ==null){

		return new Node(data);

		}

		else if(data.get(1).compareTo(root.data.get(1)) < 0){

			root.left = insert(root.left, data);

		}
		
		else if(data.get(1).compareTo(root.data.get(1)) > 0){

			root.right = insert(root.right, data);

		}else
		{;}
				
		return root;
	}
	/** Public delete method.
	* @param data object of MaxHeap class.
	*/
	public void delete(MaxHeap<E> data){

		root = delete(root, data);
	}
	/** Private delete method.
	* @param root object of Node class for insertion method.
	* @param data object of MaxHeap class.
	* @return root of BST.
	*/
	private Node delete(Node root, MaxHeap<E> data){
		// if the root node is null, then either there's nothing to delete or no more traversal is necessary
		if(root==null){

		return null;

		}
		else if(data.get(1).compareTo(root.data.get(1)) < 0 ){

			root.left = delete(root.left, data);

		}
		
		else if(data.get(1).compareTo(root.data.get(1)) > 0){

			root.right = delete(root.right, data);

		}
		else{
				if (root.left == null && root.right == null){
					return null;
				}
				else if (root.right == null){
					return root.left;
				}
				else if (root.left == null){
					return root.right;
				}
				else{
					root.data = findMax(root.left);
					root.left = delete(root.left, root.data);
				}
		}

		return root;
	}
	/** findMax method. It finds maximum element of bst by going right all the time. 
	* @param root object of Node class.
	* @return object of MaxHeap class.
	*/
	private MaxHeap<E> findMax(Node root){

		while(root.right!=null)
			root = root.right;
				
		return root.data;
	}

	/** Public Inorder traversal method for BSTHeapTree.
	*/
	public void inorder(){

		System.out.print("In-order Traversal:");
				inorder(root);
		System.out.println();
	}
	/** Private Inorder traversal method for BSTHeapTree.
	* @param root object of Node class.
	*/
	private void inorder(Node root){
		if (root == null)
		return;
				inorder(root.left);
			root.data.print();
			System.out.println(root.data.getSize());
			System.out.println();
			System.out.println();
				inorder(root.right);
	}

	/** Add method that adds item to BSTHeapTree.
	* @param item generic object will added.
	* @return number of occurrences.
	*/
	public int add(E item){

		Node iter = root;

		while(true){

			if(iter==null){

				MaxHeap<E> maxheap = new MaxHeap<E>(5000);
				maxheap.insert(item);
				this.insert(maxheap);
				occmap.put(item,1);

				return occmap.get(item);
			}

			if(iter.data.getSize()<7 || iter.data.findElement(item,1)!=-1){

					if(iter.data.findElement(item,1)!=-1){
						int count = occmap.get(item);
						occmap.replace(item,count + 1);
						return occmap.get(item);
					}
					else{
						occmap.put(item,1);
						iter.data.insert(item);
						return occmap.get(item);
					}
			}
			else{
					if(iter.data.get(1).compareTo(item) < 0){

						iter = iter.right;
					}
					else{

						iter = iter.left;

					}	

				}
			}
	}
	/** Remove method that removes item from BSTHeapTree.
	* @param item generic object will removed.
	* @return number of occurrences.
	*/
	public int remove(E item){

		Node iter = root;

		if(iter==null){

			return -1;
		}

		while(true){

			if(iter == null){
				
				throw new RuntimeException("This item is not in this BSTHeapTree");
			}

			if(iter.data.findElement(item,1)!=-1){

				if(occmap.get(item)>1){

					int count = occmap.get(item);

					occmap.replace(item,count-1);

					return occmap.get(item);
				}else{
					
					iter.data.removeItem(item);

					if(iter.data.getSize()==0){

						root = null;
						this.delete(iter.data);
						return 0;
					}

					occmap.remove(item);

					return 0;		
					
				}

			}else{

				
				if(iter.data.get(1).compareTo(item)<0){

					iter = iter.right;
				}
				else{

					iter = iter.left;
					}

			}


		}
	}
	/** Find method that find specified item's occurrence.
	* @param item generic object will removed.
	* @return number of occurrences specified item.
	*/
	public int find(E item){

		int temp;

		temp = occmap.get(item);

		return temp;

	}
	/** find_mode method that prints all modes of BSTHeapTree.
	*/
	public void find_mode(){

		int max = 0;

		E temp = null;


		for(Map.Entry<E, Integer> entry : occmap.entrySet()){

			if(entry.getValue()>max){
				max = entry.getValue();
			}
		}

		for(Map.Entry<E, Integer> entry : occmap.entrySet()){

			if(entry.getValue()==max){
				System.out.print(entry.getKey()+" ");
			}
		}

	}

}