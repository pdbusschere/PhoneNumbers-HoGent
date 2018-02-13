package Tests;

import Models.PhoneNumberChecker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;


public class DataSetTest {

    public PhoneNumberChecker phoneNumberChecker;

    @BeforeEach
    public void init(){
        this.phoneNumberChecker = new PhoneNumberChecker();
    }

    @Test
    public void readingDataFileFillsCollection(){
        assertFalse(phoneNumberChecker.getCollection().isEmpty());
    }

    @Test
    public void phoneNumberDoesNotContainAnyWhitespace(){
        assertEquals("123", PhoneNumberChecker.parseLineFromFile("Name, 12 3 ")[1]);
    }

    @Test
    public void phoneNumberDoesNotContainAnyDashes(){
        assertEquals("123", PhoneNumberChecker.parseLineFromFile("Name, 12-3 ")[1]);
    }

}
