import javax.lang.model.type.NullType;

public class KnownSpy
{
    private String name;
    private CaesarCipher cipher;

    /**
     * This creates an instance of the KnownSpy class
     * @param name this is the name of the spy
     * @param cipher this is created instance of the CaesarCipher object
     */
    public KnownSpy(String name, CaesarCipher cipher)
    {
        this.name = name;
        this.cipher = cipher;
    }

    /**
     * This gets the name of the KnownSpy object
     * @return a string of the name
     */
    public String getName()
    {
        return name;
    }

    /**
     * This decrypts a message if the name of the KnownSpy matches who the
     * passed message object is from. Otherwise, it stays encrypted.
     * @param message is a message object
     */
    public void decrypt(Message message)
    {
        if(message.getFrom().equals(name))
        {
            message.setMessage(cipher.decrypt(message.getMessage()));
        }
    }

    /**
     * This function checks if the sender of the message class is one
     * of the knownSpies.
     * @param knownSpies is an array on knownSpy objects
     * @param message is an object of the message class
     * @return True or false
     */
    public static boolean isFromSpy(KnownSpy[] knownSpies, Message message)
    {
        for (KnownSpy knownSpy : knownSpies) {
            if (knownSpy.getName().equals(message.getFrom())) {
                return true;
            }
        }

        return false;
    }

    /**
     * This function uses brute force to check if a given encrypted word
     * when decrypted is within a list of common words that we can then use
     * to determine what the key is.
     * @param encryptedCommonWord this is a encrypted word that is passed
     * @param commonWords this is a string of words that are common
     * @return The string of the common word the encrypted word corresponds
     * to or it returns null
     */
    public static String tryDecrypt(String encryptedCommonWord, String commonWords)
    {
        CaesarCipher cipher;
        String[] commonWordsArray = commonWords.split(" ");
        String decryptedCommonWord;

        for(int i = 1; i < 26; i++)
        {
            cipher = new CaesarCipher(i);
            decryptedCommonWord = cipher.decrypt(encryptedCommonWord);

            for (String s : commonWordsArray) {
                if (s.equals(decryptedCommonWord)) {
                    return s;
                }
            }
        }

        return null;
    }

}
