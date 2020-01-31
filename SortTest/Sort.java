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
                break;
            case 3://버블정렬 
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
    }

    public static void selectionSort(int[] arr) {
        //행렬을 인풋으로 받고 정렬한 뒤 출력

    }

    public static void insertionSort(int[] arr) {
        int tmpLen = arr.length;
        for(int i = 0;i < tmpLen;i++){
            //Todo완성해야 된다.
        }
    }

    public static void bubbleSort() {
        
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