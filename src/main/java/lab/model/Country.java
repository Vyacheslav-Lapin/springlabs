package lab.model;

import lombok.SneakyThrows;
import lombok.val;

public interface Country {
    int getId();
    String getName();
    String getCodeName();

    @SneakyThrows
    default Country setId(int i) {
        val field = this.getClass().getField("id");
        field.setAccessible(true);
        field.set(this, i);
        return this;
    }
}
