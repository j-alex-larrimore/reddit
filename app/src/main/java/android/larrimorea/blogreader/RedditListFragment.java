package android.larrimorea.blogreader;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.json.JSONObject;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alex on 6/25/2015.
 */
public class RedditListFragment extends Fragment {

    private RecyclerView mPostRecyclerView;
    private PostAdapter mAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_reddit_list, container, false);

        mPostRecyclerView = (RecyclerView) v.findViewById(R.id.post_recycler_view);
        mPostRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

//        Intent intent = getIntent();
//        Uri blogUri = intent.getData();
//
//        WebView webView = (WebView)findViewById(R.id.webView);
//        webView.loadUrl(blogUri.toString());

        //updateUI();

        new BlogPostTask().execute(getActivity());

        return v;
    }

    private void updateUI(JSONObject jsonObject){
        BlogPostParser parser = BlogPostParser.get();
        parser.get().readFeed(jsonObject);
        ArrayList<BlogPost> posts = parser.getPosts();

        mAdapter = new PostAdapter(posts);
        mPostRecyclerView.setAdapter(mAdapter);
    }

    public class PostHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public TextView mTitleTextView;

        public PostHolder(View itemView){
            super(itemView);
            itemView.setOnClickListener(this);
            mTitleTextView = (TextView)itemView;
        }

        @Override
        public void onClick(View v) {
                //Intent intent = new Intent(getActivity(), WebPagerActivity.class);

                //getAdapterPosition can be called in a viewHolder object to return that ViewHolder's position in the List.
                int position = getAdapterPosition();


                Uri blogUri = Uri.parse(BlogPostParser.get().posts.get(position).url);
                Intent intent = WebPagerActivity.newIntent(getActivity(), blogUri);

                //intent.setData(blogUri);

                startActivity(intent);

        }
    }

    public class PostAdapter extends RecyclerView.Adapter<PostHolder>{
        private List<BlogPost> mPosts;

        public PostAdapter(List<BlogPost> posts){
            mPosts = posts;
        }

        @Override
        public PostHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            View view = layoutInflater.inflate(android.R.layout.simple_list_item_1, parent, false);
            return new PostHolder(view);
        }

        @Override
        public void onBindViewHolder(PostHolder holder, int position) {
            BlogPost post = mPosts.get(position);
            holder.mTitleTextView.setText(post.getTitle());
        }

        @Override
        public int getItemCount() {
            return mPosts.size();
        }


    }

//    @Nullable
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//        View v = inflater.inflate(R.layout.fragment_reddit_list, container, false);
//
////        Intent intent = getIntent();
////        Uri blogUri = intent.getData();
////
////        WebView webView = (WebView)findViewById(R.id.webView);
////        webView.loadUrl(blogUri.toString());
//
//        return v;
//    }

    public class BlogPostTask extends AsyncTask<Activity, Void, JSONObject> {
        private Activity activity;

        @Override
        protected JSONObject doInBackground(Activity... activities) {
            activity = activities[0];
            JSONObject jsonObject = null;

            try {
                URL blogFeedURL = new URL("https://www.reddit.com/r/AskReddit/.json");

                HttpURLConnection connection = (HttpURLConnection)blogFeedURL.openConnection();
                connection.connect();
                int responseCode = connection.getResponseCode();

                if(responseCode == HttpURLConnection.HTTP_OK){

                    jsonObject = BlogPostParser.get().parse(connection.getInputStream());
                }
            }
            catch(MalformedURLException error){
                Log.e("BlogPostTask", "Malformed URL: " + error);
            }
            catch(IOException error){
                Log.e("BlogPostTask", "IO Exception: " + error);
            }

            return jsonObject;
        }

        @Override
        protected void onPostExecute(JSONObject jsonObject) {
            //BlogPostParser.get().readFeed(jsonObject);
            updateUI(jsonObject);

            //RedditListFragment.PostAdapter adapter = new RedditListFragment.PostAdapter(BlogPostParser.get().posts);
            //listView.setAdapter(adapter);
        }
    }
}
