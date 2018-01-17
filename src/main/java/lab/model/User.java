package lab.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class User {
	
	private int id;
	
	private final String firstName;
	
	private final String lastName;

}
