package model;

import entity.Person;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;
import java.util.Objects;

@XmlRootElement
public class People {

    private List<Person> listOfPeople;

    public People() {
    }

    public People(List<Person> listOfElements) {
        this.listOfPeople = listOfElements;
    }

    @XmlElement(name = "person")
    public List<Person> getListOfPeople() {
        return listOfPeople;
    }

    public void setListOfPeople(List<Person> listOfElements) {
        this.listOfPeople = listOfElements;
    }

    @Override
    public String toString() {
        return "People{" +
                "listOfPeople=" + listOfPeople +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        People people = (People) o;
        return Objects.equals(listOfPeople, people.listOfPeople);
    }

    @Override
    public int hashCode() {
        return Objects.hash(listOfPeople);
    }
}
