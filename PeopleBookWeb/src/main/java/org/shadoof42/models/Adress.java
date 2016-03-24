package org.shadoof42.models;

/**
 * Created by Shadoof on 23.03.2016.
 */
public class Adress{
    private Long id;
    /**
     * Абонент
     */
    private Abonent abonent;
    /**
     * Почтовый индекс
     */
    private String post_index;
    /**
     * Город
     */
    private String city;
    /**
     * Улица
     */
    private String street;
    /**
     * Дом
     */
    private String house;
    /**
     * квартира
     */
    private String apartment;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Abonent getAbonent() {
        return abonent;
    }

    public void setAbonent(Abonent abonent) {
        this.abonent = abonent;
    }

    public String getPost_index() {
        return post_index;
    }

    public void setPost_index(String post_index) {
        this.post_index = post_index;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    public String getApartment() {
        return apartment;
    }

    public void setApartment(String apartment) {
        this.apartment = apartment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Adress adress = (Adress) o;

        if (!abonent.equals(adress.abonent)) return false;
        if (!post_index.equals(adress.post_index)) return false;
        if (!city.equals(adress.city)) return false;
        if (street != null ? !street.equals(adress.street) : adress.street != null) return false;
        if (house != null ? !house.equals(adress.house) : adress.house != null) return false;
        return !(apartment != null ? !apartment.equals(adress.apartment) : adress.apartment != null);

    }

    @Override
    public int hashCode() {
        int result = abonent.hashCode();
        result = 31 * result + post_index.hashCode();
        result = 31 * result + city.hashCode();
        result = 31 * result + (street != null ? street.hashCode() : 0);
        result = 31 * result + (house != null ? house.hashCode() : 0);
        result = 31 * result + (apartment != null ? apartment.hashCode() : 0);
        return result;
    }
}
