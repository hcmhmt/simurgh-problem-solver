package leetCode;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class MedianOfTwoSortedArrays {

    public static void main(String[] args) {

        int[] a = new int[]{1, 3};
        int[] b = new int[]{2};
        System.out.println(findMedianSortedArrays(a, b));

        a = new int[]{1, 2};
        b = new int[]{3, 4};
        System.out.println(findMedianSortedArrays(a, b));
        System.out.println(findMedianSortedArraysBest(a, b));

    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

        List<Integer> integerList = Arrays.stream(nums1)
                .boxed()
                .collect(Collectors.toList());

        integerList.addAll(Arrays.stream(nums2)
                .boxed()
                .collect(Collectors.toList()));

        Collections.sort(integerList);

        if (integerList.size() % 2 == 1) {
            return integerList.get(integerList.size() / 2);
        }

        return integerList.size() % 2 == 1 ? integerList.get(integerList.size() / 2) : ((double) integerList.get(integerList.size() / 2) + (double) integerList.get((integerList.size() / 2) - 1)) / 2;
    }

    public static double findMedianSortedArrays3(int[] nums1, int[] nums2) {

        List<Double> doubleList = Arrays.stream(nums1).asDoubleStream().boxed().collect(Collectors.toList());

        doubleList.addAll(Arrays.stream(nums2).asDoubleStream().boxed().collect(Collectors.toList()));

        Collections.sort(doubleList);

        if (doubleList.size() % 2 == 1) {
            return doubleList.get(doubleList.size() / 2);
        }

        return doubleList.size() % 2 == 1 ? doubleList.get(doubleList.size() / 2) : (doubleList.get(doubleList.size() / 2) + doubleList.get((doubleList.size() / 2) - 1)) / 2;
    }

    public static double findMedianSortedArrays2(int[] nums1, int[] nums2) {

        List<Integer> integerLinkedList = new LinkedList<>(Arrays.stream(nums1).boxed().collect(Collectors.toList()));
        integerLinkedList.addAll(Arrays.stream(nums2)
                .boxed()
                .collect(Collectors.toList()));

        Collections.sort(integerLinkedList);

        if (integerLinkedList.size() % 2 == 1) {
            return integerLinkedList.get(integerLinkedList.size() / 2);
        }

        return integerLinkedList.size() % 2 == 1 ? integerLinkedList.get(integerLinkedList.size() / 2) : ((double) integerLinkedList.get(integerLinkedList.size() / 2) + (double) integerLinkedList.get((integerLinkedList.size() / 2) - 1)) / 2;
    }

    public static double findMedianSortedArraysBest(int[] nums1, int[] nums2) { // best memory

        int[] mergedNums = new int[nums1.length + nums2.length];

        int i = 0;
        int j = 0;
        int k = 0;

        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                mergedNums[k] = nums1[i];
                i++;
            } else {
                mergedNums[k] = nums2[j];
                j++;
            }
            k++;
        }


        while (i < nums1.length) {
            mergedNums[k] = nums1[i];
            i++;
            k++;
        }

        while (j < nums2.length) {
            mergedNums[k] = nums2[j];
            j++;
            k++;
        }

        if (mergedNums.length % 2 == 0) {
            return ((double) mergedNums[mergedNums.length / 2] + (double) mergedNums[mergedNums.length / 2 - 1]) / 2;
        } else {
            return (double) mergedNums[mergedNums.length / 2];
        }
    }

}