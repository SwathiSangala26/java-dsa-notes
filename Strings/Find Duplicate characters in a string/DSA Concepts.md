## 🧠 DSA Concepts Used

### 1️⃣ String Traversal

**What it means:**
Visiting **each character of the string one by one**.

**Where it is used:**

```java
for (char ch : str.toCharArray()) {
    freq[ch]++;
}
```

**Why it matters:**

* Ensures every character is processed
* Leads to **linear time complexity**

---

### 2️⃣ Linear Traversal

**What it means:**
Processing elements **sequentially from start to end**, without skipping.

**Where it is used:**

* Traversing the string
* Traversing the frequency array

**Why it matters:**

* No nested loops
* Efficient → **O(n)** time

---

### 3️⃣ Array-Based Hashing

**What it means:**
Using an **array as a hash table** instead of a HashMap.

**Where it is used:**

```java
int[] freq = new int[256];
```

**Why it matters:**

* Direct access using index
* Faster than HashMap
* Constant-time lookup

---

### 4️⃣ Frequency Counting

**What it means:**
Counting how many times each character appears.

**Where it is used:**

```java
freq[ch]++;
```

**Why it matters:**

* Helps detect duplicates
* Frequency > 1 → duplicate character

---

### 5️⃣ ASCII Character Mapping

**What it means:**
Mapping a character to its **ASCII numeric value**.

**Where it is used:**

```java
freq[ch]++;
```

**Why it matters:**

* `char` is automatically converted to an `int`
* That value becomes the array index

Example:

```
'g' → ASCII 103 → freq[103]
```

---

### 6️⃣ Index-to-Value Relationship

**What it means:**
Understanding that:

* **Index** represents the character
* **Value** represents its frequency

**Where it is used:**

```java
(char) i + " -> " + freq[i]
```

**Why it matters:**

* Correctly prints character and count
* Prevents logic errors with enhanced loops

---

### 7️⃣ Constant Space Optimization

**What it means:**
Using a fixed-size array that does not grow with input.

**Where it is used:**

```java
int[] freq = new int[256];
```

**Why it matters:**

* Space complexity stays **O(1)**
* Memory efficient
