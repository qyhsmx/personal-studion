package com.qyy.test;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @description: 这是代码里唯一的注释
 * @author: QinYong
 * @create: 2020-04-29 13:44
 **/
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            int[] num = new int[13];
            int[] aa = new int[5];
            for (int i = 0; i < 5; i++) {
                int temp = sc.nextInt();
                aa[i] = temp;
                num[temp - 1]++;
            }

            Arrays.sort(num);
            Arrays.sort(aa);

            if (num[12] == 4) {
                System.out.println(1);
            } else if (num[12] == 3 && num[11] == 2) {
                System.out.println(2);
            } else if (num[12] == 3 && num[11] == 1) {
                System.out.println(3);
            } else if (num[12] == 2 && num[11] == 2) {
                System.out.println(4);
            } else if (num[12] == 2 && num[11] == 1) {
                System.out.println(7);
            } else {
                boolean flag = true;
                for (int i = 1; i < 5; i++) {
                    if (aa[i] != aa[0] + i) {
                        System.out.println(6);
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    System.out.println(5);
                }
            }

        }

    }
}
