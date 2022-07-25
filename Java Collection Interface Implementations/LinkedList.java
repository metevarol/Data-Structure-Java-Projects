/** Represents an LinkedList.
 * @author Hikmet Mete Varol
 * @version 1.0
 * @since 1.0
*/
	@SuppressWarnings("unchecked")
	public class LinkedList<E> implements List<E>,Queue<E>{

		/** standart Java array for implement methods.
		*/
		private  E linkList[];
		/** size of LinkedList.
		*/
   		private int size;
   		/** current index of linkList[].
		*/
    	private int index = -1 ;
    	/** constructor for LinkedList.
		*/
    	public LinkedList(){

			this.linkList = (E[])new Object[1];
			this.size = 0;
	  	}
	  	/**
     	* Ensures that this collection contains the specified element.
     	* @param e specified element to be added.
     	*/ 
		public void add(E e){
			this.index++;
			this.size++;

			E newlinkList[] = (E[])new Object[this.size+1];

				for(int i=0; i < this.size;i++){

				newlinkList[i] = linkList[i];
				}

			this.linkList = newlinkList;

			linkList[this.index] = e;
		}
		/**
     	* Ensures that this collection contains the specified element.
     	* @param i the index to be reached.
     	* @return element in the corresponding index.
     	*/ 
		public E get(int i){
		
			return this.linkList[i];	
		}
		/**
     	* Returns the number of elements in this collection.
     	* @return size of LinkedList.
     	*/ 
		public int size(){
		
			return this.size;
		}
		/**
     	* Returns an iterator over the collection.
     	* @return iterator.
     	*/ 
		public Iterator iterator(){

			return new Iterator(this);
		}
		/**
     	* Adds all of the elements in the specified collection to this collection.
     	* @param c specified collection to be added.
     	*/ 
		public void addAll(Collection c){
		
			for(int i=0;i<c.size();i++)

			this.add((E)c.get(i));
		}
		/** throws an exception for LinkedList.
     	*/	
		public void clear(){

			throw new RuntimeException("not able with LinkedList"); 
		}
		/**
     	* Returns true if this collection contains the specified element.
     	* @param e specified element to be controlled.
     	* @return true or false.
     	*/ 
		public boolean contains(E e){
			for(int i=0;i<this.size;i++){

			if(linkList[i].equals(e))
				return true;
		
			}

			return false;
		}
		/**
     	* Returns true if this collection contains all of the elements in the specified collection.
     	* @param c specified collection to be controlled.
     	* @return true or false.
     	*/ 	
		public boolean containsAll(Collection c){

			int count=0;

			for(int i=0;i<c.size();i++){

				for(int j=0;j<this.size;j++){

					if(linkList[j]==(E)c.get(i)){
						count++;
						break;
					}
				}

			}
			if(count==c.size())
				return true;
			else 
				return false;
		}
		/**
     	* Returns true if this collection contains no elements.
     	* @return true or false.
     	*/
		public boolean isEmpty(){

			if(this.size==0)
				return true;
			else
				return false;
		}
		/** throws an exception for LinkedList.
     	*/
		public void remove(E e){

			throw new RuntimeException("not able with LinkedList"); 
		}
		/** throws an exception for LinkedList.
     	*/
		public void removeAll(Collection c){

		
			throw new RuntimeException("not able with LinkedList"); 
		}
		/** throws an exception for LinkedList.
     	*/
		public void retainAll(Collection c){

			throw new RuntimeException("not able with LinkedList"); 
		} 
		/**
     	* Retrieves, but does not remove, the head of this queue.
     	* @return element in the first index.
     	*/
		public E element(){

			return this.linkList[0];
		}
		/**
     	* Inserts the specified element into this queue.
     	* @param e specified element to be added.
     	*/ 
		public void offer(E e){

			add(e);
		}
		/** Retrieves and removes the head of this queue, or throws if this queue is empty
		* @return first element of LinkedList.
		*/
		public E poll(){

			if(isEmpty()){
			throw new RuntimeException("not able with LinkedList"); 
			}
			E temp;
			temp = linkList[0];
			linkList[0] = null;
			for(int j=0;j<this.size-1;j++){

				linkList[j]=linkList[j+1];
					
				}

				this.size--;
				this.index--;

				return temp;
		}


	}