package mei.src;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.sql.Date;
import java.time.LocalDate;
import java.time.ZoneId;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PersonTest {

    private static Person person;

    @BeforeAll
    public static void setup() {
        person = new Person();
        person.setName("Paul");
        person.setSurname("McCartney");
        person.setBirthDate(Date.from(LocalDate.of(2000, 1, 1)
                .atStartOfDay(ZoneId.systemDefault()).toInstant()));
        person.setPensioner(true);
        person.setAnotherCompanyOwner(true);
        person.setPublicServer(true);
        person.setSalary(1200);
    }

    @Test
    public void show_full_name() {
        assertEquals("Paul McCartney", person.fullName());
    }

    @Test
    public void test_calculateYearlySalary() {
        assertEquals(14400, person.calculateYearlySalary());
    }

    @Test
    public void person_is_MEI() {
        person.setAnotherCompanyOwner(false);
        person.setPublicServer(false);
        person.setPensioner(false);
        assertTrue(person.isMEI());
    }

    @Test
    public void person_is_not_MEI() {
        person.setAnotherCompanyOwner(true);
        person.setPublicServer(true);
        person.setPensioner(true);
        assertFalse(person.isMEI());
    }

}