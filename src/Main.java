public class Main {
    public static void main(String[] args) {
        Simulation<SimpleGnome, Object> simulation = new Simulation<>(SimpleGnome.class, 10, 10000, 0.01f, 10, 0.1f);
        SimpleGnome res = simulation.Simulate();
        System.out.println(res.getDna());
        System.out.println(res.getFitness());
        System.out.println(res.getAccuracy());
    }
}