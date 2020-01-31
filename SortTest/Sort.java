package SortTest;

import java.util.Random;
import java.util.Scanner;

public class Sort{

    public static void main(final String[] args) {
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
        int x = 0;
        final Scanner sc = new Scanner(System.in);
        x = sc.nextInt();
        sc.close();
        
        switch(x){
            case 1://선택정렬
                selectionSort(makeInput());
                break;
            case 2://삽입정렬 
                insertionSort(makeInput());
                break;
            case 3://버블정렬 
                bubbleSort(makeInput());
                break;
            case 4://셸 정렬 
                break;
            case 5://합병정렬 
                break;
            case 6://퀵 정렬 
                break;
            case 7://히프정렬 
                break;
            case 8://기수정렬 
                break;
            case 9://종료 
                System.out.println("프로그램을 종료합니다.");
                return;
        }        
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

    public static void selectionSort(int[] arr) {
        //행렬을 인풋으로 받고 정렬한 뒤 출력
        //Selection sort : 제일 작은 element를 제일 왼쪽으로 옮기면서 루프를 줄여가자
        int tmpLen = arr.length;
        for(int i = 0;i < tmpLen-1;i++){        //0번째 원소와 나머지를 비교하기 때문에 길이-1까지 루프
            int least = i;                      //0번째 원소를 두고 1번째부터 비교하면서 끝까지
            for(int j = i+1;j < tmpLen;j++){
                int tmp = 0;
                if(arr[j] < arr[least]){
                    least = j;
                }
                tmp = arr[j];
                arr[i] = arr[least];
                
            }
        }
        showArray(arr);

    }

    public static void insertionSort(int[] arr) {
        int tmpLen = arr.length;
        for(int i = 1;i < tmpLen;i++){          //0번째는 정렬되어 있는 거니까 1부터 길이까지 루프
            int key = arr[i];
            for(int j = i-1;j >=0 && arr[j] > key;j--){ //과정을 이해해야됨 i번째 원소를 j번째와 비교하며 옮기는 것
                arr[j+1] = arr[j];
                arr[j] = key;       //Todo:이 부분이 맞나 확인해봐야됨 
            }
            
        }
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
        }
        showArray(arr);
    }

    public static void shellSort() {
        
    }

    public static void mergeSort() {
        
    }

    public static void quickSort() {
        
    }

    public static void heapSort() {
        
    }

    public static void radixSort() {
        
    }

}