package uaslp.ingenieria.labs;

import uaslp.ingenieria.labs.list.*;

public class Main {

    public static void main(String[] args) {

        //int cuenta = LinkedList.getListsCount();
        List<Integer> list1 = new LinkedList<>();
        List<String> list2 = new LinkedList<>();

        list1.add(1);
        list1.add(4);
        list1.add(3);
        list1.add(7);

        list2.add("hola");
        list2.add(" Object ");
        list2.add(" Oriented ");
        list2.add(" Programming ");

        list1.delete(3);

        System.out.println("---------------------");

        System.out.println("El tamaño es: " + list1.getSize());

        Iterator<Integer> it = list1.getIterator();

        while(it.hasNext()){
            int element = it.next();

            System.out.println("Dato: " + element);
        }

        System.out.println("---------------------");

        it = list1.getReverseIterator();

        while(it.hasNext()){
            int element = it.next();

            System.out.println("Dato: " + element);
        }

        System.out.println("---------------------");

        System.out.println("El tamaño es: " + list2.getSize());

        Iterator<String> itStrings = list2.getIterator();

        while(itStrings.hasNext()){
            System.out.print(itStrings.next());
        }

        System.out.println("\n---------------------");

        itStrings = list2.getReverseIterator();

        while(itStrings.hasNext()){
            System.out.print(itStrings.next());
        }

        System.out.println("\n---------------------");
    }
}
