import java.util.Arrays;

//CSCI1913 FALL2020 KLUVER
//Author: Bethany Freeman
public class SuperCipher extends BaseCipher
{
    // This Variable indicates which ciphers are applied and in what order
    BaseCipher[] cipherApplication;

    /**
     * This constructs an object of the SuperCipher class
     * @param cipherApplication this is a BaseCipher array that indicates which ciphers are applied and in
     *                          what order
     */
    public SuperCipher(BaseCipher[] cipherApplication)
    {
        super("SuperCipher");
        this.cipherApplication = cipherApplication;
    }

    /**
     * This checks if a SuperCipher object is valid. This only checks CaesarCipher since the
     * CaesarCipher object is the only object that changes its isValid key depending on the construction
     * of the object.
     * @return true or false
     */
    public boolean isValid()
    {
        boolean result;

        for (BaseCipher cipher : cipherApplication)
        {
            if (cipher instanceof CaesarCipher)
            {
                CaesarCipher cipherC = (CaesarCipher) cipher;
                result = cipherC.isValid();
                if (!result) {
                    return false;
                }
            }
        }

        return true;
    }

    /**
     * This method encrypts a string based upon the encrypts in the cipherApplication array.
     * @param input this is a string to be encrypted
     * @return an encrypted string
     */
    public String encrypt(String input)
    {
        String encryptedString = input;
        for(int i = 0; i < cipherApplication.length; i++)
        {
            BaseCipher cipher = cipherApplication[i];
            encryptedString = cipher.encrypt(encryptedString);
        }

        return encryptedString;
    }

    /**
     * This will loop through the cipherApplication array backwards in order to undo the encryption put
     * on the input string.
     * @param input this is an encrypted string
     * @return a decrypted String
     */
    public String decrypt(String input)
    {
        String decryptedString = input;

        for(int i = cipherApplication.length - 1; i >= 0; i--)
        {
            BaseCipher cipher = cipherApplication[i];
            decryptedString = cipher.decrypt(decryptedString);
        }

        return decryptedString;
    }

    /**
     * @return a string representing the construction of the object
     */
    public String toString()
    {
        String input = "";
        for(int i = 0; i < cipherApplication.length; i++)
        {
            if(i > 0)
            {
                input += " | ";
            }

            input += cipherApplication[i].toString();
        }


        return "SuperCipher(" + input + ")";
    }

    /**
     * This will compare any object passed to the object of the class SuperCipher
     * and tell you if they are equivalent objects.
     * @param object is an object of some class
     * @return true or false
     */
    public boolean equals(Object object)
    {
        if(object instanceof SuperCipher)
        {
            SuperCipher objectS = (SuperCipher) object;
            if(Arrays.equals(objectS.cipherApplication,cipherApplication))
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        else
        {
            return false;
        }
    }
}
