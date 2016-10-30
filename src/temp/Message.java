package temp;

import temp.User;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by temp.User on 27.10.2016.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class Message {
    @XmlElement
    private User avtor;
    @XmlElement
    private String text;
    @XmlElement
    private String date;

    public Message() {
    }

    public Message(User avtor, String text, String date) {
        this.avtor = avtor;
        this.text = text;
        this.date = date;

    }

    public synchronized User getAvtor()
    {
        return avtor;
    }

    public synchronized void setAvtor(User avtor)
    {
        this.avtor = avtor;
    }

    public synchronized String getText()
    {
        return text;
    }

    public synchronized void setText(String text)
    {
        this.text = text;
    }

    public synchronized String getDate()
    {
        return date;
    }
}
