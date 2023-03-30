public class TravelGnome extends Gnome<int[]> {
    public TravelGnome(int length, float mutationProbability) {
        super(length, mutationProbability);
    }

    public TravelGnome(Gnome<int[]> a, Gnome<int[]> b) {
        super(a, b);
    }

    @Override
    protected int calculateFitness() {
        return 0;
    }


}
