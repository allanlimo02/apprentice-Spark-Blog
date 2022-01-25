package AccessObjects;

import AccessInterface.ConnnectionNewsInterface;
import Models.News;
import Models.Users;
import org.h2.util.New;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

public class NewsDao implements ConnnectionNewsInterface {


    static Sql2o sql2o;
    Connection conn;

    public NewsDao(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

//    @Override
    public static void add(News news) {
        String sql ="INSERT INTO news (description) VALUES (:descriptiom)";
        try (Connection conn= sql2o.open()){
                int id=(int) conn.createQuery(sql,true)
                        .bind(news)
                        .executeUpdate()
                        .getKey();
                news.setSerialNo(id);
        }catch (Sql2oException sql2oException){
            sql2oException.printStackTrace();
        }
    }

    @Override
    public List<News> getAll() {
        String sql="SELECT * FROM news";
        try (Connection connection=sql2o.open()){
            return connection.createQuery(sql)
                    .executeAndFetch(News.class);
        }
    }

    @Override
    public News findById(int serialNo) {
        String sql="SELECT * FROM news WHERE serialNo = :serialNo";
        try (Connection conn= sql2o.open()){
            return conn.createQuery(sql)
                    .addParameter("serialNo",serialNo)
                    .executeAndFetchFirst(News.class);
        }
    }

    @Override
    public void findByCategory(String category) {
        String sql="SELECT * FROM news WHERE category=(:category)";
        try (Connection conn=sql2o.open()){
            conn.createQuery(sql)
                    .executeAndFetchFirst(New.class);

        }

    }

}
