package Tests;

import Models.PhoneNumberChecker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

public class PhoneNumbersTest {

    private HashMap<String, String> dataSet;
    private PhoneNumberChecker phoneNumberChecker;

    @BeforeEach
    public void init(){
        phoneNumberChecker = new PhoneNumberChecker();
        dataSet = phoneNumberChecker.getCollection();
    }


    @Test
    public void anEmptyNumberShouldReturnTrue(){
        HashMap<String, String> dataSet = new HashMap<>();
        dataSet.put("Test", "");
        dataSet.put("Test1", "");
        assertTrue(phoneNumberChecker.checkIfNumberIsPrefixForCollection("Test", "", dataSet));
    }

    @Test
    public void singleNumberIsPrefixShouldReturnTrue(){
        HashMap<String, String> dataSet = new HashMap<>();
        dataSet.put("Test", "1");
        dataSet.put("Test1", "1");
        assertTrue(phoneNumberChecker.checkIfNumberIsPrefixForCollection("Test", "1", dataSet));
    }

    @Test
    public void isPrefixForMultipleShouldReturnTrue(){
        HashMap<String, String> dataSet = new HashMap<>();
        dataSet.put("Test", "12");
        dataSet.put("Test1", "123");
        assertTrue(phoneNumberChecker.checkIfNumberIsPrefixForCollection("Test", "12", dataSet));
    }

    @Test
    public void isNoPrefixShouldReturnFalse(){
        HashMap<String, String> dataSet = new HashMap<>();
        dataSet.put("Test", "1");
        dataSet.put("Test1", "2");
        assertFalse(phoneNumberChecker.checkIfNumberIsPrefixForCollection("Test", "1", dataSet));
    }

    @Test
    public void containsPrefixButIsLongerShouldReturnFalse(){
        HashMap<String, String> dataSet = new HashMap<>();
        dataSet.put("Test", "123");
        dataSet.put("Test1", "12");
        assertFalse(phoneNumberChecker.checkIfNumberIsPrefixForCollection("Test", "123", dataSet));
    }

    @Test
    public void wholeDataSetShouldReturnFalse(){
        boolean result = false;
        Iterator it = dataSet.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            result = phoneNumberChecker.checkIfNumberIsPrefixForCollection((String) pair.getKey(), (String) pair.getValue(), dataSet);
            it.remove();
        }
        assertFalse(result);
    }

}
