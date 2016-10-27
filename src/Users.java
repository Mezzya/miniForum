import java.util.ArrayList;

/**
 * Created by User on 27.10.2016.
 */
public class Users {
    private ArrayList<User> users = new ArrayList<>();

    public Users() {
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }

    public Boolean checkPassword(String name, String password)
    {
        for (User user: users) {

            if ((user.getName().equals(name))&&user.getPassword().equals(password))
            {
                return true;
            }

        }

        return false;
    }
}
