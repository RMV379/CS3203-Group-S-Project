import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import static org.junit.Assert.assertEquals;
import java.util.Scanner;

public class TestcheckUsername {

    @Test
    void Test() { //test edge case, negative value target
        Scanner input = new Scanner(System.in);
        String Username = "tonyesh";
        
        assertEquals(true, -1);
    }
    
}
