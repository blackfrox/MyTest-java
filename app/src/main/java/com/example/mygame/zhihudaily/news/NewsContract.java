package com.example.mygame.zhihudaily.news;

import com.example.mygame.bean.LatestNews;

import java.util.List;

/**
 * Created by Admin on 2017/6/23.
 */

public interface NewsContract {

    interface View{
        void refreshRecyclerView(List<LatestNews.StoriesBean> storiesList);
    }

    interface  Presenter{
        void getBeforeNews(String date);
        void getLatestNews();
    }
    interface Model {
        void getBeforeNews(CakkbackLatestNews callback,String date);
        void getLatestNews(CakkbackLatestNews callback);
    }
}
