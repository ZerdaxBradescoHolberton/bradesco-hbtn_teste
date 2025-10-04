import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PersonTest {

    private static Person person;

    @BeforeAll
    public static void setup() {
        person = new Person();
        person.setUsername("");
        person.setPassword("");
    }

    @Test
    public void check_user_valid() {
        List.of("PaulMcCartney2", "NeilArms2").forEach(s -> {
            person.setUsername(s);
            assertTrue(person.checkUser());
        });
    }

    @Test
    public void check_user_not_valid() {
        List.of("Paul#McCartney", "Neil@Arms").forEach(s -> {
            person.setUsername(s);
            assertFalse(person.checkUser());
        });
    }

    @Test
    public void does_not_have_letters() {
        List.of("123456789", "#$%1234").forEach(s -> {
            person.setPassword(s);
            assertFalse(person.checkPassword());
        });
    }

    @Test
    public void does_not_have_numbers() {
        List.of("Abcabcdefgh@", "#hbtn@%tc").forEach(s -> {
            person.setPassword(s);
            assertFalse(person.checkPassword());
        });
    }

    @Test
    public void does_not_have_eight_chars() {
        List.of("Abc@123", "12$@hbt").forEach(s -> {
            person.setPassword(s);
            assertFalse(person.checkPassword());
        });

    }

    @Test
    public void check_password_valid() {
        List.of("abC123456$", "Hbtn@1234", "Betty@1#2", "Hbtn@123").forEach(s -> {
            person.setPassword(s);
            assertTrue(person.checkPassword());
        });

    }

}