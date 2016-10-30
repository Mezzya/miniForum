package temp;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by temp.User on 27.10.2016.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class User {

    @XmlElement
    private String firstName;
    @XmlElement
    private String lastName;
    @XmlElement
    private int colMsg;
    @XmlElement
    private String login;
    @XmlElement
    private String password;

    public User() {
    }

    public User(String firstName, String lastName, String login, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.login = login;
        this.password = password;
        this.colMsg=0;
    }

    public synchronized String getFirstName() {
        return firstName;
    }

    public synchronized void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public synchronized String getLastName() {
        return lastName;
    }

    public synchronized void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public synchronized String getLogin() {
        return login;
    }

    public synchronized void setLogin(String login) {
        this.login = login;
    }

    public synchronized String getPassword() {
        return password;
    }

    public synchronized void setPassword(String password) {
        this.password = password;
    }
    public synchronized void colMsgplus()
    {
        colMsg++;
    }
}
