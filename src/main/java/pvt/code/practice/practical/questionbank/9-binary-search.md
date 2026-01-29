# TOPIC : Structures → Binary Search

---

## 📘 Question Bank

---

### **91. Binary Search (Classic)**

**Problem Statement**
Given a sorted integer array and a target, return the index of the target.
Return `-1` if the target does not exist.

**Examples**

| Input                   | Output |
|-------------------------|--------|
| `[1,2,3,4,5], target=4` | `3`    |
| `[1,2,3], target=6`     | `-1`   |

---

### **92. First and Last Position of Element in Sorted Array**

**Problem Statement**
Given a sorted array, find the **first and last occurrence** of a target.

**Examples**

| Input                      | Output    |
|----------------------------|-----------|
| `[5,7,7,8,8,10], target=8` | `[3,4]`   |
| `[5,7,7], target=6`        | `[-1,-1]` |

---

### **93. Search in Rotated Sorted Array**

**Problem Statement**
Search a target in a rotated sorted array and return its index.

**Examples**

| Input                       | Output |
|-----------------------------|--------|
| `[4,5,6,7,0,1,2], target=0` | `4`    |
| `[4,5,6], target=3`         | `-1`   |

---

### **94. Find Peak Element**

**Problem Statement**
A peak element is greater than its neighbors. Return the index of any peak.

**Examples**

| Input             | Output   |
|-------------------|----------|
| `[1,2,3,1]`       | `2`      |
| `[1,2,1,3,5,6,4]` | `1 or 5` |

---

### **95. Square Root of a Number**

**Problem Statement**
Compute and return the **integer square root** of a non-negative integer.

**Examples**

| Input | Output |
|-------|--------|
| `8`   | `2`    |
| `16`  | `4`    |

---

### **96. Capacity to Ship Packages Within D Days**

**Problem Statement**
Given package weights and days `D`, return the **minimum ship capacity** to ship all packages within `D` days.

**Examples**

| Input                         | Output |
|-------------------------------|--------|
| `[1,2,3,4,5,6,7,8,9,10], D=5` | `15`   |

---

### **97. Koko Eating Bananas**

**Problem Statement**
Koko eats bananas at speed `k`. Find the minimum `k` to eat all bananas within `h` hours.

**Examples**

| Input             | Output |
|-------------------|--------|
| `[3,6,7,11], h=8` | `4`    |

---

### **98. Minimum Element in Rotated Sorted Array**

**Problem Statement**
Find the minimum element in a rotated sorted array.

**Examples**

| Input         | Output |
|---------------|--------|
| `[3,4,5,1,2]` | `1`    |

---

### **99. Median of Two Sorted Arrays**

**Problem Statement**
Given two sorted arrays, return the median.

**Examples**

| Input           | Output |
|-----------------|--------|
| `[1,3] & [2]`   | `2.0`  |
| `[1,2] & [3,4]` | `2.5`  |

---

### **100. Allocate Books**

**Problem Statement**
Given book pages and number of students, allocate books to minimize the **maximum pages assigned**.

**Examples**

| Input                       | Output |
|-----------------------------|--------|
| `[12,34,67,90], students=2` | `113`  |

---

---

## 🧠 Solutions

---

### **91. Binary Search**

```java
public int binarySearch(int[] nums, int target) {
    int l = 0, r = nums.length - 1;

    while (l <= r) {
        int mid = l + (r - l) / 2;
        if (nums[mid] == target) return mid;
        if (nums[mid] < target) l = mid + 1;
        else r = mid - 1;
    }
    return -1;
}
```

* **Time:** O(log n)
* **Space:** O(1)

---

### **92. First and Last Position**

```java
public int[] searchRange(int[] nums, int target) {
    return new int[]{first(nums, target), last(nums, target)};
}

private int first(int[] nums, int target) {
    int l = 0, r = nums.length - 1, ans = -1;
    while (l <= r) {
        int m = l + (r - l) / 2;
        if (nums[m] >= target) r = m - 1;
        else l = m + 1;
        if (nums[m] == target) ans = m;
    }
    return ans;
}

private int last(int[] nums, int target) {
    int l = 0, r = nums.length - 1, ans = -1;
    while (l <= r) {
        int m = l + (r - l) / 2;
        if (nums[m] <= target) l = m + 1;
        else r = m - 1;
        if (nums[m] == target) ans = m;
    }
    return ans;
}
```

* **Time:** O(log n)
* **Space:** O(1)

---

### **93. Search in Rotated Sorted Array**

```java
public int search(int[] nums, int target) {
    int l = 0, r = nums.length - 1;

    while (l <= r) {
        int m = l + (r - l) / 2;
        if (nums[m] == target) return m;

        if (nums[l] <= nums[m]) {
            if (nums[l] <= target && target < nums[m]) r = m - 1;
            else l = m + 1;
        } else {
            if (nums[m] < target && target <= nums[r]) l = m + 1;
            else r = m - 1;
        }
    }
    return -1;
}
```

* **Time:** O(log n)
* **Space:** O(1)

---

### **94. Find Peak Element**

```java
public int findPeakElement(int[] nums) {
    int l = 0, r = nums.length - 1;

    while (l < r) {
        int m = l + (r - l) / 2;
        if (nums[m] < nums[m + 1]) l = m + 1;
        else r = m;
    }
    return l;
}
```

* **Time:** O(log n)
* **Space:** O(1)

---

### **95. Square Root**

```java
public int mySqrt(int x) {
    if (x < 2) return x;

    int l = 1, r = x / 2, ans = 0;
    while (l <= r) {
        int m = l + (r - l) / 2;
        long sq = (long) m * m;

        if (sq <= x) {
            ans = m;
            l = m + 1;
        } else {
            r = m - 1;
        }
    }
    return ans;
}
```

* **Time:** O(log n)
* **Space:** O(1)

---

### **96. Capacity to Ship Packages**

```java
public int shipWithinDays(int[] weights, int days) {
    int low = Arrays.stream(weights).max().getAsInt();
    int high = Arrays.stream(weights).sum();

    while (low < high) {
        int mid = low + (high - low) / 2;
        if (canShip(weights, days, mid)) high = mid;
        else low = mid + 1;
    }
    return low;
}

private boolean canShip(int[] w, int days, int cap) {
    int d = 1, load = 0;
    for (int x : w) {
        if (load + x > cap) {
            d++;
            load = 0;
        }
        load += x;
    }
    return d <= days;
}
```

* **Time:** O(n log S)
* **Space:** O(1)

---

### **97. Koko Eating Bananas**

```java
public int minEatingSpeed(int[] piles, int h) {
    int l = 1, r = Arrays.stream(piles).max().getAsInt();

    while (l < r) {
        int m = l + (r - l) / 2;
        if (canEat(piles, h, m)) r = m;
        else l = m + 1;
    }
    return l;
}

private boolean canEat(int[] piles, int h, int k) {
    int time = 0;
    for (int p : piles) {
        time += (p + k - 1) / k;
    }
    return time <= h;
}
```

* **Time:** O(n log M)
* **Space:** O(1)

---

### **98. Minimum in Rotated Sorted Array**

```java
public int findMin(int[] nums) {
    int l = 0, r = nums.length - 1;

    while (l < r) {
        int m = l + (r - l) / 2;
        if (nums[m] > nums[r]) l = m + 1;
        else r = m;
    }
    return nums[l];
}
```

* **Time:** O(log n)
* **Space:** O(1)

---

### **99. Median of Two Sorted Arrays**

```java
public double findMedianSortedArrays(int[] a, int[] b) {
    if (a.length > b.length) return findMedianSortedArrays(b, a);

    int m = a.length, n = b.length;
    int l = 0, r = m;

    while (l <= r) {
        int i = (l + r) / 2;
        int j = (m + n + 1) / 2 - i;

        int maxL1 = (i == 0) ? Integer.MIN_VALUE : a[i - 1];
        int minR1 = (i == m) ? Integer.MAX_VALUE : a[i];
        int maxL2 = (j == 0) ? Integer.MIN_VALUE : b[j - 1];
        int minR2 = (j == n) ? Integer.MAX_VALUE : b[j];

        if (maxL1 <= minR2 && maxL2 <= minR1) {
            if ((m + n) % 2 == 0)
                return (Math.max(maxL1, maxL2) + Math.min(minR1, minR2)) / 2.0;
            else
                return Math.max(maxL1, maxL2);
        } else if (maxL1 > minR2) r = i - 1;
        else l = i + 1;
    }
    return 0.0;
}
```

* **Time:** O(log(min(n, m)))
* **Space:** O(1)

---

### **100. Allocate Books**

```java
public int allocateBooks(int[] pages, int students) {
    int low = Arrays.stream(pages).max().getAsInt();
    int high = Arrays.stream(pages).sum();

    while (low < high) {
        int mid = low + (high - low) / 2;
        if (canAllocate(pages, students, mid)) high = mid;
        else low = mid + 1;
    }
    return low;
}

private boolean canAllocate(int[] pages, int students, int limit) {
    int count = 1, sum = 0;
    for (int p : pages) {
        if (sum + p > limit) {
            count++;
            sum = 0;
        }
        sum += p;
    }
    return count <= students;
}
```

* **Time:** O(n log S)
* **Space:** O(1)

---
