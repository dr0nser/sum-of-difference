import java.util.Random;

public class Mutation {
    
    int[][] mutate(int[][] population) {
        for (int i = 0; i < population.length; i++) {
            population[i] = shuffleArray(population[i]);
        }
        return population;
    }

    static int[] shuffleArray(int[] arr) {
        Random random = new Random();
        int[] temp = new int[arr.length-1];
        for(int i=0;i<arr.length-1;i++)
            temp[i] = arr[i];
        for (int i = 0; i < temp.length; i++) {
            int randomIndex = random.nextInt(temp.length);
            if(randomIndex!=i) {
                int x = temp[i];
                temp[i]=temp[randomIndex];
                temp[randomIndex]=x;
            }
        }
        if(calSum(temp)>arr[arr.length-1]){
            for(int i=0;i<arr.length-1;i++)
                arr[i] = temp[i];
            arr[arr.length-1] = calSum(temp);
        }
        return arr;
    }

    static int calSum(int array[]) {
        int sum = 0;
        for(int i = 0; i < array.length-1; i++) {
            sum+= Math.abs(array[i] - array[i+1]);
        }
        return sum;
    }

}
