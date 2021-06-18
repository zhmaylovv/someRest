import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

class MainTest {

    @Test
    void checkCorrectionOutputAfterCreatePersonByArgs() {
        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));
        Main.main(new String[] {"Vasiliy", "Zhmaylo"});
        Assertions.assertEquals("Added new person: firstName='Vasiliy', lastName='Zhmaylo'\n" +
                "Please enter first and last name of person, split by space. For add to person list.",
                outputStreamCaptor.toString().trim());
    }
}
