//CSCI1913 FALL2022 KLUVER
//Author: Bethany Freeman
public class RepeatBlockQueueNode <T>
{
    T data;
    int count;
    RepeatBlockQueueNode<T> next;

    /**
     * This constructs an object of RepeatBlockQueueNode
     * @param data this is the passed data of the type ELEM
     * @param next this is the next variable in the linked chain that is passed
     */
    public RepeatBlockQueueNode(T data, RepeatBlockQueueNode<T> next)
    {
        this.data = data;
        this.next = next;
        this.count = 1;
    }

    /**
     * @return the current value of data
     */
    public T getData()
    {
        return data;
    }

    /**
     * This sets the data to the passed data type
     * @param data this is a passed ELEM type of data
     */
    public void setData(T data)
    {
        this.data = data;
    }

    /**
     * @return the next node
     */
    public RepeatBlockQueueNode<T> getNext()
    {
        return next;
    }

    /**
     * This will set the next node with the passed param next
     * @param next is of type RepeatBlockQueueNode<ElEM>
     */
    public void setNext(RepeatBlockQueueNode<T> next)
    {
        this.next = next;
    }

    /**
     * @return the count
     */
    public int getCount()
    {
        return count;
    }

    /**
     * This will set the count with the passed param count
     * @param count an int variable
     */
    public void setCount(int count)
    {
        this.count = count;
    }

    /**
     * This compares an object that passed to an object of the RepeatBlockQueueNode class
     * and says if they are equal
     * @param object a passed object of a class
     * @return true or false
     */
    public boolean equals(Object object)
    {
        if(object != null)
        {
            if(object instanceof RepeatBlockQueueNode<?>)
            {
                if(((RepeatBlockQueueNode<?>) object).getData().equals(data) && ((RepeatBlockQueueNode<?>) object).getCount() == count)
                {
                    return true;
                }

                return false;
            }
        }

        return false;
    }

    public String toString()
    {
        return data.toString();
    }
}
