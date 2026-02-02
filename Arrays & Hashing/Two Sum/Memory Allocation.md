```
STACK

nums    ->  ref
target  ->  7
value   ->  ref
map     ->  ref
i       ->  int
diff    ->  int


HEAP

int[] nums
index : 0  1  2  3
value : 3  4  5  6


HashMap<Integer, Integer> map
(empty)


LOOP i = 0

nums[i] = 3
diff    = 4

map.put(3, 0)


HashMap<Integer, Integer> map
key -> value
3   -> 0


LOOP i = 1

nums[i] = 4
diff    = 3

map.containsKey(3) -> true


RETURN

int[] result
index : 0  1
value : 0  1


STACK END

references cleared


HEAP

objects GC eligible
```
