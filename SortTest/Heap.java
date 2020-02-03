package SortTest;

public class Heap{
    static int heapSize;
    static int items[];

    public Heap(){
        heapSize = 0;
        items = new int[20];
    }

    public void insertHeap(int item){
        int i = ++heapSize;

        while((i!=1)&&(item > items[i/2])){
            items[i] = items[i/2];
            i /= 2;
        }

        items[i] = item;
    }

    public int deleteHeap() {
        int parent, child;
        int item, tmp;
        item = items[1];
        tmp = items[heapSize--];
        parent = 1;
        child = 2;

        while(child <= heapSize){
            if((child < heapSize)&&(items[child] < items[child+1])){
                child++;
            }
            if(tmp >= items[child]){
                break;
            }
            items[parent] = items[child];
            parent = child;
            child *= 2;
        }

        items[parent] = tmp;
        return item;
        
    }
}