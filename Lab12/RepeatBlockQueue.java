//CSCI1913 FALL2022 KLUVER
//Author: Bethany Freeman
public class RepeatBlockQueue<T>
{
    RepeatBlockQueueNode<T> front;
    RepeatBlockQueueNode<T> end;
    int size;

    /**
     * This constructs an object of RepeatBlockQueue meant to represent an empty linked-chain
     */
    public RepeatBlockQueue()
    {
        this.front = null;
        this.end = null;
        this.size = 0;
    }

    /**
     * This attempts to add an element to the queue and increases the size of the queue.
     * @param data This is a passed generic T
     */
    public void enqueue(T data)
    {
        RepeatBlockQueueNode<T> node = new RepeatBlockQueueNode<T>(data, null);

        if(isEmpty()) //since the linked chain is empty both the front and end will be the same data point
        {
            front = node;
            end = node;
            size = size + 1;
        }
        else if(front.equals(end) && node.getData().equals(end.getData()))
            //This checks if front and end are the same and also if data is the same as the end node
        {
            front.setCount(front.getCount() + 1);
            end = front;
            size = size + 1;
        }
        else if(front.equals(end) && !node.getData().equals(end.getData()))
        //This checks if front and end are the same and if data does not equal the end
        {
            end = node;
            front.setNext(end);
            size = size + 1;

        }
        else if(!front.equals(end) && node.getData().equals(end.getData()))
        //This checks if the front and end are different and if date and the end are the same
        {
            end.setCount(end.getCount() + 1);
            size = size + 1;
        }
        else //This is all other cases
        {
            end.setNext(node);
            end = node;
            size = size + 1;
        }
    }

    /**
     * @return This returns the front node of the queue
     */
    public T front()
    {
        if(isEmpty())
        {
            return null;
        }

        return front.getData();
    }

    /**
     * This will remove the front of the queue and decrease the size
     * @return the front of the queue that is being removed
     */
    public T dequeue()
    {
        if(isEmpty()) //This will return nothing and not decrease the size or modify the linked chain
        {
            return null;
        }
        else if(front == (end) && front.getCount() == 1 && size == 1)
        {
            T tempData = front.getData();
            front = null;
            end = null;
            size = size - 1;
            return tempData;
        }
        else if(front != (end) && front.getCount() == 1)
        {
            T tempData = front.getData();
            front = front.getNext();
            size = size - 1;
            return tempData;
        }
        else if(front != (end) && front.getCount() > 1)
        {
            T tempData = front.getData();
            front.setCount(front.getCount() - 1);
            size = size - 1;
            return tempData;
        }
        else
        {
            T tempData = front.getData();
            front.setCount(front.getCount() - 1);
            end.setCount(end.getCount() - 1);
            size = size - 1;
            return tempData;
        }
    }

    /**
     * @return the size of the repeat block at the front of the queue
     */
    public int frontOfLineRepeatCount()
    {
        if(isEmpty())
        {
            return 0;
        }
        else
        {
            return front.getCount();
        }
    }

    /**
     * @return the size of the queue
     */
    public int getSize()
    {
        return size;
    }

    /**
     * This checks if the linked-chain is empty
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
     * This is the formatting for the output of the RepeatBlockQueue Class
     * @return a string
     */
    @Override
    public String toString()
    {
        String returnString = "";
        if(isEmpty())
        {
            returnString = "";
        }
        else if(size > 0)
        {
            RepeatBlockQueueNode<T> temp = front;

            int i = 0;
            while (temp!= null)
            {
                if (i > 0)
                {
                    returnString += ", ";
                }
                returnString += temp.getData();
                returnString += ":";
                returnString += temp.getCount();
                temp = temp.getNext();
                i++;
            }
        }
        return returnString;
    }
}
