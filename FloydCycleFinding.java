//09-04-2022
//https://www.youtube.com/watch?v=-YiQZi3mLq0


0  ->   1   ->   2   
  
        ->           ->  
  
    5                       3  
  
        <-            <-
               4
  
D = 0 -> 1 -> 2 (Distance from Head to Loop start)
k = 3 -> 4 (Extra Distance moved from Loop start)
Meeting Point = 4
Number of loops done by Fast = i
Number of loops done by Slow = j
Length of Loop = C
  
2N = D + i * C + k
 N = D + j * C + k
 
 2D + 2 i * C + 2k = D + j * C + k
 D + k             = C * (j - 2i)
 D                 = C * (j - 2i) - k
 
 So if you Travel D from start of loop you will be at C * (j - 2i) - k
 So if you Travel D from k distance from start of loop you will be at Start of loop 
 
 
 
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        boolean loopExists = false;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                loopExists = true;
                break;
            }
        }
        if (!loopExists) {
            return null;
        }
        
        slow = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }
}
 
 
                 
