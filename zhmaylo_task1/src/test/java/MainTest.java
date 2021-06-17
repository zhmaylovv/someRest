import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void checkCorrectionOutputAfterCreatePerson() {
        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));
        Main.main(new String[] {"Vasiliy", "Zhmaylo"});
        Assertions.assertEquals("Added new person: firstName='Vasiliy', lastName='Zhmaylo'", outputStreamCaptor.toString().trim());
    }

    @Test
    void negativeTestIfNoArgs() {
        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));
        Assertions.assertThrows(IllegalArgumentException.class,()-> Main.main(new String[] {"Vasiliy"}));
    }
}
