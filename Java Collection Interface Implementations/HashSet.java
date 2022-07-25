 /** Represents an HashSet.
 * @author Hikmet Mete Varol
 * @version 1.0
 * @since 1.0
*/
	@SuppressWarnings("unchecked")
	public class HashSet<E> implements Set<E>{

		/** standart Java array for implement methods.
		*/	
		private  E hashList[];
		/** size of HashList.
		*/
   		private int size;
   		/** current index of hashList[].
		*/
    	private int index;


    	/** constructor for HashList.
		*/
    	public HashSet(){

			this.hashList = (E[])new Object[1];
			this.size = 0;
			this.index = -1;
	  	}

	  	/**
     	* Ensures that this collection contains the specified element but don't allowed duplicate.
     	* @param e specified element to be added.
     	*/ 
		public void add(E e)
			{
			boolean check = false;

			for(int i=0;i<this.size;i++){

			if(hashList[i].equals(e))
				check = true;
			}


			if(check==false){
			this.index++;
			this.size++;

			E newhashList[] = (E[])new Object[this.size+1];

			for(int i=0; i < this.size;i++){

				newhashList[i] = hashList[i];
				}

			this.hashList = newhashList;

			hashList[this.index] = e;
		
			}
			check = false;
		}
		/**
     	* Ensures that this collection contains the specified element.
     	* @param i the index to be reached.
     	* @return element in the corresponding index.
     	*/ 
		public E get(int i){
		
			return this.hashList[i];
		}
		/**
     	* Returns the number of elements in this collection.
     	* @return size of HashList.
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
     	* Adds all of the elements in the specified collection to this collection but don't allowed duplicate.
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
				hashList[i] = null;

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

				if(hashList[i].equals(e))
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

					if(hashList[j]==(E)c.get(i)){
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
				if(hashList[i].equals(e)){

					hashList[i] = null;
					for(int j=i;j<this.size-1;j++){

						hashList[j]=hashList[j+1];
					
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

					if(hashList[j]==(E)c.get(i)){
					
						remove(hashList[j]);

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
