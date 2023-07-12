package cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public class TagBean {
    public static int TYPE_IMAGE = 2;
    public static int TYPE_TEXT = 1;
    public int ids;
    public int picHeight;
    public int picWidth;
    public String text;
    public int type;

    public TagBean(int i, String str) {
        this.type = i;
        this.text = str;
    }

    public TagBean(int i, int i2, int i3, int i4) {
        this.type = i;
        this.ids = i2;
        this.picWidth = i3;
        this.picHeight = i4;
    }
}
