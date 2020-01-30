from inbox.message_sender import MessageSender


class Inbox:

    def receive_message(self, sender: str, text: str) -> None:
        MessageSender.send_message('', ('', ''))
