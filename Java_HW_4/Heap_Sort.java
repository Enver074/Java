public class Heap_Sort {
    public static void main(String args[]){  // Управляющая программа
        int[] arr = {2121, 48, 7, 565, 77, 69, 56, 4};

        heapSort(arr); 
        printArray(arr);
        
    }

    private static void heapSort(int[] arr) {   // Реализация пирамидальной сортировки на Java
        int n = arr.length;

        // Построение кучи (перегруппируем массив)
        for(int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, i, n);
        
        // Один за другим извлекаем элементы из кучи 
        for (int i = n - 1; i >= 0; i--){
            int temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;
            
            // Вызываем процедуру heapify на уменьшенной куче
            heapify(arr, 0, i);
        }
    }
    
    // Процедура для преобразования в двоичную кучу поддерева с корневым узлом i, что является
    // индексом в arr[]. n - размер кучи
    private static void heapify(int[] arr, int i, int n) {  
        int l = i * 2 + 1;
        int r = i * 2 + 2;
        int largest = i;

        if(l < n && arr[l] > arr[largest])
            largest = l;
        if(r <n && arr[r] > arr[largest])
            largest = r;
        if(i != largest){
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;

            heapify(arr, largest, n);
        }
    }

    static void printArray(int arr[])  // функция вывода массива
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i]+" ");
        System.out.println();
    }
}