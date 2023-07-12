package cn.damai.commonbusiness.share.bean;

import java.util.ArrayList;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class ShareParams {
    public ArrayList<Plugin> plugins;
    public Share share;

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public static class EditImgJson {
        public int type;
        public String url;
    }

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public static class Plugin {
        public String type;
        public TypeInfo typeInfo;
        public String typeName;
    }

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public static class Share {
        public String description;
        public String fromWhere;
        public String image;
        public String title;
        public String url;
    }

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public static class TypeInfo {
        public String circleId;
        public String circleName;
        public String commentId;
        public String content;
        public int currentScore;
        public ArrayList<EditImgJson> editImgJson;
        public long evaluateTime;
        public String generateImageType;
        public String id;
        public String imageUrl;
        public String projectName;
        public String publisherType;
        public String title;
        public int type;
        public String url;
        public String userIcon;
        public String userNick;
    }
}
