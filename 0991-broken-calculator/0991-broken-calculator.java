class Solution {
    public int brokenCalc(int startValue, int target) {
        int count =0;
        while(startValue!=target){
            if(target%2==0 && target>startValue){
            target = target/2;
            count++;
            if(target == startValue){
                return count;
            }
        }
        else{
            target = target +1;
             count++;
            if(target == startValue){
                return count;
            }
        }
        }
        return count;
       
    }
}