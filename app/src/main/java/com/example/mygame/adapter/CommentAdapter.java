package com.example.mygame.adapter;

import android.content.Context;
import android.sax.TextElementListener;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.mygame.R;
import com.example.mygame.bean.Comment;
import com.example.mygame.zhihudaily.comment.CommentContract;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

/**
 * Created by Admin on 2017/6/24.
 */

public class CommentAdapter extends RecyclerView.Adapter<CommentAdapter.ViewHolder> {
    private Context context;
    private List<Comment.CommentsBean> commentList;

    public CommentAdapter(List<Comment.CommentsBean> commentList) {
        this.commentList = commentList;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView commentImage;
        TextView commentName;
        TextView commentContent;
        TextView likeNumber;

        public ViewHolder(View itemView) {
            super(itemView);
            commentImage=itemView.findViewById(R.id.comment_image);
            commentName= itemView.findViewById(R.id.comment_name);
            commentContent=itemView.findViewById(R.id.comment_content);
            likeNumber=itemView.findViewById(R.id.like_number);
        }
    } @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context=parent.getContext();
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.comment_item,parent,false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
          Comment.CommentsBean comment=commentList.get(position);
        holder.commentName.setText(comment.getAuthor()+"");
        holder.commentContent.setText(comment.getContent()+"");
        holder.likeNumber.setText(comment.getLikes());
        Glide.with(context).load(comment.getAvatar()).into(holder.commentImage);
    }

    @Override
    public int getItemCount() {
        return commentList.size();
    }


}
