package temp;

import temp.User;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by temp.User on 27.10.2016.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class Thema {
    @XmlElement
    private String title;
    @XmlElement
    private User avtor;
    @XmlElement
    private List<Message> messages = Collections.synchronizedList(new ArrayList<Message>());

    public Thema() {
    }

    public Thema(String title, User avtor) {
        this.title = title;
        this.avtor = avtor;
    }

    public synchronized void addMessage(Message message)

    {
        messages.add(message);
    }

    public synchronized String getTitle()
    {
        return title;
    }

    public synchronized void setTitle(String title)
    {
        this.title = title;
    }

    public synchronized User getAvtor()
    {
        return avtor;
    }

    public synchronized void setAvtor(User avtor)
    {
        this.avtor = avtor;
    }

    public List<Message> getMessages()
    {
        return messages;
    }

}
