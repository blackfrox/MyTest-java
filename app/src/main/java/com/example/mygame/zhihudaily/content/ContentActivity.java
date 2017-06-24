package com.example.mygame.zhihudaily.content;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.mygame.R;
import com.example.mygame.adapter.NewsAdapter;
import com.example.mygame.util.HtmlFormat;
import com.example.mygame.zhihudaily.comment.CommentActivity;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ContentActivity extends AppCompatActivity implements ContentContract.View {

    @Bind(R.id.news_image)
    ImageView mNewsImage;
    @Bind(R.id.toolbar_layout)
    CollapsingToolbarLayout mToolbarLayout;
    @Bind(R.id.news_content)
    WebView newsContent;

    private int id;

   private FloatingActionButton fab;
    private ContentContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);
        ButterKnife.bind(this);
        Toolbar toolbar= (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        presenter=new ContentPresenter(this);

        final Intent intent=getIntent();
        id=intent.getIntExtra(NewsAdapter.NEWS_ID,0);

        fab= (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1=new Intent(ContentActivity.this,CommentActivity.class);
                intent.putExtra("newsId",id);
                startActivity(intent1);
            }
        });
        fab.setVisibility(View.INVISIBLE);
        //通过此方法来判断是否显示id，如果id=0就不会调用让fab显示的方法
        presenter.getCommentNum(id);
        presenter.getNews(id);
    }

    @Override
    public void setTitleImage(String url) {
        Glide.with(this).load(url).into(mNewsImage);
    }

    @Override
    public void setContent(String text) {
         newsContent.loadDataWithBaseURL(null,HtmlFormat.getNewContent(text),"text/html","utf-8",null);
        newsContent.getSettings().setJavaScriptEnabled(true);
        WebSettings settings=newsContent.getSettings();

        newsContent.setWebChromeClient(new WebChromeClient());
    }

    @Override
    public void setTitle(String title) {
       mToolbarLayout.setTitle(title);
    }

    @Override
    public void setFabVisible() {
       fab.setVisibility(View.VISIBLE);
    }
}
