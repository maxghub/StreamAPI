# StreamAPI


# Order
Practical Assignment – Stream API – Number Generation
Suppose we have a list of orders, where each order represents a product and its cost. The task is to use the Stream API and collectors to solve the following problems:

Create a list of orders with different products and their costs.

Group the orders by product.

For each product, calculate the total cost of all orders.

Sort the products in descending order by total cost.

Select the three most expensive products.

Output the result: a list of the three most expensive products and their total cost.

Initial code

class Order {
    private String product;
    private double cost;

    public Order(String product, double cost) {
        this.product = product;
        this.cost = cost;
    }

    public String getProduct() {
        return product;
    }

    public double getCost() {
        return cost;
    }
}

public class StreamCollectorsExample {
    public static void main(String[] args) {
        List<Order> orders = List.of(
                new Order("Laptop", 1200.0),
                new Order("Smartphone", 800.0),
                new Order("Laptop", 1500.0),
                new Order("Tablet", 500.0),
                new Order("Smartphone", 900.0)
        );
    }
}



# Student
Practical Assignment – Stream API – Aggregation and Result Merging
Create a collection of students, where each student contains information about the subjects they study and their grades in those subjects.

Use a Parallel Stream to process the data and create a Map, where:

the key is the subject,

the value is the average grade across all students.

Output the result: a single Map containing the average grades for all subjects.

class Student {
    private String name;
    private Map<String, Integer> grades;

    public Student(String name, Map<String, Integer> grades) {
        this.name = name;
        this.grades = grades;
    }

    public Map<String, Integer> getGrades() {
        return grades;
    }
}

public class ParallelStreamCollectMapAdvancedExample {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
                new Student("Student1", Map.of("Math", 90, "Physics", 85)),
                new Student("Student2", Map.of("Math", 95, "Physics", 88)),
                new Student("Student3", Map.of("Math", 88, "Chemistry", 92)),
                new Student("Student4", Map.of("Physics", 78, "Chemistry", 85))
        );
    }
}






# forkjoin-factorial
Practical Assignment – Stream API – ForkJoinPool: Recursive Factorial Calculation
Consider the task of calculating a factorial using ForkJoinPool. The factorial of a number n is denoted as n! and is calculated as the product of all positive integers from 1 to n.

Implement the FactorialTask class that extends RecursiveTask.

In the constructor of FactorialTask, pass the number n whose factorial needs to be calculated.

In the compute() method, split the task into subtasks and use fork() for asynchronous execution.

Use join() to retrieve the results of subtasks and combine them to produce the final result.

In the main method, create an instance of FactorialTask with the number whose factorial should be calculated and execute it using a ForkJoinPool.

Output the result of the factorial calculation.

As a result, the following structure should be obtained:

public class ForkJoinPoolExample {
    public static void main(String[] args) {
        int n = 10; // Calculate factorial for number 10

        ForkJoinPool forkJoinPool = new ForkJoinPool();
        FactorialTask factorialTask = new FactorialTask(n);

        long result = forkJoinPool.invoke(factorialTask);

        System.out.println("Factorial " + n + "! = " + result);
    }
}
