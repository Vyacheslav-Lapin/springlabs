package lab.dao.jdbc;

import lab.dao.CountryDao;
import lab.dao.CountryNotFoundException;
import lab.model.Country;
import lab.model.simple.SimpleCountry;
import lombok.val;
import org.jetbrains.annotations.NotNull;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

@Repository
public class CountryJdbcDao extends NamedParameterJdbcDaoSupport implements CountryDao {
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

    //language=H2
    private static final String SAVE_COUNTRY_SQL = "INSERT INTO country (name, code_name) VALUES (?, ?);";
    //language=H2
    private static final String GET_ALL_COUNTRIES_SQL = "SELECT id, name, code_name FROM country";
    //language=H2
    private static final String GET_COUNTRIES_BY_NAME_SQL = "SELECT id, name, code_name FROM country WHERE name LIKE :name";
    //language=H2
    private static final String GET_COUNTRY_BY_NAME_SQL = "SELECT id, name, code_name FROM country WHERE name='%s'";
    //language=H2
    private static final String GET_COUNTRY_BY_CODE_NAME_SQL = "SELECT id, name, code_name FROM country WHERE code_name = '%s'";
    //language=H2
    private static final String UPDATE_COUNTRY_NAME_SQL = "UPDATE country SET name='%s' WHERE code_name='%s'";

    private static final RowMapper<Country> COUNTRY_ROW_MAPPER = (rs, i) -> new SimpleCountry(
            rs.getInt("id"),
            rs.getString("name"),
            rs.getString("code_name"));

    public CountryJdbcDao(DataSource dataSource) {
        setDataSource(dataSource);
    }

    public List<Country> getAllCountries() {
        return getJdbcTemplate().query(
                GET_ALL_COUNTRIES_SQL,
                COUNTRY_ROW_MAPPER);
    }

    public List<Country> getCountryListStartWith(String name) {
        return getNamedParameterJdbcTemplate().query(
                GET_COUNTRIES_BY_NAME_SQL,
                new MapSqlParameterSource(
                        "name", name + "%"),
                COUNTRY_ROW_MAPPER);
    }

    public void updateCountryName(String codeName, String newCountryName) {
        getJdbcTemplate().update(String.format(
                UPDATE_COUNTRY_NAME_SQL, newCountryName, codeName));
    }

//    @PostConstruct
    public void loadCountries() {
        for (String[] countryData : COUNTRY_INIT_DATA)
            getJdbcTemplate().update(
                    SAVE_COUNTRY_SQL, countryData[0], countryData[1]);
    }

    public Country getCountryByCodeName(String codeName) {
        return getJdbcTemplate().query(
                String.format(GET_COUNTRY_BY_CODE_NAME_SQL, codeName),
                COUNTRY_ROW_MAPPER)
                .get(0);
    }

    @Override
    public void save(@NotNull Country country) {
        val keyHolder = new GeneratedKeyHolder();
        getJdbcTemplate().update(con -> {
            val preparedStatement = con.prepareStatement(
                    SAVE_COUNTRY_SQL,
                    Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, country.getName());
            preparedStatement.setString(2, country.getCodeName());
            return preparedStatement;
        }, keyHolder);
        country.setId(keyHolder.getKey().intValue());
//                String.format(SAVE_COUNTRY_SQL, country.getName(), country.getCodeName()));
    }

    @Override
    public Country getCountryByName(String name) throws CountryNotFoundException {
        List<Country> countryList = getJdbcTemplate().query(
                String.format(GET_COUNTRY_BY_NAME_SQL, name),
                COUNTRY_ROW_MAPPER);
        if (countryList.isEmpty()) {
            throw new CountryNotFoundException();
        }
        return countryList.get(0);
    }
}
