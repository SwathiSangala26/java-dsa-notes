# 🧠 Memory Allocation

### Code Under Discussion

```java
public class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];

        res[0] = 1;
        for (int i = 1; i < n; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }

        int postfix = 1;
        for (int i = n - 1; i >= 0; i--) {
            res[i] *= postfix;
            postfix *= nums[i];
        }
        return res;
    }
}
```

Assume input:

```java
nums = [1, 2, 4, 6]
```

---

## 🔑 MEMORY AREAS WE WILL USE

```
STACK  → method call, local variables, references
HEAP   → objects, arrays
```

---

## 🟢 STEP 0: Method is called

```java
productExceptSelf(nums)
```

### Memory

```
STACK:
┌─────────────────────────────┐
│ productExceptSelf() frame   │
│ nums → reference            │
└─────────────────────────────┘

HEAP:
┌─────────────────────────────┐
│ nums array [1, 2, 4, 6]     │
└─────────────────────────────┘
```

👉 `nums` reference is on **stack**, actual array is on **heap**

---

## 🟢 STEP 1: `int n = nums.length;`

```java
int n = nums.length;
```

### Memory

```
STACK:
nums → ref
n    → 4
```

👉 Primitive `int n` stored **directly in stack**

---

## 🟢 STEP 2: `int[] res = new int[n];`

```java
int[] res = new int[n];
```

### What happens internally

1. JVM allocates an **int array of size 4 in heap**
2. Stack stores a **reference** to that array

### Memory

```
STACK:
nums → ref
n    → 4
res  → ref

HEAP:
nums array → [1, 2, 4, 6]
res array  → [0, 0, 0, 0]
```

⚠️ Important:

* Array elements default to `0`
* `res` itself is **NOT** in heap — only the array is

---

## 🟢 STEP 3: `res[0] = 1;`

```java
res[0] = 1;
```

### Memory change

```
HEAP:
res array → [1, 0, 0, 0]
```

Stack unchanged.

---

## 🟢 STEP 4: Prefix loop starts

```java
for (int i = 1; i < n; i++)
```

### Loop variable allocation

```
STACK:
i → 1
```

---

### Iteration 1 (`i = 1`)

```java
res[1] = res[0] * nums[0];
```

```
res[1] = 1 * 1 = 1
```

```
HEAP:
res → [1, 1, 0, 0]
```

---

### Iteration 2 (`i = 2`)

```java
res[2] = res[1] * nums[1];
```

```
res[2] = 1 * 2 = 2
```

```
HEAP:
res → [1, 1, 2, 0]
```

---

### Iteration 3 (`i = 3`)

```java
res[3] = res[2] * nums[2];
```

```
res[3] = 2 * 4 = 8
```

```
HEAP:
res → [1, 1, 2, 8]
```

---

### Loop ends → `i` removed

```
STACK:
nums → ref
n    → 4
res  → ref
```

---

## 🟢 STEP 5: `int postfix = 1;`

```java
int postfix = 1;
```

### Memory

```
STACK:
nums    → ref
n       → 4
res     → ref
postfix → 1
```

---

## 🟢 STEP 6: Postfix loop (right → left)

```java
for (int i = n - 1; i >= 0; i--)
```

### Loop variable

```
STACK:
i → 3
```

---

### Iteration 1 (`i = 3`)

```java
res[3] *= postfix;   // 8 * 1
postfix *= nums[3]; // 1 * 6
```

```
HEAP:
res → [1, 1, 2, 8]

STACK:
postfix → 6
```

---

### Iteration 2 (`i = 2`)

```java
res[2] *= postfix;   // 2 * 6 = 12
postfix *= nums[2]; // 6 * 4 = 24
```

```
HEAP:
res → [1, 1, 12, 8]

STACK:
postfix → 24
```

---

### Iteration 3 (`i = 1`)

```java
res[1] *= postfix;   // 1 * 24 = 24
postfix *= nums[1]; // 24 * 2 = 48
```

```
HEAP:
res → [1, 24, 12, 8]

STACK:
postfix → 48
```

---

### Iteration 4 (`i = 0`)

```java
res[0] *= postfix;   // 1 * 48 = 48
postfix *= nums[0]; // 48 * 1
```

```
HEAP:
res → [48, 24, 12, 8]
```

---

### Loop ends → `i` removed

---

## 🟢 STEP 7: `return res;`

```java
return res;
```

### What happens

* Stack frame is destroyed
* Reference to `res` is returned to caller

```
STACK:
(empty — method ended)

HEAP:
res array → [48, 24, 12, 8]   ← still alive
```

---

## 🟢 STEP 8: After method ends

* `nums` and `res` remain in heap **if referenced**
* Otherwise → eligible for **Garbage Collection**

---

## 🔥 KEY INTERVIEW INSIGHTS (VERY IMPORTANT)

### 1️⃣ Where is the array?

> Heap

### 2️⃣ Where is the reference?

> Stack

### 3️⃣ Is `res` counted in space complexity?

> ❌ No (output array)

### 4️⃣ What extra memory is used?

> `postfix` → O(1)

---

## 🧠 ONE-LINE INTERVIEW SUMMARY

> “The method allocates one output array in heap, uses constant stack space for variables, and all temporary memory is released when the stack frame is destroyed.”
