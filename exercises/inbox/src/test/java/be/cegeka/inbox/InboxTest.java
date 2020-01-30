package be.cegeka.inbox;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.data.MapEntry.entry;

public class InboxTest {

    private MessageSenderForTest messageSender = new MessageSenderForTest();

    @Before
    public void setUp() throws Exception {
        MessageSender.setInstance(messageSender);
    }

    @Test
    public void whenMessageArrivesThenSendMessageToReception() throws Exception {
        Inbox inbox = new Inbox();

        inbox.receiveMessage("Ser Pounce", "Hello Cegeka!");

        assertThat(messageSender.messages).containsExactly(entry("reception", "Hello Cegeka!"));
    }

    private static class MessageSenderForTest extends MessageSender {
        Map<String, String> messages = new HashMap<>();

        void acceptMessage(String to, String message) {
            messages.put(to, message);
        }
    }
}