import java.awt.*;
//CSCI1913 FALL 2022 KLUVER
//Author: Bethany Freeman
public class EncryptUtils
{
    /**
     * This checks the cipher for what class it is the instance of, checking the subclasses first since
     * all the subclasses are technically instances of BaseCipher. When it appears as one of the subclasses
     * it will be converted into a new variable using polymorphism to represent a variable of the class it is
     * an instance of and the encrypt method of that class will be called.
     * @param cipher This is a cipher of class BaseCipher or one of its subclasses
     * @param stringArray This is an array of strings to encrypt
     * @return This returns an array on encrypted strings
     */
    public static String[] encryptMany(BaseCipher cipher, String[] stringArray)
    {
        String[] encryptedArray = new String[stringArray.length];

        if(cipher instanceof CaesarCipher)
        {
            for(int i = 0;i < stringArray.length; i ++)
            {
                CaesarCipher cipherC = (CaesarCipher) cipher;
                encryptedArray[i] = cipherC.encrypt(stringArray[i]);
            }
        }
        else if (cipher instanceof WordReplacementCipher)
        {
            for(int i = 0;i < stringArray.length; i ++)
            {
                WordReplacementCipher cipherW = (WordReplacementCipher) cipher;
                encryptedArray[i] = cipherW.encrypt(stringArray[i]);
            }
        }
        else if(cipher instanceof EvenOddCipher)
        {
            for(int i = 0;i < stringArray.length; i ++)
            {
                EvenOddCipher cipherE = (EvenOddCipher) cipher;
                encryptedArray[i] = cipherE.encrypt(stringArray[i]);
            }
        }
        else
        {
            for(int i = 0;i < stringArray.length; i ++)
            {
                encryptedArray[i] = cipher.encrypt(stringArray[i]);
            }
        }

        return encryptedArray;
    }

    /**
     * This checks the cipher for what class it is the instance of, checking the subclasses first since
     * all the subclasses are technically instances of BaseCipher. When it appears as one of the subclasses
     * it will be converted into a new variable using polymorphism to represent a variable of the class it is
     * an instance of and the decrypt method of that class will be called.
     * @param cipher this is an instance of a BaseCipher object or one of its subclasses
     * @param stringArray this is a string array of encrypted strings
     * @return This returns a string array of decrypted strings
     */
    public static String[] decryptMany(BaseCipher cipher, String[] stringArray)
    {
        String[] decryptedArray = new String[stringArray.length];

        if(cipher instanceof CaesarCipher)
        {
            for(int i = 0;i < stringArray.length; i ++)
            {
                CaesarCipher cipherC = (CaesarCipher) cipher;
                decryptedArray[i] = cipherC.decrypt(stringArray[i]);
            }
        }
        else if (cipher instanceof WordReplacementCipher)
        {
            for(int i = 0;i < stringArray.length; i ++)
            {
                WordReplacementCipher cipherW = (WordReplacementCipher) cipher;
                decryptedArray[i] = cipherW.decrypt(stringArray[i]);
            }
        }
        else if(cipher instanceof EvenOddCipher)
        {
            for(int i = 0;i < stringArray.length; i ++)
            {
                EvenOddCipher cipherE = (EvenOddCipher) cipher;
                decryptedArray[i] = cipherE.decrypt(stringArray[i]);
            }
        }
        else
        {
            for(int i = 0;i < stringArray.length; i ++)
            {
                decryptedArray[i] = cipher.decrypt(stringArray[i]);
            }
        }

        return decryptedArray;
    }
}
