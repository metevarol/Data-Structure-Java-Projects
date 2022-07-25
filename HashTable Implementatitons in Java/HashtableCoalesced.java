import java.util.*;


/** Hash table implementation using open addressing. */
@SuppressWarnings("unchecked")
public class HashtableCoalesced<K, V> implements KWHashMap<K, V> {
		

		/*Inner class Entry<K, V> implementation.
		*/
		private static class Entry<K, V> {
		    /** The key */
		    private final K key;
		    /** The value */
		    private V value;

		    private int next;
			/** Creates a new key‐value pair. @param key The key
			@param value The value
			*/
			public Entry(K key, V value) { 

			this.key = key;
			this.value = value; 
			this.next = -1;

			}
			/** Retrieves the key. @return The key
			*/
		    public K getKey() {
		        return key;
			}	
			/** Retrieves the value. 
			* @return The value
			*/
		    public V getValue() {
		        return value;
			}
			/** Sets the value.
			@param val The new value @return The old value
			*/
			public V setValue(V val) { 
				
				V oldVal = value; 
				value = val;

				return oldVal;
			} 

			public int getNext(){

				return next;
			}

			public void setNext(int n){

				next = n;
			}
		}

		/** The table */
		private Entry<K, V>[] table;
		/** The maximum load factor */
		private double LOAD_THRESHOLD = 0.75; 
		/** The number of keys */
		private int numKeys;
		/** The number of deletes */
		private int numDeletes;
		/** Delete object */
		private final Entry<K, V> DELETED = new Entry<>(null, null);
		
		/** Constructor of HashtableCoalesced
		* @param capacity capacity of table.
		*/
		public HashtableCoalesced(int capacity) {

			table = new Entry[capacity]; 

		}
	
		/** Method get for class HashtableCoalesced.
		@param key The key being sought
		@return the value associated with this key if found otherwise, null
		*/
		@Override
		public V get(Object key) {

			int index = key.hashCode() % table.length;

			if (table[index] == null)
				return null;

			if(table[index].getNext() == -1){

				return table[index].getValue(); 
			}
				
			else{
				while(!table[index].getKey().equals(key)){
					
					index = table[index].getNext();
					if(index==-1)
						return null;
				}
				//System.out.println(index);
				return table[index].getValue();
			}
		}

		/** Method put for class HashtableCoalesced.
		* @param key The key of item being inserted
		* @param value The value for this key
		* @return Old value associated with this key if found; otherwise, null
		*/
		@Override
		public V put(K key, V value)  {
		
			int index;
			int firstindex;
			int oldIndex = -1;

			int k = -1;

			index = key.hashCode() % table.length; 
			firstindex = index;
			if (index < 0)
			index += table.length; 
			
		
			while ((table[index] != null) && (!key.equals(table[index].getKey()))) {
				
				if(table[index].getNext() == -1 && table[index].getKey().hashCode() % table.length == firstindex)
				oldIndex = index;

				k += 2;

				index = (index + k) % table.length;
				
				// Check for wraparound. 
				if (index >= table.length)
				index = 0; // Wrap around. 

			}

			if(oldIndex != -1){
			table[oldIndex].setNext(index);
		
			}
			
			
			

			if (table[index] == null) {
			        
				table[index] = new Entry<>(key, value);

				numKeys++;

		
				double loadFactor = (double) (numKeys + numDeletes) / table.length;

			    if (loadFactor > LOAD_THRESHOLD)
			        rehash();
	        
			   return null;
			}

			
				V oldVal = table[index].getValue(); 

				table[index].setValue(value);

			    return oldVal;
		}


		/** Expands table size
		*/
		private void rehash() {


			Entry<K, V>[] oldTable = table;

			table = new Entry[2 * oldTable.length + 1];

			numKeys = 0;

			numDeletes = 0;

			for (int i = 0; i < oldTable.length; i++) {

				if ((oldTable[i] != null) && (oldTable[i] != DELETED)) { 

					put(oldTable[i].getKey(),oldTable[i].getValue());

				}
			} 
		}

		/** Remove method for Coalesced table.
		* @param key The key of item removed
		*/
		public V remove(Object key) {

			
			int index = key.hashCode() % table.length;
			int firstindex = index;
			int indextemp;
			int tempnext;

			if(table[index].getNext() == -1){

				V oldval = table[index].getValue();

				table[index] = DELETED;

				numDeletes++;

				return oldval;
			}

				while(!table[index].getKey().equals(key)){

					index = table[index].getNext();

				}

				V oldval2 = table[index].getValue();

				indextemp = index;

				tempnext = table[index].getNext();


				while(table[indextemp].getNext()!=-1){

					indextemp = table[indextemp].getNext();
				}

				
				table[index] = table[indextemp];

				table[indextemp] = DELETED;

				table[index].setNext(tempnext);
				
				
				while(table[ table[firstindex].getNext() ] != DELETED){

					 firstindex = table[firstindex].getNext();

				}

				table[firstindex].setNext(-1);


				numDeletes++;
				return oldval2;
		}

		/** Prints Hashtable for check.
		*/
		public void printTable(){
			
			System.out.println();
			System.out.println("Hash V.\tKey\tNext");
			
			for(int i = 0;i<table.length;i++){

				if(table[i]!=null && table[i]!=DELETED){


				System.out.println(i+"\t"+table[i].getKey()+"\t"+table[i].getNext());
					
				}else
				System.out.println(i+"\t"+" "+"\t"+"-1");
				
			}
			System.out.println();
		}	



	}