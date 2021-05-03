public class Person {
    private int age = -1;

    private String name = "";

    public Person(int newAge) {
        int age; // Shadows/hides attribute
        age = newAge;
    }

    public void setAge(int newAge) { // Shadow/hide attribute
        
        age = newAge;
    }

    public void printAge() {
        System.out.println(age);
    }
}