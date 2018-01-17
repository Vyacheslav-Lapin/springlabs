package lab.model;

import java.util.List;

public interface Person {

    int getId();
    String getFirstName();
    String getLastName();
    Country getCountry();
    int getAge();
    float getHeight();
    boolean isProgrammer();
    List<String> getContacts();

    default String getName() {
        return String.format("%s %s", getFirstName(), getLastName());
    }

    default void sayHello(Person person) {
        System.out.printf("Hello, %s, I`m %s!",
                person.getName(),
                getName());
    }
}
