import java.util.Scanner;

public class CardValidator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter potential credit card number");
        String cardNumberToValidate = scanner.nextLine();
        System.out.println(validateCardNumber(cardNumberToValidate));
    }

    private static String removeUnnecessaryCharacters(String cardNumberToValidate) {
        return cardNumberToValidate.replace("-", "").replace(" ", "");
    }

    private static boolean validateCardNumberContainsOnlyDigits(String cardNumberToValidate) {
        return cardNumberToValidate.matches("\\d+");
    }

    private static boolean validateCardNumberLength(String cardNumberToValidate) {
        return cardNumberToValidate.length() >= 13 && cardNumberToValidate.length() <= 19;
    }

    private static boolean validateCardNumberUsingLuhnAlgorithm(String cardNumberToValidate) {
        int doubledDigitsSum = 0;
        for (int i = cardNumberToValidate.length() - 2; i >= 0; i -= 2) {
            int doubledDigit = Character.getNumericValue(cardNumberToValidate.charAt(i)) * 2;
            if (doubledDigit > 9) {
                doubledDigit = doubledDigit - 9;
            }
            doubledDigitsSum = doubledDigitsSum + doubledDigit;
        }
        int singleDigitsSum = 0;
        for (int i = cardNumberToValidate.length() - 1; i >= 0; i -= 2) {
            singleDigitsSum = singleDigitsSum + Character.getNumericValue(cardNumberToValidate.charAt(i));
        }
        int sum = doubledDigitsSum + singleDigitsSum;
        return sum % 10 == 0;

    }

    public static boolean validateCardNumber(String cardNumberToValidate) {
        if (cardNumberToValidate == null) {
            return false;
        }

        cardNumberToValidate = removeUnnecessaryCharacters(cardNumberToValidate);
        if (!validateCardNumberLength(cardNumberToValidate)) {
            return false;
        }
        if (!validateCardNumberContainsOnlyDigits(cardNumberToValidate)) {
            return false;
        }
        if (!validateCardNumberUsingLuhnAlgorithm(cardNumberToValidate)) {
            return false;
        }
        return true;

    }


}
