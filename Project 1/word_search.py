import random

# CSCI 1913 Fall 2022
# Author: Bethany Freeman

# QUESTIONS

# Question 1: What is the worst-case big-O runtime of your get_size function?
Question1 = """The worst case big-O runtime of my get_size function is O(1). N = len(word_grid) which there are two lines
that equal the two lengths of the two array. Meaning both are O(1) meaning the function is O(1)"""

# Question 2: What is the worst-case big-O runtime of your copy_word_grid function?
Question2 = """The worst case big-O runtime of my copy_word_grid function is O(N^2). N = word_grid, The first thing that 
deals with our word_grid in this function is the for loop. The first for loop iterates through every element in the first
list in our 2d list word_grid making its runtime O(N). The second time we deal with our word_grid is a second for loop
within the first for loop. This for loop iterates through every element of the second list in our 2d list making the 
runtime O(N). Since its a for loop in a for loop our current runtime so far is O(N*N). There is no where else where we
deal with our word_grid in this function. Making the big-O runtime O(N^2)"""

# Question 3: What is the worst-case big-O runtime of your extract function?
Question3 = """The worst case big-O runtime of my extract function is O(N). N = max_len, The first time we see max_len be
used is in a for loop that iterates through the length of max_len making it O(N). We do not see it used anywhere else."""

# Question 4: What is the worst-case big-O runtime of your find function?
Question4 = """The worst case big-O runtime of my find function is O(N^2). N =len(word_grid), the first time we see 
len(word_grid) used is in a for loop iterating through all the variables in the first list of the 2d list word_grid, 
this is O(N). The second time we see len(word_grid used is in a for loop nested under the for loop talked about above. 
This for loop iterates through all the variables in the second list of the 2d list word_grid, this is O(N). There is no
where else we see len(word_grid), making this function O(N^2)"""

# This code defines valid directions a word can travel.
# Each direction is a tuple (dx, dy) that says how you change x and y 
# coordinates to go in a given direction.
RIGHT = (1, 0)  # to go right add 1 to x
DOWN = (0, 1)  # to go down add 1 to y
RIGHT_DOWN = (1, 1)  # to go right_down add 1 to both x and y
RIGHT_UP = (1, -1)  # to go right_up add 1 to x and subtract 1 from y
DIRECTIONS = (RIGHT, DOWN, RIGHT_DOWN, RIGHT_UP)


def get_size(word_grid):
    """This function takes 1 parameter, a word grid and, it returns the size of the word grid in the form of a tuple."""
    height = len(word_grid)
    width = len(word_grid[0])

    return width, height


def print_word_grid(word_grid):
    """This function takes one parameter, word grid and, it returns nothing. This function prints out the passed word
     grid in a row-by-row format. It will not modify the passed word grid."""
    for height in word_grid:
        for width in height:
            print(width, end='')
        print()


def copy_word_grid(word_grid):
    """This function takes one parameter, word grid, and it returns a copy of the passed word grid without modifying the
    passed word grid."""
    copy_of_word_grid = []
    for height in word_grid:
        row = []
        for width in height:
            row.append(width)
        copy_of_word_grid.append(row)
    return copy_of_word_grid


def extract(word_grid, position, direction, max_len):
    """This function takes four parameters, a word grid, a position, a direction, and maximum length. This function
    extracts a string from the passed word grid starting at the passed position and moving in the passed direction, it
    can contain no more letters than the maximum length allows. A string does not necessarily need to be as long as the
     maximum length to be returned. This will return a string and will not modify any of the passed parameters."""

    extracted_word = ""
    x = get_position_x(position)
    y = get_position_y(position)

    for i in range(max_len):
        try:
            if y == -1:
                raise Exception
            extracted_word += word_grid[y][x]
            x = check_and_move_x(direction, x)
            y = check_and_move_y(direction, y)

        except:
            break
    return extracted_word


# Solver Functions
def find(word_grid, word):
    """This function takes two parameters, a word grid and a word. If the passed word can be found in the passed word
    grid then the location and the direction, where the word is found, are returned. Otherwise, the function returns
    none. This function will not modify the passed parameters."""
    max_len = len(word)

    for height in range(len(word_grid)):
        for width in range(len(word_grid[0])):
            location = width, height
            if extract(word_grid, (width, height), (1, 0), max_len) == word:
                return location, (1, 0)
            elif extract(word_grid, (width, height), (0, 1), max_len) == word:
                return location, (0, 1)
            elif extract(word_grid, (width, height), (1, 1), max_len) == word:
                return location, (1, 1)
            elif extract(word_grid, (width, height), (1, -1), max_len) == word:
                return location, (1, -1)

    return None


def show_solution(word_grid, word):
    """This function takes two parameters, a word grid and a word. If the passed word cannot be found then a simple
    message will be printed stating so. If the passed word can be found then the word is capitalized within the passed
    word grid and the entire word grid is printed. This function will not modify the passed parameters"""
    upper_word = word.upper()
    if find(word_grid, word) is None:
        print(word, "is not found in this word search")
    else:
        copy_of_grid = copy_word_grid(word_grid)
        location = find(word_grid, word)[0]
        y = get_position_y(location)
        x = get_position_x(location)
        direction = find(word_grid, word)[1]
        for i in range(len(word)):
            try:
                if y == -1:
                    raise Exception
                change_letter = upper_word[i]
                copy_of_grid[y][x] = change_letter
                x = check_and_move_x(direction, x)
                y = check_and_move_y(direction, y)
            except:
                break

        print(upper_word, "can be found as below")
        print_word_grid(copy_of_grid)


# Generate Functions: These functions work together to generate novel word-search puzzles.
def make_empty_grid(width, height):
    """This function takes two integers, width and height, and returns a new empty word grid. The word grid is filled
    with '?' initially in all positions."""
    empty_grid = []
    for h in range(height):
        grid = []
        for w in range(width):
            grid.append('?')
        empty_grid.append(grid)
    return empty_grid


# TODO:Complete This
def can_add_word(word_grid, word, position, direction):
    """This function takes four parameters, a word grid, a word, a position, and a direction. This function checks if it
    is currently possible for the passed word to be added to the passed word grid in the passed position and passed
    direction. The function will return true if there is enough space for the word to fit and there are no other letters
    than '?' or the same letter as would be in that word in that position. Otherwise, return false."""
    for i in range(len(word)):
        extracted_word = extract(word_grid, position, direction, len(word))
        for m in range(len(word)):
            if (extracted_word[m] == '?' or extracted_word[m] == word[m]) and len(word) == len(extracted_word):
                return True
            else:
                return False
    return False


# TODO:Complete This
def do_add_word(word_grid, word, position, direction):
    """This function takes four parameters, a word grid, a word, a position, and a direction. This function changes the
     passed word grid to add the passed word at the passed position in the passed direction. This function will not
     check to make sure that the word can be added. This function will modify the passed word grid."""
    x = get_position_x(position)
    y = get_position_y(position)

    for i in range(len(word)):
        try:
            if y == -1:
                raise Exception
            word_grid[y][x] = word[i]
            x = check_and_move_x(direction, x)
            y = check_and_move_y(direction, y)

        except:
            break


def fill_blanks(word_grid):
    """This function takes one parameter, a word grid. It will loop through the passed word grid and fill all the 'blank'
    spots with a random lowercase letter from the random_lowercase_letter function. This will modify the passed word grid"""
    for height in range(len(word_grid)):
        for weight in range(len(word_grid[height])):
            if word_grid[height][weight] == '?':
                word_grid[height][weight] = random_lowercase_letter()


# Helper Functions:
def random_lowercase_letter():
    """This function uses random choice to get a random lower case letter and return it"""
    random_letter = random.choice("abcdefghijklmnopqrstuvwxyz")
    return random_letter


def get_position_x(position):
    """This function takes one parameter a position. It returns the width which is taken from the first spot of the
    position tuple"""
    width = position[0]
    return width


def get_position_y(position):
    """This function takes one parameter a position. It returns the height which is taken from the second spot of the
    position tuple"""
    height = position[1]
    return height


def check_and_move_x(direction, x):
    """This function takes two parameters a direction and a variable x. This function then move the x depending on
    the direction and returns the moved x"""
    if direction == (1, 0):
        x = x + 1
    elif direction == (0, 1):
        x = x + 0
    elif direction == (1, 1):
        x = x + 1
    elif direction == (1, -1):
        x = x + 1
    return x


def check_and_move_y(direction, y):
    """This function takes two parameters a direction and a variable y. This function them moves the y depending on
    the direction and returns the moved y"""
    if direction == (1, 0):
        y = y + 0
    elif direction == (0, 1):
        y = y + 1
    elif direction == (1, 1):
        y = y + 1
    elif direction == (1, -1):
        y = y - 1
    return y


# Provided Code:
def add_word(word_grid, word):
    """This function checks takes 2 parameters, a word grid and a word. It uses the get_size function to find the width
    and height of the given word grid. It gives a random direction, a random width, and a random height, and checks if
    the given word can be added and if it can be, it adds it and returns True. Otherwise, it returns false. """
    width, height = get_size(word_grid)
    for attempt_num in range(50):
        direction = random.choice(DIRECTIONS)
        x = random.randrange(width)
        y = random.randrange(height)
        location = (x, y)
        if can_add_word(word_grid, word, location, direction):
            do_add_word(word_grid, word, location, direction)
            return True
    return False


def generate(width, height, words):
    """This function takes 3 parameters, a width, height and words. This function generates a word grid of the given
    width and height and makes sure the given words are within it."""
    words_actual = []
    word_grid = make_empty_grid(width, height)
    for word in words:
        if add_word(word_grid, word):
            words_actual.append(word)
    fill_blanks(word_grid)
    return word_grid, words_actual
