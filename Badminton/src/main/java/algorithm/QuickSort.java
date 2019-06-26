package algorithm;

public class QuickSort {
    public static void  QuickSort(int[] array, int left, int right){
        if(array == null){
            return;
        }
        if(left < right){
            int mid = doSort(array, left, right);
            QuickSort(array, left, mid-1);
            QuickSort(array, mid, right);

        }
    }

    private static int doSort(int[] array, int left, int right){
        if(array == null){
            return left;
        }
        int mid = (left + right) / 2;
        int pivot = array[mid];

        while (left <= right) {
            while (array[left]<pivot) {
                ++left;
            }
            while (pivot<array[right]) {
                --right;
            }
            if (left <= right) {
                //swap(array, left, right);
                int temp = array[left];
                array[left] = array[right];
                array[right] = temp;
                ++left;
                --right;
            }
        }
        return left;
    }


    public static void main(String[] args){
        int[] array = new int[]{10, 2, 24, 11, 36, 21, 48, 9, 7, 49};
        QuickSort(array, 0, array.length-1);
        for(int a: array){
            System.out.print(a+ ",");
        }
    }
}
