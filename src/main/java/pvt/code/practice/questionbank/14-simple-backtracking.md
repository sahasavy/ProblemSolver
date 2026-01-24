# TOPIC : Problem Patterns → Simple Backtracking

---

## 📘 Question Bank

---

### **130. Generate All Subsets (Power Set)**

**Problem Statement**
Given an integer array `nums`, return **all possible subsets** (the power set).
The solution must not contain duplicate subsets.

**Examples**

| Input     | Output               |
|-----------|----------------------|
| `[1,2]`   | `[[],[1],[2],[1,2]]` |
| `[1,2,3]` | `8 subsets`          |

---

### **131. Generate All Permutations**

**Problem Statement**
Given an array of distinct integers, return **all possible permutations**.

**Examples**

| Input     | Output           |
|-----------|------------------|
| `[1,2,3]` | `6 permutations` |

---

### **132. Combination Sum**

**Problem Statement**
Given an array of **distinct integers** and a target, return all unique combinations where numbers can be chosen *
*multiple times**.

**Examples**

| Input                            | Output          |
|----------------------------------|-----------------|
| `candidates=[2,3,6,7], target=7` | `[[2,2,3],[7]]` |

---

### **133. Combination Sum II**

**Problem Statement**
Each number may be used **at most once**.
The solution set must not contain duplicate combinations.

**Examples**

| Input                                   | Output                          |
|-----------------------------------------|---------------------------------|
| `candidates=[10,1,2,7,6,1,5], target=8` | `[[1,1,6],[1,2,5],[1,7],[2,6]]` |

---

### **134. Generate Parentheses**

**Problem Statement**
Given `n` pairs of parentheses, generate all combinations of **well-formed parentheses**.

**Examples**

| Input   | Output                                           |
|---------|--------------------------------------------------|
| `n = 3` | `["((()))","(()())","(())()","()(())","()()()"]` |

---

### **135. Letter Combinations of a Phone Number**

**Problem Statement**
Given a string containing digits from `2–9`, return all possible letter combinations.

**Examples**

| Input  | Output                                           |
|--------|--------------------------------------------------|
| `"23"` | `["ad","ae","af","bd","be","bf","cd","ce","cf"]` |

---

### **136. Palindrome Partitioning**

**Problem Statement**
Partition a string such that every substring is a **palindrome**.

**Examples**

| Input   | Output                       |
|---------|------------------------------|
| `"aab"` | `[["a","a","b"],["aa","b"]]` |

---

### **137. N-Queens (Classic)**

**Problem Statement**
Place `n` queens on an `n × n` chessboard so that no two queens attack each other.

**Examples**

| Input   | Output           |
|---------|------------------|
| `n = 4` | `2 valid boards` |

---

---

## 🧠 Solutions

---

### **130. Subsets**

```java
public List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> res = new ArrayList<>();
    backtrack(0, nums, new ArrayList<>(), res);
    return res;
}

private void backtrack(int idx, int[] nums, List<Integer> curr, List<List<Integer>> res) {
    res.add(new ArrayList<>(curr));
    for (int i = idx; i < nums.length; i++) {
        curr.add(nums[i]);
        backtrack(i + 1, nums, curr, res);
        curr.remove(curr.size() - 1);
    }
}
```

* **Time:** O(2ⁿ)
* **Space:** O(n)

---

### **131. Permutations**

```java
public List<List<Integer>> permute(int[] nums) {
    List<List<Integer>> res = new ArrayList<>();
    backtrack(nums, new boolean[nums.length], new ArrayList<>(), res);
    return res;
}

private void backtrack(int[] nums, boolean[] used, List<Integer> curr, List<List<Integer>> res) {
    if (curr.size() == nums.length) {
        res.add(new ArrayList<>(curr));
        return;
    }
    for (int i = 0; i < nums.length; i++) {
        if (used[i]) continue;
        used[i] = true;
        curr.add(nums[i]);
        backtrack(nums, used, curr, res);
        curr.remove(curr.size() - 1);
        used[i] = false;
    }
}
```

* **Time:** O(n!)
* **Space:** O(n)

---

### **132. Combination Sum**

```java
public List<List<Integer>> combinationSum(int[] candidates, int target) {
    List<List<Integer>> res = new ArrayList<>();
    dfs(0, target, candidates, new ArrayList<>(), res);
    return res;
}

private void dfs(int idx, int target, int[] c, List<Integer> curr, List<List<Integer>> res) {
    if (target == 0) {
        res.add(new ArrayList<>(curr));
        return;
    }
    if (target < 0) return;

    for (int i = idx; i < c.length; i++) {
        curr.add(c[i]);
        dfs(i, target - c[i], c, curr, res);
        curr.remove(curr.size() - 1);
    }
}
```

* **Time:** Exponential
* **Space:** O(target depth)

---

### **133. Combination Sum II**

```java
public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    Arrays.sort(candidates);
    List<List<Integer>> res = new ArrayList<>();
    dfs(0, target, candidates, new ArrayList<>(), res);
    return res;
}

private void dfs(int idx, int target, int[] c, List<Integer> curr, List<List<Integer>> res) {
    if (target == 0) {
        res.add(new ArrayList<>(curr));
        return;
    }
    for (int i = idx; i < c.length && c[i] <= target; i++) {
        if (i > idx && c[i] == c[i - 1]) continue;
        curr.add(c[i]);
        dfs(i + 1, target - c[i], c, curr, res);
        curr.remove(curr.size() - 1);
    }
}
```

* **Time:** Exponential
* **Space:** O(n)

---

### **134. Generate Parentheses**

```java
public List<String> generateParenthesis(int n) {
    List<String> res = new ArrayList<>();
    backtrack("", 0, 0, n, res);
    return res;
}

private void backtrack(String curr, int open, int close, int n, List<String> res) {
    if (curr.length() == 2 * n) {
        res.add(curr);
        return;
    }
    if (open < n) backtrack(curr + "(", open + 1, close, n, res);
    if (close < open) backtrack(curr + ")", open, close + 1, n, res);
}
```

* **Time:** Catalan number growth
* **Space:** O(n)

---

### **135. Letter Combinations of Phone Number**

```java
private static final String[] MAP = {
        "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
};

public List<String> letterCombinations(String digits) {
    List<String> res = new ArrayList<>();
    if (digits.isEmpty()) return res;
    dfs(0, digits, new StringBuilder(), res);
    return res;
}

private void dfs(int idx, String digits, StringBuilder sb, List<String> res) {
    if (idx == digits.length()) {
        res.add(sb.toString());
        return;
    }
    for (char c : MAP[digits.charAt(idx) - '0'].toCharArray()) {
        sb.append(c);
        dfs(idx + 1, digits, sb, res);
        sb.deleteCharAt(sb.length() - 1);
    }
}
```

* **Time:** O(4ⁿ)
* **Space:** O(n)

---

### **136. Palindrome Partitioning**

```java
public List<List<String>> partition(String s) {
    List<List<String>> res = new ArrayList<>();
    dfs(0, s, new ArrayList<>(), res);
    return res;
}

private void dfs(int start, String s, List<String> curr, List<List<String>> res) {
    if (start == s.length()) {
        res.add(new ArrayList<>(curr));
        return;
    }
    for (int i = start; i < s.length(); i++) {
        if (isPalindrome(s, start, i)) {
            curr.add(s.substring(start, i + 1));
            dfs(i + 1, s, curr, res);
            curr.remove(curr.size() - 1);
        }
    }
}

private boolean isPalindrome(String s, int l, int r) {
    while (l < r) {
        if (s.charAt(l++) != s.charAt(r--)) return false;
    }
    return true;
}
```

* **Time:** Exponential
* **Space:** O(n)

---

### **137. N-Queens**

```java
public List<List<String>> solveNQueens(int n) {
    List<List<String>> res = new ArrayList<>();
    char[][] board = new char[n][n];
    for (char[] row : board) Arrays.fill(row, '.');
    backtrack(0, board, res);
    return res;
}

private void backtrack(int row, char[][] board, List<List<String>> res) {
    if (row == board.length) {
        res.add(construct(board));
        return;
    }
    for (int col = 0; col < board.length; col++) {
        if (!isSafe(board, row, col)) continue;
        board[row][col] = 'Q';
        backtrack(row + 1, board, res);
        board[row][col] = '.';
    }
}

private boolean isSafe(char[][] board, int r, int c) {
    for (int i = 0; i < r; i++)
        if (board[i][c] == 'Q') return false;

    for (int i = r - 1, j = c - 1; i >= 0 && j >= 0; i--, j--)
        if (board[i][j] == 'Q') return false;

    for (int i = r - 1, j = c + 1; i >= 0 && j < board.length; i--, j++)
        if (board[i][j] == 'Q') return false;

    return true;
}
```

* **Time:** O(n!)
* **Space:** O(n²)

---
