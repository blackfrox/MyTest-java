package com.example.mygame.zhihudaily.comment;

import com.example.mygame.bean.Comment;

import java.util.List;

/**
 * Created by Admin on 2017/6/24.
 */

public interface CommentContract {

    interface View {
        void refreshRecyclerView(List<Comment.CommentsBean> list);
     }

    interface Presenter{
        void getComment(int id);
    }

    interface Model{
        void getComment(CallbackComment callback,int id);
    }
}
