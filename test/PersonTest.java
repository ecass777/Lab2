import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PersonTest {
    private Person person;

    @BeforeEach
    public void setUp() {
        person = new Person("Elijah", "Cassidy", "123456", "Mr.", 2005);
    }

    @Test
    public void testFullName() {
        assertEquals("Elijah Cassidy", person.fullName());
    }

    @Test
    public void testFormalName() {
        assertEquals("Mr. Elijah Cassidy", person.formalName());
    }

    @Test
    public void testGetAge() {
        assertEquals(19, person.getAge(2024));  // assuming the current year is 2024
    }

    @Test
    public void testToCSV() {
        assertEquals("123456,Elijah,Cassidy,Mr.,2005", person.toCSV());
    }

    @Test
    public void testToJSON() {
        String expectedJson = "{ \"ID\": \"123456\", \"firstName\": \"Elijah\", \"lastName\": \"Cassidy\", \"title\": \"Mr.\", \"YOB\": 2005 }";
        assertEquals(expectedJson, person.toJSON());
    }

    @Test
    public void testToXML() {
        String expectedXml = "<Person><ID>123456</ID><firstName>Elijah</firstName><lastName>Cassidy</lastName><title>Mr.</title><YOB>2005</YOB></Person>";
        assertEquals(expectedXml, person.toXML());
    }

    @Test
    public void testEquals() {
        Person anotherPerson = new Person("Elijah", "Cassidy", "123456", "Mr.", 2005);
        assertEquals(person, anotherPerson);
    }
}
