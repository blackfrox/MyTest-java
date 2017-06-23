package com.example.mygame.zhihudaily.content;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.mygame.R;

public class ContentActivity extends AppCompatActivity implements ContentContract.View {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);
    }

    @Override
    public void setTitleImage(String url) {

    }

    @Override
    public void setContent(String text) {

    }

    @Override
    public void setTitle(String title) {

    }

    @Override
    public void setFabVisible() {

    }
}
