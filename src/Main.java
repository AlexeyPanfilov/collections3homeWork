import javax.naming.PartialResultException;
import java.util.*;
import java.util.concurrent.ConcurrentLinkedDeque;

public class Main {

    public static void main(String[] args) {
        Queue<Person> attraction = new ConcurrentLinkedDeque<>();
        for (Person p : generateClients()) {
            attraction.offer(p);
        }
        System.out.println(attraction);

        while (attraction.size() > 0) {
           for (Person p : attraction) {
               //System.out.println(p);
               p.tickets--;
               if (p.tickets > 0) System.out.println(p.printPersonalInfo() + " прокатился на паровозике. У него осталось " +
                       p.tickets + " билетов.");
               if (p.tickets == 0) {
                   System.out.println("У " + p.printPersonalInfo() + " не осталось билетов.");
                   attraction.remove(p);

                   //System.out.println(attraction);
                   //System.out.println(attraction.element().tickets);
               }
           }
           //System.out.println(attraction);
        }
    }

    static List<Person> generateClients () {
        Person person1 = new Person("Vasya", "Ivanov", 5);
        Person person2 = new Person("Kolya", "Fuckin", 8);
        Person person3 = new Person("Borat", "Sagdiev", 7);
        Person person4 = new Person("Arthur", "Dzhikiya", 4);
        Person person5 = new Person("Vlad", "Tepes", 6);
        List<Person> list = new LinkedList<>();
        list.add(person1);
        list.add(person2);
        list.add(person3);
        list.add(person4);
        list.add(person5);
        return list;
    }
}