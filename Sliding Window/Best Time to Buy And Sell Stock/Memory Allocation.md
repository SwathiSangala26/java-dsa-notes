HEAP
prices (int[]) 
index →  0   1   2   3   4   5
value → [10,  1,  5,  6,  7,  1]


STACK (before loop)
maxP    → 0
minBuy  → 10
sell    → -
profit  → -


--------------------------------
STACK (iteration 1)
sell    → 10
profit  → 0
maxP    → 0
minBuy  → 10
--------------------------------
STACK (iteration 2)
sell    → 1
profit  → -9
maxP    → 0
minBuy  → 1
--------------------------------
STACK (iteration 3)
sell    → 5
profit  → 4
maxP    → 4
minBuy  → 1
--------------------------------
STACK (iteration 4)
sell    → 6
profit  → 5
maxP    → 5
minBuy  → 1
--------------------------------
STACK (iteration 5)
sell    → 7
profit  → 6
maxP    → 6
minBuy  → 1
--------------------------------
STACK (iteration 6)
sell    → 1
profit  → 0
maxP    → 6
minBuy  → 1
--------------------------------


RETURN
maxP → 6
