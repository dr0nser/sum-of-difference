import java.util.SplittableRandom;

class InitialPopulation {

    static int ROWS = 50;

    int[][] generatePopulation(int rangeStart, int rangeEnd) {
        SplittableRandom sr = new SplittableRandom();

        int[][] population = new int[ROWS][rangeEnd-rangeStart+2];

        for (int i = 0; i < ROWS; i++) {
            int[] numberStream = sr.ints(rangeStart, rangeEnd+1).distinct().limit(rangeEnd-rangeStart+1).toArray();
            int sum = calSum(numberStream);
            population[i] = fill(numberStream, sum);
        }
        return population;
    }

    static int calSum(int[] numberStream) {
        int sum = 0;
        for (int i = 0; i < numberStream.length-1; i++) {
            sum+=Math.abs(numberStream[i]-numberStream[i+1]);
        }
        return sum;
    }

    static int[] fill(int[] array, int sum) {
        int[] tempArr = new int[array.length+1];
        for (int i = 0; i < array.length; i++) {
            tempArr[i] = array[i];
        }
        tempArr[tempArr.length-1] = sum;
        return tempArr;
    }
}