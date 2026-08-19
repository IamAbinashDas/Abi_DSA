public class Q1 {
    public static void setZeroesBruteForce(int arr[][]){
        int m=arr.length;//rows
        int n=arr[0].length;//columns

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(arr[i][j]==0){
                    //rows
                    for(int k=0;k<m;k++){
                        if(arr[i][k]!=0){
                            arr[i][k]=-1;
                        }
                    }
                    //columns
                    for(int k=0;k<n;k++){
                        if(arr[k][j]!=0){
                            arr[k][j]=-1;
                        }
                    }
                }
            }
        }
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(arr[i][j]==-1){
                    arr[i][j]=0;
                }
            }  
        }
    }

    public static void setZeroesBetter(int arr[][]){
        int m=arr.length;
        int n=arr[0].length;

        boolean rowMark[]=new boolean[m];
        boolean colMark[]=new boolean[n];

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(arr[i][j]==0){
                    rowMark[i]=true;
                    colMark[j]=true;
                }
            }
        }

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(rowMark[i]||colMark[j]){
                    arr[i][j]=0;
                }
            }
        }
    }

    public static void setZeroesOtimized(int arr[][]){
        int m=arr.length;
        int n=arr[0].length;

        boolean firstColZero=false;

        for(int i=0;i<m;i++){
            if(arr[i][0]==0){
                firstColZero=true;
            }
            for(int j=1;j<n;j++){
                if(arr[i][j]==0){
                    arr[i][0]=0;
                    arr[0][j]=0;
                }
            }
        }

        for(int i=m-1;i>=0;i--){
            for(int j=n-1;j>=1;j--){
                if(arr[i][0]==0 || arr[0][j]==0){
                    arr[i][j]=0;
                }
            }
            if(firstColZero){
                arr[i][0]=0;
            }
        }

    }
    public static void main(String[] args) {
        int matrix[][]={
            {1,1,1},
            {1,0,1},
            {1,1,1}
        };
        System.out.println("Original Matrix:");
        //setZeroesBruteForce(matrix);
        //setZeroesBetter(matrix);
        setZeroesOtimized(matrix);

        System.out.println("\n Print The Modified Matrix:");
        printMatrix(matrix);

    }
    public static void printMatrix(int arr[][]){
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                   System.out.print(arr[i][j]);
            }
            System.out.println();
        }
    }
}
