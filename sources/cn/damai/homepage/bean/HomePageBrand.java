package cn.damai.homepage.bean;

import java.io.Serializable;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes14.dex */
public class HomePageBrand implements Serializable {
    public List<BrandItem> content;
    public String mainTitle;
    public String moreText;

    /* compiled from: Taobao */
    /* loaded from: classes14.dex */
    public static class BrandItem {
        public String backgroundPic;
        public String brandId;
        public String labelName;
        public String name;
        public List<BrandItemProject> projectVos;

        /* compiled from: Taobao */
        /* loaded from: classes14.dex */
        public static class BrandItemProject {
            public String cityName;
            public int position;
            public String priceLow;
            public String projectId;
            public String projectName;
            public String projectPic;
            public String schema;
        }
    }
}
