class Solution { 
    
    public void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    
    public int partition(int[] nums, int l, int r) {
        for (int i = l; i < r; i++) {
            if (nums[i] >= nums[r]) {
                swap(nums, i, l);
                l++;
            }
        }
        swap(nums, r, l);
        return l;
    }
    
    public int randomPartition(int[] a, int l, int r) {
         int pivot = (int) (Math.random() * (r - l + 1)) + l;
         swap(a, pivot, r);
         return partition(a, l, r);
    }
    
    public int helper(int[] nums, int l, int r, int k) {   
        int index = randomPartition(nums, l, r);
        if (index == k) {
            return nums[index];
        } else if (index < k) {
             return helper(nums, index + 1, r, k);
        } else {
             return helper(nums, l, index - 1, k);
        }
    }
     
    public int findKthLargest(int[] a, int k) {
        return helper(a, 0, a.length - 1, k - 1);     
    }
}
