# 🧩 MEMORY OVERVIEW (Java)

In Java, memory is mainly divided into:

```
STACK  → stores local variables & references
HEAP   → stores objects & arrays
```

---

# 🔹 STEP 1: String Creation

```java
String str = "programming";
```

### 📍 What happens in memory?

```
STACK                          HEAP
-----                          ----
str  ────────────────▶  "programming"
(reference)                 (String object)
```

* `str` is a **reference variable**
* Actual string `"programming"` is stored in **heap (String pool)**

---

# 🔹 STEP 2: Frequency Array Creation

```java
int[] freq = new int[256];
```

### 📍 Memory allocation

```
STACK                          HEAP
-----                          ----
freq ───────────────▶  [0][0][0][0]...[0]   ← size 256
(reference)              ↑
                        all values initialized to 0
```

* `freq` holds the **address**
* The array object lives in the **heap**
* Size is **fixed (256 integers)**

---

# 🔹 STEP 3: Convert String to char array

```java
str.toCharArray()
```

### 📍 Memory allocation

```
STACK                          HEAP
-----                          ----
(temp ref) ───────────▶  ['p','r','o','g','r','a','m','m','i','n','g']
```

* A **new char[] array** is created
* Size = length of string (`n`)
* This array exists **temporarily** during loop execution

---

# 🔹 STEP 4: for-each Loop Starts

```java
for (char ch : str.toCharArray())
```

### 📍 Variable `ch` location

```
STACK
-----
ch = 'p'   → first iteration
```

* `ch` is a **primitive variable**
* Stored directly in **stack**
* Value changes each iteration

---

# 🔹 STEP 5: Character → ASCII → Array Index

```java
freq[ch]++;
```

### 📍 How memory is accessed (example: 'g')

```
ch = 'g'
↓
ASCII value of 'g' = 103
↓
freq[103]++
```

### 📍 Heap update

```
HEAP (freq array)
-----------------
index 103 → value changes

freq[103] : 0 → 1 → 2
```

---

# 🔹 STEP 6: Loop Continues (Each Character)

Visually:

```
'p' → freq[112] = 1
'r' → freq[114] = 1 → 2
'g' → freq[103] = 1 → 2
'm' → freq[109] = 1 → 2
```

Only the **array values change**, no new memory is created.

---

# 🔹 STEP 7: After Loop Ends

### 📍 Memory state

```
STACK                          HEAP
-----                          ----
str  ───────────────▶ "programming"
freq ──────────────▶  freq array (updated counts)
ch   ❌ (removed)        [103]=2, [109]=2, [114]=2
char[] ❌ (eligible for GC)
```

* `ch` goes out of scope
* `char[]` becomes **eligible for garbage collection**
* `freq` array remains

---

# 🔹 STEP 8: Printing Duplicates

```java
for (int i = 0; i < freq.length; i++)
```

### 📍 Memory use

```
STACK
-----
i = 0 → 1 → 2 → ... → 255
```

When:

```
i = 103 → freq[103] > 1 → print 'g'
i = 109 → freq[109] > 1 → print 'm'
i = 114 → freq[114] > 1 → print 'r'
```

---

# 🧠 COMPLETE MEMORY FLOW (ONE LOOK)

```
String object → HEAP
Array object  → HEAP
References    → STACK
Loop variable → STACK
Counts update → HEAP (same array)
```

---

# ✅ MEMORY TAKEAWAYS (VERY IMPORTANT)

* Objects & arrays → **Heap**
* Primitive variables → **Stack**
* `toCharArray()` creates **extra O(n) memory**
* `freq` array uses **constant memory**
* No new memory inside loop (only updates)
