package algorithm;

public class BubbleSort {
    public static void BubbleSort(int[] array){
        if(array == null){
            return;
        }
        for(int i = 0; i<array.length-1; i++){
            for(int j = 0; j < array.length-1 - i; j++){
                if(array[j] > array[j+1]){
                    int temp = array[j+1];
                    array[j+1] = array[j];
                    array[j] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{11, 21, 5, 9,36};
        BubbleSort(array);
        for(int i = 0; i<array.length; i++){
            System.out.print(array[i] + ",");
        }
    }
}
