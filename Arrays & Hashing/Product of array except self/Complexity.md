## ⏱️ TIME COMPLEXITY

### ✅ Definition

> **Time complexity** measures how the running time of an algorithm grows as the input size (`n`) grows.

It **does NOT** measure actual seconds — it measures **growth rate**.

---

## 🔹 How to Calculate Time Complexity

### 1️⃣ Count loops (most important)

| Code               | Time  |
| ------------------ | ----- |
| One loop over `n`  | O(n)  |
| Two separate loops | O(n)  |
| Nested loops       | O(n²) |

---

### 2️⃣ Ignore constants

```text
O(2n) → O(n)
O(5n + 10) → O(n)
```

---

### 3️⃣ Focus on worst case

Interviewers almost always want **worst-case time**.

---

## 🔹 Common Time Complexities (with examples)

| Complexity | Example              |
| ---------- | -------------------- |
| O(1)       | Access array element |
| O(log n)   | Binary search        |
| O(n)       | Single loop          |
| O(n log n) | Merge sort           |
| O(n²)      | Nested loops         |
| O(2ⁿ)      | Recursive subsets    |

---

## 📌 Example (Your Code)

```java
for (int i = 0; i < n; i++) { }      // O(n)
for (int i = n-1; i >= 0; i--) { }  // O(n)
```

Total:

```
O(n) + O(n) = O(n)
```

---

# 🧠 SPACE COMPLEXITY

---

## ✅ Definition

> **Space complexity** measures how much extra memory an algorithm uses as input size grows.

⚠️ Important:

> **We count auxiliary (extra) space only**

---

## 🔹 What is Auxiliary Space?

| Memory Type             | Counted? |
| ----------------------- | -------- |
| Output array (required) | ❌ No     |
| Helper arrays           | ✅ Yes    |
| Variables               | ✅ Yes    |
| Recursion stack         | ✅ Yes    |

---

## 🔹 Why Output Array Is Not Counted

If the problem says:

> “Return an array…”

You **must** allocate it.

So interviewers **exclude it** from space complexity.

---

## 📌 Example (Your Code)

```java
int[] res = new int[n];   // output → NOT counted
int postfix = 1;         // extra variable → counted
```

### Space Complexity:

```
O(1)
```

---

## 🔹 Space Complexity Examples

| Code                      | Space |
| ------------------------- | ----- |
| Only variables            | O(1)  |
| One helper array          | O(n)  |
| Two helper arrays         | O(n)  |
| Recursive calls (depth n) | O(n)  |

---

## 🧠 Time vs Space (Key Difference)

| Time         | Space                 |
| ------------ | --------------------- |
| How fast     | How much memory       |
| Loops matter | Extra storage matters |

---

## 🔥 Interview Traps (VERY IMPORTANT)

### ❓ “Why isn’t this O(n) space? You created an array!”

✅ Answer:

> “The array is the output, so it’s excluded from auxiliary space.”

---

### ❓ “If printing is allowed?”

✅ Answer:

> “Then even output isn’t stored, so space is truly O(1).”

---

## 🎯 Quick Revision Cheat Sheet

```
Time Complexity:
- Count loops
- Ignore constants
- Focus on worst case

Space Complexity:
- Count extra memory
- Exclude required output
- Include recursion stack
```
