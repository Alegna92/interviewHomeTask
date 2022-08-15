import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReverseAndAdd {

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter numbers to calculate");
        scanner.useDelimiter(System.lineSeparator() + "|\n");
        List<Long> inputNumbers = new ArrayList<>();
        while (scanner.hasNextLong()) {
            inputNumbers.add(scanner.nextLong());
        }
        for (Long inputNumber : inputNumbers) {
            System.out.println(tryToFindPalindrome(inputNumber));
        }
    }

    public static String tryToFindPalindrome(long number) throws Exception {
        if (number < 0) {
            throw new Exception("Number must be greater than 0");
        }
        BigInteger sum = BigInteger.valueOf(number);
        for (int i = 1; i <= 1000; i++) {
            sum = sum.add(reverseNumber(sum));
            if (sum.equals(reverseNumber(sum))) {
                return i + " " + sum;
            }
        }
        throw new Exception("More than 1000 iterations");
    }

    private static BigInteger reverseNumber(BigInteger number) {
        StringBuilder stringBuilder = new StringBuilder(number.toString());
        String reverseString = stringBuilder.reverse().toString();
        return new BigInteger(reverseString);

    }

}





