import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Main {

    public static void main(String[] args) {
        Queue<Person> attraction = new ArrayDeque<>(); // почитать про списки, почему этот позволяет удалять элементы в середине, а LinkedList например нет?
        for (Person p : generateClients()) {
            attraction.offer(p);
        }
        System.out.println(attraction);

/*         LinkedList с for.each внутри while не работает если удалять элементы из середины, выдает
         ConcurrentModificationException при выполнении while из за того, что изменился размер очереди в середине
         или в начале, но работает, если удаляются элементы в конце очереди. Однако, с итератором вместо for
         работает корректно
         */

        while (!attraction.isEmpty()) {
//            Iterator<Person> iterator = attraction.iterator();
//            while (iterator.hasNext()) {
//                Person p = iterator.next();
           for (Person p : attraction) {
               //System.out.println(p);
               p.tickets--;
               if (p.tickets > 0) System.out.println(p.printPersonalInfo() + " прокатился на паровозике. У него осталось " +
                       p.tickets + " билетов.");
               if (p.tickets == 0) {
                   System.out.println(attraction.peek().printPersonalInfo() + " прокатился на паровозике последний раз. У него больше не осталось билетов.");
                   attraction.poll();
                   //iterator.remove();

                   System.out.println(attraction);
                   //System.out.println(attraction.element().tickets);
               }
           }
           //System.out.println(attraction);
        }
    }

    static List<Person> generateClients () {
        Person person1 = new Person("Vasya", "Ivanov", 2);
        Person person2 = new Person("Kolya", "Petrov", 3);
        Person person3 = new Person("Borat", "Sagdiev", 4);
        Person person4 = new Person("Arthur", "Dzhikiya", 5);
        Person person5 = new Person("Vlad", "Tepes", 6);
        List<Person> list = new LinkedList<>();
        list.add(person1);
        list.add(person2);
        list.add(person3);
//        list.add(person4);
//        list.add(person5);
        return list;
    }
}