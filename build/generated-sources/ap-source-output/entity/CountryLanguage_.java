package entity;

import entity.Country;
import entity.CountryLanguagePK;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-09-25T13:15:29")
@StaticMetamodel(CountryLanguage.class)
public class CountryLanguage_ { 

    public static volatile SingularAttribute<CountryLanguage, CountryLanguagePK> countryLanguagePK;
    public static volatile SingularAttribute<CountryLanguage, Float> percentage;
    public static volatile SingularAttribute<CountryLanguage, String> isOfficial;
    public static volatile SingularAttribute<CountryLanguage, Country> country;

}