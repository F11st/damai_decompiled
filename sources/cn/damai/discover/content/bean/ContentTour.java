package cn.damai.discover.content.bean;

import cn.damai.commonbusiness.search.bean.ProjectItemBean;
import java.io.Serializable;
import java.util.ArrayList;

/* compiled from: Taobao */
/* loaded from: classes14.dex */
public class ContentTour implements Serializable {
    public String focus;
    public ProjectItemBean itemInfo;
    public ArrayList<ContentRelatedTourListItem> relateItem;
    @Deprecated
    public ContentTopic themeInfo;

    /* compiled from: Taobao */
    /* loaded from: classes14.dex */
    public static class ContentRelatedTourListItem implements Serializable {
        public String cityId;
        public String cityName;
        public String itemId;
        public String schema;
        public String showTime;
        public String targetId;
        public String targetType;
    }

    /* compiled from: Taobao */
    /* loaded from: classes14.dex */
    public static class ContentTopic implements Serializable {
        public String id;
        public String name;
    }
}
