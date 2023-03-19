import java.util.Random;

public class RandomTools {
private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
private static Random rng = new Random();
    public static String generateRandomGibberish(int stringLength){
        char[] text = new char[stringLength];
        for (int i = 0; i < stringLength; i++) {
            text[i] =  ALPHABET.charAt(rng.nextInt(ALPHABET.length()));
        }
        return new String(text);
    }
    public static int generateRandomNumber(int maxValue){
        return rng.nextInt(maxValue);
    }

    public static int generateRandomDepartmentId(){
        return generateRandomNumber(5) + 1;
    }

    public static String generateRandomName(){
        final int MAX_NAME_LENGTH = 8;
        final int MIN_NAME_LENGTH = 3;
        int length = generateRandomNumber(MAX_NAME_LENGTH);
        while (length < MIN_NAME_LENGTH){
            length = generateRandomNumber(MAX_NAME_LENGTH);
        }
        return generateRandomGibberish(length) + " " + generateRandomGibberish(length);
    }
}

