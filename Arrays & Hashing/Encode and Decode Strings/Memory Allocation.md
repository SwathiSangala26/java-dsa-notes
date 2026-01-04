# 🧠 MEMORY ALLOCATION

### (For `encode()` and `decode()` code)

---

## 🧩 PART 1: Objects involved

Your code uses:

* `Solution` object
* `StringBuilder`
* `String`
* `ArrayList`
* Local variables (`i`, `j`, `length`)
* Method stack frames

---

# 📦 MEMORY AREAS (VERY IMPORTANT)

```
STACK       → method calls, local variables, references
HEAP        → objects (ArrayList, StringBuilder, Strings)
STRING POOL → string literals (if any)
```

---

# ▶️ STEP 1: main() starts

```java
Solution sol = new Solution();
```

### Stack

```
main()
└── sol  ───────────────► Heap object (Solution)
```

### Heap

```
Solution@101
```

---

# ▶️ STEP 2: Create input list

```java
List<String> input = new ArrayList<>();
```

### Stack

```
main()
├── sol   ─────────► Solution@101
└── input ─────────► ArrayList@201
```

### Heap

```
ArrayList@201
└── internal Object[] (size=0)
```

---

# ▶️ STEP 3: Add "Hello"

```java
input.add("Hello");
```

### String literal

```
STRING POOL
└── "Hello"
```

### Heap

```
ArrayList@201
└── Object[0] ──► "Hello"
```

---

# ▶️ STEP 4: Call encode()

```java
String encoded = sol.encode(input);
```

---

## 🧠 New stack frame created

### Stack

```
encode()
├── strs ─────────► ArrayList@201
├── s    ─────────► (loop variable)
└── res  ─────────► StringBuilder@301
```

---

## ▶️ STEP 5: StringBuilder created

```java
StringBuilder res = new StringBuilder();
```

### Heap

```
StringBuilder@301
└── char[] capacity (default 16)
```

---

## ▶️ STEP 6: Append operations

```java
res.append(5).append('#').append("Hello");
```

### Heap

```
StringBuilder@301
└── char[] = ['5','#','H','e','l','l','o']
```

⚠️ No new String yet — StringBuilder is mutable

---

## ▶️ STEP 7: encode() returns String

```java
return res.toString();
```

### Heap

```
String@401  = "5#Hello"
```

### Stack

```
encoded ─────────► String@401
```

### encode() stack frame DESTROYED

---

# ▶️ STEP 8: Call decode()

```java
List<String> decoded = sol.decode(encoded);
```

---

## 🧠 New stack frame

### Stack

```
decode()
├── str   ─────────► String@401 ("5#Hello")
├── res   ─────────► ArrayList@501
├── i     = 0
├── j     = ?
└── length= ?
```

---

## ▶️ STEP 9: Create result list

```java
List<String> res = new ArrayList<>();
```

### Heap

```
ArrayList@501
└── Object[] (empty)
```

---

# ▶️ STEP 10: Parse length

```java
str.substring(0,1) → "5"
Integer.parseInt("5") → 5
```

### Heap

```
String@402 = "5"   (temporary)
```

### Stack

```
length = 5
```

⚠️ `"5"` string becomes **eligible for GC after method**

---

# ▶️ STEP 11: Extract actual string

```java
str.substring(2,7) → "Hello"
```

### Heap

```
String@403 = "Hello"
```

### Heap

```
ArrayList@501
└── Object[0] ──► String@403
```

---

## ▶️ STEP 12: decode() returns list

### Stack

```
decoded ─────────► ArrayList@501
```

### decode() stack frame DESTROYED

---

# 🗑️ GARBAGE COLLECTION ELIGIBILITY

Eligible after methods end:

```
StringBuilder@301
Temporary substring "5"
```

Still alive:

```
Solution@101
ArrayList@201 (input)
ArrayList@501 (decoded)
String literals
```
