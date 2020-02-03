package SortTest;

import java.util.Random;
import java.util.Scanner;
import java.util.Arrays;

public class Sort{

    public static void main(final String[] args) {
        printMenu();
        int x = 0;
        
        while(x != 9){
            Scanner sc = new Scanner(System.in);
            x = sc.nextInt();
            
            switch(x){
                case 1://선택정렬  TODO:문제있음 - 데이터가 변경되고 있음 - SWMP실수 변경
                    selectionSort(makeInput());
                    printMenu();
                    break;
                case 2://삽입정렬 
                    insertionSort(makeInput());
                    printMenu();
                    break;
                case 3://버블정렬 
                    bubbleSort(makeInput());
                    printMenu();
                    break;
                case 4://셸 정렬 
                    shellSort(makeInput());
                    printMenu();
                    break;
                case 5://합병정렬   TODO:Need a Exception Handle  
                    int[] mergeTmpArr = new int[10];
                    mergeTmpArr = makeInput();
                    int mergeTmpLeft = mergeTmpArr[0];
                    int mergeTmpRight = mergeTmpArr[9];
                    mergeSort(mergeTmpArr, mergeTmpLeft, mergeTmpRight);
                    printMenu();
                    break;
                case 6://퀵 정렬 
                    int[] quickTmpArr = new int[10];
                    quickTmpArr = makeInput();
                    int quickTmpLeft = quickTmpArr[0];
                    int quickTmpRight = quickTmpArr[9];
                    quickSort(quickTmpArr,quickTmpLeft, quickTmpRight); //TODO:오류 있음 ArrayIndexOutofBoundException:16
                    printMenu();
                    break;
                case 7://히프정렬
                    heapSort(makeInput());
                    printMenu();
                    break;
                case 8://기수정렬  https://journee912.tistory.com/54
                    radixSort(makeInput());
                    printMenu();
                    break;
                case 9://종료 
                    System.out.println("프로그램을 종료합니다.");
                    return;
            }
        }
                
    }
    
/***************************************************************************
 * 정렬 함수들 정의하는 부분
****************************************************************************/


    public static void selectionSort(int[] arr) {
        //행렬을 인풋으로 받고 정렬한 뒤 출력
        //Selection sort : 제일 작은 element를 제일 왼쪽으로 옮기면서 루프를 줄여가자
        int tmpLen = arr.length;
        for(int i = 0;i < tmpLen-1;i++){        //0번째 원소와 나머지를 비교하기 때문에 길이-1까지 루프
            int least = i;                      //0번째 원소를 두고 1번째부터 비교하면서 끝까지
            int tmp = 0;
            for(int j = i+1;j < tmpLen;j++){
                
                if(arr[j] < arr[least]){
                    least = j;
                }
            }
            tmp = arr[least];
            arr[least] = arr[i];
            arr[i] = tmp;
            showArray(arr);
        }
        System.out.print("최종결과 :");
        showArray(arr);

    }

    public static void insertionSort(int[] arr) {
        int tmpLen = arr.length;
        for(int i = 1;i < tmpLen;i++){          //0번째는 정렬되어 있는 거니까 1부터 길이까지 루프
            int key = arr[i];
            for(int j = i-1;j >=0 && arr[j] > key;j--){ //과정을 이해해야됨 i번째 원소를 j번째와 비교하며 옮기는 것
                arr[j+1] = arr[j];
                arr[j] = key;       //Todo:이 부분이 맞나 확인해봐야됨 
                showArray(arr);
            }
            
        }
        System.out.print("최종결과 :");
        showArray(arr);
    }

    public static void bubbleSort(int[] arr) {      //맨 뒤쪽에 큰 값을 넣어주면서 정렬
        int tmpLen = arr.length;
        for(int i = tmpLen -1;i > 0;i--){       //행렬길이 때문에 하나 줄어보이는 것
            for(int j = 0; j < i; j++){
                if(arr[j] > arr[j+1]){
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }
                
            }
            showArray(arr);
        }
        System.out.print("최종결과 :");
        showArray(arr);
    }

    public static void shellSort(int[] arr) {
        int tmpLen = arr.length;
        int gap;
        for(gap = tmpLen/2; gap > 0; gap /= 2){
            if(gap%2 == 0){
                gap++;
            }
            for(int i = 0;i < gap; i++){
                inc_insertionSort(arr, i, tmpLen-1, gap);
            }
        }
        System.out.print("최종결과 :");
        showArray(arr);
    }

    public static void inc_insertionSort(int[] arr, int first, int last, int gap) {
        int i, j, key;
        for(i = first + gap; i <= last; i += gap){
            key = arr[i];
            for(j = i-gap; j >= first && key < arr[j]; j -= gap){
                arr[j + gap] = arr[j];
            }
            arr[j+gap] = key;
        }
    }

    public static void mergeSort(int[] arr, int left, int right) {
        int mid;
        if(left < right){
            mid = (left + right)/2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid+1, right);
            merge(arr, left, mid, right);
            
        }
        else{
            System.out.println("오류");
        }
        System.out.print("최종결과 :");
        showArray(arr);
        
    }

    public static void merge(int[] arr, int left, int mid, int right) {
        int tmpLen = arr.length;
        int[] sorted = new int[tmpLen];
        int i, j, k, l;
        i = left;
        j = mid + 1;
        k = right;
        while(i <= mid && j <=right){
            if(arr[i] <= arr[j]){
                sorted[k++] = arr[i+1];
            }
            else{
                sorted[k++] = arr[j+1];
            }
        }
        if(i > mid){
            for(l = j;l <= right; l++){
                sorted[k++] = arr[l];
            }
        }
        else{
            for(l = i;l <= mid; l++){
                sorted[k++] = arr[l];
            }
        }
        for(l = left;l <= right; l++){
            arr[l] = sorted[l];
        }
    }
    
    public static void quickSort(int[] arr, int left, int right) {
        int arrLeft = arr[0];
        int arrRight = arr[9];
        if(left < right){
            int q = partition(arr, arrLeft, arrRight);  //TODO:오류 있음 ArrayIndexOutofBoundException:16
            quickSort(arr, left, q-1);
            quickSort(arr, q+1, right);
        }
        System.out.print("최종결과 :");
        showArray(arr);
    }
    
    public static int partition(int[] arr, int left, int right) {
        int pivot, temp;
        int low, high;
        low = left;
        high = right + 1;
        pivot = arr[left];  //TODO:오류 있음 ArrayIndexOutofBoundException:16
        do{
            do{
                low++;
                do{
                    high--;
                    
                    if(low < high){
                        try {
                            temp = arr[low];
                            arr[low] = arr[high];
                            arr[high] = temp;
                            showArray(arr);    
                        } catch (Exception e) {
                            System.out.println("파티션함수 오류");//TODO: handle exception
                        }
                        
                    }
                }while(high >= left && arr[high] > pivot);
            }while(low <= right && arr[low] < pivot);
            
        }while(low < high);
        return high;
    }
    
    public static void heapSort(int[] arr) {
        Heap heap = new Heap();
        for(int i = 0; i < arr.length;i++){
            heap.insertHeap(arr[i]);
        }
        for(int i = arr.length-1; i >= 0; --i){
            arr[i] = heap.deleteHeap();
        }
        //https://palpit.tistory.com/130 - 알고리즘 URL
        System.out.print("최종결과 :");
        showArray(arr);
        /*Heapsort ver1
        for(int i = 1; i < number; i++){
            int child = i;
            while(child > 0){
                int parent = (child -1)/2;
                if(arr[child] > arr[parent]){
                    int tmp = arr[parent];
                    arr[parent] = arr[child];
                    arr[child] = tmp;
                }
                child = parent;
            }
        }
        //for(int i = 1; i < number-1;i++)
        heapResultSort(arr, number);
        System.out.print("최종결과 :");
        showArray(arr);
        */
    }
    /*
    public static void heapResultSort(int[] arr, int number) {
        for(int i = number-1; i > 0; i--){
            int tmp = arr[0];
            arr[0] = arr[i];
            arr[i] = tmp;

            heapSort(arr, i);
            
        }
    }
    */
    public static void radixSort(int[] arr) {
        int m = getMax(arr);
        for(int exp = 1; m/exp>0; exp*=10){
            countSort(arr, exp);
        }
        System.out.print("최종결과 :");
        showArray(arr); 
    }
    //Radix Sort를 위한 함수
    public static void countSort(int[] arr, int exp) {
        int[] output = new int[arr.length];
        int[] count = new int[10];
        Arrays.fill(count, 0);

        for(int i = 0; i < arr.length;i++){
            count[(arr[i]/exp)%10]++;
        }
        for(int i = 1; i < 10;i++){
            count[i] += count[i-1];
        }
        for(int i = arr.length-1; i >=0; i--){
            output[count[(arr[i]/exp)%10]-1] = arr[i];
            count[(arr[i]/exp)%10]--;
        }
        for(int i = 0; i < arr.length;i++){
            arr[i] = output[i];
        }

    }
    //Radix Sort를 위한 함수
    public static int getMax(int[] arr) {
        int max = arr[0];
        for(int i = 1; i < arr.length;i++){
            if(arr[i] > max){
                max = arr[i];
            }
        }
        return max;
    }

    
    public static void printMenu() {
        System.out.println("사용할 sort의 종류를 선택하세요");
        System.out.println("1.선택정렬");
        System.out.println("2.삽입정렬");
        System.out.println("3.버블정렬");
        System.out.println("4.셸 정렬");
        System.out.println("5.합병정렬");
        System.out.println("6.퀵 정렬");
        System.out.println("7.히프정렬");
        System.out.println("8.기수정렬");
        System.out.println("9.종료");
    }

    public static int[] makeInput() {
        // 입력으로 쓸 행렬을 scanner로 입력받아 생성한다.
        // 리턴은 행렬
        final int input[] = new int[10];
        final Random rd = new Random();
        for(int i = 0;i < 10;i++){
            input[i] = rd.nextInt(100)+1;
        }
        showArray(input);
        return input;
    }

    public static void showArray(int[] arr) {
        //행렬을 보여주는 함수
        //입력으로 행렬을 받고 출력은 필요없이 행렬을 프린트해주면 된다.
        int tmpLen = arr.length;
        for(int i = 0;i < tmpLen;i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    /*
    public static int[] stdMaker(int[] arr) {
        int[] answer = new int[12];
        int left = arr[0];
        int right = arr[9];
        answer[0] = left;
        answer[1] = right;
        for(int i =2;i < 12;i++){
            answer[i] = arr[i-2];
        }
        return answer;
    }
    */ 

}