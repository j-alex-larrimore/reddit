package android.larrimorea.blogreader;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import java.net.URL;

public class BlogWebFragment extends Fragment {
    private static final String ARG_POST_ID = "post_id";

    static View mView;
    private static Uri mUri;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_blog_web, container, false);

        Intent intent = getActivity().getIntent();
        Uri blogUri = intent.getData();
        WebView webView = (WebView) mView.findViewById(R.id.webView);
        if(blogUri!= null) {
            webView.loadUrl(blogUri.toString());
        }else{
            webView.loadUrl(mUri.toString());
        }

        return mView;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public static BlogWebFragment newInstance(String postUrl){
        mUri = Uri.parse(postUrl);
        Bundle args = new Bundle();
        args.putSerializable(ARG_POST_ID, postUrl);

        BlogWebFragment fragment = new BlogWebFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
