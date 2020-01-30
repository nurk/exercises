package be.cegeka.inbox;

public class MessageSender {
    private static MessageSender instance = new MessageSender();

    static void setInstance(MessageSender instance) {
        MessageSender.instance = instance;
    }

    public static void sendMessage(String to, String message) {
        instance.acceptMessage(to, message);
    }

    void acceptMessage(String to, String message) {
        //ignore this, it's another system
    }

}
