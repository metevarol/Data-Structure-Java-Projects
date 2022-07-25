import java.util.*;

/** Represents an MapIterator.
* @author Hikmet Mete Varol
* @version 1.0
* @since 1.0
*/
@SuppressWarnings("unchecked")
public class MapIterator<K,V> extends HashMap<K,V> {

		/** Current index of MapIterator.
		*/
		private int index;
		/** Aray of K that store key object.
		*/
		private K[] keyArr;
		/** K object for one parameter constructor operation.
		*/
		private K keylog;
		/** Boolean variable for one parameter constructor operation.
		*/
		private boolean keycheck;
		/** Boolean variable for next method operation.
		*/
		private boolean nextcheck;
		/** Boolean variable for prev method operation.
		*/
		private boolean prevcheck;

		/** No parameter constructor of MapIterator.
		*/
		public MapIterator(){

			index = 0;

			keylog = null;

			keycheck = false;

			nextcheck = false;

			prevcheck = false;
		}
		/** One parameter constructor of MapIterator.
		* @param key Given key object which iterator will start at its position.
		*/
		public MapIterator(K key){

			index = 0;

			keylog = key;

			keycheck = false;

			nextcheck = false;

			prevcheck = false;	
		}
		/** Returns the next element in the iteration and advances the iterator.
		* @return Next element.
		*/
		public K next(){

			keyArr = (K[]) new Object[super.size()];

			int count = 0;

			for (Map.Entry<K, V> set : super.entrySet()) {

			    keyArr[count] = set.getKey();

			    if(keylog!=null&&keyArr[count] == keylog && keycheck == false){
			    	keycheck = true;
			    	index = count;
			    }

			    count++;

			}

			if(prevcheck == true){

				prevcheck = false;
				index++;
			}


			if(index == super.size()){

				index = 0;
			}
	
			nextcheck = true;

			return keyArr[index++];	
		}
		/** Returns the previous element in the iteration and retreat the iterator.
		* @return Previous element.
		*/
		public K prev(){

			keyArr = (K[]) new Object[super.size()];

			int count = 0;

			for (Map.Entry<K, V> set : super.entrySet()) {

			    keyArr[count] = set.getKey();

			    if(keylog!=null&&keyArr[count] == keylog && keycheck == false){
			    	keycheck = true;
			    	index = count;
			    }

			    count++;

			}
			//System.out.println(index);

			if(nextcheck == true){

			nextcheck = false;
				
			index--;
			}

			if(index == super.size()){

				index = 0;
			}

			if(index == 0){

				index = super.size();
			}

			prevcheck = true;

			return keyArr[--index];
		}
		/** Returns true if there are still not-iterated key/s in the Map.
		* @return True or false.
		*/
		public boolean hasNext(){

			keyArr = (K[]) new Object[super.size()];

			int count = 0;

			for (Map.Entry<K, V> set : super.entrySet()) {

			    keyArr[count] = set.getKey();

			    if(keylog!=null&&keyArr[count] == keylog && keycheck == false){
			    	keycheck = true;
			    	index = count;
			    }

			    count++;

			}

			if(prevcheck == true){

				index++;

				if(index==super.size())
					return false;
				else
					return true;
			}
			else{
				if(index==super.size())
					return false;
				else
					return true;
			}
		}


	}