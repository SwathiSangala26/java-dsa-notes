🧠 Memory Allocation

### Code logic (conceptual):

```java
s1.length() == s2.length() && (s1 + s1).contains(s2)
```

---

## 🔹 STEP 1: `String s1 = "abcd";`

```
STACK                          HEAP
-----                          ----
s1 ───────────────▶           [String Constant Pool]
                                   "abcd"
```

---

## 🔹 STEP 2: `String s2 = "cdab";`

```
STACK                          HEAP
-----                          ----
s1 ───────────────▶           [String Constant Pool]
s2 ───────────────▶                "abcd"
                                    "cdab"
```

---

## 🔹 STEP 3: `s1.length() == s2.length()`

```
STACK                          HEAP
-----                          ----
s1 ───────────────▶           [String Constant Pool]
s2 ───────────────▶                "abcd"
                                    "cdab"
```

✔ No allocation
✔ Only reads stored length values

---

## 🔹 STEP 4: `s1 + s1`  **(NEW STRING CREATED)**

```
STACK                          HEAP
-----                          ----
s1   ───────────────▶         [String Constant Pool]
s2   ───────────────▶              "abcd"
temp ──────────────▶               "cdab"

                                [Normal Heap]
                                    "abcdabcd"
```

✔ `"abcd"` unchanged
✔ `"abcdabcd"` is **NOT** in String Pool

---

## 🔹 STEP 5: `.contains(s2)`

```
STACK                          HEAP
-----                          ----
s1   ───────────────▶         [String Constant Pool]
s2   ───────────────▶              "abcd"
temp ──────────────▶               "cdab"

                                [Normal Heap]
                                    "abcdabcd"
```

✔ No new memory
✔ Only character comparisons

---

## 🔹 STEP 6: End of expression

```
STACK                          HEAP
-----                          ----
s1 ───────────────▶           [String Constant Pool]
s2 ───────────────▶                "abcd"
                                    "cdab"

                                [Normal Heap]
                                    "abcdabcd"  → eligible for GC
```
