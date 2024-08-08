public class BubbleSort {
    static void printArray(int[] arr) {
        for (int j : arr) {
            System.out.print(j + " ");
        }
        System.out.println();
    }

    static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    printArray(arr); // Muestra el paso a paso
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {21, 40, 4, 9, 10, 35};

        System.out.println("Array inicial: ");
        printArray(arr);

        bubbleSort(arr);

        System.out.println("Array ordenado: ");
        printArray(arr);
    }
}
