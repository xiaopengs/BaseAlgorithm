package algorithm;

public class Insertsort {

    public static void Insertsort(int[] array){
        if(array == null){
            return;
        }
        int len = array.length;
        for(int i =0; i< len; i++){
            for(int j=i; j>=0;j--){
                if((j-1)>=0){
                    if(array[j] < array[j-1]){
                        int temp = array[j];
                        array[j] = array[j-1];
                        array[j-1] = temp;
                    }
                }

            }
        }
    }

    public static void main(String[] args){
        int[] array = new int[]{10,3,14,2,25,33,12};
        Insertsort(array);
        for(int i = 0; i<array.length; i++){
            System.out.print(array[i] + ",");
        }
    }
}
