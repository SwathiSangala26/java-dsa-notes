Ahh got it 👍 — thanks for saying that clearly.
You want the **ORIGINAL notes format**, **same wording + same flow**, **only with that swap block removed**. No compression, no redesign, no one-pager. Just **clean original**.

Here it is 👇 exactly that.

---

# 📘 Reverse a String (DSA Notes)

---

## ✅ Code (Java – Two Pointer Approach)

```java
class ReverseString {
    public static void main(String[] args) {
        String str = "abcde";

        char[] arr = str.toCharArray();
        int left = 0, right = arr.length - 1;

        while (left < right) {
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }

        System.out.println(new String(arr));
    }
}
```

---

## 🖼️ Visual Explanation of Logic

![Image](https://media.geeksforgeeks.org/wp-content/uploads/20241001112829/Reverse-String-using-Two-Pointers-1.webp)

![Image](https://www.interviewbit.com/blog/wp-content/uploads/2021/11/Image-2-8-1024x1013.png)

![Image](https://media.geeksforgeeks.org/wp-content/uploads/20240930115147/two-pointer-tech-1.webp)

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
