import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.util.UUID;

public class UserListTester {
    public static CriminalDatabaseApplication db = CriminalDatabaseApplication.getInstance();
    public static UserList ul = UserList.getInstance();

    @BeforeAll
    static void setup(){
        db.createAdmin(UUID.randomUUID(), "Andrew", "Stokes", "astokes", "testing", "astokes", "1234567890", "columbia", true);
        db.saveAll();
    }

    @Test
    void findUserNameCorrect(){
        User getUser = db.findUser("astokes");
        assertNotNull(getUser);
    }

    @Test
    void findUserNameInorrect(){
        User getUser = db.findUser("stoke");
        assertNull(getUser);
    }

    @Test
    void findUserNameNull(){
        User getUser = db.findUser(null);
        assertNull(getUser);
    }

}
