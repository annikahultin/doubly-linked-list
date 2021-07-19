import java.lang.reflect.Method;
import java.lang.Exception;

/**
 * Doubly Linked List Class.
 */
public class DLL<E> {

    private Node<E> head; //keeps track of the first node of the list
    private Node<E> tail; //keeps track of the last node of the list
    private int counter; //keeps track of the size of the list

    /**
     * Node class for the DLL class
     */
    public class Node<E> {

        private E element; //contents of the node
        private Node<E> prev; //reference to the previous node of the list
        private Node<E> next; //reference to the next node of the list

        /**
         * Default constructor for the Node class.
         */
        public Node() {
            this.element = null;
            this.prev = null;
            this.next = null;
        } //Node

        /**
         * Constructor for the Node class that assigns the
         * contents of the node.
         */
        public Node(E element) {
            this.element = element;
            this.prev = null;
            this.next = null;
        } //Node

        /**
         * Constructor that assigns the contents, previous, and next
         * Node.
         */
        public Node(E element, Node<E> prev, Node<E> next) {
            this.element = element;
            this.prev = prev;
            this.next = next;
        } //Node

        /**
         * Retrieves the contents of the node
         */
        public E getElement() {
            return element;
        } //getElement

        /**
         * Sets the contents of the node
         */
        public void setElement(E element) {
            this.element = element;
        } //setElement

        /**
         * Retrieves the previous node of the list
         */
        public Node<E> getPrev() {
            return prev;
        } //getPrev

        /**
         * Sets the previous node of the list
         */
        public void setPrev(Node<E> prev) {
            this.prev = prev;
        } //setPrev

        /**
         * Retrieves the next node of the list
         */
        public Node<E> getNext() {
            return next;
        } //getNext

        /**
         * Sets the next node of the list
         */
        public void setNext(Node<E> next) {
            this.next = next;
        } //setNext
    } //Node

    /**
     * Default constructor for the DLL class
     */
    public void DLL() {
        this.head = null;
        this.tail = null;
        this.counter = 0;
    } //DLL

    /**
     * Returns the size of the list
     */
    public int size() {
        return counter;
    } //size

    /**
     * Returns whether or not the list is empty
     */
    public boolean isEmpty() {
        if (counter == 0) {
            return true;
        } else {
            return false;
        } //if
    } //isEmpty

    /**
     * Returns the first element in the list
     */
    public E first() {
        if (!isEmpty()) {
            return head.getElement();
        } else {
            return null;
        } //if
    } //first

    /**
     * Returns the last element in the list
     */
    public E last() {
        if (!isEmpty()) {
            return tail.getElement();
        } else {
            return null;
        } //if
    } //last

    /**
     * Adds an element to the first position of the list
     */
    public void addFirst(E element) {
        if (isEmpty()) {
            head = new Node<E>(element);
            tail = head;
            counter ++;
        } else {
            Node<E> temp = head;
            head = new Node<E>(element, null, temp);
            temp.setPrev(head);
            counter ++;
        } //if
    } //addFirst

    /**
     * Adds an element to the last position of the list
     */
    public void addLast(E element) {
        if (isEmpty()) {
            head = new Node<E>(element);
            tail = head;
            counter ++;
        } else {
            Node<E> temp = tail;
            tail = new Node<E>(element, temp, null);
            temp.setNext(tail);
            counter ++;
        } //if
    } //addLast

    /**
     * Removes and returns the first element of the list
     */
    public E removeFirst() {
        if (isEmpty()) {
            return null;
        } else {
            Node<E> temp = head;
            head = head.getNext(); //resets value of head
            head.setPrev(null);
            counter --; //reduces size of the list
            return temp.getElement();
        } //if
    } //removeFirst

    /**
     * Removes and returns the last element of the list
     */
    public E removeLast() {
        if (isEmpty()) {
            return null;
        } else {
            Node<E> temp = tail;
            tail = tail.getPrev(); //resets the value of tail
            tail.setNext(null);
            counter --; //reduces the size of the list
            return temp.getElement();
        } //if
    } //removeLast

    /**
     * Returns a string representation of the list
     */
    public String toString() {
        String list = "null";
        if (isEmpty()) {
            return list;
        } else {
            for (int i = 0; i < size(); i ++) {
                if (i == 0) {
                    list += " <-- " + get(i); //adds the element to the string
                } else {
                    list += " <--> " + get(i); //adds the element to the string
                } //if
            } //for
            list += " --> null";
        } //if
        return list;
    } //toString

    /**
     * Creates a new list with references to the original lists elements
     */
    public DLL<E> clone() {
        DLL<E> clonedList = new DLL<E>();
        for (int i = size() - 1; i > -1; i --) {
            clonedList.addFirst(get(i)); //adds each element to the list
        } //for
        return clonedList;
    } //clone

    /**
     * Creates a deep copy of a list
     */
    public DLL<E> deepClone() {
        DLL<E> deepClonedList = new DLL<E>();
        for (int i = size() - 1; i > -1; i --) {
            try {
                Method m = get(i).getClass().getMethod("clone");
                E elementCopy = (E) m.invoke(get(i));
                deepClonedList.addFirst(elementCopy); //adds each element to the list
            } catch (Exception e) {
                e.printStackTrace();
            } //catch
        } //for
        return deepClonedList;
     } //deepClone

    /**
     * Returns the Node at the specified position
     * One of my helper methods
     */
    public Node<E> getNode(int index) {
        if (index >= size()) {
            return null;
        } else {
            Node<E> temp = head;
            for (int i = 0; i < index; i++) {
                temp = temp.getNext(); //iterates through the elements until the index
            } //for
            return temp; //returns node at specified index
        } //if
    } //getNode

    /**
     * Inserts node at the specified index
     */
    public void insert(int index, E element) {
        if (!(index >= size() || index == 0)) {
            Node<E> current = getNode(index); //gets the node currently at the index
            Node<E> previous = current.getPrev(); //previous node at the index
            Node<E> inserted = new Node<E>(element, previous, current); //creates node to insert
            previous.setNext(inserted); //inserts the node
            current.setPrev(inserted); //inserts the node
            counter ++;
        } else if (index == 0 && isEmpty()) {
            addFirst(element);
        } else if (index == 0) {
            Node<E> current = head;
            head = new Node<E>(element, null, current); //creates node to insert
            current.setPrev(head); //inserts the node
            counter ++;
        } else if (index == size()) {
            Node<E> temp = tail;
            tail = new Node<E>(element, temp, null); //creates node to be inserted
            temp.setNext(tail); //inserts the node
            counter ++;
        } else {
            System.out.println("Invalid Index.");
        } //if
    } //insert

    /**
     * Returns the element at the specified index
     */
    public E get(int index) {
        if (index >= size()) {
            return null;
        } else {
            Node<E> temp = head;
            for (int i = 0; i < index; i++) {
                temp = temp.getNext(); //iterates through nodes till index is reached
            } //for
            return temp.getElement(); //returns element at specified index
        } //if
    } //get

    /**
     * Removes and returns the element at the specified index
     */
    public E remove(int index) {
        if (!isEmpty()) {
            if (!(index >= (size() - 1) || index == 0)) {
                Node<E> removed = getNode(index); //gets the node to remove
                Node<E> next = removed.getNext();
                Node<E> prev = removed.getPrev();
                next.setPrev(prev); //removes the node from the list
                prev.setNext(next); //removes the node from the list
                counter --;
                return removed.getElement(); //returns the removed element
            } else if (index == 0) {
                return removeFirst();
            } else if (index == (size() - 1)) {
                return removeLast();
            } else {
                return null;
            } //if
        } else {
            return null;
        } //if
    } //remove

    /**
     * Removes the specified node
     */
    public void remove(Node<E> x) {
        if (!isEmpty()) {
            Node<E> removed = find(x.getElement()); //gets the node to remove
            if (removed.equals(head)) { //handles if the node to remove is head
                head = removed.getNext();
                head.setPrev(null);
                counter --;
            } else if (removed.equals(tail)) { //handles if the node to remove is tail
                tail = removed.getPrev();
                tail.setNext(null);
                counter --;
            } else { //handles any other situation
                Node<E> next = removed.getNext();
                Node<E> prev = removed.getPrev();
                next.setPrev(prev);
                prev.setNext(next);
                counter --;
            } //if
        } //if
    } //remove

    /**
     * Returns the node containing the specified element
     */
    public Node<E> find(E element) {
        if (contains(element)) {
            int idx = -1;
            for (int i = 0; i < size(); i++) {
                if (get(i).equals(element)) { //checks if the elements are equals
                    idx = i;
                    return getNode(i); //returns the node
                } //if
            } //for
            return getNode(idx); //returns the node
        } else {
            return null;
        } //if
    } //find

    /**
     * Returns whether or not the list contains the element
     */
    public boolean contains(E element) {
        if (isEmpty()) {
            return false;
        } else {
            for (int i = 0; i < size(); i++) {
                if (get(i).equals(element)) { //checks if the elements are equals
                    return true;
                } //if
            } //for
            return false;
        } //if
    } //contains

    /**
     * Swaps the head and the tail variable
     * Helper method
     */
    private void swapHeadTail(Node<E> h, Node<E> t) {
        Node<E> hNext = h.getNext();
        Node<E> tPrev = t.getPrev();
        hNext.setPrev(t);
        t.setNext(hNext);
        t.setPrev(null);
        tPrev.setNext(h);
        h.setNext(null);
        h.setPrev(tPrev);
        head = t;
        tail = h;
    } //swapHeadTail

    /**
     * Swaps the head of the list with another item
     * Helper method
     */
    private void swapHead(Node<E> h, Node<E> x) {
        Node<E> hNext = h.getNext();
        Node<E> xNext = x.getNext();
        Node<E> xPrev = x.getPrev();
        h.setNext(xNext);
        h.setPrev(xPrev);
        xPrev.setNext(h);
        xNext.setPrev(h);
        x.setNext(hNext);
        x.setPrev(null);
        hNext.setPrev(x);
        head = x;
    } //swapHead

    /**
     * Swaps the tail of the list with another item
     * Helper method
     */
    private void swapTail(Node<E> t, Node<E> x) {
        Node<E> xNext = x.getNext();
        Node<E> xPrev = x.getPrev();
        Node<E> tPrev = t.getPrev();
        x.setNext(null);
        x.setPrev(tPrev);
        tPrev.setNext(x);
        t.setNext(xNext);
        t.setPrev(xPrev);
        xPrev.setNext(t);
        xNext.setPrev(t);
        tail = x;
    } //swapTail

    /**
     * Swaps the two specified nodes in the list
     */
    public void swap (Node<E> x, Node<E> y) {
        if (x.equals(head)) { //check if x is the head
            if (y.equals(tail)) { //chec if y is the tail
                swapHeadTail(x, y); //swaps head and tail
            } else {
                swapHead(x, y); //swaps head and other item
            } //if
        } else if (y.equals(head)) { //checks if y is head
            if (x.equals(tail)) { //checks if x is the tail
                swapHeadTail(y, x); //swaps head and tail
            } else {
                swapHead(y, x); //swaps head with other node
            } //if
        } else if (x.equals(tail)) { //checks if x is the tail
            if (y.equals(head)) { //checks if y is the head
                swapHeadTail(y, x); //swpas the head and tail
            } else {
                swapTail(x, y); //swaps the tail with other node
            } //if
        } else if (y.equals(tail)) { //checks if y is the tail
            if (x.equals(head)) { //checks if x is the head
                swapHeadTail(x, y); //swaps the head and tail
            } else {
                swapTail(y, x); //swaps the tail with other node
            } //if
        } else if (x.getNext().equals(y)) { //checks if the nodes are next to each other
            x.getPrev().setNext(y);
            y.setPrev(x.getPrev());
            Node<E> temp = y.getNext();
            y.setNext(x);
            x.setPrev(y);
            x.setNext(temp);
            temp.setPrev(x);
        } else { //handles any other swap
            Node<E> xNext = x.getNext();
            Node<E> xPrev = x.getPrev();
            Node<E> yNext = y.getNext();
            Node<E> yPrev = y.getPrev();
            x.setNext(yNext);
            x.setPrev(yPrev);
            yPrev.setNext(x);
            yNext.setPrev(x);
            y.setNext(xNext);
            y.setPrev(xPrev);
            xPrev.setNext(y);
            xNext.setPrev(y);
        } //if
    } //swap

    /**
     * Clears the list.
     */
    public void clear() {
        head = null;
        tail = null;
        counter = 0;
    } //clear

    /**
     * Sets the element of the list at the specified index
     * to the specified element and returns original element
     */
    public E set(int index, E element) {
        E original = get(index);
        getNode(index).setElement(element); //sets the element
        return original; //returns the original element
    } //set
} //DLL
