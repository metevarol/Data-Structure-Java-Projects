
import java.util.*;

/** Represents an NavigableSkipList.
* @author Hikmet Mete Varol
* @version 1.0
* @since 1.0
*/
public class NavigableAVLTree<E extends Comparable<E>> implements NavigableSet<E> {


    /** AVLTree for using as data.
    */
    private AVLTree<E> data;
    /** SortedSet for using for headSet method.
    */
    private SortedSet<E> headset;
    /** SortedSet for using for tailSet method.
    */
    private SortedSet<E> tailset;
    

    /** Constructor for NavigableSkipList.
    */ 
    public NavigableAVLTree() {

        data = new AVLTree<E>();
        headset = new TreeSet<E>();
        tailset = new TreeSet<E>();
    }

     /** insert method for NavigableSkipList.
     * @param e value.
    */ 
    public void insert(E e) {

        data.add(e);
    }

     /** headSet method for NavigableSkipList.
     * @param toElement set go forward until this element.
     * @return sortedset.
    */ 
    public SortedSet<E> headSet(E toElement) {

        for(int i=0;i<data.list.size();i++){

            if(toElement.compareTo(data.list.get(i))>0){

                headset.add(data.list.get(i));
            }
        }

        return headset;
    }

     /** tailSet method for NavigableSkipList.
     * @param fromElement set starts from after this element.
     * @return sortedset.
    */ 
    public SortedSet<E> tailSet(E fromElement) {
            
            for(int i=0;i<data.list.size();i++){

            if(fromElement.compareTo(data.list.get(i))<0){

                tailset.add(data.list.get(i));
            }
        }

        return tailset;

    }

    /** Iterator for NavigableAVLTree.
    * @return iterator.
    */
    public Iterator<E> iterator() {

        data.preOrderTraverse();

        return  data.list.iterator();
    }

    /** toString methof for NavigableAVLTree.
    * @return string.
    */
    public String toString() {
    
        return data.toString();
    }

    //----------------------------------------------------------------------------------------------

    public boolean add(E e) {

        return false;
    }

    public boolean remove(Object o) {
        return false;
    }

    public Iterator<E> descendingIterator() {
        return null;
    }

    public E lower(E e) {
        return null;
    }

    public E floor(E e) {
        return null;
    }

    public E ceiling(E e) {
        return null;
    }

    public E higher(E e) {
        return null;
    }

    public E pollFirst() {
        return null;
    }

    public E pollLast() {
        return null;
    }

    public int size() {
        return 0;
    }

    public boolean isEmpty() {
        return false;
    }

    public boolean contains(Object o) {
        return false;
    }

    public Object[] toArray() {
        return new Object[0];
    }

    public <T> T[] toArray(T[] a) {
        return null;
    }

    public boolean containsAll(Collection<?> c) {
        return false;
    }

    public boolean addAll(Collection<? extends E> c) {
        return false;
    }

    public boolean retainAll(Collection<?> c) {
        return false;
    }

    public boolean removeAll(Collection<?> c) {
        return false;
    }

    public void clear() {
    }

    public NavigableSet<E> descendingSet() {
        return null;
    }

    public NavigableSet<E> subSet(E fromElement, boolean fromInclusive, E toElement, boolean toInclusive) {
        return null;
    }

    public NavigableSet<E> headSet(E toElement, boolean inclusive) {
        return null;
    }

    public NavigableSet<E> tailSet(E fromElement, boolean inclusive) {
        return null;
    }

    public Comparator<? super E> comparator() {
        return null;
    }

    public SortedSet<E> subSet(E fromElement, E toElement) {
        return null;
    }

    public E first() {
        return null;
    }

    public E last() {
        return null;
    }
}
