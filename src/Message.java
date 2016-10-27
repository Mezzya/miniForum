/**
 * Created by User on 27.10.2016.
 */
public class Message {
    private User Avtor;
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
