import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class PersonTest {

    private static Person person;

    @BeforeAll
    public static void setup() {
        person = new Person();
        person.setUsername("");
        person.setPassword("");
    }

    @ParameterizedTest
    @ValueSource(strings = {"PaulMcCartney2", "NeilArms2"})
    public void check_user_valid(String s) {
        person.setUsername(s);
        assertTrue(person.checkUser());
    }

    @ParameterizedTest
    @ValueSource(strings = {"Paul#McCartney", "Neil@Arms"})
    public void check_user_not_valid(String s) {
        person.setUsername(s);
        assertFalse(person.checkUser());
    }

    @ParameterizedTest
    @ValueSource(strings = {"123456789", "#$%1234"})
    public void does_not_have_letters(String s) {
        person.setPassword(s);
        assertFalse(person.checkPassword());
    }

    @ParameterizedTest
    @ValueSource(strings = {"Abcabcdefgh@", "#hbtn@%tc"})
    public void does_not_have_numbers(String s) {
        person.setPassword(s);
        assertFalse(person.checkPassword());
    }

    @ParameterizedTest
    @ValueSource(strings = {"Abc@123", "12$@hbt"})
    public void does_not_have_eight_chars(String s) {
        person.setPassword(s);
        assertFalse(person.checkPassword());
    }

    @ParameterizedTest
    @ValueSource(strings = {"abC123456$", "Hbtn@1234", "Betty@1#2", "Hbtn@123"})
    public void check_password_valid(String s) {
        person.setPassword(s);
        assertTrue(person.checkPassword());
    }

}