## 📌 Code Under Discussion

```java
class ReverseString {
    public static void main(String[] args) {
        String str = "abcde";

        char[] arr = str.toCharArray();
        int left = 0, right = arr.length - 1;

        while (left < right) {
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }

        System.out.println(new String(arr));
    }
}
```

---

![Image](https://www.baeldung.com/wp-content/uploads/2018/07/java-heap-stack-diagram.png)

![Image](https://journaldev.nyc3.cdn.digitaloceanspaces.com/2012/11/String-Pool-Java1-450x249.png)

![Image](https://www.researchgate.net/publication/315467386/figure/fig2/AS%3A866238142091264%401583538675042/This-diagram-shows-the-Java-heap-memory-layout-when-examining-OOPs-Here-we-show-a.ppm)

---

# 🧠 Java Memory Areas (Quick Recall)

```
┌────────────┐
│   Stack    │ → local variables, references
├────────────┤
│    Heap    │ → objects, arrays
├────────────┤
│ StringPool │ → string literals
└────────────┘
```

---

## 🔹 STEP 1: Program Starts (`main()`)

### Stack Frame Created

```
STACK
┌──────────────────────────┐
│ main()                   │
│ (empty initially)        │
└──────────────────────────┘
```

---

## 🔹 STEP 2: `String str = "abcde";`

### What happens internally?

1. `"abcde"` is a **string literal**
2. Stored in **String Constant Pool**
3. `str` stores a **reference** to it (on stack)

### Memory View

```
STACK                         STRING POOL
┌──────────────────────┐      ┌───────────────┐
│ str ────────────────┼─────▶│ "abcde"        │
└──────────────────────┘      └───────────────┘
```

📝 **Important**

* String is **immutable**
* Pool improves memory reuse

---

## 🔹 STEP 3: `char[] arr = str.toCharArray();`

### What happens?

1. `toCharArray()` **creates a NEW array**
2. Each character is **copied**
3. Array stored in **Heap**
4. `arr` holds reference (on stack)

### Memory View

```
STACK                         HEAP
┌──────────────────────┐      ┌──────────────────────────┐
│ arr ────────────────┼─────▶│ ['a','b','c','d','e']     │
└──────────────────────┘      └──────────────────────────┘
```

🚨 **Key Point**

* This array is **mutable**
* Changes here do NOT affect the original string

---

## 🔹 STEP 4: `int left = 0, right = arr.length - 1;`

### Values Stored Directly (Primitive)

```
STACK
┌──────────────────────────┐
│ left  = 0                │
│ right = 4                │
│ arr   = reference        │
│ str   = reference        │
└──────────────────────────┘
```

✔ Primitives → **Stack only**
✔ No heap allocation

---

## 🔹 STEP 5: `while (left < right)` → FIRST ITERATION

### Initial Array State

```
Index:   0   1   2   3   4
Array:  [a] [b] [c] [d] [e]
         ↑               ↑
       left            right
```

---

## 🔹 STEP 6: `char temp = arr[left];`

```
temp = 'a'
```

```
STACK
┌──────────────────────────┐
│ temp = 'a'               │
│ left = 0                 │
│ right = 4                │
└──────────────────────────┘
```

✔ `temp` is **primitive** → stack

---

## 🔹 STEP 7: Swap Happens

### `arr[left] = arr[right];`

```
Array becomes:
[e] [b] [c] [d] [e]
```

### `arr[right] = temp;`

```
Array becomes:
[e] [b] [c] [d] [a]
```

### Visual

```
Before:  [a] [b] [c] [d] [e]
After :  [e] [b] [c] [d] [a]
```

🧠 Heap object is **modified in-place**

---

## 🔹 STEP 8: Move Pointers

```
left++  → 1
right-- → 3
```

```
Index:   0   1   2   3   4
Array:  [e] [b] [c] [d] [a]
              ↑       ↑
            left    right
```

---

## 🔹 STEP 9: Loop Repeats (Second Iteration)

Swap `b ↔ d`

```
Array:
[e] [d] [c] [b] [a]
```

Pointers move again:

```
left = 2
right = 2
```

---

## 🔹 STEP 10: Loop Stops

```
Condition: left < right ❌
2 < 2 → false
```

✔ No more memory changes

---

## 🔹 STEP 11: `new String(arr)`

### What happens?

1. **New String object created**
2. Stored in **Heap**
3. Characters copied from array

```
HEAP
┌──────────────────────────┐
│ "edcba" (new String)     │
└──────────────────────────┘
```

📝 This string is **NOT** in String Pool (unless interned)

---

## 🔹 FINAL MEMORY SNAPSHOT

```
STACK
┌──────────────────────────┐
│ str   → "abcde"          │
│ arr   → ['e','d','c','b','a'] │
│ left  = 2                │
│ right = 2                │
└──────────────────────────┘

HEAP
┌──────────────────────────┐
│ char[] ['e','d','c','b','a'] │
│ String "edcba"            │
└──────────────────────────┘

STRING POOL
┌──────────────────────────┐
│ "abcde"                  │
└──────────────────────────┘
```
