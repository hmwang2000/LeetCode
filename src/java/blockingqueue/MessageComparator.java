package java.blockingqueue;

import java.util.Comparator;

public class MessageComparator implements Comparator<Message> {
    @Override
    public int compare(Message msg1, Message msg2) {
        return msg2.getMsg().length() - msg1.getMsg().length();
    }
}
