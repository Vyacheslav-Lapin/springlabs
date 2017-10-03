package lab.model;

import java.util.List;

public class UsualPerson implements Person {
    private int id;
    private String name;
    private Country country;
    private int age;
    private float height;
    private boolean isProgrammer;
    private List<String> contacts;

    public UsualPerson(int id, String name, Country country, int age, float height, boolean isProgrammer, List<String> contacts) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.age = age;
        this.height = height;
        this.isProgrammer = isProgrammer;
        this.contacts = contacts;
    }

    public UsualPerson() {
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public Country getCountry() {
        return this.country;
    }

    public int getAge() {
        return this.age;
    }

    public float getHeight() {
        return this.height;
    }

    public boolean isProgrammer() {
        return this.isProgrammer;
    }

    public List<String> getContacts() {
        return this.contacts;
    }

    public UsualPerson setId(int id) {
        this.id = id;
        return this;
    }

    public UsualPerson setName(String name) {
        this.name = name;
        return this;
    }

    public UsualPerson setCountry(Country country) {
        this.country = country;
        return this;
    }

    public UsualPerson setAge(int age) {
        this.age = age;
        return this;
    }

    public UsualPerson setHeight(float height) {
        this.height = height;
        return this;
    }

    public UsualPerson setProgrammer(boolean isProgrammer) {
        this.isProgrammer = isProgrammer;
        return this;
    }

    public UsualPerson setContacts(List<String> contacts) {
        this.contacts = contacts;
        return this;
    }

    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof UsualPerson)) return false;
        final UsualPerson other = (UsualPerson) o;
        if (!other.canEqual((Object) this)) return false;
        if (this.getId() != other.getId()) return false;
        final Object this$name = this.getName();
        final Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) return false;
        final Object this$country = this.getCountry();
        final Object other$country = other.getCountry();
        if (this$country == null ? other$country != null : !this$country.equals(other$country)) return false;
        if (this.getAge() != other.getAge()) return false;
        if (Float.compare(this.getHeight(), other.getHeight()) != 0) return false;
        if (this.isProgrammer() != other.isProgrammer()) return false;
        final Object this$contacts = this.getContacts();
        final Object other$contacts = other.getContacts();
        if (this$contacts == null ? other$contacts != null : !this$contacts.equals(other$contacts)) return false;
        return true;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        result = result * PRIME + this.getId();
        final Object $name = this.getName();
        result = result * PRIME + ($name == null ? 43 : $name.hashCode());
        final Object $country = this.getCountry();
        result = result * PRIME + ($country == null ? 43 : $country.hashCode());
        result = result * PRIME + this.getAge();
        result = result * PRIME + Float.floatToIntBits(this.getHeight());
        result = result * PRIME + (this.isProgrammer() ? 79 : 97);
        final Object $contacts = this.getContacts();
        result = result * PRIME + ($contacts == null ? 43 : $contacts.hashCode());
        return result;
    }

    protected boolean canEqual(Object other) {
        return other instanceof UsualPerson;
    }

    public String toString() {
        return "UsualPerson(id=" + this.getId() + ", name=" + this.getName() + ", country=" + this.getCountry() + ", age=" + this.getAge() + ", height=" + this.getHeight() + ", isProgrammer=" + this.isProgrammer() + ", contacts=" + this.getContacts() + ")";
    }
}