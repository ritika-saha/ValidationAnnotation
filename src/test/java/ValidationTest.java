import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import com.user.User;
import com.user.ValidationProcessor;
import com.user.*;
public class ValidationTest {

    @Test
    public void testBlankHappy(){
        User user=new User();
        user.setUsername("Ritika");
        user.setPassword("Password123");
        user.setPin(123);
        ValidationProcessor v=new ValidationProcessor();
        try {
            v.validate(user);
            assertTrue(true);
        } catch (ValidationException e) {
            fail("Unexpected validation exception === "+e.getMessage());
        }
    }

    @Test 
    public void testBlankSad(){
        User user=new User();
        user.setUsername("  ");
        user.setPassword("Password123");
        user.setPin(123);
        ValidationProcessor v=new ValidationProcessor();
        try {
            v.validate(user);
            fail("not blank exception expected");
        } catch (ValidationException e) {
            assertEquals("username field can not be BLANK", e.getMessage());
        }
    }

    @Test 
    public void testPositiveHappy(){
        User user=new User();
        user.setUsername("Ritika");
        user.setPassword("Password123");
        user.setPin(123);
        ValidationProcessor v=new ValidationProcessor();
        try {
            v.validate(user);
            assertTrue(true);
        } catch (ValidationException e) {
            fail("Unexpected validation exception === "+e.getMessage());
        }
    }

     @Test 
    public void testPositiveSad(){
        User user=new User();
        user.setUsername("Ritika");
        user.setPassword("Password123");
        user.setPin(-123);
        ValidationProcessor v=new ValidationProcessor();
        try {
            v.validate(user);
            fail("not negative exception expected");
        } catch (ValidationException e) {
            assertEquals("pin field can not be NEGATIVE", e.getMessage());
        }
    }


}
