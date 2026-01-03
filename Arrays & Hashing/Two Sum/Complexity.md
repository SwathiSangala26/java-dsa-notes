## ⏱️ Time Complexity

### Code part that matters

```java
for (int i = 0; i < nums.length; i++) {
    int diff = target - nums[i];

    if (prevMap.containsKey(diff)) {
        return new int[] { prevMap.get(diff), i };
    }

    prevMap.put(num, i);
}
```

* The loop runs **once** for `n` elements
* `containsKey()` → **O(1)** average
* `put()` → **O(1)** average

### ✅ Total Time

```
O(n)
```

---

## 🧠 Space Complexity

### Extra memory used

```java
HashMap<Integer, Integer> prevMap = new HashMap<>();
```

* In the worst case, all elements are stored in the map
* Map stores up to `n` key–value pairs

### ✅ Total Space

```
O(n)
```

---

## 📝 Summary (For Notes)

* Single loop over array → **O(n) time**
* HashMap lookups and inserts → **O(1) average**
* HashMap stores up to `n` elements → **O(n) space**

---

## 🎯 One-Line Interview Answer

> **“The solution runs in linear time using a HashMap and requires linear extra space to store visited elements.”**
