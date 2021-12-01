package entity;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;


@XmlRootElement(name = "person")
@XmlType(propOrder={"firstName" , "lastName", "mobile_nr", "phone_nr", "address" , "familyMemberList" })
public class Person {


    private String firstName;
    private String lastName;
    private String mobile_nr;
    private String phone_nr;
    private Address address;
    private List<FamilyMember> familyMemberList;


    public Person() {
        this.firstName = null;
        this.lastName = null;
        this.mobile_nr = null;
        this.phone_nr = null;
        this.address = null;
        this.familyMemberList = new LinkedList<>();
    }

    public Person(String firstName, String lastName, String mobile_nr, String phone_nr, String street, String city, String postal_nr) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.mobile_nr = mobile_nr;
        this.phone_nr = phone_nr;
        this.address = new Address(street, city , postal_nr);

    }

    public Person(String firstName, String lastName, String mobile_nr, String phone_nr, String street, String city, String postal_nr, List<FamilyMember> familyMemberList) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.mobile_nr = mobile_nr;
        this.phone_nr = phone_nr;
        this.address = new Address(street, city , postal_nr);
        this.familyMemberList = familyMemberList;
    }

    @XmlElement(name = "firstname")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @XmlElement(name = "lastname")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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
        this.address = new Address(street, city , postal_nr);
    }

    @XmlElement(name = "family")
    public List<FamilyMember> getFamilyMemberList() {
        return familyMemberList;
    }

    public void setFamilyMemberList(List<FamilyMember> familyMemberList) {
        this.familyMemberList = familyMemberList;
    }

    public void addFamilyMemberToList(FamilyMember familyMember){
        this.familyMemberList.add(familyMember);
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", mobile_nr='" + mobile_nr + '\'' +
                ", phone_nr='" + phone_nr + '\'' +
                ", address=" + address +
                ", familyMemberList=" + familyMemberList +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(firstName, person.firstName) &&
                Objects.equals(lastName, person.lastName) &&
                Objects.equals(mobile_nr, person.mobile_nr) &&
                Objects.equals(phone_nr, person.phone_nr) &&
                Objects.equals(address, person.address) &&
                Objects.equals(familyMemberList, person.familyMemberList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, mobile_nr, phone_nr, address, familyMemberList);
    }
}
