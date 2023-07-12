package cn.damai.commonbusiness.fission.bean;

import android.graphics.Bitmap;
import cn.damai.commonbusiness.fission.bean.FissionInfoBean;
import java.io.Serializable;

/* compiled from: Taobao */
/* loaded from: classes14.dex */
public class FissionViewPagerBean implements Serializable {
    public static final String MAIDAN_DETAIL = "2";
    public static final String ORDER_DETAIL = "3";
    public static final String PROJECT_DETAIL = "1";
    private static final long serialVersionUID = 1;
    public int bgColor;
    public Bitmap bitmap;
    public String channel;
    public String chickenSoup;
    public String imageUrl;
    public String mainMessage;
    public String subMessage;
    public FissionInfoBean.UserInfo userInfo;
}
