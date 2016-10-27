import java.util.AbstractList;
import java.util.ArrayList;

/**
 * Created by User on 27.10.2016.
 */
public class Thema {
    private String Name;
    private User Avtor;
    private ArrayList<Message> messages = new ArrayList<>();

    public Thema() {
    }

    public Thema(String name, User avtor) {
        Name = name;
        Avtor = avtor;
    }

    public void addMessage(Message message)
    {
        messages.add(message);
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public User getAvtor() {
        return Avtor;
    }

    public void setAvtor(User avtor) {
        Avtor = avtor;
    }

    public ArrayList<Message> getMessages() {
        return messages;
    }

    public void setMessages(ArrayList<Message> messages) {
        this.messages = messages;
    }
}
