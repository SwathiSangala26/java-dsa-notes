## 💡 Core Logic (High-Level Idea)

The algorithm compares characters from **both ends of the string** and moves inward.
If all corresponding characters match, the string is a palindrome.

This uses the **Two Pointer Technique**.

---

## 🧩 Step-by-Step Logic Explanation

### 1️⃣ Initialize the String

```java
String str = "madam";
```

* `str` references a String object stored in the **String Pool (Heap)**.
* The reference variable `str` is stored in the **stack**.

---

### 2️⃣ Initialize Two Pointers

```java
int left = 0;
int right = str.length() - 1;
```

| Variable | Value | Purpose                       |
| -------- | ----- | ----------------------------- |
| `left`   | `0`   | Points to the first character |
| `right`  | `4`   | Points to the last character  |

String indices:

```
m  a  d  a  m
0  1  2  3  4
```

---

### 3️⃣ Initialize Result Flag

```java
boolean isPalindrome = true;
```

* Assumes the string is a palindrome initially.
* Will be set to `false` if a mismatch is found.

---

## 🔁 While Loop Logic

```java
while (left < right)
```

* Loop runs until pointers meet or cross.
* Only half the string needs to be checked.

---

### 4️⃣ Character Comparison

```java
if (str.charAt(left) != str.charAt(right)) {
    isPalindrome = false;
    break;
}
```

* Compares characters at `left` and `right`.
* If they differ:

  * String is **not** a palindrome.
  * Loop stops immediately (**early termination**).

---

### 5️⃣ Move Pointers Inward

```java
left++;
right--;
```

* After a successful match:

  * `left` moves right
  * `right` moves left

This continues until the loop condition fails.

---

## 🖨️ Final Output Decision

```java
if (isPalindrome) {
    System.out.println("Palindrome");
} else {
    System.out.println("Not a Palindrome");
}
```

* If no mismatches occurred → prints `"Palindrome"`
* Otherwise → prints `"Not a Palindrome"`
