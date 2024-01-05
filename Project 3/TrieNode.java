import static java.lang.Character.getNumericValue;
//CSCI1913 FALL2022 KLUVER
//Author: Bethany Freeman
public class TrieNode <TYPE>
{
    private TYPE data;
    private TrieNode<TYPE>[] children;

    /**
     * This constructs an object of the TrieNode class. It initilizes the array children to the size 26 and all null
     */
    public TrieNode()
    {
        this.data = null;

        //initilize array
        children = new TrieNode[26];
        for(int i = 0; i < children.length; i++)
        {
            children[i] = null;
        }
    }

    /**
     * @return the data from the node
     */
    public TYPE getData()
    {
        return data;
    }

    /**
     * This will set the data on the node to what has been passed
     * @param data is a passed piece of data of the Type defied on the node
     */
    public void setData(TYPE data)
    {
        this.data = data;
    }

    /**
     * This will return the child at the current index
     * @param letter this is the letter you are trying to access
     * @return a TrieNode
     */
    public TrieNode<TYPE> getChild(char letter)
    {
        if((int) letter < 97 || (int) letter > 122)
        {
           letter = LetterSample.STOP;
        }

        int index = (int)letter - 97;

        if(children[index] == null)
        {
            TrieNode temp = new TrieNode();
            children[index] = temp;
            return children[index];
        }
        else
        {
            return children[index];
        }
    }
}
