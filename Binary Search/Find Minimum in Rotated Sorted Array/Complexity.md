## ⏱️ Time Complexity — **O(log n)**

* `while (l < r)` loop runs
* Each iteration **cuts the search space in half**
* This happens because:

  ```java
  r = m;       // discard right half
  l = m + 1;   // discard left half
  ```
* Array size progression:

  ```
  n → n/2 → n/4 → n/8 → ... → 1
  ```
* Number of iterations ≈ `log₂ n`

✅ **Time Complexity = O(log n)**

---

## 🧠 Space Complexity — **O(1)**

* Only variables used:

  ```java
  int l, r, m;
  ```
* No extra arrays created
* No recursion
* No stack / map / set used
* Memory usage does **not depend on input size**
