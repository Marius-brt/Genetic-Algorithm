import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class Simulation<T extends Gnome<?>, T2> {
    private final Class<T> gnomeClass;
    private final int generations;
    private final int populationSize;
    private final float parents;
    private final int dnaLength;
    private final float mutation;

    public Simulation(Class<T> gnomeClass, int generations, int populationSize, float parents, int dnaLength, float mutation) {

        this.gnomeClass = gnomeClass;
        this.generations = generations;
        this.populationSize = populationSize;
        this.parents = parents;
        this.dnaLength = dnaLength;
        this.mutation = mutation;
    }

    public T Simulate() {
        return Simulate(null);
    }

    public T Simulate(T2 param) {
        LinkedList<T> pa = new LinkedList<>();
        for (int g = 0; g < generations; g++) {
            PriorityQueue<T> pop = new PriorityQueue<>(Comparator.comparingDouble(T::getFitness).reversed());
            for (int p = 0; p < populationSize; p++) {
                try {
                    if (pa.size() > 1) {
                        T n = gnomeClass.getDeclaredConstructor(gnomeClass, gnomeClass).newInstance(pa.getFirst(), pa.get(1));
                        pop.add(n);
                        pa.removeFirst();
                        pa.removeFirst();
                    } else if (param != null)
                        pop.add(gnomeClass.getDeclaredConstructor(int.class, float.class, param.getClass()).newInstance(dnaLength, mutation, param));
                    else
                        pop.add(gnomeClass.getDeclaredConstructor(int.class, float.class).newInstance(dnaLength, mutation));


                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
            pa = new LinkedList<>();
            for (int i = 0; i < (int) (populationSize * parents) && !pop.isEmpty(); i++)
                pa.add(pop.poll());

        }
        PriorityQueue<T> res = new PriorityQueue<>(Comparator.comparingDouble(T::getFitness).reversed());
        res.addAll(pa);
        return res.poll();
    }
}