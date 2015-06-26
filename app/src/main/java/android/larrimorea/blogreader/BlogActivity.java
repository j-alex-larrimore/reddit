package android.larrimorea.blogreader;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;

import java.util.UUID;

public class BlogActivity extends SingleFragmentActivity {
    @Override
    protected Fragment createFragment() {
        return new RedditListFragment();
    }

    public static Intent newIntent(Context packageContext, Uri blogUri){
        Intent intent = new Intent(packageContext, WebPagerActivity.class);
        intent.setData(blogUri);
        //intent.putExtra(EXTRA_CRIME_ID, blogUri);
        return intent;
    }



}

