package com.alibaba.pictures.bricks.bean;

import android.text.TextUtils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import java.util.ArrayList;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class ContentDetailItem implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    public ArrayList<ContentText> content;
    public String contentId;
    public CoverImage coverImg;
    public boolean focus;
    public int focusCount = 0;
    public FromInfo fromInfo;
    public ArrayList<ContentBanner> image;
    public String isFeature;
    public PraiseInfo praiseInfo;
    public String publishTimeStr;
    public String relateTitle;
    public RichText richContent;
    public String sourceId;
    public String sourceType;
    public int subType;
    public String targetId;
    public String title;
    public ContentUserInfo userInfo;
    public VideoInfo videoInfo;

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public static class ContentBanner implements Serializable {
        public boolean isPlayIcon;
        public String url;
        public VideoInfo videoInfo;
    }

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public static class ContentText {
        public String isRequired;
        public String textId;
        public String value;
    }

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public static class ContentUserInfo implements Serializable {
        public String bid;
        public String btype;
        public boolean focus;
        public String havanaIdStr;
        public String headImg;
        public String nickname;
        public PerformFilmVipDO performFilmVipDO;
        public String targetType;
        public int userTypeCode;
        public String userTypeText;
        public boolean vip;
    }

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public static class CoverImage implements Serializable {
        public int height;
        public String url;
        public int width;
    }

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public static class FromInfo implements Serializable {
        public String headImg;
        public String id;
        public String nickname;
        public String sourceLabel;
    }

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public static class PraiseInfo implements Serializable {
        public boolean hasPraised;
        public int praiseCount;
        public String sourceId;
        public String sourceType;
    }

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public static class RichText implements Serializable {
        public String textId;
        public String value;
    }

    public boolean isFeature() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "478976683") ? ((Boolean) ipChange.ipc$dispatch("478976683", new Object[]{this})).booleanValue() : TextUtils.equals("1", this.isFeature);
    }
}
