package AccessObjects;

import AccessInterface.ConnnectionNewsInterface;
import Models.News;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

public class NewsDaoTest {
    private static NewsDao newsDao;
    private static Connection connection;
    @BeforeClass
    public static void beforeClass() throws Exception {
        String connectionString = "jdbc:h2:mem:testing;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
        Sql2o sql2o = new Sql2o(connectionString, "", "");
        newsDao = new NewsDao(sql2o); //ignore me for now
        connection = sql2o.open(); //keep connection open through entire test so it does not get erased
    }

    @AfterClass
    public static void afterClass() throws Exception {
        connection.close();
    }

    @Test
    public void add() {
        News news=new News(22,"Raila gets Angry","Politics","22/01/2022","Raila gets angry at Mudavadi and Wetangula","Janet Kirui");
        ConnnectionNewsInterface.add(news);
    }

    @Test
    public void getAll() {
    }

    @Test
    public void findById() {
    }
}