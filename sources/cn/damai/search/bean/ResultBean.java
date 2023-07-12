package cn.damai.search.bean;

import java.io.Serializable;

/* compiled from: Taobao */
/* loaded from: classes15.dex */
public class ResultBean implements Serializable {
    public static final String TYPE_EVALUATE = "3";
    public static final String TYPE_JUMU = "2";
    public static final String TYPE_PROJECT = "1";
    public final String desc;
    public final String id;
    public final String imageUrl;
    public final String name;
    public final String type;

    public ResultBean(String str, String str2, String str3, String str4, String str5) {
        this.id = str;
        this.name = str2;
        this.imageUrl = str3;
        this.desc = str4;
        this.type = str5;
    }
}
