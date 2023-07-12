package cn.damai.commonbusiness.coupondialog.net;

import java.io.Serializable;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes14.dex */
public class CouponListResponse implements Serializable {
    public List<Model> model;
    public String success;

    /* compiled from: Taobao */
    /* loaded from: classes14.dex */
    public static class ContentList implements Serializable {
        public String appButtonAction;
        public String buttonName;
        public String cityName;
        public String desText;
        public String eventTrack;
        public String footer;
        public String header;
        public String id;
        public String itemId;
        public List<Coupon> itemList;
        public String itemName;
        public String itemScore;
        public String performTime;
        public String projectDatetime;
        public String projectPic;
        public String targetId;
        public String title;
        public String venuesName;
    }

    /* compiled from: Taobao */
    /* loaded from: classes14.dex */
    public static class Coupon implements Serializable {
        public String amount;
        public String condition;
        public String couponId;
        public String endTime;
        public String eventTrack;
        public String name;
        public long startShowTimeMillis;
        public String startTime;
    }

    /* compiled from: Taobao */
    /* loaded from: classes14.dex */
    public static class Model implements Serializable {
        public List<ContentList> contentList;
        public String type;
    }
}
