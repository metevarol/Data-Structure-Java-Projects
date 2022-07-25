	/** Represents an Iterator.
 * @author Hikmet Mete Varol
 * @version 1.0
 * @since 1.0
*/
	@SuppressWarnings("unchecked")
	public class Iterator{

		/** current index of Iterator.
		*/
		private int index;
		/** a collection object for operation.
		*/
		public Collection iter;
		/** constructor of Iterator.
		*/
		public Iterator(){
			index = 0;
		}
		/** constructor of Iterator.
		* @param obj object of any class.
		*/
		public Iterator(Collection obj){
			iter = obj;
		}
		/** Returns the next element in the iteration and advances the iterator.
		* @return next element.
		*/
		public Object next(){
			return iter.get(index++);
			
		}
		/** Returns true if the iteration has more elements.
		* @return true or false.
		*/
		public boolean hashNext(){

			return index < iter.size();
		}
		/** Removes from the underlying collection the last element returned by this iterator.
		*/
		public void remove(){
			iter.remove(iter.get(index));
		}


	}