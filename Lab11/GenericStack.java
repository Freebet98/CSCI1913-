//CSCI1913 FALL2022 KLUVER
//Author: Bethany Freeman
public class GenericStack <ELEM> {
    //variables
    private ELEM[] data;
    private int size;
    private int intitialSize;


    /**
     * This creates an object of GenericStack
     * @param initialSize is the initial size of the GenericStack, it needs to be greater than 0
     */
    public GenericStack(int initialSize) {

        this.intitialSize = initialSize;

        if(initialSize <= 0)
        {
            this.intitialSize = 1;
        }

        this.size = 0;
        this.data = (ELEM[]) new Object[initialSize];
    }

    /**
     * This checks if the data array is empty
     * @return true or false
     */
    public boolean isEmpty()
    {
        if(size == 0)
        {
            return true;
        }

        return false;
    }

    /**
     * This checks if the data array is full and doubles the size of the array and copies over the array if it is.
     * In addition, it will increase the size by one and add the element e to the "top" of the stack.
     * @param e this is the element to be added to the "top" of the stack
     */
    public void push(ELEM e)
    {
        if(data.length <= size)
        {
            ELEM[] tempData = (ELEM[]) new Object[data.length * 2];
            for(int i = 0; i < data.length; i++)
            {
                tempData[i] = data[i];
            }

            data = tempData;
        }



        data[size] = e;
        size = size + 1;
    }

    /**
     * This will allow the user to see what the top element of the stack is if it is not empty
     * @return the top element of the stack
     */
    public ELEM peek()
    {
        if(isEmpty())
        {
            return null;
        }

        return data[size-1];
    }

    /**
     * This will remove the "top" of the stack as long as it is not empty and the size will go down by one.
     * @return the removed element of the stack
     */
    public ELEM pop()
    {
        if(isEmpty())
        {
            return null;
        }
        else
        {
            ELEM tempElem = data[size - 1];
            data[size - 1] = null;
            size = size - 1;
            return tempElem;
        }
    }

    /**
     * This will create an output of the array
     * @return
     */
    public String toString()
    {
        String returnString = "";
        for(int i = 0; i < data.length; i++)
        {
            returnString += data[i];
        }

        return returnString;
    }

    /**
     * Checks if a passed object is equal to the current GenericStack object
     * @param object the passed object
     * @return true or false
     */
    public boolean equals(Object object)
    {
        if(object instanceof GenericStack<?>)
        {
             object = new GenericStack<ELEM>(intitialSize);

            if(((GenericStack<?>) object).intitialSize == intitialSize && ((GenericStack<?>) object).size == size)
            {
                if(((GenericStack<?>) object).data.length == data.length)
                {
                    for(int i = 0; i < data.length; i++)
                    {
                        if(!((GenericStack<ELEM>) object).data[i].equals(data[i]))
                        {
                            return false;
                        }

                        return true;
                    }
                }
            }
        }

        return false;
    }



}