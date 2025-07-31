package be.codesolutions.leetcode;

public class MedianOfTwoSortedArrays {

    public static void main(String[] args) {
        MedianOfTwoSortedArrays.findMedianSortedArrays(new int[]{1, 3}, new int[]{2});
        MedianOfTwoSortedArrays.findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4});
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] mergedArray = new int[nums1.length + nums2.length];

        int i = 0;
        int j = 0;
        int k = 0;

        if (nums1.length == 0) {
            return calculateAverage(nums2);
        }

        if (nums2.length == 0) {
            return calculateAverage(nums1);
        }

        while (k < mergedArray.length && i < nums1.length && j < nums2.length) {
            if (nums1[i] <= nums2[j]) {
                mergedArray[k++] = nums1[i];
                if (i >= (nums1.length - 1)) {
                    append(mergedArray, k, nums2, j);
                    break;
                } else {
                    ++i;
                }
            } else {
                mergedArray[k++] = nums2[j];
                if (j >= (nums2.length - 1)) {
                    append(mergedArray, k, nums1, i);
                    break;
                } else {
                    ++j;
                }
            }
        }

        double result = calculateAverage(mergedArray);
        System.out.println(result);
        return result;
    }

    private static void append(int[] array, int resultIndex, int[] array2, int index) {
        while (index < array2.length) {
            array[resultIndex++] = array2[index++];
        }
    }

    private static double calculateAverage(int[] array) {
        return array.length % 2 == 0 ?
                (array[array.length / 2] + array[array.length / 2 - 1]) / 2.0 :
                array[array.length / 2];
    }
}
