/** Represents an Iterator.
 * @author Hikmet Mete Varol
 * @version 1.0
 * @since 1.0
*/
	@SuppressWarnings("unchecked")
	public class Iterator<T extends Comparable<T>>{

		/** current index of Iterator.
		*/
		private int index;
		/** a MaxHeap object for operation.
		*/
		public MaxHeap<T> iter;
		/** constructor of Iterator.
		*/
		public Iterator(){
			index = 1;
		}
		/** constructor of Iterator.
		* @param obj object of MaxHeap class.
		*/
		public Iterator(MaxHeap<T>  obj){
			index = 1;
			iter = obj;
		}
		/** Returns the next element in the iteration and advances the iterator.
		* @return next element.
		*/
		public Object next(){

			return iter.get(index++);
			
		}
		/** Sets the next element to given parameter.
		* @param element generic object to set.
		*/
		public void setLast(T element){

			iter.set(element,index);
		}
		

	}