# 🧠 Memory Allocation

### For: `longestConsecutive(int[] nums)`

---

## 🔹 Before method call

### `main()` (caller)

```
STACK
┌───────────────────────────┐
│ main()                    │
│ nums → reference          │
└───────────────────────────┘

HEAP
┌───────────────────────────┐
│ int[] nums = {0,3,2,5,...}│
└───────────────────────────┘
```

* `nums` array is created in **heap**
* Stack stores only a **reference** to it

---

## 🔹 Method is called

```java
longestConsecutive(nums)
```

A new **stack frame** is created.

```
STACK
┌───────────────────────────┐
│ longestConsecutive()      │
│ nums → reference          │
│ longest (not yet assigned)│
│ numSet (not yet assigned) │
└───────────────────────────┘
```

---

## 🔹 Line 1: Create HashSet

```java
Set<Integer> numSet = new HashSet<>();
```

### What happens:

* `numSet` → reference stored in **stack**
* `HashSet object` → created in **heap**

```
STACK
┌───────────────────────────┐
│ numSet → 0xA12            │
└───────────────────────────┘

HEAP
┌───────────────────────────┐
│ HashSet object            │
│  - buckets[]              │
│  - size = 0               │
└───────────────────────────┘
```

---

## 🔹 Line 2–4: Adding elements to HashSet

```java
for (int num : nums) {
    numSet.add(num);
}
```

### Each iteration:

1. `num` → stored in **stack**
2. Hash is calculated
3. Integer object is stored in heap (autoboxing)

Example for `num = 3`:

```
STACK
│ num = 3                   │

HEAP
│ Integer(3)                │
│ HashSet bucket → reference│
```

### After loop completes:

```
HEAP
┌───────────────────────────┐
│ HashSet                   │
│  buckets:                 │
│   ├─ Integer(0)           │
│   ├─ Integer(1)           │
│   ├─ Integer(2)           │
│   ├─ Integer(3)           │
│   ├─ Integer(4)           │
│   ├─ Integer(5)           │
│   └─ Integer(6)           │
└───────────────────────────┘
```

Duplicates are ignored (no new allocation).

---

## 🔹 Line 5: Initialize longest

```java
int longest = 0;
```

* Primitive `int`
* Stored directly in **stack**

```
STACK
│ longest = 0               │
```

---

## 🔹 Line 6: Start iterating over HashSet

```java
for (int num : numSet)
```

* Iterator object created in heap
* `num` reused in stack each iteration

```
STACK
│ num = current element     │

HEAP
│ HashSet Iterator          │
```

---

## 🔹 Line 7: Check start of sequence

```java
if (!numSet.contains(num - 1))
```

### What happens:

* `num - 1` calculated in stack
* `contains()`:

  * Computes hash
  * Looks into bucket
  * No new allocation

```
STACK
│ temp = num - 1            │
```

---

## 🔹 Line 8: length initialization

```java
int length = 1;
```

* Stored in **stack**
* Exists only inside `if` block

```
STACK
│ length = 1                │
```

---

## 🔹 Line 9–11: While loop expansion

```java
while (numSet.contains(num + length)) {
    length++;
}
```

Each iteration:

* `num + length` computed in stack
* `contains()` checks heap
* `length` updated in stack

Example:

```
STACK
│ num = 0                   │
│ length = 1 → 2 → 3 → ...  │
```

No new heap allocations occur here.

---

## 🔹 Line 12: Update longest

```java
longest = Math.max(longest, length);
```

* `Math.max` works on stack values
* No heap allocation
* `longest` updated in stack

```
STACK
│ longest = 7               │
```

---

## 🔹 Loop ends

* `length` goes out of scope
* `num` reused
* Iterator finishes

---

## 🔹 Return statement

```java
return longest;
```

* Value copied from stack to caller
* Stack frame destroyed

```
STACK
┌───────────────────────────┐
│ main()                    │
│ result = 7                │
└───────────────────────────┘
```

---

## 🔹 Garbage Collection (Later)

Objects eligible for GC:

* HashSet
* Integer objects
* Iterator

Once method finishes and no references remain.

---

# 🧠 Final Memory Summary (For Notes)

### Stack:

* `nums` reference
* `numSet` reference
* `longest`
* `num`
* `length`

### Heap:

* `int[] nums`
* `HashSet`
* `Integer objects`
* `Iterator`

---

## 🎯 Interview-Ready Memory Explanation (1–2 lines)

> “The array and HashSet are allocated in heap, while primitive variables and references are stored on the stack. HashSet stores boxed Integer objects in heap, and only references are manipulated during lookups.”
