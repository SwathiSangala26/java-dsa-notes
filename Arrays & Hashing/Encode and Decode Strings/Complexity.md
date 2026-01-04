# ⏱️ TIME & SPACE COMPLEXITY

### (For your Encode–Decode Code)

---

## 🔹 encode(List<String> strs)

### Code recap

```java
for (String s : strs) {
    res.append(s.length()).append('#').append(s);
}
```

---

## ⏱️ Time Complexity — `encode()`

### 👉 **O(N)**

Where:

* `N` = **total number of characters in all strings**

### Why?

* Each character of every string is appended **exactly once**
* `StringBuilder.append()` is **amortized O(1)** per character
* Length and `#` are constant-time

✔ No nested loops over characters
✔ No re-traversal

---

## 📦 Space Complexity — `encode()`

### 👉 **O(N)**

Why?

* `StringBuilder` stores all characters of the encoded string
* Output string size is proportional to input size

### Extra space?

* Only the output string
* No unnecessary intermediate strings

---

## 🔹 decode(String str)

### Code recap

```java
while (i < str.length()) {
    while (str.charAt(j) != '#') j++;
    int length = Integer.parseInt(str.substring(i, j));
    res.add(str.substring(i, i + length));
    i = i + length;
}
```

---

## ⏱️ Time Complexity — `decode()`

### 👉 **O(N)**

Where:

* `N` = length of encoded string

### Why?

* Pointer `i` moves **only forward**
* Each character is:

  * Read once to find `#`
  * Read once when extracting substring
* No backtracking

✔ Single pass
✔ Linear scan

---

## 📦 Space Complexity — `decode()`

### 👉 **O(N)**

Why?

* Output list stores all decoded strings
* Total size of decoded strings ≈ input size

### Temporary objects

* Substrings created briefly
* Eligible for GC after method execution

---

# 📊 FINAL COMPLEXITY TABLE (WRITE THIS)

| Method | Time | Space |
| ------ | ---- | ----- |
| encode | O(N) | O(N)  |
| decode | O(N) | O(N)  |

---

# 🎯 INTERVIEW-PERFECT SUMMARY

> “Both encoding and decoding run in linear time relative to the total number of characters, and use linear extra space to store the result.”

---

## 🧠 Bonus (If interviewer pushes deeper)

### Why not O(N²)?

* No repeated scanning
* No string concatenation (`+`)
* `StringBuilder` avoids re-copying

### Worst case input?

* Many small strings
* Still linear overall
