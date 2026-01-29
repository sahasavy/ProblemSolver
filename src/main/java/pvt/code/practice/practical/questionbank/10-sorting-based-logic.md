# TOPIC : Problem Patterns → Sorting-based Logic

---

## 📘 Question Bank

---

### **101. Sort an Array by Parity**

**Problem Statement**
Given an integer array, reorder it so that all **even numbers come before odd numbers**.
Order among evens or odds does not matter.

**Examples**

| Input       | Output      |
|-------------|-------------|
| `[3,1,2,4]` | `[2,4,3,1]` |
| `[0]`       | `[0]`       |

---

### **102. Merge Intervals**

**Problem Statement**
Given an array of intervals, merge all overlapping intervals.

**Examples**

| Input                          | Output                   |
|--------------------------------|--------------------------|
| `[[1,3],[2,6],[8,10],[15,18]]` | `[[1,6],[8,10],[15,18]]` |

---

### **103. Non-Overlapping Intervals**

**Problem Statement**
Given a set of intervals, return the **minimum number of intervals to remove** to make the rest non-overlapping.

**Examples**

| Input                       | Output |
|-----------------------------|--------|
| `[[1,2],[2,3],[3,4],[1,3]]` | `1`    |

---

### **104. Sort Array by Increasing Frequency**

**Problem Statement**
Sort elements by increasing frequency.
If frequencies are equal, sort by **decreasing value**.

**Examples**

| Input           | Output          |
|-----------------|-----------------|
| `[1,1,2,2,2,3]` | `[3,1,1,2,2,2]` |

---

### **105. Maximum Product of Two Elements**

**Problem Statement**
Given an array, return the **maximum product of (nums[i]−1)×(nums[j]−1)**.

**Examples**

| Input       | Output |
|-------------|--------|
| `[3,4,5,2]` | `12`   |

---

### **106. Can Attend All Meetings**

**Problem Statement**
Given meeting time intervals, determine if a person can attend all meetings.

**Examples**

| Input                     | Output  |
|---------------------------|---------|
| `[[0,30],[5,10],[15,20]]` | `false` |
| `[[7,10],[2,4]]`          | `true`  |

---

### **107. Sort Colors (Revisit with Sorting Perspective)**

**Problem Statement**
Sort an array containing only `0`, `1`, and `2`.

**Examples**

| Input           | Output          |
|-----------------|-----------------|
| `[2,0,2,1,1,0]` | `[0,0,1,1,2,2]` |

---

### **108. Minimum Difference Between Two Elements**

**Problem Statement**
Find the minimum absolute difference between any two elements in the array.

**Examples**

| Input       | Output |
|-------------|--------|
| `[3,6,9,1]` | `3`    |

---

---

## 🧠 Solutions

---

### **101. Sort an Array by Parity**

```java
public int[] sortArrayByParity(int[] nums) {
    int l = 0, r = nums.length - 1;

    while (l < r) {
        if (nums[l] % 2 > nums[r] % 2) {
            int tmp = nums[l];
            nums[l] = nums[r];
            nums[r] = tmp;
        }
        if (nums[l] % 2 == 0) l++;
        if (nums[r] % 2 == 1) r--;
    }
    return nums;
}
```

* **Time:** O(n)
* **Space:** O(1)

---

### **102. Merge Intervals**

```java
public int[][] merge(int[][] intervals) {
    if (intervals.length == 0) return new int[0][0];

    Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
    List<int[]> res = new ArrayList<>();

    int[] curr = intervals[0];
    res.add(curr);

    for (int[] in : intervals) {
        if (in[0] <= curr[1]) {
            curr[1] = Math.max(curr[1], in[1]);
        } else {
            curr = in;
            res.add(curr);
        }
    }
    return res.toArray(new int[res.size()][]);
}
```

* **Time:** O(n log n)
* **Space:** O(n)

---

### **103. Non-Overlapping Intervals**

```java
public int eraseOverlapIntervals(int[][] intervals) {
    Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
    int count = 0, end = intervals[0][1];

    for (int i = 1; i < intervals.length; i++) {
        if (intervals[i][0] < end) {
            count++;
        } else {
            end = intervals[i][1];
        }
    }
    return count;
}
```

* **Time:** O(n log n)
* **Space:** O(1)

---

### **104. Sort Array by Increasing Frequency**

```java
public int[] frequencySort(int[] nums) {
    Map<Integer, Integer> freq = new HashMap<>();
    for (int n : nums) freq.put(n, freq.getOrDefault(n, 0) + 1);

    Integer[] arr = Arrays.stream(nums).boxed().toArray(Integer[]::new);
    Arrays.sort(arr, (a, b) -> {
        if (!freq.get(a).equals(freq.get(b)))
            return freq.get(a) - freq.get(b);
        return b - a;
    });

    return Arrays.stream(arr).mapToInt(i -> i).toArray();
}
```

* **Time:** O(n log n)
* **Space:** O(n)

---

### **105. Maximum Product of Two Elements**

```java
public int maxProduct(int[] nums) {
    Arrays.sort(nums);
    int n = nums.length;
    return (nums[n - 1] - 1) * (nums[n - 2] - 1);
}
```

* **Time:** O(n log n)
* **Space:** O(1)

---

### **106. Can Attend All Meetings**

```java
public boolean canAttendMeetings(int[][] intervals) {
    Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

    for (int i = 1; i < intervals.length; i++) {
        if (intervals[i][0] < intervals[i - 1][1]) return false;
    }
    return true;
}
```

* **Time:** O(n log n)
* **Space:** O(1)

---

### **107. Sort Colors**

```java
public void sortColors(int[] nums) {
    int low = 0, mid = 0, high = nums.length - 1;

    while (mid <= high) {
        if (nums[mid] == 0) {
            swap(nums, low++, mid++);
        } else if (nums[mid] == 1) {
            mid++;
        } else {
            swap(nums, mid, high--);
        }
    }
}

private void swap(int[] a, int i, int j) {
    int t = a[i];
    a[i] = a[j];
    a[j] = t;
}
```

* **Time:** O(n)
* **Space:** O(1)

---

### **108. Minimum Difference Between Two Elements**

```java
public int minDifference(int[] nums) {
    Arrays.sort(nums);
    int min = Integer.MAX_VALUE;

    for (int i = 1; i < nums.length; i++) {
        min = Math.min(min, nums[i] - nums[i - 1]);
    }
    return min;
}
```

* **Time:** O(n log n)
* **Space:** O(1)

---
