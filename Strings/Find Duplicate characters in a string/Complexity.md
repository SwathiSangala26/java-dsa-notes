## ⏱️ Time Complexity (Step-by-Step Reasoning)

### **Step 1️⃣: Identify all loops**

#### Loop 1: String traversal

```java
for (char ch : str.toCharArray()) {
    freq[ch]++;
}
```

* Let `n` = length of the string
* Loop runs **once per character**
* Number of iterations = `n`

✅ Time = **O(n)**

---

#### Loop 2: Frequency array traversal

```java
for (int i = 0; i < freq.length; i++) {
    if (freq[i] > 1) { ... }
}
```

* `freq.length = 256`
* 256 is a **constant**
* Loop does **not depend on n**

✅ Time = **O(1)**

---

## **Step 2️⃣: Add the time taken by all parts**

Total time:

```
O(n) + O(1)
```

---

## **Step 3️⃣: Decide the FINAL Time Complexity**

### 🔑 Rule of Big-O

> When adding complexities, **keep only the dominant term**

* O(n) grows as input grows
* O(1) stays the same

So:

```
O(n) + O(1) = O(n)
```

### ✔ **Final Time Complexity: O(n)**

---

### 🧠 Points to Remember (Interview Gold)

* Constants are ignored (`256 → 1`)
* Only growth with input size matters
* Dominant term decides final Big-O

---

## 🧠 Space Complexity (Step-by-Step Reasoning)

---

### **Step 1️⃣: Identify extra memory used**

#### Memory 1: Frequency array

```java
int[] freq = new int[256];
```

* Fixed size
* Independent of input length

✅ Space = **O(1)**

---

#### Memory 2: Character array

```java
str.toCharArray()
```

* Creates new array of size `n`
* Depends on input length

✅ Space = **O(n)**

---

## **Step 2️⃣: Add space used**

Total space:

```
O(1) + O(n)
```

---

## **Step 3️⃣: Decide FINAL Space Complexity**

### 🔑 Big-O Rule (same as time)

> Keep only the dominant term

* O(n) dominates O(1)

So:

```
O(1) + O(n) = O(n)
```

### ✔ **Final Space Complexity: O(n)**

---

## 🧠 One Simple Rule to Memorize

> **Time / Space = biggest term after removing constants**
