# CSCI 1913 FALL 2022 KLUVER
# Author: Bethany Freeman

# QUESTIONS:
# Question 1: Which image file you submitted covers which analysis case?
Answer1 = '''
Backwards = Backwards_ Selection, Insertion, Merge.png
Near-Sort = Near-Sort_ Selection, Insertion, Merge.png
Random = Random_ Selection, Insertion, Merge.png
Sorted List = Sorted List_ Selection, Insertion, Merge.png
'''

# Question 2: For each algorithm, explain how you see it behaving in your images.
# If the algorithm's behavior differed case-by-case say this and explain how it behaved in each case.

Answer2_insertion = '''Insertion sort in the images acted differently depending on what it was in. In backwards it 
looked like a linear function graph. In near sorted, it also looked like a linear graph but more squiggly. In random, 
it was an inbetween of backwards and near-sorted appearance wise. Lastly, in sorted list, it looked like another 
straight linear line. '''

Answer2_selection = '''
Selection sort in every image went towards the N^2 type of graph.
'''

Answer2_merge = '''
Merge sort in every graph was directly against the bottom of the graph and didn't seem to be increasing by much. 
'''

# Question 3: For each algorithm, What is the theoretical expectation. I.E. what is the expected big-O runtime behavior.
# If the algorithm's expected behavior differs case-by-case say this and explain how it is
# expected to behave case-by-case. (You should be able to find this information in the textbook.
# If not we will discuss this in class)

Answer3_insertion = '''
Insertions worst and best case depend. Worst is O(N^2) since you have to swap every element in the list. Best case is O(N)
since every element is already swapped.
'''

Answer3_selection = '''
Selection sort will always run O(N^2) times since you will always go through both for loops
'''

Answer3_merge = '''
Merge sort is O(nlogn) for all cases since it is based in recursion.
'''

# Question 4: For each algorithm, How did the observed behavior match the theoretical behavior? Again, if your answer
# differs case by case, say that here and explain your findings for each case.

Answer4_insertion = '''
In each graph, Insertion sort, I felt like, pretty fairly met expectations of what it would theoretically.
'''

Answer4_selection = '''
The observed behavior kind of matched the theoretical behavior as it started to curve in each graph.
'''

Answer4_merge = '''
The observed behavior kind of matched the theoretical behavior since compared to the other two it was much less of a 
slope.
'''

# Question 5: Merge sort is theoretically the fastest algorithm, are there
# cases where another algorithm might be faster?

Answer5 = '''
I think there are cases where a different algorithm not stated in this lab might be faster but none of these two would
ever be faster than merge sort.
'''

# Question 6: If you didn't know the order of data you might want to sort,
# what algorithm might you use to sort it, and why?

Answer6 = '''
Merge sort since it can do it fastest.
'''


# Selection, Insertion, and Merge sorts -- taken from ZyBooks.
def selection_sort(numbers):
    """Sort the list numbers in-place. (Note, this doesn't have to be numbers)"""
    count = 0
    for i in range(len(numbers) - 1):
        # Find index of the smallest remaining element
        index_smallest = i
        for j in range(i + 1, len(numbers)):
            if numbers[j] < numbers[index_smallest]:
                index_smallest = j
                count += 1
            else:
                count += 1

        # Swap numbers[i] and numbers[index_smallest]
        temp = numbers[i]
        numbers[i] = numbers[index_smallest]
        numbers[index_smallest] = temp

    return count


def insertion_sort(numbers):
    """Sort the list numbers in-place. (Note, this doesn't have to be numbers)"""
    count = 0
    for i in range(1, len(numbers)):
        j = i
        # Insert numbers[i] into sorted part stopping once numbers[i] in correct position KLUVER NOTE - PLEASE READ -
        # so this line is a bit tricky. Technically, if j > 0 then numbers would not be compared to make things
        # easier you can assume that every time the list condition is checked one array element comparison occurs.
        # That is -- you can ignore the short-circuit evaluation of the logical and in this counting problem.
        count += 1
        while j > 0 and numbers[j] < numbers[j - 1]:
            # Swap numbers[j] and numbers[j - 1]
            count = count + 1
            temp = numbers[j]
            numbers[j] = numbers[j - 1]
            numbers[j - 1] = temp
            j = j - 1
    return count


def merge(numbers, i, j, k):
    """ Given two sorted sub-lists create one sorted list. This is done in-place, meaning we are given one list and
    expected to modify the list to be sorted. Furthermore, this operates on "sub-lists" (a specific range of the
    list) The list named numbers may contain other types of data than just numbers the variables i, j, and k are all
    indices into the numbers list So the part of the list to be sorted is from position i to k (inclusive) with i to
    j being one sorted list, and j+1 to k being another. """
    count = 0
    merged_size = k - i + 1  # Size of merged partition
    merged_numbers = []  # Temporary list for merged numbers
    for l in range(merged_size):
        merged_numbers.append(0)

    merge_pos = 0  # Position to insert merged number

    left_pos = i  # Initialize left partition position
    right_pos = j + 1  # Initialize right partition position

    #  Add the smallest element from left or right partition to merged numbers
    while left_pos <= j and right_pos <= k:
        if numbers[left_pos] < numbers[right_pos]:
            count += 1
            merged_numbers[merge_pos] = numbers[left_pos]
            left_pos = left_pos + 1
        else:
            count += 1
            merged_numbers[merge_pos] = numbers[right_pos]
            right_pos = right_pos + 1
        merge_pos = merge_pos + 1

    #  If left partition is not empty, add remaining elements to merged numbers
    while left_pos <= j:
        merged_numbers[merge_pos] = numbers[left_pos]
        left_pos = left_pos + 1
        merge_pos = merge_pos + 1

    #  If right partition is not empty, add remaining elements to merged numbers
    while right_pos <= k:
        merged_numbers[merge_pos] = numbers[right_pos]
        right_pos = right_pos + 1
        merge_pos = merge_pos + 1

    #  Copy merge number back to numbers
    merge_pos = 0
    while merge_pos < merged_size:
        numbers[i + merge_pos] = merged_numbers[merge_pos]
        merge_pos = merge_pos + 1
    return count


def merge_sort_recursive(numbers, i, k):
    """ Sort the sub-list in numbers from position i to k (inclusive)"""
    count = 0
    if i < k:
        j = (i + k) // 2  # Find the midpoint in the partition
        count += merge_sort_recursive(numbers, i, j)
        count += merge_sort_recursive(numbers, j + 1, k)
        count += merge(numbers, i, j, k)
    return count


def merge_sort(numbers):
    """ Sort a list of numbers This function is added on-top of the textbook's code to simply start the
    recursive process with the appropriate parameters. This also gives us a consistent sorting interface
    over the three sorts."""
    count = 0
    count += merge_sort_recursive(numbers, 0, len(numbers) - 1)
    return count
