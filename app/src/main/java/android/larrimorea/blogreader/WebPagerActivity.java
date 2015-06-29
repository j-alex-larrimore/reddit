package android.larrimorea.blogreader;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;

import java.net.URL;
import java.util.List;
import java.util.UUID;

public class WebPagerActivity extends AppCompatActivity {
    private ViewPager mViewPager;
    private List<BlogPost> mPosts;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blog_web);

        Intent intent = this.getIntent();
        Uri blogUri = intent.getData();

        mViewPager = (ViewPager)findViewById(R.id.web_pager);

        mPosts = BlogPostParser.get().getPosts();

        FragmentManager fragmentManager = getSupportFragmentManager();
        mViewPager.setAdapter(new FragmentStatePagerAdapter(fragmentManager) {
            @Override
            public Fragment getItem(int position) {
                BlogPost post = mPosts.get(position);
                return BlogWebFragment.newInstance(post.getUrl());
            }

            @Override
            public int getCount() {
                return mPosts.size();
            }
        });

        for(int i = 0; i< mPosts.size(); i++){
            if(mPosts.get(i).getUrl().equals(blogUri)){
                mViewPager.setCurrentItem(i);
                break;
            }
        }
    }

    public static Intent newIntent(Context packageContext, Uri blogUri){
        Intent intent = new Intent(packageContext, WebPagerActivity.class);
        intent.setData(blogUri);
        //intent.putExtra(EXTRA_CRIME_ID, blogUri);
        return intent;
    }



//    public static Intent newIntent(Context packageContext, UUID crimeID){
//        Intent intent = new Intent(packageContext, CrimePagerActivity.class);
//        intent.putExtra(EXTRA_CRIME_ID, crimeID);
//        return intent;
//    }
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_crime_pager);
//
//        UUID crimeId = (UUID) getIntent().getSerializableExtra(EXTRA_CRIME_ID);
//
//        mViewPager = (ViewPager)findViewById(R.id.activity_crime_pager_view_pager);
//
//        mCrimes = CrimeLab.get(this).getCrimes();
//        FragmentManager fragmentManager = getSupportFragmentManager();
//        mViewPager.setAdapter(new FragmentStatePagerAdapter(fragmentManager) {
//            @Override
//            public Fragment getItem(int position) {
//                Crime crime = mCrimes.get(position);
//                return CrimeFragment.newInstance(crime.getId());
//            }
//
//            @Override
//            public int getCount() {
//                return mCrimes.size();
//            }
//        });
//
//        for(int i = 0; i< mCrimes.size(); i++){
//            if(mCrimes.get(i).getId().equals(crimeId)){
//                mViewPager.setCurrentItem(i);
//                break;
//            }
//        }
//    }
}
