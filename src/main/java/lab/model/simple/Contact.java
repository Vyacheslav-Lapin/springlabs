package lab.model.simple;

import lombok.Value;

@Value
public class Contact {

    public enum Type { TELEPHONE, EMAIL }

    private Type type;
    private String value;
}
