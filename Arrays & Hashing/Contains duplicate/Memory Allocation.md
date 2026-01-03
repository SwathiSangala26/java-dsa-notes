# 📘 Memory Allocation

### Example Code

```java
Set<Integer> set = new HashSet<>();
set.add(1);
set.add(2);
set.add(1);
```

---

## 1️⃣ Java Memory Areas Used

Java mainly uses two memory areas here:

```
+------------------+
|      STACK       |
+------------------+
| Local variables  |
| Object references|
+------------------+

+------------------+
|       HEAP       |
+------------------+
| Objects          |
| Arrays           |
| HashSet, HashMap |
+------------------+
```

---

## 2️⃣ Memory Allocation for Reference Variable

```java
Set<Integer> set;
```

* `set` is a **reference variable**
* Stored in **stack memory**
* Does NOT store the object itself

```
STACK
----------------
set  ->  (address)
```

---

## 3️⃣ Memory Allocation for Object Creation

```java
new HashSet<>();
```

Creates objects in **heap memory**:

```
HEAP
-------------------------------
HashSet object
   |
   v
HashMap object
   |
   v
Bucket Array (Node[])
```

* Default bucket array size = 16
* Bucket array stores references to nodes

---

## 4️⃣ Initial Bucket Array State

```
Bucket Array
--------------------------------
[0] -> null
[1] -> null
[2] -> null
...
[15] -> null
```

---

## 5️⃣ Memory Allocation During `set.add(1)`

### Steps:

1. `int 1` is converted to `Integer(1)`
2. A new `Integer` object is created in heap
3. A new `Node` object is created
4. Node reference is stored in a bucket

```
HEAP
--------------------------------
Bucket[1] -> Node
              |
              v
          Integer(1)
```

---

## 6️⃣ Memory Allocation During `set.add(2)`

```
HEAP
--------------------------------
Bucket[1] -> Node -> Integer(1)
Bucket[2] -> Node -> Integer(2)
```

* Each unique element creates:

  * One `Integer` object
  * One `Node` object

---

## 7️⃣ Memory Behavior for Duplicate (`set.add(1)` again)

### Steps:

1. Hash is calculated
2. Correct bucket is found
3. Existing node is checked using `equals()`
4. Match found

```
Bucket[1] -> Node -> Integer(1)
```

* ❌ No new `Integer` created
* ❌ No new `Node` created
* ❌ Heap size unchanged

---

## 8️⃣ Collision Memory Behavior

When two values map to same bucket:

```
Bucket[10] -> Node -> Integer(10)
                 |
                 v
               Node -> Integer(26)
```

* Multiple nodes stored in same bucket
* Nodes connected using references

---

## 9️⃣ Rehashing Memory Allocation

When bucket array fills beyond threshold:

```
Old bucket array (size 16)
        |
        v
New bucket array (size 32)
```

* New array allocated in heap
* Old nodes re-linked into new buckets
* Old array becomes eligible for GC

---

## 🔟 Final Memory Map Summary

```
STACK
-------------------------
set (reference)

HEAP
-------------------------
HashSet
  |
  v
HashMap
  |
  v
Bucket Array
  |
  v
Node -> Integer
Node -> Integer
```

---

## 📝 Key Notes (Write These)

* Reference variables live in **stack**
* Objects live in **heap**
* HashSet internally uses **HashMap**
* Bucket array is an internal object
* Each unique element allocates:

  * One Node
  * One boxed Integer
* Duplicate elements do not allocate memory
* Old bucket arrays are garbage collected
