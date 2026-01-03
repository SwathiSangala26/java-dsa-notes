## ⏱️ Time Complexity Explanation

### Code parts involved

```java
if (s.length() != t.length())   // O(1)
```

* Constant time check

---

```java
for (int i = 0; i < s.length(); i++) {
    count[s.charAt(i) - 'a']++;
    count[t.charAt(i) - 'a']--;
}
```

* Loop runs **n times** (n = length of string)
* Each operation inside loop is constant time

➡ **Time = O(n)**

---

```java
for (int val : count) {
    if (val != 0) {
        return false;
    }
}
```

* Always runs **26 times**
* 26 is constant, not dependent on input size

➡ **Time = O(1)**

---

### ✅ Total Time Complexity

```
O(n) + O(1) = O(n)
```

---

## 🧠 Space Complexity Explanation

### Extra memory used

```java
int[] count = new int[26];
```

* Array size is **fixed (26)**
* Does NOT grow with input size

➡ **Space = O(1)**

---

### Important Note

* Strings `s` and `t` are input, not counted as extra space
* Only the `count` array is extra memory

---

## 🎯 One-Line Interview Answer

> **“The algorithm runs in linear time and uses constant extra space due to the fixed-size frequency array.”**
