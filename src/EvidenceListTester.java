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
    void findEvidenceIDCorrect(){
        User getEvidenceID = db.getEvidenceID("IDtest");
        assertNotNull(getEvidenceID);
    }

    @Test
    void findEvidenceIDInorrect(){
        User getEvidenceID = db.getEvidenceID("IDtest");
        assertNull(getEvidenceID);
    }

}
