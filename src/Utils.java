import java.util.Random;

public class Utils {
    public static char RandomLetter() {
        Random r = new Random();
        return (char) (r.nextInt(26) + 'a');
    }

    public static int RandomMinMax(int min, int max) {
        Random r = new Random();
        return r.nextInt(max + 1 - min) + min;
    }

    public static float RandomMinMax(float min, float max) {
        Random r = new Random();
        return min + r.nextFloat() * (max - min);
    }

    public static boolean RandomBool(float probability) {
        return RandomMinMax(0f, 1f) <= probability;
    }
}
