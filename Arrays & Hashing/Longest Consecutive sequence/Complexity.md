## ⏱️ Time Complexity

### 🔹 Step 1: Insert elements into HashSet

```java
for (int num : nums) {
    numSet.add(num);
}
```

* Runs **n times**
* Each `add()` is **O(1)** average

👉 **Total: O(n)**

---

### 🔹 Step 2: Loop through HashSet

```java
for (int num : numSet) {
```

* Runs once per **unique element**
* At most **n iterations**

---

### 🔹 Step 3: `num - 1` check

```java
if (!numSet.contains(num - 1)) {
```

* `contains()` is **O(1)**

---

### 🔹 Step 4: `while` loop — the tricky part

```java
while (numSet.contains(num + length)) {
    length++;
}
```

This **looks** like it could be O(n²), but it’s **not**.

#### Why?

* The `while` loop runs **only for sequence starts**
* Each number is visited **once overall** across all while loops

📌 Example:

```
Sequence: 0 → 1 → 2 → 3 → 4 → 5 → 6
```

* The `while` loop runs **only once**, starting at `0`
* It never runs again for `1,2,3...`

👉 **Total work of all while loops combined = O(n)**

---

### ✅ Final Time Complexity

```
O(n) + O(n) = O(n)
```

✔ **Linear time**

---

## 🧠 Why it is NOT O(n²)

Without this check:

```java
if (!numSet.contains(num - 1))
```

* You’d start counting from **every number**
* Same sequence would be counted repeatedly
* That would become **O(n²)**

This check is what **guarantees O(n)**.

---

## 📦 Space Complexity

### HashSet storage

```java
Set<Integer> numSet = new HashSet<>();
```

* Stores up to **n elements**

👉 **O(n)** space

### Other variables

```java
longest, length, num
```

* Constant space

---

### ✅ Final Space Complexity

```
O(n)
```

---

## 🎯 Interview-Ready Answer (Say This)

> “The time complexity is O(n) because each number is processed at most once using a HashSet for constant-time lookups.
> The space complexity is O(n) due to the HashSet storing all unique elements.”

🔥 That answer is **exactly what interviewers expect**.

---

## 🧩 Quick Summary Table

| Aspect           | Complexity            |
| ---------------- | --------------------- |
| Time             | **O(n)**              |
| Space            | **O(n)**              |
| Data Structure   | HashSet               |
| Key Optimization | `num - 1` start check |
