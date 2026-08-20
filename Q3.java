public class Q3 {
    /*Array Algotithms:
        1> Update An Array
        2> Linear Search
        3> Binary Search
        4> Reverse an Array
        5> Largest & Smallest element in an Array
        6> Maximum Subarray and Subarray Sum
        7> Kadane's Algorithm
     */
    public static void update(int arr[]){
        for(int i=0;i<arr.length;i++){
        arr[i]++;
        }
    }

    public static int linearSearch(int num[],int key1){
        for(int i=0;i<num.length;i++){
            if(num[i]==key1){
                return i;
            }
        }
       return -1;
    }
    

    public static int binarySearch(int numbers[],int key2){
        int start=0,end=numbers.length-1;
        while(start<=end){
            int mid=(start+end)/2;
            //comparisons
            if(numbers[mid]==key2){//found
                return mid;
            }
            else if(numbers[mid] < key2){//right
                start = mid + 1;
            }
            else{//left
                end = mid - 1;
            }
        }
        return -1;//doesn't exist
    }
    public static void reverse(int numbers[]){
        int first=0, last=numbers.length-1;
        while(first<last){
            int temp=numbers[last];
            numbers[last]=numbers[first];
            numbers[first]=temp;

            first++;
            last--;
        }
    }

    public static int largest_and_smallest(int num[]){
        int largest=Integer.MIN_VALUE;
        int smallest=Integer.MAX_VALUE;
        for(int i=0;i<num.length;i++){
            if(largest<num[i]){
                largest=num[i];
            }
            if(smallest>num[i]){
                smallest=num[i];
            }
        }
        System.out.println();
        System.out.println("Smallest element is: " + smallest);
        return largest;
    }


    public static void printPairs(int numbers[]){
        int tp=0;
        for(int i=0;i<numbers.length;i++){
            int current=numbers[i];
            for(int j=i+1;j<numbers.length;j++){
                System.out.print("("+current+","+numbers[j]+")");
                 tp++;
            } 
            System.out.println();
        }
        System.out.println("Total pairs:"+tp);
        
    }
    public static void subArrays(int numbers[]){
        int ts=0;
        int sum=0;
        int maxSum=Integer.MIN_VALUE;
        int prefix[]=new int[numbers.length];

        prefix[0]=numbers[0];
        //calculate prefix array
        for(int i=1;i<prefix.length;i++){
            prefix[i]=prefix[i-1]+numbers[i];
            System.out.println(prefix[i]);
        }
        for(int i =0;i<numbers.length;i++){
           int start=i;
            for(int j=i;j<numbers.length;j++){
                int end=j;
                sum=start==0?prefix[end]:prefix[end]-prefix[start-1];
                /*for(int k=start;k<=end;k++){
                    sum+=numbers[k];
                    System.out.print(numbers[k]+" ");
                }*/

                System.out.println("Sum: " + sum);
                ts++;
                System.out.println();
                if(sum>maxSum){
                    maxSum=sum;
                }
            }
            System.out.println();
        }
        System.out.println("Total subarrays: " + ts);
        System.out.println("Maximum subarray sum: " + maxSum);
    }
    public static void kadanes(int numbers[]) {//For small Negative number conataining array
        int ms=Integer.MIN_VALUE;
        int cs=0;
        for(int i=0;i<numbers.length;i++){
            cs=cs+numbers[i];
            if(cs<0){
                cs=0;
            }
            ms=Math.max(cs, ms);
        }
        System.out.println("Maximum subarray sum: " + ms);
    }
    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40, 50};

        System.out.println("Array elements:");
        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        update(arr);                     //call by reference
        System.out.println("\nUpdated array elements:");
        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");

        }
     
        int key1=20;
        int index1=linearSearch(arr, key1);
        if(index1==-1){
            System.out.println("Element not found");
        }
        else{
            System.out.println("Element found at index: " + index1);
        }

        int key2=20;
        int index2=binarySearch(arr, key2);
        if(index2==-1){
           System.out.println("Element not found");
        }
       else{
        System.out.println("Element found at index: " + index2);
        }

        reverse(arr);
        for(int i=0;i<arr.length;i++){
           System.out.print(arr[i]+" ");
       }

       System.out.println("Largest element: " + largest_and_smallest(arr));

        printPairs(arr);
        subArrays(arr);
        kadanes(arr);
}
}
