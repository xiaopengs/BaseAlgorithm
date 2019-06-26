package algorithm;

public class MergeSort {

    public static void MergeSort(int[] array, int left, int right){
        if (array == null){
            return;
        }
        int mid = left + (right - left)/2;
        if(right > left){
            MergeSort(array, left, mid);
            MergeSort(array, mid +1, right);

            sort(array, left, mid, right);
        }

    }

    public static void sort(int[] array, int left, int mid, int right){
        int i = left;
        int j = mid + 1;
        int k = left;

        int[] temp = new int[array.length];
        System.arraycopy(array, 0, temp, 0, array.length);
        while (i <= mid && j <= right) {
            if (temp[i]<= temp[j] ) {
                array[k++] = temp[i++];
            } else {
                array[k++] = temp[j++];
            }
        }

        while (i <= mid) {
            array[k++] = temp[i++];
        }

        while (j <= right) {
            array[k++] = temp[j++];
        }

    }


    public static void main(String[] args){
        int[] array  =  new int[]{10,2,15,21,14,16,78,33};
        MergeSort(array, 0, array.length -1);
        for(int i = 0; i<array.length; i++){
            System.out.print(array[i] + ",");
        }
    }
}
