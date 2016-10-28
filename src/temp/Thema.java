package temp;

import temp.User;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;

/**
 * Created by temp.User on 27.10.2016.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class Thema {
    @XmlElement
    private String title;
    @XmlElement
    private User Avtor;
    @XmlElement
    private ArrayList<Message> messages = new ArrayList<>();

    public Thema() {
    }

    public Thema(String title, User avtor) {
        this.title = title;
        Avtor = avtor;
    }

    public void addMessage(Message message)
    {
        messages.add(message);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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
