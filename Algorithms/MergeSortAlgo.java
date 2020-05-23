class SortArray{

    public void mergeSort(int a[], int start, int end){

        if(start<end){
            int mid = start + (end-start)/2;
            
            mergeSort(a,start,mid);
            mergeSort(a,mid+1,end);
            merge(a,start,end,mid);
        }
    }

    public void merge(int a[], int start, int end, int mid){

        int tempArray[] = new int[end+1];
        int p=start, q=mid+1, k=0;
        for(int i = start; i<end;i++){
            
            if(q>=end){
                tempArray[k++]=a[p++];
            }
            else if(p>mid){
                tempArray[k++]=a[q++];
            }
            else if(a[p]>a[q]){
                tempArray[k++]=a[q++];
            }
            else if(a[p]<a[q]){
                tempArray[k++]=a[p++];
            }
            
        }

        for(int i =0;i<k;i++){
            a[start++]=tempArray[i];
        }

    }

}

public class MergeSortAlgo {
 
    public static void main(String[] args){
        int[] arr=new int[]{10,85,14,56,78,15,26,45,98,2,13,156};
        SortArray sortArray = new SortArray();
        System.out.println("\n----Before Sorting-----");
        for(int a: arr){
            System.out.print(a+"->");
        }
        sortArray.mergeSort(arr,0,arr.length);
        System.out.println("\n----After Sorting-----");
        for(int a: arr){
            System.out.print(a+"->");
        }
    }
}