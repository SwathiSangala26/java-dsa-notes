# 🧩 STEP 1: JVM Starts `main()` Method

When `main()` starts, JVM creates a **stack frame**.

```
STACK
┌──────────────────────────────┐
│ main() stack frame created   │
└──────────────────────────────┘

HEAP
(empty for now)
```

📌 Stack frame stores:

* Local variables
* References
* Method execution context

---

# 🧩 STEP 2: String Literal Allocation

### Code:

```java
String str = "madam";
```

### What happens internally:

1. JVM checks **String Constant Pool**
2. `"madam"` not found → created
3. Stored in **Heap (String Pool)**
4. Reference `str` stored in **Stack**

```
STACK                          HEAP (String Pool)
┌──────────────────────────┐   ┌──────────────────┐
│ str ────────────────┐   │   │  "madam"          │
│                     │   │   │  m a d a m        │
└─────────────────────│───┘   └──────────────────┘
                      └──────────────▶
```

📌 Important:

* Only **one `"madam"` object exists**
* Multiple references can point to it

---

# 🧩 STEP 3: Primitive Variable Allocation

### Code:

```java
int left = 0;
int right = 4;
boolean isPalindrome = true;
```

### Memory behavior:

* `int` and `boolean` are **primitives**
* Stored **directly in stack**
* No heap allocation

```
STACK (main frame)
┌────────────────────────────┐
│ str           → "madam"    │
│ left          → 0          │
│ right         → 4          │
│ isPalindrome  → true       │
└────────────────────────────┘
```

📌 `"madam".length()` = 5 → last index = 4

---

# 🧩 STEP 4: While Loop Begins

### Code:

```java
while (left < right)
```

Only **values change**, not memory structure.

---

## 🔄 Iteration 1

```
left = 0 → 'm'
right = 4 → 'm'
```

```
STACK                          HEAP
┌──────────────┐               ┌──────────────┐
│ left → 0     │──────────────▶│ m a d a m    │
│ right → 4    │──────────────▶│              │
└──────────────┘               └──────────────┘
```

✔ Characters match → pointers move

---

## 🔄 Iteration 2

```
left = 1 → 'a'
right = 3 → 'a'
```

```
STACK
┌──────────────┐
│ left → 1     │
│ right → 3    │
└──────────────┘
```

✔ Match again → continue

---

## 🔄 Iteration 3

```
left = 2
right = 2
```

Condition `left < right` fails → loop exits

📌 No new objects created at any iteration

---

# 🧩 STEP 5: Mismatch Case (If Occurs)

### Code:

```java
isPalindrome = false;
break;
```

```
STACK
┌────────────────────────────┐
│ isPalindrome → false       │
└────────────────────────────┘
```

📌 Only **value update**, no memory allocation
📌 `break` exits loop, not method

---

# 🧩 STEP 6: Printing Result

```java
System.out.println("Palindrome");
```

* `"Palindrome"` is a **string literal**
* Stored in **String Pool** (once)
* Temporary stack frame created for `println()`
* Removed after execution

---

# 🧩 STEP 7: `main()` Ends → Stack Cleanup

```
STACK
(main stack frame destroyed)

HEAP
┌──────────────────┐
│ "madam"          │  ← remains in String Pool
└──────────────────┘
```

📌 Stack memory is cleared immediately
📌 Heap objects cleaned later by GC if unused

---

# 🧠 MEMORY SUMMARY (VERY IMPORTANT)

| Item            | Memory Area        | Reason             |
| --------------- | ------------------ | ------------------ |
| `str`           | Stack              | Reference variable |
| `"madam"`       | Heap (String Pool) | String literal     |
| `left`, `right` | Stack              | Primitive data     |
| `isPalindrome`  | Stack              | Primitive boolean  |
| `charAt()`      | Heap read          | No allocation      |
