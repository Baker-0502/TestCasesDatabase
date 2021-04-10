import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.util.UUID;
public class PersonListTester {
    public static CriminalDatabaseApplication db = CriminalDatabaseApplication.getInstance();
    public static PersonList pl = PersonList.getInstance();

    @BeforeAll
    static void setup(){
        //db.createWitness(UUID.randomUUID(), "Colin", "Sandman", "Male", "White", 19, 62.6, 167.4, "8435051109", "1234 blue st", "worker", "NA", "saw accident and shooting");
        //db.saveAll();
    }

    @Test
    void findPersonByFirstNameCorrect()
    {
        Person findPerson = pl.findPersonFirst("Colin");
        assertNotNull(findPerson);
    }

    @Test
    void findPersonByFirstNameIncorrect()
    {
        pl.findPersonFirst("Hash");
        assertNull(pl);
    }

}
