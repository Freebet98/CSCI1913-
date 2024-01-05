import java.util.Arrays;
import java.util.Random;

import static java.lang.Character.getNumericValue;
import static java.lang.Character.toLowerCase;

//CSCI1913 FALL2022 KLUVER
//Author: Bethany Freeman
public class CharBag
{
    private int size;
    private LinkedChainNode[] bag;

    /**
     * This creates an object of the CharBag class
     * It creates a LinkedChainNode for each letter of the english alphabet
     */
    public CharBag()
    {
        //Initialize array bag, this is O(1) since the array is always size of 27
        bag = new LinkedChainNode[27];
        for(int i = 0; i < bag.length; i++)
        {
            LinkedChainNode node;
            if(i == 26)
            {
                node = new LinkedChainNode(LetterSample.STOP);
            }
            else
            {
                node = new LinkedChainNode((char) (i + 97));
            }

            bag[i] = node;
        }

        size = 0;
    }

    /**
     * This will add a letter to the CharBag unless it is not a part of the English alphabet.
     * @param letter this is a passed english alphabet letter
     */
    public void add(char letter)
    {
        char lowerLetter = toLowerCase(letter);
        int index = checkStop(lowerLetter);

        bag[index].setCount(bag[index].getCount() + 1);
        size = size + 1;
    }

    /**
     * This function will remove a char from the bag
     * @param letter this is the char to be removed
     */
    public void remove(char letter)
    {
        int index = checkStop(letter);

        if(bag[index].getCount() > 0)
        {
            bag[index].setCount(bag[index].getCount() - 1);
            size = size - 1;
        }
    }

    /**
     * @param letter this is the letter you want the count of
     * @return an int of the count
     */
    public int getCount(char letter)
    {
        int index = hash(letter);

        return bag[index].getCount();
    }

    /**
     * @return The size of the bag
     */
    public int getSize()
    {
        return size;
    }

    /**
     * This will get a random letter from the bag only if it is not empty. This takes into account probability
     * based off of the size of the entire bag and the count of each individual letter.
     * @return a letter from the bag assuming the bag has letters.
     */
    public char getRandomChar()
    {
        Random rng = new Random();

        //This checks to satisfy the condition of rng.nextInt() having a bound of 0 or lower
        if (size <= 0)
        {
            return LetterSample.STOP;
        }

        int count = rng.nextInt(size);

        //This goes through all the letters getting rid of their count and returning them if the count is below zero.
        //This relies on the rng.nextInt(size) random for count
        for(int i = 0; i < 26; i++)
        {
            count = count - bag[i].getCount();
            if(count < 0)
            {
                return bag[i].getLetter();
            }
        }

        return LetterSample.STOP;
//
    }

    /**
     * This will create a readable output of the bag for the user
     * @return a string
     */
    public String toString()
    {
        String returnString = "";
        returnString += "CharBag{";

        //This runs through each letter and adds it to the toString. Runs O(1) since it will always run 27 times
        for(int i = 0; i < 27; i++)
        {
            returnString += bag[i].getLetter();
            returnString += ":";
            returnString += bag[i].getCount();
            if(i < 26)
            {
                returnString += ", ";
            }
        }

        returnString += "}";
        return returnString;
    }

    /**
     * @param letter this is the char that gets passed to the hash function
     * @return the index of where this letter is in the hashtable
     */
    private int hash(char letter)
    {
        int returnIndex;

        if((int) letter > 96 && (int)letter < 123)
        {
            returnIndex = (int) letter - 97;
        }
        else
        {
            returnIndex = 26;
        }

        return returnIndex;
    }

    /**
     * This uses the hash function to check if the index is the stop variable or not and changes the index
     * based on that answer
     * @param letter the passed char
     * @return an index
     */
    private int checkStop(char letter)
    {
        int index;
        if((int) letter > 96 && (int) letter < 123)
        {
            index = hash(letter);
        }
        else
        {
            letter = LetterSample.STOP;
            index = hash(letter);
        }

        return index;
    }

    /**
     * This class is to help create the data structure that is CharBag
     * This is based off of Lab12
     * There is no set method for letter because once the letters have been created
     * the user has no reason to change them
     */
    static private class LinkedChainNode
    {
        private char letter; //key
        private int count; //value

        /**
         * This constructs an object of a LinkedChainNode and the count is set to 1 to start
         * @param letter is a single char
         */
        public LinkedChainNode(char letter)
        {
            this.letter = letter;
            count = 0;
        }

        /**
         * @return the letter variable
         */
        public char getLetter()
        {
            return letter;
        }

        /**
         * @return the count variable for the letter key
         */
        public int getCount()
        {
            return count;
        }

        /**
         * This will update the count variable
         * @param count this is the new updated count
         */
        public void setCount(int count)
        {
            this.count = count;
        }

        /**
         * This will check if two LinkedChainNodes are equal to each other
         * @param object this is a passed object
         * @return true or false
         */
        public boolean equals(Object object)
        {
            if(object instanceof LinkedChainNode)
            {
                if(((LinkedChainNode) object).letter == letter && ((LinkedChainNode) object).count == count)
                {
                    return true;
                }
            }

            return false;
        }
    }

}
