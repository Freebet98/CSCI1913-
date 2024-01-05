//CSCI1913 FALL2022 KLUVER
//Author: Bethany Freeman
public class GameScore implements Comparable <GameScore>
{
    private double score;
    private String nameRecord;
    private boolean hardMode;

    /**
     * This constructs an object of GameScorer
     * @param score is the double of the score
     * @param nameRecord is the String of the name
     * @param hardMode is the boolean of if the game is on hard mode
     */
    public GameScore(String nameRecord, double score, boolean hardMode)
    {
        this.score = score;
        this.nameRecord = nameRecord;
        this.hardMode = hardMode;
    }

    /**
     * This gets the value of the name property of the object
     * @return nameRecord
     */
    public String getName()
    {
        return nameRecord;
    }

    /**
     * This gets the value of the score property of the object
     * @return score
     */
    public double getScore()
    {
        return  score;
    }

    /**
     * This returns a true of false value based on the hardMode property of the object
     * @return hardMode
     */
    public boolean isHardMode()
    {
        return hardMode;
    }

    /**
     * This compares other and a GameScore object based on difficulty and
     * the score
     * @param other the object to be compared.
     * @return an interger, positve, negative or zero
     */
    public int compareTo(GameScore other)
    {
        int valueHardMode;
        int valueScore;

        if(hardMode == true && other.isHardMode() == true)
        {
            valueHardMode = 0;
        }
        else if (hardMode == false && other.isHardMode() == true)
        {
            valueHardMode = -1;
        }
        else if(hardMode == true && other.isHardMode() == false)
        {
            valueHardMode = 1;
        }
        else
        {
            valueHardMode = 0;
        }

        if(other.getScore() == score)
        {
            valueScore = 0;
        }
        else if(other.getScore() > score)
        {
            valueScore = -1;
        }
        else
        {
            valueScore = 1;
        }

        if(valueScore == 0 && valueHardMode == 0)
        {
            return 0;
        }
        else if (valueHardMode == 1)
        {
            return 1;
        }
        else if(valueHardMode == -1)
        {
            return -1;
        }
        else if(valueHardMode == 0 && valueScore == -1)
        {
            return -1;
        }
        else if(valueHardMode == 0 && valueScore == 1)
        {
            return 1;
        }

        return 0;
    }


    /**
     * This converts the object into a printable string format
     * @return a string value
     */
    public String toString()
    {
        String input = nameRecord + " " + score;

        if(hardMode == true)
        {
            input += "*";
        }
        return input;
    }

    /**
     * This checks if a passed object is an instance of the GameScore class
     * with the same value for score, nameRecord, and hardMode
     * @param object is a passed object of any type
     * @return true of false
     */
    public boolean equals(Object object)
    {
        if(object instanceof GameScore)
        {
            GameScore objectG = (GameScore) object;

            if(objectG.getScore() == ((GameScore) object).score && objectG.isHardMode() == ((GameScore) object).hardMode && objectG.getName() == ((GameScore) object).nameRecord)
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