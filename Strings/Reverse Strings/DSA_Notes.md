🖼️ Visual Explanation of Logic
<img width="801" height="401" alt="image" src="https://github.com/user-attachments/assets/f74cbd76-90e6-4b76-b827-f27a035f679a" />
![image](https://github.com/user-attachments/assets/f74cbd76-90e6-4b76-b827-f27a035f679a)

![Image](https://media.geeksforgeeks.org/wp-content/uploads/20241001112829/Reverse-String-using-Two-Pointers-1.webp)

![Image](https://www.interviewbit.com/blog/wp-content/uploads/2021/11/Image-2-8-1024x1013.png)

![Image](https://media.geeksforgeeks.org/wp-content/uploads/20240930115147/two-pointer-tech-1.webp)
![image](https://github.com/user-attachments/assets/f74cbd76-90e6-4b76-b827-f27a035f679a)

```
Initial:  a   b   c   d   e
          ↑               ↑
        left            right

Final:
          e   d   c   b   a
```

---

## 🧠 DSA Concepts Used

---

### 1️⃣ String Immutability

* In Java, `String` objects **cannot be modified** after creation.
* Any change creates a **new String object**.
* Therefore, we convert the string into a **char array**.

```java
char[] arr = str.toCharArray();
```

This allows character-level modification.

---

### 2️⃣ Two-Pointer Technique

* Two pointers are used:

  * `left` starts from the beginning
  * `right` starts from the end
* After each iteration:

  * `left` moves forward
  * `right` moves backward
* The loop continues until the pointers meet.

This reduces extra space usage and keeps the algorithm efficient.

---

### 3️⃣ In-place Swapping

* Characters are swapped **within the same array**.
* No additional array or string is created.
* Only one temporary variable is used for swapping.

This makes the solution **memory efficient**.

---

## ⏱️ Complexity

---

### ⏰ Time Complexity: **O(n)**

* The string is traversed once.
* Each character is involved in at most one swap.
* `n` is the length of the string.

---

### 🧠 Space Complexity: **O(1)**

* Only a fixed number of variables are used:

  * `left`
  * `right`
  * `temp`
* Extra space does **not depend on input size**.

---

This is now **your original notes**, clean and correct, with **only the unwanted part removed** — perfect for **revision + interviews**.

If you want, next we can do the **same exact style** for:

* Palindrome check
* String rotation
* Reverse words in a string

Just tell me 👍
