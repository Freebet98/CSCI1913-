import java.lang.Math;

/*
 * CSCI 1913
 * Lab 06
 * Author: Bethany Freeman
 * */
public class Altitools
{

    /**
     * Computes the steepest angle (Raising or falling) in a mountain range
     * @param mountainRange an array of doubles representing the heights of a mountain range. Will not be modified
     * @return the steepest upward/downward angle in the mountain range as a positive value measured in degrees.
     */
    public static double steepest_angle(double [] mountainRange)
    {
        double [] mountain = mountainRange;

        if(mountain.length == 0)
        {
            return 0.0;
        }
        else
        {
            double holdVar = mountain[0];
            int x = 1;
            double holdChange = 0;

            while (x < mountain.length)
            {
                if(Math.abs(holdVar - mountain[x]) > holdChange)
                {
                    holdChange = Math.abs(holdVar - mountain[x]);
                }

                holdVar = mountain[x];
                x++;
            }

            double mountainAngleR = Math.atan2(holdChange, 1);
            double angleInDegree = Math.toDegrees(mountainAngleR);

            return angleInDegree;
        }
    }

    /**
     * Get the total "travel distance" over a mountain range
     * @param mountainRange an array of doubles representing the heights of a mountain range.  Will not be modified
     * @return the travel distance -- a non-negative double.
     */
    public static double total_distance(double [] mountainRange)
    {
        double [] mountain = mountainRange;
        double distance = 0;

        if(mountain.length == 1 || mountain.length == 0)
        {
            return distance;
        }
        else
        {
            int x = 1;
            while(x < mountain.length)
            {
                distance += Math.sqrt(Math.pow((mountain[x-1] - mountain[x]), 2) + 1);
                x += 1;
            }
        }

        return distance;
    }

    /**
     * compute the longest (in terms of travel distance) sequentially climbing part of a mountain range.
     * @param mountainRange an array of doubles representing the heights of a mountain range. Will not be modified
     * @return the latest travel distance of any sequentially climbing segment of the mountain range
     */
    public static double longest_sequential_climb(double [] mountainRange)
    {
        double [] mountain = mountainRange;
        double [] sequentialClimb = new double[]{};
        double longestTravelDistance;

        if(mountain.length == 1 || mountain.length == 0)
        {
            return 0;
        }
        else
        {
            int hold = 0;
            int x = 1;

            while(x < mountain.length)
            {
                if(mountain[x-1] < mountain[x])
                {
                    try
                    {
                        sequentialClimb[hold] += (Math.sqrt(Math.pow((mountain[x-1] - mountain[x]), 2) + 1));
                    }
                    catch(Exception e)
                    {
                        sequentialClimb = new_array(sequentialClimb,(Math.sqrt(Math.pow((mountain[x-1] - mountain[x]), 2) + 1)));
                    }

                    x++;
                }
                else
                {
                    hold++;
                    x++;
                }
            }
        }

        if(sequentialClimb.length == 0)
        {
            longestTravelDistance = 0;
        }
        else
        {
           sequentialClimb = selection_sort(sequentialClimb);
           longestTravelDistance = sequentialClimb[sequentialClimb.length - 1];
        }

        return longestTravelDistance;
    }

    /**
     * compute the number of peaks (higher than it's neighbors) and valleys (lower than it's neighbors) in a mountain
     * @param mountainRange an array of doubles representing the heights of a mountain range. Will not be modified
     * @return a length 2 int array. position 1 is the number of peaks and position 2 the number of valleys.
     */
    public static int[] num_of_peaks_and_valleys(double [] mountainRange)
    {
        double [] mountain = mountainRange;
        int [] numPeakValleys;

        int peaks = 0;
        int valleys = 0;

        if(mountain.length <= 2)
        {
            peaks = 0;
            valleys = 0;
        }
        else
        {
            for(int x = 1; x < mountain.length - 1; x++)
            {
                if (mountain[x - 1] > mountain[x] && mountain[x] < mountain[x+1])
                {
                    valleys += 1;
                }
                else if(mountain[x - 1] < mountain[x] && mountain[x] > mountain[x+1])
                {
                    peaks += 1;
                }
            }
        }

        numPeakValleys = new int[]{peaks, valleys};

        return numPeakValleys;
    }

    /**
     * Creates a new array to indicate what would happen if we were to hypothetically fill the lowest parts of a
     * mountain range up to a fixed height
     * @param mountainRange an array of doubles representing the heights of a mountain range. Will not be modified
     * @param target a double. the new array will have all positions below this filled up to this height
     * @return a new array showing the result of filling in the array
     */
    public static double[] fill_valleys(double [] mountainRange, double target)
    {
        double [] mountain = mountainRange;
        double [] newList = new double[]{};

        if(mountain.length == 0)
        {
            return newList;
        }
        else
        {
            int x = 0;
            while(x < mountain.length)
            {
                if(mountain[x] < target)
                {
                    newList = new_array(newList, target);
                    x += 1;
                }
                else
                {
                    newList = new_array(newList, mountain[x]);
                    x += 1;
                }
            }

            return newList;
        }
    }

    /**
     * Creates a new array from the passedArray and adds a value to it and returns a new array with that new value added
     * @param passedArray an array of doubles representing the current state of the array when it was given to the
     *                    function
     * @param value the value to be added to the array
     * @return a new array with the @param value added to it.
     */
    public static double[] new_array(double [] passedArray, double value)
    {
        double [] tempArray = new double[passedArray.length + 1];

       if(passedArray.length != 0)
       {
           for(int x = 0;x != passedArray.length; x++)
           {
               tempArray[x] = passedArray[x];
           }
       }

       tempArray[passedArray.length] = value;



        return tempArray;
    }

    /**
     * Based off of Zybook section 8.2.1 Selection sort. This takes the passed array and sorts it by repeatedly comparing
     * two indexes to each other until it find the smallest one and moves that one to the front, and so on until it has
     * sorted the entire array.
     * @param passedArray this is an array of double that is unsorted
     * @return a new sorted array of the passedArray
     */
    public static double[] selection_sort(double [] passedArray)
    {
        double[] tempArray = passedArray;
        double temp;

        for(int i = 0; i != tempArray.length; i++)
        {
            int smallestIndex = i;
            for(int j = i +1; j != tempArray.length; j++)
            {
                if(tempArray[j] < tempArray[smallestIndex])
                {
                    smallestIndex = j;
                }
            }

            temp = tempArray[i];
            tempArray[i] = tempArray[smallestIndex];
            tempArray[smallestIndex] = temp;
        }

        return tempArray;
    }
}




