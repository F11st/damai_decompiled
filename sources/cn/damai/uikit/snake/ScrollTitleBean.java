package cn.damai.uikit.snake;

import java.io.Serializable;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class ScrollTitleBean implements Serializable {
    private static final long serialVersionUID = 8499530670854957651L;
    public String id;
    public int index;
    public String name;
    public String picJson;
    public String picUrl;

    public ScrollTitleBean() {
    }

    public ScrollTitleBean(String str, String str2, int i) {
        this.id = str;
        this.name = str2;
        this.index = i;
    }

    public ScrollTitleBean(String str, String str2, int i, String str3, String str4) {
        this.id = str;
        this.name = str2;
        this.index = i;
        this.picUrl = str3;
        this.picJson = str4;
    }
}
