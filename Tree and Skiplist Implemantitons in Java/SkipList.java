import java.util.*;

/**
 * A skip list is a data structure
 */
public class SkipList<E extends Comparable<E>, V> implements Iterable<E> {

    protected static final Random randomGenerator = new Random();

    protected static final double DEFAULT_PROBABILITY = 0.5;

    private Node<E, V> head;

    private double probability;

    private int size;

    public SkipList() {
        this(DEFAULT_PROBABILITY);
    }

    public SkipList(double probability) {
        this.head = new Node<E,V>(null, null, 0);
        this.probability = probability;
        this.size = 0;
    }

    public V get(E key) {
        checkKeyValidity(key);
        Node<E,V> node = findNode(key);
        if (node.getKey().compareTo(key) == 0)
            return node.getValue();
        else
            return null;
    }

    public void add(E key, V value) {
        checkKeyValidity(key);
        Node<E,V> node = findNode(key);
        if (node.getKey() != null && node.getKey().compareTo(key) == 0) {
            node.setValue(value);
            return;
        }

        Node<E,V> newNode = new Node<E,V>(key, value, node.getLevel());
        horizontalInsert(node, newNode);
        // Decide level according to the probability function
        int currentLevel = node.getLevel();
        int headLevel = head.getLevel();
        while (isBuildLevel()) {
            // buiding a new level
            if (currentLevel >= headLevel) {
                Node<E,V> newHead = new Node<E,V>(null, null, headLevel + 1);
                verticalLink(newHead, head);
                head = newHead;
                headLevel = head.getLevel();
            }
            // copy node and newNode to the upper level
            while (node.getUp() == null) {
                node = node.getPrevious();
            }
            node = node.getUp();

            Node<E,V> tmp = new Node<E,V>(key, value, node.getLevel());
            horizontalInsert(node, tmp);
            verticalLink(tmp, newNode);
            newNode = tmp;
            currentLevel++;
        }
        size++;
    }

    public void remove(E key) {
        checkKeyValidity(key);
        Node<E,V> node = findNode(key);
        if (node == null || node.getKey().compareTo(key) != 0)
            throw new NoSuchElementException("The key is not exist!");

        // Move to the bottom
        while (node.getDown() != null)
            node = node.getDown();
        // Because node is on the lowest level so we need remove by down-top
        Node<E,V> prev = null;
        Node<E,V> next = null;
        for (; node != null; node = node.getUp()) {
            prev = node.getPrevious();
            next = node.getNext();
            if (prev != null)
                prev.setNext(next);
            if (next != null)
                next.setPrevious(prev);
        }

        // Adjust head
        while (head.getNext() == null && head.getDown() != null) {
            head = head.getDown();
            head.setUp(null);
        }
        size--;
    }

    public boolean contains(E key) {
        return get(key) != null;
    }

    public int size() {
        return size;
    }

    public boolean empty() {
        return size == 0;
    }

    protected Node<E, V> findNode(E key) {
        Node<E,V> node = head;
        Node<E,V> next = null;
        Node<E,V> down = null;
        E nodeKey = null;

        while (true) {
            // Searching nearest (less than or equal) node with special key
            next = node.getNext();
            while (next != null && lessThanOrEqual(next.getKey(), key)) {
                node = next;
                next = node.getNext();
            }
            nodeKey = node.getKey();
            if (nodeKey != null && nodeKey.compareTo(key) == 0)
                break;
            // Descend to the bottom for continue search
            down = node.getDown();
            if (down != null) {
                node = down;
            } else {
                break;
            }
        }

        return node;
    }

    protected void checkKeyValidity(E key) {
        if (key == null)
            throw new IllegalArgumentException("Key must be not null!");
    }

    protected boolean lessThanOrEqual(E a, E b) {
        return a.compareTo(b) <= 0;
    }

    protected boolean isBuildLevel() {
        return randomGenerator.nextDouble() < probability;
    }

    protected void horizontalInsert(Node<E, V> x, Node<E, V> y) {
        y.setPrevious(x);
        y.setNext(x.getNext());
        if (x.getNext() != null)
            x.getNext().setPrevious(y);
        x.setNext(y);
    }

    protected void verticalLink(Node<E, V> x, Node<E, V> y) {
        x.setDown(y);
        y.setUp(x);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node<E,V> node = head;

        // Move into the lower left bottom
        while (node.getDown() != null)
            node = node.getDown();

        while (node.getPrevious() != null)
            node = node.getPrevious();

        // Head node with each level the key is null
        // so need to move into the next node
        if (node.getNext() != null)
            node = node.getNext();

        while (node != null) {
            sb.append(node.toString()).append("\n");
            node = node.getNext();
        }

        return sb.toString();
    }

    @Override
    public Iterator<E> iterator() {
        return new SkipListIterator<E, V>(head);
    }

    protected static class SkipListIterator<E extends Comparable<E>, V> implements Iterator<E> {

        private Node<E,V> node;

        public SkipListIterator(Node<E,V> node) {
            while (node.getDown() != null)
                node = node.getDown();

            while (node.getPrevious() != null)
                node = node.getPrevious();

            if (node.getNext() != null)
                node = node.getNext();

            this.node = node;
        }

        @Override
        public boolean hasNext() {
            return this.node != null;
        }

        @Override
        public E next() {
            E result = node.getKey();
            node = node.getNext();
            return result;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    protected static class Node<E extends Comparable<E>, V> {

        private E key;

        private V value;

        private int level;

        private Node<E,V> up, down, next, previous;

        public Node(E key, V value, int level) {
            this.key = key;
            this.value = value;
            this.level = level;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Node[")
                    .append("key:");
            if (this.key == null)
                sb.append("None");
            else
                sb.append(this.key.toString());

            sb.append(" value:");
            if (this.value == null)
                sb.append("None");
            else
                sb.append(this.value.toString());
            sb.append("]");
            return sb.toString();
        }

        public E getKey() {
            return key;
        }

        public void setKey(E key) {
            this.key = key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }

        public int getLevel() {
            return level;
        }

        public void setLevel(int level) {
            this.level = level;
        }

        public Node<E,V> getUp() {
            return up;
        }

        public void setUp(Node<E,V> up) {
            this.up = up;
        }

        public Node<E,V> getDown() {
            return down;
        }

        public void setDown(Node<E,V> down) {
            this.down = down;
        }

        public Node<E,V> getNext() {
            return next;
        }

        public void setNext(Node<E,V> next) {
            this.next = next;
        }

        public Node<E,V> getPrevious() {
            return previous;
        }

        public void setPrevious(Node<E,V> previous) {
            this.previous = previous;
        }
    }

}