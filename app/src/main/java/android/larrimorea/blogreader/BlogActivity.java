package android.larrimorea.blogreader;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;


public class BlogActivity extends Activity {

    protected ProgressBar progressBar;
    protected ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blog);

        String[] arrayStrings = new String[]{
                "Blog Post 1",
                "Blog Post 2",
                "Blog Post 3",
                "Blog Post 4"
        };

        progressBar = (ProgressBar)findViewById(R.id.progressBar);
        listView = (ListView)findViewById(R.id.listView);

        listView.setEmptyView(progressBar);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(), BlogWebActivity.class);
                Uri blogUri = Uri.parse(BlogPostParser.get().posts.get(position).url);
                intent.setData(blogUri);

                startActivity(intent);
            }
        });

        new BlogPostTask().execute(this);
    }


}
