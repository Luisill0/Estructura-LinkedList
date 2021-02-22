package uaslp.ingenieria.labs.list;

public class LinkedList {
    Node head;
    Node tail;
}

class Node{
    private int dato;
    private Node next;
    private Node previous;

    public int getDato() {
        return dato;
    }

    public void setDato(int dato) {
        this.dato = dato;
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