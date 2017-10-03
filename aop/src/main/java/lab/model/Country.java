package lab.model;

public class Country {

    private int id;
    private String name;
    private String codeName;

    public Country(int id, String name, String codeName) {
        this.id = id;
        this.name = name;
        this.codeName = codeName;
    }

    public Country() {
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getCodeName() {
        return this.codeName;
    }

    public Country setId(int id) {
        this.id = id;
        return this;
    }

    public Country setName(String name) {
        this.name = name;
        return this;
    }

    public Country setCodeName(String codeName) {
        this.codeName = codeName;
        return this;
    }

    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof Country)) return false;
        final Country other = (Country) o;
        if (!other.canEqual((Object) this)) return false;
        if (this.getId() != other.getId()) return false;
        final Object this$name = this.getName();
        final Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) return false;
        final Object this$codeName = this.getCodeName();
        final Object other$codeName = other.getCodeName();
        if (this$codeName == null ? other$codeName != null : !this$codeName.equals(other$codeName)) return false;
        return true;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        result = result * PRIME + this.getId();
        final Object $name = this.getName();
        result = result * PRIME + ($name == null ? 43 : $name.hashCode());
        final Object $codeName = this.getCodeName();
        result = result * PRIME + ($codeName == null ? 43 : $codeName.hashCode());
        return result;
    }

    protected boolean canEqual(Object other) {
        return other instanceof Country;
    }

    public String toString() {
        return "Country(id=" + this.getId() + ", name=" + this.getName() + ", codeName=" + this.getCodeName() + ")";
    }

//    public Country(String name, String codeName) {
//        this.name = name;
//        this.codeName = codeName;
//    }
}
