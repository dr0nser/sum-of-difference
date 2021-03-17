import java.util.Arrays;

public class SortPopulation {

    int[][] sortPopulation(int[][] population){
        Arrays.sort(population, (a, b) -> Integer.compare(b[population[0].length - 1], a[population[0].length - 1]));
        return population;
    }
    
}
