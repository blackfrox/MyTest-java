package com.example.mygame.zhihudaily.comment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.mygame.R;
import com.example.mygame.adapter.CommentAdapter;
import com.example.mygame.bean.Comment;

import java.util.List;

public class CommentActivity extends AppCompatActivity implements CommentContract.View{
     private RecyclerView recyclerView;
    private CommentContract.Presenter presenter;
  private int id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment);

        Intent intent=getIntent();
        id=intent.getIntExtra("newsId",0);

        recyclerView= (RecyclerView) findViewById(R.id.cmment_recyclerview);
        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        presenter=new CommentPresenter(this);
        presenter.getComment(id);
    }

    @Override
    public void refreshRecyclerView(List<Comment.CommentsBean> list) {
        CommentAdapter adapter=new CommentAdapter(list);
        recyclerView.setAdapter(adapter);
    }
}
