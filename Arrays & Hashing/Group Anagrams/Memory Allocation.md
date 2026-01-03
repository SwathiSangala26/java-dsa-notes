# 📘 Memory Allocation

### Problem: **Group Anagrams (HashMap + Frequency Array)**

---

## 📌 Code Under Discussion

```java
Map<String, List<String>> res = new HashMap<>();

for (String s : strs) {
    int[] count = new int[26];
    for (char c : s.toCharArray()) {
        count[c - 'a']++;
    }
    String key = Arrays.toString(count);
    res.putIfAbsent(key, new ArrayList<>());
    res.get(key).add(s);
}

return new ArrayList<>(res.values());
```

---

# 1️⃣ Before Method Call

Assume input:

```java
String[] strs = {"act","pots","tops","cat","stop","hat"};
```

### HEAP

```
--------------------------------
String Pool:
"act"  "pots"  "tops"  "cat"  "stop"  "hat"

Normal Heap:
String[] strs  → ["act","pots","tops","cat","stop","hat"]
```

---

# 2️⃣ Method Call → Stack Frame Created

```java
groupAnagrams(strs)
```

### STACK

```
--------------------------------
strs  → reference
res   → not yet created
s     → not yet created
count → not yet created
key   → not yet created
```

---

# 3️⃣ HashMap Creation

```java
Map<String, List<String>> res = new HashMap<>();
```

### STACK

```
--------------------------------
res  ------------------> (heap address)
```

### HEAP

```
--------------------------------
HashMap res
 |
 v
Bucket Array (initial capacity)
```

📌 **Heap objects now**

* `String[] strs`
* `HashMap res`
* HashMap internal bucket array

---

# 4️⃣ First Loop Iteration (`s = "act"`)

### STACK

```
--------------------------------
s  ------------------> "act" (String Pool)
```

---

## 4.1 Frequency Array Creation

```java
int[] count = new int[26];
```

### STACK

```
--------------------------------
count ---------------> (heap address)
```

### HEAP

```
--------------------------------
int[] count
[0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0]
```

📌 **New heap object created**

---

## 4.2 Character Counting

```java
for (char c : s.toCharArray())
```

* `char c` → stack
* `'a'`, `'c'`, `'t'` → stack primitives

### HEAP (same array updated)

```
--------------------------------
count:
a → 1
c → 1
t → 1
```

❌ No new heap allocation
✔ Existing array modified

---

## 4.3 Key Creation

```java
String key = Arrays.toString(count);
```

### HEAP

```
--------------------------------
String key = "[1,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0]"
```

📌 **New String object created in heap (NOT String Pool)**

---

## 4.4 putIfAbsent

```java
res.putIfAbsent(key, new ArrayList<>());
```

### HEAP

```
--------------------------------
HashMap res
 |
 v
Bucket[index] → Entry
                |
                v
              key (String)
              value → ArrayList []
```

📌 **New ArrayList object created**

---

## 4.5 add(s)

```java
res.get(key).add("act");
```

### HEAP

```
--------------------------------
ArrayList → ["act"]
```

---

# 5️⃣ Second Iteration (`s = "cat"`)

* New `int[26]` created
* Same frequency → same `key` string content
* `putIfAbsent` does NOTHING
* `add("cat")` appends to existing list

### HEAP

```
--------------------------------
key → ["act", "cat"]
```

---

# 6️⃣ Iterations Continue…

### After processing all strings:

### HEAP

```
--------------------------------
HashMap res

key1 → ["act", "cat"]
key2 → ["pots", "tops", "stop"]
key3 → ["hat"]
```

📌 Multiple `int[] count` arrays were created
📌 All became **GC-eligible** after each loop iteration

---

# 7️⃣ Returning Result

```java
return new ArrayList<>(res.values());
```

### HEAP

```
--------------------------------
ArrayList result
[
  ["act", "cat"],
  ["pots", "tops", "stop"],
  ["hat"]
]
```

📌 New ArrayList created to hold values

---

# 8️⃣ Method Ends → Stack Frame Destroyed

### STACK

```
--------------------------------
(groupAnagrams frame removed)
```

### HEAP

```
--------------------------------
String Pool → still exists
String[] strs → still exists
Result list → returned to caller
HashMap res → GC-eligible after return (if no reference)
```

---

# 🔟 Final Memory Classification (WRITE THIS)

### STACK

* References: `strs`, `res`, `s`, `count`, `key`
* Primitives: `char c`

### HEAP (Normal)

* `String[] strs`
* `HashMap res`
* HashMap bucket array
* HashMap nodes
* `ArrayList` objects
* Result `ArrayList`
* Temporary `int[] count` arrays
* Key `String` objects

### HEAP (String Pool)

* `"act"`, `"cat"`, `"pots"`, `"tops"`, `"stop"`, `"hat"`

---

# 📝 Key Notes for Exam / Interview

* HashMap and ArrayList are stored in heap
* `int[] count` is created **per string**
* `Arrays.toString(count)` creates a new String key
* `putIfAbsent` avoids overwriting lists
* Temporary arrays become GC-eligible
* Final output list is a new heap object

---

## 🎯 One-Line Interview Explanation

> “For each string, a frequency array and key string are created in the heap, grouped using a HashMap whose values are ArrayLists; temporary arrays are garbage-collected after each iteration.”
