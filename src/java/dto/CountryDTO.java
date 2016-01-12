package dto;

public class CountryDTO {

    private String code;
    private String name;
    private String continent;
    private int capital;

    public CountryDTO(String code, String name, String continent, int capital) {
        this.code = code;
        this.name = name;
        this.continent = continent;
        this.capital = capital;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public int getCapital() {
        return capital;
    }

    public void setCapital(int capital) {
        this.capital = capital;
    }
}
