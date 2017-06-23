package com.example.mygame.zhihudaily.news;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mygame.R;
import com.example.mygame.adapter.NewsAdapter;
import com.example.mygame.bean.LatestNews;
import com.example.mygame.zhihudaily.news.NewsContract;
import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;

import java.util.Calendar;
import java.util.List;

/**
 * Created by Admin on 2017/6/23.
 */

public class NewsFragment  extends Fragment implements NewsContract.View, DatePickerDialog.OnDateSetListener {
    private RecyclerView recyclerView;
    private NewsContract.Presenter presenter;

    public NewsFragment(){
        //传入的参数是view类型
        presenter=new NewsPresenter(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_zhihudaily_news,container,false);
        FloatingActionButton fab=view.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar now=Calendar.getInstance();
                DatePickerDialog dpd=DatePickerDialog.newInstance(
                        NewsFragment.this,
                        now.get(Calendar.YEAR),
                        now.get(Calendar.MONTH),
                        now.get(Calendar.DAY_OF_MONTH)
                );
                dpd.show(getActivity().getFragmentManager(),"Datepickerdialog");
            }
        });
        recyclerView=view.findViewById(R.id.latest_news_recyclerView);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);
        presenter.getLatestNews();
        return view;
    }

    @Override
    public void refreshRecyclerView(List<LatestNews.StoriesBean> storiesList) {
        NewsAdapter adapter=new NewsAdapter(storiesList);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onDateSet(DatePickerDialog view, int year, int monthOfYear, int dayOfMonth) {
        String date=String.format("%d%02d%02d",year,monthOfYear+1,dayOfMonth);
        presenter.getBeforeNews(date);
    }
}
