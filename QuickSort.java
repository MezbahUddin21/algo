package com.mycompany.quicksort;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author Maruf
 */

public class QuickSort {
    static int[] arr;
    static int N;

    public static void main(String[] args) {
        readInputsFromFile("C:\\Users\\Maruf\\OneDrive\\Documents\\NetBeansProjects\\quickSort\\src\\main\\java\\com\\mycompany\\quicksort\\textQ.txt");
        quickSort(arr, 0, arr.length - 1);
        System.out.println("The sorted array is: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
     private static void readInputsFromFile(String fileName) {
        try {
            Scanner scanner = new Scanner(new File(fileName));
            int N=scanner.nextInt();
            arr= new int[N];
            for (int i = 0; i < N; i++) {
                arr[i] = scanner.nextInt();
                
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
        }
    }

    public static int partition(int[] a, int beg, int end) {
        int left = beg;
        int right = end;
        int temp, loc, flag;
        loc = left;
        flag = 0;
        while (flag != 1) {
            while ((a[loc] <= a[right]) && (loc != right)) {
                right--;
            }
            if (loc == right) {
                flag = 1;
            } else {
                temp = a[loc];
                a[loc] = a[right];
                a[right] = temp;
                loc = right;
            }
            if (flag != 1) {
                while ((a[loc] >= a[left]) && (loc != left)) {
                    left++;
                }
                if (loc == left) {
                    flag = 1;
                } else {
                    temp = a[loc];
                    a[loc] = a[left];
                    a[left] = temp;
                    loc = left;
                }
            }
        }
        return loc;
    }

    static void quickSort(int[] a, int beg, int end) {
        if (beg < end) {
            int loc = partition(a, beg, end);
            quickSort(a, beg, loc - 1);
            quickSort(a, loc + 1, end);
        }
    }
}
