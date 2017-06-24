package com.example.mygame.zhihudaily.content;

import com.example.mygame.bean.News;
import com.example.mygame.bean.StoryExtra;

import java.net.IDN;

import retrofit2.http.Path;

/**
 * Created by Admin on 2017/6/23.
 */

public class ContentPresenter implements ContentContract.Presenter {
    private ContentContract.View view;
    private ContentContract.Model model;

    public ContentPresenter(ContentContract.View view) {
        this.view = view;
        model=new ContentModel();
    }

    @Override
    public void getNews(int id) {
        model.getNews(new CallBackNewsContent() {
            @Override
            public void result(News news) {
                view.setContent(news.getBody());
                view.setTitleImage(news.getImage());
                view.setTitle(news.getTitle());
            }
        },id);
    }

    @Override
    public void getCommentNum(int id) {
          model.getCommentNum(new CallBackComment() {
              @Override
              public void getNewsExtra(StoryExtra storyExtra) {
                  if (storyExtra.getLong_comments()!=0){
                      view.setFabVisible();
                  }
              }
          },id);
    }
}
