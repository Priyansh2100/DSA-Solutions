class Solution {
    public long maxMatrixSum(int[][] matrix) {
        long sum =0;
        int smallest =Math.abs(matrix[0][0]);
        int count =0;

        for(int i=0;i<matrix.length;i++){
            int arr[] = matrix[i];
            for(int j =0;j<arr.length;j++){

                if(arr[j]<0){
                    count++;
                }
                int temp = Math.abs(arr[j]);
                smallest = Math.min(smallest,temp);
                
            }
        }

        if(count % 2 ==0){
            for(int i=0;i<matrix.length;i++){
            int arr[] = matrix[i];
            for(int j =0;j<arr.length;j++){
                if(arr[j]<0){
                    arr[j] = -(arr[j]);
                }
                sum = sum + arr[j];
            }
        }
        }
        else{
             for(int i=0;i<matrix.length;i++){
            int arr[] = matrix[i];
            for(int j =0;j<arr.length;j++){
                if(arr[j]<0){
                    arr[j] = -(arr[j]);
                }
                sum = sum + arr[j];
            }
        }
    
       sum = sum -(long)smallest-(long)smallest;

        }

return sum;

        
    }
}