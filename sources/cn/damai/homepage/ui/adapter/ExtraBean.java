package cn.damai.homepage.ui.adapter;

import java.io.Serializable;

/* compiled from: Taobao */
/* loaded from: classes14.dex */
public class ExtraBean implements Serializable {
    public static final String EXTRA_KEY = "EXTRA_KEY";
    public int pageNum;
    public int pos;

    public ExtraBean(int i, int i2) {
        this.pageNum = i;
        this.pos = i2;
    }

    public ExtraBean() {
    }
}
