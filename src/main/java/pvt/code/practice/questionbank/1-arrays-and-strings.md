# TOPIC : Core → Arrays & Strings

---

## 📘 Question Bank

---

### **1. Find the Second Largest Element in an Array**

**Problem Statement**
Given an integer array `int[] arr`, return the **second largest DISTINCT element**.
If it does not exist, return `-1`.

**Constraints**

* `0 ≤ arr.length ≤ 10^5`
* Array may contain negative values
* Duplicates allowed

**Examples**

| Input            | Output |
|------------------|--------|
| `[10, 5, 20, 8]` | `10`   |
| `[5, 5, 5]`      | `-1`   |
| `[-1, -5, -3]`   | `-3`   |

**Tricky Cases**

| Input                         | Output              | Reason          |
|-------------------------------|---------------------|-----------------|
| `[]`                          | `-1`                | Empty array     |
| `[1]`                         | `-1`                | Single element  |
| `[2, 1, 2]`                   | `1`                 | Duplicate max   |
| `[Integer.MIN_VALUE, -1, -1]` | `Integer.MIN_VALUE` | Distinct values |

---

### **2. Rotate Array by K Steps (In-Place)**

**Problem Statement**
Rotate the array to the **right by `k` steps**, modifying it **in-place**.

**Examples**

| Input              | Output        |
|--------------------|---------------|
| `[1,2,3,4,5], k=2` | `[4,5,1,2,3]` |
| `[1,2], k=3`       | `[2,1]`       |

**Tricky Cases**

| Input          | Output    |
|----------------|-----------|
| `[1], k=100`   | `[1]`     |
| `[1,2,3], k=0` | `[1,2,3]` |
| `[], k=5`      | `[]`      |

---

### **3. Maximum Subarray Sum**

**Problem Statement**
Return the **maximum sum of a contiguous subarray**.

**Examples**

| Input                     | Output |
|---------------------------|--------|
| `[-2,1,-3,4,-1,2,1,-5,4]` | `6`    |
| `[5]`                     | `5`    |

**Tricky Cases**

| Input                     | Output              |
|---------------------------|---------------------|
| `[-1,-2,-3]`              | `-1`                |
| `[Integer.MAX_VALUE, -1]` | `Integer.MAX_VALUE` |

---

### **4. Remove Duplicates from Sorted Array**

**Problem Statement**
Remove duplicates **in-place** from a sorted array and return the new length `k`.
The first `k` elements must contain unique values.

**Examples**

| Input               | Output            |
|---------------------|-------------------|
| `[1,1,2]`           | `k=2 → [1,2]`     |
| `[0,0,1,1,1,2,2,3]` | `k=4 → [0,1,2,3]` |

---

### **5. String Compression**

**Problem Statement**
Compress consecutive characters:
`"aaabbc"` → `"a3b2c1"`

Return the original string if the compressed version is **not shorter**.

**Examples**

| Input      | Output     |
|------------|------------|
| `"aaabbc"` | `"a3b2c1"` |
| `"abc"`    | `"abc"`    |

**Tricky Cases**

| Input           | Output  |
|-----------------|---------|
| `"a"`           | `"a"`   |
| `"aaaaaaaaaaa"` | `"a11"` |
| `""`            | `""`    |

---

### **6. Reverse Words in a String**

**Problem Statement**
Reverse the **order of words**, removing extra spaces.

**Examples**

| Input                | Output             |
|----------------------|--------------------|
| `"  hello world  "`  | `"world hello"`    |
| `"a good   example"` | `"example good a"` |

---

### **7. Longest Common Prefix**

**Problem Statement**
Return the longest common prefix among all strings.

**Examples**

| Input                        | Output |
|------------------------------|--------|
| `["flower","flow","flight"]` | `"fl"` |
| `["dog","racecar","car"]`    | `""`   |

---

### **8. Valid Palindrome (Ignore Non-Alphanumeric)**

**Problem Statement**
Check if a string is a palindrome, ignoring case and non-alphanumeric characters.

**Examples**

| Input                              | Output  |
|------------------------------------|---------|
| `"A man, a plan, a canal: Panama"` | `true`  |
| `"race a car"`                     | `false` |

---

### **9. First Non-Repeating Character**

**Problem Statement**
Return the **first character** that does not repeat.
Return `'\0'` if none exists.

**Examples**

| Input        | Output |
|--------------|--------|
| `"aabbccde"` | `'d'`  |
| `"aabb"`     | `'\0'` |

---

### **10. Check if Two Strings Are Anagrams**

**Examples**

| Input                | Output  |
|----------------------|---------|
| `"listen", "silent"` | `true`  |
| `"rat", "car"`       | `false` |

---

### **11. Move All Zeroes to End**

**Examples**

| Input          | Output         |
|----------------|----------------|
| `[0,1,0,3,12]` | `[1,3,12,0,0]` |

---

### **12. Merge Two Sorted Arrays**

**Examples**

| Input               | Output          |
|---------------------|-----------------|
| `[1,3,5] & [2,4,6]` | `[1,2,3,4,5,6]` |

---

### **13. Find Missing Number (0…n)**

**Examples**

| Input     | Output |
|-----------|--------|
| `[3,0,1]` | `2`    |
| `[0]`     | `1`    |

---

### **14. Majority Element (> n/2)**

**Examples**

| Input             | Output |
|-------------------|--------|
| `[2,2,1,1,1,2,2]` | `2`    |

---

### **15. Best Time to Buy and Sell Stock**

**Examples**

| Input           | Output |
|-----------------|--------|
| `[7,1,5,3,6,4]` | `5`    |
| `[7,6,4,3,1]`   | `0`    |

---

### **16. Longest Consecutive Sequence**

**Examples**

| Input               | Output |
|---------------------|--------|
| `[100,4,200,1,3,2]` | `4`    |

---

### **17. Check if String Rotation**

**Examples**

| Input              | Output  |
|--------------------|---------|
| `"abcde", "cdeab"` | `true`  |
| `"abc", "acb"`     | `false` |

---

### **18. Implement `atoi`**

**Examples**

| Input               | Output              |
|---------------------|---------------------|
| `"   -42"`          | `-42`               |
| `"4193 with words"` | `4193`              |
| `"91283472332"`     | `Integer.MAX_VALUE` |

---

## 🧠 Solutions

---

### **1. Find the Second Largest Element in an Array**

```java
public int secondLargest(int[] arr) {
    if (arr == null || arr.length < 2) return -1;

    Integer max = null, second = null;
    for (int n : arr) {
        if (max == null || n > max) {
            if (max != null && n != max) second = max;
            max = n;
        } else if (n != max && (second == null || n > second)) {
            second = n;
        }
    }
    return second == null ? -1 : second;
}
```

* **Time:** O(n)
* **Space:** O(1)

---

### **2. Rotate Array by K Steps (In-Place)**

```java
public void rotate(int[] nums, int k) {
    if (nums == null || nums.length == 0) return;

    k %= nums.length;
    reverse(nums, 0, nums.length - 1);
    reverse(nums, 0, k - 1);
    reverse(nums, k, nums.length - 1);
}

private void reverse(int[] arr, int l, int r) {
    while (l < r) {
        int tmp = arr[l];
        arr[l++] = arr[r];
        arr[r--] = tmp;
    }
}
```

* **Time:** O(n)
* **Space:** O(1)

---

### **3. Maximum Subarray Sum (Kadane’s Algorithm)**

```java
public int maxSubArray(int[] nums) {
    int current = nums[0], max = nums[0];
    for (int i = 1; i < nums.length; i++) {
        current = Math.max(nums[i], current + nums[i]);
        max = Math.max(max, current);
    }
    return max;
}
```

* **Time:** O(n)
* **Space:** O(1)

---

### **4. Remove Duplicates from Sorted Array**

```java
public int removeDuplicates(int[] nums) {
    if (nums.length == 0) return 0;

    int idx = 1;
    for (int i = 1; i < nums.length; i++) {
        if (nums[i] != nums[i - 1]) {
            nums[idx++] = nums[i];
        }
    }
    return idx;
}
```

* **Time:** O(n)
* **Space:** O(1)

---

### **5. String Compression**

```java
public String compress(String s) {
    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < s.length(); ) {
        int j = i;
        while (j < s.length() && s.charAt(i) == s.charAt(j)) j++;
        sb.append(s.charAt(i)).append(j - i);
        i = j;
    }
    return sb.length() < s.length() ? sb.toString() : s;
}
```

* **Time:** O(n)
* **Space:** O(n)

---

### **6. Reverse Words in a String**

```java
public String reverseWords(String s) {
    String[] words = s.trim().split("\\s+");
    StringBuilder sb = new StringBuilder();

    for (int i = words.length - 1; i >= 0; i--) {
        sb.append(words[i]).append(" ");
    }
    return sb.toString().trim();
}
```

* **Time:** O(n)
* **Space:** O(n)

---

### **7. Longest Common Prefix**

```java
public String longestCommonPrefix(String[] strs) {
    if (strs.length == 0) return "";

    String prefix = strs[0];
    for (int i = 1; i < strs.length; i++) {
        while (!strs[i].startsWith(prefix)) {
            prefix = prefix.substring(0, prefix.length() - 1);
            if (prefix.isEmpty()) return "";
        }
    }
    return prefix;
}
```

* **Time:** O(n · m)
* **Space:** O(1)

---

### **8. Valid Palindrome (Ignore Non-Alphanumeric)**

```java
public boolean isPalindrome(String s) {
    int l = 0, r = s.length() - 1;

    while (l < r) {
        while (l < r && !Character.isLetterOrDigit(s.charAt(l))) l++;
        while (l < r && !Character.isLetterOrDigit(s.charAt(r))) r--;

        if (Character.toLowerCase(s.charAt(l)) !=
                Character.toLowerCase(s.charAt(r))) {
            return false;
        }
        l++;
        r--;
    }
    return true;
}
```

* **Time:** O(n)
* **Space:** O(1)

---

### **9. First Non-Repeating Character**

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

### **10. Check if Two Strings Are Anagrams**

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

### **11. Move All Zeroes to End**

```java
public void moveZeroes(int[] nums) {
    int idx = 0;
    for (int n : nums) {
        if (n != 0) nums[idx++] = n;
    }
    while (idx < nums.length) nums[idx++] = 0;
}
```

* **Time:** O(n)
* **Space:** O(1)

---

### **12. Merge Two Sorted Arrays**

```java
public int[] merge(int[] a, int[] b) {
    int[] res = new int[a.length + b.length];
    int i = 0, j = 0, k = 0;

    while (i < a.length && j < b.length) {
        res[k++] = a[i] <= b[j] ? a[i++] : b[j++];
    }
    while (i < a.length) res[k++] = a[i++];
    while (j < b.length) res[k++] = b[j++];

    return res;
}
```

* **Time:** O(n + m)
* **Space:** O(n + m)

---

### **13. Find Missing Number (0…n)**

```java
public int missingNumber(int[] nums) {
    int n = nums.length;
    int sum = n * (n + 1) / 2;

    for (int num : nums) sum -= num;
    return sum;
}
```

* **Time:** O(n)
* **Space:** O(1)

---

### **14. Majority Element (> n/2)**

```java
public int majorityElement(int[] nums) {
    int count = 0, candidate = 0;

    for (int num : nums) {
        if (count == 0) candidate = num;
        count += (num == candidate) ? 1 : -1;
    }
    return candidate;
}
```

* **Time:** O(n)
* **Space:** O(1)

---

### **15. Best Time to Buy and Sell Stock**

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

### **16. Longest Consecutive Sequence**

```java
public int longestConsecutive(int[] nums) {
    Set<Integer> set = new HashSet<>();
    for (int n : nums) set.add(n);

    int max = 0;
    for (int n : set) {
        if (!set.contains(n - 1)) {
            int curr = n, len = 1;
            while (set.contains(curr + 1)) {
                curr++;
                len++;
            }
            max = Math.max(max, len);
        }
    }
    return max;
}
```

* **Time:** O(n)
* **Space:** O(n)

---

### **17. Check if String Rotation**

```java
public boolean isRotation(String s, String t) {
    return s.length() == t.length() && (s + s).contains(t);
}
```

* **Time:** O(n)
* **Space:** O(n)

---

### **18. Implement `atoi`**

```java
public int myAtoi(String s) {
    int i = 0, sign = 1, res = 0;

    while (i < s.length() && s.charAt(i) == ' ') i++;

    if (i < s.length() && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
        sign = s.charAt(i++) == '-' ? -1 : 1;
    }

    while (i < s.length() && Character.isDigit(s.charAt(i))) {
        int d = s.charAt(i++) - '0';
        if (res > (Integer.MAX_VALUE - d) / 10) {
            return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }
        res = res * 10 + d;
    }
    return res * sign;
}
```

* **Time:** O(n)
* **Space:** O(1)

---
