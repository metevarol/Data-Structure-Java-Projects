 /** Represents an ArrayList.
 * @author Hikmet Mete Varol
 * @version 1.0
 * @since 1.0
*/
 	@SuppressWarnings("unchecked")
	public class ArrayList<E> implements List<E>
		{
		/** standart Java array for implement methods.
		*/	
		private  E arrList[];
		/** size of ArrayList.
		*/
   		private int size;
   		/** current index of arrList[].
		*/
    	private int index = -1 ;

    	/** constructor for ArrayList.
		*/	
    	public ArrayList(){

			this.arrList = (E[])new Object[1];
			this.size = 0;
	  	}

	  	/**
     	* Ensures that this collection contains the specified element.
     	* @param e specified element to be added.
     	*/ 
		public void add(E e)
			{
			this.index++;
			this.size++;

			E newarrList[] = (E[])new Object[this.size+1];

			for(int i=0; i < this.size;i++){

			newarrList[i] = arrList[i];
			}

			this.arrList = newarrList;

			arrList[this.index] = e;
		}
		/**
     	* Ensures that this collection contains the specified element.
     	* @param i the index to be reached.
     	* @return element in the corresponding index.
     	*/ 
		public E get(int i){
		
			return this.arrList[i];
		
		}
		/**
     	* Returns the number of elements in this collection.
     	* @return size of ArrayList.
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
		/** Removes all of the elements from this collection.
		*/	
		public void clear(){

			for(int i=0;i<this.size;i++)
			arrList[i] = null;

			this.size = 0;
			this.index =-1;
		}
		/**
     	* Returns true if this collection contains the specified element.
     	* @param e specified element to be controlled.
     	* @return true or false.
     	*/ 
		public boolean contains(E e){
			for(int i=0;i<this.size;i++){
				if(arrList[i].equals(e))
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

					if(arrList[j]==(E)c.get(i)){
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
		/**
     	* Removes a single instance of the specified element from this collection, if it is present.
     	* @param e specified element to be removed.
     	*/ 
		public void remove(E e){

			for(int i=0;i<this.size;i++){
				if(arrList[i].equals(e)){

					arrList[i] = null;
					for(int j=i;j<this.size-1;j++){

						arrList[j]=arrList[j+1];
					
					}
					this.size--;
					this.index--;
				}

			}	
		}
		/**
     	* Removes all of this collection's elements that are also contained in the specified collection.
     	* @param c specified collection to be removed.
     	*/ 
		public void removeAll(Collection c){

			for(int i=0;i<c.size();i++){

				for(int j=0;j<this.size;j++){

					if(arrList[j]==(E)c.get(i)){
					
						remove(arrList[j]);

					}
				}

			}
		}
		/**
     	* Retains only the elements in this collection that are contained in the specified collection.
     	* @param c specified collection to be retained.
     	*/ 
		public void retainAll(Collection c){

			clear();
			addAll(c);
	} 
}