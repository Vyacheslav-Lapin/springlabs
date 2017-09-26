package lab.model;

import lombok.Value;

import java.io.Serializable;

@Value
public class Country {
	private int id;
    private String name;
    private String codeName;
}
