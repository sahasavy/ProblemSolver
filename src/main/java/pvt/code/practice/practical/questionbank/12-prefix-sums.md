# TOPIC : Problem Patterns → Prefix Sums

---

## 📘 Question Bank

---

### **117. Range Sum Query (Immutable)**

**Problem Statement**
Given an integer array `nums`, handle multiple queries of the form
`sumRange(left, right)` which returns the sum of elements between indices `left` and `right` (inclusive).

**Examples**

| nums          | Query           | Output |
|---------------|-----------------|--------|
| `[1,2,3,4,5]` | `sumRange(1,3)` | `9`    |
| `[1,2,3,4,5]` | `sumRange(0,4)` | `15`   |

---

### **118. Subarray Sum Equals K**

**Problem Statement**
Given an integer array and integer `k`, return the **total number of subarrays** whose sum equals `k`.

**Examples**

| Input          | Output |
|----------------|--------|
| `[1,1,1], k=2` | `2`    |
| `[1,2,3], k=3` | `2`    |

---

### **119. Find Pivot Index**

**Problem Statement**
Return the index where the sum of elements on the left equals the sum on the right.

**Examples**

| Input           | Output |
|-----------------|--------|
| `[1,7,3,6,5,6]` | `3`    |
| `[1,2,3]`       | `-1`   |

---

### **120. Running Sum of 1D Array**

**Problem Statement**
Return the running sum of the array.

**Examples**

| Input       | Output       |
|-------------|--------------|
| `[1,2,3,4]` | `[1,3,6,10]` |

---

### **121. Product of Array Except Self**

**Problem Statement**
Return an array where each element is the product of all other elements **except itself**.

**Examples**

| Input       | Output        |
|-------------|---------------|
| `[1,2,3,4]` | `[24,12,8,6]` |

---

### **122. Maximum Size Subarray Sum Equals K**

**Problem Statement**
Given an integer array, return the **maximum length** subarray with sum exactly `k`.

**Examples**

| Input                | Output |
|----------------------|--------|
| `[1,-1,5,-2,3], k=3` | `4`    |

---

---

## 🧠 Solutions

---

### **117. Range Sum Query (Immutable)**

```java
class NumArray {
    private int[] prefix;

    public NumArray(int[] nums) {
        prefix = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }
    }

    public int sumRange(int left, int right) {
        return prefix[right + 1] - prefix[left];
    }
}
```

* **Time:**

    * Preprocessing: O(n)
    * Query: O(1)
* **Space:** O(n)

---

### **118. Subarray Sum Equals K**

```java
public int subarraySum(int[] nums, int k) {
    Map<Integer, Integer> map = new HashMap<>();
    map.put(0, 1);

    int sum = 0, count = 0;
    for (int n : nums) {
        sum += n;
        count += map.getOrDefault(sum - k, 0);
        map.put(sum, map.getOrDefault(sum, 0) + 1);
    }
    return count;
}
```

* **Time:** O(n)
* **Space:** O(n)

---

### **119. Find Pivot Index**

```java
public int pivotIndex(int[] nums) {
    int total = 0;
    for (int n : nums) total += n;

    int leftSum = 0;
    for (int i = 0; i < nums.length; i++) {
        if (leftSum == total - leftSum - nums[i]) return i;
        leftSum += nums[i];
    }
    return -1;
}
```

* **Time:** O(n)
* **Space:** O(1)

---

### **120. Running Sum of 1D Array**

```java
public int[] runningSum(int[] nums) {
    int[] res = new int[nums.length];
    res[0] = nums[0];

    for (int i = 1; i < nums.length; i++) {
        res[i] = res[i - 1] + nums[i];
    }
    return res;
}
```

* **Time:** O(n)
* **Space:** O(n)

---

### **121. Product of Array Except Self**

```java
public int[] productExceptSelf(int[] nums) {
    int n = nums.length;
    int[] res = new int[n];

    res[0] = 1;
    for (int i = 1; i < n; i++) {
        res[i] = res[i - 1] * nums[i - 1];
    }

    int right = 1;
    for (int i = n - 1; i >= 0; i--) {
        res[i] *= right;
        right *= nums[i];
    }
    return res;
}
```

* **Time:** O(n)
* **Space:** O(1) (excluding output)

---

### **122. Maximum Size Subarray Sum Equals K**

```java
public int maxSubArrayLen(int[] nums, int k) {
    Map<Integer, Integer> map = new HashMap<>();
    map.put(0, -1);

    int sum = 0, maxLen = 0;
    for (int i = 0; i < nums.length; i++) {
        sum += nums[i];
        if (map.containsKey(sum - k)) {
            maxLen = Math.max(maxLen, i - map.get(sum - k));
        }
        map.putIfAbsent(sum, i);
    }
    return maxLen;
}
```

* **Time:** O(n)
* **Space:** O(n)

---
