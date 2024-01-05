import math


# CSCI 1913 Lab 02 Fall 2022
# Author: Bethany Freeman

def steepest_angle(var):
    """This function computes the steepest angle in degrees for a mountain.
    These values come from either a list or a tuple."""
    mountain = convert_to_list(var)

    # this checks all changes in x's that are next to each other and keeps the largest of those changes
    hold_var = mountain[0]
    x = 1
    hold_change = 0
    while x < len(mountain):
        if math.fabs(hold_var - mountain[x]) > hold_change:
            hold_change = math.fabs(hold_var - mountain[x])

        hold_var = mountain[x]
        x += 1

    # mountain_angle_r gets the angle in radians, angle_in_degree converts that angle to degrees
    mountain_angle_r = math.atan2(hold_change, 1)
    angle_in_degree = math.degrees(mountain_angle_r)

    return angle_in_degree


def total_distance(var):
    """This function compute the total climb distance of a mountain from the given values of a tuple or list."""
    mountain = convert_to_list(var)
    distance = 0
    if len(mountain) == 1 or 0:
        distance = 0
    else:
        x = 1
        while x < len(mountain):
            distance += math.sqrt(math.pow((mountain[x - 1] - mountain[x]), 2) + 1)
            x += 1
    return distance


def longest_sequential_climb(var):
    """This function takes the distance formula and uses it to return the longest sequential climb of the mountain.
    The longest sequential climb being where you go up the mountain the greatest distance in one go"""
    mountain = convert_to_list(var)

    sequential_climb = []
    if len(mountain) == 1 or 0:
        return 0
    else:
        hold = 0
        x = 1
        while x < len(mountain):
            if mountain[x - 1] < mountain[x]:
                try:
                    sequential_climb[hold] += (math.sqrt(math.pow((mountain[x - 1] - mountain[x]), 2) + 1))
                except:
                    sequential_climb.append((math.sqrt(math.pow((mountain[x - 1] - mountain[x]), 2) + 1)))

                x += 1
            else:
                hold += 1
                x += 1

    if len(sequential_climb) == 0:
        longest_travel_distance = 0
    else:
        sequential_climb.sort()
        longest_travel_distance = sequential_climb[-1]

    return longest_travel_distance


def num_of_peaks_and_valleys(var):
    """This function counts the number of peaks and valleys in the mountain and returns them in the form of a tuple.
    with peaks presenting first and valleys presenting second."""

    mountain = convert_to_list(var)

    peaks = 0
    valleys = 0
    if len(mountain) <= 2:
        peaks = 0
        valleys = 0
    else:
        for x in range(1, len(mountain) - 1):
            if mountain[x - 1] > mountain[x] < mountain[x + 1]:
                valleys += 1
            elif mountain[x - 1] < mountain[x] > mountain[x + 1]:
                peaks += 1

    return peaks, valleys


def fill_valleys(var, min_height):
    """This function takes 2 variables, 1 of type tuple or list, and 1 of type int. These variables are used to create
    a new list of variables of a hypothetical mountain range heights should the valleys in the mountain range have
    been filled with sand"""
    mountain = convert_to_list(var)

    new_list = []
    if len(mountain) == 0:
        return new_list
    else:
        x = 0
        while x < len(mountain):
            if mountain[x] < min_height:
                new_list.append(min_height)
                x += 1
            else:
                new_list.append(mountain[x])
                x += 1
        return new_list


def convert_to_list(var):
    """this takes a variable of type tuple or list and converts it into a different list as to make
    it usable by other functions and to not change the original given variable"""

    # this converts the given tuple or the given list into a list named mountain.
    converted_list = []
    if isinstance(var, tuple) or isinstance(var, list):
        for x in var:
            converted_list.append(x)

    return converted_list
