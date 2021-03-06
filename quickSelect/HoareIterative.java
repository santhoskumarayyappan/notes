// Note that in this scheme, the pivot’s final location is not necessarily at the index that was returned,
// and the next two segments that the main algorithm recurs on are (lo..p) and (p+1..hi) as opposed to (lo..p-1) and (p+1..hi) as in Lomuto’s scheme.

    
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
        while(i < j) {
            int pivot = partition(a, i, j);
            if(pivot < k) i = pivot + 1;
            else j = pivot;
        }
        return a[i];
    }
     
    public int kthLargestValue(int[] a, int k) {
        return helper(a, 0, a.length - 1, k - 1);     
    }
}
