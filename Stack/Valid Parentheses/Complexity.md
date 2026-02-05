## ⏱️ Time Complexity — **O(n)**

### Definition

* `n` = length of the input string

### Explanation

* The string is traversed **once**
* Each character is processed exactly **one time**
* All operations inside the loop are constant time

### Operations inside loop

* `containsKey()` → O(1)
* `peek()` → O(1)
* `push()` → O(1)
* `pop()` → O(1)

### Conclusion

```
n iterations × O(1) work per iteration = O(n)
```

---

## 📦 Space Complexity — **O(n)**

### Why?

* A stack is used to store opening brackets
* In the worst case, all characters are opening brackets

### Worst-case input

```
"((((((("
```

### Memory usage

* Stack size grows up to `n`
* HashMap size is constant (3 entries) → O(1)

### Conclusion

```
Stack → O(n)
Map → O(1)
Total → O(n)
```
