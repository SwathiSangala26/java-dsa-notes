# 🧠 Memory Allocation

### Code (context)

```java
String s1 = "abc";
String s2 = "def";
String s3 = "daebcf";
```

---

## JVM Memory Areas Used

* **STACK** → stores local variables & references
* **HEAP**

  * **String Constant Pool (SCP)** → stores string literals
  * **Normal Heap** → stores objects created at runtime

---

## 🔹 STEP 1: `String s1 = "abc";`

### What happens

* `"abc"` is a **string literal**
* Stored in **String Constant Pool**
* `s1` stores the reference

```
STACK                          HEAP
-----                          ----
s1 ───────────────▶           [String Constant Pool]
                                   "abc"
```

---

## 🔹 STEP 2: `String s2 = "def";`

```
STACK                          HEAP
-----                          ----
s1 ───────────────▶           [String Constant Pool]
s2 ───────────────▶                "abc"
                                    "def"
```

---

## 🔹 STEP 3: `String s3 = "daebcf";`

```
STACK                          HEAP
-----                          ----
s1 ───────────────▶           [String Constant Pool]
s2 ───────────────▶                "abc"
s3 ───────────────▶                "def"
                                    "daebcf"
```

✔ All three are **literals**
✔ All stored in **String Constant Pool**

---

## 🔹 STEP 4: Length Check

```java
s1.length() + s2.length() != s3.length()
```

### Memory behavior

* No new objects
* Reads stored integer values

```
STACK                          HEAP
-----                          ----
s1 ───────────────▶           [String Constant Pool]
s2 ───────────────▶                "abc"
s3 ───────────────▶                "def"
                                    "daebcf"
```

---

## 🔹 STEP 5: Pointer Variables Creation

```java
int i = 0, j = 0;
```

```
STACK                          HEAP
-----                          ----
i = 0                          [String Constant Pool]
j = 0                               "abc"
s1 ───────────────▶                "def"
s2 ───────────────▶                "daebcf"
s3 ───────────────▶
```

✔ Primitive variables → **stack only**

---

## 🔹 STEP 6: Loop Variable Creation

```java
for (int k = 0; k < s3.length(); k++)
```

```
STACK                          HEAP
-----                          ----
i = 0                          [String Constant Pool]
j = 0                               "abc"
k = 0                               "def"
s1 ───────────────▶                "daebcf"
s2 ───────────────▶
s3 ───────────────▶
```

✔ `k` lives in stack
✔ Loop does **not** allocate heap memory

---

## 🔹 STEP 7: Character Comparisons

```java
s3.charAt(k)
s1.charAt(i)
s2.charAt(j)
```

### Memory behavior

* No new strings created
* Characters read from existing objects

```
STACK                          HEAP
-----                          ----
i, j, k                        [String Constant Pool]
s1 ───────────────▶                "abc"
s2 ───────────────▶                "def"
s3 ───────────────▶                "daebcf"
```

✔ `charAt()` does NOT allocate memory

---

## 🔹 STEP 8: Pointer Updates

```java
i++;
j++;
```

```
STACK                          HEAP
-----                          ----
i = 1 / 2 / 3                  [String Constant Pool]
j = 1 / 2 / 3                       "abc"
k increments                        "def"
s1 ───────────────▶                "daebcf"
s2 ───────────────▶
s3 ───────────────▶
```

✔ Only integer values change
✔ Heap remains unchanged

---

## 🔹 STEP 9: End of `main()`

### What happens

* Stack frame is destroyed
* References removed
* String literals remain (JVM-managed)

```
STACK                          HEAP
-----                          ----
(empty)                        [String Constant Pool]
                                   "abc"
                                   "def"
                                   "daebcf"
```

✔ No garbage collection for literals
✔ JVM may reuse SCP strings

---

## 🧠 Key Memory Concepts to Write in Notes

* String literals → **String Constant Pool**
* No `new String()` used → no normal heap strings
* Loop & pointers → stack only
* `charAt()` → read-only operation
* No temporary strings created

---

## 🎯 One-Line Memory Summary (Perfect Notes Line)

> In valid shuffle logic, all input strings are stored in the String Constant Pool, while only primitive pointers and loop variables occupy stack memory; no additional heap objects are created during execution.
