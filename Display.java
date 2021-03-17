import java.util.Arrays;

public class Display {

	public void displayPopulation(int[][] population) {
        for (int i = 0; i < population.length; i++) {
            System.out.println(Arrays.toString(population[i]));
        }
	}
    
}
