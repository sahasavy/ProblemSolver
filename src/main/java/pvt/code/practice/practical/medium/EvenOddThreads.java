package pvt.code.practice.practical.medium;

/*
Write a program in java 8 or above that will have 2 threads.
The 1st thread will print even numbers and the 2nd thread will print odd numbers.
The loop will run from 1 to 10

 */
public class EvenOddThreads {
    private static final int MAX = 10;
    private final Object lock = new Object();
    private int currentNumber = 1;

    public static void main(String[] args) {
        EvenOddThreads evenOddThreads = new EvenOddThreads();

        Thread evenThread = new Thread(() -> evenOddThreads.printNumbers(false));
        Thread oddThread = new Thread(() -> evenOddThreads.printNumbers(true));

        evenThread.start();
        oddThread.start();
    }

    private void printNumbers(boolean isOdd) {
        while (currentNumber <= MAX) {
            synchronized (lock) {
                if (isOdd && currentNumber % 2 == 0 || !isOdd && currentNumber % 2 != 0) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                } else {
                    System.out.println(Thread.currentThread().getName() + ": " + currentNumber);
                    currentNumber++;
                    lock.notify();
                }
            }
        }
    }
}
