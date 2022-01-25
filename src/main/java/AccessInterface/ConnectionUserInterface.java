package AccessInterface;

import Models.Users;

import java.util.List;

public interface ConnectionUserInterface {
    // LISTING
    List<Users> getAll();

    // CREATING
    void add(Users users);

    // READING
    Users findById(String username);

}
