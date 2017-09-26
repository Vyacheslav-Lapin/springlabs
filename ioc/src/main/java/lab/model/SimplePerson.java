package lab.model;

import lombok.Value;

import java.util.List;

@Value
public class SimplePerson implements Person {
    private int id;
    private String name;
    private Country country;

    private int age;
    private float height;
    private boolean isProgrammer;

    private List<String> contacts;

    @Override
    public void sayHello(Person person) {
    }
}