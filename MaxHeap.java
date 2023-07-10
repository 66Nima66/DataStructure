import java.util.Arrays;

/**
 * NIMA BAHRAMI 
 * MaxHeap
 */

public class MaxHeap {

    int capacity = 10;
    int size = 0;
    int[] items = new int[capacity];
    private int getLeftChildIndex(int nodeIndexInArray) {

        return (nodeIndexInArray * 2) + 1;
    }
    private boolean hasLeftChild(int nodeIndexInArray) {

        return (nodeIndexInArray * 2) > size; 
    }
    private int getRightChildIndex(int nodeIndexInArray) {

        return (nodeIndexInArray * 2) + 2; 
    }
    private boolean hasRightChild(int nodeIndexInArray) {

        return (nodeIndexInArray * 2) + 2 > size; 
    }
    private int getParentIndex(int nodeIndexInArray){

        return (nodeIndexInArray - 1) / 2;
    }
    private boolean hasParent(int nodeIndexInArray) {

         return (nodeIndexInArray -1) / 2 >= 0;
    }

    private void swapElementsInArray(int indexOne ,int indexTwo) {
        //save the the element into temporary variable
        int temp = items[indexOne];
        items[indexOne] = items[indexTwo];
        items[indexTwo] = temp;
    }
    //method that ensure the size of array
    private void ensureExtraCapacity() {
        if (size == capacity){
            items = Arrays.copyOf(items, capacity * 2);
            capacity *= 2;
        }
    }
    //add element method!
    public void addElement(int newElement) {
        //check if array has free spot for new element
        ensureExtraCapacity();
        items[size + 1] = newElement;
        size++;
        heapifyUp();
    }

    public int peek() {
        if (size == 0) {throw new IllegalStateException("Array Is Empty");}
        else
        return items[0];
    }

    public int poll () {
        //replace the top with last node
        int top = peek();
        swapElementsInArray( 0 , size - 1);
        size--;
        heapifyDown();
        return top;
    }

    public void heapifyUp() {
        int index  = size - 1;
        while(hasParent(index) && items[getParentIndex(index)] < items[index]) {
            swapElementsInArray(index, getParentIndex(index));
            index = getParentIndex(index);
        }

    }

    public void heapifyDown() {
        int index = 0;
        while (hasLeftChild(index)) {
            int BiggetChildIndex = getLeftChildIndex(index);
            if (hasRightChild(index) && items[getLeftChildIndex(index)] < items[getRightChildIndex(index)]) {
                BiggetChildIndex = getRightChildIndex(index);
            }
            if (items[index] > items[BiggetChildIndex]){
                break; 
            }else {
                swapElementsInArray(index, BiggetChildIndex);
            }
            index = BiggetChildIndex;
        }
    }
 