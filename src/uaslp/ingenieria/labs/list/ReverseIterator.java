package uaslp.ingenieria.labs.list;

public class ReverseIterator {

    private Node currentNode;

    public ReverseIterator(Node currentNode){
        this.currentNode = currentNode;
    }

    public ReverseIterator(ReverseIterator reverseIterator){
        currentNode = reverseIterator.currentNode;
    }

    public boolean hasNext(){
        return currentNode != null;
    }

    public int next(){
        int data = currentNode.getData();
        currentNode = currentNode.getPrevious();
        return data;
    }

    public Node getCurrentNode() {
        return currentNode;
    }
}
