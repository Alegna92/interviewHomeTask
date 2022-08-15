import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReverseAndAddTest {

    @Test
    void shouldThrowExceptionWhenNumberIsNegative() {
        long number = -54321;
        assertThrows(Exception.class, () -> ReverseAndAdd.tryToFindPalindrome(number));
    }

    @Test
    void shouldThrowExceptionWhenMaxCounterValueIsExceeded() {
        long number = 196;
        assertThrows(Exception.class, () -> ReverseAndAdd.tryToFindPalindrome(number));
    }

    @Test
    void shouldReturnResultWhenNumberIsZero() throws Exception {
        long number = 0;
        assertEquals("1 0", ReverseAndAdd.tryToFindPalindrome(number));
    }

    @Test
    void shouldReturnResultWhenNumberIsValid() throws Exception {
        long number = 195;
        assertEquals("4 9339", ReverseAndAdd.tryToFindPalindrome(number));
    }
}