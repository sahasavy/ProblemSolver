# TOPIC : Problem Patterns → Frequency Counting

---

## 📘 Question Bank

---

### **109. First Non-Repeating Character in a String**

**Problem Statement**
Given a string, return the **first character that appears exactly once**.
Return `'\0'` if no such character exists.

**Examples**

| Input        | Output |
|--------------|--------|
| `"leetcode"` | `'l'`  |
| `"aabb"`     | `'\0'` |

---

### **110. Majority Element (> n/2)**

**Problem Statement**
Given an integer array, find the element that appears **more than ⌊n/2⌋ times**.

**Examples**

| Input             | Output |
|-------------------|--------|
| `[3,2,3]`         | `3`    |
| `[2,2,1,1,1,2,2]` | `2`    |

---

### **111. Check if Two Strings Are Anagrams**

**Problem Statement**
Given two strings, determine if they are anagrams of each other.

**Examples**

| Input               | Output  |
|---------------------|---------|
| `"listen","silent"` | `true`  |
| `"rat","car"`       | `false` |

---

### **112. Find All Duplicate Elements in an Array**

**Problem Statement**
Given an integer array, return all elements that appear **more than once**.

**Examples**

| Input               | Output  |
|---------------------|---------|
| `[4,3,2,7,8,2,3,1]` | `[2,3]` |

---

### **113. Sort Characters by Frequency**

**Problem Statement**
Sort characters in a string by **descending frequency**.

**Examples**

| Input      | Output     |
|------------|------------|
| `"tree"`   | `"eert"`   |
| `"cccaaa"` | `"cccaaa"` |

---

### **114. Longest Palindrome That Can Be Built**

**Problem Statement**
Return the length of the longest palindrome that can be built using characters of the string.

**Examples**

| Input        | Output |
|--------------|--------|
| `"abccccdd"` | `7`    |

---

### **115. Top K Frequent Elements**

**Problem Statement**
Given an integer array, return the **k most frequent elements**.

**Examples**

| Input                | Output  |
|----------------------|---------|
| `[1,1,1,2,2,3], k=2` | `[1,2]` |

---

### **116. Count Occurrences of Each Character**

**Problem Statement**
Given a string, return a map of character frequencies.

**Examples**

| Input      | Output          |
|------------|-----------------|
| `"banana"` | `{b=1,a=3,n=2}` |

---

---

## 🧠 Solutions

---

### **109. First Non-Repeating Character**

```java
public char firstUniqueChar(String s) {
    int[] freq = new int[256];
    for (char c : s.toCharArray()) freq[c]++;
    for (char c : s.toCharArray()) {
        if (freq[c] == 1) return c;
    }
    return '\0';
}
```

* **Time:** O(n)
* **Space:** O(1)

---

### **110. Majority Element**

```java
public int majorityElement(int[] nums) {
    int count = 0, candidate = 0;

    for (int n : nums) {
        if (count == 0) candidate = n;
        count += (n == candidate) ? 1 : -1;
    }
    return candidate;
}
```

* **Time:** O(n)
* **Space:** O(1)

---

### **111. Valid Anagram**

```java
public boolean isAnagram(String s, String t) {
    if (s.length() != t.length()) return false;

    int[] count = new int[26];
    for (char c : s.toCharArray()) count[c - 'a']++;
    for (char c : t.toCharArray()) {
        if (--count[c - 'a'] < 0) return false;
    }
    return true;
}
```

* **Time:** O(n)
* **Space:** O(1)

---

### **112. Find All Duplicates**

```java
public List<Integer> findDuplicates(int[] nums) {
    Map<Integer, Integer> freq = new HashMap<>();
    List<Integer> res = new ArrayList<>();

    for (int n : nums) freq.put(n, freq.getOrDefault(n, 0) + 1);
    for (int k : freq.keySet()) {
        if (freq.get(k) > 1) res.add(k);
    }
    return res;
}
```

* **Time:** O(n)
* **Space:** O(n)

---

### **113. Sort Characters by Frequency**

```java
public String frequencySort(String s) {
    Map<Character, Integer> map = new HashMap<>();
    for (char c : s.toCharArray())
        map.put(c, map.getOrDefault(c, 0) + 1);

    return map.entrySet().stream()
            .sorted((a, b) -> b.getValue() - a.getValue())
            .map(e -> String.valueOf(e.getKey()).repeat(e.getValue()))
            .collect(Collectors.joining());
}
```

* **Time:** O(n log n)
* **Space:** O(n)

---

### **114. Longest Palindrome by Characters**

```java
public int longestPalindrome(String s) {
    int[] count = new int[128];
    for (char c : s.toCharArray()) count[c]++;

    int len = 0;
    boolean odd = false;
    for (int c : count) {
        len += (c / 2) * 2;
        if (c % 2 == 1) odd = true;
    }
    return odd ? len + 1 : len;
}
```

* **Time:** O(n)
* **Space:** O(1)

---

### **115. Top K Frequent Elements**

```java
public int[] topKFrequent(int[] nums, int k) {
    Map<Integer, Integer> freq = new HashMap<>();
    for (int n : nums) freq.put(n, freq.getOrDefault(n, 0) + 1);

    return freq.entrySet().stream()
            .sorted((a, b) -> b.getValue() - a.getValue())
            .limit(k)
            .mapToInt(Map.Entry::getKey)
            .toArray();
}
```

* **Time:** O(n log n)
* **Space:** O(n)

---

### **116. Count Occurrences of Each Character**

```java
public Map<Character, Integer> charFrequency(String s) {
    Map<Character, Integer> map = new HashMap<>();
    for (char c : s.toCharArray()) {
        map.put(c, map.getOrDefault(c, 0) + 1);
    }
    return map;
}
```

* **Time:** O(n)
* **Space:** O(n)

---
