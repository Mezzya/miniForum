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
    private User Avtor;
    @XmlElement
    private String Text;

    public Message() {
    }

    public Message(User avtor, String text) {
        Avtor = avtor;
        Text = text;
    }

    public User getAvtor() {
        return Avtor;
    }

    public void setAvtor(User avtor) {
        Avtor = avtor;
    }

    public String getText() {
        return Text;
    }

    public void setText(String text) {
        Text = text;
    }
}
