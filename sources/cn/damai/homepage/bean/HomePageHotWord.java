package cn.damai.homepage.bean;

import java.io.Serializable;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes14.dex */
public class HomePageHotWord implements Serializable {
    private static final long serialVersionUID = -1911052457846969114L;
    public List<HotWords> hotWords;
    public SearchTip searchTip;
    public String top;

    /* compiled from: Taobao */
    /* loaded from: classes14.dex */
    public static class HotWords {
        public int action;
        public String alg;
        public String keyword;
        public int position;
        public String reason;
        public String url;
    }

    /* compiled from: Taobao */
    /* loaded from: classes14.dex */
    public static class SearchTip {
        public String alg;
        public String keyword;
    }
}
