import static java.lang.Character.isAlphabetic;

public class CaesarCipher
{
    private int key;

    /**
     * This creates a CaesarCipher Object
     * @param key is the int for how many times it will rotate around the alphabet
     */
    public CaesarCipher(int key)
    {
        this.key = key;
    }

    /**
     * This checks to see if the key is between 1 and 25
     * @return true or false
     */
    public boolean isValid()
    {
        return this.key > 0 && this.key < 26;
    }

    /**
     * This function takes a char letter of the lowercase alphabet and rotates it around the alphabet using
     * a given key. It returns a char letter. This is a private function.
     * @param letter the letter of the alphabet initially given to change according to the key
     * @param key is the number of times the letter in the alphabet is supposed to change
     * @return a char letter of the alphabet in lowercase
     */
    private char rotate(char letter, int key)
    {
        int count = letter;
        int rotationsLeft = Math.abs(key);
        char returnLetter;

        for(int k = rotationsLeft;k > 0;k--)
        {

            if(key > 0)
            {
                if(count < 97)
                {
                    count = 121;
                }
                else if (count > 122)
                {
                    count = 97;
                }
                else if(count == 122)
                {
                    count = 96;
                }
                count++;


            }
            else if (key < 0)
            {
                if(count < 97)
                {
                    count = 121;
                }
                else if (count > 122)
                {
                    count = 97;
                }
                else if(count == 97)
                {
                    count = 123;
                }
               count--;
            }
        }

        returnLetter = (char)count;
        return returnLetter;
    }

    /**
     * Encrypts the message with the Caesar Cipher by rotating by the key amount
     * @param message The message to be encrypted
     * @return a encrypted string
     */
    public String encrypt(String message)
    {
        String encryptString = "";
        String messageLowercase = message.toLowerCase();

        for(int i = 0;i < messageLowercase.length();i++)
        {
            char tempChar = messageLowercase.charAt(i);

            if(isAlphabetic(tempChar))
            {
                tempChar = rotate(tempChar, key);
            }
            encryptString += tempChar;
        }

        return encryptString;
    }

    /**
     * This takes an encrypted message and uses the rotate method to
     * decrypt the message uses the negative of the key to rotate it around
     * the alphabet.
     * @param message This is an encrypted message
     * @return a decrypted string of the message
     */
    public String decrypt(String message)
    {
        String decryptString = "";
        String messageLowercase = message.toLowerCase();

        for(int i = 0;i < messageLowercase.length();i++)
        {
            char tempChar = messageLowercase.charAt(i);

            if(isAlphabetic(tempChar))
            {
                tempChar = rotate(tempChar, -(key));
            }
            decryptString += tempChar;
        }

        return decryptString;
    }

    /**
     * This creates a toString to return an output of the object for the user
     * @return the word Caesar with the key in parentheses
     */
    public String toString()
    {
        return "Caesar(" + key +")";
    }
}
