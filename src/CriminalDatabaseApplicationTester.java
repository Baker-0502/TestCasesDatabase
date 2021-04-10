import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.util.UUID;

import java.util.ArrayList;
public class CriminalDatabaseApplicationTester {
    public static CriminalDatabaseApplication db = CriminalDatabaseApplication.getInstance();

    @BeforeAll
    static void setup() {
        db.createAdmin(UUID.randomUUID(), "Randy", "Briggs", "rbriggs", "IAmATest", "rbriggs@gmail.com", "8023949949", "Sumter County", true);
        db.createWitness(UUID.randomUUID(), "Blop", "Whoo", "Male", "White", 19, 62.6, 167.4, "8435051109", "1234 blue st", "worker", "NA", "saw accident and shooting");
        db.createAdmin(UUID.randomUUID(), "", "", "", "", "", "", " ", false);
        db.createVictim(UUID.randomUUID(), "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyzÀÁÂÃÄÅÆÇÈÉÊËÌÍÎÏÐÑÒÓÔÕÖØÙÚÛÜÝÞßàáâãäåæçèéêëìíîïð","ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyzÀÁÂÃÄÅÆÇÈÉÊËÌÍÎÏÐÑÒÓÔÕÖØÙÚÛÜÝÞßàáâãäåæçèéêëìíîïð","B","C", 0, 22, 22, "ADWAWD", "AWDAWDAWDAWD", "ZXCZXCZXC", "IOUHAWFIDJBHN", "OIHJAo:iwJDOIJAWD\t\t\t0");
        db.saveAll();
        //UUID userID, String firstName, String lastName, String username, String password, String email, String phoneNumber, String department, boolean updateCase
    }
    
    //test Login
    @Test
    void testLogin_Null() {
        User loginNull = db.login(null,null);
        assertNull(loginNull);
    }

    @Test
    void testLogin_Empty() {
        User loginEmpty = db.login("","");
        assertTrue(loginEmpty instanceof User);
    }

    @Test
    void testLogin_Correct() {
        User login = db.login("rbriggs", "IAmATest");
        assertTrue(login instanceof User);
    }

    //searchFirst Tests
    //ADDED FIX, ALL ADD METHODS NEED TO ADD TO PERSON LIST. FIX BEFORE CHANGE
    @Test
    void testSearchFirst_Null() {
        assertEquals(db.searchFirst(null), new ArrayList<Person>());
    }

    @Test
    void testSearchFirst_ASCII() {
        Person personAscii = db.searchFirst("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyzÀÁÂÃÄÅÆÇÈÉÊËÌÍÎÏÐÑÒÓÔÕÖØÙÚÛÜÝÞßàáâãäåæçèéêëìíîïð").get(0);
        assertTrue(personAscii instanceof Person);
    }

    @Test
    void testSearchFirst_Correct() {
        assertTrue(db.searchFirst("Blop").get(0) instanceof Person);
    }
}
