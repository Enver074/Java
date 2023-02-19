package Java_HW_3;

public class MergeSort {
    public static int[] sortMerge(int[] arr){

        if (arr == null){
            System.out.println("Массив пуст");
            return null;
        }
        if (arr.length < 2){
            return arr;
        }

        int[] left = new int[arr.length/2];
        int[] right = new int[arr.length - arr.length/2];

        System.arraycopy(arr, 0, left, 0, arr.length/2);
        System.arraycopy(arr, arr.length/2, right, 0, arr.length - arr.length/2);

        left = sortMerge(left);
        right = sortMerge(right);

        return merge(left, right);
    }
    private static int[] merge(int a[], int b[]){
        int[] res = new int[a.length + b.length];
        int n = a.length;
        int m = b.length;
        int i = 0, j = 0, k = 0;
        while (i < n && j < m) {
            if (a[i] <= b[j]){
                res[k] = a[i];
                i++;
            }
            else {
                res[k] = b[j];
                j++;
            }
            k++;
        }
        while (i < n){
            res[k] = a[i];
            i++;
            k++;
        }
        while (j < m){
            res[k] = b[j];
            j++;
            k++;
        }
    return res;
    }
}
