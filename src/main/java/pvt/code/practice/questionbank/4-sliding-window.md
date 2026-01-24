# TOPIC : Core → Sliding Window

---

## 📘 Question Bank

---

### **43. Fixed Window Sum**

**Problem Statement**
Given an integer array `nums` and an integer `k`, return the **maximum sum of any contiguous subarray of size `k`**.

**Examples**

| Input                | Output |
|----------------------|--------|
| `[2,1,5,1,3,2], k=3` | `9`    |
| `[2,3,4,1,5], k=2`   | `7`    |

**Tricky Cases**

* `k == nums.length`
* `k == 1`
* Array with negative values

---

### **44. Minimum Size Subarray Sum**

**Problem Statement**
Given an array of **positive integers** and a target sum, return the **minimum length** of a contiguous subarray whose
sum is **≥ target**.
Return `0` if no such subarray exists.

**Examples**

| Input                     | Output |
|---------------------------|--------|
| `[2,3,1,2,4,3], target=7` | `2`    |

---

### **45. Longest Substring Without Repeating Characters**

**Problem Statement**
Return the length of the longest substring without repeating characters.

**Examples**

| Input        | Output |
|--------------|--------|
| `"abcabcbb"` | `3`    |
| `"bbbbb"`    | `1`    |

---

### **46. Longest Substring with At Most K Distinct Characters**

**Problem Statement**
Given a string `s` and integer `k`, return the length of the **longest substring** containing **at most `k` distinct
characters**.

**Examples**

| Input          | Output |
|----------------|--------|
| `"eceba", k=2` | `3`    |
| `"aa", k=1`    | `2`    |

---

### **47. Longest Repeating Character Replacement**

**Problem Statement**
Given a string `s` and integer `k`, return the length of the longest substring you can obtain by replacing at most `k`
characters so that all characters are the same.

**Examples**

| Input            | Output |
|------------------|--------|
| `"ABAB", k=2`    | `4`    |
| `"AABABBA", k=1` | `4`    |

---

### **48. Max Consecutive Ones with K Flips**

**Problem Statement**
Given a binary array and integer `k`, return the maximum number of consecutive `1`s obtainable by flipping at most `k`
zeroes.

**Examples**

| Input                          | Output |
|--------------------------------|--------|
| `[1,1,1,0,0,0,1,1,1,1,0], k=2` | `6`    |

---

### **49. Subarray Product Less Than K**

**Problem Statement**
Given an array of **positive integers** and integer `k`, return the number of contiguous subarrays where the product is
**less than `k`**.

**Examples**

| Input               | Output |
|---------------------|--------|
| `[10,5,2,6], k=100` | `8`    |

---

### **50. Find All Anagrams in a String**

**Problem Statement**
Given strings `s` and `p`, return all starting indices of `p`’s anagrams in `s`.

**Examples**

| Input                   | Output  |
|-------------------------|---------|
| `"cbaebabacd", p="abc"` | `[0,6]` |

---

### **51. Sliding Window Maximum**

**Problem Statement**
Given an array and window size `k`, return the maximum element in every window.

**Examples**

| Input                      | Output          |
|----------------------------|-----------------|
| `[1,3,-1,-3,5,3,6,7], k=3` | `[3,3,5,5,6,7]` |

---

### **52. Longest Subarray with Sum Equals K (Positive Numbers)**

**Problem Statement**
Given an array of **positive integers** and integer `k`, return the length of the **longest subarray** whose sum equals
`k`.

**Examples**

| Input              | Output |
|--------------------|--------|
| `[1,2,1,1,1], k=3` | `3`    |

---

---

## 🧠 Solutions

---

### **43. Fixed Window Sum**

```java
public int maxSumSubarray(int[] nums, int k) {
    int sum = 0, max = Integer.MIN_VALUE;

    for (int i = 0; i < nums.length; i++) {
        sum += nums[i];
        if (i >= k) sum -= nums[i - k];
        if (i >= k - 1) max = Math.max(max, sum);
    }
    return max;
}
```

* **Time:** O(n)
* **Space:** O(1)

---

### **44. Minimum Size Subarray Sum**

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

### **45. Longest Substring Without Repeating Characters**

```java
public int lengthOfLongestSubstring(String s) {
    Map<Character, Integer> map = new HashMap<>();
    int l = 0, max = 0;

    for (int r = 0; r < s.length(); r++) {
        char c = s.charAt(r);
        if (map.containsKey(c)) {
            l = Math.max(l, map.get(c) + 1);
        }
        map.put(c, r);
        max = Math.max(max, r - l + 1);
    }
    return max;
}
```

* **Time:** O(n)
* **Space:** O(n)

---

### **46. Longest Substring with At Most K Distinct Characters**

```java
public int lengthOfLongestSubstringKDistinct(String s, int k) {
    Map<Character, Integer> freq = new HashMap<>();
    int l = 0, max = 0;

    for (int r = 0; r < s.length(); r++) {
        freq.put(s.charAt(r), freq.getOrDefault(s.charAt(r), 0) + 1);

        while (freq.size() > k) {
            freq.put(s.charAt(l), freq.get(s.charAt(l)) - 1);
            if (freq.get(s.charAt(l)) == 0) freq.remove(s.charAt(l));
            l++;
        }
        max = Math.max(max, r - l + 1);
    }
    return max;
}
```

* **Time:** O(n)
* **Space:** O(k)

---

### **47. Longest Repeating Character Replacement**

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

### **48. Max Consecutive Ones with K Flips**

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

### **49. Subarray Product Less Than K**

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

### **50. Find All Anagrams in a String**

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

### **51. Sliding Window Maximum**

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

### **52. Longest Subarray with Sum Equals K (Positive Numbers)**

```java
public int longestSubarraySumK(int[] nums, int k) {
    int l = 0, sum = 0, max = 0;

    for (int r = 0; r < nums.length; r++) {
        sum += nums[r];
        while (sum > k) sum -= nums[l++];
        if (sum == k) max = Math.max(max, r - l + 1);
    }
    return max;
}
```

* **Time:** O(n)
* **Space:** O(1)

---
