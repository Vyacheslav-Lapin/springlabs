package lab.dao;

import lab.model.Country;
import lab.model.simple.SimpleCountry;
import lombok.val;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;

import javax.annotation.PostConstruct;
import java.util.List;

public class CountryDao extends NamedParameterJdbcDaoSupport {
    // language=H2
    private static final String LOAD_COUNTRIES_SQL = "INSERT INTO country (name, code_name) VALUES ('%s', '%s');";
    // language=H2
    private static final String GET_ALL_COUNTRIES_SQL = "SELECT id, name, code_name FROM country";
    // language=H2
    private static final String GET_COUNTRIES_BY_NAME_SQL = "SELECT id, name, code_name FROM country WHERE name LIKE :name";
    // language=H2
    private static final String GET_COUNTRY_BY_NAME_SQL = "select id, name, code_name from country where name = '%s'";
    // language=H2
    private static final String GET_COUNTRY_BY_CODE_NAME_SQL = "select id, name, code_name from country where code_name = '%s'";
    // language=H2
    private static final String UPDATE_COUNTRY_NAME_SQL = "UPDATE country SET name='%s' WHERE code_name='%s'";

    public static final String[][] COUNTRY_INIT_DATA = {
            {"Australia", "AU"},
            {"Canada", "CA"},
            {"France", "FR"},
            {"Hong Kong", "HK"},
            {"Iceland", "IC"},
            {"Japan", "JP"},
            {"Nepal", "NP"},
            {"Russian Federation", "RU"},
            {"Sweden", "SE"},
            {"Switzerland", "CH"},
            {"United Kingdom", "GB"},
            {"United States", "US"}};

    private static final RowMapper<Country> COUNTRY_ROW_MAPPER = (rs, __) -> new SimpleCountry(
            rs.getInt("id"),
            rs.getString("name"),
            rs.getString("code_name"));

    public List<Country> getCountryList() {
        return getJdbcTemplate().query(GET_ALL_COUNTRIES_SQL, COUNTRY_ROW_MAPPER);
    }

    public List<Country> getCountryListStartWith(String name) {
        val sqlParameterSource = new MapSqlParameterSource(
                "name", name + "%");
        return getNamedParameterJdbcTemplate().query(GET_COUNTRIES_BY_NAME_SQL,
                sqlParameterSource, COUNTRY_ROW_MAPPER);
    }

    public void updateCountryName(String codeName, String newCountryName) {
        getJdbcTemplate().update(String.format(
                UPDATE_COUNTRY_NAME_SQL, newCountryName, codeName));
    }

    @PostConstruct
    public void loadCountries() {
        for (String[] countryData : COUNTRY_INIT_DATA) {
            String sql = String.format(LOAD_COUNTRIES_SQL, countryData[0], countryData[1]);
            getJdbcTemplate().execute(sql);
        }
    }

    public Country getCountryByCodeName(String codeName) {
        JdbcTemplate jdbcTemplate = getJdbcTemplate();

        String sql = GET_COUNTRY_BY_CODE_NAME_SQL + codeName + "'";
//		System.out.println(sql);

        return jdbcTemplate.query(sql, COUNTRY_ROW_MAPPER).get(0);
    }

    public Country getCountryByName(String name)
            throws CountryNotFoundException {
        JdbcTemplate jdbcTemplate = getJdbcTemplate();
        List<Country> countryList = jdbcTemplate.query(GET_COUNTRY_BY_NAME_SQL
                + name + "'", COUNTRY_ROW_MAPPER);
        if (countryList.isEmpty()) {
            throw new CountryNotFoundException();
        }
        return countryList.get(0);
    }
}
