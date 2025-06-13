public class LinearSearch {
    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;  // target not found
    }

    public static void main(String[] args) {
        int[] numbers = {5, 3, 7, 1, 9};
        int target = 7;
        int result = linearSearch(numbers, target);
        
        if (result == -1) {
            System.out.println("Element not found");
        } else {
            System.out.println("Element found at index: " + result);
        }
    }
}