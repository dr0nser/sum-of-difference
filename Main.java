import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter start bound (inclusive)");
        int start = sc.nextInt();
        System.out.println("enter start bound (inclusive)");
        int end = sc.nextInt();
        sc.close();
        
        InitialPopulation init = new InitialPopulation();
        SortPopulation sort = new SortPopulation();
        Selection select = new Selection();
        Mutation mutation = new Mutation();
        Crossover crossover = new Crossover();
        //Display display = new Display();

        long startTimeMillis = System.currentTimeMillis();

        int[][] population = init.generatePopulation(start, end);
        population = sort.sortPopulation(population);
        long currentTimeMillis = System.currentTimeMillis();

        int genCount=0;
        while(genCount<200000) {
            population = select.select(population);
            population = mutation.mutate(population);
            population = crossover.cross(population);
            population = sort.sortPopulation(population);
            currentTimeMillis = System.currentTimeMillis();
            genCount++;
        }
        System.out.println("task completed in " + ((float)(currentTimeMillis-startTimeMillis)/1000)+"s");
        System.out.println("generation => " + genCount);
        System.out.println("combination with max sum");
        for (int i = 0; i < population[0].length-1; i++) {
            System.out.print(population[0][i]+" ");
        }
        System.out.println("\nMax sum => "+population[0][population[0].length-1]);
    }
}