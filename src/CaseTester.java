import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.util.UUID;
import java.util.ArrayList;

public class CaseTester {
    Case tester = new Case(null, false, null, false, false, false, null, null, null, null, null);
    public static boolean closedCase;
    public static boolean updateCase;
    public static boolean federalCase;

    @BeforeAll
    static void setup() {
        closedCase = true;
        updateCase = true;
        federalCase = true;
    }

    @Test
    void activeCaseTrue(){
        tester.updateCase(closedCase);
        assertTrue(closedCase);
    }

    @Test
    void activeCaseFalse(){
        closedCase = false;
        tester.updateCase(closedCase);
        assertFalse(closedCase);
    }

    @Test
    void updateCaseTrue(){
        tester.updateCase(updateCase);
        assertTrue(updateCase);
    }

    @Test
    void updateCaseFalse(){
        updateCase = false;
        tester.updateCase(updateCase);
        assertFalse(updateCase);
    }

    @Test
    void federalCaseTrue(){
        tester.updateFederalStatus(federalCase);
        assertTrue(federalCase);
    }

    @Test
    void federalCaseFalse(){
        federalCase = false;
        tester.updateFederalStatus(federalCase);
        assertFalse(federalCase);
    }

}
