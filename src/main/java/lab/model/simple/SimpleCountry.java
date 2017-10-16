package lab.model.simple;

import lab.model.Country;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class SimpleCountry implements Country {
	@Id
    private int id;
    private String name;
    private String codeName;
}
