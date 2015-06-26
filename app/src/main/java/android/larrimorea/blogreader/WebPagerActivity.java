package android.larrimorea.blogreader;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.webkit.WebView;

import java.util.List;
import java.util.UUID;

public class WebPagerActivity extends SingleFragmentActivity {
    private ViewPager mViewPager;
    private List<BlogPost> mPosts;

    @Override
    protected Fragment createFragment() {
        return new BlogWebFragment();
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
