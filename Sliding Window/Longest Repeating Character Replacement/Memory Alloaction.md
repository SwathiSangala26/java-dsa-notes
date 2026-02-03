```
INITIAL
-------
STACK
main
s = "AAABABB"
k = 1
l = 0
r = -
res = 0
maxf = 0
count -> ref

HEAP
"AAABABB"
count
(empty)



ITERATION r = 0
---------------
STACK
l = 0
r = 0
res = 1
maxf = 1
count -> ref

HEAP
"AAABABB"
count
'A' = 1



ITERATION r = 1
---------------
STACK
l = 0
r = 1
res = 2
maxf = 2
count -> ref

HEAP
"AAABABB"
count
'A' = 2



ITERATION r = 2
---------------
STACK
l = 0
r = 2
res = 3
maxf = 3
count -> ref

HEAP
"AAABABB"
count
'A' = 3



ITERATION r = 3
---------------
STACK
l = 0
r = 3
res = 4
maxf = 3
count -> ref

HEAP
"AAABABB"
count
'A' = 3
'B' = 1



ITERATION r = 4
---------------
STACK
l = 0
r = 4
res = 5
maxf = 4
count -> ref

HEAP
"AAABABB"
count
'A' = 4
'B' = 1



ITERATION r = 5
---------------
STACK
l = 1
r = 5
res = 5
maxf = 4
count -> ref

HEAP
"AAABABB"
count
'A' = 3
'B' = 2



ITERATION r = 6
---------------
STACK
l = 2
r = 6
res = 5
maxf = 4
count -> ref

HEAP
"AAABABB"
count
'A' = 2
'B' = 3



FINAL
-----
STACK
l = 2
r = 6
res = 5
maxf = 4
count -> ref

HEAP
"AAABABB"
count
'A' = 2
'B' = 3
```
