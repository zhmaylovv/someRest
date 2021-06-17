import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

class Main1Test {


    @Test
    void main() {
        InputStream in = new ByteArrayInputStream("Vasiliy Zhmaylo".getBytes());
        System.setIn(in);
        Main1.main(new String[]{});
        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));
        Main.main(new String[] {"Vasiliy", "Zhmaylo"});
        Assertions.assertEquals("Added new person: firstName='Vasiliy', lastName='Zhmaylo'", outputStreamCaptor.toString().trim());
    }

    @Test
    void negativeTestIfNoArgs() {
        InputStream in = new ByteArrayInputStream("Vasiliy".getBytes());
        System.setIn(in);
        Assertions.assertThrows(IllegalArgumentException.class,()-> Main1.main(new String[]{}));
    }

}