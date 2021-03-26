package uaslp.ingenieria.labs.list;

/**
 * Lista doblemente ligada
 */
public class LinkedList<G> implements List<G> {

    private static class Node<T>{
        private final T data;
        private Node<T> previous;
        private Node<T> next;

        Node(T data){
            this.data = data;
        }
    }

    public class ForwardIterator implements Iterator<G> {
        private Node<G> currentNode;

        public ForwardIterator(){
            this.currentNode = head;
        }

        public ForwardIterator(ForwardIterator iterator){
            currentNode = iterator.currentNode;
        }

        @Override
        public boolean hasNext(){
            return currentNode != null;
        }

        @Override
        public G next(){
            G data = currentNode.data;
            currentNode = currentNode.next;
            return data;
        }

        public Node<G> getCurrentNode(){
            return currentNode;
        }
    }

    public class ReverseIterator implements Iterator<G>{
        private Node<G> currentNode;

        public ReverseIterator(){
            this.currentNode = tail;
        }

        public ReverseIterator(ReverseIterator reverseIterator){
            currentNode = reverseIterator.currentNode;
        }

        @Override
        public boolean hasNext(){
            return currentNode != null;
        }

        @Override
        public G next(){
            G data = currentNode.data;
            currentNode = currentNode.previous;
            return data;
        }

        Node<G> getCurrentNode(){
            return currentNode;
        }
    }

    private Node<G> head;
    private Node<G> tail;
    private int size;
    private static int listsCount = 0;

    public LinkedList(){
        listsCount++;
    }

    public static int getListsCount(){
        return listsCount;
    }

    /***
     * Inserts data at the end of the list
     * @param data Data to be inserted
     */
    @Override
    public void add(G data){
        Node<G> node = new Node<>(data);
        node.previous = tail;

        if(tail != null){
            tail.next = node;
        }

        if(head == null){
            head = node;
        }

        tail = node;
        size++;
    }

    /**
     * @param index 0-index
     * @return data in index
     */
    @Override
    public G get(int index){
        Node<G> currentNode = head;
        int currentindex = 0;

        while(currentindex < index){
            currentNode = currentNode.next;
            currentindex++;
        }

        return currentNode.data;
    }

    /**
     * @param index 0-index
     */
    @Override
    public void delete(int index){
        Node<G> currentNode = head;
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
            head = head.next;
            head.previous = null;
        }

        if(index == size){
            tail = tail.previous;
            tail.next = null;
        }

        if(index > 0 && index < size){
            while(currentIndex < index){
                currentNode = currentNode.next;
                currentIndex++;
            }
            currentNode.previous.next = currentNode.next;
            currentNode.next.previous = currentNode.previous;
        }
    }

    @Override
    public ForwardIterator getIterator(){
        return new ForwardIterator();
    }

    @Override
    public ReverseIterator getReverseIterator(){
        return new ReverseIterator();
    }

    @Override
    public int getSize() {
        return size;
    }
}

