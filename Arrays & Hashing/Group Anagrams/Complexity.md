## 📌 Code we are analyzing (conceptually)

```java
for (String s : strs) {
    int[] count = new int[26];
    for (char c : s.toCharArray()) {
        count[c - 'a']++;
    }
    String key = Arrays.toString(count);
    res.putIfAbsent(key, new ArrayList<>());
    res.get(key).add(s);
}
```

---

# ⏱️ Time Complexity — **O(m × n)**

### What do `m` and `n` mean?

* `m` = number of strings in the input array
* `n` = length of the longest string

---

## Step-by-step time analysis

### 1️⃣ Outer loop

```java
for (String s : strs)
```

* Runs **m times** (once per string)

---

### 2️⃣ Creating frequency array

```java
int[] count = new int[26];
```

* Always size 26
* Constant time → **O(1)**

---

### 3️⃣ Counting characters

```java
for (char c : s.toCharArray())
```

* Runs once for each character in the string
* Worst case = `n` characters

➡ **O(n)** per string

---

### 4️⃣ Converting count to key

```java
Arrays.toString(count);
```

* Always converts 26 elements
* Constant time → **O(1)**

---

### 5️⃣ HashMap operations

```java
putIfAbsent(), get(), add()
```

* Average case **O(1)**

---

## ✅ Total Time

For **one string**:

```
O(n)
```

For **m strings**:

```
O(m × n)
```

---

# 🧠 Space Complexity — **O(m × n)**

Let’s break this into parts.

---

## 1️⃣ Frequency array

```java
int[] count = new int[26];
```

* Size is fixed (26)
* Recreated per string but discarded
* Constant extra space → **O(1)**

---

## 2️⃣ HashMap storage (important part)

```java
Map<String, List<String>> res
```

What is stored?

* **Keys** → frequency strings (length ~26)
* **Values** → lists of original strings

All input strings are stored in the map.

➡ Total stored characters ≈ all characters in input
➡ **O(m × n)** space

---

## 3️⃣ Output list

```java
new ArrayList<>(res.values())
```

* Contains all grouped strings
* Same size as input

➡ **O(m × n)**

---

## ✅ Total Space

```
O(m × n)
```

---

# 📝 Summary Table (Good for Notes)

| Aspect           | Complexity    |
| ---------------- | ------------- |
| Time             | **O(m × n)**  |
| Space            | **O(m × n)**  |
| Sorting avoided? | ✅ Yes         |
| Extra array size | Constant (26) |

---

## 🎯 One-line Interview Explanation

> **“For each string, we count characters in linear time, so the total time is O(m × n), and since we store all strings in the hash map, the space complexity is also O(m × n).”**
