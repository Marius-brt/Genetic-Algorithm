public class Gnome<T> {
    private final T dna;
    private final int length;
    private final float mutationProbability;
    private final int fitness;

    public Gnome(int length, float mutationProbability) {
        this.mutationProbability = mutationProbability;
        this.length = length;
        dna = GenerateDna();
        fitness = calculateFitness();
    }

    public Gnome(Gnome<T> a, Gnome<T> b) {
        this.length = a.getLength();
        this.mutationProbability = a.getMutationProbability();
        dna = Combine(a, b);
        fitness = calculateFitness();
    }

    public int getLength() {
        return length;
    }

    public T getDna() {
        return dna;
    }

    public float getMutationProbability() {
        return mutationProbability;
    }

    public int getFitness() {
        return fitness;
    }

    public float getAccuracy() {
        return 0;
    }

    protected int calculateFitness() {
        return 0;
    }

    protected T GenerateDna() {
        return null;
    }

    protected T Combine(Gnome<T> a, Gnome<T> b) {
        return null;
    }

    protected T Mutate(String dna) {
        return null;
    }
}
