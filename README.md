# QuickSort-Multithreaded

This project implements the QuickSort algorithm with multithreading in Java, designed to sort a list of integers efficiently using parallel processing.

## Introduction

QuickSort is a divide-and-conquer sorting algorithm known for its efficiency and is commonly used in various applications. By introducing multithreading, this implementation partitions the list into sublists and sorts them concurrently, taking advantage of modern multi-core processors to potentially reduce sorting time.

## Features

- Multithreaded implementation of the QuickSort algorithm.
- Efficient sorting of large datasets through parallel processing.
- Demonstrates the use of Java's `RecursiveAction` and `ForkJoinPool` for parallel execution.

## Usage

To use this project, you can integrate the `QuickSortTask` class into your Java application:

1. Clone the repository:

   ```bash
   git clone https://github.com/your-username/QuickSort-Multithreaded.git
2. Import the QuickSortTask class into your project.

3. Create a List<Integer> that needs to be sorted.

4. Create an instance of QuickSortTask with the list and the range [0, list.size() - 1].

5. Use a ForkJoinPool to invoke the task:

  ```java
  ForkJoinPool pool = ForkJoinPool.commonPool();
  QuickSortTask task = new QuickSortTask(list, 0, list.size() - 1);
  pool.invoke(task);
```
6. After invocation, the list will be sorted in-place.
