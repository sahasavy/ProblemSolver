# 📚 Java Question Bank – Contents

1. [Topic 1: Java Fundamentals & Language Basics](#-topic-1-java-fundamentals--language-basics)
2. [Topic 2: Object-Oriented Programming (OOP)](#-topic-2-object-oriented-programming-oop-in-java)
3. [Topic 3: Java Memory Model (JMM) & JVM Internals](#-topic-3-java-memory-model-jmm--jvm-internals)
4. [Topic 4: Garbage Collection (GC) & Performance](#-topic-4-garbage-collection-gc--performance-in-java)
5. [Topic 5: Exception Handling](#-topic-5-exception-handling-in-java)
6. [Topic 6: Java Collections Framework](#-topic-6-java-collections-framework)
7. [Topic 7: Concurrency & Multithreading](#-topic-7-concurrency--multithreading-in-java)
8. [Topic 8: Java 8+ Features (Modern Java)](#-topic-8-java-8-features-modern-java)
9. [Topic 9: Serialization & Deserialization](#-topic-9-serialization--deserialization-in-java)
10. [Topic 10: Reflection, Annotations & Proxies](#-topic-10-reflection-annotations--proxies-in-java)
11. [Topic 11: Design Patterns (Java-centric)](#-topic-11-design-patterns-in-java-gof--real-world-usage)
12. [Topic 12: Java I/O & NIO](#-topic-12-java-io--nio)
13. [Topic 13: Security & Best Practices](#-topic-13-security--best-practices-in-java)
14. [Topic 14: JVM, Java & System Design Intersections](#-topic-14-jvm-java--system-design-intersections)
15. [Topic 15: Tricky / Brain-Teaser Java Questions](#-topic-15-tricky--brain-teaser-java-questions-interview-traps)

---

# 📘 Topic 1: Java Fundamentals & Language Basics

---

## 🟢 EASY QUESTIONS

---

### Q1. What is the difference between JDK, JRE, and JVM?

#### 📘 Answer

Think of them as **nested layers**:

```
JDK
 └── JRE
      └── JVM
```

| Component                          | Purpose                    |
|------------------------------------|----------------------------|
| **JVM (Java Virtual Machine)**     | Executes Java bytecode     |
| **JRE (Java Runtime Environment)** | JVM + core libraries       |
| **JDK (Java Development Kit)**     | JRE + compiler + dev tools |

**Execution flow:**

1. `javac` compiles `.java` → `.class` (bytecode)
2. JVM loads bytecode
3. Bytecode is interpreted / JIT-compiled
4. OS-specific machine code runs

---

#### ⚠️ Tricky Follow-up

**Can Java run without JRE?**

✅ **Answer:**
No. Java programs *require* a runtime environment. However, since **Java 9**, JRE is no longer distributed separately —
it’s bundled inside the JDK.

---

### Q2. Explain the Java compilation and execution process.

#### 📘 Answer

```
.java  →  javac  →  .class (bytecode)
                     ↓
              Class Loader
                     ↓
              Bytecode Verifier
                     ↓
            Interpreter / JIT
                     ↓
               Machine Code
```

**Key stages:**

* **Compilation**: Platform-independent bytecode
* **Class Loading**: Loads classes on demand
* **Verification**: Ensures safety
* **Execution**: Interpreter + JIT (HotSpot)

---

#### ⚠️ Tricky Follow-up

**Is Java truly interpreted or compiled?**

✅ **Answer:**
Both. Java is:

* **Compiled** to bytecode
* **Interpreted initially**
* **JIT-compiled** for hot code paths

---

### Q3. Why is Java platform-independent?

#### 📘 Answer

Java compiles to **bytecode**, not native machine code.

```
Java Code → Bytecode → JVM (OS-specific)
```

Each OS has its own JVM that understands the same bytecode.

---

#### ⚠️ Tricky Follow-up

**Is bytecode truly platform-independent?**

✅ **Answer:**
Yes, *but* JVM implementations are platform-specific.

---

### Q4. What is the `main` method signature and why is it `static`?

```java
public static void main(String[] args)
```

#### 📘 Answer

* `public`: JVM must access it
* `static`: JVM doesn’t create an object
* `void`: JVM doesn’t expect a return value
* `String[] args`: command-line arguments

---

#### ⚠️ Tricky Follow-ups

1. **Can we overload `main()`?**
2. **Can `main()` be non-static?**

✅ **Answers:**

1. Yes, but JVM only calls the exact signature
2. No — JVM can’t instantiate the class

---

### Q5. Is Java pass-by-value or pass-by-reference?

#### 📘 Answer

👉 **Java is always pass-by-value**

* For primitives → value copied
* For objects → **reference value copied**

```java
void change(Person p) {
    p.name = "X";      // affects original object
    p = new Person();  // does NOT affect caller
}
```

---

#### ⚠️ Tricky Follow-up

**Why does it look like pass-by-reference then?**

✅ **Answer:**
Because the reference itself is passed by value.

---

## 🟡 MEDIUM QUESTIONS

---

### Q6. Difference between primitive and reference types?

#### 📘 Answer

| Aspect        | Primitive | Reference |
|---------------|-----------|-----------|
| Storage       | Stack     | Heap      |
| Null allowed  | ❌         | ✅         |
| Default value | 0 / false | null      |
| Performance   | Faster    | Slower    |

---

#### ⚠️ Tricky Follow-up

**Where are objects actually stored?**

✅ **Answer:**
Objects → Heap
References → Stack

---

### Q7. Explain `==` vs `equals()`

#### 📘 Answer

* `==` → compares references (memory address)
* `equals()` → compares content (if overridden)

```java
String a = new String("x");
String b = new String("x");

a ==b        // false
a.

equals(b)   // true
```

---

#### ⚠️ Tricky Follow-up

**Why override `hashCode()` when overriding `equals()`?**

✅ **Answer:**
Because Hash-based collections depend on both.

---

### Q8. Explain `static` keyword in Java.

#### 📘 Answer

* Belongs to **class**, not object
* Shared across instances
* Loaded during class loading

```java
static {
    // static block
}
```

---

#### ⚠️ Tricky Follow-up

**Can static methods access instance variables?**

✅ **Answer:**
No — no object context exists.

---

### Q9. Explain `final` keyword in Java.

#### 📘 Answer

| Usage          | Meaning         |
|----------------|-----------------|
| final variable | Cannot reassign |
| final method   | Cannot override |
| final class    | Cannot extend   |

---

#### ⚠️ Tricky Follow-up

**Is a final object immutable?**

✅ **Answer:**
No — reference is final, object may mutate.

---

### Q10. Difference between `this` and `super`

#### 📘 Answer

* `this` → current class
* `super` → parent class

Used for:

* Constructor chaining
* Method/field disambiguation

---

#### ⚠️ Tricky Follow-up

**Can `this()` and `super()` be used together?**

✅ **Answer:**
No — both must be the first statement.

---

## 🔴 HARD / TRICKY QUESTIONS

---

### Q11. Explain Wrapper Classes and Autoboxing.

#### 📘 Answer

```java
int a = 10;
Integer b = a;     // autoboxing
int c = b;         // unboxing
```

Used in:

* Collections
* Generics

---

#### ⚠️ Tricky Follow-up

```java
Integer a = 100;
Integer b = 100;
a ==b // ?
```

✅ **Answer:**
`true` (cached range -128 to 127)

```java
Integer a = 200;
Integer b = 200;
a ==b // false
```

---

### Q12. Explain String Pool and String immutability.

#### 📘 Answer

```java
String a = "abc";
String b = "abc"; // same reference
```

```java
String c = new String("abc"); // new object
```

**Why immutable?**

* Thread safety
* Security
* String pool optimization

---

#### ⚠️ Tricky Follow-up

**How many objects are created here?**

```java
String s = new String("abc");
```

✅ **Answer:**
2 objects (literal + heap)

---

### Q13. Access modifiers and their scope?

| Modifier  | Same Class | Same Package | Subclass | Outside |
|-----------|------------|--------------|----------|---------|
| private   | ✅          | ❌            | ❌        | ❌       |
| default   | ✅          | ✅            | ❌        | ❌       |
| protected | ✅          | ✅            | ✅        | ❌       |
| public    | ✅          | ✅            | ✅        | ✅       |

---

#### ⚠️ Tricky Follow-up

**Is protected accessible outside package without inheritance?**

✅ **Answer:**
No.

---

### Q14. Can we change the return type while overriding?

#### 📘 Answer

Yes, **covariant return types** allowed.

```java
Parent get();

Child get(); // valid
```

---

#### ⚠️ Tricky Follow-up

**What about primitives?**

✅ **Answer:**
Not allowed.

---

### Q15. Why does Java not support multiple inheritance?

#### 📘 Answer

To avoid **Diamond Problem**:

```
    A
   / \
  B   C
   \ /
    D
```

Java uses:

* Interfaces
* Default methods (resolved explicitly)

---

#### ⚠️ Tricky Follow-up

**How does Java resolve default method conflict?**

✅ **Answer:**
Implementing class must override explicitly.

---

## ✅ End of Topic 1

---

[⬆ Back to Contents](#-java-question-bank--contents)

---

# 📘 Topic 2: Object-Oriented Programming (OOP) in Java

---

## 🟢 EASY QUESTIONS

---

### Q1. What are the four pillars of Object-Oriented Programming?

#### 📘 Answer

The four pillars are:

1. **Encapsulation**
2. **Inheritance**
3. **Polymorphism**
4. **Abstraction**

| Pillar        | Purpose                       |
|---------------|-------------------------------|
| Encapsulation | Data hiding & control         |
| Inheritance   | Code reuse                    |
| Polymorphism  | One interface, many behaviors |
| Abstraction   | Hide implementation details   |

OOP helps in building **modular, maintainable, and scalable systems**.

---

#### ⚠️ Tricky Follow-up

**Is Java 100% object-oriented?**

✅ **Answer:**
No. Java uses primitives (`int`, `boolean`, etc.), so it’s not 100% OO.

---

### Q2. Explain Encapsulation with an example.

#### 📘 Answer

Encapsulation = **binding data + behavior** and **restricting access**.

```java
class Account {
    private double balance;

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) balance += amount;
    }
}
```

**Benefits:**

* Prevents invalid states
* Improves maintainability
* Enables future changes without breaking callers

---

#### ⚠️ Tricky Follow-up

**Is using getters/setters always good encapsulation?**

✅ **Answer:**
No. Blind getters/setters can break encapsulation. Behavior-driven methods are better.

---

### Q3. What is Inheritance?

#### 📘 Answer

Inheritance allows a class to **reuse and extend** another class.

```java
class Vehicle {
    void move() {
    }
}

class Car extends Vehicle {
    void playMusic() {
    }
}
```

* `Car` **is-a** `Vehicle`
* Achieved using `extends`

---

#### ⚠️ Tricky Follow-up

**Can a class extend multiple classes in Java?**

✅ **Answer:**
No — Java does not support multiple inheritance of classes.

---

### Q4. What is Polymorphism?

#### 📘 Answer

Polymorphism means **same method call, different behavior**.

Types:

* **Compile-time** → Method overloading
* **Runtime** → Method overriding

```java
Vehicle v = new Car();
v.

move(); // calls Car's implementation
```

---

#### ⚠️ Tricky Follow-up

**Is method overloading polymorphism?**

✅ **Answer:**
Yes, but it’s compile-time polymorphism.

---

### Q5. What is Abstraction?

#### 📘 Answer

Abstraction hides **how** something works and exposes **what** it does.

Achieved using:

* Abstract classes
* Interfaces

```java
interface Payment {
    void pay();
}
```

---

#### ⚠️ Tricky Follow-up

**Can abstraction exist without encapsulation?**

✅ **Answer:**
No. Abstraction relies on encapsulation.

---

## 🟡 MEDIUM QUESTIONS

---

### Q6. Abstract Class vs Interface

#### 📘 Answer

| Aspect               | Abstract Class     | Interface      |
|----------------------|--------------------|----------------|
| Multiple inheritance | ❌                  | ✅              |
| Fields               | Instance variables | Constants only |
| Constructors         | ✅                  | ❌              |
| Default methods      | ✅                  | ✅ (Java 8+)    |

Use:

* Abstract class → **is-a relationship with shared state**
* Interface → **capability / contract**

---

#### ⚠️ Tricky Follow-up

**Why were default methods added to interfaces?**

✅ **Answer:**
To support backward compatibility (Java 8 streams).

---

### Q7. Method Overloading vs Overriding

#### 📘 Answer

| Aspect          | Overloading | Overriding |
|-----------------|-------------|------------|
| Same class      | ✅           | ❌          |
| Same signature  | ❌           | ✅          |
| Runtime binding | ❌           | ✅          |

---

#### ⚠️ Tricky Follow-up

**Can return type alone distinguish overloaded methods?**

✅ **Answer:**
No.

---

### Q8. Rules for Method Overriding

#### 📘 Answer

Key rules:

* Same method signature
* Access level cannot be reduced
* Return type can be covariant
* Cannot override `final` methods
* Static methods are hidden, not overridden

---

#### ⚠️ Tricky Follow-up

**Can private methods be overridden?**

✅ **Answer:**
No — they are not inherited.

---

### Q9. What is Method Hiding?

#### 📘 Answer

Static methods are **hidden**, not overridden.

```java
class A {
    static void show() {
    }
}

class B extends A {
    static void show() {
    }
}
```

Method call depends on **reference type**, not object.

---

#### ⚠️ Tricky Follow-up

**Is this polymorphism?**

✅ **Answer:**
No — polymorphism applies only to instance methods.

---

### Q10. What are Marker Interfaces?

#### 📘 Answer

Marker interfaces have **no methods**.

Examples:

* `Serializable`
* `Cloneable`
* `RandomAccess`

Used to **signal behavior to JVM/frameworks**.

---

#### ⚠️ Tricky Follow-up

**Why not use annotations instead?**

✅ **Answer:**
Annotations are preferred now, but marker interfaces allow `instanceof` checks.

---

## 🔴 HARD / SENIOR-LEVEL QUESTIONS

---

### Q11. Composition vs Inheritance — which is better?

#### 📘 Answer

**Composition is preferred over inheritance**.

```java
class Engine {
}

class Car {
    private Engine engine;
}
```

**Why composition wins:**

* Loose coupling
* Better testability
* Avoids fragile base class problem

---

#### ⚠️ Tricky Follow-up

**When should inheritance be used?**

✅ **Answer:**
Only when a true **is-a** relationship exists.

---

### Q12. Explain the Diamond Problem and how Java solves it.

#### 📘 Answer

Java avoids diamond problem by:

* Disallowing multiple class inheritance
* For interfaces:

    * Explicit override required if conflict exists

```java
class X implements A, B {
    public void show() {
        A.super.show();
    }
}
```

---

#### ⚠️ Tricky Follow-up

**Which default method wins automatically?**

✅ **Answer:**
None — compiler forces resolution.

---

### Q13. What is an Immutable Class? How do you design one?

#### 📘 Answer

Characteristics:

* Class is `final`
* Fields are `private final`
* No setters
* Defensive copying

```java
final class User {
    private final String name;

    public User(String name) {
        this.name = name;
    }
}
```

---

#### ⚠️ Tricky Follow-up

**Why is immutability important in concurrency?**

✅ **Answer:**
Immutable objects are thread-safe by design.

---

### Q14. Explain `instanceof` and its pitfalls.

#### 📘 Answer

```java
if(obj instanceof String){}
```

Pitfalls:

* Violates OCP
* Indicates bad design
* Breaks polymorphism

---

#### ⚠️ Tricky Follow-up

**What’s a better alternative?**

✅ **Answer:**
Use polymorphism or visitor pattern.

---

### Q15. Can constructors be overridden?

#### 📘 Answer

No. Constructors are:

* Not inherited
* Can be overloaded
* Can call parent constructor using `super()`

---

#### ⚠️ Tricky Follow-up

**Why can constructors not be overridden?**

✅ **Answer:**
Because constructors initialize objects, not behavior.

---

## ✅ End of Topic 2

---

[⬆ Back to Contents](#-java-question-bank--contents)

---

# 📘 Topic 3: Java Memory Model (JMM) & JVM Internals

---

## 🟢 EASY QUESTIONS

---

### Q1. What is the JVM and what are its main responsibilities?

#### 📘 Answer

**JVM (Java Virtual Machine)** is responsible for:

* Loading classes
* Managing memory
* Executing bytecode
* Garbage collection
* Security & verification

High-level JVM flow:

```
.class file
   ↓
Class Loader
   ↓
Bytecode Verifier
   ↓
Execution Engine (Interpreter + JIT)
   ↓
OS / Hardware
```

---

#### ⚠️ Tricky Follow-up

**Is JVM the same across all platforms?**

✅ **Answer:**
No. JVM implementations are platform-specific, but they all follow the same JVM specification.

---

### Q2. What are the main runtime memory areas of JVM?

#### 📘 Answer

JVM memory is divided into:

```
┌─────────────────────────┐
│        Heap             │
├─────────────────────────┤
│        Stack            │
├─────────────────────────┤
│        Metaspace        │
├─────────────────────────┤
│     PC Register         │
├─────────────────────────┤
│ Native Method Stack     │
└─────────────────────────┘
```

| Area         | Purpose                   |
|--------------|---------------------------|
| Heap         | Objects & class instances |
| Stack        | Method calls & local vars |
| Metaspace    | Class metadata            |
| PC Register  | Current instruction       |
| Native Stack | JNI calls                 |

---

#### ⚠️ Tricky Follow-up

**Is stack memory shared across threads?**

✅ **Answer:**
No. Each thread has its own stack.

---

### Q3. What is the Java Stack and what does it store?

#### 📘 Answer

Each thread gets a **private stack**.

Stack frame contains:

* Local variables
* Method parameters
* Operand stack
* Return address

```
Thread
 └── Stack
     ├── Frame (method A)
     ├── Frame (method B)
```

---

#### ⚠️ Tricky Follow-up

**What causes `StackOverflowError`?**

✅ **Answer:**
Deep or infinite recursion causing stack frames to exceed stack size.

---

### Q4. What is the Heap and what is stored there?

#### 📘 Answer

Heap stores:

* Objects
* Instance variables
* Arrays

Characteristics:

* Shared across threads
* Managed by Garbage Collector

---

#### ⚠️ Tricky Follow-up

**Can primitives be stored in heap?**

✅ **Answer:**
Yes — if they are part of an object.

---

## 🟡 MEDIUM QUESTIONS

---

### Q5. Explain Young Generation and Old Generation.

#### 📘 Answer

Heap is divided into generations:

```
Heap
 ├── Young Gen
 │    ├── Eden
 │    ├── Survivor S0
 │    └── Survivor S1
 └── Old Gen
```

* New objects → Eden
* Minor GC → survivor spaces
* Long-living objects → Old Gen

---

#### ⚠️ Tricky Follow-up

**Why generational GC works well?**

✅ **Answer:**
Most objects die young (weak generational hypothesis).

---

### Q6. What is Metaspace? How is it different from PermGen?

#### 📘 Answer

* Stores class metadata
* Introduced in Java 8
* Uses native memory

| PermGen           | Metaspace     |
|-------------------|---------------|
| Fixed size        | Dynamic       |
| Heap memory       | Native memory |
| OOM errors common | Fewer OOMs    |

---

#### ⚠️ Tricky Follow-up

**Can Metaspace still cause OOM?**

✅ **Answer:**
Yes — `OutOfMemoryError: Metaspace`.

---

### Q7. Explain Object Creation Process in Java.

#### 📘 Answer

Steps:

1. Class loading
2. Memory allocation
3. Zero initialization
4. Constructor execution
5. Reference assignment

```
new Object()
  ↓
Heap allocation
  ↓
Constructor
```

---

#### ⚠️ Tricky Follow-up

**Where is the reference stored?**

✅ **Answer:**
In stack (or CPU register).

---

### Q8. What is Escape Analysis?

#### 📘 Answer

JVM checks if an object:

* Escapes method
* Escapes thread

If not:

* Allocate on stack
* Eliminate synchronization

---

#### ⚠️ Tricky Follow-up

**Is stack allocation guaranteed?**

✅ **Answer:**
No — JVM optimization dependent.

---

### Q9. What is the String Pool?

#### 📘 Answer

String literals are stored in **String Pool** (heap).

```java
String a = "abc";
String b = "abc"; // same object
```

Benefits:

* Memory optimization
* Fast equality checks

---

#### ⚠️ Tricky Follow-up

**Where is String Pool located now?**

✅ **Answer:**
Heap (since Java 7).

---

## 🔴 HARD / SENIOR-LEVEL QUESTIONS

---

### Q10. Explain ClassLoader hierarchy.

#### 📘 Answer

```
Bootstrap ClassLoader
        ↓
Extension ClassLoader
        ↓
Application ClassLoader
```

* Bootstrap → core Java classes
* Extension → JDK extensions
* Application → classpath classes

---

#### ⚠️ Tricky Follow-up

**Can you create a custom ClassLoader?**

✅ **Answer:**
Yes — extend `ClassLoader`.

---

### Q11. What is the Java Memory Model (JMM)?

#### 📘 Answer

JMM defines:

* Visibility
* Ordering
* Atomicity

Between:

* Threads
* Main memory
* CPU caches

---

#### ⚠️ Tricky Follow-up

**Is JMM about JVM memory layout?**

✅ **Answer:**
No — it’s about concurrency semantics.

---

### Q12. Explain `volatile` keyword in detail.

#### 📘 Answer

`volatile` guarantees:

* Visibility
* Ordering

Does NOT guarantee:

* Atomicity (except for 64-bit reads/writes)

```
Thread A → writes volatile
Thread B → reads latest value
```

---

#### ⚠️ Tricky Follow-up

**Why is double-checked locking broken without volatile?**

✅ **Answer:**
Instruction reordering can expose partially constructed objects.

---

### Q13. What is Happens-Before relationship?

#### 📘 Answer

Defines **memory visibility guarantees**.

Examples:

* Program order
* Monitor lock/unlock
* Volatile write → read
* Thread start/join

---

#### ⚠️ Tricky Follow-up

**Does happens-before imply execution order?**

✅ **Answer:**
No — it implies visibility, not scheduling.

---

### Q14. Difference between `OutOfMemoryError` and `StackOverflowError`?

#### 📘 Answer

| Error | Cause                     |
|-------|---------------------------|
| OOM   | Heap/Metaspace exhaustion |
| SOE   | Stack exhaustion          |

---

#### ⚠️ Tricky Follow-up

**Can OOM occur without memory leak?**

✅ **Answer:**
Yes — insufficient heap or large allocation.

---

### Q15. Can Java have memory leaks?

#### 📘 Answer

Yes — logical leaks.

Examples:

* Static references
* Unclosed listeners
* Cache without eviction

---

#### ⚠️ Tricky Follow-up

**Is GC responsible for preventing memory leaks?**

✅ **Answer:**
No — GC only frees unreachable objects.

---

## ✅ End of Topic 3

---

[⬆ Back to Contents](#-java-question-bank--contents)

---

# 📘 Topic 4: Garbage Collection (GC) & Performance in Java

---

## 🟢 EASY QUESTIONS

---

### Q1. What is Garbage Collection in Java?

#### 📘 Answer

Garbage Collection (GC) is the **automatic memory management** process in Java where:

* Unreachable objects are identified
* Their memory is reclaimed

Key idea:

> **GC removes objects that are no longer reachable, not unused variables**

---

#### ⚠️ Tricky Follow-up

**Does GC guarantee immediate memory release?**

✅ **Answer:**
No. GC runs based on JVM heuristics, not deterministically.

---

### Q2. What makes an object eligible for Garbage Collection?

#### 📘 Answer

An object is eligible when **no live thread can reach it**.

Examples:

```java
obj =null;
```

```java
method() {
    Object o = new Object(); // eligible after method exits
}
```

---

#### ⚠️ Tricky Follow-up

**Is setting reference to null mandatory?**

✅ **Answer:**
No — GC tracks reachability, not variable values.

---

### Q3. What is Stop-The-World (STW)?

#### 📘 Answer

STW pauses:

* **All application threads**
* Except GC threads

Used to:

* Ensure heap consistency
* Perform marking/compaction

---

#### ⚠️ Tricky Follow-up

**Can STW pauses be completely avoided?**

✅ **Answer:**
No — but modern GCs (G1, ZGC) minimize them.

---

## 🟡 MEDIUM QUESTIONS

---

### Q4. Explain Minor GC, Major GC, and Full GC.

#### 📘 Answer

| GC Type  | Area                    |
|----------|-------------------------|
| Minor GC | Young Generation        |
| Major GC | Old Generation          |
| Full GC  | Entire Heap + Metaspace |

Flow:

```
Eden full → Minor GC
Old Gen full → Major / Full GC
```

---

#### ⚠️ Tricky Follow-up

**Is Major GC always Full GC?**

✅ **Answer:**
Not necessarily — depends on GC algorithm.

---

### Q5. Explain Young Generation memory layout.

#### 📘 Answer

```
Young Gen
 ├── Eden
 ├── Survivor S0
 └── Survivor S1
```

Process:

1. Objects allocated in Eden
2. Minor GC moves survivors
3. Objects age & promote

---

#### ⚠️ Tricky Follow-up

**Why two survivor spaces?**

✅ **Answer:**
To avoid fragmentation during copying.

---

### Q6. What is Object Promotion?

#### 📘 Answer

Objects are promoted to Old Gen when:

* They survive multiple Minor GCs
* Survivor space is insufficient

Controlled by:

* Object age
* Survivor space capacity

---

#### ⚠️ Tricky Follow-up

**What is premature promotion?**

✅ **Answer:**
Large objects promoted early, increasing Old Gen pressure.

---

### Q7. Explain GC Roots.

#### 📘 Answer

GC Roots include:

* Thread stacks
* Static variables
* JNI references

Reachability graph starts from GC Roots.

---

#### ⚠️ Tricky Follow-up

**Are local variables always GC Roots?**

✅ **Answer:**
Only if still in scope and referenced.

---

## 🔴 HARD / SENIOR-LEVEL QUESTIONS

---

### Q8. Explain different GC algorithms.

#### 📘 Answer

| GC       | Characteristics          |
|----------|--------------------------|
| Serial   | Single-threaded, simple  |
| Parallel | Throughput-focused       |
| CMS      | Low-latency (deprecated) |
| G1       | Balanced, region-based   |
| ZGC      | Ultra-low latency        |

---

#### ⚠️ Tricky Follow-up

**Which GC is default today?**

✅ **Answer:**
G1 GC (Java 9+).

---

### Q9. Explain G1 GC in detail.

#### 📘 Answer

Key ideas:

* Heap divided into **regions**
* No fixed young/old layout
* Predictable pause times

```
Heap → Regions → Selected regions GC
```

Advantages:

* Mixed collections
* Compaction by default
* Predictable latency

---

#### ⚠️ Tricky Follow-up

**Does G1 eliminate Full GC?**

✅ **Answer:**
No — but reduces frequency significantly.

---

### Q10. What is Concurrent Marking?

#### 📘 Answer

Marking reachable objects **while application runs**.

Phases:

1. Initial Mark (STW)
2. Concurrent Mark
3. Remark (STW)
4. Cleanup

---

#### ⚠️ Tricky Follow-up

**Why still need STW phases?**

✅ **Answer:**
To capture state changes during concurrent marking.

---

### Q11. What is GC Tuning? Should developers tune GC?

#### 📘 Answer

GC tuning involves:

* Heap sizing
* Pause time goals
* Throughput trade-offs

Senior rule:

> **Fix allocation patterns first, tune GC later**

---

#### ⚠️ Tricky Follow-up

**Name a few GC flags.**

✅ **Answer (conceptual):**

* `-Xms`, `-Xmx`
* `-XX:MaxGCPauseMillis`
* `-XX:+UseG1GC`

---

### Q12. How do you identify GC-related performance issues?

#### 📘 Answer

Signals:

* High latency spikes
* Increased Full GC frequency
* CPU spikes during GC

Tools:

* GC logs
* JVisualVM
* Flight Recorder

---

#### ⚠️ Tricky Follow-up

**Can GC cause CPU saturation?**

✅ **Answer:**
Yes — especially with Parallel GC.

---

### Q13. Explain Memory Leaks in Java.

#### 📘 Answer

Java leaks are **logical leaks**, not missing deallocation.

Common causes:

* Static references
* ThreadLocals misuse
* Listeners not removed
* Caches without eviction

---

#### ⚠️ Tricky Follow-up

**Does GC clean leaked memory?**

✅ **Answer:**
No — leaked objects are still reachable.

---

### Q14. What is Allocation Rate and why does it matter?

#### 📘 Answer

Allocation rate = objects created per second.

High allocation rate:

* More Minor GCs
* Increased CPU usage
* Latency spikes

---

#### ⚠️ Tricky Follow-up

**How to reduce allocation rate?**

✅ **Answer:**

* Object reuse
* Avoid unnecessary boxing
* Stream/lambda caution

---

### Q15. Can GC tuning fix bad application design?

#### 📘 Answer

❌ No.

GC tuning can:

* Mask symptoms
* Reduce pauses

But:

> **Bad object lifecycle design will always resurface**

---

#### ⚠️ Tricky Follow-up

**What should be fixed first: GC or code?**

✅ **Answer:**
Code and allocation patterns first.

---

## ✅ End of Topic 4

---

[⬆ Back to Contents](#-java-question-bank--contents)

---

# 📘 Topic 5: Exception Handling in Java

---

## 🟢 EASY QUESTIONS

---

### Q1. What is an Exception in Java?

#### 📘 Answer

An **exception** is an event that disrupts the normal flow of program execution.

Java exceptions:

* Are objects
* Belong to `java.lang.Throwable` hierarchy
* Represent **abnormal conditions**

```
Throwable
 ├── Error
 └── Exception
```

---

#### ⚠️ Tricky Follow-up

**Is an exception always an error?**

✅ **Answer:**
No. Exceptions represent recoverable conditions; `Error`s usually don’t.

---

### Q2. Difference between `Error` and `Exception`?

#### 📘 Answer

| Aspect      | Error              | Exception   |
|-------------|--------------------|-------------|
| Recoverable | ❌                  | ✅           |
| Checked     | ❌                  | Some        |
| Examples    | OOM, StackOverflow | IOException |

---

#### ⚠️ Tricky Follow-up

**Should applications catch `Error`?**

✅ **Answer:**
No. Errors indicate JVM-level failures.

---

### Q3. What are Checked and Unchecked Exceptions?

#### 📘 Answer

| Type               | Checked     | Unchecked            |
|--------------------|-------------|----------------------|
| Compile-time check | ✅           | ❌                    |
| Base class         | `Exception` | `RuntimeException`   |
| Examples           | IOException | NullPointerException |

---

#### ⚠️ Tricky Follow-up

**Why does Java have checked exceptions?**

✅ **Answer:**
To force explicit handling of recoverable failures.

---

### Q4. What is `try-catch-finally`?

#### 📘 Answer

```java
try{
riskyCode();
}catch(
Exception e){

handle();
}finally{

cleanup();
}
```

* `try` → risky code
* `catch` → handling
* `finally` → always executes

---

#### ⚠️ Tricky Follow-up

**Does finally always execute?**

✅ **Answer:**
Almost always — except `System.exit()` or JVM crash.

---

## 🟡 MEDIUM QUESTIONS

---

### Q5. Can `finally` override a return statement?

#### 📘 Answer

Yes.

```java
int test() {
    try {
        return 1;
    } finally {
        return 2;
    }
}
```

**Returns:** `2`

---

#### ⚠️ Tricky Follow-up

**Is this a good practice?**

✅ **Answer:**
No — it hides logic and causes bugs.

---

### Q6. Explain Multiple Catch Blocks and Ordering.

#### 📘 Answer

```java
try{
        }catch(IOException e){
        }catch(
Exception e){
        }
```

Rules:

* Most specific first
* Parent last
* Otherwise → compile-time error

---

#### ⚠️ Tricky Follow-up

**Can we catch multiple exceptions in one catch?**

✅ **Answer:**
Yes (Java 7+):

```java
catch(IOException |
SQLException e){}
```

---

### Q7. What is Try-With-Resources?

#### 📘 Answer

Automatically closes resources implementing `AutoCloseable`.

```java
try(BufferedReader br = new BufferedReader(...)){
        }
```

* Eliminates boilerplate
* Prevents resource leaks

---

#### ⚠️ Tricky Follow-up

**What if both try and close throw exceptions?**

✅ **Answer:**
Close exception becomes **suppressed**.

---

### Q8. What are Suppressed Exceptions?

#### 📘 Answer

Exceptions thrown during resource closing are **suppressed**.

Accessed via:

```java
Throwable.getSuppressed()
```

---

#### ⚠️ Tricky Follow-up

**Why suppress instead of replace?**

✅ **Answer:**
Primary exception contains root cause.

---

### Q9. How does Exception propagation work?

#### 📘 Answer

If not caught:

* Exception bubbles up the call stack
* Until caught or JVM terminates

```
methodA → methodB → methodC → exception
```

---

#### ⚠️ Tricky Follow-up

**Does propagation stop at checked exceptions?**

✅ **Answer:**
No — both propagate unless caught.

---

## 🔴 HARD / SENIOR-LEVEL QUESTIONS

---

### Q10. How should custom exceptions be designed?

#### 📘 Answer

Best practices:

* Extend `RuntimeException` for business logic
* Meaningful names
* Preserve root cause

```java
throw new OrderFailedException("msg",cause);
```

---

#### ⚠️ Tricky Follow-up

**When should custom exceptions be checked?**

✅ **Answer:**
Rarely — only for truly recoverable flows.

---

### Q11. Checked vs Unchecked — which is better?

#### 📘 Answer

Modern Java prefers **unchecked exceptions** because:

* Cleaner APIs
* Better layering
* Easier refactoring

---

#### ⚠️ Tricky Follow-up

**Why did Java originally introduce checked exceptions?**

✅ **Answer:**
To enforce error handling discipline.

---

### Q12. What is Exception Masking?

#### 📘 Answer

Original exception hidden by another exception.

```java
catch(Exception e){
        throw new

RuntimeException();
}
```

---

#### ⚠️ Tricky Follow-up

**How to avoid masking?**

✅ **Answer:**
Always chain exceptions.

---

### Q13. Can constructors throw exceptions?

#### 📘 Answer

Yes.

```java
public FileReader() throws IOException {
}
```

Object is:

* Not created if constructor fails

---

#### ⚠️ Tricky Follow-up

**Are finally blocks executed if constructor fails?**

✅ **Answer:**
No — object never exists.

---

### Q14. Exception Handling in Lambdas — challenges?

#### 📘 Answer

Lambdas don’t allow checked exceptions unless declared.

```java
stream.forEach(x ->{
        try{...}catch(...){}
        });
```

---

#### ⚠️ Tricky Follow-up

**Best practice?**

✅ **Answer:**
Wrap checked exceptions into runtime exceptions.

---

### Q15. How should exceptions be handled in layered architectures?

#### 📘 Answer

Guidelines:

* DAO → technical exceptions
* Service → business exceptions
* Controller → map to HTTP responses

---

#### ⚠️ Tricky Follow-up

**Should exceptions be logged at every layer?**

✅ **Answer:**
No — log once, near boundary.

---

## ✅ End of Topic 5

---

[⬆ Back to Contents](#-java-question-bank--contents)

---

# 📘 Topic 6: Java Collections Framework

---

## 🟢 EASY QUESTIONS

---

### Q1. What is the Java Collections Framework?

#### 📘 Answer

The Java Collections Framework (JCF) is a **set of interfaces, implementations, and algorithms** to store and manipulate
groups of objects.

Key benefits:

* Standardized APIs
* High-performance implementations
* Reduces boilerplate
* Well-tested & optimized

Core interfaces:

```
Collection
 ├── List
 ├── Set
 └── Queue

Map (separate hierarchy)
```

---

#### ⚠️ Tricky Follow-up

**Why does `Map` not extend `Collection`?**

✅ **Answer:**
Because `Map` stores key-value pairs, not individual elements.

---

### Q2. Difference between List, Set, and Map?

#### 📘 Answer

| Interface | Duplicates | Ordering  | Example   |
|-----------|------------|-----------|-----------|
| List      | ✅          | Preserved | ArrayList |
| Set       | ❌          | Depends   | HashSet   |
| Map       | Keys ❌     | Depends   | HashMap   |

---

#### ⚠️ Tricky Follow-up

**Can a Map contain duplicate values?**

✅ **Answer:**
Yes — only keys must be unique.

---

### Q3. Difference between `ArrayList` and `LinkedList`?

#### 📘 Answer

| Aspect         | ArrayList     | LinkedList           |
|----------------|---------------|----------------------|
| Data structure | Dynamic array | Doubly linked list   |
| Access         | O(1)          | O(n)                 |
| Insert/Delete  | Costly        | Efficient            |
| Memory         | Less          | More (node overhead) |

---

#### ⚠️ Tricky Follow-up

**Why is LinkedList rarely used in practice?**

✅ **Answer:**
Poor cache locality and higher memory overhead.

---

### Q4. Difference between `HashSet` and `TreeSet`?

#### 📘 Answer

| Aspect       | HashSet  | TreeSet  |
|--------------|----------|----------|
| Ordering     | No       | Sorted   |
| Performance  | O(1) avg | O(log n) |
| Null allowed | One      | ❌        |

---

#### ⚠️ Tricky Follow-up

**How does HashSet ensure uniqueness?**

✅ **Answer:**
Uses `hashCode()` and `equals()` internally via `HashMap`.

---

## 🟡 MEDIUM QUESTIONS

---

### Q5. Explain internal working of `HashMap`.

#### 📘 Answer

Java 8+ HashMap internals:

```
hash(key)
   ↓
index = (n - 1) & hash
   ↓
bucket
   ↓
LinkedList → Tree (if > 8 nodes)
```

Key points:

* Array of buckets
* Collisions handled via chaining
* Converts to Red-Black Tree when bucket size > 8

---

#### ⚠️ Tricky Follow-up

**Why treeify threshold is 8?**

✅ **Answer:**
Empirically chosen balance between memory and performance.

---

### Q6. What is load factor in HashMap?

#### 📘 Answer

Load factor determines **when resizing occurs**.

Default:

```java
capacity =16
loadFactor =0.75
resize at 12 entries
```

---

#### ⚠️ Tricky Follow-up

**What happens during resize?**

✅ **Answer:**
Rehashing — expensive O(n) operation.

---

### Q7. Difference between `HashMap` and `Hashtable`?

#### 📘 Answer

| Aspect      | HashMap | Hashtable |
|-------------|---------|-----------|
| Thread-safe | ❌       | ✅         |
| Performance | Faster  | Slower    |
| Null key    | One     | ❌         |
| Legacy      | No      | Yes       |

---

#### ⚠️ Tricky Follow-up

**Should Hashtable ever be used today?**

✅ **Answer:**
No — use `ConcurrentHashMap`.

---

### Q8. Explain `ConcurrentHashMap`.

#### 📘 Answer

Java 8+ design:

* No segment locking
* Uses CAS + synchronized blocks
* Lock per bin (not whole map)

Advantages:

* High concurrency
* No global locking
* Safe iteration

---

#### ⚠️ Tricky Follow-up

**Can ConcurrentHashMap store null keys?**

✅ **Answer:**
No — to avoid ambiguity during concurrent reads.

---

### Q9. Fail-fast vs Fail-safe iterators.

#### 📘 Answer

| Type      | Behavior                                 |
|-----------|------------------------------------------|
| Fail-fast | Throws `ConcurrentModificationException` |
| Fail-safe | Works on snapshot                        |

Examples:

* Fail-fast → `ArrayList`
* Fail-safe → `ConcurrentHashMap`

---

#### ⚠️ Tricky Follow-up

**Is fail-safe iteration always safe?**

✅ **Answer:**
Safe from exception, but may see stale data.

---

## 🔴 HARD / SENIOR-LEVEL QUESTIONS

---

### Q10. Why must `hashCode()` and `equals()` follow a contract?

#### 📘 Answer

Contract:

* Equal objects → same hashCode
* Unequal objects → may have same hashCode

Violation causes:

* Lost entries
* Infinite loops
* Lookup failures

---

#### ⚠️ Tricky Follow-up

**Can two unequal objects have same hashCode?**

✅ **Answer:**
Yes — collisions are allowed.

---

### Q11. Difference between `Collections.unmodifiableList()` and `List.of()`?

#### 📘 Answer

| Aspect             | unmodifiableList | List.of |
|--------------------|------------------|---------|
| Backed by original | ✅                | ❌       |
| Null allowed       | Yes              | ❌       |
| Java version       | Older            | Java 9+ |

---

#### ⚠️ Tricky Follow-up

**Can underlying list still change?**

✅ **Answer:**
Yes — wrapper reflects changes.

---

### Q12. Difference between `Arrays.asList()` and `List.of()`?

#### 📘 Answer

| Aspect          | Arrays.asList | List.of |
|-----------------|---------------|---------|
| Fixed size      | ✅             | ✅       |
| Backed by array | ✅             | ❌       |
| Supports set()  | ✅             | ❌       |

---

#### ⚠️ Tricky Follow-up

**Why does `add()` fail on Arrays.asList()?**

✅ **Answer:**
Size is fixed — structural modification not allowed.

---

### Q13. What is `WeakHashMap`?

#### 📘 Answer

* Keys held via **weak references**
* GC removes entries when key is no longer strongly referenced

Use cases:

* Caches
* Metadata storage

---

#### ⚠️ Tricky Follow-up

**Does WeakHashMap prevent memory leaks?**

✅ **Answer:**
Helps, but not a silver bullet.

---

### Q14. What are common collection-related performance mistakes?

#### 📘 Answer

* Using LinkedList blindly
* Poor initial capacity sizing
* Excessive boxing
* Using synchronized collections unnecessarily

---

#### ⚠️ Tricky Follow-up

**How to size HashMap correctly?**

✅ **Answer:**
Initial capacity ≈ expectedSize / loadFactor.

---

### Q15. Why is modifying a collection during iteration dangerous?

#### 📘 Answer

Structural modification breaks iterator consistency.

Fail-fast behavior prevents:

* Infinite loops
* Corrupted state

---

#### ⚠️ Tricky Follow-up

**How to modify safely while iterating?**

✅ **Answer:**
Use:

* Iterator’s `remove()`
* Concurrent collections

---

## ✅ End of Topic 6

---

[⬆ Back to Contents](#-java-question-bank--contents)

---

# 📘 Topic 7: Concurrency & Multithreading in Java

---

## 🟢 EASY QUESTIONS

---

### Q1. What is a thread? Why do we need multithreading?

#### 📘 Answer

A **thread** is the smallest unit of execution within a process.

Multithreading allows:

* Parallelism (CPU utilization)
* Responsiveness
* Resource sharing

```
Process
 ├── Thread 1
 ├── Thread 2
 └── Thread N
```

---

#### ⚠️ Tricky Follow-up

**Does multithreading always improve performance?**

✅ **Answer:**
No — context switching and contention can degrade performance.

---

### Q2. Thread lifecycle in Java.

#### 📘 Answer

```
NEW
 ↓ start()
RUNNABLE
 ↓ (scheduler)
RUNNING
 ↓ wait/sleep/block
BLOCKED / WAITING
 ↓
TERMINATED
```

---

#### ⚠️ Tricky Follow-up

**Is RUNNING a separate state in Java?**

✅ **Answer:**
No — Java exposes it as RUNNABLE.

---

### Q3. Difference between `Thread` and `Runnable`.

#### 📘 Answer

| Thread                   | Runnable             |
|--------------------------|----------------------|
| Represents thread        | Represents task      |
| Inherits Thread          | Functional interface |
| Single inheritance issue | Flexible             |

Best practice: **Prefer Runnable**

---

#### ⚠️ Tricky Follow-up

**Can Runnable return a value?**

✅ **Answer:**
No — use `Callable`.

---

### Q4. Difference between `Runnable` and `Callable`.

#### 📘 Answer

| Aspect           | Runnable | Callable        |
|------------------|----------|-----------------|
| Return value     | ❌        | ✅               |
| Throws exception | ❌        | ✅               |
| Used with        | Thread   | ExecutorService |

---

#### ⚠️ Tricky Follow-up

**How do you get result from Callable?**

✅ **Answer:**
Using `Future`.

---

## 🟡 MEDIUM QUESTIONS

---

### Q5. What is synchronization in Java?

#### 📘 Answer

Synchronization ensures:

* Mutual exclusion
* Visibility
* Ordering

Achieved using:

* `synchronized` keyword
* Locks

---

#### ⚠️ Tricky Follow-up

**What exactly does synchronized lock?**

✅ **Answer:**
An object’s monitor (intrinsic lock).

---

### Q6. Explain `synchronized` method vs block.

#### 📘 Answer

```java
synchronized void method() {
}
```

Locks:

* Instance → object lock
* Static → class lock

Block:

```java
synchronized(obj){}
```

More granular and efficient.

---

#### ⚠️ Tricky Follow-up

**Can synchronized block lock `this`?**

✅ **Answer:**
Yes.

---

### Q7. What is `volatile` and how is it different from `synchronized`?

#### 📘 Answer

| volatile            | synchronized           |
|---------------------|------------------------|
| Visibility          | Visibility + Atomicity |
| No blocking         | Blocking               |
| No mutual exclusion | Mutual exclusion       |

---

#### ⚠️ Tricky Follow-up

**Is volatile enough for counters?**

✅ **Answer:**
No — increment is not atomic.

---

### Q8. Explain `wait()`, `notify()`, and `notifyAll()`.

#### 📘 Answer

* Must be called inside synchronized block
* Operate on object monitor

```
wait() → releases lock
notify() → wakes one thread
notifyAll() → wakes all
```

---

#### ⚠️ Tricky Follow-up

**Why is wait not in Thread class?**

✅ **Answer:**
Because waiting is tied to object monitors.

---

### Q9. Difference between `sleep()` and `wait()`.

#### 📘 Answer

| sleep                | wait            |
|----------------------|-----------------|
| Thread method        | Object method   |
| Doesn’t release lock | Releases lock   |
| Time-based           | Condition-based |

---

#### ⚠️ Tricky Follow-up

**Can wait timeout?**

✅ **Answer:**
Yes — timed wait.

---

## 🔴 HARD / SENIOR-LEVEL QUESTIONS

---

### Q10. What is a Deadlock? How does it occur?

#### 📘 Answer

Deadlock occurs when:

* Mutual exclusion
* Hold and wait
* No preemption
* Circular wait

```
Thread A → Lock 1 → waits for Lock 2
Thread B → Lock 2 → waits for Lock 1
```

---

#### ⚠️ Tricky Follow-up

**How to prevent deadlocks?**

✅ **Answer:**
Lock ordering, timeouts, lock-free algorithms.

---

### Q11. Difference between Deadlock, Livelock, and Starvation.

#### 📘 Answer

| Issue      | Description                    |
|------------|--------------------------------|
| Deadlock   | Threads stuck forever          |
| Livelock   | Threads active but no progress |
| Starvation | Thread never gets CPU          |

---

#### ⚠️ Tricky Follow-up

**Which is hardest to detect?**

✅ **Answer:**
Livelock.

---

### Q12. What is ExecutorService?

#### 📘 Answer

ExecutorService decouples:

* Task submission
* Thread management

Provides:

* Thread pools
* Lifecycle management

---

#### ⚠️ Tricky Follow-up

**Why not create threads manually?**

✅ **Answer:**
Thread creation is expensive and unbounded.

---

### Q13. Types of Thread Pools.

#### 📘 Answer

* FixedThreadPool
* CachedThreadPool
* SingleThreadExecutor
* ScheduledThreadPool

---

#### ⚠️ Tricky Follow-up

**Why is CachedThreadPool dangerous?**

✅ **Answer:**
Unbounded thread creation.

---

### Q14. What is ForkJoin framework?

#### 📘 Answer

Designed for:

* Divide-and-conquer
* Recursive parallelism

Uses:

* Work stealing algorithm

---

#### ⚠️ Tricky Follow-up

**Is ForkJoin suitable for blocking tasks?**

✅ **Answer:**
No — blocking defeats work stealing.

---

### Q15. What is `CompletableFuture`?

#### 📘 Answer

* Asynchronous computation
* Non-blocking
* Functional composition

```java
CompletableFuture.supplyAsync()
    .

thenApply()
    .

thenAccept();
```

---

#### ⚠️ Tricky Follow-up

**Difference between `get()` and `join()`?**

✅ **Answer:**
`get()` throws checked exception; `join()` throws unchecked.

---

## ✅ End of Topic 7

---

[⬆ Back to Contents](#-java-question-bank--contents)

---

# 📘 Topic 8: Java 8+ Features (Modern Java)

---

## 🟢 EASY QUESTIONS

---

### Q1. What were the major goals of Java 8?

#### 📘 Answer

Java 8 focused on:

* Functional programming support
* Better collection processing
* Backward compatibility
* Improved concurrency

Key additions:

* Lambda expressions
* Streams
* Functional interfaces
* Optional
* New Date-Time API

---

#### ⚠️ Tricky Follow-up

**Did Java 8 break backward compatibility?**

✅ **Answer:**
No — default methods were added specifically to avoid breaking existing interfaces.

---

### Q2. What is a Lambda Expression?

#### 📘 Answer

A lambda is a **compact representation of a function**.

```java
(a,b)->a +b
```

Equivalent to:

```java
new Comparator<Integer>(){

public int compare(Integer a, Integer b) {
    return a - b;
}
}
```

---

#### ⚠️ Tricky Follow-up

**Can lambdas access local variables?**

✅ **Answer:**
Yes — but variables must be **effectively final**.

---

### Q3. What is a Functional Interface?

#### 📘 Answer

A functional interface has **exactly one abstract method**.

Examples:

* `Runnable`
* `Callable`
* `Comparator`
* `Function`

Annotation:

```java
@FunctionalInterface
```

---

#### ⚠️ Tricky Follow-up

**Can a functional interface have default methods?**

✅ **Answer:**
Yes — only abstract methods are counted.

---

## 🟡 MEDIUM QUESTIONS

---

### Q4. Explain Stream API.

#### 📘 Answer

Streams provide **declarative data processing**.

Pipeline:

```
Source → Intermediate Ops → Terminal Op
```

Example:

```java
list.stream()
    .

filter(x ->x >10)
        .

map(x ->x *2)
        .

collect(toList());
```

---

#### ⚠️ Tricky Follow-up

**Are streams data structures?**

✅ **Answer:**
No — they don’t store data.

---

### Q5. Difference between Intermediate and Terminal operations.

#### 📘 Answer

| Intermediate   | Terminal         |
|----------------|------------------|
| Lazy           | Eager            |
| Returns Stream | Produces result  |
| filter, map    | collect, forEach |

---

#### ⚠️ Tricky Follow-up

**Can you reuse a stream?**

✅ **Answer:**
No — streams are single-use.

---

### Q6. What is Lazy Evaluation in Streams?

#### 📘 Answer

Intermediate operations execute **only when a terminal operation is invoked**.

This allows:

* Short-circuiting
* Performance optimizations

---

#### ⚠️ Tricky Follow-up

**How does `findFirst()` behave?**

✅ **Answer:**
Stops processing once a match is found.

---

### Q7. What is `Optional` and why was it introduced?

#### 📘 Answer

`Optional` is a container to represent **presence or absence** of a value.

```java
Optional<User> user;
```

Purpose:

* Avoid NullPointerException
* Make nullability explicit

---

#### ⚠️ Tricky Follow-up

**Should Optional be used as method parameters?**

✅ **Answer:**
No — it complicates APIs.

---

### Q8. Common Optional pitfalls?

#### 📘 Answer

❌ Anti-patterns:

* `Optional.get()` without check
* Using Optional in fields
* Wrapping null in Optional

✅ Prefer:

* `orElseGet`
* `ifPresent`

---

#### ⚠️ Tricky Follow-up

**Difference between `orElse()` and `orElseGet()`?**

✅ **Answer:**
`orElse()` eagerly evaluates; `orElseGet()` is lazy.

---

## 🔴 HARD / SENIOR-LEVEL QUESTIONS

---

### Q9. Parallel Streams — how do they work?

#### 📘 Answer

Parallel streams use:

* ForkJoinPool
* Work-stealing algorithm

```java
list.parallelStream()
```

---

#### ⚠️ Tricky Follow-up

**Why are parallel streams dangerous?**

✅ **Answer:**

* Shared thread pool
* Blocking tasks kill performance
* Non-deterministic ordering

---

### Q10. When should you NOT use Streams?

#### 📘 Answer

Avoid streams when:

* Simple loops are clearer
* Debugging is critical
* Heavy mutation required
* Low-latency code paths

---

#### ⚠️ Tricky Follow-up

**Are streams always slower than loops?**

✅ **Answer:**
Not always — depends on workload.

---

### Q11. Method References vs Lambdas.

#### 📘 Answer

Method reference is a **syntactic sugar**.

```java
list.forEach(System.out::println);
```

Types:

* Static
* Instance
* Constructor

---

#### ⚠️ Tricky Follow-up

**Do method references have performance benefits?**

✅ **Answer:**
No — readability only.

---

### Q12. Default methods in interfaces — why and risks?

#### 📘 Answer

Purpose:

* Backward compatibility

Risks:

* Diamond ambiguity
* Breaking encapsulation

---

#### ⚠️ Tricky Follow-up

**How to resolve default method conflict?**

✅ **Answer:**
Explicit override in implementing class.

---

### Q13. Explain the new Date-Time API (`java.time`).

#### 📘 Answer

Problems with old API:

* Mutable
* Not thread-safe

New API:

* Immutable
* Fluent
* Thread-safe

Examples:

* `LocalDate`
* `Instant`
* `ZonedDateTime`

---

#### ⚠️ Tricky Follow-up

**Difference between `Instant` and `LocalDateTime`?**

✅ **Answer:**
`Instant` is UTC-based; `LocalDateTime` has no timezone.

---

### Q14. What is `CompletableFuture` chaining?

#### 📘 Answer

Allows non-blocking composition.

```java
cf.thenApply()
  .

thenCompose()
  .

thenAccept();
```

---

#### ⚠️ Tricky Follow-up

**Difference between `thenApply` and `thenCompose`?**

✅ **Answer:**

* `thenApply` → map
* `thenCompose` → flatMap

---

### Q15. How has Java evolved post Java 8 (high-level)?

#### 📘 Answer

Highlights:

* Java 9: Modules
* Java 11: LTS, HTTP client
* Java 17: LTS, records, sealed classes
* Java 21: Virtual threads (preview → GA)

---

#### ⚠️ Tricky Follow-up

**Should teams always upgrade Java versions?**

✅ **Answer:**
Yes — but align with LTS versions.

---

## ✅ End of Topic 8

---

[⬆ Back to Contents](#-java-question-bank--contents)

---

# 📘 Topic 9: Serialization & Deserialization in Java

---

## 🟢 EASY QUESTIONS

---

### Q1. What is Serialization in Java?

#### 📘 Answer

**Serialization** is the process of converting an object into a **byte stream** so it can be:

* Stored (file, cache)
* Transmitted (network)
* Persisted or shared

Deserialization is the reverse process.

```java
Object →byte[] →Object
```

---

#### ⚠️ Tricky Follow-up

**Why is serialization needed when we already have JSON/XML?**

✅ **Answer:**
Java serialization preserves **object graph and type information**, unlike text formats.

---

### Q2. How do you make a class Serializable?

#### 📘 Answer

By implementing the marker interface:

```java
class User implements Serializable {
}
```

Key points:

* No methods to implement
* JVM handles serialization logic

---

#### ⚠️ Tricky Follow-up

**What happens if a non-serializable field exists?**

✅ **Answer:**
`NotSerializableException` is thrown.

---

### Q3. What is `serialVersionUID`?

#### 📘 Answer

`serialVersionUID` is a **version identifier** for a Serializable class.

```java
private static final long serialVersionUID = 1L;
```

Used to:

* Ensure compatibility during deserialization

---

#### ⚠️ Tricky Follow-up

**What happens if it is missing?**

✅ **Answer:**
JVM generates one dynamically — risky across versions.

---

## 🟡 MEDIUM QUESTIONS

---

### Q4. What happens if `serialVersionUID` changes?

#### 📘 Answer

If sender and receiver `serialVersionUID` mismatch:

❌ `InvalidClassException`

This protects against:

* Structural incompatibility
* Corrupted object graphs

---

#### ⚠️ Tricky Follow-up

**Can deserialization still work after class changes?**

✅ **Answer:**
Yes — if changes are backward compatible and UID is unchanged.

---

### Q5. What is the `transient` keyword?

#### 📘 Answer

Marks fields to be **excluded from serialization**.

```java
transient String password;
```

Use cases:

* Sensitive data
* Derived fields
* Non-serializable references

---

#### ⚠️ Tricky Follow-up

**What is the default value after deserialization?**

✅ **Answer:**
Default value (`null`, `0`, `false`).

---

### Q6. Explain the Java Serialization process.

#### 📘 Answer

Steps:

1. Check class implements Serializable
2. Write metadata
3. Serialize object graph recursively
4. Handle references & cycles

```
Object
 ↓
Fields
 ↓
Referenced Objects
```

---

#### ⚠️ Tricky Follow-up

**Does serialization handle circular references?**

✅ **Answer:**
Yes — JVM maintains reference tracking.

---

### Q7. What is `Externalizable`?

#### 📘 Answer

`Externalizable` gives **full control** over serialization.

```java
class User implements Externalizable {
    public void writeExternal(...) {
    }

    public void readExternal(...) {
    }
}
```

---

#### ⚠️ Tricky Follow-up

**Key difference from Serializable?**

✅ **Answer:**
Serializable → JVM-controlled
Externalizable → developer-controlled

---

## 🔴 HARD / SENIOR-LEVEL QUESTIONS

---

### Q8. Custom Serialization using `writeObject` / `readObject`.

#### 📘 Answer

Allows partial customization:

```java
private void writeObject(ObjectOutputStream out) {
}

private void readObject(ObjectInputStream in) {
}
```

Common use:

* Encrypt sensitive fields
* Validate state

---

#### ⚠️ Tricky Follow-up

**Are these methods called automatically?**

✅ **Answer:**
Yes — via reflection by JVM.

---

### Q9. Why is Java Serialization considered dangerous?

#### 📘 Answer

Major issues:

* Security vulnerabilities (RCE)
* Tight coupling
* Versioning issues
* Performance overhead

Many exploits rely on:

* Gadget chains
* Malicious byte streams

---

#### ⚠️ Tricky Follow-up

**How to mitigate serialization attacks?**

✅ **Answer:**

* Avoid Java serialization
* Use allowlists (`ObjectInputFilter`)
* Prefer JSON/Protobuf

---

### Q10. Can constructors be skipped during deserialization?

#### 📘 Answer

Yes.

During deserialization:

* Constructors are **not called**
* Object is reconstructed directly from byte stream

---

#### ⚠️ Tricky Follow-up

**Then how is object initialization handled?**

✅ **Answer:**
Via deserialization hooks (`readObject`).

---

### Q11. What happens to static fields during serialization?

#### 📘 Answer

Static fields:

* Belong to class, not object
* ❌ Not serialized

---

#### ⚠️ Tricky Follow-up

**Can static state cause bugs after deserialization?**

✅ **Answer:**
Yes — static state may be inconsistent.

---

### Q12. Serialization and Inheritance — what happens?

#### 📘 Answer

Rules:

* Serializable child + non-serializable parent → parent constructor invoked
* Serializable parent → no constructor call

---

#### ⚠️ Tricky Follow-up

**Why is parent constructor called?**

✅ **Answer:**
To initialize non-serializable state.

---

### Q13. How does serialization impact performance?

#### 📘 Answer

Costs:

* Reflection
* Deep object graphs
* Large payloads

Slower than:

* JSON
* Protobuf
* Avro

---

#### ⚠️ Tricky Follow-up

**Is serialization suitable for microservices?**

✅ **Answer:**
No — avoid in distributed systems.

---

### Q14. Is serialization suitable for caching?

#### 📘 Answer

Sometimes:

* In-memory caches (carefully)
* JVM-local caches

Avoid for:

* Long-term persistence
* Distributed caches

---

#### ⚠️ Tricky Follow-up

**What’s better for distributed caches?**

✅ **Answer:**
JSON / Kryo / Protobuf.

---

### Q15. When should Java Serialization be used at all?

#### 📘 Answer

Rare cases:

* JVM-internal frameworks
* Short-lived, trusted environments
* Legacy systems

---

#### ⚠️ Tricky Follow-up

**What’s the modern recommendation?**

✅ **Answer:**
Avoid Java Serialization unless absolutely required.

---

## ✅ End of Topic 9

---

[⬆ Back to Contents](#-java-question-bank--contents)

---

# 📘 Topic 10: Reflection, Annotations & Proxies in Java

---

## 🟢 EASY QUESTIONS

---

### Q1. What is Reflection in Java?

#### 📘 Answer

**Reflection** allows a program to:

* Inspect classes, methods, fields
* Modify behavior at runtime

Provided by:

```java
java.lang.reflect
```

Example:

```java
Class<?> c = Class.forName("com.example.User");
Method m = c.getMethod("getName");
```

---

#### ⚠️ Tricky Follow-up

**Why is reflection needed when Java is statically typed?**

✅ **Answer:**
Frameworks need runtime flexibility (e.g., Spring DI).

---

### Q2. What can reflection do?

#### 📘 Answer

Reflection can:

* Access private fields
* Invoke private methods
* Instantiate objects dynamically
* Inspect annotations

---

#### ⚠️ Tricky Follow-up

**Is reflection safe?**

✅ **Answer:**
Powerful but dangerous — can break encapsulation.

---

### Q3. What are Annotations?

#### 📘 Answer

Annotations are **metadata** added to code.

```java
@Override
@Service
@Entity
```

Used for:

* Compile-time checks
* Runtime processing
* Configuration

---

#### ⚠️ Tricky Follow-up

**Do annotations change program behavior by themselves?**

✅ **Answer:**
No — they need a processor.

---

## 🟡 MEDIUM QUESTIONS

---

### Q4. Annotation Retention Policies.

#### 📘 Answer

| Retention | Available    |
|-----------|--------------|
| SOURCE    | Compile-time |
| CLASS     | Bytecode     |
| RUNTIME   | Reflection   |

```java
@Retention(RetentionPolicy.RUNTIME)
```

---

#### ⚠️ Tricky Follow-up

**Which retention does Spring mostly use?**

✅ **Answer:**
RUNTIME.

---

### Q5. How does Spring use Reflection?

#### 📘 Answer

Spring uses reflection for:

* Dependency injection
* Bean creation
* Method interception
* Annotation scanning

Example:

```java
@Autowired
```

Spring scans classes and injects dependencies dynamically.

---

#### ⚠️ Tricky Follow-up

**Does Spring use reflection on every method call?**

✅ **Answer:**
No — mostly at startup.

---

### Q6. What is a Proxy in Java?

#### 📘 Answer

A proxy is an object that **wraps another object** to add behavior.

Uses:

* Logging
* Security
* Transactions

Types:

* JDK Dynamic Proxy
* CGLIB Proxy

---

#### ⚠️ Tricky Follow-up

**Which proxy does Spring prefer?**

✅ **Answer:**
JDK proxy if interface exists; otherwise CGLIB.

---

### Q7. Difference between JDK Dynamic Proxy and CGLIB.

#### 📘 Answer

| JDK Proxy       | CGLIB                    |
|-----------------|--------------------------|
| Interface-based | Class-based              |
| Uses reflection | Uses bytecode generation |
| Slower          | Faster                   |

---

#### ⚠️ Tricky Follow-up

**Can CGLIB proxy final classes?**

✅ **Answer:**
No — final classes/methods cannot be overridden.

---

## 🔴 HARD / SENIOR-LEVEL QUESTIONS

---

### Q8. Performance cost of Reflection.

#### 📘 Answer

Reflection is slower because:

* Bypasses JVM optimizations
* Uses dynamic lookup
* Breaks inlining

But:

* Cost mostly at startup
* Cached metadata reduces overhead

---

#### ⚠️ Tricky Follow-up

**Is reflection always slow?**

✅ **Answer:**
No — with caching, impact is minimal.

---

### Q9. How do annotations and reflection work together?

#### 📘 Answer

Flow:

```
Class loaded
 ↓
Reflection scans annotations
 ↓
Framework applies behavior
```

Annotations act as **markers**, reflection acts as **executor**.

---

#### ⚠️ Tricky Follow-up

**Can annotations be added at runtime?**

✅ **Answer:**
No — bytecode modification is required.

---

### Q10. What are Invocation Handlers?

#### 📘 Answer

Used in JDK dynamic proxies.

```java
InvocationHandler handler = (proxy, method, args) -> {
    // intercept
};
```

Intercepts:

* Method calls
* Arguments
* Return values

---

#### ⚠️ Tricky Follow-up

**Is InvocationHandler thread-safe?**

✅ **Answer:**
Depends on implementation.

---

### Q11. Explain AOP using proxies.

#### 📘 Answer

Aspect-Oriented Programming:

* Cross-cutting concerns
* Implemented via proxies

Examples:

* Transactions
* Logging
* Security

---

#### ⚠️ Tricky Follow-up

**Does AOP work on private methods?**

✅ **Answer:**
No — proxies can’t intercept private methods.

---

### Q12. Reflection vs Bytecode Manipulation.

#### 📘 Answer

| Reflection | Bytecode          |
|------------|-------------------|
| Runtime    | Compile/load time |
| Slower     | Faster            |
| Simple     | Complex           |

Frameworks like Hibernate use both.

---

#### ⚠️ Tricky Follow-up

**Why not always use bytecode manipulation?**

✅ **Answer:**
Complexity and maintainability issues.

---

### Q13. Security implications of Reflection.

#### 📘 Answer

Risks:

* Access private data
* Break encapsulation
* Bypass security checks

Mitigation:

* SecurityManager (legacy)
* Module system (Java 9+)

---

#### ⚠️ Tricky Follow-up

**Can reflection access private fields?**

✅ **Answer:**
Yes — via `setAccessible(true)` (restricted now).

---

### Q14. How does Java Module System affect reflection?

#### 📘 Answer

Java 9 modules:

* Restrict deep reflection
* Require `opens` keyword

---

#### ⚠️ Tricky Follow-up

**Why did many frameworks break after Java 9?**

✅ **Answer:**
Illegal reflective access restrictions.

---

### Q15. When should reflection be avoided?

#### 📘 Answer

Avoid reflection when:

* Performance-critical paths
* Compile-time safety needed
* Simpler alternatives exist

---

#### ⚠️ Tricky Follow-up

**Is reflection acceptable in frameworks?**

✅ **Answer:**
Yes — but with caution and caching.

---

## ✅ End of Topic 10

---

[⬆ Back to Contents](#-java-question-bank--contents)

---

# 📘 Topic 11: Design Patterns in Java (GOF + Real-World Usage)

---

## 🟢 EASY QUESTIONS

---

### Q1. What are Design Patterns?

#### 📘 Answer

Design Patterns are **proven, reusable solutions** to commonly occurring software design problems.

They are:

* Not code
* Not frameworks
* **Templates for solving problems**

Benefits:

* Shared vocabulary
* Better maintainability
* Cleaner architecture

---

#### ⚠️ Tricky Follow-up

**Are design patterns mandatory?**

✅ **Answer:**
No — patterns should solve problems, not be forced.

---

### Q2. What are the main categories of Design Patterns?

#### 📘 Answer

GOF patterns are grouped into:

| Category   | Purpose            |
|------------|--------------------|
| Creational | Object creation    |
| Structural | Object composition |
| Behavioral | Object interaction |

---

#### ⚠️ Tricky Follow-up

**Which category is most used in Java backend systems?**

✅ **Answer:**
Creational & Behavioral.

---

### Q3. Explain the Singleton Pattern.

#### 📘 Answer

Ensures **only one instance** of a class exists.

Classic implementation:

```java
class Singleton {
    private static final Singleton INSTANCE = new Singleton();

    private Singleton() {
    }

    public static Singleton getInstance() {
        return INSTANCE;
    }
}
```

---

#### ⚠️ Tricky Follow-up

**Why is Singleton controversial?**

✅ **Answer:**

* Global state
* Hard to test
* Hidden dependencies

---

## 🟡 MEDIUM QUESTIONS

---

### Q4. Different ways to implement Singleton in Java.

#### 📘 Answer

| Method                 | Thread-safe | Lazy |
|------------------------|-------------|------|
| Eager                  | ✅           | ❌    |
| Synchronized           | ✅           | ✅    |
| Double-checked locking | ✅           | ✅    |
| Enum                   | ✅           | ❌    |

**Best:** Enum Singleton

```java
enum Singleton {
    INSTANCE;
}
```

---

#### ⚠️ Tricky Follow-up

**Why is Enum Singleton preferred?**

✅ **Answer:**
Handles serialization & reflection attacks automatically.

---

### Q5. Factory Pattern vs Abstract Factory.

#### 📘 Answer

| Factory            | Abstract Factory |
|--------------------|------------------|
| Creates one object | Creates families |
| Simple             | Complex          |

Factory:

```java
Shape createShape(String type);
```

Abstract Factory:

```java
GUIFactory.createButton();
```

---

#### ⚠️ Tricky Follow-up

**When does Abstract Factory become overkill?**

✅ **Answer:**
When product families are unlikely to change.

---

### Q6. Builder Pattern — when and why?

#### 📘 Answer

Used for:

* Complex object construction
* Optional parameters
* Immutability

```java
User user = User.builder()
        .name("A")
        .age(30)
        .build();
```

---

#### ⚠️ Tricky Follow-up

**Is Builder better than constructors always?**

✅ **Answer:**
No — for simple objects, constructors are clearer.

---

### Q7. Prototype Pattern.

#### 📘 Answer

Creates objects by **cloning**.

```java
User clone = original.clone();
```

Useful when:

* Object creation is expensive

---

#### ⚠️ Tricky Follow-up

**Difference between shallow and deep copy?**

✅ **Answer:**
Shallow copies references; deep copies entire object graph.

---

## 🔴 HARD / SENIOR-LEVEL QUESTIONS

---

### Q8. Strategy Pattern — real-world use case.

#### 📘 Answer

Encapsulates interchangeable behaviors.

```java
interface PaymentStrategy {
    void pay();
}
```

Use cases:

* Pricing rules
* Validation logic
* Sorting strategies

---

#### ⚠️ Tricky Follow-up

**How is Strategy better than if-else?**

✅ **Answer:**
Open/Closed Principle compliance.

---

### Q9. Observer Pattern — where it breaks.

#### 📘 Answer

Used for:

* Event handling
* Notifications

Problems:

* Memory leaks
* Hidden dependencies
* Order unpredictability

---

#### ⚠️ Tricky Follow-up

**Why is Observer dangerous in large systems?**

✅ **Answer:**
Hard to trace event flow.

---

### Q10. Decorator Pattern vs Inheritance.

#### 📘 Answer

Decorator:

* Adds behavior dynamically
* Avoids subclass explosion

```java
new BufferedInputStream(
    new FileInputStream()
)
```

---

#### ⚠️ Tricky Follow-up

**What’s the downside of decorators?**

✅ **Answer:**
Complex debugging and deep wrapping chains.

---

### Q11. Proxy Pattern — real-world usage.

#### 📘 Answer

Used for:

* Lazy loading
* Security
* Transactions

Spring AOP uses Proxy Pattern heavily.

---

#### ⚠️ Tricky Follow-up

**Is proxy same as decorator?**

✅ **Answer:**
No — proxy controls access; decorator adds behavior.

---

### Q12. Template Method Pattern.

#### 📘 Answer

Defines algorithm skeleton; subclasses fill steps.

```java
abstract class Processor {
    final void process() {
        step1();
        step2();
    }
}
```

---

#### ⚠️ Tricky Follow-up

**What principle does it violate?**

✅ **Answer:**
Inheritance over composition (sometimes).

---

### Q13. Anti-patterns commonly seen in Java.

#### 📘 Answer

* God Object
* Singleton abuse
* Utility class overload
* Overuse of inheritance
* Anemic domain model

---

#### ⚠️ Tricky Follow-up

**Is Singleton always an anti-pattern?**

✅ **Answer:**
No — but often misused.

---

### Q14. Patterns commonly used implicitly in Java.

#### 📘 Answer

* Iterator → `Iterator`
* Adapter → `InputStreamReader`
* Decorator → IO streams
* Factory → `Collections.unmodifiableList()`

---

#### ⚠️ Tricky Follow-up

**Why is recognizing implicit patterns important?**

✅ **Answer:**
Shows design maturity.

---

### Q15. How to explain design patterns in interviews?

#### 📘 Answer

Best structure:

1. Problem
2. Why naive approach fails
3. Pattern solution
4. Trade-offs

---

#### ⚠️ Tricky Follow-up

**What’s worse than not knowing a pattern?**

✅ **Answer:**
Using a pattern without understanding why.

---

## ✅ End of Topic 11

---

[⬆ Back to Contents](#-java-question-bank--contents)

---

# 📘 Topic 12: Java I/O & NIO

---

## 🟢 EASY QUESTIONS

---

### Q1. What is Java I/O?

#### 📘 Answer

Java I/O provides APIs to:

* Read/write data
* From files, network, memory, etc.

Core packages:

```java
java.io
java.nio
```

Two major models:

* **I/O (blocking)**
* **NIO (non-blocking)**

---

#### ⚠️ Tricky Follow-up

**Is Java I/O only file-based?**

✅ **Answer:**
No — it includes network and in-memory I/O.

---

### Q2. Difference between Byte Streams and Character Streams.

#### 📘 Answer

| Byte Streams  | Character Streams  |
|---------------|--------------------|
| Raw bytes     | Unicode characters |
| `InputStream` | `Reader`           |
| Binary data   | Text data          |

Examples:

* Byte → `FileInputStream`
* Char → `FileReader`

---

#### ⚠️ Tricky Follow-up

**Why not always use character streams?**

✅ **Answer:**
Binary data (images, videos) needs byte streams.

---

### Q3. What is Buffered I/O?

#### 📘 Answer

Buffered I/O:

* Reduces disk/network access
* Uses in-memory buffers

```java
BufferedInputStream
        BufferedReader
```

---

#### ⚠️ Tricky Follow-up

**Does buffering change data correctness?**

✅ **Answer:**
No — only improves performance.

---

## 🟡 MEDIUM QUESTIONS

---

### Q4. What is Java NIO?

#### 📘 Answer

NIO (New I/O):

* Introduced in Java 1.4
* Designed for scalability

Key components:

* Channels
* Buffers
* Selectors

---

#### ⚠️ Tricky Follow-up

**Is NIO always non-blocking?**

✅ **Answer:**
No — it supports both blocking and non-blocking modes.

---

### Q5. Channel vs Stream.

#### 📘 Answer

| Stream     | Channel             |
|------------|---------------------|
| One-way    | Two-way             |
| Blocking   | Can be non-blocking |
| Sequential | Random access       |

---

#### ⚠️ Tricky Follow-up

**Can a channel replace all streams?**

✅ **Answer:**
No — streams are simpler for small tasks.

---

### Q6. What is a Buffer in NIO?

#### 📘 Answer

A buffer:

* Holds data temporarily
* Has position, limit, capacity

```
write → flip → read
```

---

#### ⚠️ Tricky Follow-up

**What happens if you forget to flip()?**

✅ **Answer:**
Reads will return incorrect data.

---

### Q7. Explain Selector in NIO.

#### 📘 Answer

Selector:

* Monitors multiple channels
* Uses single thread

Ideal for:

* High-concurrency servers

---

#### ⚠️ Tricky Follow-up

**Why is selector more scalable than thread-per-connection?**

✅ **Answer:**
Reduces thread and context-switch overhead.

---

## 🔴 HARD / SENIOR-LEVEL QUESTIONS

---

### Q8. Blocking vs Non-Blocking I/O.

#### 📘 Answer

| Blocking         | Non-Blocking     |
|------------------|------------------|
| Thread waits     | Thread continues |
| Simpler          | Complex          |
| Poor scalability | High scalability |

---

#### ⚠️ Tricky Follow-up

**Is non-blocking always faster?**

✅ **Answer:**
No — complexity overhead can outweigh benefits.

---

### Q9. What is Memory-Mapped I/O?

#### 📘 Answer

Maps file directly into memory.

```java
MappedByteBuffer
```

Benefits:

* Fast file access
* OS-level optimizations

---

#### ⚠️ Tricky Follow-up

**Any risks?**

✅ **Answer:**
Memory leaks if not unmapped properly.

---

### Q10. Explain FileChannel.

#### 📘 Answer

FileChannel:

* Reads/writes files
* Supports random access
* Works with buffers

---

#### ⚠️ Tricky Follow-up

**Is FileChannel thread-safe?**

✅ **Answer:**
No — external synchronization required.

---

### Q11. When should NIO be preferred over IO?

#### 📘 Answer

Use NIO when:

* High concurrency
* Network servers
* Large file transfers

Use IO when:

* Simplicity matters
* Low concurrency

---

#### ⚠️ Tricky Follow-up

**Does Spring WebFlux use NIO?**

✅ **Answer:**
Yes — based on non-blocking I/O.

---

### Q12. Difference between NIO and NIO.2.

#### 📘 Answer

NIO.2 (Java 7):

* Async I/O
* Better file system support

Example:

```java
AsynchronousFileChannel
```

---

#### ⚠️ Tricky Follow-up

**Is async I/O same as non-blocking I/O?**

✅ **Answer:**
No — async uses callbacks/futures.

---

### Q13. Common I/O performance mistakes.

#### 📘 Answer

* Not buffering
* Reading byte-by-byte
* Blocking I/O on request threads
* Not closing resources

---

#### ⚠️ Tricky Follow-up

**Best way to close resources?**

✅ **Answer:**
Try-with-resources.

---

### Q14. How does Java handle character encoding?

#### 📘 Answer

Encodings:

* UTF-8 (default)
* UTF-16
* ASCII

Specify explicitly:

```java
new InputStreamReader(stream, UTF_8)
```

---

#### ⚠️ Tricky Follow-up

**Why do encoding bugs happen?**

✅ **Answer:**
Platform default charset mismatch.

---

### Q15. I/O in microservices — best practices?

#### 📘 Answer

* Avoid blocking calls
* Use async/non-blocking I/O
* Proper back-pressure
* Timeouts everywhere

---

#### ⚠️ Tricky Follow-up

**Should every service use non-blocking I/O?**

✅ **Answer:**
No — complexity must justify benefit.

---

## ✅ End of Topic 12

---

[⬆ Back to Contents](#-java-question-bank--contents)

---

# 📘 Topic 13: Security & Best Practices in Java

---

## 🟢 EASY QUESTIONS

---

### Q1. Why is immutability important for security?

#### 📘 Answer

Immutable objects:

* Cannot be modified after creation
* Are inherently thread-safe
* Prevent accidental or malicious state changes

Common immutable classes:

* `String`
* `Integer`
* `LocalDate`

---

#### ⚠️ Tricky Follow-up

**Why is `String` immutable in Java?**

✅ **Answer:**
Security (class loaders, credentials), thread safety, and string pool optimizations.

---

### Q2. What is defensive copying?

#### 📘 Answer

Defensive copying prevents external modification of internal state.

```java
public Date getDate() {
    return new Date(date.getTime());
}
```

Used when:

* Exposing mutable objects
* Accepting mutable parameters

---

#### ⚠️ Tricky Follow-up

**Is defensive copying needed for immutable objects?**

✅ **Answer:**
No.

---

### Q3. Why should sensitive data not be stored as `String`?

#### 📘 Answer

Problems with `String`:

* Immutable (cannot be wiped)
* Stored in string pool
* Lives longer in memory

Better:

* `char[]`
* Byte arrays

---

#### ⚠️ Tricky Follow-up

**Why is this especially risky for passwords?**

✅ **Answer:**
Passwords remain in memory until GC.

---

## 🟡 MEDIUM QUESTIONS

---

### Q4. How should passwords be stored in Java applications?

#### 📘 Answer

Best practices:

* Never store plain text
* Use one-way hashing
* Add salt
* Use adaptive algorithms

Recommended:

* BCrypt
* PBKDF2
* Argon2

---

#### ⚠️ Tricky Follow-up

**Why not SHA-256?**

✅ **Answer:**
Too fast → vulnerable to brute-force attacks.

---

### Q5. What is the risk of deserialization vulnerabilities?

#### 📘 Answer

Attackers can:

* Send crafted byte streams
* Trigger malicious code execution
* Exploit gadget chains

---

#### ⚠️ Tricky Follow-up

**Is this theoretical or practical?**

✅ **Answer:**
Very practical — many real-world exploits exist.

---

### Q6. What is input validation and why is it important?

#### 📘 Answer

Input validation:

* Ensures data correctness
* Prevents injection attacks
* Protects downstream systems

Principle:

> **Never trust user input**

---

#### ⚠️ Tricky Follow-up

**Validation vs Sanitization — difference?**

✅ **Answer:**
Validation checks correctness; sanitization modifies input.

---

### Q7. What is secure exception handling?

#### 📘 Answer

Guidelines:

* Don’t expose stack traces to users
* Log internally
* Return generic error messages

---

#### ⚠️ Tricky Follow-up

**Why are stack traces dangerous?**

✅ **Answer:**
They leak internal structure and implementation details.

---

## 🔴 HARD / SENIOR-LEVEL QUESTIONS

---

### Q8. How can `equals()` and `hashCode()` cause security issues?

#### 📘 Answer

Issues:

* Timing attacks
* Hash collision attacks
* Denial-of-service via crafted inputs

Example:

* HashMap collision attack

---

#### ⚠️ Tricky Follow-up

**How did Java mitigate HashMap attacks?**

✅ **Answer:**
Tree bins (Java 8+) using Red-Black Trees.

---

### Q9. What is the principle of least privilege?

#### 📘 Answer

Grant:

* Minimum access required
* Nothing more

Applies to:

* Access modifiers
* APIs
* Credentials
* JVM permissions

---

#### ⚠️ Tricky Follow-up

**How does Java support this principle?**

✅ **Answer:**
Access modifiers, module system, security APIs.

---

### Q10. What are common security mistakes in Java code?

#### 📘 Answer

* Hard-coded credentials
* Using `Random` for security
* Ignoring TLS validation
* Logging sensitive data
* Reflection abuse

---

#### ⚠️ Tricky Follow-up

**Why is `java.util.Random` insecure?**

✅ **Answer:**
Predictable — use `SecureRandom`.

---

### Q11. What is secure object construction?

#### 📘 Answer

Ensure:

* Fully initialized objects
* No exposure of `this` during construction
* Validation inside constructors

---

#### ⚠️ Tricky Follow-up

**Why is exposing `this` dangerous?**

✅ **Answer:**
Allows access to partially constructed objects.

---

### Q12. What is the role of Java Module System in security?

#### 📘 Answer

Modules:

* Strong encapsulation
* Limit reflective access
* Explicit dependencies

---

#### ⚠️ Tricky Follow-up

**Why did many apps break after Java 9?**

✅ **Answer:**
Illegal reflective access was restricted.

---

### Q13. How can ThreadLocal cause security issues?

#### 📘 Answer

Problems:

* Data leaks across requests
* Memory leaks in thread pools

---

#### ⚠️ Tricky Follow-up

**How to use ThreadLocal safely?**

✅ **Answer:**
Always clean up (`remove()`).

---

### Q14. How should secrets be managed in Java apps?

#### 📘 Answer

Best practices:

* External secret stores
* Environment variables
* Vaults
* No secrets in code/repos

---

#### ⚠️ Tricky Follow-up

**Why not config files?**

✅ **Answer:**
Often leaked via source control or logs.

---

### Q15. What mindset should a senior engineer have about security?

#### 📘 Answer

Security is:

* Not a feature
* Not optional
* A continuous process

Think in terms of:

* Threat models
* Attack surfaces
* Blast radius

---

#### ⚠️ Tricky Follow-up

**Is security the responsibility of a separate team?**

✅ **Answer:**
No — every engineer owns security.

---

## ✅ End of Topic 13

---

[⬆ Back to Contents](#-java-question-bank--contents)

---

# 📘 Topic 14: JVM, Java & System Design Intersections

---

## 🟢 EASY QUESTIONS

---

### Q1. Why is Java commonly used for backend and distributed systems?

#### 📘 Answer

Java is popular because of:

* Mature ecosystem (Spring, Netty, Kafka, etc.)
* Strong concurrency support
* GC-managed memory
* Platform independence
* Long-term backward compatibility

---

#### ⚠️ Tricky Follow-up

**Is Java still relevant compared to Go or Node.js?**

✅ **Answer:**
Yes — Java excels in large, long-running, complex systems.

---

### Q2. What JVM characteristics matter most in system design?

#### 📘 Answer

Key JVM aspects:

* Garbage Collection behavior
* Thread model
* Memory footprint
* Startup time
* JIT optimizations

---

#### ⚠️ Tricky Follow-up

**Which JVM aspect impacts latency the most?**

✅ **Answer:**
Garbage Collection pauses.

---

## 🟡 MEDIUM QUESTIONS

---

### Q3. How does Garbage Collection affect distributed systems?

#### 📘 Answer

GC impacts:

* Latency spikes
* Request timeouts
* Cascading failures

Example:

* Long GC pause → instance unresponsive → load balancer retries → system overload

---

#### ⚠️ Tricky Follow-up

**How do teams mitigate GC impact?**

✅ **Answer:**

* Low-latency GCs (G1/ZGC)
* Smaller heaps
* Horizontal scaling

---

### Q4. JVM Heap sizing — what’s the trade-off?

#### 📘 Answer

| Small Heap     | Large Heap      |
|----------------|-----------------|
| Faster GC      | Slower GC       |
| More GC cycles | Fewer GC cycles |
| Less memory    | More memory     |

No “one-size-fits-all”.

---

#### ⚠️ Tricky Follow-up

**Why is max heap often set lower than available RAM?**

✅ **Answer:**
To leave room for native memory, metaspace, buffers.

---

### Q5. How does Java handle high concurrency in microservices?

#### 📘 Answer

Mechanisms:

* Thread pools
* Non-blocking I/O
* Reactive programming
* Efficient synchronization

---

#### ⚠️ Tricky Follow-up

**Why is thread-per-request dangerous?**

✅ **Answer:**
Thread exhaustion and context-switch overhead.

---

### Q6. Blocking vs Non-blocking in system design.

#### 📘 Answer

| Blocking          | Non-blocking        |
|-------------------|---------------------|
| Simple            | Complex             |
| Scales vertically | Scales horizontally |
| Thread-heavy      | Event-driven        |

---

#### ⚠️ Tricky Follow-up

**Should all services be non-blocking?**

✅ **Answer:**
No — complexity must justify gains.

---

## 🔴 HARD / SENIOR-LEVEL QUESTIONS

---

### Q7. JVM warm-up and its impact on production systems.

#### 📘 Answer

JVM needs time for:

* Class loading
* JIT compilation
* Profile-guided optimizations

Cold JVMs:

* Higher latency
* Lower throughput

---

#### ⚠️ Tricky Follow-up

**How do teams mitigate cold-start issues?**

✅ **Answer:**

* Warm-up traffic
* JVM flags
* Container reuse

---

### Q8. Java memory vs container memory (Docker/K8s).

#### 📘 Answer

Issues:

* JVM not aware of container limits (older Java)
* OOMKills by container runtime

Modern Java:

* Container-aware
* Uses cgroup limits

---

#### ⚠️ Tricky Follow-up

**Why do Java apps get killed even with free heap?**

✅ **Answer:**
Native memory exhaustion.

---

### Q9. GC pauses and tail latency.

#### 📘 Answer

Tail latency (P99/P999) is:

* Highly sensitive to GC pauses

Even rare pauses:

* Break SLAs
* Trigger retries

---

#### ⚠️ Tricky Follow-up

**Which GC is best for tail latency?**

✅ **Answer:**
ZGC or Shenandoah (if available).

---

### Q10. Java vs Go / Node.js — system design trade-offs.

#### 📘 Answer

| Java          | Go                     | Node            |
|---------------|------------------------|-----------------|
| Mature GC     | Lightweight goroutines | Event loop      |
| Strong typing | Simple concurrency     | JS ecosystem    |
| Higher memory | Low memory             | Single-threaded |

---

#### ⚠️ Tricky Follow-up

**When would you avoid Java?**

✅ **Answer:**
Ultra-low-latency or tiny-footprint services.

---

### Q11. How does JVM tuning differ across environments?

#### 📘 Answer

Differences:

* Dev → fast startup
* Prod → predictable latency
* Batch → throughput

---

#### ⚠️ Tricky Follow-up

**Should JVM flags differ per service?**

✅ **Answer:**
Yes — based on workload.

---

### Q12. How does Java impact resiliency patterns?

#### 📘 Answer

Java supports:

* Circuit breakers
* Bulkheads
* Timeouts
* Back-pressure

But GC pauses can:

* Break assumptions
* Delay timeouts

---

#### ⚠️ Tricky Follow-up

**How to design around GC pauses?**

✅ **Answer:**
Timeouts + retries + idempotency.

---

### Q13. Observability in Java systems.

#### 📘 Answer

Key signals:

* GC metrics
* Heap usage
* Thread counts
* Latency percentiles

---

#### ⚠️ Tricky Follow-up

**Why is average latency misleading?**

✅ **Answer:**
Tail latency causes failures.

---

### Q14. Java and event-driven architectures.

#### 📘 Answer

Java fits well with:

* Kafka
* Pulsar
* Streaming systems

Strengths:

* Strong typing
* Back-pressure support

---

#### ⚠️ Tricky Follow-up

**What Java mistake breaks event systems?**

✅ **Answer:**
Blocking calls in consumer threads.

---

### Q15. What does “thinking in JVM terms” mean for a senior engineer?

#### 📘 Answer

It means:

* Understanding memory behavior
* Predicting GC impact
* Designing for failure
* Balancing performance vs complexity

---

#### ⚠️ Tricky Follow-up

**What separates a senior Java engineer from a mid-level one?**

✅ **Answer:**
Ability to reason about JVM behavior under load.

---

## ✅ End of Topic 14

---

[⬆ Back to Contents](#-java-question-bank--contents)

---

# 📘 Topic 15: Tricky / Brain-Teaser Java Questions (Interview Traps)

---

## 🧠 CATEGORY 1: OUTPUT-BASED TRAPS

---

### Q1. What is the output?

```java
Integer a = 100;
Integer b = 100;
System.out.

println(a ==b);

Integer x = 200;
Integer y = 200;
System.out.

println(x ==y);
```

#### 📘 Answer

```
true
false
```

**Why?**

* Integer cache range: **-128 to 127**
* Cached values share references

---

#### ⚠️ Tricky Follow-up

**Does this behavior apply to `Long`?**

✅ **Answer:**
Yes — same caching range.

---

### Q2. What is the output?

```java
String a = "hello";
String b = "he" + "llo";
System.out.

println(a ==b);
```

#### 📘 Answer

```
true
```

**Why?**

* Compile-time constant folding
* Same string pool reference

---

#### ⚠️ Tricky Follow-up

```java
String b = "he";
String c = b + "llo";
```

✅ **Answer:**
`false` — runtime concatenation creates new object.

---

### Q3. What is the output?

```java
System.out.println(1+2+"3"+4+5);
```

#### 📘 Answer

```
3345
```

Left-to-right evaluation.

---

#### ⚠️ Tricky Follow-up

**What if parentheses change order?**

✅ **Answer:**
Changes output — always evaluate carefully.

---

## 🧠 CATEGORY 2: EXCEPTION & FINALLY TRAPS

---

### Q4. What is the output?

```java
try{
        throw new RuntimeException();
}finally{
        System.out.

println("finally");
}
```

#### 📘 Answer

```
finally
Exception thrown after
```

---

#### ⚠️ Tricky Follow-up

**Does finally always execute?**

✅ **Answer:**
Almost always — except `System.exit()`.

---

### Q5. What is the output?

```java
static int test() {
    try {
        return 1;
    } finally {
        return 2;
    }
}
```

#### 📘 Answer

```
2
```

---

#### ⚠️ Tricky Follow-up

**Is this good practice?**

✅ **Answer:**
No — return in finally hides logic.

---

## 🧠 CATEGORY 3: COLLECTION & MUTABILITY TRAPS

---

### Q6. What happens here?

```java
List<Integer> list = List.of(1, 2, 3);
list.

add(4);
```

#### 📘 Answer

Throws:

```
UnsupportedOperationException
```

---

#### ⚠️ Tricky Follow-up

**Is `Collections.unmodifiableList()` same?**

✅ **Answer:**
No — it’s a view over a mutable list.

---

### Q7. What is the output?

```java
List<String> list = Arrays.asList("a", "b");
list.

add("c");
```

#### 📘 Answer

Throws:

```
UnsupportedOperationException
```

Fixed-size list backed by array.

---

#### ⚠️ Tricky Follow-up

**Can `set()` work here?**

✅ **Answer:**
Yes.

---

## 🧠 CATEGORY 4: CONCURRENCY TRAPS

---

### Q8. Is this thread-safe?

```java
volatile int count = 0;
count++;
```

#### 📘 Answer

❌ **Not thread-safe**

`count++` is not atomic.

---

#### ⚠️ Tricky Follow-up

**What fixes this?**

✅ **Answer:**
`AtomicInteger` or synchronization.

---

### Q9. What’s wrong here?

```java
synchronized (new

Object()){
        // critical section
        }
```

#### 📘 Answer

❌ Lock is useless — new object every time.

---

#### ⚠️ Tricky Follow-up

**What should be used instead?**

✅ **Answer:**
Shared lock object.

---

## 🧠 CATEGORY 5: OBJECT & INITIALIZATION TRAPS

---

### Q10. What is the output?

```java
class A {
    static {
        System.out.println("A static");
    }
}

public class Test {
    public static void main(String[] args) {
        new A();
        new A();
    }
}
```

#### 📘 Answer

```
A static
```

Static block runs once.

---

#### ⚠️ Tricky Follow-up

**When is static block executed?**

✅ **Answer:**
When class is first loaded.

---

### Q11. What is printed?

```java
class Test {
    Test() {
        print();
    }

    void print() {
        System.out.println("Test");
    }
}

class Child extends Test {
    int x = 10;

    void print() {
        System.out.println(x);
    }
}
new

Child();
```

#### 📘 Answer

```
0
```

Field not initialized yet.

---

#### ⚠️ Tricky Follow-up

**Why is this dangerous?**

✅ **Answer:**
Calling overridable methods in constructors.

---

## 🧠 CATEGORY 6: STREAM & LAMBDA GOTCHAS

---

### Q12. What happens here?

```java
list.stream()
    .

filter(x ->{
        System.out.

println(x);
        return x >2;
        });
```

#### 📘 Answer

Nothing printed.

No terminal operation → no execution.

---

#### ⚠️ Tricky Follow-up

**How to force execution?**

✅ **Answer:**
Add terminal operation like `forEach`.

---

### Q13. What’s wrong here?

```java
list.parallelStream().

forEach(System.out::println);
```

#### 📘 Answer

Order is **not guaranteed**.

---

#### ⚠️ Tricky Follow-up

**How to preserve order?**

✅ **Answer:**
`forEachOrdered()`.

---

## 🧠 CATEGORY 7: MEMORY & GC TRAPS

---

### Q14. Is this a memory leak?

```java
static List<Object> cache = new ArrayList<>();
```

#### 📘 Answer

Potentially yes — static references prevent GC.

---

#### ⚠️ Tricky Follow-up

**How to fix?**

✅ **Answer:**
Eviction policies or weak references.

---

### Q15. Can GC collect this object?

```java
obj =null;
```

#### 📘 Answer

Eligible for GC — not guaranteed immediate collection.

---

#### ⚠️ Tricky Follow-up

**Can you force GC?**

✅ **Answer:**
No — `System.gc()` is just a hint.

---

## 🧠 CATEGORY 8: DESIGN & API TRAPS

---

### Q16. What’s wrong with this API?

```java
void process(Optional<User> user)
```

#### 📘 Answer

❌ Optional should not be used as parameters.

---

#### ⚠️ Tricky Follow-up

**Correct usage of Optional?**

✅ **Answer:**
Return types only.

---

### Q17. What’s the issue with this equals?

```java
public boolean equals(Object o) {
    return true;
}
```

#### 📘 Answer

Breaks:

* Symmetry
* Transitivity
* Hash-based collections

---

#### ⚠️ Tricky Follow-up

**Why is equals contract important?**

✅ **Answer:**
Collections depend on it.

---

## 🧠 FINAL INTERVIEW-LEVEL QUESTION

---

### Q18. What’s the biggest Java mistake senior engineers still make?

#### 📘 Answer

Not thinking in terms of:

* Object lifecycle
* Memory behavior
* Concurrency visibility
* Failure modes

---

#### ⚠️ Tricky Follow-up

**How do you avoid this?**

✅ **Answer:**
Design with JVM behavior in mind, not just syntax.

---

## ✅ End of Topic 15

---

[⬆ Back to Contents](#-java-question-bank--contents)

---
