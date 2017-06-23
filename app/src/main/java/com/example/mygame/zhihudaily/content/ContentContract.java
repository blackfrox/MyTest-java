package com.example.mygame.zhihudaily.content;

/**
 * Created by Admin on 2017/6/23.
 */

public interface ContentContract {

    interface View{
        void setTitleImage(String url);
        void setContent(String text);
        void setTitle(String title);
        void setFabVisible();
    }

    interface Presenter{
        void getNews(int id);
        void getCommentNum(int id);
    }

    interface Model{
        void getNews(CallBackNewsContent callback,int id);
        void getCommentNum(CallBackComment callback,int id);
    }
}
