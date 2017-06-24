package com.example.mygame.zhihudaily.comment;

import com.example.mygame.bean.Comment;

/**
 * Created by Admin on 2017/6/24.
 */

public class CommentPresenter implements CommentContract.Presenter {
    private CommentContract.View view;
    private CommentContract.Model model;

    public CommentPresenter(CommentContract.View view) {
        this.view = view;
        model=new CommentModel();
    }

    @Override
    public void getComment(int id) {
        model.getComment(new CallbackComment() {
            @Override
            public void getComment(Comment comment) {
                view.refreshRecyclerView(comment.getComments());
            }
         },id);
    }
}
