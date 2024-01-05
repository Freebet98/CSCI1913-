# CSCI 1913 Lab 01 Fall 2022
# All assignments should start with a "header comment" like this one.
# it should list what the file is (lab01 fall 2022) and who wrote it (below)
# This will be a standing REQUIREMENT for the whole semester.
# Author: Bethany Freeman


# NOTE: You should pay attention to how this file is structured -- you'll be making these files on your own after this
# lab -- so you'll want to know about all the "details" (other than correct code) that we expect! The big things to pay
# attention to here is the header comment at the top, and the docstrings (STRINGS on the first line of a function
# describing what the function does) -- this is a formal part of the programming language that is used to document code.

def num_divisors(n, count=0):
    """Given an integer input n, return the number of positive integers that are divisors of n
    (including 1 and itself)"""
    if n <= 0:
        return 0
    elif n > 0:
        for var in range(1, n + 1):
            if (n / var).is_integer():
                count += 1
        return count


# hard to make this NOT work on negative numbers with num_divisors being weird for negatives.
def is_highly_composite_number(n):
    """ an integer n is a highly composite number if and only if it is a positive integer with
    more divisors than any positive interger smaller than it."""
    if n <= 0:
        return False
    if n == 1:
        return True
    else:
        temp_hold = num_divisors(1)
        temp_var = 1
        for var in range(2, n + 1):
            if num_divisors(var) > temp_hold:
                temp_var = var
                temp_hold = num_divisors(var)
        if temp_var != n:
            return False
        else:
            return True


# returns string of the name of Kluvers cat
def kluver_cat_name():
    return "Willow"


# REMINDER: For submission you should have no code outside of functions.
# it can be quite useful **while developing your code** to use print statements
# at the end of this file to run tests (example:)
# but, for the actual submission -- this has to be deleted
