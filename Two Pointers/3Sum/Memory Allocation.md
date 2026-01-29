# 🧠 Memory Allocation Notes – `threeSum` (Step by Step)

## Code Context (simplified)

```java
List<List<Integer>> threeSum(int[] nums)
```

---

## 1️⃣ Before Method Call

```java
int[] nums = {-1,0,1,2,-1,-4};
threeSum(nums);
```

### HEAP

```
┌────────────────────────────┐
│ int[] nums                 │
│ [-1, 0, 1, 2, -1, -4]      │
└────────────────────────────┘
```

### STACK

```
┌────────────────────────────┐
│ main() frame               │
│ nums → reference to heap   │
└────────────────────────────┘
```

---

## 2️⃣ Entering `threeSum()`

```java
public List<List<Integer>> threeSum(int[] nums)
```

### STACK (new frame created)

```
┌────────────────────────────┐
│ threeSum frame             │
│ nums → same heap array     │
└────────────────────────────┘
```

👉 No new array is created — only the **reference is copied**

---

## 3️⃣ Sorting the Array

```java
Arrays.sort(nums);
```

### HEAP (same array, modified in place)

```
┌────────────────────────────┐
│ nums                       │
│ [-4, -1, -1, 0, 1, 2]      │
└────────────────────────────┘
```

👉 **No new array**
👉 Sorting happens **in place**

---

## 4️⃣ Creating Result List

```java
List<List<Integer>> res = new ArrayList<>();
```

### STACK

```
res → reference
```

### HEAP

```
┌────────────────────────────┐
│ ArrayList res              │
│ size = 0                   │
│ []                         │
└────────────────────────────┘
```

---

## 5️⃣ Loop Variables Created

```java
int i, l, r, sum;
```

### STACK (primitives)

```
┌────────────────────────────┐
│ i                           │
│ l                           │
│ r                           │
│ sum                         │
└────────────────────────────┘
```

👉 Primitives are **stack only**

---

## 6️⃣ When a Triplet Is Found

```java
res.add(Arrays.asList(nums[i], nums[l], nums[r]));
```

### Step 6.1: `Arrays.asList(...)`

Creates a **new List object**

### HEAP

```
┌────────────────────────────┐
│ List<Integer>              │
│ [-1, -1, 2]                │
└────────────────────────────┘
```

---

### Step 6.2: Add to `res`

```java
res.add(listReference);
```

### HEAP

```
┌────────────────────────────┐
│ res (ArrayList)            │
│ ──► [-1, -1, 2]            │
└────────────────────────────┘
```

👉 `res` stores **references to inner lists**, not copies

---

## 7️⃣ Add Another Triplet

```java
res.add(Arrays.asList(-1, 0, 1));
```

### HEAP

```
┌────────────────────────────┐
│ res                        │
│ ──► [-1, -1, 2]            │
│ ──► [-1, 0, 1]             │
└────────────────────────────┘
```

---

## 8️⃣ Pointer Movement (No Allocation)

```java
l++;
r--;
```

### STACK update only

```
l = 3 → 4
r = 4 → 3
```

👉 No new memory

---

## 9️⃣ Loop Ends → Method Returns

```java
return res;
```

### STACK Cleanup

```
threeSum frame destroyed
```

### HEAP (unchanged)

```
res and inner lists remain
```

Returned to caller.

---

## 🔚 After Method Ends

### STACK

```
main() frame
result → res (heap)
```

### HEAP

```
res
 ├── [-1, -1, 2]
 └── [-1, 0, 1]
```

---

## 🧾 Final Memory Summary (Notes Format)

```
• nums array → Heap (single object)
• Sorting → In-place (no new array)
• res (ArrayList) → Heap
• Each triplet → Separate List object in heap
• i, l, r, sum → Stack (primitive)
• No extra data structures
• Stack frames auto-destroyed
```
