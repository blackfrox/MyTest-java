package com.example.mygame.zhihudaily.comment;

import com.example.mygame.api.ZhihuApi;
import com.example.mygame.bean.Comment;

import rx.Subscriber;

/**
 * Created by Admin on 2017/6/24.
 */

public class CommentModel implements CommentContract.Model {
    @Override
    public void getComment(final CallbackComment callback, int id) {
        Subscriber subscriber= new Subscriber<Comment>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(Comment comment) {
                callback.getComment(comment);
            }
        };
        ZhihuApi.getInstance().getComment(subscriber,id);
    }
}
