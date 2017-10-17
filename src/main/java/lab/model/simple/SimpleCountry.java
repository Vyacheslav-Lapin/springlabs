package lab.model.simple;

import lab.model.Country;
import lombok.*;

import javax.persistence.*;

@Entity(name = "Country")
@Table(name = "country")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SimpleCountry implements Country {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String codeName;
}



