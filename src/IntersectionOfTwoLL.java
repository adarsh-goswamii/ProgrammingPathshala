class IntersectionOfTwoLL {
    public static void main(String[] args) throws Exception {
        // https://leetcode.com/problems/intersection-of-two-linked-lists/discuss/49785/Java-solution-without-knowing-the-difference-in-len!
        // check out the comments really beautiful visual explanation.
    }

    public class ListNode {
        ListNode next;
        ListNode val;
    }

    public class Solution {
        /**
         * Main focus here is how we can make the pointers align such that they get to the intersection node 
         * at the same time.
         * 
         * For this we have two approaches: 
         * 1. calc the length and then give a head start to the long linkedlist O(3.n)
         * 2. we can make then walk there respective linked lists and then when they reach end of null
         *    we will make them walk through the other linkedlist as well.
         *    we do this for both of the pointers and this will nullify the diff in length and they both will reach 
         *    intersection node at the same time. (Pathetic attempt to explain the logic read the article and you 
         *    are good to go. )
         */
        public ListNode getIntersectionNode(ListNode _headA, ListNode _headB) {
            if(_headA== null || _headB== null) return null;
            
            ListNode headA= _headA, headB= _headB;
            while(headA!= headB) {
                if(headA== null) headA= _headB;
                else headA= headA.next;
                if(headB== null) headB= _headA;
                else headB= headB.next;
            }
            
            return headA;
        }
    }
}