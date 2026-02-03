## ⏱️ Time Complexity → **O(n)**

### Why?

Let `n` be the length of the string.

### Key observations:

1. The **right pointer (`r`)** moves from `0 → n-1`

   * It **never moves backward**
   * Total moves = `n`

2. The **left pointer (`l`)** also moves from `0 → n-1`

   * It only moves **forward**
   * Across the entire algorithm, it moves at most `n` times

3. Even though there is a `while` loop:

   * Each character is **added once**
   * Each character is **removed once**
   * So total operations are **linear**

### Map operations:

* `put`, `get`, `getOrDefault` → **O(1)** average time

---

### Final Time Complexity

```
O(n + n) = O(n)
```

✔ Linear time
✔ No nested re-processing

---

## 🧠 Space Complexity → **O(m)**

Where:

* `m` = number of **unique characters** in the string

---

### Why?

1. We use a `HashMap<Character, Integer>` called `count`
2. This map stores **only character frequencies**
3. At worst, the map contains **one entry per unique character**

Example:

* `"AAAA"` → m = 1
* `"ABCDE"` → m = 5

So memory grows with **unique characters**, not string length.

---

### What is stored in memory?

* HashMap entries → `m`
* Integers & pointers → constant
* Variables (`l`, `r`, `res`, `maxf`) → constant

---

### Final Space Complexity

```
O(m)
```

---

## 📌 Special Case (Interview Bonus ⭐)

If the problem guarantees **uppercase English letters only**:

```
m ≤ 26
```

So space becomes:

```
O(1)  (constant space)
```

---

## 🧾 Summary Table

| Aspect          | Complexity | Reason                             |
| --------------- | ---------- | ---------------------------------- |
| Time            | O(n)       | Each pointer moves at most n times |
| Space           | O(m)       | HashMap stores m unique characters |
| Optimized Space | O(1)       | If alphabet size is fixed          |
