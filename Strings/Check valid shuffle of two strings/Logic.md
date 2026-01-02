# 🧠 Logic

## 1️⃣ Problem Essence

A string `s3` is a **valid shuffle** of `s1` and `s2` if:

* All characters of `s1` and `s2` appear in `s3`
* The **relative order** of characters in `s1` is preserved
* The **relative order** of characters in `s2` is preserved

---

## 2️⃣ Key Logical Insight

At any position in `s3`, the current character can only come from:

* the **next unused character of `s1`**, or
* the **next unused character of `s2`**

No other choice is valid.

---

## 3️⃣ Order Preservation Principle

* Characters from `s1` must appear in `s3` in the same left-to-right order
* Characters from `s2` must appear in `s3` in the same left-to-right order
* Interleaving is allowed, reordering is not

---

## 4️⃣ Pointer-Based Matching Logic

Maintain:

* one pointer for `s1`
* one pointer for `s2`

While reading `s3` sequentially:

* match the character with the current pointer of `s1` or `s2`
* move the pointer forward once matched

---

## 5️⃣ Greedy Choice Justification

* Choosing the earliest possible valid character is safe
* Delaying a valid match can only break order later
* Each character in `s3` must be consumed immediately

---

## 6️⃣ Failure Condition

If a character in `s3`:

* matches neither the next character of `s1`
* nor the next character of `s2`

→ the shuffle is invalid.

---

## 7️⃣ Why Frequency Check Alone Is Insufficient

* Matching character counts does not guarantee order
* Valid shuffle is an **order-sensitive merge**, not just an anagram

---

## 8️⃣ Mental Model

Think of:

* `s1` and `s2` as **two queues**
* `s3` as the **merged output**
* You can only take from the **front** of either queue

---

## 🎯 One-Line Logic Summary

> A valid shuffle is formed by merging two strings while preserving their internal order, where each character in the result must come from the next available character of either input string.
