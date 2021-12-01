package entity;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;


@XmlType(propOrder={"name", "birthYear", "mobile_nr", "phone_nr", "address" })

public class FamilyMember {
   private String name;
   private String birthYear;
   private String mobile_nr;
   private String phone_nr;
   private Address address;
   private List<String> listOfAddresses = new LinkedList<>();


    public FamilyMember() {
        this.name = null;
        this.birthYear = null;
        this.mobile_nr = null;
        this.phone_nr = null;
        this.address = null;

    }

    public FamilyMember(String name, String birthYear){
        this.name = name;
        this.birthYear = birthYear;
    }

    public void setBirthYear(String birthYear) {
        this.birthYear = birthYear;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlElement(name = "born")
    public String getBirthYear() {
        return birthYear;
    }

    @XmlElement(name = "name")
    public String getName() {
        return name;
    }

    @XmlElement(name = "mobile")
    public String getMobile_nr() {
        return mobile_nr;
    }

    public void setMobile_nr(String mobile_nr) {
        this.mobile_nr = mobile_nr;
    }

    @XmlElement(name = "phone")
    public String getPhone_nr() {
        return phone_nr;
    }

    public void setPhone_nr(String phone_nr) {
        this.phone_nr = phone_nr;
    }

    @XmlElement(name = "address")
    public Address getAddress() {
        return address;
    }

    public void setAddress(String street, String city, String postal_nr) {
        this.address = new Address(street, city, postal_nr);
    }

    @Override
    public String toString() {
        return "FamilyMember{" +
                "name='" + name + '\'' +
                ", birthYear='" + birthYear + '\'' +
                ", mobile_nr='" + mobile_nr + '\'' +
                ", phone_nr='" + phone_nr + '\'' +
                ", address=" + address +
                ", listOfAddresses=" + listOfAddresses +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FamilyMember that = (FamilyMember) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(birthYear, that.birthYear) &&
                Objects.equals(mobile_nr, that.mobile_nr) &&
                Objects.equals(phone_nr, that.phone_nr) &&
                Objects.equals(address, that.address) &&
                Objects.equals(listOfAddresses, that.listOfAddresses);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, birthYear, mobile_nr, phone_nr, address, listOfAddresses);
    }
}
