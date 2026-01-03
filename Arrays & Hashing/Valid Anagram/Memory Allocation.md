## 1️⃣ Java Heap Is Logically Divided

```
HEAP
------------------------------------------------
|              STRING POOL                     |
|----------------------------------------------|
|  "anagram"     "nagaram"                     |
------------------------------------------------
|              NORMAL HEAP                     |
|----------------------------------------------|
|  int[] count                                  |
|  other objects / arrays                      |
------------------------------------------------
```

📌 **Important**

* String Pool is **inside the heap**
* It is a **special area**, not a separate memory

---

## 2️⃣ String Literal Creation (`"anagram"`)

```java
String s = "anagram";
```

### What happens?

```
1. JVM checks String Pool
2. "anagram" not found
3. Creates String object in STRING POOL
4. Reference stored in stack
```

```
STACK                     HEAP (String Pool)
------------------------------------------------
s  --------------------->  "anagram"
```

---

## 3️⃣ Second String Literal (`"nagaram"`)

```java
String t = "nagaram";
```

```
STACK                     HEAP (String Pool)
------------------------------------------------
t  --------------------->  "nagaram"
```

📌 **Heap now contains**

* `"anagram"` → String Pool
* `"nagaram"` → String Pool

---

## 4️⃣ Method Call (`isAnagram(s, t)`)

```
STACK (new frame)
------------------------------------------------
s  -> reference
t  -> reference
```

```
STACK → HEAP
------------------------------------------------
s  --------------------->  "anagram" (String Pool)
t  --------------------->  "nagaram" (String Pool)
```

✔ No new String objects created
✔ Same pooled objects reused

---

## 5️⃣ Frequency Array Allocation

```java
int[] count = new int[26];
```

### Where does this go?

➡ **NORMAL HEAP (NOT String Pool)**

```
STACK                         HEAP (Normal)
------------------------------------------------
count --------------------->  int[26]
                              [0][0][0]...[0]
```

📌 Arrays are **never** stored in the String Pool.

---

## 6️⃣ During Loop Execution

```java
count[s.charAt(i) - 'a']++;
```

* `charAt()` returns a **primitive char**
* `'a'` is a **primitive char**
* `i` is a **primitive int**

```
STACK ONLY
------------------------------------------------
i, char, index, val
```

❌ No heap allocation
❌ No new objects
✔ Existing array updated

---

## 7️⃣ After Method Ends

```java
return true;
```

```
STACK
------------------------------------------------
(isAnagram frame destroyed)
```

### Heap status

```
HEAP
------------------------------------------------
STRING POOL:
  "anagram"
  "nagaram"

NORMAL HEAP:
  int[] count  → unreachable → GC eligible
```

---

## 8️⃣ Very Important Comparison

### String Literal

```java
String s = "anagram";
```

✔ Stored in **String Pool**

---

### String Object

```java
String s = new String("anagram");
```

```
HEAP (Normal)
--------------------
new String("anagram")
```

📌 Even though `"anagram"` exists in pool, `new` forces a **new heap object**

---

## 9️⃣ Final Classification Table (WRITE THIS)

| Item              | Location               |
| ----------------- | ---------------------- |
| `"anagram"`       | Heap → **String Pool** |
| `"nagaram"`       | Heap → **String Pool** |
| `int[] count`     | Heap → **Normal Heap** |
| `s`, `t`          | Stack (references)     |
| `i`, `val`, chars | Stack (primitives)     |

---

## 🔟 One-Line Exam / Interview Answer

> “String literals are stored in the String Pool inside the heap, while arrays like the frequency array are stored in the normal heap.”

---

## 📝 Key Notes (Must Remember)

* String Pool is part of heap
* String literals go to String Pool
* `new String()` → normal heap
* Arrays always go to normal heap
* Stack stores references & primitives only
