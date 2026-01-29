### **Time Complexity: O(n²)**

**Why?**

1. Sorting the array takes **O(n log n)**.
2. The outer `for` loop runs up to **n** times.
3. For each `i`, the two pointers (`l` and `r`) together scan the array once → **O(n)**.
4. So the main work is:

   ```
   O(n × n) = O(n²)
   ```
5. In Big-O, we keep the dominant term:

   ```
   O(n log n) + O(n²) = O(n²)
   ```

**Final:**
➡️ **Time complexity = O(n²)**

---

## 📝 Space Complexity — Notes

### **Extra Space (Algorithm Space)**

1. No extra arrays or hash maps are used.
2. Only a few variables (`i`, `l`, `r`, `sum`) are used → constant space.
3. Sorting:

   * In-place sort → **O(1)** or **O(log n)** stack space
   * Some sorting algorithms may take **O(n)** space

➡️ **Extra space = O(1)** (or **O(n)** depending on sorting)

---

### **Output Space**

1. The result list stores all valid triplets.
2. Let `m` = number of triplets found.
3. Each triplet uses constant space (3 integers).
4. Total output space:

   ```
   O(m)
   ```

➡️ **Output space = O(m)**
