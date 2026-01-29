## ⏱ Time Complexity: **O(n)**

### Why O(n)?

* Two pointers are used: `left` and `right`
* Initially:

  * `left = 0`
  * `right = n − 1`
* In **each iteration**, **exactly one pointer moves**

  * either `left++` or `right--`
* No pointer ever moves backward
* The loop runs until `left < right`

### Total number of pointer moves:

* `left` can move at most `n − 1` times
* `right` can move at most `n − 1` times
* Combined moves ≤ `n − 1`

### Therefore:

```
Time Complexity = O(n)
```

---

### ❌ Why NOT O(n²)?

* There is **no nested loop**
* Each element is visited **once**
* Brute force checks all pairs → O(n²)
* Two-pointer avoids repeated comparisons

---

## 💾 Space Complexity: **O(1)**

### Why O(1)?

* Only a **constant number of variables** are used:

  ```java
  int left, right, area, maxArea;
  ```
* No additional data structures (arrays, lists, sets)
* No recursion
* Input array is **not counted** as extra space

### Therefore:

```
Space Complexity = O(1)
```

---

## 📌 Key Points to Remember

* **O(n)** → linear scan using two pointers
* **O(1)** → constant extra memory
* Efficient and optimal compared to brute force

---

## 🎯 Interview-Ready One-Liners

* **Time:**

  > “Each pointer moves at most once across the array, so the time complexity is O(n).”

* **Space:**

  > “Only a fixed number of variables are used, so the space complexity is O(1).”

---

## 📝 Final Summary

| Metric | Complexity | Reason                    |
| ------ | ---------- | ------------------------- |
| Time   | O(n)       | Single pass, two pointers |
| Space  | O(1)       | No extra data structures  |
