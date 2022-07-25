/** Represents a MaxHeap.
 * @author Hikmet Mete Varol
 * @version 1.0
 * @since 1.0
*/

@SuppressWarnings("unchecked")
public class MaxHeap<T extends Comparable<T>> {

	/** Standart Java array for implement MaxHeap.
	*/
	private T[] heap;
	/** Current size of MaxHeap.
	*/
	private int size;
	/** Maximum size of MaxHeap.
	*/
	private int maxsize;

	/** Constructor for ArrayList. It initialize an empty max heap with given maximum capacity.
	* @param maxsize  maxsize for initialize MaxHeap.
	*/	
	public MaxHeap(int maxsize)	{

		this.maxsize = maxsize;
		this.size = 0;
		heap = (T[]) new Comparable[this.maxsize+1];
		//heap[0] = Integer.MAX_VALUE;
	}
	/** parentIndex method. 
	* @param index position of parent.
	* @return position of parent.
	*/
	private int parentIndex(int index) { 

		return index / 2; 
	}
	/** leftIndex method. 
	* @param index position of left child.
	* @return position of left child.
	*/
	private int leftIndex(int index) { 

		return (2 * index); 

	}
	/** rightIndex method. 
	* @param index position of right child.
	* @return position of right child.
	*/
	private int rightIndex(int index){

		return (2 * index) + 1;
	}

	/** swapElements method. Standart swap operation with using temporary variable. 
	* @param first_index first variable.
	* @param second_index second variable.
	*/
	private void swapElements(int first_index, int second_index){
		T temp;
	
		temp = heap[first_index];
		heap[first_index] = heap[second_index];
		heap[second_index] = temp;
	}

	/** A recursive method to make MaxHeap to regular. 
	* @param index position where to operation start.
	*/
	private void makeHeap(int index){
		if (index > (size / 2) && index <= size)
			return;

		if ((heap[index].compareTo(heap[leftIndex(index)]) < 0) || (heap[index].compareTo(heap[rightIndex(index)]) < 0)) {


			if (heap[leftIndex(index)].compareTo(heap[rightIndex(index)]) > 0) {

				swapElements(index, leftIndex(index));
				makeHeap(leftIndex(index));

			}
			else{

				swapElements(index, rightIndex(index));
				makeHeap(rightIndex(index));

			}
		}
	}

	/** Inserts a new element to MaxHeap 
	* @param element an element inserted to MaxHeap.
	*/
	public void insert(T element){	
		size++;

		heap[size] = element;

		// Traverse up and fix violated property
		int current = size;

		//System.out.println("parentIndex = "+parentIndex(current));
		//System.out.println("current = "+current);
		//System.out.println("element = "+element);

		if(current!=1){

		while (heap[current].compareTo(heap[parentIndex(current)]) > 0) {

			//System.out.println("check ");

			swapElements(current, parentIndex(current));
			current = parentIndex(current);

			if(parentIndex(current)==0)
				break;
			}
		}
	}

	/** Print method for MaxHeap.
	*/
	public void print(){

		if(size==1){
			System.out.println(" Parent 1 : " + heap[1]);
		}
		for (int i = 1; i <= size / 2; i++) {
			System.out.print(" Parent "+i+" : " + heap[i]);
			if((2*i)<size+1)
			System.out.print(" Left Child : " + heap[2 * i]);
			if((2*i+1)<size+1)
			System.out.print(" Right Child : " + heap[2 * i + 1]);
			System.out.println();

		}
	}

	/** Standart Remove method for MaxHeap. It removed top element of MaxHeap.
	* @return removed item.
	*/
	public T remove(){

		T temp = heap[1];

		heap[1] = heap[size];
		size--;

		makeHeap(1);

		heap[size+1] = null;

		return temp;
	}
	/** Recursive method for search element.
	* @param element searched element.
	* @param pos position variable for recursive call.
	* @return position of searched element.
	*/
	public int findElement(T element,int pos){

		if (heap[pos]==null)
		return -1;	
		if(element.compareTo(heap[pos]) > 0){
		return -1;
		}
		else if(element.compareTo(heap[pos]) == 0){
		return pos;
		}
		else{

				int index = findElement(element,2*pos);

				if(index==-1){

				index = findElement(element,2*pos+1);

					}

				return index;
			}
	}
	/** mergeHeaps method. It merges two MaxHeap object.
	* @param maxheap object of MaxHeap class.
	*/
	public void mergeHeaps(MaxHeap<T> maxheap){

		for(int i=1;i<=maxheap.size;i++){
			this.insert((T)maxheap.heap[i]);
		}

	}
	/** removeTh method. It removes ith largest elemennt from MaxHeap.
	* @param i level of largest element.
	* @return removed item.
	*/
	public T removeTh(int i){

		T[] temparr = (T[])new Comparable[size+1];
		
		int index;
		T tmp; 
		T temp;

		if(i>size){

			throw new RuntimeException("i can not be bigger than size");
		}


		for(int j=1;j<=size;j++){
		temparr[j] = heap[j];
		//System.out.println(temparr[j]);	
		}
		
		for (int k = 1; k <= size; k++) {  
			for (int j = k + 1; j <= size; j++) {  
				 
					if (temparr[k].compareTo(temparr[j]) > 0){  

						tmp = temparr[k];  
						temparr[k] = temparr[j];  
						temparr[j] = tmp;  
					}  
				}
			}
		index = this.findElement(temparr[size+1-i],1);
		
		if(index==size){

		temp = heap[index];
		heap[index] = null;
		size--;

		}else{

		temp = heap[index];

		heap[index] = heap[size];
		size--;

		makeHeap(index);

		heap[size+1] = null;

		}

		return temp;
	
	}
	/** removeItem method for BSTHeapTree operations.
	*/
	public T removeItem(T item){

		int index;
		T temp;

		index = this.findElement(item,1);


		if(index==size){

		temp = heap[index];
		heap[index] = null;
		size--;

		}else{

		temp = heap[index];

		heap[index] = heap[size];
		size--;

		makeHeap(index);

		heap[size+1] = null;	

		}

		

		return temp;

	}
	/**
     * Returns an iterator over the MaxHeap.
     * @return iterator.
     */ 
	public Iterator iterator(){

		return new Iterator(this);
	}

	/** get method for BSTHeapTree operations.
	*/
	public T get(int index){

		return heap[index];
	}
	/** getSize method for BSTHeapTree operations.
	*/
	public int getSize(){

		return size;
	}
	/** setSize method for BSTHeapTree operations.
	*/
	public void setSize(int size){

		this.size = size;
	}
	/** set method for BSTHeapTree operations.
	*/
	public void set(T element,int index){

		heap[index] = element;

		makeHeap(index);

	}

	
}

