# 📘 Memory Allocation

## 1️⃣ Before Method Call (Heap State)

Assume this call:

```java
int[] nums = {2, 7, 11, 15};
int target = 9;
solution.twoSum(nums, target);
```

```
HEAP
--------------------------------
int[] nums  → [2, 7, 11, 15]
```

---

## 2️⃣ Method Call → Stack Frame Created

```
STACK (twoSum frame)
--------------------------------
nums   -> reference
target -> 9
prevMap -> not yet created
i, num, diff -> not yet created
```

```
STACK → HEAP
--------------------------------
nums --------------------------> int[] [2,7,11,15]
```

---

## 3️⃣ HashMap Creation

```java
HashMap<Integer, Integer> prevMap = new HashMap<>();
```

### Memory allocation

```
STACK
--------------------------------
prevMap -----------------------> (heap address)
```

```
HEAP (Normal Heap)
--------------------------------
HashMap object
  |
  v
Internal bucket array (initial size)
```

📌 **Heap objects now**

* `int[] nums`
* `HashMap prevMap`
* HashMap’s internal bucket array

---

## 4️⃣ Loop Starts (`i = 0`)

```java
for (int i = 0; i < nums.length; i++)
```

```
STACK
--------------------------------
i = 0
num, diff -> not yet assigned
```

* `i` is a primitive → **stack only**

---

## 5️⃣ Reading Current Number

```java
int num = nums[i];
```

```
STACK
--------------------------------
num = 2
```

* No new heap object
* Value read from existing array

---

## 6️⃣ Compute Complement

```java
int diff = target - num;
```

```
STACK
--------------------------------
diff = 7
```

* Pure arithmetic
* Stack only

---

## 7️⃣ HashMap Lookup

```java
prevMap.containsKey(diff)
```

```
HEAP (HashMap)
--------------------------------
(empty)
```

* Map is empty
* No new memory allocated

---

## 8️⃣ Insert into HashMap

```java
prevMap.put(num, i);
```

### What happens in memory

```
HEAP
--------------------------------
HashMap
  |
  v
Bucket[index] -> Node
                 |
                 v
             key=Integer(2)
             value=Integer(0)
```

📌 **Important**

* `int 2` → autoboxed to `Integer(2)`
* `int 0` → autoboxed to `Integer(0)`
* A **Node object** is created inside HashMap

---

## 9️⃣ Second Iteration (`i = 1`)

```
STACK
--------------------------------
i = 1
num = 7
diff = 2
```

---

## 🔍 HashMap Lookup (Success Case)

```java
prevMap.containsKey(2)
```

```
HEAP
--------------------------------
HashMap
Bucket[x] -> Node(key=2, value=0)
```

✔ Key found

---

## 🔁 Return Statement Memory Allocation

```java
return new int[] { prevMap.get(diff), i };
```

### Heap allocation

```
HEAP
--------------------------------
int[] result
[0, 1]
```

```
STACK
--------------------------------
(reference to result array)
```

📌 New heap object:

* `int[] {0, 1}`

---

## 🔟 Method Ends → Stack Frame Destroyed

```
STACK
--------------------------------
(twoSum frame removed)
```

---

## 1️⃣1️⃣ Heap After Method Ends

```
HEAP
--------------------------------
int[] nums        (still referenced in main)
HashMap prevMap  → unreachable → GC eligible
int[] result     (returned to caller)
```

---

## 🔚 Final Memory Classification (IMPORTANT)

### STACK CONTAINS

* References: `nums`, `prevMap`
* Primitives: `i`, `num`, `diff`, `target`

### HEAP CONTAINS

* `int[] nums`
* `HashMap prevMap`
* HashMap internal bucket array
* HashMap Node objects
* Autoboxed `Integer` objects
* Returned `int[] result`

---

## 📝 Notes to Write (Exam / Interview)

* Arrays and objects are stored in **heap**
* References and primitives are stored in **stack**
* HashMap stores data as **Node objects**
* Integers are **autoboxed** when stored in HashMap
* Memory grows only when inserting into HashMap
* Stack frame is destroyed after method returns
* Heap objects become GC-eligible when unreachable

---

## 🎯 One-Line Interview Explanation

> “The HashMap and result array are allocated in the heap, while loop variables and references live on the stack; entries are stored as nodes with autoboxed Integer keys and values.”

Just say 👍
