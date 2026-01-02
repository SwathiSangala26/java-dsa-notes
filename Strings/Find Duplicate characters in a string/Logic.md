## 🧠 LOGIC

### 📥 Input

```java
String str = "programming";
```

---

## 🔹 Step 1: Create Frequency Array

```java
int[] freq = new int[256];
```

Visualize the array as **boxes indexed by ASCII values**:

```
Index (ASCII) →  97   98   99   ... 103 ... 109 ... 114 ...
Character     →   a    b    c   ...  g  ...  m  ...  r
Frequency     →   0    0    0   ...  0  ...  0  ...  0
```

---

## 🔹 Step 2: Traverse the String

```java
p   r   o   g   r   a   m   m   i   n   g
|   |   |   |   |   |   |   |   |   |   |
```

Each character is processed **one by one**.

---

## 🔹 Step 3: Map Character → ASCII → Array Index

```
'p' ──► ASCII 112 ──► freq[112] = 1
```

```
'r' ──► ASCII 114 ──► freq[114] = 1
```

```
'o' ──► ASCII 111 ──► freq[111] = 1
```

```
'g' ──► ASCII 103 ──► freq[103] = 1
```

```
'r' again ──► ASCII 114 ──► freq[114] = 2   (duplicate)
```

```
'm' ──► ASCII 109 ──► freq[109] = 1
'm' again ──► ASCII 109 ──► freq[109] = 2   (duplicate)
```

```
'g' again ──► ASCII 103 ──► freq[103] = 2   (duplicate)
```

---

## 🔹 Step 4: Final Frequency Table (Relevant Part)

```
freq[103] ──► 'g' ──► 2
freq[109] ──► 'm' ──► 2
freq[114] ──► 'r' ──► 2
```

---

## 🔹 Step 5: Detect Duplicates

```java
if (freq[i] > 1)
```

Visual logic:

```
freq[i] > 1
   ↓
duplicate character found
```

---

## 🧠 One-Glance Logic Flow (VERY IMPORTANT)

```
Character
   ↓
ASCII value
   ↓
Array index
   ↓
Frequency count
```

---

## ✅ Logic Summary (Interview-Ready)

* Traverse the string once
* Convert each character to ASCII
* Use ASCII as array index
* Increment frequency
* Print characters with frequency > 1
