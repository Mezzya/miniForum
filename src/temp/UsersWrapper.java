package temp;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.File;
import java.util.ArrayList;

/**
 * Created by andre on 10/28/2016.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "users")
public class UsersWrapper {
    @XmlElement(name = "user")
    private ArrayList<User> users = new ArrayList<>();

    public UsersWrapper() {
    }


    public boolean regNewUser(User newUser)
    {
        for (User user: users) {

            if (user.getLogin().equals(newUser.getLogin()))
            {
//                Такой пользователь уще есть
                return false;
            }

        }
        users.add(newUser);

        return true;
    }

    public boolean chekUserPwd(String login, String pwd)
    {
        for (User user: users) {

            if ((user.getLogin().equals(login))&&(user.getPassword().equals(pwd)))
            {
//                Правильная комбинация
                return true;
            }

        }

        return false;

    }

    public boolean userLoginexist(String login)
    {
        for (User user: users) {

            if ((user.getLogin().equals(login)))
            {
//                Пользователь с таким логином существует
                return true;
            }

        }

        return false;

    }

    public User getUser(String login)
    {
        for (User user: users) {

            if (user.getLogin().equals(login))
                return user;

        }
        return null;
    }
    public ArrayList<User> getUsers() {
        return users;
    }


    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }

    public void saveXML( String source) {
        try {
            JAXBContext context = JAXBContext.newInstance(this.getClass());
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);
            marshaller.marshal(this,new File(source));
            System.out.println(">> Save to XML OK!");
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    public void loadXML(String source)
    {
        try {
            JAXBContext context = JAXBContext.newInstance(this.getClass());
            Unmarshaller unmarshaller = context.createUnmarshaller();
            this.users = ((UsersWrapper) unmarshaller.unmarshal(new File(source))).getUsers();
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
