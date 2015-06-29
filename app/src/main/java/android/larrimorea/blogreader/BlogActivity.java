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

public class BlogActivity extends SingleFragmentActivity implements RedditListFragment.Callbacks{
    @Override
    protected Fragment createFragment() {
        return new RedditListFragment();
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_masterdetail;
    }

    @Override
    public void onPostSelected(Uri postUri) {
        if(findViewById(R.id.detail_fragment_container)==null){
            Intent intent = WebPagerActivity.newIntent(this, postUri);
            intent.setData(postUri);
            startActivity(intent);
        }else{
            Fragment newDetail = BlogWebFragment.newInstance(postUri.toString());
            getSupportFragmentManager().beginTransaction().replace(R.id.detail_fragment_container, newDetail).commit();
        }
    }
}

