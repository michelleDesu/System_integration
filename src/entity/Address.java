package entity;

import javax.xml.bind.annotation.XmlElement;
import java.util.Objects;

public class Address {
    private String street;
    private String city;
    private String postal_nr;

    public Address() {
    }

    public Address(String street, String city, String postal_nr) {
        this.street = street;
        this.city = city;
        this.postal_nr = postal_nr;
    }

    @XmlElement(name = "street")
    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    @XmlElement(name = "city")
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @XmlElement(name = "postal")
    public String getPostal_nr() {
        return postal_nr;
    }

    public void setPostal_nr(String postal_nr) {
        this.postal_nr = postal_nr;
    }

    @Override
    public String toString() {
        return "Address{" +
                "street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", postal_nr='" + postal_nr + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return Objects.equals(street, address.street) &&
                Objects.equals(city, address.city) &&
                Objects.equals(postal_nr, address.postal_nr);
    }

    @Override
    public int hashCode() {
        return Objects.hash(street, city, postal_nr);
    }
}
