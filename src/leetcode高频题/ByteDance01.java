package leetcode高频题;

import java.util.Arrays;

/**
 * 大厂算法面试
 *
 * @author menglin
 * 2021/11/26
 */
@SuppressWarnings("all")
public class ByteDance01 {


    // 题目1  给定一个多叉树的头节点head

    /**
     * 有序数组的平方
     * 解法1
     */
    public static int[] squareArray1(int[] a) {

        int[] newArray = new int[a.length];
        int i = 0;
        int j = a.length - 1;
        int index = a.length - 1;
        while (i <= j) {
            int val1 = a[i] * a[i];
            int val2 = a[j] * a[j];
            if (val1 > val2) {
                newArray[index--] = val1;
                i++;
            } else {
                newArray[index--] = val2;
                j--;
            }
        }
        return newArray;
    }

    /**
     * 解法2
     */
    public static int[] squareArray2(int[] a) {
        int[] arr = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            arr[i] = a[i] * a[i];
        }
        //对平方后的数组排序
        Arrays.sort(arr);
        return arr;
    }

    //for test
    public static void main(String[] args) {
        int[] a = new int[]{-1, 2, 3, -4, 0, 9, -6};
        String s1 = Arrays.toString(squareArray1(a));
        String s2 = Arrays.toString(squareArray2(a));
        System.out.println("解法1: " + s1);
        System.out.println("解法2: " + s2);
    }
}
