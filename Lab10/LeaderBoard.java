/**
 * An object that tracks the top-N values of a larger collection.
 * This data structure stores N elements of any sortable type.
 * (NOTE -- while we initially envisioned this in relation to GameScores -- we're building this with generics
 *          and interfaces so it can work with ANY sortable data type. This is a common way to build software
 *          you use an example to determine a need -- but you design to be as flexible as possible.)
 * @param <T> the type of data stored in this LeaderBoard object -- must be a sortable type with defines the compareTo method.
 */
public class LeaderBoard <T extends Comparable<T>> {

    // do not change.
    private T[] scores;

    /**
     * Create a new leaderboard
     * @param size the size of the leaderboard
     * @param dflt the default value for each position in the leaderboard.
     */
    @SuppressWarnings("unchecked")
    public LeaderBoard(int size, T dflt) {
        // do not change.

        // we don't want to deal with small-size boards.
        if (size < 2) {
            size = 2;
        }
        // This line will always have a warning on it (if we hadn't suppressed that on line 17)
        // quite frankly it's a bit messy to begin with -- but it turns out generics and arrays don't play well together.
        // and this is generally understood to be the best we can do for making a generic array.
        scores = (T[]) new Comparable[size];

        for (int i = 0; i < size; i++) {
            scores[i] = dflt;
        }
    }

    /**
     * This gets the size of the leaderboard
     * @return an int
     */
    public int getSize(){
        int size = scores.length;
        return size;
    }

    /**
     * This gets the highscore on the leaderboard
     */
    public T highScore() {
        T highScore = scores[0];
        return highScore;
    }

    /**
     * This gets the lowest score on the leaderboard
     */
    public T lowScore() {
        T lowScore = scores[scores.length - 1];
        return lowScore;
    }

    /**
     * This function will add newScore to the leaderboard, keeping the ordering of largest to smallest
     * @param newScore this is a score that will be compared to the current scores on the leaderboard
     */
    public void add(T newScore)
    {
        if(newScore.compareTo(scores[scores.length - 1]) > 0)
        {
            scores[scores.length - 1] = newScore;
            T tempScore;

            for(int swap = scores.length - 2; swap > 0; swap--)
            {
                if(newScore.compareTo(scores[swap]) > 0)
                {
                    tempScore = scores[swap];
                    scores[swap] = newScore;
                    scores[swap + 1] = tempScore;
                }
            }
            if(newScore.compareTo(scores[0]) > 0)
            {
                tempScore = scores[0];
                scores[0] = newScore;
                scores[1] = tempScore;
            }
        }
    }

    @Override
    public String toString() {
        // do not change.
        String retVal = "";
        for (int i = 0; i < scores.length; i++) {
            retVal += (i+1) + ". " + scores[i].toString() + "\n";
        }
        return retVal;
    }

}
