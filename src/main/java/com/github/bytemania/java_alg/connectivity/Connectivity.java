package com.github.bytemania.java_alg.connectivity;

import java.io.*;
import java.util.Scanner;

public class Connectivity {

    private Connectivity() {}

    public static void main(String[] args) {
        try (Scanner in = new Scanner(new File(args[0]))){
            int n = in.nextInt();

            UF uf = new UF(n);
            while (in.hasNext()) {
                int p = in.nextInt();
                int q = in.nextInt();
                if(!uf.connected(p, q)) {
                    uf.union(p, q);
                    System.out.println(p + " " + q);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
