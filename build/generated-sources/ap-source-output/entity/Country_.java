package entity;

import entity.City;
import entity.CountryLanguage;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-09-25T13:15:29")
@StaticMetamodel(Country.class)
public class Country_ { 

    public static volatile SingularAttribute<Country, String> region;
    public static volatile SingularAttribute<Country, String> headOfState;
    public static volatile SingularAttribute<Country, String> localName;
    public static volatile ListAttribute<Country, City> cityList;
    public static volatile SingularAttribute<Country, String> governmentForm;
    public static volatile SingularAttribute<Country, String> code;
    public static volatile SingularAttribute<Country, Integer> capital;
    public static volatile SingularAttribute<Country, Float> surfaceArea;
    public static volatile SingularAttribute<Country, Float> gNPOld;
    public static volatile SingularAttribute<Country, String> name;
    public static volatile SingularAttribute<Country, Float> lifeExpectancy;
    public static volatile SingularAttribute<Country, Float> gnp;
    public static volatile SingularAttribute<Country, String> continent;
    public static volatile SingularAttribute<Country, String> code2;
    public static volatile ListAttribute<Country, CountryLanguage> countryLanguageList;
    public static volatile SingularAttribute<Country, Short> indepYear;
    public static volatile SingularAttribute<Country, Integer> population;

}