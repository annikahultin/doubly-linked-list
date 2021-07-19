
public class DLLTester {

    public static void sizeTest() {
        DLL<Integer> list = new DLL<Integer>();
        list.addFirst(1);
        list.addLast(2);
        list.addFirst(3);
        if (list.size() == 3) {
            System.out.println("PASS: size when list contains elements");
            list.clear();
            if (list.size() == 0) {
                System.out.println("PASS: size after clear()");
            } else {
                System.out.println("FAIL: size after clear()");
            } //if
        } else {
            System.out.println("FAIL: size when list contains elements");
        } //else
    } //sizeTest

    public static void isEmptyTest() {
        DLL<String> list = new DLL<String>();
        if (list.isEmpty()) {
            System.out.println("PASS: isEmpty when list is empty");
            list.addFirst("hi");
            list.addLast("oh");
            if (list.isEmpty()) {
                System.out.println("FAIL: when list is not empty");
            } else {
                System.out.println("PASS: when list is not empty");
                list.clear();
                if (list.isEmpty()) {
                    System.out.println("PASS: after list has been cleared");
                } else {
                    System.out.println("FAIL: after list has been cleared");
                } //if
            } //if
        } else {
            System.out.println("FAIL: isEmpty when list is empty");
        } //if
    } //isEmptyTest

    public static void firstTest() {
        DLL<String> list = new DLL<String>();
        list.addFirst("c");
        if (list.first().equals("c")) {
            System.out.println("PASS: when list has 1 element");
            list.addFirst("b");
            list.addFirst("a");
            if (list.first().equals("a")) {
                System.out.println("PASS: when list has 3 elements");
            } //if
        } //if
    } //firstTest

    public static void lastTest() {
        DLL<String> list = new DLL<String>();
        list.addFirst("c");
        if (list.last().equals("c")) {
            System.out.println("PASS: when list has 1 element");
            list.addLast("b");
            list.addLast("a");
            if (list.last().equals("a")) {
                System.out.println("PASS: when list has 3 elements");
            } //if
        } //if
    } //lastTest

    public static void addFirstTest() {
        DLL<Double> list = new DLL<Double>();
        list.addFirst(3.0);
        System.out.println("addFirst(3.0): " + list.toString());
        list.addFirst(2.0);
        System.out.println("addFirst(2.0): " + list.toString());
    } //addFirstTest

    public static void addLastTest() {
        DLL<Double> list = new DLL<Double>();
        list.addLast(3.0);
        System.out.println("addLast(3.0): " + list.toString());
        list.addLast(2.0);
        System.out.println("addLast(2.0): " + list.toString());
    } //addFirstTest

    public static void removeFirstTest() {
        DLL<String> list = new DLL<String>();
        list.addFirst("a");
        list.addLast("b");
        list.addLast("c");
        if (list.removeFirst().equals("a")) {
            System.out.println("PASS: when list has 3 elements");
            System.out.println(list.toString());
            if (list.removeFirst().equals("b")) {
                System.out.println("PASS: when list has 2 elements");
                System.out.println(list.toString());
            } //if
        } //if
    } //removeFirstTest

    public static void removeLastTest() {
        DLL<String> list = new DLL<String>();
        list.addFirst("a");
        list.addLast("b");
        list.addLast("c");
        if (list.removeLast().equals("c")) {
            System.out.println("PASS: when list has 3 elements");
            System.out.println(list.toString());
            if (list.removeLast().equals("b")) {
                System.out.println("PASS: when list has 2 elements");
                System.out.println(list.toString());
            } //if
        } //if
    } //removeLastTest

    public static void cloneTest() {
        DLL<Integer> list = new DLL<Integer>();
        list.addFirst(3);
        list.addFirst(2);
        list.addFirst(1);
        DLL<Integer> clonedList = list.clone();
        System.out.println("list == clonedList: " + (list == clonedList));
        System.out.println("list.equals(clonedList): " + list.equals(clonedList));
        System.out.println("list: " + list.toString());
        System.out.println("clonedList: " + clonedList.toString());
        clonedList.find(1).setElement(4);
        System.out.println("new list: " + list.toString());
        System.out.println("new clonedList: " + clonedList.toString());
    } //cloneTest

    public static void deepCloneTest() {
        DLL<Integer> list = new DLL<Integer>();
        list.addFirst(3);
        list.addFirst(2);
        list.addFirst(1);
        DLL<Integer> clonedList = list.deepClone();
        System.out.println("list == clonedList: " + (list == clonedList));
        System.out.println("list.equals(clonedList): " + list.equals(clonedList));
        System.out.println("list: " + list.toString());
        System.out.println("clonedList: " + clonedList.toString());
        clonedList.set(1, 4);
        System.out.println("new list: " + list.toString());
        System.out.println("new clonedList: " + clonedList.toString());
    } //deepCloneTest

    public static void insertTest() {
        DLL<String> list = new DLL<String>();
        list.addFirst("d");
        list.addFirst("b");
        list.addFirst("a");
        System.out.println("Original: " + list.toString());
        list.insert(2, "c");
        System.out.println("list.insert(2, c): " + list.toString());
        list.insert(4, "e");
        System.out.println("list.insert(4, e): " + list.toString());
        list.insert(0, "a");
        System.out.println("list.insert(0, a): " + list.toString());
        System.out.println("size = " + list.size());
        list.clear();
        list.insert(0, "d");
        System.out.println("list.insert(0, d): " + list.toString());
    } //insertTest

    public static void getTest() {
        DLL<String> list = new DLL<String>();
        list.addFirst("c");
        list.addFirst("b");
        list.addFirst("a");
        if (list.get(0).equals("a")) {
            if (list.get(1).equals("b")) {
                if (list.get(2).equals("c")) {
                    System.out.println("PASS: for all indicies in the list");
                } //if
            } //if
        } //if
    } //getTest

    public static void removeTest() {
        DLL<Integer> list = new DLL<Integer>();
        list.addLast(3);
        list.addFirst(2);
        list.addFirst(1);
        System.out.println("Original: " + list.toString());
        if (list.remove(1) == 2) {
            System.out.println("PASS: for middle index.");
            System.out.println("remove(1): " + list.toString());
            list.insert(1, 2);
            if (list.remove(0) == 1) {
                System.out.println("PASS: for first index.");
                System.out.println("remove(0): " + list.toString());
                list.insert(0, 1);
                if (list.remove(2) == 3) {
                    System.out.println("PASS: for last index.");
                    System.out.println("remove(2): " + list.toString());
                } //if
            } //if
        } //if
    } //removeTest

    public static void removeTwoTest() {
        DLL<Integer> list = new DLL<Integer>();
        list.addLast(3);
        list.addFirst(2);
        list.addFirst(1);
        System.out.println("Original: " + list.toString());
        list.remove(list.find(2));
        System.out.println("remove(second): " + list.toString());
        list.insert(1, 2);
        list.remove(list.find(1));
        System.out.println("remove(first): " + list.toString());
        list.insert(0, 1);
        list.remove(list.find(3));
        System.out.println("remove(third): " + list.toString());
    } //removeTest

    public static void findTest() {
        DLL<Integer> list = new DLL<Integer>();
        list.addFirst(1);
        list.addLast(2);
        list.addLast(3);
        System.out.println("find(2): " + list.find(2).getElement());
        System.out.println("find(1): " + list.find(1).getElement());
        System.out.println("find(3): " + list.find(3).getElement());
    } //findtest

    public static void containsTest() {
        DLL<String> list = new DLL<String>();
        list.addFirst("c");
        list.addFirst("b");
        list.addFirst("a");
        if (list.contains("a")) {
            if (list.contains("b")) {
                if (list.contains("c")) {
                    if (list.contains("d") == false) {
                        System.out.println("PASS: for all test cases");
                    } //if
                } //if
            } //if
        } //if
    } //containsTest

    public static void swapTest() {
        DLL<Integer> list = new DLL<Integer>();
        list.addLast(4);
        list.addFirst(3);
        list.addFirst(2);
        list.addFirst(1);
        System.out.println("Original: " + list.toString());
        list.swap(list.find(4), list.find(1));
        System.out.println("Swap(tail, head): " + list.toString());
        list.swap(list.find(4), list.find(1));
        System.out.println("Swap(head, tail): " + list.toString());
        list.swap(list.find(1), list.find(3));
        System.out.println("Swap(1, 3): " + list.toString());
        list.swap(list.find(4), list.find(2));
        System.out.println("Swap(4, 2): " + list.toString());
        list.swap(list.find(4), list.find(1));
        System.out.println("Swap(4, 1): " + list.toString());
        list.addFirst(5);
        list.swap(list.find(3), list.find(4));
        System.out.println("Swap(3, 4): " + list.toString());
    } //swapTest

    public static void clearTest() {
        DLL<String> list = new DLL<String>();
        list.addFirst("a");
        list.addLast("b");
        list.addLast("c");
        System.out.println("Before: " + list.toString());
        System.out.println("size = " + list.size());
        list.clear();
        System.out.println("After: " + list.toString());
        System.out.println("size = " + list.size());
        list.addFirst("a");
        list.addFirst("b");
        list.addLast("c");
        System.out.println(list.toString());
        System.out.println(list.size());
    } //clearTest

    public static void setTest() {
        DLL<Integer> list = new DLL<Integer>();
        list.addFirst(1);
        list.addLast(2);
        list.addLast(3);
        System.out.println("Original: " + list.toString());
        System.out.println("Returned: " + list.set(2, 4));
        System.out.println("After: " + list.toString());
        System.out.println("get(2): " + list.get(2));
    } //setTest

    public static void main(String[] args) {
        System.out.println("\nSize Tests:");
        sizeTest();
        System.out.println("\nisEmpty Tests:");
        isEmptyTest();
        System.out.println("\nfirst Tests:");
        firstTest();
        System.out.println("\nlast Tests:");
        lastTest();
        System.out.println("\naddFirst Tests:");
        addFirstTest();
        System.out.println("\naddLast Tests:");
        addLastTest();
        System.out.println("\nremoveFirst Tests:");
        removeFirstTest();
        System.out.println("\nremoveLast Tests:");
        removeLastTest();
        System.out.println("\nclone Tests:");
        cloneTest();
        System.out.println("\ndeepClone Tests:");
//        deepCloneTest();
        System.out.println("\ninsert Test:");
        insertTest();
        System.out.println("\nget Tests: ");
        getTest();
        System.out.println("\nremove Tests: ");
        removeTest();
        System.out.println("\nremove (void) Tests: ");
        removeTwoTest();
        System.out.println("\nfind Tests:");
        findTest();
        System.out.println("\ncontains Tests:");
        containsTest();
        System.out.println("\nswap Tests:");
        swapTest();
        System.out.println("\nclear Tests:");
        clearTest();
        System.out.println("\nset Tests:");
        setTest();

        DLL<Integer> list = new DLL<Integer>();
        list.addFirst(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        System.out.println(list.toString());
        System.out.println(list.removeLast());
        System.out.println(list.toString());
        System.out.println(list.removeLast());
        System.out.println(list.toString());
        System.out.println(list.removeLast());
        System.out.println(list.toString());
        System.out.println(list.removeLast());
        System.out.println(list.toString());
        System.out.println(list.removeLast());
        System.out.println(list.toString());
    } //main

} //DLLTester
