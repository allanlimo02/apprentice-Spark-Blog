package Models;

import java.util.Objects;

public class News {
    private int serialNo;
    private String title;
    private String category;
    private String date;
    private String body;
    private String reporter;

    public String getReporter() {
        return reporter;
    }

    public void setReporter(String reporter) {
        this.reporter = reporter;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public int getSerialNo() {return serialNo;}

    public void setSerialNo(int serialNo) {this.serialNo = serialNo;}

    public News(int serialNo, String title, String category, String date, String body, String reporter) {
        this.serialNo = serialNo;
        this.title = title;
        this.category = category;
        this.date = date;
        this.body = body;
        this.reporter = reporter;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof News)) return false;
        News news = (News) o;
        return getSerialNo() == news.getSerialNo() && Objects.equals(getTitle(), news.getTitle()) && Objects.equals(getCategory(), news.getCategory()) && Objects.equals(getDate(), news.getDate()) && Objects.equals(getBody(), news.getBody()) && Objects.equals(getReporter(), news.getReporter());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSerialNo(), getTitle(), getCategory(), getDate(), getBody(), getReporter());
    }
}
