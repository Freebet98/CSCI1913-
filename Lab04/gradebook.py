# CSCI 1913 FALL 2022 Kluver
# Author: Bethany Freeman

def is_sorted(gradebook):
    """This function takes a gradebook and checks if that gradebook is sorted. This is checked based on the students
    name in the gradebook and whether those names are in alphabetical order. This returns true if it is sorted or
    false if it is not"""

    b_sort = True
    if not gradebook:
        b_sort = True
    else:
        for x in range(1, len(gradebook)):
            if gradebook[x - 1][1] < gradebook[x][1]:
                b_sort = True
            else:
                b_sort = False
                break

    return b_sort


def grade_average(gradebook):
    """This function takes a gradebook, sorted or unsorted, and computes the average grade of all the students in the
    gradebook. It then returns the average."""

    if not gradebook:
        return 0.0
    else:
        total_grade = 0
        for x in gradebook:
            total_grade += x[0]

        average_grade = total_grade / len(gradebook)
        return average_grade


def unsorted_get(gradebook, student_name):
    """This function takes two parameters, a gradebook and a students name. This function uses the linear search
    function to check if the student name is in the gradebook. If the student is in the gradebook, the function returns
    the grade found with their name. Otherwise, it returns none"""

    grade = linear_search(gradebook, student_name)
    if grade == -1:
        return None
    else:
        return grade


def unsorted_put(gradebook, student_name, student_grade):
    """This function takes three parameters, a gradebook, a student name, and a student grade. This function uses linear
    search to find the student name in the gradebook. It will then either replace the tuple for the student with the
    updated grade, or it will add a new one for a new student. This will not return a value."""

    return_value = linear_search(gradebook, student_name)

    if return_value == -1:
        gradebook.append((student_grade, student_name))
    else:
        for x in range(len(gradebook)):
            if gradebook[x][1] == student_name:
                gradebook[x] = (student_grade, student_name)


def sorted_get(gradebook, student_name):
    """This function takes two parameters, a gradebook and a student name. This function uses binary search to find the
    student name in the gradebook. If the student is in the gradebook, the function returns the grade found. Otherwise,
    it will return none."""

    # This is based off of Zybooks section 7.2.1
    low = 0
    high = len(gradebook) - 1

    while high >= low:
        mid = (high + low) // 2
        if gradebook[mid][1] < student_name:
            low = mid + 1
        elif gradebook[mid][1] > student_name:
            high = mid - 1
        else:
            return gradebook[mid][0]
    return None


def sorted_put(gradebook, student_name, student_grade):
    """This function takes three parameters, a gradebook, a student name, and a student grade. This function uses the
    linear search function to find the student name in the gradebook. It will then either replace the tuple for the
    student with the updated grade, or it will add a new one for a new student. This will not return a value."""

    result = linear_search(gradebook, student_name)

    if result == -1:
        if gradebook == []:
            gradebook.append((student_grade, student_name))
        else:
            for x in range(len(gradebook)):
                if gradebook[x][1] > student_name:
                    gradebook.insert(x, (student_grade, student_name))
                    break
            if gradebook[-1][1] < student_name:
                gradebook.append((student_grade, student_name))
    else:
        for x in range(len(gradebook)):
            if gradebook[x][1] == student_name:
                gradebook[x] = (student_grade, student_name)


def linear_search(gradebook, student_name):
    """This function uses the linear search algorithm from section 7.1.1 on Zybooks. This specific linear search
     searches through gradebook for a specific student name and returns the grade at that student_name. If there exists
     no student with that name it returns -1"""

    # Based off of Zybooks section 7.1.1
    for x in range(len(gradebook)):
        if gradebook[x][1] == student_name:
            return gradebook[x][0]
    return -1
