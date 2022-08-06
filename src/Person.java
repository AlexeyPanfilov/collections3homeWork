public class Person {

    protected String name;
    protected String lastName;
    protected int tickets;

    public Person (String name, String lastName, int tickets) {
        this.name = name;
        this.lastName = lastName;
        this.tickets = tickets;
    }

    public String toString () {
        return name + " " + lastName + ", " + tickets + " билетов";
    }

    public String printPersonalInfo () {
        return name + " " + lastName;
    }
}
