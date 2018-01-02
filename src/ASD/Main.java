package ASD;

public class Main {

    public static void main(String[] args) {
        int[] num = { 3,6,1,7,2,8,10,4,9,5};
        int n = num.length;

        mergeSort(num, 0, n - 1);

        for (int h = 0; h < n; h++)
            System.out.print(num[h]+ " ");
    }

    public static void mergeSort(int[] elements, int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            mergeSort(elements, low, mid);
            mergeSort(elements, mid + 1, high);
            merge(elements, low, mid, high);
        }
    }

    private static void merge(int[] subset, int low, int mid, int high) {
        int n = high-low+1;
        int[] Temp = new int[n];
        int i = low, j = mid + 1;
        int k = 0;
        while (i <= mid || j <= high) {
            if (i > mid)
                Temp[k++] = subset[j++];
            else if (j > high)
                Temp[k++] = subset[i++];
            else if (subset[i] < subset[j])
                Temp[k++] = subset[i++];
            else
                Temp[k++] = subset[j++];
        }
        for (j = 0; j < n; j++)
            subset[low + j] = Temp[j];
    }
}
