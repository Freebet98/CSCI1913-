import java.util.Arrays;

public class Gibberisher
{
   private Trie<CharBag> model;
   private int segmentLength;
   private int sampleCount;

    /**
     * This constructs an object of the Gibberisher class
     * @param segmentLength this is the length of the segment
     */
   public Gibberisher(int segmentLength)
   {
       this.segmentLength = segmentLength;
       sampleCount = 0;
       model = new Trie<>();
   }

    /**
     * This will train the model using an array of LatterSample objects for every string in the input array
     * @param input this is an array of Strings to train the Gibberisher model
     */
   public void train(String[] input)
   {
       for(int i = 0; i < input.length; i++)
       {
           LetterSample[] train = LetterSample.toSamples(input[i], segmentLength);
           int x = 0;
           while(x < train.length)
           {
               if(train[x].getSegment().equals(""))
               {
                   CharBag temp;
                   if(model.get(train[x].getSegment()) == null)
                   {
                       temp = new CharBag();
                   }
                   else
                   {
                       temp = model.get(train[x].getSegment());
                   }
                   temp.add(train[x].getNextLetter());
                   model.put(train[x].getSegment(), temp);
                   sampleCount++;
               }
               else if(train[x].getSegment().length() > 0)
               {
                   CharBag temp;
                   if(model.get(train[x].getSegment()) == null)
                   {
                       temp = new CharBag();
                   }
                   else
                   {
                       temp = model.get(train[x].getSegment());
                   }
                   temp.add(train[x].getNextLetter());
                   model.put(train[x].getSegment(), temp);
                   sampleCount++;
               }
               x++;
           }
       }
   }

    /**
     * @return the amount of samples counted so far
     */
   public int getSampleCount()
   {
       return sampleCount;
   }

    /**
     * Generate a new gibberish word based on the current model
     * @return a string of the word generated
     */
   public String generate()
   {
       int segmentSize = segmentLength;
       String word = "";
       String finalSegment = "";
       int i = 0;
       CharBag temp;
       char letter;
       int r = 1;

        //This checks if the word is empty
       if(word.equals(""))
       {
           temp = model.get(word);
           letter = temp.getRandomChar();
           word += letter;
       }

       //This will go through the word and its various segments of segment lengths
       while(word.charAt(word.length()-1) != LetterSample.STOP)
       {
           if(i < segmentSize)
           {
               finalSegment = word;
           }
           else if(i >= segmentSize)
           {
               finalSegment = word.substring(r ,segmentSize + r);
               r = r + 1;
           }

           temp = model.get(finalSegment);
           if(temp != null)
           {
               letter = temp.getRandomChar();
               word += letter;
           }
           else
           {
               word += LetterSample.STOP;
           }

           i++;
       }

       word = word.substring(0, word.length() - 1);
       return word;
   }
}
