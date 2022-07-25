/** Represents an Queue.
 * @author Hikmet Mete Varol
 * @version 1.0
 * @since 1.0
*/
interface Queue<E> extends Collection<E>
    {
     /**
     * Retrieves the head of this Queue.
     * @return the first element of Queue.
     */
		E element(); 
	 /**
     * Inserts the specified element into this Queue.
     * @param e specified element to be inserted.
     */ 
		void offer(E e);
	/**
     * Retrieves and removes the head of this Queue, or throws if this queue is empty.
     */
		E poll(); 

    }