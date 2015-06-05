package android.larrimorea.blogreader;

public class BlogPost {
    public final String title;
    public final String url;
    public final String author;
    public final String id;
    public final String subreddit;

    public BlogPost(String title, String url, String author, String id, String subreddit){
        this.title = title;
        this.url = url;
        this.author = author;
        this.id = id;
        this.subreddit = subreddit;
    }

}
