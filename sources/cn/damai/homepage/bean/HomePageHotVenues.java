package cn.damai.homepage.bean;

import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes14.dex */
public class HomePageHotVenues {
    public String id;
    public String mainTitle;
    public String moreText;
    public List<VenuesVoList> venuesVoList;

    /* compiled from: Taobao */
    /* loaded from: classes14.dex */
    public static class VenuesVoList {
        public String address;
        public String distance;
        public String id;
        public String itemOnSaleSize;
        public String name;
        public int position;
        public List<ProjectVos> projectVos;

        /* compiled from: Taobao */
        /* loaded from: classes14.dex */
        public static class ProjectVos {
            public int cardPosition;
            public String categoryName;
            public int itemPosition;
            public String priceLow;
            public String projectId;
            public String projectName;
            public String projectPic;
            public String schema;
            public String scm;
        }
    }
}
