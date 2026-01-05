### **Time Complexity:**

```
O(n)
```

### **Space Complexity:**

```
O(1) auxiliary space (output array excluded)
```

---

# 📌 CODE UNDER ANALYSIS

```java
public int[] productExceptSelf(int[] nums) {

    int n = nums.length;          // (1)
    int[] res = new int[n];       // (2)

    res[0] = 1;                   // (3)
    for (int i = 1; i < n; i++) { // (4)
        res[i] = res[i - 1] * nums[i - 1];  // (5)
    }

    int postfix = 1;              // (6)
    for (int i = n - 1; i >= 0; i--) { // (7)
        res[i] *= postfix;        // (8)
        postfix *= nums[i];       // (9)
    }
    return res;                   // (10)
}
```

---

# ⏱️ WHY TIME COMPLEXITY IS **O(n)**

### Prefix Loop — Lines (4)–(5)

```java
for (int i = 1; i < n; i++)
```

* Runs `n − 1` times
* Constant work per iteration
  → **O(n)**

---

### Postfix Loop — Lines (7)–(9)

```java
for (int i = n - 1; i >= 0; i--)
```

* Runs `n` times
* Constant work per iteration
  → **O(n)**

---

### Total Time

```
O(n) + O(n) = O(n)
```

✔ No nested loops
✔ Each element processed twice

---

# 🧠 WHY SPACE COMPLEXITY IS **O(1)**

### Output Array — Line (2)

```java
int[] res = new int[n];
```

* Required by the problem
* ❌ Not counted in auxiliary space

---

### Extra Memory Used

```java
int postfix = 1;   // one variable
int i              // loop variable
```

* Constant number of variables
  → **O(1)** extra space

---

# 🔥 IMPORTANT INTERVIEW LINE (MEMORIZE)

> “The algorithm runs in O(n) time and uses O(1) auxiliary space, excluding the output array.”

---

# 🧾 FINAL NOTES (WRITE THIS IN ONE BOX)

```
Product of Array Except Self

Time Complexity:
O(n) – two linear passes

Space Complexity:
O(1) – only constant extra space
(output array excluded)
