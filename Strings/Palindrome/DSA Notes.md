## 🖼️ Visual Explanation of Logic

![Image](https://media.geeksforgeeks.org/wp-content/uploads/20240920165631/Check-for-Palindromic-String.webp)

* A pointer `left` starts from the **beginning** of the string
* A pointer `right` starts from the **end** of the string
* Characters at `left` and `right` are compared:

  * If they match → move both pointers inward
  * If they don’t match → the string is **not** a palindrome
* The process continues until both pointers meet in the middle

---

## 🧠 DSA Concepts Used

* **Two Pointer Technique**

  * Efficiently compares elements from both ends
* **Character Access**

  * Uses `charAt()` for constant-time character comparison
* **Loop Control**

  * `break` is used for early exit on mismatch
* **Boolean Flag**

  * Tracks palindrome status without extra data structures

---

## ⏱️ Complexity

### ⏰ Time Complexity

* Let `n` be the length of the string
* The loop runs until `left < right`
* Each iteration compares **two characters**
* Total comparisons ≈ `n / 2`

**Final Time Complexity:**
✔ **O(n)**

**Points to remember:**

* Best case: mismatch at first comparison → **O(1)**
* Worst case: entire string is palindrome → **O(n)**
* Constants are ignored in Big-O notation

---

### 🧠 Space Complexity

* Only a few variables are used:

  * `left`
  * `right`
  * `isPalindrome`
* No extra arrays or strings are created
* Memory usage does **not depend on input size**

**Final Space Complexity:**
✔ **O(1)**

**Points to remember:**

* In-place comparison
* No recursion stack
* No additional data structures
