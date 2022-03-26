
class Solution { 
    
    public void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    
    int partition(int[] a, int l, int r) {
        if(l >= r) return l;
        int i = l - 1, j = r + 1, pivot = a[l];
        while(true) {
            while(a[++i] > pivot);
            while(a[--j] < pivot);
            if(i < j) {
                swap(a, i, j);
            }
            else return j;
        }
    }
    
    public int randomPartition(int[] a, int l, int r) {
         int pivot = (int) (Math.random() * (r - l + 1)) + l;
         swap(a, pivot, l);
         return partition(a, l, r);
    }
    
    public int helper(int[] a, int i, int j, int k) {
         if (i == j) {
             return a[i];
         }
         int pivot = randomPartition(a, i, j);
         if (pivot < k) {
             return helper(a, pivot + 1, j, k);
         } else {
             return helper(a, i, pivot, k);
         }
    }
     
    public int kthLargestValue(int[] a, int k) {
        return helper(a, 0, a.length - 1, k - 1);     
    }
}
