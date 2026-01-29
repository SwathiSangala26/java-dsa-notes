## ⏱️ Time Complexity: **O(n)**

**How?**

* Two pointers (`l` and `r`) move from both ends toward the center.
* Each character is visited **at most once**.
* Skipping non-alphanumeric characters does not add extra passes.

👉 Total work is proportional to the string length `n`.

---

## 💾 Space Complexity: **O(1)**

**How?**

* No extra data structures are used.
* Only a few variables (`l`, `r`, `ch`) are stored.
* No new string or array is created.

---
