from typing import Any, Dict, Tuple


class MessageSender:

    _instance = None

    @classmethod
    def send_message(cls, receiver: str, message: Tuple[str, str]) -> None:
        MessageSender().accept_message(receiver, message)

    def __new__(cls) -> Any:
        if not cls._instance:
            cls._instance = object.__new__(cls)
        return cls._instance

    def accept_message(self, receiver: str, message: Tuple[str, str]) -> None:
        """Sends message off to another system ...
        """
        print('sending message: "%s" to %s...' % (message, receiver))
