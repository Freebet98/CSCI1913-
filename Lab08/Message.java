public class Message
{
    private String nameSent;
    private String nameReceived;
    private String message;

    /**
     * This constructs a Message object
     * @param nameSent is a string of the name of the sender
     * @param nameReceived is a string of the name of the receiver
     * @param message is a string of the message that was sent
     */
    public Message(String nameSent, String nameReceived, String message)
    {
        this.nameSent = nameSent;
        this.nameReceived = nameReceived;
        this.message = message;
    }

    /**
     * This gets who the message is from
     * @return the name of the person the message was sent by
     */
    public String getFrom()
    {
        return nameSent;
    }

    /**
     * This gets who the message was received by
     * @return the name of the person who received the message
     */
    public String getTo()
    {
        return nameReceived;
    }

    /**
     * This returns the message that was sent
     * @return the message
     */
    public String getMessage()
    {
        return message;
    }

    /**
     * This sets who the message was sent to
     * @param nameReceived is the name of the receiver
     */
    public void setTo(String nameReceived)
    {
        this.nameReceived = nameReceived;
    }

    /**
     * This changes what message was sent
     * @param message is the text that was sent
     */
    public void setMessage(String message)
    {
        this.message = message;
    }

    /**
     * This creates a formatted printout for the object
     * @return a String message
     */
    public String toString()
    {
        return "Message from: " + nameSent + " to: " + nameReceived + " Message: \"" + message + "\"";
    }
}