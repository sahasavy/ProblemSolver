# TOPIC : Problem Patterns → Basic Greedy

---

## 📘 Question Bank

---

### **123. Best Time to Buy and Sell Stock**

**Problem Statement**
Given an array where `prices[i]` is the stock price on day `i`, return the **maximum profit** you can achieve by buying
once and selling once.
Return `0` if no profit is possible.

**Examples**

| Input           | Output |
|-----------------|--------|
| `[7,1,5,3,6,4]` | `5`    |
| `[7,6,4,3,1]`   | `0`    |

---

### **124. Assign Cookies**

**Problem Statement**
Each child has a greed factor and each cookie has a size.
Assign at most one cookie to each child such that the number of satisfied children is maximized.

**Examples**

| Input                | Output |
|----------------------|--------|
| `g=[1,2,3], s=[1,1]` | `1`    |
| `g=[1,2], s=[1,2,3]` | `2`    |

---

### **125. Lemonade Change**

**Problem Statement**
Customers buy lemonade for `$5`.
Return whether you can provide correct change to every customer.

**Examples**

| Input            | Output  |
|------------------|---------|
| `[5,5,5,10,20]`  | `true`  |
| `[5,5,10,10,20]` | `false` |

---

### **126. Jump Game**

**Problem Statement**
Given an array where each element represents maximum jump length from that position, return whether you can reach the
last index.

**Examples**

| Input         | Output  |
|---------------|---------|
| `[2,3,1,1,4]` | `true`  |
| `[3,2,1,0,4]` | `false` |

---

### **127. Jump Game II**

**Problem Statement**
Return the **minimum number of jumps** to reach the last index.

**Examples**

| Input         | Output |
|---------------|--------|
| `[2,3,1,1,4]` | `2`    |

---

### **128. Gas Station**

**Problem Statement**
Given gas and cost arrays, return the starting station index to complete the circuit.
Return `-1` if impossible.

**Examples**

| Input                               | Output |
|-------------------------------------|--------|
| `gas=[1,2,3,4,5], cost=[3,4,5,1,2]` | `3`    |

---

### **129. Boats to Save People**

**Problem Statement**
Each boat can carry at most two people with a weight limit.
Return the **minimum number of boats** required.

**Examples**

| Input                | Output |
|----------------------|--------|
| `[3,2,2,1], limit=3` | `3`    |

---

---

## 🧠 Solutions

---

### **123. Best Time to Buy and Sell Stock**

```java
public int maxProfit(int[] prices) {
    int min = Integer.MAX_VALUE, profit = 0;

    for (int p : prices) {
        min = Math.min(min, p);
        profit = Math.max(profit, p - min);
    }
    return profit;
}
```

* **Time:** O(n)
* **Space:** O(1)

---

### **124. Assign Cookies**

```java
public int findContentChildren(int[] g, int[] s) {
    Arrays.sort(g);
    Arrays.sort(s);

    int i = 0, j = 0;
    while (i < g.length && j < s.length) {
        if (s[j] >= g[i]) i++;
        j++;
    }
    return i;
}
```

* **Time:** O(n log n)
* **Space:** O(1)

---

### **125. Lemonade Change**

```java
public boolean lemonadeChange(int[] bills) {
    int five = 0, ten = 0;

    for (int b : bills) {
        if (b == 5) five++;
        else if (b == 10) {
            if (five == 0) return false;
            five--;
            ten++;
        } else {
            if (ten > 0 && five > 0) {
                ten--;
                five--;
            } else if (five >= 3) {
                five -= 3;
            } else return false;
        }
    }
    return true;
}
```

* **Time:** O(n)
* **Space:** O(1)

---

### **126. Jump Game**

```java
public boolean canJump(int[] nums) {
    int reach = 0;

    for (int i = 0; i < nums.length; i++) {
        if (i > reach) return false;
        reach = Math.max(reach, i + nums[i]);
    }
    return true;
}
```

* **Time:** O(n)
* **Space:** O(1)

---

### **127. Jump Game II**

```java
public int jump(int[] nums) {
    int jumps = 0, currEnd = 0, farthest = 0;

    for (int i = 0; i < nums.length - 1; i++) {
        farthest = Math.max(farthest, i + nums[i]);
        if (i == currEnd) {
            jumps++;
            currEnd = farthest;
        }
    }
    return jumps;
}
```

* **Time:** O(n)
* **Space:** O(1)

---

### **128. Gas Station**

```java
public int canCompleteCircuit(int[] gas, int[] cost) {
    int total = 0, curr = 0, start = 0;

    for (int i = 0; i < gas.length; i++) {
        total += gas[i] - cost[i];
        curr += gas[i] - cost[i];
        if (curr < 0) {
            start = i + 1;
            curr = 0;
        }
    }
    return total >= 0 ? start : -1;
}
```

* **Time:** O(n)
* **Space:** O(1)

---

### **129. Boats to Save People**

```java
public int numRescueBoats(int[] people, int limit) {
    Arrays.sort(people);
    int l = 0, r = people.length - 1, boats = 0;

    while (l <= r) {
        if (people[l] + people[r] <= limit) l++;
        r--;
        boats++;
    }
    return boats;
}
```

* **Time:** O(n log n)
* **Space:** O(1)

---
