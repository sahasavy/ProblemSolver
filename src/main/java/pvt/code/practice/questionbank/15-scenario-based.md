# TOPIC : Scenario Based

---

## 📘 Question Bank

---

## 1️⃣ Rate Limiting & Traffic Control

### Examples

1. **API Rate Limiter**

    * Limit requests per user per minute
    * Variants:

        * Fixed window
        * Sliding window
        * Token bucket
2. **Login Attempt Limiter**

    * Lock account after `N` failed attempts in `T` minutes
3. **IP-based Throttling**

    * Block abusive IPs dynamically

### What’s Being Tested

* HashMaps + timestamps
* Sliding window / queue logic
* Clean handling of time
* Edge cases (bursts, resets)

👉 Very common for backend roles.

---

## 2️⃣ Scheduling & Calendar Problems

### Examples

4. **Meeting Scheduler**

    * Find common free slots between two calendars
5. **Meeting Room Allocation**

    * Minimum number of rooms required
6. **Task Scheduler**

    * Schedule tasks with cooldown period
7. **CPU Job Scheduling**

    * Shortest job first / priority scheduling

### What’s Being Tested

* Sorting + greedy
* Heap / priority queue usage
* Interval overlap reasoning

👉 These appear *constantly* in interviews.

---

## 3️⃣ Media / Data Compression & Processing

### Examples

8. **Image Compression Logic**

    * Downscale resolution based on bandwidth
9. **Run-Length Encoding**

    * Compress strings like `"aaabb"`
10. **Log File Compression**

* Group repeated log messages

### What’s Being Tested

* String/array manipulation
* Tradeoffs (lossy vs lossless)
* Time & space optimization thinking

👉 You won’t write JPEG — they want *logical reasoning*.

---

## 4️⃣ Cache Design & Memory Management

### Examples

11. **LRU Cache**
12. **LFU Cache**
13. **In-Memory Key-Value Store**
14. **TTL Cache (expiry-based)**

### What’s Being Tested

* HashMap + LinkedList combo
* Eviction policies
* O(1) operations

👉 If you do only **one** scenario deeply — make it **LRU Cache**.

---

## 5️⃣ File System & Path Handling

### Examples

15. **Unix Path Normalizer**
16. **Directory Size Calculator**
17. **Find Duplicate Files**
18. **File Versioning System**

### What’s Being Tested

* Stack usage
* String parsing
* Tree-like thinking

---

## 6️⃣ Data Stream Processing

### Examples

19. **Moving Average from Stream**
20. **Top K Elements in a Stream**
21. **Median from Data Stream**
22. **Log Aggregator**

### What’s Being Tested

* Heaps
* Sliding window
* Incremental computation

👉 Often framed as “numbers are coming continuously…”

---

## 7️⃣ Search, Ranking & Recommendation

### Examples

23. **Search Auto-Complete**
24. **Trending Topics**
25. **Top Viewed Products**
26. **Search Result Ranking**

### What’s Being Tested

* Hashing + frequency counting
* Sorting + heaps
* Partial matching

---

## 8️⃣ Concurrency-Inspired (Single-Threaded Coding)

> They usually **don’t ask real multithreading**, but simulate logic.

### Examples

27. **Thread-safe Counter (conceptual)**
28. **Producer–Consumer Simulation**
29. **Request Queue Processor**
30. **Batch Job Executor**

### What’s Being Tested

* State consistency
* Queue discipline
* Clear separation of responsibilities

---

## 9️⃣ Validation & Rule Engines

### Examples

31. **Email / Password Validator**
32. **Form Input Validation Engine**
33. **Discount Rule Engine**
34. **Fraud Detection Rules**

### What’s Being Tested

* Clean condition handling
* Extensibility
* Defensive coding

---

## 🔟 Realistic Business Scenarios (Very Common)

### Examples

35. **Order Processing System**
36. **Inventory Management**
37. **Seat Booking System**
38. **Ticket Reservation**
39. **Bank Transaction Ledger**
40. **Expense Splitter (Splitwise-like)**

### What’s Being Tested

* Modeling real entities
* Clean class design
* Edge cases (partial failures)

👉 These often start vague on purpose.

---

```
```

---

# Scenario-Based Coding Problems (High-ROI Set)

---

## 📘 Question Bank

---

## **S1. API Rate Limiter (Fixed + Sliding Window)**

### Problem Statement

Design a rate limiter that allows **at most N requests per user per T seconds**.

You need to support:

* `boolean allowRequest(String userId, long timestamp)`

### Requirements

* Requests arrive with timestamps (seconds)
* Each user is tracked independently
* Efficient for large number of users

### Variants

* **Fixed Window**
* **Sliding Window**

### Examples

```
N = 3, T = 10 seconds

Requests at times:
t=1,2,3  -> allowed
t=4      -> rejected
t=11     -> allowed
```

### What Interviewer Is Testing

* Time-based logic
* HashMap + Queue
* Sliding window reasoning

---

## **S2. LRU Cache**

### Problem Statement

Design an **LRU (Least Recently Used) Cache** with the following operations in **O(1)** time:

* `get(key)`
* `put(key, value)`

When capacity is exceeded, remove the **least recently used** item.

### Examples

```
capacity = 2
put(1,1)
put(2,2)
get(1) -> 1
put(3,3) -> evicts key 2
```

### What Interviewer Is Testing

* HashMap + Doubly Linked List
* Data structure composition
* Clean class design

---

## **S3. Meeting Room Allocation**

### Problem Statement

Given meeting time intervals, return the **minimum number of meeting rooms** required.

### Examples

```
[[0,30],[5,10],[15,20]] -> 2
[[7,10],[2,4]] -> 1
```

### What Interviewer Is Testing

* Interval overlap
* Sorting + Min Heap
* Greedy thinking

---

## **S4. Task Scheduler with Cooldown**

### Problem Statement

Given tasks represented by characters and a cooldown `n`, return the **minimum time units** required to execute all
tasks.

### Examples

```
tasks = [A,A,A,B,B,B], n=2 -> 8
```

### What Interviewer Is Testing

* Frequency counting
* Greedy scheduling
* Idle time calculation

---

## **S5. Moving Average from Data Stream**

### Problem Statement

Design a class that calculates the **moving average of the last K elements** from a stream.

### Example

```
K = 3
add(1) -> 1
add(10) -> 5.5
add(3) -> 4.67
add(5) -> 6
```

### What Interviewer Is Testing

* Queue usage
* Incremental computation
* Space optimization

---

## **S6. Median from Data Stream**

### Problem Statement

Design a data structure that supports:

* `addNum(int num)`
* `findMedian()`

### Example

```
add(1), add(2) -> median = 1.5
add(3) -> median = 2
```

### What Interviewer Is Testing

* Two heaps strategy
* Balancing invariants
* Real-time statistics

---

## **S7. Log Aggregator**

### Problem Statement

Logs arrive in the format:

```
(timestamp, serviceName, logLevel)
```

Design a system that supports:

* Count logs per service
* Count logs per log level
* Query logs in time range

### What Interviewer Is Testing

* HashMap nesting
* Time-based grouping
* Query-friendly design

---

## **S8. Simple Order Processing System**

### Problem Statement

Design a system to process orders with:

* orderId
* userId
* amount
* status (CREATED, PAID, CANCELLED)

Support:

* Create order
* Pay order
* Cancel order
* Get total revenue

### What Interviewer Is Testing

* State transitions
* Business rules
* Defensive coding

---

---

# 🧠 Solutions

---

## **S1. Rate Limiter (Sliding Window)**

```java
class RateLimiter {
    private final int limit;
    private final int window;
    private Map<String, Deque<Long>> map = new HashMap<>();

    public RateLimiter(int limit, int window) {
        this.limit = limit;
        this.window = window;
    }

    public boolean allowRequest(String user, long time) {
        map.putIfAbsent(user, new ArrayDeque<>());
        Deque<Long> q = map.get(user);

        while (!q.isEmpty() && time - q.peekFirst() >= window) {
            q.pollFirst();
        }

        if (q.size() < limit) {
            q.addLast(time);
            return true;
        }
        return false;
    }
}
```

**Time:** O(1) amortized
**Space:** O(users × requests)

---

## **S2. LRU Cache**

```java
class LRUCache {
    class Node {
        int k, v;
        Node prev, next;

        Node(int k, int v) {
            this.k = k;
            this.v = v;
        }
    }

    private int cap;
    private Map<Integer, Node> map = new HashMap<>();
    private Node head = new Node(0, 0), tail = new Node(0, 0);

    public LRUCache(int capacity) {
        cap = capacity;
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (!map.containsKey(key)) return -1;
        Node n = map.get(key);
        remove(n);
        insert(n);
        return n.v;
    }

    public void put(int key, int val) {
        if (map.containsKey(key)) remove(map.get(key));
        if (map.size() == cap) remove(tail.prev);

        Node n = new Node(key, val);
        insert(n);
        map.put(key, n);
    }

    private void remove(Node n) {
        map.remove(n.k);
        n.prev.next = n.next;
        n.next.prev = n.prev;
    }

    private void insert(Node n) {
        map.put(n.k, n);
        n.next = head.next;
        head.next.prev = n;
        head.next = n;
        n.prev = head;
    }
}
```

---

## **S3. Meeting Room Allocation**

```java
public int minMeetingRooms(int[][] intervals) {
    Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
    PriorityQueue<Integer> pq = new PriorityQueue<>();

    for (int[] i : intervals) {
        if (!pq.isEmpty() && pq.peek() <= i[0]) pq.poll();
        pq.offer(i[1]);
    }
    return pq.size();
}
```

---

## **S4. Task Scheduler**

```java
public int leastInterval(char[] tasks, int n) {
    int[] freq = new int[26];
    for (char c : tasks) freq[c - 'A']++;

    Arrays.sort(freq);
    int max = freq[25] - 1;
    int idle = max * n;

    for (int i = 24; i >= 0 && freq[i] > 0; i--) {
        idle -= Math.min(max, freq[i]);
    }
    return idle > 0 ? idle + tasks.length : tasks.length;
}
```

---

## **S5. Moving Average**

```java
class MovingAverage {
    Queue<Integer> q = new LinkedList<>();
    int sum = 0, size;

    public MovingAverage(int k) {
        size = k;
    }

    public double next(int val) {
        q.offer(val);
        sum += val;
        if (q.size() > size) sum -= q.poll();
        return (double) sum / q.size();
    }
}
```

---

## **S6. Median from Data Stream**

```java
class MedianFinder {
    PriorityQueue<Integer> low = new PriorityQueue<>(Collections.reverseOrder());
    PriorityQueue<Integer> high = new PriorityQueue<>();

    public void addNum(int num) {
        low.offer(num);
        high.offer(low.poll());
        if (high.size() > low.size()) low.offer(high.poll());
    }

    public double findMedian() {
        return low.size() > high.size()
                ? low.peek()
                : (low.peek() + high.peek()) / 2.0;
    }
}
```

---

## **S7. Log Aggregator**

```java
class LogAggregator {
    Map<String, Integer> serviceCount = new HashMap<>();
    Map<String, Integer> levelCount = new HashMap<>();

    public void addLog(String service, String level) {
        serviceCount.put(service, serviceCount.getOrDefault(service, 0) + 1);
        levelCount.put(level, levelCount.getOrDefault(level, 0) + 1);
    }
}
```

---

## **S8. Order Processing System**

```java
class Order {
    enum Status {CREATED, PAID, CANCELLED}

    int id;
    double amount;
    Status status = Status.CREATED;
}

class OrderService {
    Map<Integer, Order> orders = new HashMap<>();
    double revenue = 0;

    public void create(Order o) {
        orders.put(o.id, o);
    }

    public void pay(int id) {
        Order o = orders.get(id);
        if (o != null && o.status == Order.Status.CREATED) {
            o.status = Order.Status.PAID;
            revenue += o.amount;
        }
    }

    public double totalRevenue() {
        return revenue;
    }
}
```

---
