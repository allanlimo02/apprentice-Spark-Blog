package AccessObjects;

//import ;

import AccessInterface.ConnectionUserInterface;
import Models.Users;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

public class UsersDao implements ConnectionUserInterface {

    Sql2o sql2o;
    @Override
    public List<Users> getAll() {
        return null;
    }

    @Override
    public void add(Users users) {
        String sql="INSERT INTO user (description) VALUES (:descriptiom";
        try (Connection conn= sql2o.open()){
            conn.createQuery(sql)
                    .executeUpdate();

        }catch (Sql2oException ex){
            ex.printStackTrace();
        }

    }

    @Override
    public Users findById(String username) {
        String sql="SELECT * FROM news WHERE username = :serialNo";
        try (Connection conn= sql2o.open()){
            conn.createQuery(sql)
                    .executeUpdate();
        }catch (Sql2oException ex){
            ex.printStackTrace();
        }
        return null;
    }
}
