/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package fizzbuzzkata;

import org.junit.Test;
import org.concordion.integration.junit4.ConcordionRunner;
import org.junit.runner.RunWith;
import static org.junit.Assert.*;

//@RunWith(ConcordionRunner.class)
public class AppTest {
    @Test public void testAppHasAGreeting() {
        App classUnderTest = new App();
        assertNotNull("app should have a greeting", classUnderTest.getGreeting());
    }
}