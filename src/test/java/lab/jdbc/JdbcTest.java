package lab.jdbc;

import java.util.ArrayList;
import java.util.List;

import lab.dao.CountryJdbcDao;
import lab.model.Country;

import lab.model.simple.SimpleCountry;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class)
@ContextConfiguration("classpath:jdbc.xml")
class JdbcTest{

	@Autowired
	private CountryJdbcDao countryJdbcDao;
	
    private List<Country> expectedCountryList = new ArrayList<>();
    private List<Country> expectedCountryListStartsWithA = new ArrayList<>();
    private Country countryWithChangedName = new SimpleCountry(8, "Russia", "RU");

    @BeforeEach
    void setUp() {
        initExpectedCountryLists();
        countryJdbcDao.loadCountries();
    }

    
    @Test
    @DirtiesContext
    void testCountryList() {
        List<Country> countryList = countryJdbcDao.getCountryList();
        assertNotNull(countryList);
        assertEquals(expectedCountryList.size(), countryList.size());
        for (int i = 0; i < expectedCountryList.size(); i++) {
            assertEquals(expectedCountryList.get(i), countryList.get(i));
        }
    }

    @Test
    @DirtiesContext
    void testCountryListStartsWithA() {
        List<Country> countryList = countryJdbcDao.getCountryListStartWith("A");
        assertNotNull(countryList);
        assertEquals(expectedCountryListStartsWithA.size(), countryList.size());
        for (int i = 0; i < expectedCountryListStartsWithA.size(); i++) {
            assertEquals(expectedCountryListStartsWithA.get(i), countryList.get(i));
        }
    }

    @Test
    @DirtiesContext
    void testCountryChange() {
        countryJdbcDao.updateCountryName("RU", "Russia");
        assertEquals(countryWithChangedName, countryJdbcDao.getCountryByCodeName("RU"));
    }

    private void initExpectedCountryLists() {
         for (int i = 0; i < CountryJdbcDao.COUNTRY_INIT_DATA.length;) {
             String[] countryInitData = CountryJdbcDao.COUNTRY_INIT_DATA[i];
             Country country = new SimpleCountry(++i, countryInitData[0], countryInitData[1]);
             expectedCountryList.add(country);
             if (country.getName().startsWith("A")) {
                 expectedCountryListStartsWithA.add(country);
             }
         }
     }
}