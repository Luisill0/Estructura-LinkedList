package uaslp.ingenieria.labs;

import uaslp.ingenieria.labs.list.LinkedList;
import uaslp.ingenieria.labs.list.Position;

public class Main {

    public static void main(String[] args) {

        int cuenta = LinkedList.getListsCount();

        LinkedList<Integer> list1 = new LinkedList<>();
        LinkedList<String> list2 = new LinkedList<>();

        list1.add(1);
        list1.add(4);
        list1.add(3);
        list1.add(7);

        list2.add("hola");
        list2.add(" Object ");
        list2.add(" Oriented ");
        list2.add(" Programming ");

        LinkedList<Integer>.Iterator it = list1.getIterator();

        while(it.hasNext()){
            LinkedList<Integer>.Iterator backupIt = list1.new Iterator(it);
            int element = it.next(); //regresar el dato y avanzar el iterador

            if(element == 3){
                list1.insert(10, Position.BEFORE, backupIt);
            }

            if(element == 7){
                list1.insert(15, Position.AFTER, backupIt);
            }
        }

        list1.delete(3);

        System.out.println("---------------------");

        System.out.println("El tamaño es: " + list1.getSize());

        it = list1.getIterator();

        while(it.hasNext()){
            int element = it.next();

            System.out.println("Dato: " + element);
        }

        System.out.println("---------------------");

        LinkedList<Integer>.ReverseIterator reverseIterator = list1.getReverseIterator();

        while(reverseIterator.hasNext()){
            int element = reverseIterator.next();

            System.out.println("Dato: " + element);
        }

        System.out.println("---------------------");

        LinkedList<String>.Iterator itStrings = list2.getIterator();

        while(itStrings.hasNext()){
            System.out.print(itStrings.next());
        }

        System.out.println("\n---------------------");

        LinkedList<String>.ReverseIterator revItString = list2.getReverseIterator();

        while(revItString.hasNext()){
            System.out.print(revItString.next());
        }

        System.out.println("\n---------------------");
    }
}
