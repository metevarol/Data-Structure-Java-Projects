
import java.util.*;

/** Represents an NavigableSkipList.
* @author Hikmet Mete Varol
* @version 1.0
* @since 1.0
*/
public class NavigableSkipList<E extends Comparable<E>, V> implements NavigableSet<E> {

    /** SkipList for using as data.
    */  
    private SkipList<E,V> data;
    
    /** Constructor for NavigableSkipList.
    */ 
    public NavigableSkipList() {

        data = new SkipList<>();
    }

    /** insert method for NavigableSkipList.
     * @param key Key.
     * @param val Value.
    */ 
    public void insert(E key,V val){

        data.add(key,val);
    }

    /** delete method for NavigableSkipList.
     * @param key Key.
    */ 
    public void delete(E key){

        data.remove(key);
    }

    /** get method for NavigableSkipList.
     * @param key Key.
     * @return Value of key.
    */ 
    public V get(E key){

        return data.get(key);
    }

    /** Iterator for NavigableSkipList.
     * @return iterator.
    */
    public Iterator<E> descendingIterator() {
        return data.iterator();
    }

    /** Size method for NavigableSkipList.
     * @return size.
    */
    public int size(){

        return data.size();
    }

    //----------------------------------------------------------------------------------------------

    public boolean add(E key) {

        return false;
    }

     public boolean remove(Object key) {

        return false;
    }


    public Iterator<E> iterator() {

        return null;
    }

    public SortedSet<E> headSet(E toElement) {

        return null;
    }

    public SortedSet<E> tailSet(E fromElement) {
            
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
