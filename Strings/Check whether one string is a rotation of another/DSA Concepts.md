# 🧠 DSA Concepts

## 1️⃣ String Rotation Concept

### 🔹 Definition

One string is a **rotation** of another if it can be obtained by **circularly shifting characters** without changing their order.

### 🔹 Example

```text
Original: abcd
Rotations:
abcd
bcda
cdab
dabc
```

---

## 2️⃣ Circular Nature of Rotations

### 🔹 Key Insight

String rotations behave like a **circle**:

* Characters removed from the front reappear at the end
* Order remains the same

This circular behavior is the foundation of the solution.

---

## 3️⃣ Concatenation Trick `(s1 + s1)`

### 🔹 Core Idea

When a string is concatenated with itself:

* It contains **all possible circular shifts** of the original string

### 🔹 Why this works

* Any rotation is just a substring that spans the “boundary” of the original string
* Doubling the string removes that boundary

### 🔹 Example

```text
s1 = abcd
s1 + s1 = abcdabcd
```

All rotations appear inside this combined string.

---

## 4️⃣ Substring Existence Check

### 🔹 Concept

If `s2` is a rotation of `s1`, then:

* `s2` must appear as a **substring** inside `s1 + s1`

This converts a **rotation problem** into a **substring problem**.

---

## 5️⃣ Length Equality Requirement

### 🔹 Logical Rule

Two strings can only be rotations if:

* They have the **same length**

Different lengths automatically disqualify rotation.

---

## 6️⃣ String Immutability (Important Concept)

### 🔹 What it means

* Strings cannot be modified after creation
* Any concatenation or change creates a **new string**

### 🔹 Why it matters

The concatenation operation does not alter the original string; it builds a new one.

---

## 7️⃣ Use of Built-in Methods

### 🔹 Concept

High-level string methods (like substring checks):

* Abstract away low-level character comparison
* Improve readability and reduce manual logic

This is acceptable and expected in interviews unless explicitly restricted.

---

## 8️⃣ Problem Transformation (Key DSA Skill)

### 🔹 Original Problem

```text
Check if one string is a rotation of another
```

### 🔹 Transformed Problem

```text
Check if one string is a substring of another
```

Transforming problems into simpler, known patterns is a **core DSA skill**.
