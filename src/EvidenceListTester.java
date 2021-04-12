import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.util.UUID;

public class EvidenceListTester {
    public static CriminalDatabaseApplication db = CriminalDatabaseApplication.getInstance();
    public static EvidenceList el = EvidenceList.getInstance();

    @BeforeAll
    static void setup(){
        db.createEvidence(UUID.randomUUID(), "type", "location");
        db.saveAll();
    }

    @Test
    void findEvidenceCorrect(){
        Evidence getevidenceID = db.findEvidence("IDtest");
        assertNotNull(getevidenceID);
    }

    @Test
    void findEvidenceIncorrect(){
        Evidence getevidenceID = db.findEvidence("IDtest");
        assertNull(getevidenceID);
    }
    @Test
    void findEvidenceNull(){
        Evidence findevidenceID = db.findEvidence(null);
        assertNull(findevidenceID);
    }


}
