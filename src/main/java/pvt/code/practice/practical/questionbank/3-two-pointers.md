# TOPIC : Core → Two Pointers

---

## 📘 Question Bank

---

### **31. Container With Most Water**

**Problem Statement**
Given an array `height[]` where each element represents the height of a vertical line, find two lines that together with
the x-axis form a container such that the container holds the **maximum amount of water**.

**Examples**

| Input                 | Output |
|-----------------------|--------|
| `[1,8,6,2,5,4,8,3,7]` | `49`   |
| `[1,1]`               | `1`    |

**Tricky Cases**

* Heights with plateaus
* Very large width but small height

---

### **32. 3Sum**

**Problem Statement**
Given an integer array `nums`, return all **unique triplets** `[a, b, c]` such that `a + b + c = 0`.

**Examples**

| Input              | Output                 |
|--------------------|------------------------|
| `[-1,0,1,2,-1,-4]` | `[[-1,-1,2],[-1,0,1]]` |

**Notes**

* Triplets must be unique
* Order does not matter

---

### **33. Remove Duplicates Allowing At Most Two Occurrences**

**Problem Statement**
Given a sorted array, remove duplicates in-place such that each element appears **at most twice**.

**Examples**

| Input           | Output              |
|-----------------|---------------------|
| `[1,1,1,2,2,3]` | `k=5 → [1,1,2,2,3]` |

---

### **34. Minimum Size Subarray Sum**

**Problem Statement**
Given an array of positive integers and a target sum, return the **minimum length** of a contiguous subarray whose sum ≥
target.
Return `0` if no such subarray exists.

**Examples**

| Input                     | Output |
|---------------------------|--------|
| `[2,3,1,2,4,3], target=7` | `2`    |

---

### **35. Longest Repeating Character Replacement**

**Problem Statement**
Given a string `s` and integer `k`, return the length of the longest substring that can be obtained by replacing at most
`k` characters to make all characters the same.

**Examples**

| Input            | Output |
|------------------|--------|
| `"ABAB", k=2`    | `4`    |
| `"AABABBA", k=1` | `4`    |

---

### **36. Max Consecutive Ones with K Flips**

**Problem Statement**
Given a binary array and integer `k`, return the maximum number of consecutive `1`s obtainable by flipping at most `k`
zeroes.

**Examples**

| Input                          | Output |
|--------------------------------|--------|
| `[1,1,1,0,0,0,1,1,1,1,0], k=2` | `6`    |

---

### **37. Trapping Rain Water**

**Problem Statement**
Given elevation heights, compute how much rain water can be trapped.

**Examples**

| Input                       | Output |
|-----------------------------|--------|
| `[0,1,0,2,1,0,1,3,2,1,2,1]` | `6`    |

---

### **38. Sort Colors**

**Problem Statement**
Sort an array containing `0`, `1`, and `2` in-place.

**Examples**

| Input           | Output          |
|-----------------|-----------------|
| `[2,0,2,1,1,0]` | `[0,0,1,1,2,2]` |

---

### **39. Find All Anagrams in a String**

**Problem Statement**
Given strings `s` and `p`, return all start indices of `p`'s anagrams in `s`.

**Examples**

| Input                   | Output  |
|-------------------------|---------|
| `"cbaebabacd", p="abc"` | `[0,6]` |

---

### **40. Subarray Product Less Than K**

**Problem Statement**
Given an array of positive integers and integer `k`, return the number of contiguous subarrays where the product is less
than `k`.

**Examples**

| Input               | Output |
|---------------------|--------|
| `[10,5,2,6], k=100` | `8`    |

---

### **41. Partition Labels**

**Problem Statement**
Partition a string into as many parts as possible such that each letter appears in **at most one part**.

**Examples**

| Input                        | Output    |
|------------------------------|-----------|
| `"ababcbacadefegdehijhklij"` | `[9,7,8]` |

---

### **42. Maximum Sliding Window**

**Problem Statement**
Given an array and window size `k`, return the maximum value in each window.

**Examples**

| Input                      | Output          |
|----------------------------|-----------------|
| `[1,3,-1,-3,5,3,6,7], k=3` | `[3,3,5,5,6,7]` |

---

---

## 🧠 Solutions

---

### **31. Container With Most Water**

```java
public int maxArea(int[] height) {
    int l = 0, r = height.length - 1;
    int max = 0;

    while (l < r) {
        int area = Math.min(height[l], height[r]) * (r - l);
        max = Math.max(max, area);

        if (height[l] < height[r]) l++;
        else r--;
    }
    return max;
}
```

* **Time:** O(n)
* **Space:** O(1)

---

### **32. 3Sum**

```java
public List<List<Integer>> threeSum(int[] nums) {
    Arrays.sort(nums);
    List<List<Integer>> res = new ArrayList<>();

    for (int i = 0; i < nums.length - 2; i++) {
        if (i > 0 && nums[i] == nums[i - 1]) continue;

        int l = i + 1, r = nums.length - 1;
        while (l < r) {
            int sum = nums[i] + nums[l] + nums[r];
            if (sum == 0) {
                res.add(Arrays.asList(nums[i], nums[l], nums[r]));
                while (l < r && nums[l] == nums[l + 1]) l++;
                while (l < r && nums[r] == nums[r - 1]) r--;
                l++;
                r--;
            } else if (sum < 0) {
                l++;
            } else {
                r--;
            }
        }
    }
    return res;
}
```

* **Time:** O(n²)
* **Space:** O(1) (excluding output)

---

### **33. Remove Duplicates Allowing At Most Two**

```java
public int removeDuplicates(int[] nums) {
    if (nums.length <= 2) return nums.length;

    int idx = 2;
    for (int i = 2; i < nums.length; i++) {
        if (nums[i] != nums[idx - 2]) {
            nums[idx++] = nums[i];
        }
    }
    return idx;
}
```

* **Time:** O(n)
* **Space:** O(1)

---

### **34. Minimum Size Subarray Sum**

```java
public int minSubArrayLen(int target, int[] nums) {
    int l = 0, sum = 0, min = Integer.MAX_VALUE;

    for (int r = 0; r < nums.length; r++) {
        sum += nums[r];
        while (sum >= target) {
            min = Math.min(min, r - l + 1);
            sum -= nums[l++];
        }
    }
    return min == Integer.MAX_VALUE ? 0 : min;
}
```

* **Time:** O(n)
* **Space:** O(1)

---

### **35. Longest Repeating Character Replacement**

```java
public int characterReplacement(String s, int k) {
    int[] freq = new int[26];
    int l = 0, maxFreq = 0, maxLen = 0;

    for (int r = 0; r < s.length(); r++) {
        freq[s.charAt(r) - 'A']++;
        maxFreq = Math.max(maxFreq, freq[s.charAt(r) - 'A']);

        while (r - l + 1 - maxFreq > k) {
            freq[s.charAt(l) - 'A']--;
            l++;
        }
        maxLen = Math.max(maxLen, r - l + 1);
    }
    return maxLen;
}
```

* **Time:** O(n)
* **Space:** O(1)

---

### **36. Max Consecutive Ones with K Flips**

```java
public int longestOnes(int[] nums, int k) {
    int l = 0, zeros = 0, max = 0;

    for (int r = 0; r < nums.length; r++) {
        if (nums[r] == 0) zeros++;
        while (zeros > k) {
            if (nums[l++] == 0) zeros--;
        }
        max = Math.max(max, r - l + 1);
    }
    return max;
}
```

* **Time:** O(n)
* **Space:** O(1)

---

### **37. Trapping Rain Water**

```java
public int trap(int[] height) {
    int l = 0, r = height.length - 1;
    int leftMax = 0, rightMax = 0, water = 0;

    while (l < r) {
        if (height[l] < height[r]) {
            leftMax = Math.max(leftMax, height[l]);
            water += leftMax - height[l++];
        } else {
            rightMax = Math.max(rightMax, height[r]);
            water += rightMax - height[r--];
        }
    }
    return water;
}
```

* **Time:** O(n)
* **Space:** O(1)

---

### **38. Sort Colors (Dutch National Flag)**

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

### **39. Find All Anagrams in a String**

```java
public List<Integer> findAnagrams(String s, String p) {
    List<Integer> res = new ArrayList<>();
    if (s.length() < p.length()) return res;

    int[] freq = new int[26];
    for (char c : p.toCharArray()) freq[c - 'a']++;

    int l = 0, count = p.length();
    for (int r = 0; r < s.length(); r++) {
        if (freq[s.charAt(r) - 'a']-- > 0) count--;

        if (r - l + 1 > p.length()) {
            if (freq[s.charAt(l++) - 'a']++ >= 0) count++;
        }
        if (count == 0) res.add(l);
    }
    return res;
}
```

* **Time:** O(n)
* **Space:** O(1)

---

### **40. Subarray Product Less Than K**

```java
public int numSubarrayProductLessThanK(int[] nums, int k) {
    if (k <= 1) return 0;

    int l = 0;
    long prod = 1;
    int count = 0;

    for (int r = 0; r < nums.length; r++) {
        prod *= nums[r];
        while (prod >= k) prod /= nums[l++];
        count += r - l + 1;
    }
    return count;
}
```

* **Time:** O(n)
* **Space:** O(1)

---

### **41. Partition Labels**

```java
public List<Integer> partitionLabels(String s) {
    int[] last = new int[26];
    for (int i = 0; i < s.length(); i++) {
        last[s.charAt(i) - 'a'] = i;
    }

    List<Integer> res = new ArrayList<>();
    int start = 0, end = 0;

    for (int i = 0; i < s.length(); i++) {
        end = Math.max(end, last[s.charAt(i) - 'a']);
        if (i == end) {
            res.add(end - start + 1);
            start = i + 1;
        }
    }
    return res;
}
```

* **Time:** O(n)
* **Space:** O(1)

---

### **42. Maximum Sliding Window**

```java
public int[] maxSlidingWindow(int[] nums, int k) {
    Deque<Integer> dq = new ArrayDeque<>();
    int[] res = new int[nums.length - k + 1];
    int idx = 0;

    for (int i = 0; i < nums.length; i++) {
        while (!dq.isEmpty() && dq.peekFirst() <= i - k) dq.pollFirst();
        while (!dq.isEmpty() && nums[dq.peekLast()] < nums[i]) dq.pollLast();
        dq.offerLast(i);

        if (i >= k - 1) res[idx++] = nums[dq.peekFirst()];
    }
    return res;
}
```

* **Time:** O(n)
* **Space:** O(k)

---
