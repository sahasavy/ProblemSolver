# TOPIC : Structures → Linked List

---

## 📘 Question Bank

---

### **73. Reverse a Linked List**

**Problem Statement**
Given the head of a singly linked list, reverse the list and return the new head.

**Examples**

| Input                  | Output                 |
|------------------------|------------------------|
| `1 → 2 → 3 → 4 → null` | `4 → 3 → 2 → 1 → null` |

---

### **74. Detect Cycle in a Linked List**

**Problem Statement**
Determine if a linked list contains a cycle.

**Examples**

* `1 → 2 → 3 → 4 → 2` → `true`
* `1 → 2 → 3 → null` → `false`

---

### **75. Remove Nth Node from End**

**Problem Statement**
Remove the `n`th node from the end of the list and return the head.

**Examples**

| Input            | Output    |
|------------------|-----------|
| `1→2→3→4→5, n=2` | `1→2→3→5` |

---

### **76. Merge Two Sorted Linked Lists**

**Problem Statement**
Merge two sorted linked lists and return the merged sorted list.

---

### **77. Palindrome Linked List**

**Problem Statement**
Check whether a linked list is a palindrome.

**Examples**

* `1→2→2→1` → `true`
* `1→2` → `false`

---

### **78. Intersection of Two Linked Lists**

**Problem Statement**
Return the node at which two singly linked lists intersect.

---

### **79. Add Two Numbers**

**Problem Statement**
Two linked lists represent non-negative integers in reverse order.
Add the two numbers and return the sum as a linked list.

**Examples**

| Input               | Output  |
|---------------------|---------|
| `(2→4→3) + (5→6→4)` | `7→0→8` |

---

### **80. Odd Even Linked List**

**Problem Statement**
Group all odd-indexed nodes followed by even-indexed nodes.

---

### **81. Rotate Linked List**

**Problem Statement**
Rotate the list to the right by `k` places.

**Examples**

| Input            | Output      |
|------------------|-------------|
| `1→2→3→4→5, k=2` | `4→5→1→2→3` |

---

### **82. Copy List with Random Pointer**

**Problem Statement**
Create a deep copy of a linked list where each node has a `random` pointer.

---

---

## 🧠 Solutions

> **Assumed Node Definition**

```java
class ListNode {
    int val;
    ListNode next;
    ListNode random;

    ListNode(int val) {
        this.val = val;
    }
}
```

---

### **73. Reverse a Linked List**

```java
public ListNode reverseList(ListNode head) {
    ListNode prev = null, curr = head;

    while (curr != null) {
        ListNode next = curr.next;
        curr.next = prev;
        prev = curr;
        curr = next;
    }
    return prev;
}
```

* **Time:** O(n)
* **Space:** O(1)

---

### **74. Detect Cycle**

```java
public boolean hasCycle(ListNode head) {
    ListNode slow = head, fast = head;

    while (fast != null && fast.next != null) {
        slow = slow.next;
        fast = fast.next.next;
        if (slow == fast) return true;
    }
    return false;
}
```

* **Time:** O(n)
* **Space:** O(1)

---

### **75. Remove Nth Node from End**

```java
public ListNode removeNthFromEnd(ListNode head, int n) {
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode fast = dummy, slow = dummy;

    for (int i = 0; i < n; i++) fast = fast.next;
    while (fast.next != null) {
        fast = fast.next;
        slow = slow.next;
    }
    slow.next = slow.next.next;
    return dummy.next;
}
```

* **Time:** O(n)
* **Space:** O(1)

---

### **76. Merge Two Sorted Lists**

```java
public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    ListNode dummy = new ListNode(0);
    ListNode curr = dummy;

    while (l1 != null && l2 != null) {
        if (l1.val <= l2.val) {
            curr.next = l1;
            l1 = l1.next;
        } else {
            curr.next = l2;
            l2 = l2.next;
        }
        curr = curr.next;
    }
    curr.next = (l1 != null) ? l1 : l2;
    return dummy.next;
}
```

* **Time:** O(n + m)
* **Space:** O(1)

---

### **77. Palindrome Linked List**

```java
public boolean isPalindrome(ListNode head) {
    ListNode slow = head, fast = head;

    while (fast != null && fast.next != null) {
        slow = slow.next;
        fast = fast.next.next;
    }

    ListNode secondHalf = reverseList(slow);
    ListNode firstHalf = head;

    while (secondHalf != null) {
        if (firstHalf.val != secondHalf.val) return false;
        firstHalf = firstHalf.next;
        secondHalf = secondHalf.next;
    }
    return true;
}
```

* **Time:** O(n)
* **Space:** O(1)

---

### **78. Intersection of Two Linked Lists**

```java
public ListNode getIntersectionNode(ListNode a, ListNode b) {
    if (a == null || b == null) return null;

    ListNode p1 = a, p2 = b;
    while (p1 != p2) {
        p1 = (p1 == null) ? b : p1.next;
        p2 = (p2 == null) ? a : p2.next;
    }
    return p1;
}
```

* **Time:** O(n + m)
* **Space:** O(1)

---

### **79. Add Two Numbers**

```java
public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode dummy = new ListNode(0);
    ListNode curr = dummy;
    int carry = 0;

    while (l1 != null || l2 != null || carry != 0) {
        int sum = carry;
        if (l1 != null) sum += l1.val;
        if (l2 != null) sum += l2.val;

        carry = sum / 10;
        curr.next = new ListNode(sum % 10);
        curr = curr.next;

        if (l1 != null) l1 = l1.next;
        if (l2 != null) l2 = l2.next;
    }
    return dummy.next;
}
```

* **Time:** O(n)
* **Space:** O(n)

---

### **80. Odd Even Linked List**

```java
public ListNode oddEvenList(ListNode head) {
    if (head == null) return null;

    ListNode odd = head, even = head.next, evenHead = even;

    while (even != null && even.next != null) {
        odd.next = even.next;
        odd = odd.next;
        even.next = odd.next;
        even = even.next;
    }
    odd.next = evenHead;
    return head;
}
```

* **Time:** O(n)
* **Space:** O(1)

---

### **81. Rotate Linked List**

```java
public ListNode rotateRight(ListNode head, int k) {
    if (head == null || head.next == null || k == 0) return head;

    ListNode curr = head;
    int len = 1;
    while (curr.next != null) {
        curr = curr.next;
        len++;
    }
    curr.next = head; // make circular

    k %= len;
    int steps = len - k;
    while (steps-- > 0) curr = curr.next;

    ListNode newHead = curr.next;
    curr.next = null;
    return newHead;
}
```

* **Time:** O(n)
* **Space:** O(1)

---

### **82. Copy List with Random Pointer**

```java
public ListNode copyRandomList(ListNode head) {
    if (head == null) return null;

    Map<ListNode, ListNode> map = new HashMap<>();
    ListNode curr = head;

    while (curr != null) {
        map.put(curr, new ListNode(curr.val));
        curr = curr.next;
    }

    curr = head;
    while (curr != null) {
        map.get(curr).next = map.get(curr.next);
        map.get(curr).random = map.get(curr.random);
        curr = curr.next;
    }
    return map.get(head);
}
```

* **Time:** O(n)
* **Space:** O(n)

---
