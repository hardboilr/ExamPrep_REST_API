package facade;

import dto.CityDTO;
import dto.CountryDTO;
import entity.City;
import entity.Country;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

public class Controller {

    private final EntityManagerFactory emf;

    public Controller(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public List<CountryDTO> getAllCountries(String population) {
        EntityManager em = getEntityManager();
        List<Country> countries = new ArrayList();
        List<CountryDTO> countriesDTO = new ArrayList();
        try {
            TypedQuery<Country> query = null;
            if (population.isEmpty()) {
                query = em.createNamedQuery("Country.findAll", Country.class);
            } else {
                int pop = 0;
                try {
                    pop = Integer.parseInt(population);
                    query = em.createNamedQuery("Country.findByPopulationGreaterThan", Country.class).setParameter("population", pop);
                } catch (NumberFormatException ex) {
//                    throw new InvalidInputException("Could not find any countries with population greater than: " + population);
                }
            }
            countries = query.getResultList();
            System.out.println("Countries size: " + countries.size());
            if (countries.isEmpty()) {
//                throw new ServerException("Could not find any countries"));
            } else {
                for (Country country : countries) {
                    String na = "Data not available";
                    if (country.getCode() == null || country.getCode().isEmpty()) {
                        country.setCode(na);
                    }
                    if (country.getName() == null || country.getName().isEmpty()) {
                        country.setName(na);
                    }
                    if (country.getContinent() == null || country.getContinent().isEmpty()) {
                        country.setContinent(na);
                    }
                    if (country.getCapital() == null) {
                        country.setCapital(0);
                    }
                    CountryDTO dto = new CountryDTO(country.getCode(), country.getName(), country.getContinent(), country.getCapital());
                    countriesDTO.add(dto);
                }
            }
        } finally {
            em.close();
        }
        return countriesDTO;
    }

    public List<CityDTO> getAllCitiesInCountry(String countryCode) {
        EntityManager em = getEntityManager();
        List<City> cities = new ArrayList();
        List<CityDTO> citiesDTO = new ArrayList();
        Country country = new Country();
        country.setCode(countryCode);
        try {
            TypedQuery<City> query = em.createNamedQuery("City.findByCountryCode", City.class).setParameter("countryCode", country);
            cities = query.getResultList();
            if (cities.isEmpty()) {
                //throw new ServerException("Could not find any cities with country code: " + countryCode);
            } else {
                for (City city : cities) {
                    CityDTO dto = new CityDTO(city.getName(), city.getDistrict(), city.getPopulation());
                    citiesDTO.add(dto);
                }
            }
        } finally {
            em.close();
        }
        return citiesDTO;
    }

    public CityDTO createCity(CityDTO dto) {
        EntityManager em = getEntityManager();
        List<City> cities = new ArrayList();
        try {
            TypedQuery<City> query = em.createNamedQuery("City.findByName", City.class).setParameter("name", dto.getName());
            cities = query.getResultList();
            if (cities.isEmpty()) {
                Country country = em.find(Country.class, dto.getCountryCode());
                if (country == null) {
                    //throw new ServerException("Invalid country code: " + dto.getCountryCode());
                } else {
                    City city = new City();
                    city.setName(dto.getName());
                    city.setDistrict(dto.getDistrict());
                    city.setPopulation(dto.getPopulation());
                    city.setCountryCode(country);
                    em.getTransaction().begin();
                    em.persist(city);
                    em.getTransaction().commit();
                }
                
            } else {
                //throw new ServerException("City already exists: " + dto.getName());
            }
        } finally {
            em.close();
        }
        return dto;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
}
