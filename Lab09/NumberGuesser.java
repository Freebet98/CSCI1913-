import java.util.Random;
//CSCI1913 FALL2022 KLUVER
//Author: Bethany Freeman

public class NumberGuesser extends Game
{
    //Game Setting Variables
    Random rng;
    int maxNumber;
    int maxGuesses;

    //Each Round Variables
    int secretNumber;
    int guessCount;
    boolean guessCorrect;

    /**
     * This constructs a new instance of the NumberGuesser game
     * @param rng this is a random object used to generate the secret numbers
     * @param maxNumber this is the maximum number to use when generating the secret number, this is inclusive
     * @param maxGuesses this is the max number of guesses the user is allowed before the game is over
     */
    public NumberGuesser(Random rng, int maxNumber, int maxGuesses)
    {
        this.rng = rng;
        this.maxNumber = maxNumber;
        this.maxGuesses = maxGuesses;
    }

    /**
     * This sets the secret number to a random value between 1 and the maxNumber,
     * It updates the guessCount to 0, and updates the guessCorrect variable to false.
     * @return a message to the user about the game state
     */
    @Override
    protected String prepToPlay()
    {
        secretNumber = rng.nextInt(maxNumber) + 1;
        guessCount = 0;
        guessCorrect = false;

        return "I've picked a number 1 to " + maxNumber + ". You get " + maxGuesses + " guesses to guess it";
    }

    /**
     * This checks if the user guessed correctly or if they reached the max guesses
     * @return true or false
     */
    @Override
    protected boolean isOver()
    {
        if(guessCorrect == true || guessCount == maxGuesses)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    /**
     * This checks if the string the user inputted was a positive number
     * @param move string input from user
     * @return true or false
     */
    @Override
    protected boolean isValid(String move)
    {
        if(move.length() == 0)
        {
            return false;
        }
        else
        {
            for(int i = 0; i < move.length(); i++)
            {
                char c = move.charAt(i);
                if(!Character.isDigit(c))
                {
                    return false;
                }
            }
        }

        return true;
    }

    /**
     * This takes the string move and converts it to an integer. Using that integer
     * it gets compared to secret number and depending on if its lower, higher, or just right
     * a corresponding string is returned. It also adds 1 to guess count and sets guessCorrect
     * to true or false depending on if the user is correct.
     * @param move a String input from the user
     * @return a string about the move compared to the secret number
     */
    @Override
    protected String processMove(String move)
    {
        int intMove = Integer.parseInt(move);
        guessCount += 1;

        if(intMove > secretNumber)
        {
            guessCorrect = false;
            return "Too High";
        }
        else if (intMove < secretNumber)
        {
            guessCorrect = false;
            return "Too Low";
        }

        guessCorrect = true;
        return "That's it!";
    }

    @Override
    protected String finalMessage()
    {
        return "The number was: " + secretNumber;
    }

    /**
     * @return the name of the game Number Guesser
     */
    @Override
    public String getName()
    {
        return "Number Guesser";
    }

    public static void main(String[] args)
    {

    }
}