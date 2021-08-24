package validating;

public class Person {

    private String name;
    private int age;

    public Person(String name, int age) {
        
        if ((name != null && name.length() <= 40) && (age >= 0 && age <= 120) && (!name.equals(""))){
            this.name = name;
            this.age = age;
        } else {
            throw new IllegalArgumentException("Name cannot be blank or over 40 characters.");
        }
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}