public class MaxHeap {
    private Post[] Heap;
    private int size;
    private int maxsize;
    public MaxHeap(int maxsize) {
        this.maxsize = maxsize;
        this.size = 0;
        Heap = new Post[this.maxsize];
    }
    private int parent(int pos) { return (pos - 1) / 2; }
    private int leftChild(int pos) { return (2 * pos) + 1; }
    private int rightChild(int pos)
    {
        return (2 * pos) + 2;
    }
    private boolean isLeaf(int pos)
    {
        if (pos > (size / 2) && pos <= size) {
            return true;
        }
        return false;
    }
    private void swap(int fpos, int spos)
    {
        Post tmp;
        tmp = Heap[fpos];
        Heap[fpos] = Heap[spos];
        Heap[spos] = tmp;
    }
    private void maxHeapify(int pos)
    {
        if (isLeaf(pos))
            return;

        if (Heap[pos].getLikes() < Heap[leftChild(pos)].getLikes()
                || Heap[pos].getLikes() < Heap[rightChild(pos)].getLikes()) {

            if (Heap[leftChild(pos)].getLikes()
                    > Heap[rightChild(pos)].getLikes()) {
                swap(pos, leftChild(pos));
                maxHeapify(leftChild(pos));
            }
            else {
                swap(pos, rightChild(pos));
                maxHeapify(rightChild(pos));
            }
        }
    }
    public void insert(Post element) {
        Heap[size] = element;
        int current = size;
        while (Heap[current].getLikes() > Heap[parent(current)].getLikes()) {
            swap(current, parent(current));
            current = parent(current);
        }
        size++;
    }
    public void print() {
        for (int i = 0; i < size / 2; i++) {
            System.out.print("Parent Node : " + Heap[i]);
            if (leftChild(i) < size) // if the child is out of the bound
                System.out.print(" Left Child Node: " + Heap[leftChild(i)]);
            if (rightChild(i) < size) // if the right child index must not
                System.out.print(" Right Child Node: " + Heap[rightChild(i)]);
            System.out.println(); // for new line
        }
    }
    public Post extractMax()
    {
        Post popped = Heap[0];
        Heap[0] = Heap[--size];
        maxHeapify(0);
        return popped;
    }
}
