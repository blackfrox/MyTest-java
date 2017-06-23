package com.example.mygame.zhihudaily.content;

import com.example.mygame.bean.News;
import com.example.mygame.bean.StoryExtra;

/**
 * Created by Admin on 2017/6/23.
 */

public interface CallBackNewsContent {
    public void result(News news);
}
interface CallBackComment{
    public void getNewsExtra(StoryExtra storyExtra);
}
