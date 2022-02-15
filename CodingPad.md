# Binary Search

## 1. Classical Binary Search:

1. A: 
   1. array is sorted
   2. duplicate is possible, and can return any index i once array[i] = target
   3. if target not in array, return -1
2. Idea: since array is sorted, can use binary search to get rid of half per round
3. Code:

```java
// return type is int representing index, inputs are int array, and int target
public int bs(int[] array, int target) {
    // corner case check
    if (array == null || array.length == 0) {
        return -1;
    }
    // normal case
    int left = 0; // the left searching bound 
    int right = array.length - 1; // the right bound
    while (left <= right) { // because when left == right we still have one element to be checked
        int mid = left + (right - left) / 2;
        if (array[mid] < target) { // target is at right side, update left bound
            left = mid + 1; // because mid is not the answer
        } else if (array[mid] > target) { // target is at left side, update right bound
            right = mid - 1;
        } else { // found
            return mid;
        }
    }
    return -1;
}
```

4. Complexity:

   1. time: assume k round, the last round what remain is n/2^k, where n is the number of elements in array. at last round, what remain is 1, so we get n/2^k = 1 which lead to k = logn 

      -> O(longn)


   2. space: we do not create extra datastructure to help solve this, so no heap cost, and no recursion, so no stack cost

      -> O(1)

## 2. Search in Sorted Matrix I:

1. A:
   1. matrix is sorted, meaning for each line, from left to right, increasing, the first element of next line is larger than the last element of previous row
   2. duplicate is possible, just return one valid answer
   3. target could not be in matrix, if that is the case return -1, -1
3. Idea: matrix can be treated as one dimension array, the index of m, n will be m * cols + n, and for a sorted array, binary search is possible, and we use binary search to find the target index in oneD and then transfer to matrix index, with row = index / cols and col = index % cols
4. Code:

```java
// return an int[] that contains two element, one is row one is col, take two input arguments, first is matrix int[][], second is int target
public int[] bs(int[][] matrix, int target) {
    // corner case check
    if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
        return new int[] {-1, -1};
    }
    // get m, n of the matrix
    int rows = matrix.length;
    int cols = matrix[0].length;
    // define intialized bound
    int left = 0 ;
    int right = rows * cols - 1;
    while (left <= right) { // since we need to check the last one 
        int mid = left + (right - left) / 2;
        // transfer to matrix position
        int midRow = mid / cols;
        int midCol = mid % cols;
        if (matrix[midRow][midCol] < target) { // right, update left
           left = mid + 1; 
        } else if (matrix[midRow][midCol] > target) {
            right = mid - 1;
        } else {
            return new int[] {midRow, midCol};
        }
    }
    return new int[] {-1, -1};
}
```

4. Complexity:

   1. time: total number of elements is m*n, k round, last round has mn / 2^k = 1, get k = logmn

      -> O(logmn)


   2. space: no extra data structure used, so no heap cost, no recursion, no stack cost

      -> O(1)

## 3. Closest in Sorted Array:

1. Assumption: 
   1. array is sorted
   2. target can be in the array, if thats the case, return target
   3. duplicate may happen, return one
   4. may have few numbers that are close to target, return left one
2. Idea: given this array is sorted, also we want to find the closest, apparently the array can be split into two parts with the closest one, so that for each round this is also true. so binary search is possible, each round get rid of one half of the searching area that are definitely larger or smaller than target and have a closer one to target.
3. Code:

```java
// return should be int standing for the index of the closest number, input two arguments, one is int array which should be sorted, and one is int target
public int closest(int[] array, int target) {
    // corner case
    if (array == null || array.length == 0) {
        return -1;
    }
 	// define searching area bound
    int left = 0;
    int right = array.length - 1;
    while (left < right - 1) { // we need to compare the last two to figure which is closer
        int mid = left + (right - left) / 2;
        if (array[mid] < target) { // update left bound
            left = mid; // left may be the answer
        } else if (array[mid] > target) {
            right = mid;
        } else {
            return mid;
        }
    }
    // now we have two left
    if (Math.abs(array[left] - target) <= Math.abs(array[right] - target)) {
        return left;
    } else {
        return right;
    }
}
```

4. Complexity:

   1. time: k round, the last round has n/2^k and this should equal to 1, so we get k = logn

      -> O(logn)

   2. space: no extra data structure used, so no extra heap cost. no recursion or additional function call, so no extra stack cost.

      -> O(1)

## 4. First Occurrence:

1. Assumption: 
   1. array is sorted
   2. duplicate is possible
   3. if target is not in array, return -1
2. Idea: given sorted array, per round we are sure that half of the array are definitely not the answers, so use binary search. at last we leave two to check which one is the answer
3. Code:

``` java
// return int standing for the index, input two arguments, one is int array, one is target
public int first(int[] array, int target) {
    // corner case check
    if (array == null || array.length == 0) {
        return -1;
    }
    // define searching area
    int left = 0;
    int right = array.length - 1;
    while (left < right - 1) { 
        // four cases: 
        // left and right are both target
        // left is target
        // right is target
        // both are not target
        int mid = left + (right - left) / 2;
        if (array[mid] < target) { // update left
            left = mid + 1; // mid is not the answer for sure
        } else if (array[mid] > target) {
            right = mid - 1;
        } else { // if find target, update right to search left, since all right part will not be the answer
            right = mid;
        }
    }
    if (array[left] == target) { // order matters, should check left first, to avoid case when left and right are both atrget
        return left;
    } else if (array[right] == target) {
        return right;
    } else {
        return -1;
    }
}
```

4. Complexity:

   1. time: k round, n/2^k = 1, get k = logn

      -> O(logn)

   2. space: no stack, no heap

      -> O(1)

## 5. Last Occurrence:

1. Assumption: 
   1. array is sorted
   2. target may not in array, if that is the case, return -1
2. Idea: binary search, since it is sorted, so we know for sure if given an element, we know one side of this element will not be the answer for sure
3. Code:

```java
// return type is int standing for the index of answer, takes two input arguments, one is int array, one is int target
public int last(int[] array, int target) {
    // corner check
    if (array == null || array.length == 0) {
        return -1;
    }
    // define searching bound
    int left = 0;
    int right = array.length - 1;
    while (left < right - 1) {
        // four cases:
        // left is target
        // right is target
        // both are not
        // both are
        int mid = left + (right - left) / 2;
        if (array[mid] < target) { // update left
            left = mid + 1;
        } else if (array[mid] > target) {
            right = mid - 1;
        } else { // if find target, update left
            left = mid;
        }
    }
    if (array[right] == target) { // order matters
        return right;
    } else if (array[left] == target) {
        return left;
    } else {
        return -1;
    }
}
```

4. Complexity:
   1. time: O(logn)
   2. space: O(1)

## 6. K Closest in Sorted Array:

1. Assumption:
   1. array is sorted
   2. if two has same distance to target, we use left first
   3. k should be bigger than 0 and smaller than array length
2. Idea: find closest first using binary search, then begin from that index to left and right
3. Code:

```java
// return int array, takes three input arguments, one is int array, one is target int, one is int k standing for the length of final answer
public int[] k(int[] array, int target, int k) {
    // corner check
    if (array == null || array.length == 0 || k <= 0 || k > array.length) {
        return new int[] {};
    }
    // define searching bound
    int left = 0;
    int right = array.length - 1;
    int closest = -1;
    while (left < right - 1) {
        int mid = left + (right - left) / 2;
        if (array[mid] < target) { // update left
            left = mid;
        } else if (array[mid] > target) { // update right
            right = mid;
        } else {
            closest = mid;
            break;
        }
    }
    // check whether closest is valid or not
    if (closest == -1) {
        if (Math.abs(array[left] - target) <= Math.abs(array[right] - target)) {
            closest = left;
        } else {
            closest = right;
        }
    }
    // define an int array to store answer
    int[] result = new int[k];
    result[0] = array[closest];
    // define begin index
    int cl = closest - 1;
    int cr = closest + 1;
    for (int i = 1; i < k; i++) { // stands for the ith closest to target
        // add left when right out of bound or left is the closer one
        if (cl >= 0 && (cr >= array.length || Math.abs(array[cl] - target) <= Math.abs(array[cr] - target))) {
            result[i] = array[cl--]; // cl not left
        } else {
            result[i] = array[cr++]; // cr not right
        }
    }
    return result;
}
```

4. Complexity:

   1. time: binary search logn, then traverse k times

      -> O(logn + k)

   2. space: no extra stack used, no extra heap used (the int array created for answer is not counted as extra space cost)

      -> O(1)

## 7. Smallest Element Larger than Target:

1. Assumption: 
   1. array is sorted
   2. may not have such an answer
   3. their may be duplicate, if that happens, return the leftmost
2. Idea: binary search, since once we have the mid point, we know for sure one half is not valid
3. Code:

```java
// return int standing for index, take two input arguments, one is int array, one is int target
public int smallest(int[] array, int target) {
    // corner case check
    if (array == null || array.length == 0) {
        return -1;
    }
    // define searching area
    int left = 0;
    int right = array.length - 1;
    while (left < right - 1) {
        int mid = left + (right - left) / 2;
        if (array[mid] < target) { // update left
            left = mid + 1; 
        } else if (array[mid] > target) { // update right
            right = mid; // should keep, may be the answer
        } else {
            left = mid + 1;
        }
    }
    // three cases:
    if (array[left] > target) { // both are larger
        return left;
    } else if (array[right] > target) { // left is smaller, right is larger
        return right;
    } else { // both are smaller
        return -1;
    }
}
```

4. Complexity:

   1. time: k round, n/2^k = 1, get k = logn

      -> O(logn)

   2. space: not extra stack or heap cost

      -> O(1)

## 8. Search in Unknown Sized Sorted Array:

1. Assumption:
   1. array is sorted
   2. suppose we have a get method that given an index, to return its value or null
2. Idea: binary search, first use get method to find the left and right bound. we can stop finding right bound once that number is greater or equal to target or return null
3. Code:

```java
// return int index, input a dictionary of number, int target
public int unknown(Dictionary dict, int target) {
    // corner case check
    if (dict == null) {
        return -1;
    }
    int left = 0;
    int right = 1;
    while (dict.get(right) != null && dict.get(right) < target) {
        left = right;
        right = right * 2;
    }
    while (left <= right) {
        int mid = left + (right - left) / 2;
        if (dict.get(mid) == null || dict.get(mid) > target) { // update right, and should check null first to avoid npe
            right = mid - 1;
        } else if (dict.get(mid) < target) {
            left = mid + 1;
        } else {
            return mid;
        }
    }
    return -1;
}
```

4. Complexity:

   1. time: first, suppose we have n in array, in worst case to find the right bound, we have to traverse n/2 times. second for the binary search part, logn round

      -> O(n + logn) = O(n)

   2. space: no extra stack and heap cost

      -> O(1)

------

# Recursion

## 1. Fibonacci:

1. Assumption: 

   1. input number should be valid

2. Idea: 

   1. recursion rule: fib(n) = fib(n - 1) + fib(n - 2)

   2. basic case: n == 0: 0, n == 1: 1

   3. recursion tree: 

      ```mermaid
      graph TD;
      	n --> n-1;
      	n --> n-2;
      ```

3. Code:

```java
// return type is int standing for the answer, input one argument, int target n representing the nth element in fibonacci
public int fib(int n) {
	// corner case:
    if (n < 0) {
        return 0;
    }
    // basic case:
    if (n == 0 || n == 1) {
        return n;
    }
    // recursion rule
    return fib(n - 1) + fib(n - 2);
}
```

4. Complexity:

   1. time: each node will split into two subnodes, so that for each level k, the node for that level is 2^k, so the total number of nodes will be 1 + 2^1 + 2^2 + ... + 2 ^ n since the level number is n, and that sum is approximately at the 2 ^ n level

      -> O(2^n)

   2. space: have stack cost, the max depth of recursion call on stack is n, so stack cost is n. no heap cost

      -> O(n)

## 2. a to the power of b:

1. Assumption: 

   1. consider long type
   2. b can be negative

2. Idea:

   1. recursion rule: a ^ b = a ^ b/2 * a ^ b / 2 (* a if b is odd)

   2. basic case: b == 0, return 1

   3. recursion tree:

      ```mermaid
      graph TD;
      	b --> b/2;
      	b/2 --> b/4;
      	b/4 --> ...;
      	... --> b/2**k;
      ```

3. Code:

```java
// return type is long standing for the answer, take two argument, one is a, one is b
public long power(int a, int b) {
    // corner case
    if (a == 0 && b == 0) {
        return 1; // special case
    }
    if (a == 0) {
        return 1;
    }
    // basic case:
    if (b == 0) {
        return 1;
    }
    long half = power(a, b/2);
    return b % 2 == 1 ? half * half * a : half * half;
}
```

4. Complexity:

   1. time: suppose have k level, first level we have b, next b/2, down to b/2^k, at the last level the formula will equal to 1, so we get k = logb

      -> O(logb)

   2. space: the longest path at the recursion tree top to down is logb, so stack cost is logb. for heap, no extra cost

      -> O(logb)

------

# Sorting

## 1. Selection Sort:

1. Assumption:
   1. array is valid
   2. ascending order sorting
   3. inplace
2. Idea: two traverse, first i standing for the position need to be fulfill, and use j to find the current min from i to last
3. Code:

```java
// return type should be int array, take one input, input an unsorted array
public int[] selection(int[] array) {
    // corner case check
    if (array == null || array.length == 0) {
        return new int[] {};
    }
    for (int i = 0; i < array.length; i++) {
        // i stands for the position that should be complete with correct number this round
        int curMin = array[i]; // !careful
        int curMinIndex = i; // !careful
        for (int j = i + 1; j < array.length; j++) {
            // j stands for the elements that should be compared with i to find local min
            if (array[j] < curMin) {
                curMin = array[j];
                curMinIndex = j;
            }
        }
        // after finding the local min, swap
        int tmp = array[i];
        array[i] = curMin;
        array[curMinIndex] = tmp;
    }
    return array;
}
```

4. Complexity:

   1. time: two traverse, in worst case will have n^2 round

      -> O(n^2)

   2. space: no stack cost, no heap cost

      -> O(1)

## 2. Merge Sort:

1. Assumption:
   1. ascending order
2. Idea: use recursion to split array into one element, and merge with order down to top
3. Code:

```java
// return type is int array, take one input argument that is unsorted int array
public int[] mergeSort(int[] array) {
    // corner case check
    if (array == null || array.length == 0) {
        return new int[] {};
    }
    return helper(array, 0, array.length - 1);
}

public int[] helper(int[] array, int left, int right) {
    // base case
    if (left == right) {
        return new int[] {array[left]};
    }
    int mid = left + (right - left) / 2;
    int[] leftSub = helper(array, left, mid);
    int[] rightSub = helper(array, mid + 1, right);
    return merge(leftSub, rightSub);
}

// return int array, take two inputs, two are both parts of array
public int[] merge(int[] left, int[] right) {
    int[] result = new int[left.length + right.length];
    int cur = 0;
    int leftIndex = 0;
    int rightIndex = 0;
    while (leftIndex < left.length && rightIndex < right.length) {
        if (left[leftIndex] <= right[rightIndex]) {
            result[cur++] = left[leftIndex++];
        } else {
            result[cur++] = right[rightIndex++];
        }
    }
    while (leftIndex < left.length) {
        result[cur++] = left[leftIndex++];
    }
    while (rightIndex < right.length) {
        result[cur++] = right[rightIndex++];
    }
    return result;
}
```

4. Complexity:

   1. time: the recursion tree has logn level, because each time, we split the array into two, so suppose we have k level, the last level fits 2^k = n, so k = logn. Top down level, each level is O(1), and down to top level, each level is O(n)

      -> O(nlogn + logn)

   2. space: at stack, the cost is logn, since the depth of recursion tree is logn. at heap, the cost is n, because we need to new n elements

      -> O(logn + n)

## 3. Quick Sort:

1. Assumption:
   1. ascending order
2. Idea: each round pick a pivot, sort smaller to left, larger to right, and use recursion to update left and right of pivot. 
3. Code:

```java
// return type is int array, input unserted int array
public int[] quickSort(int[] array) {
    // corner case check
    if (array == null || array.length == 0) {
        return new int[] {};
    }
    helper(array, 0, array.length - 1);
    return array;
}

// return void since inplace
public void helper(int[] array, int left, int right) {
    if (left >= right) { // left may be larger than right, because we obtain left based on pivot
        return;
    }
    // get pivot
    int pivot = partition(array, left, right);
    // recursion
    helper(array, left, pivot - 1);
    helper(array, pivot + 1, right);
}

// return pivot
public int partition(int[] array, int left, int right) {
    int pivotIndex = getPivot(left, right);
    int pivot = array[pivotIndex];
    swap(array, pivotIndex, right);
    int l = left; // first element that is larger or equal than pivot
    int r = right - 1; // first element that is smaller than pivot
    while (l <= r) {
        if (array[l] <= pivot) {
            l++;
        } else if (array[r] > pivot) {
            r--;
        } else {
            swap(array, l++, r--);
        }
    }
    swap(array, l, right);
    return l;
}

// return pivot index
public int getPivot(int left, int right) {
    return left + (int)(Math.random() * (right - left + 1)); // need to cast to int or it will be double
}

// swap function
public void swap(int[] array, int left, int right) {
    int tmp = array[left];
    array[left] = array[right];
    array[right] = tmp;
}
```

4. Complexity:

   1. time: worst case will become selection sort that has O(n^2). on average, will have logn level, each level partition cost n, so total nlogn

      -> O(nlogn)

   2. space: in worst case, will have n level, O(n). on average, will have logn level, so stack cost is logn. no heap cost because inplace

      -> O(logn)

## 4. Rainbow Sort:

1. Assumption:
   1. array only contains -1, 0, 1

2. Idea: three blocks, first block stands for he first element that is not -1, second stands for the first element that is not 0, and the third is the last 0
3. Code:

```java
// return reordered int array, input one int array
public int[] rainbow(int[] array) {
    // corner case check
    if (array == null || array.length == 0) {
        return array;
    }
    int left = 0;
    int leftBound = 0;
    int rightBound = array.length - 1;
    while (leftBound <= rightBound) {
        if (array[leftBound] == -1) {
            swap(array, left++, leftBound++); // we can update leftbound because lfet is sure 0
        } else if (array[leftBound] == 1) {
            swap(array, leftBound, rightBound--); // cannot update leftbound since we are not sure about rightBound value
        } else {
            leftBound++;
        }
    }
    return array;
}
```

4. Complexity:

   1. time: each elements should be checked, so totally need to check n round

      -> O(n)

   2. space: no extra stack and heap cost

      -> O(1)

------

# Array

## 1. Move 0s to End I:

1. Assumption: 
   1. array contains 0 and other numbers
   2. relative order no need to keep
2. Idea: because no need to keep the relative order, so use two bound, one from left, one from right, left is the first that is 0, and right is the last that is not 0
3. Code:

```java
// return type is result int array, input is int array
public int[] move(int[] array) {
    // corner case check
    if (array == null || array.length == 0) {
        return array;
    }
    int left = 0;
    int right = array.length - 1;
    while (left <= right) {
        if (array[left] != 0) {
            left++;
        } else {
            swap(array, left, right--);
        }
    }
    return array;
}
```

4. Complexity:

   1. time: each elements should be checked so totally n round

      -> O(n)

   2. space: no function call, so no stack cost. no extra data structure used, so no heap cost

      ->O(1)

## 2. Move 0s to End II:

1. Assumption:
   1. array contains 0 and other numbers
   2. relative order should be kept
2. Idea: because we need to keep the order, so use two pointer, one stands for the last element that is not 0, and one stands for the last 0
3. Code:

```java
// return type is int array after reorder, input is int array
public int[] move(int[] array) {
    // corner check
    if (array == null || array.length == 0) {
        return array;
    }
    int slow = 0;
    int fast = 0; // used to traverse
    while (fast < array.length) {
        if (array[fast] != 0) {
            swap(array, slow++, fast++);
        } else {
            fast++;
        }
    }
    return array;
}
```

4. Complexity:

   1. time: each elements will be viewed once, so totally n round

      -> O(n)

   2. space: no stack cost no heap cost

      -> O(1)
