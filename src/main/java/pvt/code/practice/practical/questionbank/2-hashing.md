# TOPIC : Core → Hashing

---

## 📘 Question Bank

---

### **19. Two Sum**

**Problem Statement**
Given an integer array `int[] nums` and an integer `target`, return the **indices of the two distinct elements** whose
sum equals `target`.

Assumptions:

* Exactly one valid solution exists
* You cannot use the same index twice

**Examples**

| Input                   | Output  |
|-------------------------|---------|
| `[2,7,11,15], target=9` | `[0,1]` |
| `[3,2,4], target=6`     | `[1,2]` |

**Tricky Cases**

| Input                      | Output  | Reason                        |
|----------------------------|---------|-------------------------------|
| `[3,3], target=6`          | `[0,1]` | Same value, different indices |
| `[0,4,3,0], target=0`      | `[0,3]` | Zero handling                 |
| `[-1,-2,-3,-4], target=-6` | `[1,3]` | Negative numbers              |

---

### **20. Subarray Sum Equals K**

**Problem Statement**
Given an integer array `int[] nums` and an integer `k`, return the **total number of continuous subarrays** whose sum
equals `k`.

**Examples**

| Input          | Output |
|----------------|--------|
| `[1,1,1], k=2` | `2`    |
| `[1,2,3], k=3` | `2`    |

**Tricky Cases**

| Input                     | Output | Reason                |
|---------------------------|--------|-----------------------|
| `[0,0,0], k=0`            | `6`    | Overlapping subarrays |
| `[-1,-1,1], k=0`          | `1`    | Negative numbers      |
| `[3,4,7,2,-3,1,4,2], k=7` | `4`    | Mixed values          |

---

### **21. Longest Substring Without Repeating Characters**

**Problem Statement**
Return the length of the **longest substring** without repeating characters.

**Examples**

| Input        | Output |
|--------------|--------|
| `"abcabcbb"` | `3`    |
| `"bbbbb"`    | `1`    |

**Tricky Cases**

| Input      | Output |
|------------|--------|
| `""`       | `0`    |
| `"pwwkew"` | `3`    |
| `"dvdf"`   | `3`    |

---

### **22. Group Anagrams**

**Problem Statement**
Given an array of strings, group all strings that are **anagrams** of each other.

**Examples**

| Input                                   | Output                                        |
|-----------------------------------------|-----------------------------------------------|
| `["eat","tea","tan","ate","nat","bat"]` | `[["eat","tea","ate"],["tan","nat"],["bat"]]` |

**Tricky Cases**

| Input                     | Output           |
|---------------------------|------------------|
| `[""]`                    | `[[""]]`         |
| `["a"]`                   | `[["a"]]`        |
| `["ab","ba","abc","cba"]` | Two valid groups |

---

### **23. Intersection of Two Arrays**

**Problem Statement**
Given two integer arrays, return an array of their **unique intersection elements**.

**Examples**

| Input                  | Output  |
|------------------------|---------|
| `[1,2,2,1], [2,2]`     | `[2]`   |
| `[4,9,5], [9,4,9,8,4]` | `[4,9]` |

---

### **24. First Repeating Element**

**Problem Statement**
Return the **first element that repeats** while scanning from left to right.
Return `-1` if none exists.

**Examples**

| Input              | Output |
|--------------------|--------|
| `[10,5,3,4,3,5,6]` | `3`    |
| `[1,2,3,4]`        | `-1`   |

---

### **25. Isomorphic Strings**

**Problem Statement**
Two strings are isomorphic if characters in one string can be replaced to get the other string, preserving order.

**Examples**

| Input         | Output  |
|---------------|---------|
| `"egg","add"` | `true`  |
| `"foo","bar"` | `false` |

**Tricky Cases**

| Input             | Output  |
|-------------------|---------|
| `"paper","title"` | `true`  |
| `"ab","aa"`       | `false` |

---

### **26. Sort Characters by Frequency**

**Problem Statement**
Sort the characters of a string in **descending order of frequency**.

**Examples**

| Input      | Output     |
|------------|------------|
| `"tree"`   | `"eert"`   |
| `"cccaaa"` | `"cccaaa"` |

---

### **27. Longest Palindrome by Characters**

**Problem Statement**
Return the **length of the longest palindrome** that can be built using the characters of the string.

**Examples**

| Input        | Output |
|--------------|--------|
| `"abccccdd"` | `7`    |
| `"a"`        | `1`    |

---

### **28. Top K Frequent Elements**

**Problem Statement**
Given an integer array, return the **k most frequent elements**.

**Examples**

| Input                | Output  |
|----------------------|---------|
| `[1,1,1,2,2,3], k=2` | `[1,2]` |

---

### **29. Happy Number**

**Problem Statement**
A number is happy if repeatedly replacing it with the sum of squares of its digits eventually results in `1`.

**Examples**

| Input | Output  |
|-------|---------|
| `19`  | `true`  |
| `2`   | `false` |

---

### **30. Count Distinct Elements in Every Window**

**Problem Statement**
Given an array and a window size `k`, return the **count of distinct elements** in every window.

**Examples**

| Input                  | Output      |
|------------------------|-------------|
| `[1,2,1,3,4,2,3], k=4` | `[3,4,4,3]` |

---

## 🧠 Solutions

---

### **19. Two Sum**

```java
public int[] twoSum(int[] nums, int target) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
        int diff = target - nums[i];
        if (map.containsKey(diff)) {
            return new int[]{map.get(diff), i};
        }
        map.put(nums[i], i);
    }
    return new int[0];
}
```

* **Time:** O(n)
* **Space:** O(n)

---

### **20. Subarray Sum Equals K**

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

### **21. Longest Substring Without Repeating Characters**

```java
public int lengthOfLongestSubstring(String s) {
    Map<Character, Integer> map = new HashMap<>();
    int left = 0, max = 0;

    for (int right = 0; right < s.length(); right++) {
        char c = s.charAt(right);
        if (map.containsKey(c)) {
            left = Math.max(left, map.get(c) + 1);
        }
        map.put(c, right);
        max = Math.max(max, right - left + 1);
    }
    return max;
}
```

* **Time:** O(n)
* **Space:** O(n)

---

### **22. Group Anagrams**

```java
public List<List<String>> groupAnagrams(String[] strs) {
    Map<String, List<String>> map = new HashMap<>();

    for (String s : strs) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        String key = new String(chars);

        map.computeIfAbsent(key, k -> new ArrayList<>()).add(s);
    }
    return new ArrayList<>(map.values());
}
```

* **Time:** O(n · k log k)
* **Space:** O(n)

---

### **23. Intersection of Two Arrays**

```java
public int[] intersection(int[] nums1, int[] nums2) {
    Set<Integer> set = new HashSet<>();
    for (int n : nums1) set.add(n);

    Set<Integer> res = new HashSet<>();
    for (int n : nums2) {
        if (set.contains(n)) res.add(n);
    }
    return res.stream().mapToInt(i -> i).toArray();
}
```

* **Time:** O(n + m)
* **Space:** O(n)

---

### **24. First Repeating Element**

```java
public int firstRepeating(int[] arr) {
    Set<Integer> seen = new HashSet<>();
    for (int n : arr) {
        if (seen.contains(n)) return n;
        seen.add(n);
    }
    return -1;
}
```

* **Time:** O(n)
* **Space:** O(n)

---

### **25. Isomorphic Strings**

```java
public boolean isIsomorphic(String s, String t) {
    if (s.length() != t.length()) return false;

    Map<Character, Character> m1 = new HashMap<>();
    Map<Character, Character> m2 = new HashMap<>();

    for (int i = 0; i < s.length(); i++) {
        char c1 = s.charAt(i), c2 = t.charAt(i);

        if (m1.containsKey(c1) && m1.get(c1) != c2) return false;
        if (m2.containsKey(c2) && m2.get(c2) != c1) return false;

        m1.put(c1, c2);
        m2.put(c2, c1);
    }
    return true;
}
```

* **Time:** O(n)
* **Space:** O(n)

---

### **26. Sort Characters by Frequency**

```java
public String frequencySort(String s) {
    Map<Character, Integer> map = new HashMap<>();
    for (char c : s.toCharArray()) {
        map.put(c, map.getOrDefault(c, 0) + 1);
    }

    return map.entrySet().stream()
            .sorted((a, b) -> b.getValue() - a.getValue())
            .map(e -> String.valueOf(e.getKey()).repeat(e.getValue()))
            .collect(Collectors.joining());
}
```

* **Time:** O(n log n)
* **Space:** O(n)

---

### **27. Longest Palindrome by Characters**

```java
public int longestPalindrome(String s) {
    int[] count = new int[128];
    for (char c : s.toCharArray()) count[c]++;

    int len = 0;
    boolean hasOdd = false;
    for (int c : count) {
        len += (c / 2) * 2;
        if (c % 2 == 1) hasOdd = true;
    }
    return hasOdd ? len + 1 : len;
}
```

* **Time:** O(n)
* **Space:** O(1)

---

### **28. Top K Frequent Elements**

```java
public int[] topKFrequent(int[] nums, int k) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int n : nums) map.put(n, map.getOrDefault(n, 0) + 1);

    return map.entrySet().stream()
            .sorted((a, b) -> b.getValue() - a.getValue())
            .limit(k)
            .mapToInt(Map.Entry::getKey)
            .toArray();
}
```

* **Time:** O(n log n)
* **Space:** O(n)

---

### **29. Happy Number**

```java
public boolean isHappy(int n) {
    Set<Integer> seen = new HashSet<>();
    while (n != 1 && !seen.contains(n)) {
        seen.add(n);
        int sum = 0;
        while (n > 0) {
            int d = n % 10;
            sum += d * d;
            n /= 10;
        }
        n = sum;
    }
    return n == 1;
}
```

* **Time:** O(log n)
* **Space:** O(log n)

---

### **30. Count Distinct Elements in Every Window**

```java
public List<Integer> countDistinct(int[] nums, int k) {
    Map<Integer, Integer> freq = new HashMap<>();
    List<Integer> result = new ArrayList<>();

    for (int i = 0; i < nums.length; i++) {
        freq.put(nums[i], freq.getOrDefault(nums[i], 0) + 1);

        if (i >= k) {
            freq.put(nums[i - k], freq.get(nums[i - k]) - 1);
            if (freq.get(nums[i - k]) == 0) freq.remove(nums[i - k]);
        }
        if (i >= k - 1) {
            result.add(freq.size());
        }
    }
    return result;
}
```

* **Time:** O(n)
* **Space:** O(k)

---
