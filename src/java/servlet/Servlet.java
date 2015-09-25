package servlet;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import entity.City;
import entity.Country;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Tobias Jacobsen
 */
@WebServlet(name = "Servlet", urlPatterns = {"/Servlet"})
public class Servlet extends HttpServlet {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU");
    EntityManager em = emf.createEntityManager();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("In doGet");

        String id = request.getParameter("id");
        TypedQuery<Country> query;
        List<Country> countryList;
        String jsonString = "";
        Gson gson = new Gson();
        switch (id) {

            case "all":
                //Get a list of all countries, with code, name, continent and the name of the capital
                query = em.createQuery("SELECT c.code, c.name, c.continent, c.capital FROM Country c", Country.class);
                countryList = query.getResultList();

                for (Country country : countryList) {
                    JsonObject quote = new JsonObject();
                    quote.addProperty("code", country.getCode());
                    jsonString = new Gson().toJson(quote);
                }
//                jsonString = gson.toJson(countryList);

                break;
            case "pop1000":
                //Get a list of all countries with a population greater than an number provided (return data as above)
                query = em.createQuery("SELECT c.code, c.name, c.continent, c.capital FROM Country c WHERE c.population > :p", Country.class);
                query.setParameter("p", id);
                countryList = query.getResultList();
                jsonString = gson.toJson(countryList);
                break;
            case "cityCountry":
                //Get a list of all cities in a country (provided the Country code) including name and population
                TypedQuery<City> query1 = em.createQuery("SELECT c.name, c.population FROM City c WHERE c.countryCode = :code", City.class);
                query1.setParameter("code", id);
                List<City> cityList = query1.getResultList();
                jsonString = gson.toJson(cityList);
                break;
        }

        System.out.println("jsonString: " + jsonString);
        response.setContentType("application/json");
        try (PrintWriter pw = response.getWriter()) {
            pw.print(jsonString);
            pw.flush();
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("In doPost");
        String cityInfo = request.getParameter("id");
        //Create a new city for a Country
        City city = new City();
        city.setName(null);
        city.setDistrict(null);
        city.setPopulation(0);
        city.setCountryCode(null);
        em.getTransaction().begin();
        em.persist(city);
        em.getTransaction().commit();
    }

}
