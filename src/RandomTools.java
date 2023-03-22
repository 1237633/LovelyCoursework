import java.util.Random;

public class RandomTools {
private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
private static final Random rng = new Random();
    public static String generateRandomGibberish(int stringLength){
        char[] text = new char[stringLength];
        for (int i = 0; i < stringLength; i++) {
            text[i] =  ALPHABET.charAt(generateRandomNumber(0, ALPHABET.length()));
        }
        return new String(text);
    }
    public static int generateRandomNumber(int minValue, int maxValue){
        if(maxValue < 0 || minValue < 0){
            throw new IllegalArgumentException("Random works only with positive numbers!");
        } else if (minValue > maxValue) {
            throw new IllegalArgumentException("Minimal value must be LESS than maximum value!");
        }
        return rng.nextInt(maxValue-minValue) + minValue ;
    }

    public static String generateRandomName(){
        final int MAX_NAME_LENGTH = 9;
        final int MIN_NAME_LENGTH = 3;
        int length = generateRandomNumber(MIN_NAME_LENGTH, MAX_NAME_LENGTH);
        return generateRandomGibberish(length) + " " + generateRandomGibberish(length);
    }
}

