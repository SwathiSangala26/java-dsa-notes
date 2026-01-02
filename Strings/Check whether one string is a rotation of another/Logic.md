### 🔍 Logic

### ✅ **Step 1: Length check**

* If two strings are rotations, **their lengths must be equal**
* If lengths differ → ❌ **Not a rotation**

```text
s1 = "abcd"  (length = 4)
s2 = "cdab"  (length = 4) ✔
```

---

### 🔁 **Step 2: Concatenate the first string with itself**

* Create a new string: `s1 + s1`
* This contains **all possible rotations** of `s1`

```text
s1 + s1 = "abcdabcd"
```

---

### 🔎 **Step 3: Check substring**

* If `s2` exists inside `s1 + s1`
* Then `s2` is a rotation of `s1`

```text
"abcdabcd".contains("cdab") → ✔ true
```

---

### 🎯 **Final Decision**

* Lengths equal ✔
* `s2` found inside `s1 + s1` ✔
  👉 **s2 is a rotation of s1**

---

### 🧠 **Why this logic works**

* Rotating a string just shifts characters in a circular way
* All circular shifts appear as substrings in the doubled string

️
