import java.util.*;

public class mergeSortWithNoExtraSpace{

    private static void merge(int[] arr, int start, int end, int mid){
        int start1=start;
        int start2=mid+1;

        if(arr[mid]<=arr[start2]){
            display(arr);
            return;
        }

        while(start1<=mid && start2<=end){
            if(arr[start1]<=arr[start2]){
                start1++;
            }
            else{
                int value=arr[start2]; //value which need to swap with value at index start1
                int index=start2;

                while(index>start1){ //shiift all the arr elemnts between start1 to start2 1 position to right so that we will get a place to store the value at index1
                    arr[index]=arr[index-1];
                    index--;
                }

                arr[start1]=value;
                start1++;
                start2++;
                mid++;
            }
        }
        display(arr);
    }

    private static void mergeSortOptimize(int[] arr, int start, int end){
        if(start>=end){
            return;
        }
        int mid=(start+end)/2;
        mergeSortOptimize(arr, start, mid);
        mergeSortOptimize(arr, mid+1, end);

        merge(arr, start, end, mid);
    }

    private static void mergeSort(int[] arr){
        int start=0, end=arr.length-1;
        mergeSortOptimize(arr, start, end);
        System.out.println("The sorted array is");
        display(arr);
        return;
    }

    private static void display(int[] arr){
        // System.out.println(arr);
        for(int element: arr){
            System.out.print(element+" ");
        }
        System.out.println();
        System.out.println("------------------------------------------");
    }
    public static void main(String []args){
        Scanner sc=new Scanner(System.in);

        System.out.println("Enter the size of array");
        int size=sc.nextInt();
        System.out.println("Enter the elements in the array");
        int[] arr=new int[size];
        for(int i=0;i<size;i++){
            arr[i]=sc.nextInt();
        }

        mergeSort(arr);

        
    }
}

// 4 10 6 5 1 3 8 2 7 9