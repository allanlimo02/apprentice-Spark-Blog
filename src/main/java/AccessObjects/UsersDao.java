package AccessObjects;

//import ;

import AccessInterface.ConnectionUserInterface;
import Models.Users;

import java.util.List;

public class UsersDao implements ConnectionUserInterface {

    @Override
    public List<Users> getAll() {
        return null;
    }

    @Override
    public void add(Users users) {

    }

    @Override
    public Users findById(String username) {
        return null;
    }
}
