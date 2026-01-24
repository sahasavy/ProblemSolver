# TOPIC : Core → Recursion Basics

---

## 📘 Question Bank

---

### **53. Print Numbers from 1 to N (Recursive)**

**Problem Statement**
Given an integer `n`, print numbers from `1` to `n` using recursion.

**Examples**

| Input   | Output      |
|---------|-------------|
| `n = 5` | `1 2 3 4 5` |

**Tricky Cases**

* `n = 0` → print nothing
* Negative `n` → handle gracefully

---

### **54. Factorial of a Number**

**Problem Statement**
Compute the factorial of a non-negative integer `n` using recursion.

**Examples**

| Input   | Output |
|---------|--------|
| `n = 5` | `120`  |
| `n = 0` | `1`    |

---

### **55. Fibonacci Number**

**Problem Statement**
Return the `n`-th Fibonacci number using recursion.

**Definition**
`fib(0) = 0`, `fib(1) = 1`
`fib(n) = fib(n-1) + fib(n-2)`

**Examples**

| Input   | Output |
|---------|--------|
| `n = 6` | `8`    |

**Note**
This is a **conceptual recursion problem**, not optimized.

---

### **56. Sum of Digits of a Number**

**Problem Statement**
Given a non-negative integer `n`, return the sum of its digits using recursion.

**Examples**

| Input      | Output |
|------------|--------|
| `n = 1234` | `10`   |
| `n = 0`    | `0`    |

---

### **57. Reverse a String Using Recursion**

**Problem Statement**
Reverse a string using recursion.

**Examples**

| Input    | Output   |
|----------|----------|
| `"abcd"` | `"dcba"` |

---

### **58. Check if String is Palindrome (Recursive)**

**Problem Statement**
Check whether a string is a palindrome using recursion.

**Examples**

| Input     | Output  |
|-----------|---------|
| `"madam"` | `true`  |
| `"hello"` | `false` |

---

### **59. Power Function (xⁿ)**

**Problem Statement**
Compute `x` raised to the power `n` using recursion.

**Examples**

| Input          | Output |
|----------------|--------|
| `x = 2, n = 5` | `32`   |
| `x = 3, n = 0` | `1`    |

---

### **60. Count Number of Digits**

**Problem Statement**
Given a non-negative integer `n`, count the number of digits using recursion.

**Examples**

| Input       | Output |
|-------------|--------|
| `n = 12345` | `5`    |
| `n = 0`     | `1`    |

---

### **61. Check if Array is Sorted**

**Problem Statement**
Check if an integer array is sorted in non-decreasing order using recursion.

**Examples**

| Input         | Output  |
|---------------|---------|
| `[1,2,3,4,5]` | `true`  |
| `[1,3,2]`     | `false` |

---

### **62. Binary Search Using Recursion**

**Problem Statement**
Implement binary search recursively on a sorted array.

**Examples**

| Input                   | Output |
|-------------------------|--------|
| `[1,2,3,4,5], target=4` | `3`    |
| `[1,2,3], target=6`     | `-1`   |

---

---

## 🧠 Solutions

---

### **53. Print Numbers from 1 to N**

```java
public void printNumbers(int n) {
    if (n <= 0) return;
    printNumbers(n - 1);
    System.out.print(n + " ");
}
```

* **Time:** O(n)
* **Space:** O(n) (recursion stack)

---

### **54. Factorial**

```java
public int factorial(int n) {
    if (n == 0) return 1;
    return n * factorial(n - 1);
}
```

* **Time:** O(n)
* **Space:** O(n)

---

### **55. Fibonacci (Recursive)**

```java
public int fibonacci(int n) {
    if (n == 0) return 0;
    if (n == 1) return 1;
    return fibonacci(n - 1) + fibonacci(n - 2);
}
```

* **Time:** O(2ⁿ)
* **Space:** O(n)

---

### **56. Sum of Digits**

```java
public int sumOfDigits(int n) {
    if (n == 0) return 0;
    return n % 10 + sumOfDigits(n / 10);
}
```

* **Time:** O(d)
* **Space:** O(d)
  (`d` = number of digits)

---

### **57. Reverse a String**

```java
public String reverseString(String s) {
    if (s.length() <= 1) return s;
    return reverseString(s.substring(1)) + s.charAt(0);
}
```

* **Time:** O(n²) (due to substring)
* **Space:** O(n)

---

### **58. Palindrome Check (Recursive)**

```java
public boolean isPalindrome(String s, int l, int r) {
    if (l >= r) return true;
    if (s.charAt(l) != s.charAt(r)) return false;
    return isPalindrome(s, l + 1, r - 1);
}
```

* **Time:** O(n)
* **Space:** O(n)

---

### **59. Power Function (xⁿ)**

```java
public int power(int x, int n) {
    if (n == 0) return 1;
    return x * power(x, n - 1);
}
```

* **Time:** O(n)
* **Space:** O(n)

---

### **60. Count Number of Digits**

```java
public int countDigits(int n) {
    if (n == 0) return 1;
    return countDigitsHelper(n);
}

private int countDigitsHelper(int n) {
    if (n == 0) return 0;
    return 1 + countDigitsHelper(n / 10);
}
```

* **Time:** O(d)
* **Space:** O(d)

---

### **61. Check if Array is Sorted**

```java
public boolean isSorted(int[] arr, int index) {
    if (index == arr.length - 1) return true;
    if (arr[index] > arr[index + 1]) return false;
    return isSorted(arr, index + 1);
}
```

* **Time:** O(n)
* **Space:** O(n)

---

### **62. Binary Search (Recursive)**

```java
public int binarySearch(int[] nums, int target, int l, int r) {
    if (l > r) return -1;

    int mid = l + (r - l) / 2;
    if (nums[mid] == target) return mid;
    if (nums[mid] > target)
        return binarySearch(nums, target, l, mid - 1);
    else
        return binarySearch(nums, target, mid + 1, r);
}
```

* **Time:** O(log n)
* **Space:** O(log n)

---
