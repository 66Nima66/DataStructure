import java.util.Arrays;

class MinHeap {
    private int capacity = 10;
    private int size = 0;
    int[] items = new int[capacity];

    private int getLeftChildIndex(int parentIndex) {
        return 2 * parentIndex + 1;
    }

    private int getRightChildIndex(int parentIndex) {
        return 2 * parentIndex + 2;
    }

    private int parentIndex(int childIndex) {
        return (childIndex - 1) / 2;
    }

    private boolean hasLeftChild(int parentIndex) {
        return getLeftChildIndex(parentIndex) < size;
    }

    private boolean hasRightChild(int parentIndex) {
        return getRightChildIndex(parentIndex) < size;
    }

    private boolean hasParent(int childIndex) {
        return parentIndex(childIndex) >= 0;
    }

    private void swap(int indexOne, int indexTwo) {
        int temp = items[indexOne];
        items[indexOne] = items[indexTwo];
        items[indexTwo] = temp;
    }

    private void ensureExtraCapacity() {
        if (size == capacity) {
            items = Arrays.copyOf(items, capacity * 2);
            capacity *= 2;
        }
    }

    public int peek() {
        if (size == 0) {
            throw new IllegalStateException("Array is empty");
        } else {
            return items[0];
        }
    }

    public int remove() {
        if (size == 0) {
            throw new IllegalStateException("Array is empty");
        }

        int item = items[0];
        items[0] = items[size - 1];
        size--;
        heapifyDown();
        return item;
    }

    public void add(int item) {
        ensureExtraCapacity();
        items[size] = item;
        size++;
        heapifyUp();
    }

    public void heapifyUp() {
        int index = size - 1;
        while (hasParent(index) && items[parentIndex(index)] > items[index]) {
            swap(parentIndex(index), index);
            index = parentIndex(index);
        }
    }

    public void heapifyDown() {
        int index = 0;
        while (hasLeftChild(index)) {
            int smallerChildIndex = getLeftChildIndex(index);
            if (hasRightChild(index) && items[getRightChildIndex(index)] < items[smallerChildIndex]) {
                smallerChildIndex = getRightChildIndex(index);
            }

            if (items[index] < items[smallerChildIndex]) {
                break;
            } else {
                swap(index, smallerChildIndex);
            }
            index = smallerChildIndex;
        }
    }

    public int getSize() {
        return size;
    }

    public static void main(String[] args) {
        MinHeap heap = new MinHeap();
        heap.add(10);
        heap.add(5);
        heap.add(15);
        heap.add(3);

        System.out.println("Heap size: " + heap.getSize());
        System.out.println("Heap Cpacity is: " + heap.capacity);
    }
}
