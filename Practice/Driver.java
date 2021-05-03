public class Driver {
    public static void main(String[] args) {
        Person aPerson = new Person(0);
        aPerson.printAge();

        aPerson.setAge(28);
        aPerson.printAge();
    }
}
