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
        db.createWitness(UUID.randomUUID(), "Blop", "Whoo", "Male", "White", 999999999, 99999999999999999.999999999999999999, 99999999999999999.999999999999999999, "8435051109", "1234 blue st", "worker", "NA", "saw accident and shooting");
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
    void testSearchFirst_Incorrect() {
        ArrayList<Person> peopleFound = db.searchFirst("iuhawiudjpojmolnmaiwuidn");
        assertTrue(peopleFound.size() == 0);
    }

    @Test
    void testSearchFirst_Correct() {
        assertTrue(db.searchFirst("Blop").get(0) instanceof Person);
    }

    //searchLast test
    @Test
    void testSearchLast_Null() {
        assertEquals(db.searchLast(null), new ArrayList<Person>());
    }

    @Test
    void testSearchLast_ASCII() {
        Person personAscii = db.searchLast("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyzÀÁÂÃÄÅÆÇÈÉÊËÌÍÎÏÐÑÒÓÔÕÖØÙÚÛÜÝÞßàáâãäåæçèéêëìíîïð").get(0);
        assertTrue(personAscii instanceof Person);
    }

    @Test
    void testSearchLast_Correct() {
        assertTrue(db.searchLast("Whoo").get(0) instanceof Person);
    }

    //searchGender test
    @Test
    void testSearchGender_Null() {
        assertEquals(db.searchGender(null), new ArrayList<Person>());
    }

    @Test
    void testSearchGender_ASCII() {
        Person personAscii = db.searchGender("B").get(0);
        assertTrue(personAscii instanceof Person);
    }

    @Test
    void testSearchGender_Correct() {
        assertTrue(db.searchGender("Male").get(0) instanceof Person);
    }

    //seachRace test
    @Test
    void testSearchRace_Null() {
        assertEquals(db.searchRace(null), new ArrayList<Person>());
    }

    @Test
    void testSearchRace_ASCII() {
        Person personAscii = db.searchRace("C").get(0);
        assertTrue(personAscii instanceof Person);
    }

    @Test
    void testSearchRace_Correct() {
        assertTrue(db.searchRace("White").get(0) instanceof Person);
    }

    //searchAge test
    @Test
    void testSearchAge_Negative() {
        assertEquals(db.searchAge(-4), new ArrayList<Person>());
    }

    @Test
    void testSearchAge_Max() {
        Person personAscii = db.searchAge(999999999).get(0);
        assertTrue(personAscii instanceof Person);
    }

    @Test
    void testSearchAge_Correct() {
        assertTrue(db.searchAge(19).get(0) instanceof Person);
    }

    //searchHeight test
    @Test
    void testSearchHeight_Negative() {
        assertEquals(db.searchHeight(-4), new ArrayList<Person>());
    }

    @Test
    void testSearchHeight_Max() {
        Person personAscii = db.searchHeight(99999999999999999.999999999999999999).get(0);
        assertTrue(personAscii instanceof Person);
    }

    @Test
    void testSearchHeight_Correct() {
        assertTrue(db.searchHeight(62.6).get(0) instanceof Person);
    }

    //searchWeight test
    @Test
    void testSearchWeight_Negative() {
        assertEquals(db.searchWeight(-4), new ArrayList<Person>());
    }

    @Test
    void testSearchWeight_Max() {
        Person personAscii = db.searchWeight(99999999999999999.999999999999999999).get(0);
        assertTrue(personAscii instanceof Person);
    }

    @Test
    void testSearchWeight_Correct() {
        assertTrue(db.searchWeight(167.4).get(0) instanceof Person);
    }

    //searchPhone test
    @Test
    void testSearchPhone_Null() {
        assertEquals(db.searchPhone(null), new ArrayList<Person>());
    }

    @Test
    void testSearchPhone_ASCII() {
        Person personAscii = db.searchPhone("ADWAWD").get(0);
        assertTrue(personAscii instanceof Person);
    }

    @Test
    void testSearchPhone_Correct() {
        assertTrue(db.searchPhone("8435051109").get(0) instanceof Person);
    }

    //searchAddress test
    @Test
    void testSearchAddress_Null() {
        assertEquals(db.searchAddress(null), new ArrayList<Person>());
    }

    @Test
    void testSearchAddress_ASCII() {
        Person personAscii = db.searchAddress("AWDAWDAWDAWD").get(0);
        assertTrue(personAscii instanceof Person);
    }

    @Test
    void testSearchAddress_Correct() {
        assertTrue(db.searchAddress("1234 blue st").get(0) instanceof Person);
    }

    //searchOccupation test
    @Test
    void testSearchOccupation_Null() {
        assertEquals(db.searchOccupation(null), new ArrayList<Person>());
    }

    @Test
    void testSearchOccupation_ASCII() {
        Person personAscii = db.searchOccupation("ZXCZXCZXC").get(0);
        assertTrue(personAscii instanceof Person);
    }

    @Test
    void testSearchOccupation_Correct() {
        assertTrue(db.searchOccupation("worker").get(0) instanceof Person);
    }

    //searchBlood test
    @Test
    void testSearchBlood_Null() {
        assertEquals(db.searchBlood(null), new ArrayList<Person>());
    }

    @Test
    void testSearchBlood_ASCII() {
        Person personAscii = db.searchBlood("IOUHAWFIDJBHN").get(0);
        assertTrue(personAscii instanceof Person);
    }

    @Test
    void testSearchBlood_Correct() {
        assertTrue(db.searchBlood("NA").get(0) instanceof Person);
    }

    //searchHair test
    @Test
    void testSearchHair_Null() {
        assertEquals(db.searchHair(null), new ArrayList<Person>());
    }

    @Test
    void testSearchHair_ASCII() {
        Person personAscii = db.searchHair("IOUHAWFIDJBHN").get(0);
        assertTrue(personAscii instanceof Person);
    }

    @Test
    void testSearchHair_Correct() {
        assertTrue(db.searchHair("NA").get(0) instanceof Person);
    }
}
