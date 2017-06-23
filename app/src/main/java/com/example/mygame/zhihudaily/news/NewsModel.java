package com.example.mygame.zhihudaily.news;

import com.example.mygame.api.ZhihuApi;
import com.example.mygame.bean.LatestNews;

import rx.Subscriber;

/**
 * Created by Admin on 2017/6/23.
 */

public class NewsModel implements NewsContract.Model {
    @Override
    public void getBeforeNews(final CakkbackLatestNews callback, String date) {
        Subscriber subscriber= new Subscriber<LatestNews>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(LatestNews latestNews) {
                   callback.result(latestNews.getStories());
            }
        };
        ZhihuApi.getInstance().getBeforeNews(subscriber,date);
    }

    @Override
    public void getLatestNews(final CakkbackLatestNews callback) {
       Subscriber subscriber= new Subscriber<LatestNews>() {
           @Override
           public void onCompleted() {

           }

           @Override
           public void onError(Throwable e) {

           }

           @Override
           public void onNext(LatestNews latestNews) {
              callback.result(latestNews.getStories());
           }
       };
        ZhihuApi.getInstance().getLatestNews(subscriber);
    }
}
