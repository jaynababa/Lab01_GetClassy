import java.util.Scanner;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class SafeInputObjTest {

        private SafeInputObj safeInput;

        @BeforeEach
        public void setUp() {
            safeInput = new SafeInputObj(new Scanner("test input\n25\n2.250\nY\n012345\n"));
        }

        @Test
        public void testGetNonZeroLenString() {
            assertEquals("test input", safeInput.getNonZeroLenString("Enter a string"));
        }

        @Test
        public void testGetInt() {
            assertEquals(25, safeInput.getInt("Enter an int"));
        }

        @Test
        public void testGetDouble() {
            safeInput = new SafeInputObj(new Scanner("2.50\n"));
            assertEquals(2.50, safeInput.getDouble("Enter a double"), 0.01);
        }

        @Test
        public void testGetYNConfirm() {
            assertTrue(safeInput.getYNConfirm("Confirm"));
        }
    }


