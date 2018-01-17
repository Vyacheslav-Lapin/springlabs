package lab.dao;

import lab.model.Country;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public interface CountryDao {
    void save(@NotNull Country country);

    List<Country> getAllCountries();

    default Country getCountryByName(String name) throws CountryNotFoundException {

        int x = 10;
        switch (x) {
            case 20:
                System.out.println("20");
            case 30:
                System.out.println("30");
            default:
                System.out.println("default");
            case 10:
                System.out.println("10");
            case 40:
                System.out.println("40");
        }

        return getAllCountries().stream()
                .filter(country -> country.getName().equals(name))
                .findAny()
                .orElseThrow(CountryNotFoundException::new);
    }


}