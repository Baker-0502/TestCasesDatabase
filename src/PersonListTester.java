import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.util.UUID;
public class PersonListTester {
    public static CriminalDatabaseApplication db = CriminalDatabaseApplication.getInstance();
    public static PersonList pl = PersonList.getInstance();

    /**
     * Testing all finding methods
     */
    @BeforeAll
    static void setup(){
        db.createWitness(UUID.randomUUID(), "thisisbrandnew", "Tester", "Male", "White", 19, 62.6, 167.4, "8435051109", "1234 blue st", "worker", "NA", "saw accident and shooting");
        db.saveAll();
    }
    

    @Test
    void findPersonByFirstNameCorrect()
    {
        Person findPerson = db.searchFirst("thisisbrandnew").get(0);
        assertNotNull(findPerson);
    }

    @Test
    void findPersonByFirstNameIncorrect()
    {
        Person findPerson = db.searchFirst("thisisbrandnew").get(0);
        assertNull(findPerson);
    }

    @Test
    void findPersonByFirstNameNull()
    {
        Person findPersonNull = db.searchFirst(null).get(0);
        assertNull(findPersonNull);
    }

    @Test
    void findPersonByLastNameCorrect(){
        Person findPerson = db.searchLast("Tester").get(0);
        assertNotNull(findPerson);
    }

}
