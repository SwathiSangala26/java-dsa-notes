## ⏱️ Time Complexity

Let

* `n = length of s1`
* `m = length of s2`
* `s3.length() = n + m`

### What the code does:

* One single loop runs over `s3`
* Each character is checked **once**
* Pointer movements are constant-time operations

### 👉 Total operations grow with `(n + m)`

### ✅ **Final Time Complexity**

```
O(n + m)
```

---

## 📦 Space Complexity

### Extra space used:

* Only integer variables: `i`, `j`, `k`
* No extra arrays, maps, or strings
* No recursion

### Input strings are not counted as extra space

### ✅ **Final Space Complexity**

```
O(1)
```

---

## 🎯 Interview-Ready Final Answer

> **Time Complexity:** `O(n + m)`
> **Space Complexity:** `O(1)`
