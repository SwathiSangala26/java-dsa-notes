## ⏱️ Time Complexity (Step-by-Step Reasoning)

### **Step 1️⃣: Identify all loops**

#### Loop 1: Two-pointer traversal

```java
while (left < right) {
    if (str.charAt(left) != str.charAt(right)) {
        break;
    }
    left++;
    right--;
}
```

* Let `n` = length of the string
* `left` starts from index `0`
* `right` starts from index `n - 1`
* In each iteration:

  * `left` moves forward
  * `right` moves backward

➡ Loop checks **two characters per iteration**
➡ Total iterations ≈ `n / 2`

✅ Time = **O(n)**

---

### **Step 2️⃣: Check for other time-consuming code**

```java
System.out.println("Palindrome");
```

* Printing is a constant-time operation
* Does not depend on input size

✅ Time = **O(1)**

---

### **Step 3️⃣: Add the time taken by all parts**

```
O(n) + O(1)
```

---

### **Step 4️⃣: Decide the FINAL Time Complexity**

#### 🔑 Big-O Rule

> Keep only the **dominant term**

* `O(n)` grows with input size
* `O(1)` stays constant

So:

```
O(n) + O(1) = O(n)
```

### ✔ **Final Time Complexity: O(n)**

---

## 🧠 Space Complexity (Step-by-Step Reasoning)

---

### **Step 1️⃣: Identify extra memory used**

#### Memory 1: Variables

```java
int left;
int right;
boolean isPalindrome;
```

* Fixed number of variables
* Does not grow with input size

✅ Space = **O(1)**

---

### **Step 2️⃣: Check for additional data structures**

* ❌ No arrays
* ❌ No new strings
* ❌ No recursion
* ❌ No collections

➡ No memory allocated based on input length

---

### **Step 3️⃣: Add space used**

```
O(1)
```

---

### **Step 4️⃣: Decide FINAL Space Complexity**

* Only constant extra memory is used

### ✔ **Final Space Complexity: O(1)**
