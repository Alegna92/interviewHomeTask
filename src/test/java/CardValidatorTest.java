import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CardValidatorTest {

    @Test
    void shouldReturnFalseWhenCardNumberIsNull() {
        String cardNumberToValidate = null;
        assertFalse(CardValidator.validateCardNumber(cardNumberToValidate));
    }

    @Test
    void shouldReturnFalseWhenCardNumberIsEmpty() {
        String cardNumberToValidate = "";
        assertFalse(CardValidator.validateCardNumber(cardNumberToValidate));
    }

    @Test
    void shouldReturnFalseWhenValidCardNumberWithInvalidCharacters() {
        String cardNumberToValidate = "4354735186402!@#"; //change example card number to valid one, and add invalid character
        assertFalse(CardValidator.validateCardNumber(cardNumberToValidate));
    }

    @Test
    void shouldReturnFalseWhenCardNumberIsTooShort() {
        String cardNumberToValidate = "123456789012";
        assertFalse(CardValidator.validateCardNumber(cardNumberToValidate));
    }

    @Test
    void shouldReturnFalseWhenCardNumberIsTooLong() {
        String cardNumberToValidate = "12345678901234567890";
        assertFalse(CardValidator.validateCardNumber(cardNumberToValidate));
    }

    @Test
    void shouldReturnFalseWhenCardNumberIsNotValid() {
        String cardNumberToValidate = "5019717010103743";
        assertFalse(CardValidator.validateCardNumber(cardNumberToValidate));
    }

    @Test
    void shouldReturnTrueWhenValidCardNumberWithLegalAdditionalCharacters() { //is card number valid without legal additional characters?
        String cardNumberToValidate = "6759-6498 2643- 8453";
        assertTrue(CardValidator.validateCardNumber(cardNumberToValidate));
    }

    @Test
    void shouldReturnTrueWhenValidCardNumberWithMinimumLength() {
        String cardNumberToValidate = "4354735186402";
        assertTrue(CardValidator.validateCardNumber(cardNumberToValidate));
    }

    @Test
    void shouldReturnTrueWhenValidCardNumberWithMaximumLength() {
        String cardNumberToValidate = "6799990100000000019";
        assertTrue(CardValidator.validateCardNumber(cardNumberToValidate));
    }


}