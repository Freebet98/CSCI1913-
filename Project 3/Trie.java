//CSCI1913 FALL2022 KLUVER
//Author: Bethany Freeman
public class Trie <TYPE>
{
    private TrieNode<TYPE> root;

    /**
     * This constructs an object of the Trie class and sets the root to a new node
     */
    public Trie()
    {
        root = new TrieNode<>();
    }

    /**
     * This will find the TrieNode that input is on
     * @param input a string input
     * @return the TrieNode
     */
    private TrieNode<TYPE> getNode(String input)
    {
        TrieNode<TYPE> letter;

        if(input.equals(""))
        {
            letter = root;
        }
        else
        {
            letter = root.getChild(input.charAt(0));
        }

        for(int i = 1; i < input.length(); i++)
        {
            if(letter != null)
            {
                letter = letter.getChild(input.charAt(i));
            }
        }

        return letter;
    }

    /**
     * This will get the data currently on the node of the input string
     * @param input a string
     * @return the data from the node
     */
    public TYPE get(String input)
    {
        TrieNode<TYPE> inputNode = getNode(input);

        if(inputNode == null)
        {
            return null;
        }

        return inputNode.getData();
    }

    /**
     * This sets the node with new data
     * @param input a string
     * @param data data of the type of Trie
     * @return the original data from the input node
     */
    public TYPE put(String input, TYPE data)
    {
        TrieNode<TYPE> inputNode = getNode(input);
        TYPE originalData = get(input);
        if(inputNode != null)
        {
            inputNode.setData(data);
        }

        return originalData;
    }
}
