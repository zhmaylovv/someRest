import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.sber.entity.Person;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

class MainTest {

    @Test
    void checkCorrectionOutputAfterCreatePersonByArgs() {
        List<Person> personList = new ArrayList<>();
        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));
        Main.checkArgs(new String[] {"Vasiliy", "Zhmaylo"}, personList);
        Assertions.assertEquals("Added new person: firstName='Vasiliy', lastName='Zhmaylo'",
                outputStreamCaptor.toString().trim());
    }


}
