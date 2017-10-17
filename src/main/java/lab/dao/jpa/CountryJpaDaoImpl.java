package lab.dao.jpa;

import lab.dao.CountryDao;
import lab.model.Country;
import lab.model.simple.SimpleCountry;
import lombok.val;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CountryJpaDaoImpl extends AbstractJpaDao implements CountryDao {

    @Override
    public void save(Country country) {
        withEntityManagerUnderTransaction(em -> em.merge(country));
    }

    @Override
    public List<Country> getAllCountries() {
        return mapEntityManagerUnderTransaction(em ->
            em.createQuery("select c.codeName from Country c" , Country.class)
                    .getResultList());
    }

    @Override
    public Country getCountryByName(String name) {
//		TODO: Implement it

        return null;
    }

}
