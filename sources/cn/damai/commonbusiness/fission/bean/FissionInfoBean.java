package cn.damai.commonbusiness.fission.bean;

import cn.damai.commonbusiness.yymember.bean.PerformFilmVipDO;
import java.io.Serializable;

/* compiled from: Taobao */
/* loaded from: classes14.dex */
public class FissionInfoBean implements Serializable {
    private static final long serialVersionUID = 1;
    public ActivityInfo shareInfo;
    public UserInfo userInfo;

    /* compiled from: Taobao */
    /* loaded from: classes14.dex */
    public static class ActivityInfo implements Serializable {
        private static final long serialVersionUID = 1;
        public String bgImageUrl;
        public String chickenSoup;
        public String detailLinkUrl;
        public String mainTitle;
        public String ruleUrl;
        public String seatInfo;
        public String shareType;
        public String shareUrl;
        public String subTitleHighlight;
        public String subTitlePrefix;
        public String subTitleSuffix;
        public String venue;
    }

    /* compiled from: Taobao */
    /* loaded from: classes14.dex */
    public static class UserInfo implements Serializable {
        private static final long serialVersionUID = 1;
        public String nickname;
        public PerformFilmVipDO performFilmVipDO;
        public String portraitUrl;
        public String shareCode;
    }
}
