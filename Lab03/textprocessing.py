import math


# CSCI 1913 Lab 03 Fall 2022
# Author: Bethany Freeman

def generate_words_list(words):
    """This function takes a string a splits it into a general list of words where there a spaces within the given
    string. If there is nothing within the given string it will return an empty string"""
    if words == "":
        return []
    else:
        words_list = []
        hold = 0
        for x in words:
            if x != " ":
                try:
                    words_list[hold] += x
                except:
                    words_list.append(x)
            else:
                hold += 1
        return words_list


def remove_stop_words(word_list, word_set):
    """This function takes a list of words and a set of "stop words" and returns a copy of the inputted word list where
     the words from the set of "stop words" have been removed. This also has a counter of all the words in the given
     word list, this is not returned."""
    removed_word_list = []
    count = 0
    for word in word_list:
        if word in word_set:
            count += 1
        else:
            removed_word_list.append(word)
    return removed_word_list


def word_count(given_string):
    """This function takes a string and returns a dictionary that counts how many times each word showed up in the given
    string."""
    if given_string == "":
        return {}
    else:
        given_string_list = generate_words_list(given_string)
        string_dict = {}
        for word in given_string_list:
            if word in string_dict:
                hold_value = string_dict.get(word)
                hold_value += 1
                string_dict[word] = hold_value
            else:
                string_dict.setdefault(word, 1)

        return string_dict


def get_longest_words(given_string):
    """This function takes a string a returns a set contains all the longest words in the given string"""
    given_string_list = generate_words_list(given_string)

    if given_string == "":
        return set()
    else:
        max_hold = 0
        string_set = set()
        for word in given_string_list:
            if max_hold < len(word):
                max_hold = len(word)
        for word in given_string_list:
            if len(word) == max_hold:
                string_set.add(word)
        return string_set


def cal_cosine_similarity(dict1, dict2):
    """This function takes in two dictionaries and, using the cosine similarity equation, determines are returns a
     measurement of how similar the two dictionaries passed into the function are."""
    # sum_one is the sum of squared counts for each word in dict1
    sum_one = 0
    for x in dict1:
        sum_one += math.pow(dict1.get(x), 2)

    # sum_two is the sum of squared counts for each word in dict2
    sum_two = 0
    for x in dict2:
        sum_two += math.pow(dict2.get(x), 2)

    # sum_three is the sum of the word counts in dict1 multiplied by the word counts in dict2, only if in both
    sum_three = 0
    for x in dict1:
        if x in dict2:
            sum_three += (dict1.get(x) * dict2.get(x))

    # find cos-sim
    cos_sim = 0.0
    if sum_one == 0 or sum_two == 0:
        return cos_sim
    else:
        cos_sim = sum_three / ((math.sqrt(sum_one)) * (math.sqrt(sum_two)))
    return round(cos_sim, 4)


def most_similar_string(query_string, string_list):
    """This function takes a single string and a list of secondary strings and compares the single string to all the
    secondary strings and returns the string that is the most similar"""

    query_string_dict = word_count(query_string)

    if not string_list:
        return ""
    else:
        hold_value = 0
        hold_string = ''
        for x in range(len(string_list)):
            temp_dict = word_count(string_list[x])
            temp_cal_similarity = cal_cosine_similarity(query_string_dict, temp_dict)
            if hold_value < temp_cal_similarity:
                hold_value = temp_cal_similarity
                hold_string = string_list[x]
            temp_dict.clear()

        return hold_string
