import java.math.BigInteger;

public class ReverseAndAdd {

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





