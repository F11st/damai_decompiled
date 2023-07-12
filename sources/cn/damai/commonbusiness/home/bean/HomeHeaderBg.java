package cn.damai.commonbusiness.home.bean;

import java.io.Serializable;

/* compiled from: Taobao */
/* loaded from: classes14.dex */
public class HomeHeaderBg implements Serializable {
    private static final long serialVersionUID = 230801076599399280L;
    @Deprecated
    public String categoryId;
    public String headBackgroudPic;
    public String headColor;
    public HeadLottieBean headLottie;
    public int type;
    public String weiyiId;

    public HomeHeaderBg() {
    }

    public HomeHeaderBg(String str, int i, String str2, String str3) {
        this.categoryId = str;
        this.type = i;
        this.headBackgroudPic = str2;
        this.headColor = str3;
    }

    public HomeHeaderBg(HomeTabBean homeTabBean, String str, String str2) {
        if (homeTabBean != null) {
            this.categoryId = homeTabBean.categoryId;
            this.type = homeTabBean.type;
        }
        this.headBackgroudPic = str;
        this.headColor = str2;
    }
}
