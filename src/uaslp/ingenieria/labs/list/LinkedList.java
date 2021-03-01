package uaslp.ingenieria.labs.list;

/**
 * Lista doblemente ligada
 */
public class LinkedList {

    public static final boolean BEFORE = false;
    public static final boolean AFTER = true;

    private Node head;
    private Node tail;
    private int size;

    /***
     * Inserts data at the end of the list
     * @param data Data to be inserted
     */
    public void add(int data){
        Node node = new Node(data);
        node.setPrevious(tail);

        if(tail != null){
            tail.setNext(node);
        }

        if(head == null){
            head = node;
        }

        tail = node;
        size++;
    }

    public int getSize() {
        return size;
    }

    /**
     * @param index 0-index
     * @return data in index
     */
    public int get(int index){
        Node currentNode = head;
        int currentindex = 0;

        while(currentindex < index){
            currentNode = currentNode.getNext();
            currentindex++;
        }

        return currentNode.getData();
    }

    /**
     * @param index 0-index
     */
    public void delete(int index){
        Node currentNode = head;
        int currentIndex = 0;

        if(index < 0 || index >= size){
            return;
        }
        size--;

        if(size == 0){
            head = null;
            tail = null;
            return;
        }

        if(index == 0){
            head = head.getNext();
            head.setPrevious(null);
        }

        if(index == size){
            tail = tail.getPrevious();
            tail.setNext(null);
        }

        if(index > 0 && index < size){
            while(currentIndex < index){
                currentNode = currentNode.getNext();
                currentIndex++;
            }
            currentNode.getPrevious().setNext(currentNode.getNext());
            currentNode.getNext().setPrevious(currentNode.getPrevious());
        }
    }

    public Iterator getIterator(){
        return new Iterator(head);
    }

    public ReverseIterator getReverseIterator(){
        return new ReverseIterator(tail);
    }

    public void insert(int data, boolean position, Iterator it){
        Node newNode = new Node(data);
        Node currentNode = it.getCurrentNode();

        if(position == AFTER){
            newNode.setNext((currentNode.getNext()));
            newNode.setPrevious(currentNode);
            currentNode.setNext(newNode);
            if(newNode.getNext() != null){
                newNode.getNext().setPrevious(newNode);
            }else{
                tail = newNode;
            }
        }else{
            newNode.setPrevious(currentNode.getPrevious());
            newNode.setNext(currentNode);
            currentNode.setPrevious(newNode);
            if(newNode.getPrevious() != null){
                newNode.getPrevious().setNext(newNode);
            }else{
                head = newNode;
            }
        }
        size++;
    }
}

class Node{
    private int data;
    private Node next;
    private Node previous;

    Node(int data){
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getPrevious() {
        return previous;
    }

    public void setPrevious(Node previous) {
        this.previous = previous;
    }
}