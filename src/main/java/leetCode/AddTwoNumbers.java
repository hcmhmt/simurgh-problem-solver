package leetCode;

public class AddTwoNumbers {

    public static void main(String[] args) {
        ListNode listNode13 = new ListNode(3);
        ListNode listNode12 = new ListNode(4, listNode13);
        ListNode listNode11 = new ListNode(2, listNode12);

        ListNode listNode23 = new ListNode(4);
        ListNode listNode22 = new ListNode(6, listNode23);
        ListNode listNode21 = new ListNode(5, listNode22);


        ListNode listNode37 = new ListNode(9);
        ListNode listNode36 = new ListNode(9, listNode37);
        ListNode listNode35 = new ListNode(9, listNode36);
        ListNode listNode34 = new ListNode(9, listNode35);
        ListNode listNode33 = new ListNode(9, listNode34);
        ListNode listNode32 = new ListNode(9, listNode33);
        ListNode listNode31 = new ListNode(9, listNode32);

        ListNode listNode44 = new ListNode(9);
        ListNode listNode43 = new ListNode(9, listNode44);
        ListNode listNode42 = new ListNode(9, listNode43);
        ListNode listNode41 = new ListNode(9, listNode42);

        ListNode listNode53 = new ListNode(9);
        ListNode listNode52 = new ListNode(4, listNode53);
        ListNode listNode51 = new ListNode(2, listNode52);

        ListNode listNode64 = new ListNode(9);
        ListNode listNode63 = new ListNode(4, listNode64);
        ListNode listNode62 = new ListNode(6, listNode63);
        ListNode listNode61 = new ListNode(5, listNode62);


        ListNode listNode71 = new ListNode(5, null);
        ListNode listNode81 = new ListNode(5, null);


//        ListNode result = addTwoNumbers(listNode11, listNode21);
//        ListNode result2 = addTwoNumbers(listNode31, listNode41);
        ListNode result2 = mergeThemAll(listNode71, listNode81);
        System.out.println(result2.toString());

    }

    private static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1.next == null && l2.next == null) {
            if ((l1.val + l2.val) > 9) {
                ListNode listNode2 = new ListNode((l1.val + l2.val) % 10);
                listNode2.next = new ListNode(10);
                return addTwoNumbers(listNode2, null);
            }
            return new ListNode((l1.val + l2.val));

        } else if (l1 == null || l1.next == null) {
            if (l2.val > 9) {
                ListNode listNode2 = new ListNode(l2.val % 10);
                listNode2.next = new ListNode(10);
                return addTwoNumbers(listNode2, null);
            }
            return l2.next;
        } else if (l2 == null || l2.next == null) {
            if (l1.val > 9) {
                ListNode listNode2 = new ListNode(l1.val % 10);
                listNode2.next = new ListNode(10);
                return addTwoNumbers(listNode2, null);
            }
            return l1.next;
        }

        ListNode listNode = new ListNode();

        int tempVal = (l1.val + l2.val);
        boolean flag = false;
        if (tempVal > 9) {
            tempVal = (l1.val + l2.val) % 10;
            flag = true;
        }
        listNode.val = tempVal;

        if (flag && (l1.next != null)) {
            l1.next.val++;
        } else if (flag && (l2.next != null)) {
            l2.next.val++;
        }

        listNode.next = addTwoNumbers(l1.next, l2.next);
        return listNode;
    }


    private static ListNode addTwoNumbers2(ListNode l1, ListNode l2) {

/*        if (l1.next == null) {
            return l1;
        } else if ((l2 == null || l2.next == null)) {
            if (l1.val > 9) {
                if (l1.next != null) l1.next.val++;
                l1.val = l1.val % 10;
                return addTwoNumbers2(l1.next, null);
            }
            return l1;

        }*/

        ListNode listNode = new ListNode();

        int tempVal = (l1.val + l2.val);
        boolean flag = false;
        if (tempVal > 9) {
            tempVal = (l1.val + l2.val) % 10;
            flag = true;
        }
        listNode.val = tempVal;

        if (flag && (l1.next != null)) {
            l1.next.val++;
        } else if (flag && (l2.next != null)) {
            l2.next.val++;
        }

        listNode.next = addTwoNumbers2(l1.next, l2.next);
        return listNode;
    }

    private static ListNode mergeThemAll(ListNode l1, ListNode l2) {

        if (l1 == null && l2 == null) {
            return null;
        } else if (l1 == null && l2 != null) {
            ListNode listNode = new ListNode();

            if (l2.val > 9) {
                listNode.val = l2.val % 10;
                if (l2.next != null) {
                    l2.next.val++;
                } else {
                    l2.next = new ListNode(1);
                }
            } else {
                listNode.val = l2.val;
            }
            listNode.next = mergeThemAll(null, l2.next);
            return listNode;

        } else if (l1 != null && l2 != null) {
            ListNode listNode = new ListNode();

            int tempVal = (l1.val + l2.val);
            boolean flag = false;
            if (tempVal > 9) {
                tempVal = (l1.val + l2.val) % 10;
                flag = true;
            }
            listNode.val = tempVal;

            if (flag && (l1.next != null)) {
                l1.next.val++;
            } else if (flag && (l2.next != null)) {
                l2.next.val++;
            }else if (flag){
                l2.next = new ListNode(1);
            }

            listNode.next = mergeThemAll(l1.next, l2.next);
            return listNode;
        } else if ((l2 == null || l2.next == null) && l1 != null) {
            ListNode listNode = new ListNode();

            if (l1.val > 9) {
                listNode.val = l1.val % 10;
                if (l1.next != null) {
                    l1.next.val++;
                } else {
                    l1.next = new ListNode(1);
                }
            } else {
                listNode.val = l1.val;
            }
            listNode.next = mergeThemAll(l1.next, null);

            return listNode;
        }

        return null;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }

}
