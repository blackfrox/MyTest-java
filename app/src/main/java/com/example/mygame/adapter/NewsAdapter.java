package com.example.mygame.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.mygame.R;
import com.example.mygame.bean.LatestNews;

import java.util.List;

import retrofit2.http.PATCH;

/**
 * Created by Admin on 2017/6/23.
 */

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder>{

    private Context context;
    private List<LatestNews.StoriesBean> storiedList;
    public static final String NEWS_ID="news_id";

    public class ViewHolder extends RecyclerView.ViewHolder {
        LinearLayout mLinearLayout;
        ImageView newsImage;
        TextView newsTitle;

        public ViewHolder(View itemView) {
            super(itemView);
            mLinearLayout=itemView.findViewById(R.id.item_layout);
            newsImage=itemView.findViewById(R.id.latest_news_image);
            newsTitle=itemView.findViewById(R.id.latest_news_title);
        }
    }

    public NewsAdapter(List<LatestNews.StoriesBean> storiedList) {
        this.storiedList = storiedList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (context==null){
            context= parent.getContext();
        }
        View view= LayoutInflater.from(context).inflate(R.layout.zhihudaily_news_item,parent,false);
        final ViewHolder viewHolder=new ViewHolder(view);
        viewHolder.mLinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position=viewHolder.getAdapterPosition();
                LatestNews.StoriesBean storiesBean=storiedList.get(position);
                int id=storiesBean.getId();
//                Intent intent=new Intent(context,ContentActivity.class);
//                intent.putExtra(NEWS_ID,id);
//                context.startActivity(intent);
            }
        });
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        LatestNews.StoriesBean storiesBean=storiedList.get(position);
        holder.newsTitle.setText(storiesBean.getTitle());
        Glide.with(context).load(storiesBean.getImages().get(0)).into(holder.newsImage);
    }

    @Override
    public int getItemCount() {
        return storiedList.size();
    }


}
