
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