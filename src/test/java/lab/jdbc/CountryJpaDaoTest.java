package lab.jdbc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import lab.dao.CountryDao;
import lab.model.Country;
import lab.model.simple.SimpleCountry;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/**
 * Illustrates basic use of Hibernate as a JPA provider.
 */
@Log4j2
@ExtendWith(SpringExtension.class)
@ContextConfiguration("classpath:orm.xml")
class CountryJpaDaoTest {

	private Country exampleCountry = new SimpleCountry(1, "Australia", "AU");

	@Autowired
	private CountryDao countryJpaDao;

	@Test
    @DirtiesContext
    void testSaveCountry() {
        countryJpaDao.save(exampleCountry);
		List<Country> countryList = countryJpaDao.getAllCountries();
		assertTrue(countryList.size() < 3);
		assertEquals(exampleCountry, countryList.get(0));
	}

	@Test
    @DirtiesContext
    void testGetAllCountries() {
        countryJpaDao.save(exampleCountry);
		countryJpaDao.save(new SimpleCountry(2, "Canada", "CA"));

		List<Country> countryList = countryJpaDao.getAllCountries();
		assertEquals(2, countryList.size());
	}

	@Test
	@SneakyThrows
    @DirtiesContext
    void testGetCountryByName() {
        countryJpaDao.save(exampleCountry);
		Country country = countryJpaDao.getCountryByName("Australia");
		assertEquals(exampleCountry, country);
	}

}
