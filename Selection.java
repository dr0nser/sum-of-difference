public class Selection {

    int[][] select(int[][] population) {
        int rowsToBeTaken = 0;
        if(population.length>10)
            rowsToBeTaken = (int)(population.length/2);
        else
            rowsToBeTaken = population.length;
        int[][] selectedPopulation = new int[rowsToBeTaken][population[0].length];
        for (int i = 0; i < rowsToBeTaken; i++) {
            selectedPopulation[i] = population[i];
        }
        return selectedPopulation;
    }

}
