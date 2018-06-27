package com.shailesh.spcore.spcorereadprops;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
//@SpringBootTest
@ContextConfiguration(classes=SpCoreReadpropsApplication.class)
/**
 * Test property loading.
 */
public class SpCoreReadpropsApplicationTests {

    @Value("${property1}")
    private String prop1;

    @Value("${property2}")
    private String prop2;

    // Here data after the colon is the default value. In this case set to blank.
    // This practice safeguard's against exception during start up.
    // Warning: the property file itself might but the applcation never throws an error.
    @Value("${propunknown:}")
    private String propunknown;

    // Get a property from property file 2
    @Value("${propertyFile2}")
    private String propertyFile2;

    // Impport boolean values
    @Value("${mybool.true}")
    private boolean isTrue;
    @Value("${mybool.false}")
    private boolean isFalse;

    // Import arrays
    @Value("${myArray.ints}")
    private int[] numbers;
    @Value("${myArray.string}")
    private String[] strings;

    @Test
    /**
     * Get property from file one
     */
    public void readPropertyOne() {
        assertEquals("Property not as expected ", "Hello", prop1);
    }

    @Test
    /**
     * Get one more property from file
     *
     */
    public void readPropertyTwo() {
        assertEquals("Property not as expected ", "welcome", prop2);
    }

    @Test
    /**
     * Get a property not ia any file. Make sure the default value is getting set.
     */
    public void readPropertyUnknown() {
        assertEquals("Property not as expected ", "", propunknown);
    }

    /**
     * Read a property from property file two
     */
    @Test
    public void readPropertyFromFileTwo(){
        assertEquals("Property not as expected", "Property  file 2", propertyFile2) ;
    }

    /**
     * Check if the boolean value true is returned.
     */
    @Test
    public void readBooleanValuetrue(){
        assertTrue("Property not as expected", isTrue) ;
    }

    /**
     * Check if the boolean value true is returned.
     */
    @Test
    public void readBooleanValueFalse(){
        assertFalse("Property not as expected", isFalse); ;
    }

    @Test
    public void readPropertyIntArray(){
        assertEquals("Property not as expected", new int[]{1,2,3,4}.length, numbers.length) ;
    }

    @Test
    public void readPropertyStringArray(){
        assertEquals("Property not as expected", new String[]{"apple","orange","grapes"}, strings) ;
    }
}
