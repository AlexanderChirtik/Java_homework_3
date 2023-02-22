import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String args[]) {
        Random random = new Random();
        int size = random.nextInt(10,20);
        int[] sortArray = new int[size];
        for (int i = 0; i < size; i++) {
            sortArray[i] = random.nextInt(0, 20);
        }
        System.out.println(Arrays.toString(sortArray));
        int[] result = mergeSort(sortArray);
        System.out.println(Arrays.toString(result));
    }

    public static int[] mergeSort(int[] arr) {
        int[] tempArray1 = Arrays.copyOf(arr, arr.length);
        int[] tempArray2 = new int[arr.length];
        int[] result = mergeSortInside(tempArray1, tempArray2, 0, arr.length);
        return result;
    }
    public static int[] mergeSortInside(int[] temp1, int[] temp2, int startIndex, int endIndex) {
        if (startIndex >= endIndex - 1) {
            return temp1;
        }
        int middle = startIndex + (endIndex - startIndex) / 2;
        int[] sorted1 = mergeSortInside(temp1, temp2, startIndex, middle);
        int[] sorted2 = mergeSortInside(temp1, temp2, middle, endIndex);

        int index1 = startIndex;
        int index2 = middle;
        int destIndex = startIndex;
        int[] result = sorted1 == temp1 ? temp2 : temp1;
        while (index1 < middle && index2 < endIndex) {
            result[destIndex++] = sorted1[index1] < sorted2[index2]
                    ? sorted1[index1++] : sorted2[index2++];
        }
        while (index1 < middle) {
            result[destIndex++] = sorted1[index1++];
        }
        while (index2 < endIndex) {
            result[destIndex++] = sorted2[index2++];
        }
        return result;
    }
}