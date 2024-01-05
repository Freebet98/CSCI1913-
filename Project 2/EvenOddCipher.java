//CSCI1913 Fall2022 KLUVER
//Author: Bethany Freeman

public class EvenOddCipher extends BaseCipher
{
    /**
     * this constructs an object of the EvenOddCipher class
     */
    public EvenOddCipher()
    {
        super("EvenOddCipher");
    }

    /**
     * This takes a string input and encrypts it using the Even Odd Cipher. This
     * Cipher is implemented by taking all the even letters and putting them next
     * to each other and taking all the odd letters and putting the next to each
     * other.
     * @param input is the String to be encrypted
     * @return a encrypted string
     */
    public String encrypt(String input)
    {
        String evenEncoded = "";
        String oddEncoded = "";
        String encryption;

        int i = 0;
        while(i < input.length())
        {
            if(i % 2 == 0)
            {
                evenEncoded += input.charAt(i);
            }
            else if (i % 2 == 1)
            {
                oddEncoded += input.charAt(i);
            }

            i++;
        }

        encryption = evenEncoded + oddEncoded;
        return encryption;
    }

    /**
     * This takes a encrypted String input and decrypts it using the reverse of
     * the Even Odd Cipher. This is implemented by finding the crossover point in
     * the string, and putting the even and odd letters back into their proper places.
     * @param input is an encrypted String
     * @return a decrypted String
     */
    public String decrypt(String input)
    {
        String decryption = "";
        int half = (int) Math.ceil((double)input.length()/2);
        String evenHalf = input.substring(0, half);
        String oddHalf = input.substring(half);

        for(int i = 0;i < half; i++)
        {
            if(evenHalf.length() > i)
            {
                decryption += evenHalf.charAt(i);
            }
            if(oddHalf.length() > i)
            {
                decryption += oddHalf.charAt(i);
            }
        }
        return decryption;
    }

    /**
     * This describes the object in a String
     * @return a string
     */
    public String toString()
    {
        return "EvenOddCipher";
    }

    /**
     * This compares the object EvenOddCipher and another object that is passed to
     * see if they are equal objects of Class EvenOddCipher
     * @param object is a passed object of a class
     * @return true or false
     */
    public boolean equals(Object object)
    {
        if(object instanceof EvenOddCipher)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}


