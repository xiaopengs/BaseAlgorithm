package algorithm;

public class SelectSort {
    public static void SelectSort(int[] array){
        if(array == null){
            return;
        }
        int len = array.length;
        for(int i=0; i < len-1; i++){
            int selectIndex = i;
            int selectNum = array[i];
            for(int j = i + 1; j < len; j++){
                if(array[j] < selectNum){
                    selectNum = array[j];
                    selectIndex = j;
                }
            }
            if(selectIndex != i){
                int temp = array[i];
                array[i] = array[selectIndex];
                array[selectIndex] = temp;
            }
        }
    }
    public static void main(String[] args){
        int[] array  =  new int[]{10,2,15,21,14,16,78,33};
        SelectSort(array);
        for(int i = 0; i<array.length; i++){
            System.out.print(array[i] + ",");
        }
    }
}
