## ⏱️ Time Complexity — **O(n)**

* We loop through the array **once**
* For each element, we do `set.add(num)`
* `HashSet.add()` takes **O(1)** average time

So for `n` elements:

```text
O(1) + O(1) + ... n times = O(n)
```

✅ That’s why **time complexity is O(n)**

---

## 🧠 Space Complexity — **O(n)**

* In the worst case, **all elements are unique**
* We store all `n` elements in the `HashSet`

So extra memory used:

```text
n elements → O(n)
```

✅ That’s why **space complexity is O(n)**

---

## 🧪 Example

```text
nums = [1, 2, 3, 4]

Set stores → {1, 2, 3, 4}
```

---

## 🎯 One-Line Interview Explanation

> **“We iterate once through the array, and the HashSet stores up to n elements, giving O(n) time and O(n) space complexity.”**
