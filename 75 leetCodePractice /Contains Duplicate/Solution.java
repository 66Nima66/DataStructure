class Solution {
    public boolean containsDuplicate(int[] nums) {
    

        HashMap<Integer, Integer> hashMap = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++){
            if (hashMap.containsKey(nums[i])){

                return true;   
            }
            else 
            hashMap.put(nums[i],1);
        }
        return false;
    } 
}        
