public class Heap {
    // set capacity to 100
    private int capacity = 100;
    private int size = 0;

    //initialise array of ints with the length of capacity
    int[] items = new int[capacity];

    // helper functions to calculate indexes so we can use an array for the heap
    private int getLeftChildIndex(int parentIndex) { return 2 * parentIndex + 1; }
    private int getRightChildIndex(int parentIndex) { return 2 * parentIndex + 2; }
    private int getParentIndex(int childIndex) { return (childIndex - 1) / 2; }

    // functions that check if there are children or parents and returns boolean values
    private boolean hasLeftChild(int index) { return getLeftChildIndex(index) < size; }
    private boolean hasRightChild(int index) { return getRightChildIndex(index) < size; }
    private boolean hasParent(int index) { return getParentIndex(index) >= 0; }

    // functions to return the values stores at child or parent indexes
    private int leftChild(int index) { return items[getLeftChildIndex(index)]; }
    private int rightChild(int index) { return items[getRightChildIndex(index)]; }
    private int parent(int index) { return items[getParentIndex(index)]; }

    public void addValue(int data){
        // checks if the size is 0, adds value at index 0 if not and increases size by 1
        if (size == 0) {
            items[0] = data;
            size++;
        // if there is a head, adds the value to the next available index
        } else {
            items[size] = data;
            size++;
        }
        // sorts the heap
        sortHeapMax();


    }

    private void sortHeapMax(){
        // Gets the value of the final element
        int currentIndex = size - 1;
        // loops over each element of the tree, starting with the last
        while (currentIndex >= 0){
            // starting with the last element, gets the value at the current index
            int currentIndexValue = items[currentIndex];
            // gets the parent index
            int parentIndex = getParentIndex(currentIndex);
            // gets the value of the parent of the current index
            int parentIndexValue = items[parentIndex];
            // compares the current and parent values and swaps them if the current index value is higher
            if (currentIndexValue > parentIndexValue) {
                items[currentIndex] = parentIndexValue;
                items[parentIndex] = currentIndexValue;
            }
            // decrement current index
            currentIndex--;
        }
    }

    //function to print each node and it's associated child nodes, NULL is printed if there is no child node
    public void printHeap(){
        // variable for current position
        int currentPosition = 0;

        // loops while current index is less than 100
        while ( currentPosition < 100){
            // print the current nodes value
            System.out.print(items[currentPosition]);
            System.out.print(" ");
            // check if the current node has a right child, print it if so, if no value is found print NULL
            if (hasRightChild(currentPosition)) {
                System.out.print(rightChild(currentPosition));
            } else {
                System.out.print("NULL");
            }
            System.out.print(" ");
            // check if the current node has left child, print it if so, if no value is found print NULL
            if (hasLeftChild(currentPosition)) {
                System.out.println(leftChild(currentPosition));
            } else{
                System.out.println("NULL");
            }
            // increment current position
            currentPosition++;
        }

    }

}
