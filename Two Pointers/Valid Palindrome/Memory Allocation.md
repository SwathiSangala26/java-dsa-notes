# 📘 Memory Allocation Notes (Step-by-Step, Visual)

## 🧠 Step 1: Method Call

```java
sol.isPalindrome("A man, a plan, a canal: Panama");
```

### Heap Memory

```
HEAP
┌────────────────────────────────────┐
│ String Object                      │
│ "A man, a plan, a canal: Panama"   │
│ (immutable, already created)       │
└────────────────────────────────────┘
```

### Stack Memory

```
STACK
┌────────────────────────────┐
│ isPalindrome frame         │
│ s → reference to heap obj  │
└────────────────────────────┘
```

👉 **Important**

* No new string is created
* Only a **reference** is copied to the stack

---

## 🧠 Step 2: Local Variables Created

```java
int l = 0;
int r = s.length() - 1;
```

### Stack Memory Now

```
STACK
┌────────────────────────────┐
│ isPalindrome frame         │
│ s → heap string reference  │
│ l = 0                      │
│ r = 29                     │
└────────────────────────────┘
```

👉 `int` variables are:

* Primitive
* Stored directly in stack
* Fixed size (4 bytes each)

---

## 🧠 Step 3: First `charAt()` Call

```java
s.charAt(l)
```

### What Happens Internally

* JVM reads character at index `l`
* Returns a **primitive `char`**
* No object creation

### Stack (Temporary)

```
STACK
┌────────────────────────────┐
│ char = 'A'                 │
└────────────────────────────┘
```

👉 After comparison, this `char` is **discarded immediately**

---

## 🧠 Step 4: `alphaNum(char ch)` Call

```java
alphaNum(s.charAt(l))
```

### Stack Frames

```
STACK
┌────────────────────────────┐
│ alphaNum frame             │
│ ch = 'A'                   │
└────────────────────────────┘
│ isPalindrome frame         │
│ l = 0, r = 29              │
└────────────────────────────┘
```

👉 `alphaNum`:

* Uses only primitive `char`
* Returns boolean
* Frame is destroyed after return

---

## 🧠 Step 5: Character Comparison

```java
Character.toLowerCase(s.charAt(l))
```

### Memory Behavior

* `toLowerCase()` returns a **primitive char**
* No wrapper object created
* Stored briefly on stack

```
STACK
┌────────────────────────────┐
│ temp char = 'a'            │
└────────────────────────────┘
```

👉 Compared with right-side character, then discarded

---

## 🧠 Step 6: Pointer Movement

```java
l++;
r--;
```

### Stack Update

```
STACK
┌────────────────────────────┐
│ l = 1                      │
│ r = 28                     │
└────────────────────────────┘
```

👉 Same variables reused
👉 No new memory allocation

---

## 🧠 Step 7: Loop Continues

* Same stack frame reused
* Only primitive values change
* Heap string remains untouched

```
HEAP (unchanged)
┌────────────────────────────┐
│ "A man, a plan, a canal…"  │
└────────────────────────────┘
```

---

## 🧠 Step 8: Method Returns

```java
return true;
```

### Stack Cleanup

```
STACK
┌────────────────────────────┐
│ isPalindrome frame popped  │
└────────────────────────────┘
```

👉 All local variables (`l`, `r`) are destroyed
👉 Heap string remains (GC decides later)

---

## 🧾 Final Memory Summary (Exam Notes)

```
• String object → Heap (single instance, reused)
• Reference to string → Stack
• l, r, ch → Stack (primitive)
• No new objects created
• No extra arrays or strings
• Stack frames created & destroyed automatically
```

---

## 🎯 One-Line Interview Answer

> “The string resides in heap memory and is accessed via a reference on the stack. The algorithm only uses primitive local variables stored in the stack, with no additional heap allocations, resulting in O(1) extra space.”
