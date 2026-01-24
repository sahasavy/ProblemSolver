# TOPIC : Structures → Trees (Binary Tree Basics)

---

## 📘 Question Bank

---

### **83. Maximum Depth of Binary Tree**

**Problem Statement**
Given the root of a binary tree, return its **maximum depth** (number of nodes along the longest path from root to
leaf).

**Examples**

| Tree                      | Output |
|---------------------------|--------|
| `[3,9,20,null,null,15,7]` | `3`    |
| `[]`                      | `0`    |

---

### **84. Invert Binary Tree**

**Problem Statement**
Invert a binary tree (swap left and right children recursively).

**Examples**

| Input             | Output            |
|-------------------|-------------------|
| `[4,2,7,1,3,6,9]` | `[4,7,2,9,6,3,1]` |

---

### **85. Binary Tree Level Order Traversal**

**Problem Statement**
Return the **level-order traversal** of a binary tree (BFS).

**Examples**

| Input                     | Output                |
|---------------------------|-----------------------|
| `[3,9,20,null,null,15,7]` | `[[3],[9,20],[15,7]]` |

---

### **86. Diameter of Binary Tree**

**Problem Statement**
Return the **diameter** of a binary tree (length of the longest path between any two nodes).

**Examples**

| Input         | Output |
|---------------|--------|
| `[1,2,3,4,5]` | `3`    |

---

### **87. Balanced Binary Tree**

**Problem Statement**
Check whether a binary tree is **height-balanced**.

**Examples**

| Input                       | Output  |
|-----------------------------|---------|
| `[3,9,20,null,null,15,7]`   | `true`  |
| `[1,2,2,3,3,null,null,4,4]` | `false` |

---

### **88. Symmetric Tree**

**Problem Statement**
Check whether a binary tree is a **mirror of itself**.

**Examples**

| Input                   | Output  |
|-------------------------|---------|
| `[1,2,2,3,4,4,3]`       | `true`  |
| `[1,2,2,null,3,null,3]` | `false` |

---

### **89. Path Sum**

**Problem Statement**
Given a binary tree and a target sum, return `true` if the tree has a **root-to-leaf path** such that the sum equals the
target.

**Examples**

| Input           | Output  |
|-----------------|---------|
| Tree sum = `22` | `true`  |
| Tree sum = `5`  | `false` |

---

### **90. Lowest Common Ancestor (Binary Tree)**

**Problem Statement**
Given a binary tree, find the **lowest common ancestor (LCA)** of two given nodes.

**Examples**

| Input                           | Output |
|---------------------------------|--------|
| `LCA(5,1)` in `[3,5,1,6,2,0,8]` | `3`    |

---

---

## 🧠 Solutions

> **Assumed Node Definition**

```java
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}
```

---

### **83. Maximum Depth of Binary Tree**

```java
public int maxDepth(TreeNode root) {
    if (root == null) return 0;
    return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
}
```

* **Time:** O(n)
* **Space:** O(h)

---

### **84. Invert Binary Tree**

```java
public TreeNode invertTree(TreeNode root) {
    if (root == null) return null;

    TreeNode left = invertTree(root.left);
    TreeNode right = invertTree(root.right);

    root.left = right;
    root.right = left;
    return root;
}
```

* **Time:** O(n)
* **Space:** O(h)

---

### **85. Binary Tree Level Order Traversal**

```java
public List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> res = new ArrayList<>();
    if (root == null) return res;

    Queue<TreeNode> q = new LinkedList<>();
    q.offer(root);

    while (!q.isEmpty()) {
        int size = q.size();
        List<Integer> level = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            TreeNode node = q.poll();
            level.add(node.val);
            if (node.left != null) q.offer(node.left);
            if (node.right != null) q.offer(node.right);
        }
        res.add(level);
    }
    return res;
}
```

* **Time:** O(n)
* **Space:** O(n)

---

### **86. Diameter of Binary Tree**

```java
int diameter = 0;

public int diameterOfBinaryTree(TreeNode root) {
    depth(root);
    return diameter;
}

private int depth(TreeNode node) {
    if (node == null) return 0;

    int left = depth(node.left);
    int right = depth(node.right);

    diameter = Math.max(diameter, left + right);
    return 1 + Math.max(left, right);
}
```

* **Time:** O(n)
* **Space:** O(h)

---

### **87. Balanced Binary Tree**

```java
public boolean isBalanced(TreeNode root) {
    return height(root) != -1;
}

private int height(TreeNode node) {
    if (node == null) return 0;

    int left = height(node.left);
    if (left == -1) return -1;

    int right = height(node.right);
    if (right == -1) return -1;

    if (Math.abs(left - right) > 1) return -1;
    return 1 + Math.max(left, right);
}
```

* **Time:** O(n)
* **Space:** O(h)

---

### **88. Symmetric Tree**

```java
public boolean isSymmetric(TreeNode root) {
    return root == null || isMirror(root.left, root.right);
}

private boolean isMirror(TreeNode a, TreeNode b) {
    if (a == null && b == null) return true;
    if (a == null || b == null) return false;
    return a.val == b.val &&
            isMirror(a.left, b.right) &&
            isMirror(a.right, b.left);
}
```

* **Time:** O(n)
* **Space:** O(h)

---

### **89. Path Sum**

```java
public boolean hasPathSum(TreeNode root, int targetSum) {
    if (root == null) return false;
    if (root.left == null && root.right == null)
        return root.val == targetSum;

    return hasPathSum(root.left, targetSum - root.val) ||
            hasPathSum(root.right, targetSum - root.val);
}
```

* **Time:** O(n)
* **Space:** O(h)

---

### **90. Lowest Common Ancestor (Binary Tree)**

```java
public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    if (root == null || root == p || root == q) return root;

    TreeNode left = lowestCommonAncestor(root.left, p, q);
    TreeNode right = lowestCommonAncestor(root.right, p, q);

    if (left != null && right != null) return root;
    return left != null ? left : right;
}
```

* **Time:** O(n)
* **Space:** O(h)

---
