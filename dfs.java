package com.mycompany.dfs;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Dfs {
    static int N = 8;
    static int[] c = new int[N];
    static int[][] list = new int[N][];

    static int[] color = new int[N + 1];
    static int[] prev = new int[N + 1];
    static int[] f = new int[N + 1];
    static int[] d = new int[N + 1];
    static int time = 0;

    public static void main(String[] args) {
        readInputsFromFile("C:\\Users\\Maruf\\OneDrive\\Documents\\NetBeansProjects\\dfs\\src\\main\\java\\com\\mycompany\\dfs\\dfs.txt");
        for (int i = 0; i < N; i++) {
            color[i] = 0;
            prev[i] = 1;
            d[i] = f[i] = 1000000;
        }
        for (int i = 1; i <= N; i++) {
            if (color[i] == 0) {
                runDFS(i);
            }
        }
    }

    private static void readInputsFromFile(String fileName) {
        try {
            Scanner scanner = new Scanner(new File(fileName));
            for (int i = 0; i < N; i++) {
                c[i] = scanner.nextInt();
                int length = scanner.nextInt();
                list[i] = new int[length];
                for (int j = 0; j < length; j++) {
                    list[i][j] = scanner.nextInt();
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
        }
    }

    private static void runDFS(int u) {
        System.out.print(c[u - 1] + " ");
        color[u] = 1;
        time++;
        d[u] = time;
        for (int i = 0; i < list[u - 1].length; i++) {
            int v = list[u - 1][i];
            if (color[v] == 0) {
                prev[v] = u;
                runDFS(v);
            }
        }
        color[u] = 2;
        time++;
        f[u] = time;
    }
}
//1 3 2 3 4
//2 2 1 5
//3 2 1 6
//4 2 1 7
//5 2 6 7
//6 3 3 5 8
//7 3 4 5 8
//8 2 6 7
