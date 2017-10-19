package lab.dao.jpa;

import lab.dao.CountryDao;
import lab.model.Country;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CountryJpaDao extends AbstractJpaDao implements CountryDao {

    @Override
    public void save(@NotNull Country country) {
        withEntityManagerInTransaction(em -> em.merge(country));
    }

    @Override
    public List<Country> getAllCountries() {
        return mapEntityManager(em ->
                em.createQuery("select c from Country c", Country.class)
                        .getResultList());
    }

    @Override
    public Country getCountryByName(String name) {
        return mapEntityManager(em ->
                em.createQuery("select c from Country c where c.name like :name",
                        Country.class).setParameter("name", name)
                        .getSingleResult());
    }

}
