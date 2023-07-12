package cn.damai.search.bean;

import java.io.Serializable;
import java.util.ArrayList;

/* compiled from: Taobao */
/* loaded from: classes15.dex */
public class SearchPrivilegeRecommendBean implements Serializable {
    private static final long serialVersionUID = 1;
    public ArrayList<CommentProjectRecommendResult> evaluatedList;
    public ArrayList<CommentProjectRecommendResult> themeList;

    /* compiled from: Taobao */
    /* loaded from: classes15.dex */
    public static class CommentProjectRecommendResult implements Serializable {
        private static final long serialVersionUID = 1;
        public long beginTime;
        public String cityId;
        public String cityName;
        public String commentUrl;
        public String itemId;
        public Integer itemType;
        public String performEndDate;
        public String performStartDate;
        public String performTimeSpanDesc;
        public Long playerCount;
        public String postUrl;
        public String priceDesc;
        public String projectId;
        public String projectName;
        public String projectType;
        public Long storeId;
        public String targetId;
        public String themeId;
        public String venueName;
    }
}
