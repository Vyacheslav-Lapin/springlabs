package lab.model;

import org.springframework.stereotype.Component;

@Component
public class Customer implements Person {
    private String name;
    private boolean broke;

    public Customer(String name) {
        this.name = name;
    }

    public Customer(String name, boolean broke) {
        this.name = name;
        this.broke = broke;
    }

    public Customer() {
    }

    public String getName() {
        return this.name;
    }

    public boolean isBroke() {
        return this.broke;
    }

    public Customer setName(String name) {
        this.name = name;
        return this;
    }

    public Customer setBroke(boolean broke) {
        this.broke = broke;
        return this;
    }

    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof Customer)) return false;
        final Customer other = (Customer) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$name = this.getName();
        final Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) return false;
        if (this.isBroke() != other.isBroke()) return false;
        return true;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $name = this.getName();
        result = result * PRIME + ($name == null ? 43 : $name.hashCode());
        result = result * PRIME + (this.isBroke() ? 79 : 97);
        return result;
    }

    protected boolean canEqual(Object other) {
        return other instanceof Customer;
    }

    public String toString() {
        return "Customer(name=" + this.getName() + ", broke=" + this.isBroke() + ")";
    }
}
