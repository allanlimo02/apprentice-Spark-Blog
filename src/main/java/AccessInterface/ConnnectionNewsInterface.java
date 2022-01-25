package AccessInterface;

import Models.News;

import java.util.List;

public interface ConnnectionNewsInterface {
    // LIST
    List<News> getAll();

    static void add(News news) {
    }

    // READ
    News findById(int id);

    //Find by category
    void findByCategory(String category);

}
