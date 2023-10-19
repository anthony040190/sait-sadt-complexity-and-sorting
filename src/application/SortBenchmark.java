package application;

public class SortBenchmark {

    public void benchmarkAlgorithm(String algorithmName, int[] arr, SortFunction sortFunction) {
        long startTime = System.currentTimeMillis();
        sortFunction.sort(arr);
        long endTime = System.currentTimeMillis();
        long elapsedTime = endTime - startTime;
        System.out.println("Time taken for " + algorithmName + ": " + elapsedTime + " milliseconds.");
    }

}

interface SortFunction {
    void sort(int[] arr);
}


