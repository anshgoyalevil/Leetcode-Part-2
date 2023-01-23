class Solution {
    
    int [] ans = new int [2];
    
    public int binarySearch(int arr[], int x)
    {
        int l = 0, r = arr.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
 
            // Check if x is present at mid
            if (arr[m] == x)
                return m;
 
            // If x greater, ignore left half
            if (arr[m] < x)
                l = m + 1;
 
            // If x is smaller, ignore right half
            else
                r = m - 1;
        }
 
        // if we reach here, then element was
        // not present
        return -1;
    }
    
    public int[] searchRange(int[] nums, int target) {
        
        int ind1 = -1;
        int ind2 = -1;
        
        int ind = binarySearch(nums, target);
        System.out.println(ind);
        
        
            if(ind > 0){
                if(nums[ind-1] == target){
                    int i;
                    for(i = ind; i>-1; i--){
                        if(nums[i] != target){
                            
                            break;
                        }
                    }
                    ind1 = i+1;
                }
                else{
                    ind1 = ind;
                }
            }
        else{
            ind1 = ind;
        }
            if(ind < nums.length-1){
                if(nums[ind+1] == target){
                    int i;
                    for(i = ind; i<nums.length; i++){
                        if(nums[i]!=target){
                            
                            break;
                        }
                    }
                    ind2 = i-1;
                }
                else{
                    ind2 = ind;
                }
            }
        else{
            ind2 = ind;
        }
        
        
        ans[0] = ind1;
        ans[1] = ind2;
        return ans;
        
    }
}