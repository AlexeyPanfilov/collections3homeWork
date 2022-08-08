import java.util.*;

public class Main {

    public static void main(String[] args) {
        Queue<Person> attraction = new LinkedList<>(generateClients());

        System.out.println(attraction + "\n");

        while (!attraction.isEmpty()) {
            attraction.peek().tickets--;
            Person p = attraction.poll();
            if (p.tickets > 0) {
                System.out.println(p.printPersonalInfo() + " прокатился на аттракционе. У него осталось билетов: " + p.tickets);
                attraction.offer(p);
            } else if (p.tickets == 0) {
                System.out.println(p.printPersonalInfo() + " прокатился на аттракционе в последний раз. У него не осталось билетов.");
            }
        }
    }

    static List<Person> generateClients() {
        Person person1 = new Person("Vasya", "Ivanov", 4);
        Person person2 = new Person("Kolya", "Petrov", 2);
        Person person3 = new Person("Pavel", "Yatsyna", 3);
        Person person4 = new Person("Leonel", "Messi", 5);
        Person person5 = new Person("Lewis", "Hamilton", 2);
        List<Person> list = new LinkedList<>();
        list.add(person1);
        list.add(person2);
        list.add(person3);
        list.add(person4);
        list.add(person5);
        return list;
    }
}