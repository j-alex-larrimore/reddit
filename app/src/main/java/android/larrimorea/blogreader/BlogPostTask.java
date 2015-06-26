//package android.larrimorea.blogreader;

import android.app.Activity;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.json.JSONObject;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

//

//public class BlogPostTask extends AsyncTask<Activity, Void, JSONObject> {
//    private Activity activity;
//
//    @Override
//    protected JSONObject doInBackground(Activity... activities) {
//        activity = activities[0];
//        JSONObject jsonObject = null;
//
//        try {
//            URL blogFeedURL = new URL("https://www.reddit.com/r/AskReddit/.json");
//
//            HttpURLConnection connection = (HttpURLConnection)blogFeedURL.openConnection();
//            connection.connect();
//            int responseCode = connection.getResponseCode();
//
//            if(responseCode == HttpURLConnection.HTTP_OK){
//
//                jsonObject = BlogPostParser.get().parse(connection.getInputStream());
//            }
//        }
//        catch(MalformedURLException error){
//            Log.e("BlogPostTask", "Malformed URL: " + error);
//        }
//        catch(IOException error){
//            Log.e("BlogPostTask", "IO Exception: " + error);
//        }
//
//        return jsonObject;
//    }
//
//    @Override
//    protected void onPostExecute(JSONObject jsonObject) {
//        BlogPostParser.get().readFeed(jsonObject);
//
//        RedditListFragment.PostAdapter adapter = new RedditListFragment.PostAdapter(BlogPostParser.get().posts);
//        listView.setAdapter(adapter);
//    }
//}
