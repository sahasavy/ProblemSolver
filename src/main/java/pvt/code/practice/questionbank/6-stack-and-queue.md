# TOPIC : Structures → Stack & Queue

---

## 📘 Question Bank

---

### **63. Valid Parentheses**

**Problem Statement**
Given a string containing only `'('`, `')'`, `'{'`, `'}'`, `'['`, and `']'`, determine if the input string is valid.

A string is valid if:

* Open brackets are closed by the same type
* Open brackets are closed in the correct order

**Examples**

| Input      | Output  |
|------------|---------|
| `"()"`     | `true`  |
| `"()[]{}"` | `true`  |
| `"(]"`     | `false` |

---

### **64. Min Stack**

**Problem Statement**
Design a stack that supports:

* `push`
* `pop`
* `top`
* `getMin`
  all in **O(1)** time.

---

### **65. Next Greater Element**

**Problem Statement**
Given an array, for each element find the **next greater element to its right**.
If no such element exists, return `-1`.

**Examples**

| Input        | Output         |
|--------------|----------------|
| `[4,5,2,10]` | `[5,10,10,-1]` |

---

### **66. Daily Temperatures**

**Problem Statement**
Given a list of daily temperatures, return an array such that for each day, you tell how many days you would have to
wait until a warmer temperature.

**Examples**

| Input                       | Output              |
|-----------------------------|---------------------|
| `[73,74,75,71,69,72,76,73]` | `[1,1,4,2,1,1,0,0]` |

---

### **67. Simplify Unix Path**

**Problem Statement**
Given a Unix-style absolute file path, simplify it.

**Examples**

| Input               | Output    |
|---------------------|-----------|
| `"/home/"`          | `"/home"` |
| `"/a/./b/../../c/"` | `"/c"`    |

---

### **68. Evaluate Reverse Polish Notation**

**Problem Statement**
Evaluate the value of an arithmetic expression in **Reverse Polish Notation (RPN)**.

**Examples**

| Input                    | Output |
|--------------------------|--------|
| `["2","1","+","3","*"]`  | `9`    |
| `["4","13","5","/","+"]` | `6`    |

---

### **69. Stock Span Problem**

**Problem Statement**
Given daily stock prices, return the span of the stock’s price for each day.

**Examples**

| Input                     | Output            |
|---------------------------|-------------------|
| `[100,80,60,70,60,75,85]` | `[1,1,1,2,1,4,6]` |

---

### **70. Decode String**

**Problem Statement**
Given an encoded string, decode it.

**Examples**

| Input         | Output        |
|---------------|---------------|
| `"3[a]2[bc]"` | `"aaabcbc"`   |
| `"3[a2[c]]"`  | `"accaccacc"` |

---

### **71. Implement Queue Using Stacks**

**Problem Statement**
Implement a queue using two stacks.

---

### **72. Implement Stack Using Queues**

**Problem Statement**
Implement a stack using two queues.

---

---

## 🧠 Solutions

---

### **63. Valid Parentheses**

```java
public boolean isValid(String s) {
    Stack<Character> stack = new Stack<>();

    for (char c : s.toCharArray()) {
        if (c == '(' || c == '{' || c == '[') {
            stack.push(c);
        } else {
            if (stack.isEmpty()) return false;
            char top = stack.pop();
            if (c == ')' && top != '(') return false;
            if (c == '}' && top != '{') return false;
            if (c == ']' && top != '[') return false;
        }
    }
    return stack.isEmpty();
}
```

* **Time:** O(n)
* **Space:** O(n)

---

### **64. Min Stack**

```java
class MinStack {
    Stack<Integer> stack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();

    public void push(int val) {
        stack.push(val);
        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        }
    }

    public void pop() {
        if (stack.pop().equals(minStack.peek())) {
            minStack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
```

* **Time:** O(1) per operation
* **Space:** O(n)

---

### **65. Next Greater Element**

```java
public int[] nextGreaterElements(int[] nums) {
    int n = nums.length;
    int[] res = new int[n];
    Stack<Integer> stack = new Stack<>();

    for (int i = n - 1; i >= 0; i--) {
        while (!stack.isEmpty() && stack.peek() <= nums[i]) {
            stack.pop();
        }
        res[i] = stack.isEmpty() ? -1 : stack.peek();
        stack.push(nums[i]);
    }
    return res;
}
```

* **Time:** O(n)
* **Space:** O(n)

---

### **66. Daily Temperatures**

```java
public int[] dailyTemperatures(int[] temperatures) {
    int n = temperatures.length;
    int[] res = new int[n];
    Stack<Integer> stack = new Stack<>();

    for (int i = 0; i < n; i++) {
        while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
            int idx = stack.pop();
            res[idx] = i - idx;
        }
        stack.push(i);
    }
    return res;
}
```

* **Time:** O(n)
* **Space:** O(n)

---

### **67. Simplify Unix Path**

```java
public String simplifyPath(String path) {
    Stack<String> stack = new Stack<>();
    String[] parts = path.split("/");

    for (String part : parts) {
        if (part.equals("") || part.equals(".")) continue;
        if (part.equals("..")) {
            if (!stack.isEmpty()) stack.pop();
        } else {
            stack.push(part);
        }
    }
    return "/" + String.join("/", stack);
}
```

* **Time:** O(n)
* **Space:** O(n)

---

### **68. Evaluate Reverse Polish Notation**

```java
public int evalRPN(String[] tokens) {
    Stack<Integer> stack = new Stack<>();

    for (String t : tokens) {
        if (t.equals("+") || t.equals("-") || t.equals("*") || t.equals("/")) {
            int b = stack.pop();
            int a = stack.pop();
            switch (t) {
                case "+":
                    stack.push(a + b);
                    break;
                case "-":
                    stack.push(a - b);
                    break;
                case "*":
                    stack.push(a * b);
                    break;
                case "/":
                    stack.push(a / b);
                    break;
            }
        } else {
            stack.push(Integer.parseInt(t));
        }
    }
    return stack.pop();
}
```

* **Time:** O(n)
* **Space:** O(n)

---

### **69. Stock Span Problem**

```java
public int[] stockSpan(int[] prices) {
    int n = prices.length;
    int[] span = new int[n];
    Stack<Integer> stack = new Stack<>();

    for (int i = 0; i < n; i++) {
        while (!stack.isEmpty() && prices[stack.peek()] <= prices[i]) {
            stack.pop();
        }
        span[i] = stack.isEmpty() ? i + 1 : i - stack.peek();
        stack.push(i);
    }
    return span;
}
```

* **Time:** O(n)
* **Space:** O(n)

---

### **70. Decode String**

```java
public String decodeString(String s) {
    Stack<Integer> countStack = new Stack<>();
    Stack<StringBuilder> strStack = new Stack<>();
    StringBuilder curr = new StringBuilder();
    int k = 0;

    for (char c : s.toCharArray()) {
        if (Character.isDigit(c)) {
            k = k * 10 + (c - '0');
        } else if (c == '[') {
            countStack.push(k);
            strStack.push(curr);
            curr = new StringBuilder();
            k = 0;
        } else if (c == ']') {
            int times = countStack.pop();
            StringBuilder prev = strStack.pop();
            for (int i = 0; i < times; i++) prev.append(curr);
            curr = prev;
        } else {
            curr.append(c);
        }
    }
    return curr.toString();
}
```

* **Time:** O(n)
* **Space:** O(n)

---

### **71. Implement Queue Using Stacks**

```java
class MyQueue {
    Stack<Integer> in = new Stack<>();
    Stack<Integer> out = new Stack<>();

    public void push(int x) {
        in.push(x);
    }

    public int pop() {
        peek();
        return out.pop();
    }

    public int peek() {
        if (out.isEmpty()) {
            while (!in.isEmpty()) out.push(in.pop());
        }
        return out.peek();
    }

    public boolean empty() {
        return in.isEmpty() && out.isEmpty();
    }
}
```

* **Time:** Amortized O(1)
* **Space:** O(n)

---

### **72. Implement Stack Using Queues**

```java
class MyStack {
    Queue<Integer> q = new LinkedList<>();

    public void push(int x) {
        q.add(x);
        for (int i = 0; i < q.size() - 1; i++) {
            q.add(q.poll());
        }
    }

    public int pop() {
        return q.poll();
    }

    public int top() {
        return q.peek();
    }

    public boolean empty() {
        return q.isEmpty();
    }
}
```

* **Time:** Push O(n), Pop O(1)
* **Space:** O(n)

---
