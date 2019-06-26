package algorithm;

public class ShellSort {

    public static void ShellSort(int[] array){
        if(array == null){
            return;
        }
        int len = array.length;
        int k = len/2;
        while (k>0){
            for(int i =0; i< len; i++){
                for(int j=i; j>=0;j=j-k){
                    if((j-k)>=0){
                        if(array[j] < array[j-k]){
                            int temp = array[j];
                            array[j] = array[j-k];
                            array[j-k] = temp;
                        }
                    }

                }
            }
            k=k/2;
        }
    }

    public static void main(String[] args){
        int[] array  =  new int[]{10,2,15,21,14,16,78,33};
        ShellSort(array);
        for(int i = 0; i<array.length; i++){
            System.out.print(array[i] + ",");
        }
    }
}
