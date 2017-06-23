package com.example.mygame.api;

import android.graphics.Bitmap;
import android.support.v4.view.ActionProvider;
import android.support.v7.widget.RecyclerView;
import android.widget.SimpleCursorTreeAdapter;

import com.example.mygame.bean.Comment;
import com.example.mygame.bean.LatestNews;
import com.example.mygame.bean.News;
import com.example.mygame.bean.Schedule;
import com.example.mygame.bean.StoryExtra;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Admin on 2017/6/22.
 *  public interface ZhiHuService {
@GET("api/4/news/latest")
Observable<LatestNews> getLatestNews();

@GET("api/4/news/before/{date}")
Observable<LatestNews> getBeforeNews(@Path("date") String dateString);

@GET("api/4/news/{id}")
Observable<News> getNews(@Path("id") int id);

@GET("api/4/story/{id}/long-comments")
Observable<Comment> getComments(@Path("id") int id);

@GET("api/4/story-extra/{id}")
Observable<StoryExtra> getStroyExtra(@Path("id") int id);
}
 */

public class ZhihuApi {
    private ZhiHuService zhihuService;
    private static ZhihuApi zhihuApi;
    private Retrofit retrofit;

    private ZhihuApi(){
        OkHttpClient.Builder httpclientuilder=new OkHttpClient.Builder();
        Retrofit retrofit=new Retrofit.Builder()
                .client(httpclientuilder.build())
                .baseUrl(Config.ZHIHU_URL)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        zhihuService=retrofit.create(ZhiHuService.class);
    }

    public static ZhihuApi getInstance(){
        if (zhihuApi==null) {
            synchronized (ZhihuApi.class){
                if (zhihuApi==null){
                    zhihuApi=new ZhihuApi();
                }
            }
        }
        return zhihuApi;
    }
    public void getLatestNews(Subscriber<LatestNews> subscriber){
        zhihuService.getLatestNews()
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    public void getBeforeNews(Subscriber<LatestNews> subscriber,String date){
        zhihuService.getBeforeNews(date)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    public void getNews(Subscriber<News> subscriber,int id){
        zhihuService.getNews(id)
                .subscribeOn(Schedulers.io())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    public void getStoryExtra(Subscriber<StoryExtra> subscriber,int id){
        zhihuService.getStroyExtra(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    public void getComment(Subscriber<Comment> subscriber,int id){
        zhihuService.getComments(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }
}
