//CSCI1913 Fall2020 KLUVER
//Author: Bethany Freeman

public class Hangman extends Game
{
    //Game Setting Variables
    WordsList words;
    int minWordLen;
    int maxWordLen;
    int maxGuesses;

    //Each Round Variables
    String secretWord;
    int countGuesses;
    char[] clueString;

    /**
     * This constructs a new instance of the Hangman class
     * @param words is a WordsList object
     * @param minWordLen is the minimum word length
     * @param maxWordLen is the maximum word length
     * @param maxGuesses is the maximum guesses allowed in the game
     */
    public Hangman(WordsList words, int minWordLen, int maxWordLen, int maxGuesses)
    {
        this.words = words;
        this.minWordLen = minWordLen;
        this.maxWordLen = maxWordLen;
        this.maxGuesses = maxGuesses;
    }

    /**
     * This method sets the variable secretWord to a string from the object WordList words,
     * it resets countGuesses to 0 and it finishes creating the char array clue string
     * of length secretWord's length
     * @return a message to the user about the current game state
     */
    @Override
    protected String prepToPlay()
    {
        secretWord = words.getWord(minWordLen, maxWordLen);
        countGuesses = 0;
        clueString = new char[secretWord.length()];
        for(int i = 0; i < clueString.length; i++)
        {
            clueString[i] = '_';
        }

        return "I've picked a " + secretWord.length() + " letter word. Guess letters you think are in the word. You get "
                + maxGuesses + " guesses.";
    }

    /**
     * This method checks if any value in the clueString array equals _ or
     * if countGuesses does not equal maxGuesses, in which case the game would be
     * over. Otherwise, the game continues.
     * @return true or false
     */
    @Override
    protected boolean isOver()
    {
        String clue = "";
        for (char c : clueString) {
            clue += c;
        }

        if(countGuesses == maxGuesses)
        {
            return true;
        }
        else return clue.equals(secretWord);
    }

    /**
     * This checks if the length of move is 1 character long
     * @param move is a string of input from the user
     * @return true or false
     */
    @Override
    protected boolean isValid(String move)
    {
        return move.length() == 1;
    }

    /**
     * this processes a move of hangman. It adds a guess to the guess counter,
     * checks if the move string equals any of the letters in the secret word and
     * exchanges all of them in the clueString, and then prints out the updated
     * clueString.
     * @param move this is a single character string input from the user
     * @return a new clueString
     */
    @Override
    protected String processMove(String move)
    {
        this.countGuesses++;

        for(int i = 0;i < clueString.length; i++)
        {
            if(move.charAt(0) == secretWord.charAt(i))
            {
                clueString[i] = secretWord.charAt(i);
            }
        }

        String clue = "";
        for(int i = 0; i < clueString.length; i++)
        {
            clue += clueString[i];
        }

        return clue;
    }

    /**
     * This indicates in a message to the user what the secret word was
     * after the game is over
     * @return a string of the secret word
     */
    @Override
    protected String finalMessage()
    {
        return "The word was: " + secretWord;
    }

    /**
     * @return the name of the game
     */
    @Override
    public String getName()
    {
        return "Hangman";
    }
}
