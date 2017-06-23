package com.example.mygame.zhihudaily.content;

import com.example.mygame.api.ZhiHuService;
import com.example.mygame.api.ZhihuApi;
import com.example.mygame.bean.News;
import com.example.mygame.bean.StoryExtra;

import java.util.Calendar;

import rx.Subscriber;

/**
 * Created by Admin on 2017/6/23.
 */

public class ContentModel implements ContentContract.Model {
    @Override
    public void getNews(final CallBackNewsContent callback, int id) {
        Subscriber subscriber=new Subscriber<News>(){

            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(News news) {
                callback.result(news);
            }
        };
        ZhihuApi.getInstance().getNews(subscriber,id);
    }

    @Override
    public void getCommentNum(final CallBackComment callback, int id) {
       Subscriber subscriber= new Subscriber<StoryExtra>() {
           @Override
           public void onCompleted() {

           }

           @Override
           public void onError(Throwable e) {

           }

           @Override
           public void onNext(StoryExtra storyExtra) {
              callback.getNewsExtra(storyExtra);
           }
       };
        ZhihuApi.getInstance().getStoryExtra(subscriber,id);
    }
}
