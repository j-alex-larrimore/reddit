package android.larrimorea.blogreader;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;

public class BlogActivity extends SingleFragmentActivity {
    @Override
    protected Fragment createFragment() {
        return new RedditListFragment();
    }

    //    protected ProgressBar progressBar;
//    protected ListView listView;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_blog);
//
//        String[] arrayStrings = new String[]{
//                "Blog Post 1",
//                "Blog Post 2",
//                "Blog Post 3",
//                "Blog Post 4"
//        };
//
//        progressBar = (ProgressBar)findViewById(R.id.progressBar);
//        listView = (ListView)findViewById(R.id.listView);
//
//        listView.setEmptyView(progressBar);
//
//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Intent intent = new Intent(getApplicationContext(), BlogWebActivity.class);
//                Uri blogUri = Uri.parse(BlogPostParser.get().posts.get(position).url);
//                intent.setData(blogUri);
//
//                startActivity(intent);
//            }
//        });
//
//        new BlogPostTask().execute(this);
//    }




}


//package android.larrimorea.blogreader;
//
//import android.app.Activity;
//import android.app.FragmentManager;
//import android.content.Intent;
//import android.net.Uri;
//import android.os.Bundle;
//import android.support.v4.app.Fragment;
//import android.support.v4.app.FragmentActivity;
//import android.view.View;
//import android.widget.AdapterView;
//import android.widget.ArrayAdapter;
//import android.widget.ListView;
//import android.widget.ProgressBar;
//
//
//public class BlogActivity extends SingleFragmentActivity {
//
//    protected ProgressBar progressBar;
//    protected ListView listView;
//
//    @Override
//    protected Fragment createFragment() {
//        return new RedditListFragment();
//    }
//
//    @Override
//    public void onPostSelected(BlogPost post) {
//        if(findViewById(R.id.detail_fragment_container)==null){
//            Intent intent = CrimePagerActivity.newIntent(this, crime.getId());
//            startActivity(intent);
//        }else{
//            Fragment newDetail = CrimeFragment.newInstance(crime.getId());
//            getSupportFragmentManager().beginTransaction().replace(R.id.detail_fragment_container, newDetail).commit();
//        }
//    }
//
////    @Override
////    protected void onCreate(Bundle savedInstanceState) {
////
////
////
////        String[] arrayStrings = new String[]{
////                "Blog Post 1",
////                "Blog Post 2",
////                "Blog Post 3",
////                "Blog Post 4"
////        };
////
////        progressBar = (ProgressBar)findViewById(R.id.progressBar);
////        listView = (ListView)findViewById(R.id.listView);
////
////        listView.setEmptyView(progressBar);
////
////        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
////            @Override
////            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
////                Intent intent = new Intent(getApplicationContext(), BlogWebFragment.class);
////                Uri blogUri = Uri.parse(BlogPostParser.get().posts.get(position).url);
////                intent.setData(blogUri);
////
////                startActivity(intent);
////            }
////        });
////
////        new BlogPostTask().execute(this);
////    }
//
//
//}
