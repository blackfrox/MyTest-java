package com.example.mygame.zhihudaily.news;

import com.example.mygame.bean.LatestNews;

import java.util.List;

/**
 * Created by Admin on 2017/6/23.
 */

public class NewsPresenter implements NewsContract.Presenter {
    private NewsContract.View view;
    private NewsContract.Model model;

    public NewsPresenter(NewsContract.View view) {
        this.view = view;
        model=new NewsModel();
    }

    @Override
    public void getBeforeNews(String date) {
       model.getBeforeNews(new CakkbackLatestNews() {
           @Override
           public void result(List<LatestNews.StoriesBean> list) {
               view.refreshRecyclerView(list);
           }
       },date);
    }

    @Override
    public void getLatestNews() {
        model.getLatestNews(new CakkbackLatestNews() {
            @Override
            public void result(List<LatestNews.StoriesBean> list) {
                view.refreshRecyclerView(list);
            }
        });
    }
}
