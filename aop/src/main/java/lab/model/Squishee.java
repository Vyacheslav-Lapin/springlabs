package lab.model;

public class Squishee {
    private String name;

    public Squishee(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof Squishee)) return false;
        final Squishee other = (Squishee) o;
        final Object this$name = this.getName();
        final Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) return false;
        return true;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $name = this.getName();
        result = result * PRIME + ($name == null ? 43 : $name.hashCode());
        return result;
    }

    public String toString() {
        return "Squishee(name=" + this.getName() + ")";
    }
}
