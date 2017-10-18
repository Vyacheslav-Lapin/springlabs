package lab.dao;

import java.util.List;

import lab.model.Country;
import org.jetbrains.annotations.NotNull;

public interface CountryDao {
	void save(@NotNull Country country);

	List<Country> getAllCountries();

	default Country getCountryByName(String name) throws CountryNotFoundException {
		return getAllCountries().stream()
				.filter(country -> country.getName().equals(name))
				.findAny()
				.orElseThrow(CountryNotFoundException::new);
	}
}