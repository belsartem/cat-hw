/*
1
Need to create a method.
Given an array which might contain any elements and a number.
Method should return an array of sub-arrays of size of provided number.
Example 1:
Input: array: [4,1,6,2,5,2,3,5,9,4,10,1,4,4,4,6], size: 3
Output: [[4,1,6],[2,5,2],[3,5,9],[4,10,1],[4,4,4],[6]]

Example 2:
Input: array: [“acs”, “qwe”, ”Fs”, ”esg”, ””, ”f”, ”crew”, ”pdfs”, ”we”, ”xslt”, ”txt”], size: 2
Output: [[“acs”, “qwe”],[”Fs”, ”esg”],[””, ”f”,],[”crew”, ”pdfs”],[”we”, ”xslt”],[”txt”]]

2
Create tests
*/

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertTrue;

public class catHw {
    public static void main(String[] args) {

        String[] strings = new String[] {"acs", "qwe", "Fs", "esg", "", "f", "crew", "pdfs", "we", "xslt", "txt"};
        int size = 3;

        System.out.println("Source array: " + Arrays.toString(strings));
        String[][] subArrays = splitArrayByNumber(strings, size);
        System.out.println("Sub arrays by size " + size + ": " + Arrays.deepToString(subArrays));

    }

    // Splitting method

    public static String[][] splitArrayByNumber(String[] array, int size) {

        int numberOfSubArrays = (array.length + size - 1) / size;
        String[][] result = new String[numberOfSubArrays][];

        for (int i = 0; i < numberOfSubArrays; i++) {
            int start = i * size;
            int end = Math.min(start + size, array.length);
            int length = end - start;
            String[] sub = new String[length];

            System.arraycopy(array, start, sub, 0, length);
            result[i] = sub;
        }
        return result;
    }

    // JUnit tests

    @Test
    public void testSplitArray_NotDivisible() {
        String[] array = {"a", "b", "c", "d", "e"};
        int size = 2;
        String[][] expected = { {"a", "b"}, {"c", "d"}, {"e"} };
        String[][] actual = splitArrayByNumber(array, size);
        assertTrue("Expected " + Arrays.deepToString(expected) +
                        " but got " + Arrays.deepToString(actual),
                Arrays.deepEquals(expected, actual));
    }

    @Test
    public void testSplitArray_Divisible() {
        String[] array = {"a", "b", "c", "d"};
        int size = 2;
        String[][] expected = { {"a", "b"}, {"c", "d"} };
        String[][] actual = splitArrayByNumber(array, size);
        assertTrue("Expected " + Arrays.deepToString(expected) +
                        " but got " + Arrays.deepToString(actual),
                Arrays.deepEquals(expected, actual));
    }

    @Test
    public void testSplitArray_SizeGreaterThanArrayLength() {
        String[] array = {"a", "b", "c"};
        int size = 5;
        String[][] expected = { {"a", "b", "c"} };
        String[][] actual = splitArrayByNumber(array, size);
        assertTrue("Expected " + Arrays.deepToString(expected) +
                        " but got " + Arrays.deepToString(actual),
                Arrays.deepEquals(expected, actual));
    }

    @Test
    public void testSplitArray_EmptyArray() {
        String[] array = {};
        int size = 2;
        String[][] expected = {};
        String[][] actual = splitArrayByNumber(array, size);
        assertTrue("Expected " + Arrays.deepToString(expected) +
                        " but got " + Arrays.deepToString(actual),
                Arrays.deepEquals(expected, actual));
    }
}