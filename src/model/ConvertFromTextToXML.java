package model;

import entity.FamilyMember;
import entity.Person;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class ConvertFromTextToXML {


    public static void main(String args[]) {

        new ConvertFromTextToXML().convert();
    }

    private void convert() {
        BufferedReader in;
        try {

            //String filePath = "src\\data\\textToConvert";
            String filePath = "src\\data\\testFile";

            in = new BufferedReader(new InputStreamReader(new FileInputStream(filePath), "UTF-8"));

            People people = new People(parseTextToObject(in));
            convertListOfObjToXML(people);
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Converts a text file to a list of objects that is sent to the converter for XML
     *
     * First the elements are split using '|' as the regular expression,
     * the switch statement then checks if the first letter is either P,T, A or F
     *  and adds them to the correct person or family member list.
     *
     * @param in BufferedReader
     * @return List<Person>
     */
    private List<Person> parseTextToObject(BufferedReader in) {
        String str;
        Person person = new Person();

        FamilyMember familyMember = new FamilyMember();
        String[] elements;
        List<String> listOfLines = new LinkedList<>();
        List<Person> listOfPersons = new LinkedList<>();

        try{
            while ((str = in.readLine()) != null) {
                listOfLines.add(str);
            }

           for(String i: listOfLines){
               elements = i.split("\\|");


               switch (elements[0]){
                   case "P":
                       /*If familyMember.name isn't empty, there's no more information to add to a familyMember from a previous iteration,
                       * so we have to add that familyMember to the list, before doing the same check for a previous Person iteration.
                       * Once those are handled, we can start on parsing a new Person.
                       */
                       if(familyMember.getName() != null){
                           person.addFamilyMemberToList(familyMember);
                           familyMember = new FamilyMember();
                       }
                       if(person.getFirstName() != null){
                           listOfPersons.add(person);
                           person = new Person();
                       }
                       person.setFirstName(elements[1]);
                       person.setLastName(elements[2]);
                       break;

                   case "T":
                       /*Check if data still exists from a previous iteration, if there is, a new Person or FamilyMember has been found and
                        * the old will be added to the list. */
                       if(familyMember.getName() != null){
                           familyMember.setMobile_nr(elements[1]);
                           familyMember.setPhone_nr(elements[2]);
                       }else{
                           person.setMobile_nr(elements[1]);
                           person.setPhone_nr(elements[2]);
                       }
                       break;

                   case "A":
                       if(familyMember.getName() != null){
                           /* Checks if there is missing a postal number, if so it adds a null instead of the last element.*/
                           if (elements.length == 3){
                               familyMember.setAddress(elements[1], elements[2], null);
                           }else{
                               familyMember.setAddress(elements[1], elements[2], elements[3]);
                           }

                       }else{
                           /* Checks if there is missing a postal number, if so it adds a null instead of the last element.*/
                           if (elements.length == 3){
                               person.setAddress(elements[1], elements[2], null);
                           }else{
                               person.setAddress(elements[1], elements[2], elements[3]);
                           }
                       }
                       break;

                   case "F":
                       /* Same kind of check as in case 'P' */
                       if(familyMember.getName() != null){
                           person.addFamilyMemberToList(familyMember);
                           familyMember = new FamilyMember();
                       }
                       familyMember.setName(elements[1]);
                       familyMember.setBirthYear(elements[2] );
                       break;
               }
           }


            if(familyMember.getName() != null){
                /*Adds the last FamilyMember to the list of family members in Person*/
                person.addFamilyMemberToList(familyMember);
            }

            listOfPersons.add(person);

        }catch (Exception e) {
            e.printStackTrace();
        }
        return listOfPersons;
    }


    /**
     * Creates a data.xml file.
     * Takes a list of People containing a list of Persons and converts them from objects to XML
     * using JAXB Marshal
     *
     * @param elements People
     */
    private void convertListOfObjToXML(People elements) {

        try{

            String XMLpath = "src\\data\\data.xml";
            File file = new File(XMLpath); //creates the new file
            JAXBContext jaxbContext = JAXBContext.newInstance(People.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            /* Formats the xml output file */
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            jaxbMarshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
            jaxbMarshaller.marshal(elements, file);

        }catch (JAXBException e){
            e.printStackTrace();
        }
    }

}

