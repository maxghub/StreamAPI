package in.itk;

import java.util.concurrent.RecursiveTask;

public class FactorialTask extends RecursiveTask<Long> {

    private int n;

    public FactorialTask(int n) {
        this.n = n;
    }

    @Override
    protected Long compute() {

        // Base case
        if (n <= 1) {
            return 1L;
        }

        // Create subtask
        FactorialTask subTask = new FactorialTask(n - 1);

        // Fork (execute asynchronously)
        subTask.fork();

        // Join result
        long subResult = subTask.join();

        // Combine result
        return n * subResult;
    }
}
