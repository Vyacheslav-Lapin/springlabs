import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import lab.dao.CountryDao;
import lab.dao.CountryJdbcDao;
import lab.model.Country;
import lab.model.simple.SimpleCountry;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/**
 * Illustrates basic use of Hibernate as a JPA provider.
 */
@Log4j2
@ExtendWith(SpringExtension.class)
@ContextConfiguration("classpath:orm.xml")
class CountryDaoImplTest {

	private Country exampleCountry = new SimpleCountry(1, "Australia", "AU");

	@Autowired
	private CountryDao countryJpaDao;

	@Test
    void testSaveCountry() {

		countryJpaDao.save(exampleCountry);

		List<Country> countryList = countryJpaDao.getAllCountries();
		assertEquals(1, countryList.size());
		assertEquals(exampleCountry, countryList.get(0));
	}

	@Test
    void testGtAllCountries() {

		countryJpaDao.save(new SimpleCountry(1, "Canada", "CA"));

		List<Country> countryList = countryJpaDao.getAllCountries();
		assertEquals(2, countryList.size());
	}

	@Test
	@SneakyThrows
    void testGetCountryByName() {
		Country country = countryJpaDao.getCountryByName("Australia");
		assertEquals(exampleCountry, country);
	}

}
