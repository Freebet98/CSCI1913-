//CSCI1913 FALL2022 KLUVER
//Author: Bethany Freeman
public class BraceChecker
{
    /**
     * this will return true only if the stringParameter contains correctly nested parentheses
     * @param stringParameter this is a parameter that is a String
     * @return true or false
     */
    public static boolean checkBraces(String stringParameter)
    {
        //Variables
        char parenthesisL = '(';
        char parenthesisR = ')';
        char bracketL = '[';
        char bracketR = ']';
        char squiggleL = '{';
        char squiggleR = '}';

        //Stack creation
        GenericStack stack = new GenericStack<>(10);

        //checking through the string for the L and R pairs
        for(int i = 0; i < stringParameter.length(); i++)
        {
            char stringPara = stringParameter.charAt(i);

            if(parenthesisL == stringPara)
            {
                stack.push(stringPara);
            }
            else if (bracketL == stringPara)
            {
                stack.push(stringPara);
            }
            else if (squiggleL == stringPara)
            {
                stack.push(stringPara);
            }
            else if((stack.isEmpty() && stringPara == squiggleR) || (stack.isEmpty() && stringPara == parenthesisR) ||
                    stack.isEmpty() && stringPara == bracketR)
            {
                return false;
            }
            else if(stringPara == parenthesisR)
            {
                if(stack.peek().equals(parenthesisL))
                {
                    stack.pop();
                }
            }
            else if(stringPara == bracketR)
            {
                if(stack.peek().equals(bracketL))
                {
                    stack.pop();
                }
            }
            else if(stringPara == squiggleR)
            {
                if(stack.peek().equals(squiggleL))
                {
                    stack.pop();
                }
            }
        }

        if(stack.isEmpty())
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
