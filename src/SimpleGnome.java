import java.util.List;

public class SimpleGnome extends Gnome<String> {
    public SimpleGnome(int length, float mutationProbability) {
        super(length, mutationProbability);
    }

    public SimpleGnome(SimpleGnome a, SimpleGnome b) {
        super(a, b);
    }

    @Override
    protected String GenerateDna() {
        StringBuilder res = new StringBuilder();
        for (int x = 0; x < getLength(); x++)
            res.append(Utils.RandomLetter());
        return res.toString();
    }

    @Override
    protected String Combine(Gnome<String> a, Gnome<String> b) {
        return a.getDna().substring(0, a.getLength() / 2) + b.getDna().substring(a.getLength() / 2);
    }

    @Override
    protected String Mutate(String dna) {
        if (Utils.RandomBool(getMutationProbability())) {
            char[] c = dna.toCharArray();
            c[Utils.RandomMinMax(0, dna.length())] = Utils.RandomLetter();
            return String.valueOf(c);
        }
        return dna;
    }

    @Override
    public int calculateFitness() {
        List<Character> v = List.of(new Character[]{'a', 'e', 'i', 'o', 'u', 'y'});
        int score = 0;
        for (int x = 0; x < getDna().length(); x++) {
            if (getDna().charAt(x) == 'a') score += 5;
            else if (v.contains(getDna().charAt(x))) score++;
        }

        return score;
    }

    @Override
    public float getAccuracy() {
        return getFitness() / (float) getLength();
    }
}
