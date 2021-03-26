
Pensar en buena implementacion para el insert
```java
 Iterator<Integer> it = list1.getIterator();

        while(it.hasNext()){
            Iterator <Integer> backupIt = list1.new(Iterator<Integer>);
            int element = it.next(); //regresar el dato y avanzar el iterador

            if(element == 3){
                list1.insert(10, Position.BEFORE, backupIt);
            }

            if(element == 7){
                list1.insert(15, Position.AFTER, backupIt);
            }
        }
```

```java
    public void insert(G data, Position pos, Iterator<G> it){
        Node<G> newNode = new Node<>(data);
        Node<G> currentNode =((ForwardIterator)it).getCurrentNode();

        if(pos == Position.AFTER){
            newNode.next = currentNode.next;
            newNode.previous = currentNode;
            currentNode.next = newNode;
            if(newNode.next != null){
                newNode.next.previous = newNode;
            }else{
                tail = newNode;
            }
        }else{
            newNode.previous = currentNode.previous;
            newNode.next = currentNode;
            currentNode.previous = newNode;
            if(newNode.previous != null){
                newNode.previous.next = newNode;
            }else{
                head = newNode;
            }
        }
        size++;
    }
```