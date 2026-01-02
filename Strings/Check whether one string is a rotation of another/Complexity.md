## 🧠 Time Complexity

### **Step 1: Length check**

```java
s1.length() == s2.length()
```

* Length of a string in Java is stored
* Accessing it is **constant time**

✅ **O(1)**

---

### **Step 2: String concatenation**

```java
s1 + s1
```

* Creates a **new string** of length `2n`
* Copies characters from `s1` twice

✅ **O(n)**

---

### **Step 3: Substring search**

```java
(s1 + s1).contains(s2)
```

Internally:

* `contains()` → uses `indexOf()`
* Searches for `s2` (length `n`) inside a string of length `2n`
* Worst case → compares characters multiple times

✅ **O(n)** (amortized / practical interview answer)

---

### 🔢 **Total Time Complexity**

```
O(1) + O(n) + O(n)
```

### 🎯 **Final Time Complexity**

👉 **O(n)**

---

## 🧠 Space Complexity

### **Extra memory used**

* New string created: `s1 + s1` → size `2n`
* No other significant data structures

👉 **O(n)** extra space
