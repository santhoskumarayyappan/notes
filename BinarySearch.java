// Easy version
// find any index, i such that a[i] == target
public int search() {
      int left = 0, right = n - 1;
      while(left <= right) {
          int mid = left + (right - left) / 2;
          if(a[mid] == target) {
              return mid;
          }
          else if(a[mid] > target) {
              right = mid - 1;
          }
          else {
              left = mid + 1;
          }
      }
      return -1;
}


// Generic version
// find index of first occurence of true for property in [left, right] F F F T
public int search() {
      int left = 0, right = n; // right = n or n - 1 such that [left, right] will have one True for property
      while (left < right) {
          int mid = left + (right - left) / 2;
          if (property(mid)) {
              right = mid;
          } else {
              left = mid + 1;
          }
      }
      return left;
}



// Generic version
// find index of last occurence of true for property in [left, right] T T T F F F
public int search() {
      int left = 0, right = n; // right = n or n - 1 such that [left, right] will have one True for property
      while (left < right) {
          int mid = left + (right - left) / 2;
          if (!property(mid)) {
              right = mid;
          } else {
              left = mid + 1;
          }
      }
      return left - 1;
}
