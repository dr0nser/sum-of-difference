import java.util.Random;

public class Crossover {

    int[][] cross(int[][] population) {
        for (int i = 0; i < population.length; i++) {
            population[i] = cross(population[i]);
        }
        return population;
    }

    static int[] cross(int[] arr) {
        Random rand = new Random();
        int[] temp = new int[arr.length-1];
        int len = rand.nextInt((int)((arr.length-1)/2)+1);
        for(int i=0;i<temp.length;i++)
            temp[i] = arr[i];
        int i = 0;int j = temp.length-len;
        while(i<len){
            int x = temp[i];
            temp[i] = temp[j];
            temp[j] = x;
            i++;
            j++;
        }
        if(arr[arr.length-1]<calSum(temp)){
            for (int k = 0; k < arr.length-1; k++) {
                arr[k]=temp[k];
            }
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
