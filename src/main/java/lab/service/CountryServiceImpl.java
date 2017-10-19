package lab.service;

import java.util.List;

import lab.dao.CountryDao;
import lab.model.Country;

import lombok.Data;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.transaction.annotation.Propagation.*;

@Data
@Repository //is more convenient declaration for such a class than general @Service
@Transactional
public class CountryServiceImpl implements CountryService {

	@Autowired
	private CountryDao countryJdbcDao;

	@Override
	public List<Country> getAllCountriesInsideTransaction(Propagation propagation) {
		if (REQUIRED.equals(propagation)) {
			return getAllCountriesRequired();
		} else if (Propagation.REQUIRES_NEW.equals(propagation)) {
			return getAllCountriesRequiresNew();
		} else if (Propagation.SUPPORTS.equals(propagation)) {
			return getAllCountriesSupports();
		} else if (Propagation.NEVER.equals(propagation)) {
			return getAllCountriesNever();
		} else if (Propagation.MANDATORY.equals(propagation)) {
			return getAllCountriesMandatory();
		} else if (Propagation.NOT_SUPPORTED.equals(propagation)) {
			return getAllCountriesNotSupported();
		} else {
			return getAllCountries();
		}
	}

	@Override
    @Transactional(propagation = REQUIRED)
	public List<Country> getAllCountriesRequired() {
		return countryJdbcDao.getAllCountries();
	}

	@Override
    @Transactional(propagation = REQUIRES_NEW)
	public List<Country> getAllCountriesRequiresNew() {
		return countryJdbcDao.getAllCountries();
	}

	@Override
    @Transactional(propagation = SUPPORTS)
	public List<Country> getAllCountriesSupports() {
		return countryJdbcDao.getAllCountries();
	}

	@Override
    @Transactional(propagation = NEVER)
	public List<Country> getAllCountriesNever() {
		return countryJdbcDao.getAllCountries();
	}

	@Override
    @Transactional(propagation = MANDATORY)
	public List<Country> getAllCountriesMandatory() {
		return countryJdbcDao.getAllCountries();
	}

	@Override
    @Transactional(propagation = NOT_SUPPORTED)
	public List<Country> getAllCountriesNotSupported() {
		return countryJdbcDao.getAllCountries();
	}

	@Override
	public List<Country> getAllCountries() {
		return countryJdbcDao.getAllCountries();
	}
}
