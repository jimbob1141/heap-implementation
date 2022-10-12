import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // intialize new heap object
        Heap testHeap = new Heap();
        // initialize variable, this will be added to the heap
        int currentNumber = 0;
        // loop over numbers 0-99, adding them to the heap
        while (currentNumber < 100){
            // add numbers to the heap
            testHeap.addValue(currentNumber);
            // increment the current number
            currentNumber++;
        }
        // prints the heap, iterating over each index and printing child nodes alongside parents
        testHeap.printHeap();
        // print the full heap
        System.out.println(Arrays.toString(testHeap.items));

    }
}