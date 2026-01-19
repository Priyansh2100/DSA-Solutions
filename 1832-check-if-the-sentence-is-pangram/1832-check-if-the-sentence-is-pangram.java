class Solution {
    public boolean checkIfPangram(String sentence) {
        
        int arr[] = new int[26];

        for(int i=0;i<sentence.length();i++){
            int index = sentence.charAt(i) - 'a';
            arr[index] = arr[index] +1;
        }

        for(int j =0;j<arr.length;j++){
            if(arr[j] == 0){
                return false;
            }
        }
        return true;
    }
}