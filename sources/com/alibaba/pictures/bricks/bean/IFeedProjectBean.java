package com.alibaba.pictures.bricks.bean;

import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public interface IFeedProjectBean<T> {
    String getAtmospheric();

    int getLiveStatus();

    String getPostPic();

    String getProjectDate();

    String getProjectName();

    String getRankText();

    T getRaw();

    double getScoreStar();

    String getShowPrice();

    List<TagBean> getTagList();

    boolean isPendingPrice();

    boolean isShowVideoIcon();

    boolean isShowWannaSeeTag();
}
