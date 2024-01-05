//CSCI1913 Fall2022 KLUVER
//Author: Bethany Freeman

public class WordReplacementCipher extends BaseCipher
{
    private String wordReplaceFrom;
    private String wordReplaceTo;

    /**
     * This constructs an object of class WordReplacementCipher
     * @param wordReplaceFrom this is a String that represents the word to replace from
     * @param wordReplaceTo this is a String that represents the word to replace to
     */
    public WordReplacementCipher(String wordReplaceFrom, String wordReplaceTo)
    {
        super("WordReplacementCipher");
        this.wordReplaceFrom = wordReplaceFrom;
        this.wordReplaceTo = wordReplaceTo;
    }

    /**
     * This function encrypts a String input based on the Word Replacement cipher which
     * takes each occurrence of a pre-chosen word, and swaps it with a different pre-chosen
     * word.
     * @param input this is the string to be encrypted
     * @return the encrypted string based on the wordReplacement cipher
     */
    public String encrypt(String input)
    {
        String encryptedInput ;
        if(input.contains(wordReplaceFrom))
        {
            encryptedInput = input.replace(wordReplaceFrom, wordReplaceTo);
        }
        else
        {
            encryptedInput = input;
        }

        return encryptedInput;
    }

    /**
     * This function takes a String input which is encrypted and decrypts it by reversing
     * the word replacement cipher, which takes each occurrence of a pre-chosen word and
     * swaps it with a different pre-chosen word.
     * @param input this is an encrypted String
     * @return the decrypted string based on the reversal of the word replacement cipher
     */
    public String decrypt(String input)
    {
        String decryptInput;

        if(input.contains(wordReplaceTo))
        {
            decryptInput = input.replace(wordReplaceTo, wordReplaceFrom);
        }
        else
        {
            decryptInput = input;
        }

        return decryptInput;
    }

    /**
     * This describes the WordReplacementCipher object
     * @return a string description of the WordReplacementCipher object
     */
    public String toString()
    {
        return "WordReplacementCipher(" + wordReplaceFrom + ", " + wordReplaceTo + ")";
    }

    /**
     * This checks if the passed object is another WordReplacementCipher object with
     * the same from and to words
     * @param object An object presumably of WordReplacementCipher class
     * @return true or false
     */
    public boolean equals(Object object)
    {
        if(object instanceof WordReplacementCipher)
        {
            if(((WordReplacementCipher) object).wordReplaceFrom  == wordReplaceFrom && ((WordReplacementCipher) object).wordReplaceTo == wordReplaceTo)
            {
                return true;
            }
        }
        else
        {
            return false;
        }
        return false;
    }
}
