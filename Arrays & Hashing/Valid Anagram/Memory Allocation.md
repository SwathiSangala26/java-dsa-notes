```
CODE
boolean isAnagram(String s, String t)
int[] count = new int[26]


STACK  (method frame)

s        ->  ref
t        ->  ref
count    ->  ref
i        ->  loop variable


HEAP

String object
"anagram"
index : 0 1 2 3 4 5 6
char  : a n a g r a m


String object
"nagaram"
index : 0 1 2 3 4 5 6
char  : n a g a r a m


int[] object  (count)
length = 26

index :  0  1  2  3  4  5  6  7  8  9
value :  0  0  0  0  0  0  0  0  0  0

index : 10 11 12 13 14 15 16 17 18 19
value :  0  0  0  0  0  0  0  0  0  0

index : 20 21 22 23 24 25
value :  0  0  0  0  0  0


CHAR TO INDEX

'a' - 'a' = 0
'b' - 'a' = 1
'c' - 'a' = 2
...
'z' - 'a' = 25


LOOP  i = 0

s[0] = 'a' -> 0 -> count[0]  = 1
t[0] = 'n' ->13 -> count[13] = -1


LOOP  i = 1

s[1] = 'n' ->13 -> count[13] = 0
t[1] = 'a' -> 0 -> count[0]  = 0


LOOP  i = 2

s[2] = 'a' -> 0 -> count[0] = 1
t[2] = 'g' -> 6 -> count[6] = -1


LOOP  i = 3

s[3] = 'g' -> 6 -> count[6] = 0
t[3] = 'a' -> 0 -> count[0] = 0


LOOP  i = 4

s[4] = 'r' ->17 -> count[17] = 1
t[4] = 'r' ->17 -> count[17] = 0


LOOP  i = 5

s[5] = 'a' -> 0 -> count[0] = 1
t[5] = 'a' -> 0 -> count[0] = 0


LOOP  i = 6

s[6] = 'm' ->12 -> count[12] = 1
t[6] = 'm' ->12 -> count[12] = 0


FINAL int[] count

index : 0..25
value : all 0


STACK FRAME END
references cleared


HEAP
objects eligible for GC


RETURN
true
```
